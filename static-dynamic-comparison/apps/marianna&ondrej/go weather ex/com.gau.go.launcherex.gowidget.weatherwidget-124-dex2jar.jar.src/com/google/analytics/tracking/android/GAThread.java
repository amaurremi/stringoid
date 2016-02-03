package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class GAThread
  extends Thread
  implements AnalyticsThread
{
  static final String API_VERSION = "1";
  private static final String CLIENT_VERSION = "ma1b3";
  private static final int MAX_SAMPLE_RATE = 100;
  private static final int SAMPLE_RATE_MODULO = 10000;
  private static final int SAMPLE_RATE_MULTIPLIER = 100;
  private static GAThread instance;
  private volatile boolean appOptOut;
  private volatile String clientId;
  private volatile boolean closed = false;
  private volatile List<Command> commands;
  private final Context ctx;
  private volatile boolean disabled = false;
  private volatile String installCampaign;
  private volatile MetaModel metaModel;
  private final ServiceProxy proxy;
  private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue();
  
  private GAThread(Context paramContext)
  {
    super("GAThread");
    this.ctx = paramContext;
    this.proxy = new GAServiceProxy(paramContext, this);
    init();
  }
  
  GAThread(Context paramContext, ServiceProxy paramServiceProxy)
  {
    super("GAThread");
    this.ctx = paramContext;
    this.proxy = paramServiceProxy;
    init();
  }
  
  private void fillAppParameters(Map<String, String> paramMap)
  {
    PackageManager localPackageManager = this.ctx.getPackageManager();
    String str3 = this.ctx.getPackageName();
    String str4 = localPackageManager.getInstallerPackageName(str3);
    String str2 = str3;
    localObject2 = null;
    str1 = str2;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.ctx.getPackageName(), 0);
      str1 = str2;
      localObject1 = localObject2;
      if (localPackageInfo != null)
      {
        str1 = str2;
        str2 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        str1 = str2;
        localObject1 = localPackageInfo.versionName;
        str1 = str2;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.e("Error retrieving package info: appName set to " + str1);
        Object localObject1 = localObject2;
      }
    }
    putIfAbsent(paramMap, "appName", str1);
    putIfAbsent(paramMap, "appVersion", (String)localObject1);
    putIfAbsent(paramMap, "appId", str3);
    putIfAbsent(paramMap, "appInstallerId", str4);
    paramMap.put("apiVersion", "1");
  }
  
  private void fillCampaignParameters(Map<String, String> paramMap)
  {
    Object localObject = Utils.filterCampaign((String)paramMap.get("campaign"));
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = Utils.parseURLParameters((String)localObject);
    paramMap.put("campaignContent", ((Map)localObject).get("utm_content"));
    paramMap.put("campaignMedium", ((Map)localObject).get("utm_medium"));
    paramMap.put("campaignName", ((Map)localObject).get("utm_campaign"));
    paramMap.put("campaignSource", ((Map)localObject).get("utm_source"));
    paramMap.put("campaignKeyword", ((Map)localObject).get("utm_term"));
    paramMap.put("campaignId", ((Map)localObject).get("utm_id"));
    paramMap.put("gclid", ((Map)localObject).get("gclid"));
    paramMap.put("dclid", ((Map)localObject).get("dclid"));
    paramMap.put("gmob_t", ((Map)localObject).get("gmob_t"));
  }
  
  private void fillExceptionParameters(Map<String, String> paramMap)
  {
    Object localObject1 = (String)paramMap.get("rawException");
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      paramMap.remove("rawException");
      localObject1 = new ByteArrayInputStream(Utils.hexDecode((String)localObject1));
      try
      {
        localObject1 = new ObjectInputStream((InputStream)localObject1);
        Object localObject2 = ((ObjectInputStream)localObject1).readObject();
        ((ObjectInputStream)localObject1).close();
        if ((localObject2 instanceof Throwable))
        {
          localObject1 = (Throwable)localObject2;
          localObject2 = new ArrayList();
          paramMap.put("exDescription", new StandardExceptionParser(this.ctx, (Collection)localObject2).getDescription((String)paramMap.get("exceptionThreadName"), (Throwable)localObject1));
          return;
        }
      }
      catch (IOException paramMap)
      {
        Log.w("IOException reading exception");
        return;
      }
      catch (ClassNotFoundException paramMap)
      {
        Log.w("ClassNotFoundException reading exception");
      }
    }
  }
  
  static String getAndClearCampaign(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.openFileInput("gaInstallData");
      byte[] arrayOfByte = new byte[' '];
      int i = ((FileInputStream)localObject).read(arrayOfByte, 0, 8192);
      if (((FileInputStream)localObject).available() > 0)
      {
        Log.e("Too much campaign data, ignoring it.");
        ((FileInputStream)localObject).close();
        paramContext.deleteFile("gaInstallData");
        return null;
      }
      ((FileInputStream)localObject).close();
      paramContext.deleteFile("gaInstallData");
      if (i <= 0)
      {
        Log.w("Campaign file is empty.");
        return null;
      }
      localObject = new String(arrayOfByte, 0, i);
      Log.i("Campaign found: " + (String)localObject);
      return (String)localObject;
    }
    catch (FileNotFoundException paramContext)
    {
      Log.i("No campaign data found.");
      return null;
    }
    catch (IOException localIOException)
    {
      Log.e("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return null;
  }
  
  private String getHostUrl(Map<String, String> paramMap)
  {
    String str2 = (String)paramMap.get("internalHitUrl");
    String str1 = str2;
    if (str2 == null)
    {
      if (Utils.safeParseBoolean((String)paramMap.get("useSecure"))) {
        str1 = "https://ssl.google-analytics.com/collect";
      }
    }
    else {
      return str1;
    }
    return "http://www.google-analytics.com/collect";
  }
  
  static GAThread getInstance(Context paramContext)
  {
    if (instance == null) {
      instance = new GAThread(paramContext);
    }
    return instance;
  }
  
  private void init()
  {
    this.proxy.createService();
    this.commands = new ArrayList();
    this.commands.add(new Command("appendVersion", "_v", "ma1b3"));
    this.commands.add(new Command("appendQueueTime", "qt", null));
    this.commands.add(new Command("appendCacheBuster", "z", null));
    this.metaModel = new MetaModel();
    MetaModelInitializer.set(this.metaModel);
    start();
  }
  
  private boolean isSampledOut(Map<String, String> paramMap)
  {
    if (paramMap.get("sampleRate") != null)
    {
      double d = Utils.safeParseDouble((String)paramMap.get("sampleRate"));
      if (d <= 0.0D) {
        return true;
      }
      if (d < 100.0D)
      {
        paramMap = (String)paramMap.get("clientId");
        if ((paramMap != null) && (Math.abs(paramMap.hashCode()) % 10000 >= 100.0D * d)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean loadAppOptOut()
  {
    return this.ctx.getFileStreamPath("gaOptOut").exists();
  }
  
  private String printStackTrace(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  private void putIfAbsent(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!paramMap.containsKey(paramString1)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private void queueToThread(Runnable paramRunnable)
  {
    this.queue.add(paramRunnable);
  }
  
  private boolean storeClientId(String paramString)
  {
    try
    {
      FileOutputStream localFileOutputStream = this.ctx.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      Log.e("Error creating clientId file.");
      return false;
    }
    catch (IOException paramString)
    {
      Log.e("Error writing to clientId file.");
    }
    return false;
  }
  
  void close()
  {
    this.closed = true;
    interrupt();
  }
  
  public void dispatch()
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        GAThread.this.proxy.dispatch();
      }
    });
  }
  
  String generateClientId()
  {
    String str = Long.toHexString((new SecureRandom().nextLong() & 0x7FFFFFFFFFFFFFFF) % Long.MAX_VALUE + 1L);
    if (!storeClientId(str)) {}
    return str;
  }
  
  public LinkedBlockingQueue<Runnable> getQueue()
  {
    return this.queue;
  }
  
  public Thread getThread()
  {
    return this;
  }
  
  /* Error */
  String initializeClientId()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 69	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   12: ldc_w 484
    //   15: invokevirtual 332	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   18: astore 6
    //   20: sipush 128
    //   23: newarray <illegal type>
    //   25: astore_2
    //   26: aload 6
    //   28: aload_2
    //   29: iconst_0
    //   30: sipush 128
    //   33: invokevirtual 338	java/io/FileInputStream:read	([BII)I
    //   36: istore_1
    //   37: aload 6
    //   39: invokevirtual 342	java/io/FileInputStream:available	()I
    //   42: ifle +26 -> 68
    //   45: ldc_w 538
    //   48: invokestatic 210	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   51: pop
    //   52: aload 6
    //   54: invokevirtual 345	java/io/FileInputStream:close	()V
    //   57: aload_0
    //   58: getfield 69	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   61: ldc_w 328
    //   64: invokevirtual 349	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   67: pop
    //   68: iload_1
    //   69: ifgt +41 -> 110
    //   72: ldc_w 540
    //   75: invokestatic 210	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   78: pop
    //   79: aload 6
    //   81: invokevirtual 345	java/io/FileInputStream:close	()V
    //   84: aload_0
    //   85: getfield 69	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   88: ldc_w 328
    //   91: invokevirtual 349	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   94: pop
    //   95: aload_3
    //   96: astore_2
    //   97: aload_2
    //   98: astore_3
    //   99: aload_2
    //   100: ifnonnull +8 -> 108
    //   103: aload_0
    //   104: invokevirtual 542	com/google/analytics/tracking/android/GAThread:generateClientId	()Ljava/lang/String;
    //   107: astore_3
    //   108: aload_3
    //   109: areturn
    //   110: new 220	java/lang/String
    //   113: dup
    //   114: aload_2
    //   115: iconst_0
    //   116: iload_1
    //   117: invokespecial 354	java/lang/String:<init>	([BII)V
    //   120: astore_2
    //   121: aload 6
    //   123: invokevirtual 345	java/io/FileInputStream:close	()V
    //   126: goto -29 -> 97
    //   129: astore_2
    //   130: aload 4
    //   132: astore_2
    //   133: ldc_w 544
    //   136: invokestatic 210	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   139: pop
    //   140: aload_0
    //   141: getfield 69	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   144: ldc_w 328
    //   147: invokevirtual 349	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   150: pop
    //   151: goto -54 -> 97
    //   154: astore_2
    //   155: aload 5
    //   157: astore_2
    //   158: ldc_w 546
    //   161: invokestatic 210	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   164: pop
    //   165: aload_0
    //   166: getfield 69	com/google/analytics/tracking/android/GAThread:ctx	Landroid/content/Context;
    //   169: ldc_w 328
    //   172: invokevirtual 349	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   175: pop
    //   176: goto -79 -> 97
    //   179: astore_3
    //   180: goto -22 -> 158
    //   183: astore_3
    //   184: goto -51 -> 133
    //   187: astore_2
    //   188: aload_3
    //   189: astore_2
    //   190: goto -93 -> 97
    //   193: astore_3
    //   194: goto -97 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	GAThread
    //   36	81	1	i	int
    //   25	96	2	localObject1	Object
    //   129	1	2	localIOException1	IOException
    //   132	1	2	localObject2	Object
    //   154	1	2	localNumberFormatException1	NumberFormatException
    //   157	1	2	localObject3	Object
    //   187	1	2	localFileNotFoundException1	FileNotFoundException
    //   189	1	2	localIOException2	IOException
    //   7	102	3	localObject4	Object
    //   179	1	3	localNumberFormatException2	NumberFormatException
    //   183	6	3	localIOException3	IOException
    //   193	1	3	localFileNotFoundException2	FileNotFoundException
    //   1	130	4	localObject5	Object
    //   4	152	5	localObject6	Object
    //   18	104	6	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   8	68	129	java/io/IOException
    //   72	95	129	java/io/IOException
    //   110	121	129	java/io/IOException
    //   8	68	154	java/lang/NumberFormatException
    //   72	95	154	java/lang/NumberFormatException
    //   110	121	154	java/lang/NumberFormatException
    //   121	126	179	java/lang/NumberFormatException
    //   121	126	183	java/io/IOException
    //   8	68	187	java/io/FileNotFoundException
    //   72	95	187	java/io/FileNotFoundException
    //   110	121	187	java/io/FileNotFoundException
    //   121	126	193	java/io/FileNotFoundException
  }
  
  boolean isDisabled()
  {
    return this.disabled;
  }
  
  public void requestAppOptOut(final Analytics.AppOptOutCallback paramAppOptOutCallback)
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        paramAppOptOutCallback.reportAppOptOut(GAThread.this.appOptOut);
      }
    });
  }
  
  public void requestClientId(final AnalyticsThread.ClientIdCallback paramClientIdCallback)
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        paramClientIdCallback.reportClientId(GAThread.this.clientId);
      }
    });
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(2000L);
    }
    catch (InterruptedException localInterruptedException2)
    {
      try
      {
        for (;;)
        {
          this.appOptOut = loadAppOptOut();
          this.clientId = initializeClientId();
          this.installCampaign = getAndClearCampaign(this.ctx);
          while (!this.closed) {
            try
            {
              Runnable localRunnable = (Runnable)this.queue.take();
              if (!this.disabled) {
                localRunnable.run();
              }
            }
            catch (InterruptedException localInterruptedException1)
            {
              Log.i(localInterruptedException1.toString());
            }
            catch (Throwable localThrowable1)
            {
              Log.e("Error on GAThread: " + printStackTrace(localThrowable1));
              Log.e("Google Analytics is shutting down.");
              this.disabled = true;
            }
          }
          localInterruptedException2 = localInterruptedException2;
          Log.w("sleep interrupted in GAThread initialize");
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Log.e("Error initializing the GAThread: " + printStackTrace(localThrowable2));
          Log.e("Google Analytics will not start up.");
          this.disabled = true;
        }
      }
    }
  }
  
  public void sendHit(Map<String, String> paramMap)
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        if ((GAThread.this.appOptOut) || (GAThread.this.isSampledOut(this.val$hitCopy))) {
          return;
        }
        this.val$hitCopy.put("clientId", GAThread.this.clientId);
        if (!TextUtils.isEmpty(GAThread.this.installCampaign))
        {
          this.val$hitCopy.put("campaign", GAThread.this.installCampaign);
          GAThread.access$302(GAThread.this, null);
        }
        GAThread.this.fillAppParameters(this.val$hitCopy);
        GAThread.this.fillCampaignParameters(this.val$hitCopy);
        GAThread.this.fillExceptionParameters(this.val$hitCopy);
        Map localMap = HitBuilder.generateHitParams(GAThread.this.metaModel, this.val$hitCopy);
        GAThread.this.proxy.putHit(localMap, this.val$hitTime, GAThread.this.getHostUrl(this.val$hitCopy), GAThread.this.commands);
      }
    });
  }
  
  public void setAppOptOut(final boolean paramBoolean)
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        if (GAThread.this.appOptOut == paramBoolean) {
          return;
        }
        File localFile;
        if (paramBoolean) {
          localFile = GAThread.this.ctx.getFileStreamPath("gaOptOut");
        }
        for (;;)
        {
          try
          {
            localFile.createNewFile();
            GAThread.this.proxy.clearHits();
            GAThread.access$002(GAThread.this, paramBoolean);
            return;
          }
          catch (IOException localIOException)
          {
            Log.w("Error creating optOut file.");
            continue;
          }
          GAThread.this.ctx.deleteFile("gaOptOut");
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/GAThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */