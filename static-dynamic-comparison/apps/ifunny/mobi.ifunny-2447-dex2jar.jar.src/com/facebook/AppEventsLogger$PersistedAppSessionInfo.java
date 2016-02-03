package com.facebook;

import android.content.Context;

import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class AppEventsLogger$PersistedAppSessionInfo {
    private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
    private static final Runnable appSessionInfoFlushRunnable = new AppEventsLogger.PersistedAppSessionInfo
    .1();
    private static Map<AppEventsLogger.AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
    private static boolean hasChanges;
    private static boolean isLoaded;
    private static final Object staticLock = new Object();

    static {
        hasChanges = false;
        isLoaded = false;
    }

    private static FacebookTimeSpentData getTimeSpentData(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair) {
        restoreAppSessionInformation(paramContext);
        FacebookTimeSpentData localFacebookTimeSpentData = (FacebookTimeSpentData) appSessionInfoMap.get(paramAccessTokenAppIdPair);
        paramContext = localFacebookTimeSpentData;
        if (localFacebookTimeSpentData == null) {
            paramContext = new FacebookTimeSpentData();
            appSessionInfoMap.put(paramAccessTokenAppIdPair, paramContext);
        }
        return paramContext;
    }

    static void onResume(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong, String paramString) {
        synchronized (staticLock) {
            getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onResume(paramAppEventsLogger, paramLong, paramString);
            onTimeSpentDataUpdate();
            return;
        }
    }

    static void onSuspend(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong) {
        synchronized (staticLock) {
            getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onSuspend(paramAppEventsLogger, paramLong);
            onTimeSpentDataUpdate();
            return;
        }
    }

    private static void onTimeSpentDataUpdate() {
        if (!hasChanges) {
            hasChanges = true;
            AppEventsLogger.access$1400().schedule(appSessionInfoFlushRunnable, 30L, TimeUnit.SECONDS);
        }
    }

    /* Error */
    private static void restoreAppSessionInformation(Context paramContext) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 25	com/facebook/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
        //   5: astore 5
        //   7: aload 5
        //   9: monitorenter
        //   10: getstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
        //   13: istore_1
        //   14: iload_1
        //   15: ifne +76 -> 91
        //   18: new 97	java/io/ObjectInputStream
        //   21: dup
        //   22: aload_0
        //   23: ldc 8
        //   25: invokevirtual 103	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
        //   28: invokespecial 106	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
        //   31: astore_2
        //   32: aload_2
        //   33: astore_3
        //   34: aload_2
        //   35: invokevirtual 110	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   38: checkcast 112	java/util/HashMap
        //   41: putstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   44: aload_2
        //   45: astore_3
        //   46: getstatic 118	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
        //   49: ldc 120
        //   51: ldc 122
        //   53: invokestatic 128	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
        //   56: aload_2
        //   57: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   60: aload_0
        //   61: ldc 8
        //   63: invokevirtual 138	android/content/Context:deleteFile	(Ljava/lang/String;)Z
        //   66: pop
        //   67: getstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   70: ifnonnull +13 -> 83
        //   73: new 112	java/util/HashMap
        //   76: dup
        //   77: invokespecial 139	java/util/HashMap:<init>	()V
        //   80: putstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   83: iconst_1
        //   84: putstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
        //   87: iconst_0
        //   88: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
        //   91: aload 5
        //   93: monitorexit
        //   94: return
        //   95: aload_2
        //   96: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   99: aload_0
        //   100: ldc 8
        //   102: invokevirtual 138	android/content/Context:deleteFile	(Ljava/lang/String;)Z
        //   105: pop
        //   106: getstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   109: ifnonnull +13 -> 122
        //   112: new 112	java/util/HashMap
        //   115: dup
        //   116: invokespecial 139	java/util/HashMap:<init>	()V
        //   119: putstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   122: iconst_1
        //   123: putstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
        //   126: iconst_0
        //   127: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
        //   130: goto -39 -> 91
        //   133: astore_0
        //   134: aload 5
        //   136: monitorexit
        //   137: aload_0
        //   138: athrow
        //   139: astore 4
        //   141: aconst_null
        //   142: astore_2
        //   143: aload_2
        //   144: astore_3
        //   145: invokestatic 143	com/facebook/AppEventsLogger:access$1300	()Ljava/lang/String;
        //   148: new 145	java/lang/StringBuilder
        //   151: dup
        //   152: invokespecial 146	java/lang/StringBuilder:<init>	()V
        //   155: ldc -108
        //   157: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   160: aload 4
        //   162: invokevirtual 155	java/lang/Exception:toString	()Ljava/lang/String;
        //   165: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   168: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   171: invokestatic 162	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   174: pop
        //   175: aload_2
        //   176: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   179: aload_0
        //   180: ldc 8
        //   182: invokevirtual 138	android/content/Context:deleteFile	(Ljava/lang/String;)Z
        //   185: pop
        //   186: getstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   189: ifnonnull +13 -> 202
        //   192: new 112	java/util/HashMap
        //   195: dup
        //   196: invokespecial 139	java/util/HashMap:<init>	()V
        //   199: putstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   202: iconst_1
        //   203: putstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
        //   206: iconst_0
        //   207: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
        //   210: goto -119 -> 91
        //   213: aload_3
        //   214: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   217: aload_0
        //   218: ldc 8
        //   220: invokevirtual 138	android/content/Context:deleteFile	(Ljava/lang/String;)Z
        //   223: pop
        //   224: getstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   227: ifnonnull +13 -> 240
        //   230: new 112	java/util/HashMap
        //   233: dup
        //   234: invokespecial 139	java/util/HashMap:<init>	()V
        //   237: putstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   240: iconst_1
        //   241: putstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
        //   244: iconst_0
        //   245: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
        //   248: aload_2
        //   249: athrow
        //   250: astore_2
        //   251: goto -38 -> 213
        //   254: astore 4
        //   256: goto -113 -> 143
        //   259: astore_3
        //   260: goto -165 -> 95
        //   263: astore_2
        //   264: aload_3
        //   265: astore_2
        //   266: goto -171 -> 95
        //   269: astore_2
        //   270: aconst_null
        //   271: astore_3
        //   272: goto -59 -> 213
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	275	0	paramContext	Context
        //   13	2	1	bool	boolean
        //   31	218	2	localObjectInputStream	java.io.ObjectInputStream
        //   250	1	2	localObject1	Object
        //   263	1	2	localFileNotFoundException1	java.io.FileNotFoundException
        //   265	1	2	localFileNotFoundException2	java.io.FileNotFoundException
        //   269	1	2	localObject2	Object
        //   1	213	3	localObject3	Object
        //   259	6	3	localFileNotFoundException3	java.io.FileNotFoundException
        //   271	1	3	localObject4	Object
        //   139	22	4	localException1	Exception
        //   254	1	4	localException2	Exception
        //   5	130	5	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   10	14	133	finally
        //   56	83	133	finally
        //   83	91	133	finally
        //   91	94	133	finally
        //   95	122	133	finally
        //   122	130	133	finally
        //   134	137	133	finally
        //   175	202	133	finally
        //   202	210	133	finally
        //   213	240	133	finally
        //   240	250	133	finally
        //   18	32	139	java/lang/Exception
        //   34	44	250	finally
        //   46	56	250	finally
        //   145	175	250	finally
        //   34	44	254	java/lang/Exception
        //   46	56	254	java/lang/Exception
        //   34	44	259	java/io/FileNotFoundException
        //   46	56	259	java/io/FileNotFoundException
        //   18	32	263	java/io/FileNotFoundException
        //   18	32	269	finally
    }

    /* Error */
    static void saveAppSessionInformation(Context paramContext) {
        // Byte code:
        //   0: getstatic 25	com/facebook/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
        //   3: astore 4
        //   5: aload 4
        //   7: monitorenter
        //   8: getstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
        //   11: istore_1
        //   12: iload_1
        //   13: ifeq +56 -> 69
        //   16: new 165	java/io/ObjectOutputStream
        //   19: dup
        //   20: new 167	java/io/BufferedOutputStream
        //   23: dup
        //   24: aload_0
        //   25: ldc 8
        //   27: iconst_0
        //   28: invokevirtual 171	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
        //   31: invokespecial 174	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   34: invokespecial 175	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   37: astore_2
        //   38: aload_2
        //   39: astore_0
        //   40: aload_2
        //   41: getstatic 43	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
        //   44: invokevirtual 179	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
        //   47: aload_2
        //   48: astore_0
        //   49: iconst_0
        //   50: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
        //   53: aload_2
        //   54: astore_0
        //   55: getstatic 118	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
        //   58: ldc 120
        //   60: ldc -75
        //   62: invokestatic 128	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
        //   65: aload_2
        //   66: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   69: aload 4
        //   71: monitorexit
        //   72: return
        //   73: astore_3
        //   74: aconst_null
        //   75: astore_2
        //   76: aload_2
        //   77: astore_0
        //   78: invokestatic 143	com/facebook/AppEventsLogger:access$1300	()Ljava/lang/String;
        //   81: new 145	java/lang/StringBuilder
        //   84: dup
        //   85: invokespecial 146	java/lang/StringBuilder:<init>	()V
        //   88: ldc -108
        //   90: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   93: aload_3
        //   94: invokevirtual 155	java/lang/Exception:toString	()Ljava/lang/String;
        //   97: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   100: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   103: invokestatic 162	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   106: pop
        //   107: aload_2
        //   108: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   111: goto -42 -> 69
        //   114: astore_0
        //   115: aload 4
        //   117: monitorexit
        //   118: aload_0
        //   119: athrow
        //   120: astore_2
        //   121: aconst_null
        //   122: astore_0
        //   123: aload_0
        //   124: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   127: aload_2
        //   128: athrow
        //   129: astore_2
        //   130: goto -7 -> 123
        //   133: astore_3
        //   134: goto -58 -> 76
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	137	0	paramContext	Context
        //   11	2	1	bool	boolean
        //   37	71	2	localObjectOutputStream	java.io.ObjectOutputStream
        //   120	8	2	localObject1	Object
        //   129	1	2	localObject2	Object
        //   73	21	3	localException1	Exception
        //   133	1	3	localException2	Exception
        //   3	113	4	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   16	38	73	java/lang/Exception
        //   8	12	114	finally
        //   65	69	114	finally
        //   69	72	114	finally
        //   107	111	114	finally
        //   115	118	114	finally
        //   123	129	114	finally
        //   16	38	120	finally
        //   40	47	129	finally
        //   49	53	129	finally
        //   55	65	129	finally
        //   78	107	129	finally
        //   40	47	133	java/lang/Exception
        //   49	53	133	java/lang/Exception
        //   55	65	133	java/lang/Exception
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger$PersistedAppSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */