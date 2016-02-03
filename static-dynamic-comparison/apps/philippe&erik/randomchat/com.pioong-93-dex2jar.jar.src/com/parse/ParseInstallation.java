package com.parse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@ParseClassName("_Installation")
public class ParseInstallation
  extends ParseObject
{
  private static final String STORAGE_LOCATION = "currentInstallation";
  private static final String TAG = "com.parse.ParseInstallation";
  static ParseInstallation currentInstallation = null;
  private static final List<String> readonlyFields = Arrays.asList(new String[] { "deviceType", "installationId", "deviceToken", "timeZone", "appVersion", "appName", "parseVersion" });
  
  static void clearCurrentInstallationFromDisk(Context paramContext)
  {
    try
    {
      currentInstallation = null;
      ParseObject.deleteDiskObject(paramContext, "currentInstallation");
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void clearCurrentInstallationFromMemory()
  {
    try
    {
      currentInstallation = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static ParseInstallation getCurrentInstallation()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/parse/ParseInstallation:currentInstallation	Lcom/parse/ParseInstallation;
    //   6: ifnull +12 -> 18
    //   9: getstatic 28	com/parse/ParseInstallation:currentInstallation	Lcom/parse/ParseInstallation;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: getstatic 82	com/parse/Parse:applicationContext	Landroid/content/Context;
    //   21: ldc 17
    //   23: invokestatic 86	com/parse/ParseInstallation:getFromDisk	(Landroid/content/Context;Ljava/lang/String;)Lcom/parse/ParseObject;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnonnull +21 -> 49
    //   31: ldc 2
    //   33: invokestatic 90	com/parse/ParseObject:create	(Ljava/lang/Class;)Lcom/parse/ParseObject;
    //   36: checkcast 2	com/parse/ParseInstallation
    //   39: putstatic 28	com/parse/ParseInstallation:currentInstallation	Lcom/parse/ParseInstallation;
    //   42: getstatic 28	com/parse/ParseInstallation:currentInstallation	Lcom/parse/ParseInstallation;
    //   45: astore_0
    //   46: goto -33 -> 13
    //   49: aload_0
    //   50: checkcast 2	com/parse/ParseInstallation
    //   53: putstatic 28	com/parse/ParseInstallation:currentInstallation	Lcom/parse/ParseInstallation;
    //   56: ldc 20
    //   58: ldc 92
    //   60: invokestatic 96	com/parse/Parse:logV	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: goto -21 -> 42
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	38	0	localObject1	Object
    //   66	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	66	finally
    //   18	27	66	finally
    //   31	42	66	finally
    //   42	46	66	finally
    //   49	63	66	finally
  }
  
  /* Error */
  private static String getOrCreateCurrentInstallationId()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/parse/ParseInstallation:currentInstallation	Lcom/parse/ParseInstallation;
    //   6: ifnull +15 -> 21
    //   9: getstatic 28	com/parse/ParseInstallation:currentInstallation	Lcom/parse/ParseInstallation;
    //   12: invokevirtual 103	com/parse/ParseInstallation:getInstallationId	()Ljava/lang/String;
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: new 105	java/io/File
    //   24: dup
    //   25: invokestatic 109	com/parse/Parse:getParseDir	()Ljava/io/File;
    //   28: ldc 34
    //   30: invokespecial 112	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore 4
    //   35: aconst_null
    //   36: astore_2
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_2
    //   40: astore_0
    //   41: aload 4
    //   43: invokevirtual 116	java/io/File:exists	()Z
    //   46: ifne +64 -> 110
    //   49: aload_2
    //   50: astore_0
    //   51: invokestatic 122	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   54: invokevirtual 125	java/util/UUID:toString	()Ljava/lang/String;
    //   57: astore_3
    //   58: aload_2
    //   59: astore_0
    //   60: new 127	java/io/RandomAccessFile
    //   63: dup
    //   64: aload 4
    //   66: ldc -127
    //   68: invokespecial 130	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore_2
    //   72: aload_2
    //   73: astore_0
    //   74: aload_2
    //   75: astore_1
    //   76: aload_2
    //   77: aload_3
    //   78: invokevirtual 134	java/io/RandomAccessFile:writeBytes	(Ljava/lang/String;)V
    //   81: aload_2
    //   82: astore_0
    //   83: aload_2
    //   84: astore_1
    //   85: aload_2
    //   86: invokevirtual 137	java/io/RandomAccessFile:close	()V
    //   89: aload_3
    //   90: astore_0
    //   91: aload_2
    //   92: ifnull -76 -> 16
    //   95: aload_2
    //   96: invokevirtual 137	java/io/RandomAccessFile:close	()V
    //   99: aload_3
    //   100: astore_0
    //   101: goto -85 -> 16
    //   104: astore_0
    //   105: aload_3
    //   106: astore_0
    //   107: goto -91 -> 16
    //   110: aload_2
    //   111: astore_0
    //   112: ldc 20
    //   114: ldc -117
    //   116: invokestatic 96	com/parse/Parse:logV	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_2
    //   120: astore_0
    //   121: new 127	java/io/RandomAccessFile
    //   124: dup
    //   125: aload 4
    //   127: ldc -115
    //   129: invokespecial 130	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   132: astore_2
    //   133: aload_2
    //   134: astore_0
    //   135: aload_2
    //   136: astore_1
    //   137: aload_2
    //   138: invokevirtual 145	java/io/RandomAccessFile:length	()J
    //   141: l2i
    //   142: newarray <illegal type>
    //   144: astore_3
    //   145: aload_2
    //   146: astore_0
    //   147: aload_2
    //   148: astore_1
    //   149: aload_2
    //   150: aload_3
    //   151: invokevirtual 149	java/io/RandomAccessFile:readFully	([B)V
    //   154: aload_2
    //   155: astore_0
    //   156: aload_2
    //   157: astore_1
    //   158: new 30	java/lang/String
    //   161: dup
    //   162: aload_3
    //   163: invokespecial 151	java/lang/String:<init>	([B)V
    //   166: astore_3
    //   167: aload_3
    //   168: astore_0
    //   169: aload_2
    //   170: ifnull -154 -> 16
    //   173: aload_2
    //   174: invokevirtual 137	java/io/RandomAccessFile:close	()V
    //   177: aload_3
    //   178: astore_0
    //   179: goto -163 -> 16
    //   182: astore_0
    //   183: aload_3
    //   184: astore_0
    //   185: goto -169 -> 16
    //   188: astore_0
    //   189: aload_1
    //   190: astore_0
    //   191: invokestatic 122	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   194: invokevirtual 125	java/util/UUID:toString	()Ljava/lang/String;
    //   197: astore_2
    //   198: aload_2
    //   199: astore_0
    //   200: aload_1
    //   201: ifnull -185 -> 16
    //   204: aload_1
    //   205: invokevirtual 137	java/io/RandomAccessFile:close	()V
    //   208: aload_2
    //   209: astore_0
    //   210: goto -194 -> 16
    //   213: astore_0
    //   214: aload_2
    //   215: astore_0
    //   216: goto -200 -> 16
    //   219: astore_1
    //   220: aload_0
    //   221: ifnull +7 -> 228
    //   224: aload_0
    //   225: invokevirtual 137	java/io/RandomAccessFile:close	()V
    //   228: aload_1
    //   229: athrow
    //   230: astore_0
    //   231: ldc 2
    //   233: monitorexit
    //   234: aload_0
    //   235: athrow
    //   236: astore_0
    //   237: goto -9 -> 228
    //   240: astore_1
    //   241: goto -21 -> 220
    //   244: astore_0
    //   245: goto -56 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	86	0	localObject1	Object
    //   104	1	0	localIOException1	java.io.IOException
    //   106	73	0	localObject2	Object
    //   182	1	0	localIOException2	java.io.IOException
    //   184	1	0	localObject3	Object
    //   188	1	0	localIOException3	java.io.IOException
    //   190	20	0	localObject4	Object
    //   213	1	0	localIOException4	java.io.IOException
    //   215	10	0	localObject5	Object
    //   230	5	0	localObject6	Object
    //   236	1	0	localIOException5	java.io.IOException
    //   244	1	0	localIOException6	java.io.IOException
    //   38	167	1	localObject7	Object
    //   219	10	1	localObject8	Object
    //   240	1	1	localObject9	Object
    //   36	179	2	localObject10	Object
    //   57	127	3	localObject11	Object
    //   33	93	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   95	99	104	java/io/IOException
    //   173	177	182	java/io/IOException
    //   41	49	188	java/io/IOException
    //   51	58	188	java/io/IOException
    //   60	72	188	java/io/IOException
    //   112	119	188	java/io/IOException
    //   121	133	188	java/io/IOException
    //   204	208	213	java/io/IOException
    //   41	49	219	finally
    //   51	58	219	finally
    //   60	72	219	finally
    //   112	119	219	finally
    //   121	133	219	finally
    //   191	198	219	finally
    //   3	16	230	finally
    //   21	35	230	finally
    //   95	99	230	finally
    //   173	177	230	finally
    //   204	208	230	finally
    //   224	228	230	finally
    //   228	230	230	finally
    //   224	228	236	java/io/IOException
    //   76	81	240	finally
    //   85	89	240	finally
    //   137	145	240	finally
    //   149	154	240	finally
    //   158	167	240	finally
    //   76	81	244	java/io/IOException
    //   85	89	244	java/io/IOException
    //   137	145	244	java/io/IOException
    //   149	154	244	java/io/IOException
    //   158	167	244	java/io/IOException
  }
  
  public static ParseQuery<ParseInstallation> getQuery()
  {
    return ParseQuery.getQuery(ParseInstallation.class);
  }
  
  private static void maybeFlushToDisk(ParseInstallation paramParseInstallation)
  {
    try
    {
      if (currentInstallation == paramParseInstallation) {
        paramParseInstallation.saveToDisk(Parse.applicationContext, "currentInstallation");
      }
      return;
    }
    finally
    {
      paramParseInstallation = finally;
      throw paramParseInstallation;
    }
  }
  
  private void updateTimezone()
  {
    String str = TimeZone.getDefault().getID();
    if (((str.indexOf('/') > 0) || (str.equals("GMT"))) && (!str.equals(get("timeZone")))) {
      super.put("timeZone", str);
    }
  }
  
  private void updateVersionInfo()
  {
    int j = 0;
    for (;;)
    {
      int i;
      synchronized (this.mutex)
      {
        try
        {
          String str2 = Parse.applicationContext.getPackageName();
          PackageManager localPackageManager = Parse.applicationContext.getPackageManager();
          str1 = localPackageManager.getPackageInfo(str2, 0).versionName;
          str2 = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(str2, 0)).toString();
          if ((str2 == null) || (str2.equals(get("appName")))) {
            break label160;
          }
          super.put("appName", str2);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          String str1;
          Parse.logW("com.parse.ParseInstallation", "Cannot load package info; will not be saved to installation");
          continue;
        }
        if (!str1.equals(get("appVersion"))) {
          break label175;
        }
        if ((j & i) != 0) {
          super.put("appVersion", str1);
        }
        if (!"1.3.0".equals(get("parseVersion"))) {
          super.put("parseVersion", "1.3.0");
        }
        return;
      }
      label160:
      if (localObject2 != null)
      {
        i = 1;
      }
      else
      {
        i = 0;
        continue;
        label175:
        j = 1;
      }
    }
  }
  
  void checkKeyIsMutable(String paramString)
    throws IllegalArgumentException
  {
    synchronized (this.mutex)
    {
      if (readonlyFields.contains(paramString)) {
        throw new IllegalArgumentException("Cannot change " + paramString + " property of an installation object.");
      }
    }
  }
  
  <T extends ParseObject> Task<T> fetchAsync(final Task<Void> paramTask)
  {
    synchronized (this.mutex)
    {
      if (getObjectId() == null)
      {
        localTask = saveAsync(paramTask);
        paramTask = localTask.onSuccessTask(new Continuation()
        {
          public Task<T> then(Task<Void> paramAnonymousTask)
            throws Exception
          {
            return ParseInstallation.this.fetchAsync(paramTask);
          }
        }).continueWithTask(new Continuation()
        {
          public Task<T> then(Task<T> paramAnonymousTask)
            throws Exception
          {
            ParseInstallation.maybeFlushToDisk(ParseInstallation.this);
            return paramAnonymousTask;
          }
        });
        return paramTask;
      }
      Task localTask = Task.forResult(null);
    }
  }
  
  public String getInstallationId()
  {
    return getString("installationId");
  }
  
  boolean needsDefaultACL()
  {
    return false;
  }
  
  public void put(String paramString, Object paramObject)
    throws IllegalArgumentException
  {
    synchronized (this.mutex)
    {
      checkKeyIsMutable(paramString);
      super.put(paramString, paramObject);
      return;
    }
  }
  
  public void remove(String paramString)
  {
    synchronized (this.mutex)
    {
      checkKeyIsMutable(paramString);
      super.remove(paramString);
      return;
    }
  }
  
  Task<Void> saveAsync(Task<Void> paramTask)
  {
    synchronized (this.mutex)
    {
      updateTimezone();
      updateVersionInfo();
      super.put("installationId", getOrCreateCurrentInstallationId());
      super.put("deviceType", "android");
      paramTask = super.saveAsync(paramTask).onSuccessTask(new Continuation()
      {
        public Task<Void> then(Task<Void> paramAnonymousTask)
          throws Exception
        {
          ParseInstallation.maybeFlushToDisk(ParseInstallation.this);
          return paramAnonymousTask;
        }
      });
      return paramTask;
    }
  }
  
  public void saveEventually(SaveCallback paramSaveCallback)
  {
    synchronized (this.mutex)
    {
      updateTimezone();
      updateVersionInfo();
      super.put("installationId", getOrCreateCurrentInstallationId());
      super.put("deviceType", "android");
      super.saveEventually(paramSaveCallback);
      return;
    }
  }
  
  void setDefaultValues()
  {
    super.setDefaultValues();
    super.put("deviceType", "android");
    super.put("installationId", getOrCreateCurrentInstallationId());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseInstallation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */