package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class FlurryAgent
  implements LocationListener
{
  private static long aA = 10000L;
  private static boolean aB = true;
  private static boolean aC = false;
  private static boolean aD = false;
  private static boolean aE = true;
  private static Criteria aF = null;
  private static AtomicInteger aH = new AtomicInteger(0);
  private static AtomicInteger aI = new AtomicInteger(0);
  private static final String[] av = { "9774d56d682e549c", "dead00beef" };
  private static volatile String aw = null;
  private static volatile String ax = "http://data.flurry.com/aap.do";
  private static volatile String ay = "https://data.flurry.com/aap.do";
  static FlurryAgent az = new FlurryAgent();
  FlurryAds Q = FlurryAds.getInstance();
  private final Handler aG;
  private File aJ;
  private File aK = null;
  private File aL = null;
  private volatile boolean aM = false;
  private volatile boolean aN = false;
  private long aO;
  private Map<Context, Context> aP = new WeakHashMap();
  private String aQ;
  private String aR;
  private String aS;
  private boolean aT = true;
  private List<byte[]> aU;
  private LocationManager aV;
  private String aW;
  private Map<Integer, ByteBuffer> aX = new HashMap();
  private boolean aY;
  private long aZ;
  private List<byte[]> ba = new ArrayList();
  private long bb;
  private long bc;
  private long bd;
  private String be = "";
  private String bf = "";
  private byte bg = -1;
  private String bh = "";
  private byte bi = -1;
  private Long bj;
  private int bk;
  private Location bl;
  private Map<String, i> bm = new HashMap();
  private List<bs> bn = new ArrayList();
  private boolean bo;
  private int bp;
  private List<ci> bq = new ArrayList();
  private int br;
  private Map<String, List<String>> bs;
  private Map<String, List<String>> bt;
  
  private FlurryAgent()
  {
    HandlerThread localHandlerThread = new HandlerThread("FlurryAgent");
    localHandlerThread.start();
    this.aG = new Handler(localHandlerThread.getLooper());
  }
  
  private static double a(double paramDouble)
  {
    return Math.round(paramDouble * 1000.0D) / 1000.0D;
  }
  
  /* Error */
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 219	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 4
    //   13: aload 4
    //   15: astore_2
    //   16: new 224	java/lang/StringBuffer
    //   19: dup
    //   20: invokespecial 225	java/lang/StringBuffer:<init>	()V
    //   23: astore_0
    //   24: aload 4
    //   26: astore_2
    //   27: sipush 1024
    //   30: newarray <illegal type>
    //   32: astore_3
    //   33: aload 4
    //   35: astore_2
    //   36: aload 4
    //   38: aload_3
    //   39: invokevirtual 229	java/io/FileInputStream:read	([B)I
    //   42: istore_1
    //   43: iload_1
    //   44: ifle +55 -> 99
    //   47: aload 4
    //   49: astore_2
    //   50: aload_0
    //   51: new 86	java/lang/String
    //   54: dup
    //   55: aload_3
    //   56: iconst_0
    //   57: iload_1
    //   58: invokespecial 232	java/lang/String:<init>	([BII)V
    //   61: invokevirtual 236	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   64: pop
    //   65: goto -32 -> 33
    //   68: astore_3
    //   69: aload 4
    //   71: astore_2
    //   72: ldc -69
    //   74: ldc -18
    //   76: aload_3
    //   77: invokestatic 244	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload 4
    //   82: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   85: aload 5
    //   87: astore_2
    //   88: aload_0
    //   89: ifnull +8 -> 97
    //   92: aload_0
    //   93: invokevirtual 253	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   96: astore_2
    //   97: aload_2
    //   98: areturn
    //   99: aload 4
    //   101: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   104: goto -19 -> 85
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: goto -7 -> 110
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_0
    //   123: aconst_null
    //   124: astore 4
    //   126: goto -57 -> 69
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_0
    //   132: goto -63 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramFile	File
    //   42	16	1	i	int
    //   15	96	2	localObject1	Object
    //   32	24	3	arrayOfByte	byte[]
    //   68	9	3	localThrowable1	Throwable
    //   120	1	3	localThrowable2	Throwable
    //   129	1	3	localThrowable3	Throwable
    //   11	114	4	localFileInputStream	java.io.FileInputStream
    //   1	85	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	68	java/lang/Throwable
    //   36	43	68	java/lang/Throwable
    //   50	65	68	java/lang/Throwable
    //   3	13	107	finally
    //   16	24	116	finally
    //   27	33	116	finally
    //   36	43	116	finally
    //   50	65	116	finally
    //   72	80	116	finally
    //   3	13	120	java/lang/Throwable
    //   16	24	129	java/lang/Throwable
  }
  
  private void a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        if ((this.aQ != null) && (!this.aQ.equals(paramString))) {
          db.d("FlurryAgent", "onStartSession called with different api keys: " + this.aQ + " and " + paramString);
        }
        if ((Context)this.aP.put(paramContext, paramContext) != null) {
          db.g("FlurryAgent", "onStartSession called with duplicate context, use a specific Activity or Service as context instead of using a global context");
        }
        if (this.aM) {
          break label726;
        }
        db.c("FlurryAgent", "Initializing Flurry session");
        this.aQ = paramString;
        this.aK = paramContext.getFileStreamPath(".flurryagent." + Integer.toString(this.aQ.hashCode(), 16));
        this.aJ = paramContext.getFileStreamPath(".flurryb.");
        this.aL = paramContext.getFileStreamPath(".flurryinstallreceiver.");
        if (aE) {
          Thread.setDefaultUncaughtExceptionHandler(new FlurryAgent.FlurryDefaultExceptionHandler());
        }
        paramString = paramContext.getApplicationContext();
        if (this.aS == null) {
          this.aS = d(paramString);
        }
        Object localObject = paramString.getPackageName();
        if ((this.aR != null) && (!this.aR.equals(localObject))) {
          db.d("FlurryAgent", "onStartSession called from different application packages: " + this.aR + " and " + (String)localObject);
        }
        this.aR = ((String)localObject);
        long l = SystemClock.elapsedRealtime();
        if (l - this.aO <= aA) {
          break;
        }
        db.c("FlurryAgent", "New session");
        this.bb = System.currentTimeMillis();
        this.bc = l;
        this.bd = -1L;
        this.bh = "";
        this.bk = 0;
        this.bl = null;
        this.bf = TimeZone.getDefault().getID();
        this.be = (Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry());
        this.bm = new HashMap();
        this.bn = new ArrayList();
        this.bo = true;
        this.bq = new ArrayList();
        this.bp = 0;
        this.br = 0;
        aH.set(0);
        aI.set(0);
        if (n()) {
          this.Q.a(paramContext, this.bb, this.bc);
        }
        a(new d(this, paramString, this.aT));
        if (!(paramContext instanceof Activity)) {
          break label721;
        }
        paramString = ((Activity)paramContext).getIntent().getExtras();
        if (paramString == null) {
          break label721;
        }
        new StringBuilder().append("Launch Options Bundle is present ").append(paramString.toString()).toString();
        this.bt = new HashMap();
        localObject = paramString.keySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label721;
        }
        String str = (String)((Iterator)localObject).next();
        if (str != null)
        {
          paramContext = paramString.get(str);
          if (paramContext != null)
          {
            paramContext = paramContext.toString();
            this.bt.put(str, new ArrayList(Arrays.asList(new String[] { paramContext })));
            new StringBuilder().append("Launch options Key: ").append(str).append(". Its value: ").append(paramContext).toString();
          }
          else
          {
            paramContext = "null";
          }
        }
      }
      finally {}
    }
    db.c("FlurryAgent", "Continuing previous session");
    if (!this.ba.isEmpty()) {
      this.ba.remove(this.ba.size() - 1);
    }
    if (n()) {
      this.Q.J();
    }
    label721:
    this.aM = true;
    label726:
  }
  
  /* Error */
  private void a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +27 -> 30
    //   6: aload_0
    //   7: getfield 145	com/flurry/android/FlurryAgent:aP	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 490 2 0
    //   16: checkcast 283	android/content/Context
    //   19: ifnonnull +11 -> 30
    //   22: ldc -69
    //   24: ldc_w 492
    //   27: invokestatic 288	com/flurry/android/db:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 138	com/flurry/android/FlurryAgent:aM	Z
    //   34: ifeq +160 -> 194
    //   37: aload_0
    //   38: getfield 145	com/flurry/android/FlurryAgent:aP	Ljava/util/Map;
    //   41: invokeinterface 493 1 0
    //   46: ifeq +148 -> 194
    //   49: ldc -69
    //   51: ldc_w 495
    //   54: invokestatic 293	com/flurry/android/db:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: invokespecial 498	com/flurry/android/FlurryAgent:v	()V
    //   61: aload_1
    //   62: ifnonnull +135 -> 197
    //   65: aconst_null
    //   66: astore 5
    //   68: aload_1
    //   69: ifnull +58 -> 127
    //   72: aload 5
    //   74: invokevirtual 335	android/content/Context:getPackageName	()Ljava/lang/String;
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 337	com/flurry/android/FlurryAgent:aR	Ljava/lang/String;
    //   82: aload_1
    //   83: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifne +41 -> 127
    //   89: ldc -69
    //   91: new 262	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 500
    //   101: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: getfield 337	com/flurry/android/FlurryAgent:aR	Ljava/lang/String;
    //   108: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 502
    //   114: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 275	com/flurry/android/db:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: invokestatic 345	android/os/SystemClock:elapsedRealtime	()J
    //   130: lstore_3
    //   131: aload_0
    //   132: lload_3
    //   133: putfield 347	com/flurry/android/FlurryAgent:aO	J
    //   136: aload_0
    //   137: lload_3
    //   138: aload_0
    //   139: getfield 358	com/flurry/android/FlurryAgent:bc	J
    //   142: lsub
    //   143: putfield 362	com/flurry/android/FlurryAgent:bd	J
    //   146: aload_0
    //   147: invokespecial 505	com/flurry/android/FlurryAgent:id	()Ljava/lang/String;
    //   150: ifnonnull +11 -> 161
    //   153: ldc -69
    //   155: ldc_w 507
    //   158: invokestatic 275	com/flurry/android/db:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_0
    //   162: new 509	com/flurry/android/a
    //   165: dup
    //   166: aload_0
    //   167: iload_2
    //   168: aload 5
    //   170: invokespecial 512	com/flurry/android/a:<init>	(Lcom/flurry/android/FlurryAgent;ZLandroid/content/Context;)V
    //   173: invokespecial 412	com/flurry/android/FlurryAgent:a	(Lcom/flurry/android/bk;)V
    //   176: invokestatic 401	com/flurry/android/FlurryAgent:n	()Z
    //   179: ifeq +10 -> 189
    //   182: aload_0
    //   183: getfield 183	com/flurry/android/FlurryAgent:Q	Lcom/flurry/android/FlurryAds;
    //   186: invokevirtual 515	com/flurry/android/FlurryAds:K	()V
    //   189: aload_0
    //   190: iconst_0
    //   191: putfield 138	com/flurry/android/FlurryAgent:aM	Z
    //   194: aload_0
    //   195: monitorexit
    //   196: return
    //   197: aload_1
    //   198: invokevirtual 327	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   201: astore 5
    //   203: goto -135 -> 68
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	FlurryAgent
    //   0	211	1	paramContext	Context
    //   0	211	2	paramBoolean	boolean
    //   130	8	3	l	long
    //   66	136	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   6	30	206	finally
    //   30	61	206	finally
    //   72	127	206	finally
    //   127	161	206	finally
    //   161	189	206	finally
    //   189	194	206	finally
    //   197	203	206	finally
  }
  
  private void a(bk parambk)
  {
    this.aG.post(parambk);
  }
  
  private void a(DataInputStream paramDataInputStream)
    throws IOException
  {
    int i = 0;
    int j;
    try
    {
      j = paramDataInputStream.readUnsignedShort();
      if (j > 2)
      {
        db.d("FlurryAgent", "Unknown agent file version: " + j);
        throw new IOException("Unknown agent file version: " + j);
      }
    }
    finally {}
    Object localObject;
    if (j >= 2)
    {
      localObject = paramDataInputStream.readUTF();
      db.c("FlurryAgent", "Loading API key: " + f(this.aQ));
      if (((String)localObject).equals(this.aQ))
      {
        localObject = paramDataInputStream.readUTF();
        if (id() == null) {
          db.c("FlurryAgent", "Loading phoneId: " + (String)localObject);
        }
        g((String)localObject);
        this.aY = paramDataInputStream.readBoolean();
        this.aZ = paramDataInputStream.readLong();
        db.c("FlurryAgent", "Loading session reports");
        for (;;)
        {
          j = paramDataInputStream.readUnsignedShort();
          if (j == 0) {
            break;
          }
          localObject = new byte[j];
          paramDataInputStream.readFully((byte[])localObject);
          this.ba.add(0, localObject);
          localObject = new StringBuilder().append("Session report added: ");
          i += 1;
          db.c("FlurryAgent", i);
        }
        db.c("FlurryAgent", "Persistent file loaded");
        this.aN = true;
      }
    }
    for (;;)
    {
      return;
      db.c("FlurryAgent", "Api keys do not match, old: " + f((String)localObject) + ", new: " + f(this.aQ));
      continue;
      db.g("FlurryAgent", "Deleting old file version: " + j);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    label163:
    label289:
    for (;;)
    {
      int i;
      long l;
      try
      {
        if (this.bq == null)
        {
          db.d("FlurryAgent", "onError called before onStartSession.  Error: " + paramString1);
          return;
        }
        if ((paramString1 != null) && ("uncaught".equals(paramString1)))
        {
          i = 1;
          this.bk += 1;
          if (this.bq.size() >= 50) {
            break label163;
          }
          l = System.currentTimeMillis();
          paramString1 = new ci(aI.incrementAndGet(), Long.valueOf(l).longValue(), paramString1, paramString2, paramString3, paramThrowable);
          this.bq.add(paramString1);
          db.c("FlurryAgent", "Error logged: " + paramString1.am());
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        if (i >= this.bq.size()) {
          break label289;
        }
        ci localci = (ci)this.bq.get(i);
        if ((localci.am() != null) && (!"uncaught".equals(localci.am())))
        {
          l = System.currentTimeMillis();
          paramString1 = new ci(aI.incrementAndGet(), Long.valueOf(l).longValue(), paramString1, paramString2, paramString3, paramThrowable);
          this.bq.set(i, paramString1);
          break;
          db.c("FlurryAgent", "Max errors logged. No more errors logged.");
          break;
        }
        i += 1;
      }
    }
  }
  
  private void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      long l1;
      long l2;
      String str;
      try
      {
        if (this.bn == null)
        {
          db.d("FlurryAgent", "onEvent called before onStartSession.  Event: " + paramString);
          return;
        }
        l1 = SystemClock.elapsedRealtime();
        l2 = this.bc;
        str = bd.sanitize(paramString);
        if (str.length() == 0) {
          continue;
        }
        paramString = (i)this.bm.get(str);
        if (paramString != null) {
          break label264;
        }
        if (this.bm.size() < 100)
        {
          paramString = new i();
          paramString.value = 1;
          this.bm.put(str, paramString);
          db.c("FlurryAgent", "Event count incremented: " + str);
          if ((!aB) || (this.bn.size() >= 1000) || (this.bp >= 160000)) {
            break label371;
          }
          if (paramMap != null) {
            break label379;
          }
          paramString = Collections.emptyMap();
          if (paramString.size() <= 10) {
            break label277;
          }
          db.g("FlurryAgent", "MaxEventParams exceeded: " + paramString.size());
          continue;
        }
        db.g("FlurryAgent", "Too many different events. Event not counted: " + str);
      }
      finally {}
      continue;
      label264:
      paramString.value += 1;
      continue;
      label277:
      paramString = new bs(aH.incrementAndGet(), str, paramString, l1 - l2, paramBoolean);
      if (paramString.getBytes().length + this.bp <= 160000)
      {
        this.bn.add(paramString);
        int i = this.bp;
        this.bp = (paramString.getBytes().length + i);
      }
      else
      {
        this.bp = 160000;
        this.bo = false;
        db.g("FlurryAgent", "Event Log size exceeded. No more event details logged.");
        continue;
        label371:
        this.bo = false;
        continue;
        label379:
        paramString = paramMap;
      }
    }
  }
  
  private boolean a(byte[] paramArrayOfByte)
    throws IOException
  {
    ??? = r();
    boolean bool2;
    if (??? == null) {
      bool2 = false;
    }
    boolean bool1;
    for (;;)
    {
      return bool2;
      try
      {
        bool1 = a(paramArrayOfByte, (String)???);
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (aw == null)
          {
            bool2 = bool1;
            if (aC)
            {
              bool2 = bool1;
              if (aD) {}
            }
          }
        }
      }
      catch (Exception localException)
      {
        String str;
        synchronized (az)
        {
          for (;;)
          {
            aD = true;
            str = r();
            if (str != null) {
              break;
            }
            return false;
            localException = localException;
            db.c("FlurryAgent", "Sending report exception: " + localException.getMessage());
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    boolean bool = true;
    if ("local".equals(paramString)) {
      return true;
    }
    db.c("FlurryAgent", "Sending report to: " + paramString);
    paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
    paramArrayOfByte.setContentType("application/octet-stream");
    paramString = new HttpPost(paramString);
    paramString.setEntity(paramArrayOfByte);
    paramArrayOfByte = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramArrayOfByte, 10000);
    HttpConnectionParams.setSoTimeout(paramArrayOfByte, 15000);
    paramString.getParams().setBooleanParameter("http.protocol.expect-continue", false);
    int i = cn.a(paramArrayOfByte).execute(paramString).getStatusLine().getStatusCode();
    if (i == 200) {}
    for (;;)
    {
      try
      {
        db.c("FlurryAgent", "Report successful");
        this.aY = true;
        this.ba.removeAll(this.aU);
        this.aU = null;
        return bool;
      }
      finally {}
      db.c("FlurryAgent", "Report failed. HTTP response: " + i);
      bool = false;
    }
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 773	com/flurry/android/FlurryAgent:c	(Landroid/content/Context;)Ljava/lang/String;
    //   7: astore 11
    //   9: aload_0
    //   10: getfield 134	com/flurry/android/FlurryAgent:aK	Ljava/io/File;
    //   13: invokevirtual 778	java/io/File:exists	()Z
    //   16: ifeq +357 -> 373
    //   19: ldc -69
    //   21: new 262	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 780
    //   31: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 134	com/flurry/android/FlurryAgent:aK	Ljava/io/File;
    //   38: invokevirtual 783	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 785	com/flurry/android/db:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: new 549	java/io/DataInputStream
    //   53: dup
    //   54: new 219	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: getfield 134	com/flurry/android/FlurryAgent:aK	Ljava/io/File;
    //   62: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: invokespecial 788	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: astore 9
    //   70: aload 9
    //   72: astore 8
    //   74: aload 9
    //   76: invokevirtual 552	java/io/DataInputStream:readUnsignedShort	()I
    //   79: ldc_w 789
    //   82: if_icmpne +212 -> 294
    //   85: aload 9
    //   87: astore 8
    //   89: aload_0
    //   90: aload 9
    //   92: invokespecial 791	com/flurry/android/FlurryAgent:a	(Ljava/io/DataInputStream;)V
    //   95: aload 9
    //   97: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   100: aload_0
    //   101: getfield 140	com/flurry/android/FlurryAgent:aN	Z
    //   104: ifne +21 -> 125
    //   107: aload_0
    //   108: getfield 134	com/flurry/android/FlurryAgent:aK	Ljava/io/File;
    //   111: invokevirtual 794	java/io/File:delete	()Z
    //   114: ifeq +234 -> 348
    //   117: ldc -69
    //   119: ldc_w 796
    //   122: invokestatic 293	com/flurry/android/db:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 140	com/flurry/android/FlurryAgent:aN	Z
    //   129: ifne +21 -> 150
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 575	com/flurry/android/FlurryAgent:aY	Z
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 356	com/flurry/android/FlurryAgent:bb	J
    //   142: putfield 580	com/flurry/android/FlurryAgent:aZ	J
    //   145: aload_0
    //   146: iconst_1
    //   147: putfield 140	com/flurry/android/FlurryAgent:aN	Z
    //   150: aload 11
    //   152: ifnonnull +244 -> 396
    //   155: invokestatic 800	java/lang/Math:random	()D
    //   158: invokestatic 805	java/lang/Double:doubleToLongBits	(D)J
    //   161: lstore_2
    //   162: invokestatic 808	java/lang/System:nanoTime	()J
    //   165: lstore 4
    //   167: aload_0
    //   168: getfield 256	com/flurry/android/FlurryAgent:aQ	Ljava/lang/String;
    //   171: invokevirtual 299	java/lang/String:hashCode	()I
    //   174: bipush 37
    //   176: imul
    //   177: i2l
    //   178: lstore 6
    //   180: new 262	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 810
    //   190: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: lload_2
    //   194: ldc2_w 811
    //   197: lload 4
    //   199: lload 6
    //   201: ladd
    //   202: lmul
    //   203: ladd
    //   204: bipush 16
    //   206: invokestatic 815	java/lang/Long:toString	(JI)Ljava/lang/String;
    //   209: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: astore 8
    //   217: ldc -69
    //   219: ldc_w 817
    //   222: invokestatic 785	com/flurry/android/db:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_0
    //   226: aload 8
    //   228: invokespecial 570	com/flurry/android/FlurryAgent:g	(Ljava/lang/String;)V
    //   231: invokestatic 401	com/flurry/android/FlurryAgent:n	()Z
    //   234: ifeq +25 -> 259
    //   237: aload_0
    //   238: getfield 183	com/flurry/android/FlurryAgent:Q	Lcom/flurry/android/FlurryAds;
    //   241: aload_0
    //   242: getfield 819	com/flurry/android/FlurryAgent:aW	Ljava/lang/String;
    //   245: invokevirtual 822	com/flurry/android/FlurryAds:k	(Ljava/lang/String;)V
    //   248: aload_0
    //   249: getfield 183	com/flurry/android/FlurryAgent:Q	Lcom/flurry/android/FlurryAds;
    //   252: aload_0
    //   253: getfield 152	com/flurry/android/FlurryAgent:aX	Ljava/util/Map;
    //   256: invokevirtual 825	com/flurry/android/FlurryAds:b	(Ljava/util/Map;)V
    //   259: aload 8
    //   261: ldc_w 827
    //   264: invokevirtual 831	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   267: ifne +20 -> 287
    //   270: aload_0
    //   271: getfield 312	com/flurry/android/FlurryAgent:aJ	Ljava/io/File;
    //   274: invokevirtual 778	java/io/File:exists	()Z
    //   277: ifne +10 -> 287
    //   280: aload_0
    //   281: aload_1
    //   282: aload 8
    //   284: invokespecial 833	com/flurry/android/FlurryAgent:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   287: aload_0
    //   288: invokespecial 836	com/flurry/android/FlurryAgent:t	()V
    //   291: aload_0
    //   292: monitorexit
    //   293: return
    //   294: aload 9
    //   296: astore 8
    //   298: ldc -69
    //   300: ldc_w 838
    //   303: invokestatic 293	com/flurry/android/db:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: goto -211 -> 95
    //   309: astore 10
    //   311: aload 9
    //   313: astore 8
    //   315: ldc -69
    //   317: ldc -18
    //   319: aload 10
    //   321: invokestatic 244	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   324: aload 9
    //   326: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   329: goto -229 -> 100
    //   332: astore_1
    //   333: aload_0
    //   334: monitorexit
    //   335: aload_1
    //   336: athrow
    //   337: astore_1
    //   338: aconst_null
    //   339: astore 8
    //   341: aload 8
    //   343: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   346: aload_1
    //   347: athrow
    //   348: ldc -69
    //   350: ldc_w 840
    //   353: invokestatic 275	com/flurry/android/db:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: goto -231 -> 125
    //   359: astore 8
    //   361: ldc -69
    //   363: ldc -97
    //   365: aload 8
    //   367: invokestatic 244	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   370: goto -245 -> 125
    //   373: ldc -69
    //   375: ldc_w 842
    //   378: invokestatic 785	com/flurry/android/db:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: goto -256 -> 125
    //   384: astore_1
    //   385: goto -44 -> 341
    //   388: astore 10
    //   390: aconst_null
    //   391: astore 9
    //   393: goto -82 -> 311
    //   396: aload 11
    //   398: astore 8
    //   400: goto -175 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	FlurryAgent
    //   0	403	1	paramContext	Context
    //   161	33	2	l1	long
    //   165	33	4	l2	long
    //   178	22	6	l3	long
    //   72	270	8	localObject	Object
    //   359	7	8	localThrowable1	Throwable
    //   398	1	8	str1	String
    //   68	324	9	localDataInputStream	DataInputStream
    //   309	11	10	localThrowable2	Throwable
    //   388	1	10	localThrowable3	Throwable
    //   7	390	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   74	85	309	java/lang/Throwable
    //   89	95	309	java/lang/Throwable
    //   298	306	309	java/lang/Throwable
    //   2	50	332	finally
    //   95	100	332	finally
    //   100	125	332	finally
    //   125	150	332	finally
    //   155	225	332	finally
    //   225	259	332	finally
    //   259	287	332	finally
    //   287	291	332	finally
    //   324	329	332	finally
    //   341	348	332	finally
    //   348	356	332	finally
    //   361	370	332	finally
    //   373	381	332	finally
    //   50	70	337	finally
    //   100	125	359	java/lang/Throwable
    //   348	356	359	java/lang/Throwable
    //   74	85	384	finally
    //   89	95	384	finally
    //   298	306	384	finally
    //   315	324	384	finally
    //   50	70	388	java/lang/Throwable
  }
  
  /* Error */
  private void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: ldc_w 310
    //   7: invokevirtual 308	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   10: putfield 312	com/flurry/android/FlurryAgent:aJ	Ljava/io/File;
    //   13: aload_0
    //   14: getfield 312	com/flurry/android/FlurryAgent:aJ	Ljava/io/File;
    //   17: invokestatic 847	com/flurry/android/bc:b	(Ljava/io/File;)Z
    //   20: istore_3
    //   21: iload_3
    //   22: ifne +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: new 849	java/io/DataOutputStream
    //   31: dup
    //   32: new 851	java/io/FileOutputStream
    //   35: dup
    //   36: aload_0
    //   37: getfield 312	com/flurry/android/FlurryAgent:aJ	Ljava/io/File;
    //   40: invokespecial 852	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 855	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore 4
    //   48: aload 4
    //   50: astore_1
    //   51: aload 4
    //   53: iconst_1
    //   54: invokevirtual 858	java/io/DataOutputStream:writeInt	(I)V
    //   57: aload 4
    //   59: astore_1
    //   60: aload 4
    //   62: aload_2
    //   63: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   71: goto -46 -> 25
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    //   79: astore 5
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: ldc -69
    //   87: ldc_w 863
    //   90: aload 5
    //   92: invokestatic 244	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_2
    //   96: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   99: goto -74 -> 25
    //   102: aload_1
    //   103: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   106: aload_2
    //   107: athrow
    //   108: astore_2
    //   109: goto -7 -> 102
    //   112: astore 5
    //   114: aload 4
    //   116: astore_2
    //   117: goto -34 -> 83
    //   120: astore_2
    //   121: aconst_null
    //   122: astore_1
    //   123: goto -21 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	FlurryAgent
    //   0	126	1	paramContext	Context
    //   0	126	2	paramString	String
    //   20	2	3	bool	boolean
    //   46	69	4	localDataOutputStream	java.io.DataOutputStream
    //   79	12	5	localThrowable1	Throwable
    //   112	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	21	74	finally
    //   66	71	74	finally
    //   95	99	74	finally
    //   102	108	74	finally
    //   28	48	79	java/lang/Throwable
    //   51	57	108	finally
    //   60	66	108	finally
    //   85	95	108	finally
    //   51	57	112	java/lang/Throwable
    //   60	66	112	java/lang/Throwable
    //   28	48	120	finally
  }
  
  private void b(String paramString, Map<String, String> paramMap)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.bn.iterator();
        bs localbs;
        int i;
        if (localIterator.hasNext())
        {
          localbs = (bs)localIterator.next();
          if (!localbs.w(paramString)) {
            continue;
          }
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.bc;
          if ((paramMap != null) && (paramMap.size() > 0) && (this.bp < 160000))
          {
            i = this.bp - localbs.getBytes().length;
            paramString = new HashMap(localbs.getParameters());
            localbs.d(paramMap);
            if (localbs.getBytes().length + i > 160000) {
              break label211;
            }
            if (localbs.getParameters().size() > 10)
            {
              db.g("FlurryAgent", "MaxEventParams exceeded on endEvent: " + localbs.getParameters().size());
              localbs.e(paramString);
            }
          }
          else
          {
            localbs.c(l1 - l2);
          }
        }
        else
        {
          return;
        }
        this.bp = (i + localbs.getBytes().length);
        continue;
        localbs.e(paramString);
      }
      finally {}
      label211:
      this.bo = false;
      this.bp = 160000;
      db.g("FlurryAgent", "Event Log size exceeded. No more event details logged.");
    }
  }
  
  /* Error */
  private String c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: invokespecial 505	com/flurry/android/FlurryAgent:id	()Ljava/lang/String;
    //   7: astore 8
    //   9: aload 8
    //   11: ifnull +6 -> 17
    //   14: aload 8
    //   16: areturn
    //   17: aload_1
    //   18: invokevirtual 891	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: ldc_w 893
    //   24: invokestatic 899	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 6
    //   29: iload 4
    //   31: istore_2
    //   32: aload 6
    //   34: ifnull +28 -> 62
    //   37: iload 4
    //   39: istore_2
    //   40: aload 6
    //   42: invokevirtual 645	java/lang/String:length	()I
    //   45: ifle +17 -> 62
    //   48: aload 6
    //   50: ldc_w 470
    //   53: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +32 -> 88
    //   59: iload 4
    //   61: istore_2
    //   62: iload_2
    //   63: ifeq +70 -> 133
    //   66: new 262	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 827
    //   76: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 6
    //   81: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: areturn
    //   88: getstatic 92	com/flurry/android/FlurryAgent:av	[Ljava/lang/String;
    //   91: astore 7
    //   93: aload 7
    //   95: arraylength
    //   96: istore 5
    //   98: iconst_0
    //   99: istore_3
    //   100: iload_3
    //   101: iload 5
    //   103: if_icmpge +25 -> 128
    //   106: iload 4
    //   108: istore_2
    //   109: aload 6
    //   111: aload 7
    //   113: iload_3
    //   114: aaload
    //   115: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifne -56 -> 62
    //   121: iload_3
    //   122: iconst_1
    //   123: iadd
    //   124: istore_3
    //   125: goto -25 -> 100
    //   128: iconst_1
    //   129: istore_2
    //   130: goto -68 -> 62
    //   133: aload_1
    //   134: ldc_w 310
    //   137: invokevirtual 308	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 778	java/io/File:exists	()Z
    //   145: ifeq -131 -> 14
    //   148: new 549	java/io/DataInputStream
    //   151: dup
    //   152: new 219	java/io/FileInputStream
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   160: invokespecial 788	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   163: astore 6
    //   165: aload 6
    //   167: astore_1
    //   168: aload 6
    //   170: invokevirtual 902	java/io/DataInputStream:readInt	()I
    //   173: pop
    //   174: aload 6
    //   176: astore_1
    //   177: aload 6
    //   179: invokevirtual 561	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   182: astore 7
    //   184: aload 6
    //   186: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   189: aload 7
    //   191: areturn
    //   192: astore 7
    //   194: aconst_null
    //   195: astore 6
    //   197: aload 6
    //   199: astore_1
    //   200: ldc -69
    //   202: ldc_w 904
    //   205: aload 7
    //   207: invokestatic 244	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload 6
    //   212: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   215: aload 8
    //   217: areturn
    //   218: astore 6
    //   220: aconst_null
    //   221: astore_1
    //   222: aload_1
    //   223: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   226: aload 6
    //   228: athrow
    //   229: astore 6
    //   231: goto -9 -> 222
    //   234: astore 7
    //   236: goto -39 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	FlurryAgent
    //   0	239	1	paramContext	Context
    //   31	99	2	i	int
    //   99	26	3	j	int
    //   1	106	4	k	int
    //   96	8	5	m	int
    //   27	184	6	localObject1	Object
    //   218	9	6	localObject2	Object
    //   229	1	6	localObject3	Object
    //   91	99	7	localObject4	Object
    //   192	14	7	localThrowable1	Throwable
    //   234	1	7	localThrowable2	Throwable
    //   7	209	8	str	String
    // Exception table:
    //   from	to	target	type
    //   148	165	192	java/lang/Throwable
    //   148	165	218	finally
    //   168	174	229	finally
    //   177	184	229	finally
    //   200	210	229	finally
    //   168	174	234	java/lang/Throwable
    //   177	184	234	java/lang/Throwable
  }
  
  private static String d(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext.versionName != null) {
        return paramContext.versionName;
      }
      if (paramContext.versionCode != 0)
      {
        paramContext = Integer.toString(paramContext.versionCode);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      db.b("FlurryAgent", "", paramContext);
    }
    return "Unknown";
  }
  
  private Location e(Context paramContext)
  {
    if ((paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) || (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0))
    {
      paramContext = (LocationManager)paramContext.getSystemService("location");
      try
      {
        if (this.aV == null) {
          this.aV = paramContext;
        }
        for (;;)
        {
          Criteria localCriteria = aF;
          Object localObject = localCriteria;
          if (localCriteria == null) {
            localObject = new Criteria();
          }
          localObject = paramContext.getBestProvider((Criteria)localObject, true);
          if (localObject == null) {
            break;
          }
          paramContext.requestLocationUpdates((String)localObject, 0L, 0.0F, this, Looper.getMainLooper());
          return paramContext.getLastKnownLocation((String)localObject);
          paramContext = this.aV;
        }
        return null;
      }
      finally {}
    }
  }
  
  private static Map<String, List<String>> e(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramString.split("&");
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfString[i].split("=");
      if (localObject.length != 2) {
        db.c("FlurryAgent", "Invalid referrer Element: " + arrayOfString[i] + " in referrer tag " + paramString);
      }
      for (;;)
      {
        i += 1;
        break;
        String str = URLDecoder.decode(localObject[0]);
        localObject = URLDecoder.decode(localObject[1]);
        if (localHashMap.get(str) == null) {
          localHashMap.put(str, new ArrayList());
        }
        ((List)localHashMap.get(str)).add(localObject);
      }
    }
    paramString = new StringBuilder();
    if (localHashMap.get("utm_source") == null) {
      paramString.append("Campaign Source is missing.\n");
    }
    if (localHashMap.get("utm_medium") == null) {
      paramString.append("Campaign Medium is missing.\n");
    }
    if (localHashMap.get("utm_campaign") == null) {
      paramString.append("Campaign Name is missing.\n");
    }
    if (paramString.length() > 0) {
      Log.w("Detected missing referrer keys", paramString.toString());
    }
    return localHashMap;
  }
  
  public static void endTimedEvent(String paramString)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String eventId passed to endTimedEvent was null.");
      return;
    }
    try
    {
      az.b(paramString, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      db.b("FlurryAgent", "Failed to signify the end of event: " + paramString, localThrowable);
    }
  }
  
  public static void endTimedEvent(String paramString, Map<String, String> paramMap)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String eventId passed to endTimedEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      db.d("FlurryAgent", "String eventId passed to endTimedEvent was null.");
      return;
    }
    try
    {
      az.b(paramString, paramMap);
      return;
    }
    catch (Throwable paramMap)
    {
      db.b("FlurryAgent", "Failed to signify the end of event: " + paramString, paramMap);
    }
  }
  
  private static String f(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > 4)
      {
        localObject = new StringBuilder();
        int i = 0;
        while (i < paramString.length() - 4)
        {
          ((StringBuilder)localObject).append('*');
          i += 1;
        }
        ((StringBuilder)localObject).append(paramString.substring(paramString.length() - 4));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return (String)localObject;
  }
  
  private static byte[] f(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0)
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getDeviceId();
        if ((paramContext == null) || (paramContext.trim().length() <= 0)) {}
      }
    }
    try
    {
      paramContext = bd.r(paramContext);
      if ((paramContext != null) && (paramContext.length == 20)) {
        return paramContext;
      }
      db.d("FlurryAgent", "sha1 is not 20 bytes long: " + Arrays.toString(paramContext));
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  private void g(String paramString)
  {
    if (paramString != null) {}
    try
    {
      this.aW = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static int getAgentVersion()
  {
    return 148;
  }
  
  public static boolean getForbidPlaintextFallback()
  {
    return false;
  }
  
  static String getLocale()
  {
    return az.be;
  }
  
  public static String getPhoneId()
  {
    return az.id();
  }
  
  public static boolean getUseHttps()
  {
    return aC;
  }
  
  private String id()
  {
    try
    {
      String str = this.aW;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected static boolean isCaptureUncaughtExceptions()
  {
    return aE;
  }
  
  public static void logEvent(String paramString)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String eventId passed to logEvent was null.");
      return;
    }
    try
    {
      az.a(paramString, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      db.b("FlurryAgent", "Failed to log event: " + paramString, localThrowable);
    }
  }
  
  public static void logEvent(String paramString, Map<String, String> paramMap)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String eventId passed to logEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      db.d("FlurryAgent", "String parameters passed to logEvent was null.");
      return;
    }
    try
    {
      az.a(paramString, paramMap, false);
      return;
    }
    catch (Throwable paramMap)
    {
      db.b("FlurryAgent", "Failed to log event: " + paramString, paramMap);
    }
  }
  
  public static void logEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String eventId passed to logEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      db.d("FlurryAgent", "String parameters passed to logEvent was null.");
      return;
    }
    try
    {
      az.a(paramString, paramMap, paramBoolean);
      return;
    }
    catch (Throwable paramMap)
    {
      db.b("FlurryAgent", "Failed to log event: " + paramString, paramMap);
    }
  }
  
  public static void logEvent(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String eventId passed to logEvent was null.");
      return;
    }
    try
    {
      az.a(paramString, null, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      db.b("FlurryAgent", "Failed to log event: " + paramString, localThrowable);
    }
  }
  
  static boolean m()
  {
    return (az.aN) && (az.aM);
  }
  
  static boolean n()
  {
    if ((az != null) && (az.Q != null)) {}
    for (;;)
    {
      return true;
      try
      {
        Class localClass = Class.forName("com.flurry.android.FlurryAds");
        if (localClass == null) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        new StringBuilder().append("isAppSpotEnabled caught:").append(localThrowable.toString()).toString();
      }
    }
    return false;
  }
  
  /* Error */
  private void o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 4
    //   5: new 1070	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 1071	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 6
    //   14: new 849	java/io/DataOutputStream
    //   17: dup
    //   18: aload 6
    //   20: invokespecial 855	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore 5
    //   25: aload 5
    //   27: iconst_1
    //   28: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   31: aload 5
    //   33: aload_0
    //   34: getfield 329	com/flurry/android/FlurryAgent:aS	Ljava/lang/String;
    //   37: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   40: aload 5
    //   42: aload_0
    //   43: getfield 356	com/flurry/android/FlurryAgent:bb	J
    //   46: invokevirtual 1077	java/io/DataOutputStream:writeLong	(J)V
    //   49: aload 5
    //   51: aload_0
    //   52: getfield 362	com/flurry/android/FlurryAgent:bd	J
    //   55: invokevirtual 1077	java/io/DataOutputStream:writeLong	(J)V
    //   58: aload 5
    //   60: lconst_0
    //   61: invokevirtual 1077	java/io/DataOutputStream:writeLong	(J)V
    //   64: aload 5
    //   66: aload_0
    //   67: getfield 161	com/flurry/android/FlurryAgent:be	Ljava/lang/String;
    //   70: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   73: aload 5
    //   75: aload_0
    //   76: getfield 163	com/flurry/android/FlurryAgent:bf	Ljava/lang/String;
    //   79: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   82: aload 5
    //   84: aload_0
    //   85: getfield 165	com/flurry/android/FlurryAgent:bg	B
    //   88: invokevirtual 1080	java/io/DataOutputStream:writeByte	(I)V
    //   91: aload_0
    //   92: getfield 167	com/flurry/android/FlurryAgent:bh	Ljava/lang/String;
    //   95: ifnonnull +185 -> 280
    //   98: ldc -97
    //   100: astore 4
    //   102: aload 5
    //   104: aload 4
    //   106: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 366	com/flurry/android/FlurryAgent:bl	Landroid/location/Location;
    //   113: ifnonnull +176 -> 289
    //   116: aload 5
    //   118: iconst_0
    //   119: invokevirtual 1084	java/io/DataOutputStream:writeBoolean	(Z)V
    //   122: aload 5
    //   124: aload_0
    //   125: getfield 394	com/flurry/android/FlurryAgent:br	I
    //   128: invokevirtual 858	java/io/DataOutputStream:writeInt	(I)V
    //   131: aload 5
    //   133: iconst_m1
    //   134: invokevirtual 1080	java/io/DataOutputStream:writeByte	(I)V
    //   137: aload 5
    //   139: iconst_m1
    //   140: invokevirtual 1080	java/io/DataOutputStream:writeByte	(I)V
    //   143: aload 5
    //   145: aload_0
    //   146: getfield 169	com/flurry/android/FlurryAgent:bi	B
    //   149: invokevirtual 1080	java/io/DataOutputStream:writeByte	(I)V
    //   152: aload_0
    //   153: getfield 1086	com/flurry/android/FlurryAgent:bj	Ljava/lang/Long;
    //   156: ifnonnull +201 -> 357
    //   159: aload 5
    //   161: iconst_0
    //   162: invokevirtual 1084	java/io/DataOutputStream:writeBoolean	(Z)V
    //   165: aload 5
    //   167: aload_0
    //   168: getfield 171	com/flurry/android/FlurryAgent:bm	Ljava/util/Map;
    //   171: invokeinterface 650 1 0
    //   176: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   179: aload_0
    //   180: getfield 171	com/flurry/android/FlurryAgent:bm	Ljava/util/Map;
    //   183: invokeinterface 1089 1 0
    //   188: invokeinterface 441 1 0
    //   193: astore 4
    //   195: aload 4
    //   197: invokeinterface 446 1 0
    //   202: ifeq +176 -> 378
    //   205: aload 4
    //   207: invokeinterface 450 1 0
    //   212: checkcast 1091	java/util/Map$Entry
    //   215: astore 7
    //   217: aload 5
    //   219: aload 7
    //   221: invokeinterface 1094 1 0
    //   226: checkcast 86	java/lang/String
    //   229: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   232: aload 5
    //   234: aload 7
    //   236: invokeinterface 1097 1 0
    //   241: checkcast 649	com/flurry/android/i
    //   244: getfield 654	com/flurry/android/i:value	I
    //   247: invokevirtual 858	java/io/DataOutputStream:writeInt	(I)V
    //   250: goto -55 -> 195
    //   253: astore 6
    //   255: aload 5
    //   257: astore 4
    //   259: aload 6
    //   261: astore 5
    //   263: ldc -69
    //   265: ldc -97
    //   267: aload 5
    //   269: invokestatic 244	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload 4
    //   274: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   277: aload_0
    //   278: monitorexit
    //   279: return
    //   280: aload_0
    //   281: getfield 167	com/flurry/android/FlurryAgent:bh	Ljava/lang/String;
    //   284: astore 4
    //   286: goto -184 -> 102
    //   289: aload 5
    //   291: iconst_1
    //   292: invokevirtual 1084	java/io/DataOutputStream:writeBoolean	(Z)V
    //   295: aload 5
    //   297: aload_0
    //   298: getfield 366	com/flurry/android/FlurryAgent:bl	Landroid/location/Location;
    //   301: invokevirtual 1102	android/location/Location:getLatitude	()D
    //   304: invokestatic 1104	com/flurry/android/FlurryAgent:a	(D)D
    //   307: invokevirtual 1108	java/io/DataOutputStream:writeDouble	(D)V
    //   310: aload 5
    //   312: aload_0
    //   313: getfield 366	com/flurry/android/FlurryAgent:bl	Landroid/location/Location;
    //   316: invokevirtual 1111	android/location/Location:getLongitude	()D
    //   319: invokestatic 1104	com/flurry/android/FlurryAgent:a	(D)D
    //   322: invokevirtual 1108	java/io/DataOutputStream:writeDouble	(D)V
    //   325: aload 5
    //   327: aload_0
    //   328: getfield 366	com/flurry/android/FlurryAgent:bl	Landroid/location/Location;
    //   331: invokevirtual 1115	android/location/Location:getAccuracy	()F
    //   334: invokevirtual 1119	java/io/DataOutputStream:writeFloat	(F)V
    //   337: goto -215 -> 122
    //   340: astore 4
    //   342: aload 5
    //   344: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   347: aload 4
    //   349: athrow
    //   350: astore 4
    //   352: aload_0
    //   353: monitorexit
    //   354: aload 4
    //   356: athrow
    //   357: aload 5
    //   359: iconst_1
    //   360: invokevirtual 1084	java/io/DataOutputStream:writeBoolean	(Z)V
    //   363: aload 5
    //   365: aload_0
    //   366: getfield 1086	com/flurry/android/FlurryAgent:bj	Ljava/lang/Long;
    //   369: invokevirtual 619	java/lang/Long:longValue	()J
    //   372: invokevirtual 1077	java/io/DataOutputStream:writeLong	(J)V
    //   375: goto -210 -> 165
    //   378: aload 5
    //   380: aload_0
    //   381: getfield 173	com/flurry/android/FlurryAgent:bn	Ljava/util/List;
    //   384: invokeinterface 480 1 0
    //   389: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   392: aload_0
    //   393: getfield 173	com/flurry/android/FlurryAgent:bn	Ljava/util/List;
    //   396: invokeinterface 869 1 0
    //   401: astore 4
    //   403: aload 4
    //   405: invokeinterface 446 1 0
    //   410: ifeq +24 -> 434
    //   413: aload 5
    //   415: aload 4
    //   417: invokeinterface 450 1 0
    //   422: checkcast 669	com/flurry/android/bs
    //   425: invokevirtual 676	com/flurry/android/bs:getBytes	()[B
    //   428: invokevirtual 1122	java/io/DataOutputStream:write	([B)V
    //   431: goto -28 -> 403
    //   434: aload 5
    //   436: aload_0
    //   437: getfield 390	com/flurry/android/FlurryAgent:bo	Z
    //   440: invokevirtual 1084	java/io/DataOutputStream:writeBoolean	(Z)V
    //   443: iconst_0
    //   444: istore_2
    //   445: iconst_0
    //   446: istore_1
    //   447: iconst_0
    //   448: istore_3
    //   449: iload_2
    //   450: aload_0
    //   451: getfield 175	com/flurry/android/FlurryAgent:bq	Ljava/util/List;
    //   454: invokeinterface 480 1 0
    //   459: if_icmpge +38 -> 497
    //   462: iload_3
    //   463: aload_0
    //   464: getfield 175	com/flurry/android/FlurryAgent:bq	Ljava/util/List;
    //   467: iload_2
    //   468: invokeinterface 631 2 0
    //   473: checkcast 608	com/flurry/android/ci
    //   476: invokevirtual 1123	com/flurry/android/ci:getBytes	()[B
    //   479: arraylength
    //   480: iadd
    //   481: istore_3
    //   482: iload_3
    //   483: ldc_w 657
    //   486: if_icmple +122 -> 608
    //   489: ldc -69
    //   491: ldc_w 1125
    //   494: invokestatic 288	com/flurry/android/db:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload 5
    //   499: aload_0
    //   500: getfield 364	com/flurry/android/FlurryAgent:bk	I
    //   503: invokevirtual 858	java/io/DataOutputStream:writeInt	(I)V
    //   506: aload 5
    //   508: iload_1
    //   509: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   512: iconst_0
    //   513: istore_2
    //   514: iload_2
    //   515: iload_1
    //   516: if_icmpge +31 -> 547
    //   519: aload 5
    //   521: aload_0
    //   522: getfield 175	com/flurry/android/FlurryAgent:bq	Ljava/util/List;
    //   525: iload_2
    //   526: invokeinterface 631 2 0
    //   531: checkcast 608	com/flurry/android/ci
    //   534: invokevirtual 1123	com/flurry/android/ci:getBytes	()[B
    //   537: invokevirtual 1122	java/io/DataOutputStream:write	([B)V
    //   540: iload_2
    //   541: iconst_1
    //   542: iadd
    //   543: istore_2
    //   544: goto -30 -> 514
    //   547: aload 5
    //   549: iconst_0
    //   550: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   553: aload 5
    //   555: iconst_0
    //   556: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   559: aload_0
    //   560: getfield 157	com/flurry/android/FlurryAgent:ba	Ljava/util/List;
    //   563: aload 6
    //   565: invokevirtual 1128	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   568: invokeinterface 624 2 0
    //   573: pop
    //   574: aload 5
    //   576: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   579: goto -302 -> 277
    //   582: astore 4
    //   584: aconst_null
    //   585: astore 5
    //   587: goto -245 -> 342
    //   590: astore 6
    //   592: aload 4
    //   594: astore 5
    //   596: aload 6
    //   598: astore 4
    //   600: goto -258 -> 342
    //   603: astore 5
    //   605: goto -342 -> 263
    //   608: iload_1
    //   609: iconst_1
    //   610: iadd
    //   611: istore_1
    //   612: iload_2
    //   613: iconst_1
    //   614: iadd
    //   615: istore_2
    //   616: goto -167 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	FlurryAgent
    //   446	166	1	i	int
    //   444	172	2	j	int
    //   448	39	3	k	int
    //   3	282	4	localObject1	Object
    //   340	8	4	localObject2	Object
    //   350	5	4	localObject3	Object
    //   401	15	4	localIterator	Iterator
    //   582	11	4	localObject4	Object
    //   598	1	4	localObject5	Object
    //   23	572	5	localObject6	Object
    //   603	1	5	localIOException1	IOException
    //   12	7	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   253	311	6	localIOException2	IOException
    //   590	7	6	localObject7	Object
    //   215	20	7	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   25	98	253	java/io/IOException
    //   102	122	253	java/io/IOException
    //   122	165	253	java/io/IOException
    //   165	195	253	java/io/IOException
    //   195	250	253	java/io/IOException
    //   280	286	253	java/io/IOException
    //   289	337	253	java/io/IOException
    //   357	375	253	java/io/IOException
    //   378	403	253	java/io/IOException
    //   403	431	253	java/io/IOException
    //   434	443	253	java/io/IOException
    //   449	482	253	java/io/IOException
    //   489	497	253	java/io/IOException
    //   497	512	253	java/io/IOException
    //   519	540	253	java/io/IOException
    //   547	574	253	java/io/IOException
    //   25	98	340	finally
    //   102	122	340	finally
    //   122	165	340	finally
    //   165	195	340	finally
    //   195	250	340	finally
    //   280	286	340	finally
    //   289	337	340	finally
    //   357	375	340	finally
    //   378	403	340	finally
    //   403	431	340	finally
    //   434	443	340	finally
    //   449	482	340	finally
    //   489	497	340	finally
    //   497	512	340	finally
    //   519	540	340	finally
    //   547	574	340	finally
    //   272	277	350	finally
    //   342	350	350	finally
    //   574	579	350	finally
    //   5	25	582	finally
    //   263	272	590	finally
    //   5	25	603	java/io/IOException
  }
  
  public static void onEndSession(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("Null context");
    }
    try
    {
      az.a(paramContext, false);
      return;
    }
    catch (Throwable paramContext)
    {
      db.b("FlurryAgent", "", paramContext);
    }
  }
  
  public static void onError(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null)
    {
      db.d("FlurryAgent", "String errorId passed to onError was null.");
      return;
    }
    if (paramString2 == null)
    {
      db.d("FlurryAgent", "String message passed to onError was null.");
      return;
    }
    if (paramString3 == null)
    {
      db.d("FlurryAgent", "String errorClass passed to onError was null.");
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = Thread.currentThread().getStackTrace();
        if ((localObject1 != null) && (localObject1.length > 2))
        {
          Object localObject2 = new StackTraceElement[localObject1.length - 2];
          System.arraycopy(localObject1, 2, localObject2, 0, localObject2.length);
          localObject1 = localObject2;
          localObject2 = new Throwable(paramString2);
          ((Throwable)localObject2).setStackTrace((StackTraceElement[])localObject1);
          az.a(paramString1, paramString2, paramString3, (Throwable)localObject2);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        db.b("FlurryAgent", "", paramString1);
        return;
      }
    }
  }
  
  public static void onError(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramString1 == null)
    {
      db.d("FlurryAgent", "String errorId passed to onError was null.");
      return;
    }
    if (paramString2 == null)
    {
      db.d("FlurryAgent", "String message passed to onError was null.");
      return;
    }
    if (paramThrowable == null)
    {
      db.d("FlurryAgent", "Throwable passed to onError was null.");
      return;
    }
    try
    {
      az.a(paramString1, paramString2, paramThrowable.getClass().getName(), paramThrowable);
      return;
    }
    catch (Throwable paramString1)
    {
      db.b("FlurryAgent", "", paramString1);
    }
  }
  
  public static void onEvent(String paramString)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String eventId passed to onEvent was null.");
      return;
    }
    try
    {
      az.a(paramString, null, false);
      return;
    }
    catch (Throwable paramString)
    {
      db.b("FlurryAgent", "", paramString);
    }
  }
  
  public static void onEvent(String paramString, Map<String, String> paramMap)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String eventId passed to onEvent was null.");
      return;
    }
    if (paramMap == null)
    {
      db.d("FlurryAgent", "Parameters Map passed to onEvent was null.");
      return;
    }
    try
    {
      az.a(paramString, paramMap, false);
      return;
    }
    catch (Throwable paramString)
    {
      db.b("FlurryAgent", "", paramString);
    }
  }
  
  public static void onPageView()
  {
    try
    {
      az.p();
      return;
    }
    catch (Throwable localThrowable)
    {
      db.b("FlurryAgent", "", localThrowable);
    }
  }
  
  public static void onStartSession(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new NullPointerException("Null context");
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("Api key not specified");
    }
    try
    {
      az.a(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      db.b("FlurryAgent", "", paramContext);
    }
  }
  
  private void p()
  {
    try
    {
      this.br += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private byte[] q()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 1194	com/flurry/android/CrcMessageDigest
    //   5: dup
    //   6: invokespecial 1195	com/flurry/android/CrcMessageDigest:<init>	()V
    //   9: astore_3
    //   10: new 1070	java/io/ByteArrayOutputStream
    //   13: dup
    //   14: invokespecial 1071	java/io/ByteArrayOutputStream:<init>	()V
    //   17: astore 5
    //   19: new 1197	java/security/DigestOutputStream
    //   22: dup
    //   23: aload 5
    //   25: aload_3
    //   26: invokespecial 1200	java/security/DigestOutputStream:<init>	(Ljava/io/OutputStream;Ljava/security/MessageDigest;)V
    //   29: astore 6
    //   31: new 849	java/io/DataOutputStream
    //   34: dup
    //   35: aload 6
    //   37: invokespecial 855	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore 4
    //   42: aload 4
    //   44: bipush 26
    //   46: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   49: aload 4
    //   51: iconst_0
    //   52: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   55: aload 4
    //   57: lconst_0
    //   58: invokevirtual 1077	java/io/DataOutputStream:writeLong	(J)V
    //   61: aload 4
    //   63: iconst_0
    //   64: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   67: aload 4
    //   69: iconst_3
    //   70: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   73: aload 4
    //   75: sipush 148
    //   78: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   81: aload 4
    //   83: invokestatic 354	java/lang/System:currentTimeMillis	()J
    //   86: invokevirtual 1077	java/io/DataOutputStream:writeLong	(J)V
    //   89: aload 4
    //   91: aload_0
    //   92: getfield 256	com/flurry/android/FlurryAgent:aQ	Ljava/lang/String;
    //   95: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   98: aload 4
    //   100: aload_0
    //   101: getfield 329	com/flurry/android/FlurryAgent:aS	Ljava/lang/String;
    //   104: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   107: aload 4
    //   109: aload_0
    //   110: getfield 152	com/flurry/android/FlurryAgent:aX	Ljava/util/Map;
    //   113: invokeinterface 650 1 0
    //   118: iconst_1
    //   119: iadd
    //   120: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   123: aload 4
    //   125: iconst_0
    //   126: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   129: aload 4
    //   131: aload_0
    //   132: invokespecial 505	com/flurry/android/FlurryAgent:id	()Ljava/lang/String;
    //   135: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   138: aload_0
    //   139: getfield 152	com/flurry/android/FlurryAgent:aX	Ljava/util/Map;
    //   142: invokeinterface 493 1 0
    //   147: ifne +121 -> 268
    //   150: aload_0
    //   151: getfield 152	com/flurry/android/FlurryAgent:aX	Ljava/util/Map;
    //   154: invokeinterface 1089 1 0
    //   159: invokeinterface 441 1 0
    //   164: astore 7
    //   166: aload 7
    //   168: invokeinterface 446 1 0
    //   173: ifeq +95 -> 268
    //   176: aload 7
    //   178: invokeinterface 450 1 0
    //   183: checkcast 1091	java/util/Map$Entry
    //   186: astore 8
    //   188: aload 4
    //   190: aload 8
    //   192: invokeinterface 1094 1 0
    //   197: checkcast 301	java/lang/Integer
    //   200: invokevirtual 1203	java/lang/Integer:intValue	()I
    //   203: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   206: aload 8
    //   208: invokeinterface 1097 1 0
    //   213: checkcast 533	java/nio/ByteBuffer
    //   216: invokevirtual 1206	java/nio/ByteBuffer:array	()[B
    //   219: astore 8
    //   221: aload 4
    //   223: aload 8
    //   225: arraylength
    //   226: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   229: aload 4
    //   231: aload 8
    //   233: invokevirtual 1122	java/io/DataOutputStream:write	([B)V
    //   236: goto -70 -> 166
    //   239: astore 5
    //   241: aload 4
    //   243: astore_3
    //   244: aload 5
    //   246: astore 4
    //   248: ldc -69
    //   250: ldc_w 1208
    //   253: aload 4
    //   255: invokestatic 244	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload_3
    //   259: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   262: aconst_null
    //   263: astore_3
    //   264: aload_0
    //   265: monitorexit
    //   266: aload_3
    //   267: areturn
    //   268: aload 4
    //   270: iconst_0
    //   271: invokevirtual 1080	java/io/DataOutputStream:writeByte	(I)V
    //   274: aload 4
    //   276: aload_0
    //   277: getfield 580	com/flurry/android/FlurryAgent:aZ	J
    //   280: invokevirtual 1077	java/io/DataOutputStream:writeLong	(J)V
    //   283: aload 4
    //   285: aload_0
    //   286: getfield 356	com/flurry/android/FlurryAgent:bb	J
    //   289: invokevirtual 1077	java/io/DataOutputStream:writeLong	(J)V
    //   292: aload 4
    //   294: bipush 6
    //   296: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   299: aload 4
    //   301: ldc_w 1210
    //   304: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   307: aload 4
    //   309: getstatic 1215	android/os/Build:MODEL	Ljava/lang/String;
    //   312: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   315: aload 4
    //   317: ldc_w 1217
    //   320: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   323: aload 4
    //   325: getstatic 1220	android/os/Build:BRAND	Ljava/lang/String;
    //   328: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   331: aload 4
    //   333: ldc_w 1222
    //   336: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   339: aload 4
    //   341: getstatic 1224	android/os/Build:ID	Ljava/lang/String;
    //   344: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   347: aload 4
    //   349: ldc_w 1226
    //   352: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   355: aload 4
    //   357: getstatic 1231	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   360: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   363: aload 4
    //   365: ldc_w 1233
    //   368: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   371: aload 4
    //   373: getstatic 1236	android/os/Build:DEVICE	Ljava/lang/String;
    //   376: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   379: aload 4
    //   381: ldc_w 1238
    //   384: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   387: aload 4
    //   389: getstatic 1241	android/os/Build:PRODUCT	Ljava/lang/String;
    //   392: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   395: aload_0
    //   396: getfield 1243	com/flurry/android/FlurryAgent:bs	Ljava/util/Map;
    //   399: ifnull +317 -> 716
    //   402: aload_0
    //   403: getfield 1243	com/flurry/android/FlurryAgent:bs	Ljava/util/Map;
    //   406: invokeinterface 1244 1 0
    //   411: invokeinterface 1245 1 0
    //   416: istore_1
    //   417: new 262	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 1247
    //   427: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: iload_1
    //   431: invokevirtual 557	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: pop
    //   438: iload_1
    //   439: ifne +31 -> 470
    //   442: new 262	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 1249
    //   452: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_0
    //   456: getfield 136	com/flurry/android/FlurryAgent:aL	Ljava/io/File;
    //   459: invokevirtual 1252	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: pop
    //   466: aload_0
    //   467: invokespecial 836	com/flurry/android/FlurryAgent:t	()V
    //   470: aload 4
    //   472: iload_1
    //   473: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   476: aload_0
    //   477: getfield 1243	com/flurry/android/FlurryAgent:bs	Ljava/util/Map;
    //   480: ifnull +241 -> 721
    //   483: aload_0
    //   484: getfield 1243	com/flurry/android/FlurryAgent:bs	Ljava/util/Map;
    //   487: invokeinterface 1089 1 0
    //   492: invokeinterface 441 1 0
    //   497: astore 7
    //   499: aload 7
    //   501: invokeinterface 446 1 0
    //   506: ifeq +215 -> 721
    //   509: aload 7
    //   511: invokeinterface 450 1 0
    //   516: checkcast 1091	java/util/Map$Entry
    //   519: astore 8
    //   521: new 262	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 1254
    //   531: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 8
    //   536: invokeinterface 1094 1 0
    //   541: checkcast 86	java/lang/String
    //   544: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: ldc_w 977
    //   550: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 8
    //   555: invokeinterface 1097 1 0
    //   560: invokevirtual 1252	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: pop
    //   567: aload 4
    //   569: aload 8
    //   571: invokeinterface 1094 1 0
    //   576: checkcast 86	java/lang/String
    //   579: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   582: new 262	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 1256
    //   592: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload 8
    //   597: invokeinterface 1094 1 0
    //   602: checkcast 86	java/lang/String
    //   605: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: pop
    //   612: aload 4
    //   614: aload 8
    //   616: invokeinterface 1097 1 0
    //   621: checkcast 474	java/util/List
    //   624: invokeinterface 480 1 0
    //   629: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   632: aload 8
    //   634: invokeinterface 1097 1 0
    //   639: checkcast 474	java/util/List
    //   642: invokeinterface 869 1 0
    //   647: astore 8
    //   649: aload 8
    //   651: invokeinterface 446 1 0
    //   656: ifeq -157 -> 499
    //   659: aload 8
    //   661: invokeinterface 450 1 0
    //   666: checkcast 86	java/lang/String
    //   669: astore 9
    //   671: aload 4
    //   673: aload 9
    //   675: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   678: new 262	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   685: ldc_w 1258
    //   688: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload 9
    //   693: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: pop
    //   700: goto -51 -> 649
    //   703: astore_3
    //   704: aload 4
    //   706: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   709: aload_3
    //   710: athrow
    //   711: astore_3
    //   712: aload_0
    //   713: monitorexit
    //   714: aload_3
    //   715: athrow
    //   716: iconst_0
    //   717: istore_1
    //   718: goto -301 -> 417
    //   721: aload 4
    //   723: iconst_0
    //   724: invokevirtual 1084	java/io/DataOutputStream:writeBoolean	(Z)V
    //   727: aload_0
    //   728: getfield 431	com/flurry/android/FlurryAgent:bt	Ljava/util/Map;
    //   731: ifnull +348 -> 1079
    //   734: aload_0
    //   735: getfield 431	com/flurry/android/FlurryAgent:bt	Ljava/util/Map;
    //   738: invokeinterface 1244 1 0
    //   743: invokeinterface 1245 1 0
    //   748: istore_1
    //   749: new 262	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   756: ldc_w 1260
    //   759: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: iload_1
    //   763: invokevirtual 557	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   766: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: pop
    //   770: aload 4
    //   772: iload_1
    //   773: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   776: aload_0
    //   777: getfield 431	com/flurry/android/FlurryAgent:bt	Ljava/util/Map;
    //   780: ifnull +177 -> 957
    //   783: aload_0
    //   784: getfield 431	com/flurry/android/FlurryAgent:bt	Ljava/util/Map;
    //   787: invokeinterface 1089 1 0
    //   792: invokeinterface 441 1 0
    //   797: astore 7
    //   799: aload 7
    //   801: invokeinterface 446 1 0
    //   806: ifeq +151 -> 957
    //   809: aload 7
    //   811: invokeinterface 450 1 0
    //   816: checkcast 1091	java/util/Map$Entry
    //   819: astore 8
    //   821: new 262	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   828: ldc_w 1262
    //   831: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload 8
    //   836: invokeinterface 1094 1 0
    //   841: checkcast 86	java/lang/String
    //   844: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: pop
    //   851: aload 4
    //   853: aload 8
    //   855: invokeinterface 1094 1 0
    //   860: checkcast 86	java/lang/String
    //   863: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   866: aload 4
    //   868: aload 8
    //   870: invokeinterface 1097 1 0
    //   875: checkcast 474	java/util/List
    //   878: invokeinterface 480 1 0
    //   883: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   886: aload 8
    //   888: invokeinterface 1097 1 0
    //   893: checkcast 474	java/util/List
    //   896: invokeinterface 869 1 0
    //   901: astore 8
    //   903: aload 8
    //   905: invokeinterface 446 1 0
    //   910: ifeq -111 -> 799
    //   913: aload 8
    //   915: invokeinterface 450 1 0
    //   920: checkcast 86	java/lang/String
    //   923: astore 9
    //   925: aload 4
    //   927: aload 9
    //   929: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   932: new 262	java/lang/StringBuilder
    //   935: dup
    //   936: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   939: ldc_w 1264
    //   942: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: aload 9
    //   947: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   953: pop
    //   954: goto -51 -> 903
    //   957: aload_0
    //   958: getfield 157	com/flurry/android/FlurryAgent:ba	Ljava/util/List;
    //   961: invokeinterface 480 1 0
    //   966: istore_2
    //   967: aload 4
    //   969: iload_2
    //   970: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   973: iconst_0
    //   974: istore_1
    //   975: iload_1
    //   976: iload_2
    //   977: if_icmpge +28 -> 1005
    //   980: aload 4
    //   982: aload_0
    //   983: getfield 157	com/flurry/android/FlurryAgent:ba	Ljava/util/List;
    //   986: iload_1
    //   987: invokeinterface 631 2 0
    //   992: checkcast 1266	[B
    //   995: invokevirtual 1122	java/io/DataOutputStream:write	([B)V
    //   998: iload_1
    //   999: iconst_1
    //   1000: iadd
    //   1001: istore_1
    //   1002: goto -27 -> 975
    //   1005: aload_0
    //   1006: new 154	java/util/ArrayList
    //   1009: dup
    //   1010: aload_0
    //   1011: getfield 157	com/flurry/android/FlurryAgent:ba	Ljava/util/List;
    //   1014: invokespecial 464	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   1017: putfield 765	com/flurry/android/FlurryAgent:aU	Ljava/util/List;
    //   1020: aload 6
    //   1022: iconst_0
    //   1023: invokevirtual 1269	java/security/DigestOutputStream:on	(Z)V
    //   1026: aload 4
    //   1028: aload_3
    //   1029: invokevirtual 1272	com/flurry/android/CrcMessageDigest:getDigest	()[B
    //   1032: invokevirtual 1122	java/io/DataOutputStream:write	([B)V
    //   1035: aload 4
    //   1037: invokevirtual 1275	java/io/DataOutputStream:close	()V
    //   1040: aload 5
    //   1042: invokevirtual 1128	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1045: astore_3
    //   1046: aload 4
    //   1048: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   1051: goto -787 -> 264
    //   1054: astore_3
    //   1055: aconst_null
    //   1056: astore 4
    //   1058: goto -354 -> 704
    //   1061: astore 5
    //   1063: aload_3
    //   1064: astore 4
    //   1066: aload 5
    //   1068: astore_3
    //   1069: goto -365 -> 704
    //   1072: astore 4
    //   1074: aconst_null
    //   1075: astore_3
    //   1076: goto -828 -> 248
    //   1079: iconst_0
    //   1080: istore_1
    //   1081: goto -332 -> 749
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1084	0	this	FlurryAgent
    //   416	665	1	i	int
    //   966	12	2	j	int
    //   9	258	3	localObject1	Object
    //   703	7	3	localObject2	Object
    //   711	318	3	localObject3	Object
    //   1045	1	3	arrayOfByte	byte[]
    //   1054	10	3	localObject4	Object
    //   1068	8	3	localObject5	Object
    //   40	1025	4	localObject6	Object
    //   1072	1	4	localThrowable1	Throwable
    //   17	7	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   239	802	5	localThrowable2	Throwable
    //   1061	6	5	localObject7	Object
    //   29	992	6	localDigestOutputStream	java.security.DigestOutputStream
    //   164	646	7	localIterator	Iterator
    //   186	728	8	localObject8	Object
    //   669	277	9	str	String
    // Exception table:
    //   from	to	target	type
    //   42	166	239	java/lang/Throwable
    //   166	236	239	java/lang/Throwable
    //   268	417	239	java/lang/Throwable
    //   417	438	239	java/lang/Throwable
    //   442	470	239	java/lang/Throwable
    //   470	499	239	java/lang/Throwable
    //   499	649	239	java/lang/Throwable
    //   649	700	239	java/lang/Throwable
    //   721	749	239	java/lang/Throwable
    //   749	799	239	java/lang/Throwable
    //   799	903	239	java/lang/Throwable
    //   903	954	239	java/lang/Throwable
    //   957	973	239	java/lang/Throwable
    //   980	998	239	java/lang/Throwable
    //   1005	1046	239	java/lang/Throwable
    //   42	166	703	finally
    //   166	236	703	finally
    //   268	417	703	finally
    //   417	438	703	finally
    //   442	470	703	finally
    //   470	499	703	finally
    //   499	649	703	finally
    //   649	700	703	finally
    //   721	749	703	finally
    //   749	799	703	finally
    //   799	903	703	finally
    //   903	954	703	finally
    //   957	973	703	finally
    //   980	998	703	finally
    //   1005	1046	703	finally
    //   258	262	711	finally
    //   704	711	711	finally
    //   1046	1051	711	finally
    //   2	42	1054	finally
    //   248	258	1061	finally
    //   2	42	1072	java/lang/Throwable
  }
  
  private static String r()
  {
    if (aw != null) {
      return aw;
    }
    if (aD) {
      return ax;
    }
    if (aC) {
      return ay;
    }
    return ax;
  }
  
  private void s()
  {
    for (;;)
    {
      try
      {
        db.c("FlurryAgent", "generating report");
        Object localObject = q();
        if (localObject != null)
        {
          if (a((byte[])localObject))
          {
            StringBuilder localStringBuilder = new StringBuilder().append("Done sending ");
            if (!this.aM) {
              break label103;
            }
            localObject = "initial ";
            db.c("FlurryAgent", (String)localObject + "agent report");
            u();
          }
        }
        else
        {
          db.c("FlurryAgent", "Error generating report");
          return;
        }
      }
      catch (IOException localIOException)
      {
        db.a("FlurryAgent", "", localIOException);
        return;
      }
      catch (Throwable localThrowable)
      {
        db.b("FlurryAgent", "", localThrowable);
      }
      return;
      label103:
      String str = "";
    }
  }
  
  public static void setAge(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 110))
    {
      Date localDate = new Date(new Date(System.currentTimeMillis() - paramInt * 31449600000L).getYear(), 1, 1);
      az.bj = Long.valueOf(localDate.getTime());
    }
  }
  
  public static void setCaptureUncaughtExceptions(boolean paramBoolean)
  {
    synchronized (az)
    {
      if (az.aM)
      {
        db.d("FlurryAgent", "Cannot setCaptureUncaughtExceptions after onStartSession");
        return;
      }
      aE = paramBoolean;
      return;
    }
  }
  
  public static void setContinueSessionMillis(long paramLong)
  {
    if (paramLong < 5000L)
    {
      db.d("FlurryAgent", "Invalid time set for session resumption: " + paramLong);
      return;
    }
    synchronized (az)
    {
      aA = paramLong;
      return;
    }
  }
  
  public static void setGender(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      az.bi = -1;
      return;
    }
    az.bi = paramByte;
  }
  
  public static void setLocationCriteria(Criteria paramCriteria)
  {
    synchronized (az)
    {
      aF = paramCriteria;
      return;
    }
  }
  
  public static void setLogEnabled(boolean paramBoolean)
  {
    localFlurryAgent = az;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        db.ax();
        return;
      }
      finally {}
      db.aw();
    }
  }
  
  public static void setLogEvents(boolean paramBoolean)
  {
    synchronized (az)
    {
      aB = paramBoolean;
      return;
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    synchronized (az)
    {
      db.setLogLevel(paramInt);
      return;
    }
  }
  
  public static void setReportLocation(boolean paramBoolean)
  {
    synchronized (az)
    {
      az.aT = paramBoolean;
      return;
    }
  }
  
  public static void setReportUrl(String paramString)
  {
    if (paramString != null) {
      paramString.endsWith(".do");
    }
    aw = paramString;
  }
  
  public static void setUseHttps(boolean paramBoolean)
  {
    aC = paramBoolean;
  }
  
  public static void setUserId(String paramString)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String userId passed to setUserId was null.");
      return;
    }
    synchronized (az)
    {
      az.bh = bd.sanitize(paramString);
      return;
    }
  }
  
  public static void setVersionName(String paramString)
  {
    if (paramString == null)
    {
      db.d("FlurryAgent", "String versionName passed to setVersionName was null.");
      return;
    }
    synchronized (az)
    {
      az.aS = paramString;
      return;
    }
  }
  
  private void t()
  {
    if (this.aL.exists())
    {
      db.e("FlurryAgent", "Loading referrer info from file:  " + this.aL.getAbsolutePath());
      String str = a(this.aL);
      if (str != null) {
        this.bs = e(str);
      }
    }
  }
  
  /* Error */
  private void u()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 134	com/flurry/android/FlurryAgent:aK	Ljava/io/File;
    //   6: invokestatic 847	com/flurry/android/bc:b	(Ljava/io/File;)Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifne +10 -> 21
    //   14: aconst_null
    //   15: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: new 849	java/io/DataOutputStream
    //   24: dup
    //   25: new 851	java/io/FileOutputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 134	com/flurry/android/FlurryAgent:aK	Ljava/io/File;
    //   33: invokespecial 852	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: invokespecial 855	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   39: astore 5
    //   41: aload 5
    //   43: astore 4
    //   45: aload 5
    //   47: ldc_w 789
    //   50: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   53: aload 5
    //   55: astore 4
    //   57: aload 5
    //   59: iconst_2
    //   60: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   63: aload 5
    //   65: astore 4
    //   67: aload 5
    //   69: aload_0
    //   70: getfield 256	com/flurry/android/FlurryAgent:aQ	Ljava/lang/String;
    //   73: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   76: aload 5
    //   78: astore 4
    //   80: aload 5
    //   82: aload_0
    //   83: invokespecial 505	com/flurry/android/FlurryAgent:id	()Ljava/lang/String;
    //   86: invokevirtual 861	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   89: aload 5
    //   91: astore 4
    //   93: aload 5
    //   95: aload_0
    //   96: getfield 575	com/flurry/android/FlurryAgent:aY	Z
    //   99: invokevirtual 1084	java/io/DataOutputStream:writeBoolean	(Z)V
    //   102: aload 5
    //   104: astore 4
    //   106: aload 5
    //   108: aload_0
    //   109: getfield 580	com/flurry/android/FlurryAgent:aZ	J
    //   112: invokevirtual 1077	java/io/DataOutputStream:writeLong	(J)V
    //   115: aload 5
    //   117: astore 4
    //   119: aload_0
    //   120: getfield 157	com/flurry/android/FlurryAgent:ba	Ljava/util/List;
    //   123: invokeinterface 480 1 0
    //   128: iconst_1
    //   129: isub
    //   130: istore_1
    //   131: iload_1
    //   132: iflt +78 -> 210
    //   135: aload 5
    //   137: astore 4
    //   139: aload_0
    //   140: getfield 157	com/flurry/android/FlurryAgent:ba	Ljava/util/List;
    //   143: iload_1
    //   144: invokeinterface 631 2 0
    //   149: checkcast 1266	[B
    //   152: astore 6
    //   154: aload 5
    //   156: astore 4
    //   158: aload 6
    //   160: arraylength
    //   161: istore_2
    //   162: aload 5
    //   164: astore 4
    //   166: iload_2
    //   167: iconst_2
    //   168: iadd
    //   169: aload 5
    //   171: invokevirtual 1352	java/io/DataOutputStream:size	()I
    //   174: iadd
    //   175: ldc_w 1353
    //   178: if_icmple +57 -> 235
    //   181: aload 5
    //   183: astore 4
    //   185: ldc -69
    //   187: new 262	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 1355
    //   197: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload_1
    //   201: invokevirtual 557	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 293	com/flurry/android/db:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 5
    //   212: astore 4
    //   214: aload 5
    //   216: iconst_0
    //   217: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   220: aload 5
    //   222: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   225: goto -207 -> 18
    //   228: astore 4
    //   230: aload_0
    //   231: monitorexit
    //   232: aload 4
    //   234: athrow
    //   235: aload 5
    //   237: astore 4
    //   239: aload 5
    //   241: iload_2
    //   242: invokevirtual 1074	java/io/DataOutputStream:writeShort	(I)V
    //   245: aload 5
    //   247: astore 4
    //   249: aload 5
    //   251: aload 6
    //   253: invokevirtual 1122	java/io/DataOutputStream:write	([B)V
    //   256: iload_1
    //   257: iconst_1
    //   258: isub
    //   259: istore_1
    //   260: goto -129 -> 131
    //   263: astore 6
    //   265: aconst_null
    //   266: astore 5
    //   268: aload 5
    //   270: astore 4
    //   272: ldc -69
    //   274: ldc -97
    //   276: aload 6
    //   278: invokestatic 244	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload 5
    //   283: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   286: goto -268 -> 18
    //   289: aload 4
    //   291: invokestatic 249	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   294: aload 5
    //   296: athrow
    //   297: astore 5
    //   299: goto -10 -> 289
    //   302: astore 6
    //   304: goto -36 -> 268
    //   307: astore 5
    //   309: aconst_null
    //   310: astore 4
    //   312: goto -23 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	FlurryAgent
    //   130	130	1	i	int
    //   161	81	2	j	int
    //   9	2	3	bool	boolean
    //   43	170	4	localDataOutputStream1	java.io.DataOutputStream
    //   228	5	4	localObject1	Object
    //   237	74	4	localDataOutputStream2	java.io.DataOutputStream
    //   39	256	5	localDataOutputStream3	java.io.DataOutputStream
    //   297	1	5	localObject2	Object
    //   307	1	5	localObject3	Object
    //   152	100	6	arrayOfByte	byte[]
    //   263	14	6	localThrowable1	Throwable
    //   302	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	18	228	finally
    //   220	225	228	finally
    //   281	286	228	finally
    //   289	297	228	finally
    //   2	10	263	java/lang/Throwable
    //   21	41	263	java/lang/Throwable
    //   45	53	297	finally
    //   57	63	297	finally
    //   67	76	297	finally
    //   80	89	297	finally
    //   93	102	297	finally
    //   106	115	297	finally
    //   119	131	297	finally
    //   139	154	297	finally
    //   158	162	297	finally
    //   166	181	297	finally
    //   185	210	297	finally
    //   214	220	297	finally
    //   239	245	297	finally
    //   249	256	297	finally
    //   272	281	297	finally
    //   45	53	302	java/lang/Throwable
    //   57	63	302	java/lang/Throwable
    //   67	76	302	java/lang/Throwable
    //   80	89	302	java/lang/Throwable
    //   93	102	302	java/lang/Throwable
    //   106	115	302	java/lang/Throwable
    //   119	131	302	java/lang/Throwable
    //   139	154	302	java/lang/Throwable
    //   158	162	302	java/lang/Throwable
    //   166	181	302	java/lang/Throwable
    //   185	210	302	java/lang/Throwable
    //   214	220	302	java/lang/Throwable
    //   239	245	302	java/lang/Throwable
    //   249	256	302	java/lang/Throwable
    //   2	10	307	finally
    //   21	41	307	finally
  }
  
  private void v()
  {
    try
    {
      if (this.aV != null) {
        this.aV.removeUpdates(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static String w()
  {
    return az.aQ;
  }
  
  static String x()
  {
    return az.bf;
  }
  
  final void a(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    Object localObject = "";
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    if ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length > 0))
    {
      localObject = new StringBuilder();
      if (paramThrowable.getMessage() != null) {
        ((StringBuilder)localObject).append(" (" + paramThrowable.getMessage() + ")\n");
      }
      localObject = ((StringBuilder)localObject).toString();
    }
    for (;;)
    {
      onError("uncaught", (String)localObject, paramThrowable);
      this.aP.clear();
      a(null, true);
      return;
      if (paramThrowable.getMessage() != null) {
        localObject = paramThrowable.getMessage();
      }
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    try
    {
      this.bl = paramLocation;
      v();
      return;
    }
    catch (Throwable paramLocation)
    {
      for (;;)
      {
        db.b("FlurryAgent", "", paramLocation);
      }
    }
    finally {}
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/FlurryAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */