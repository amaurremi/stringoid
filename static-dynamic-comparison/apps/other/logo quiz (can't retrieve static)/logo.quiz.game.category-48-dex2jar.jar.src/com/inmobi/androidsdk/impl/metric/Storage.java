package com.inmobi.androidsdk.impl.metric;

import android.content.Context;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.Log;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Storage
{
  public static final String FILENAME_IN_CACHE = "inmobi.cache.data";
  public static final String FILENAME_IN_CACHE_EVENTS = "inmobi.cache.data.events.number";
  public static final String FILENAME_IN_CACHE_TS = "inmobi.cache.data.events.timestamp";
  static AtomicBoolean a = new AtomicBoolean(false);
  static AtomicBoolean b = new AtomicBoolean(false);
  private static Context c;
  public static long events = -1L;
  public static long timestamp = -1L;
  
  private static void a(Context paramContext)
  {
    try
    {
      FileOperations.writeStringToFile(paramContext, "inmobi.cache.data.events.number", "" + events, false);
      FileOperations.writeStringToFile(paramContext, "inmobi.cache.data.events.timestamp", "" + timestamp, false);
      return;
    }
    catch (Exception paramContext)
    {
      events = 0L;
    }
  }
  
  public static String readLocalCache(Context paramContext)
  {
    try
    {
      paramContext = FileOperations.readFileAsString(paramContext, "inmobi.cache.data");
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "null,";
  }
  
  public static void readNumberOfEventsAndTimeStampFromPersistent(Context paramContext)
  {
    c = paramContext;
    if (events != -1L) {}
    for (;;)
    {
      return;
      try
      {
        events = Long.parseLong(FileOperations.readFileAsString(paramContext, "inmobi.cache.data.events.number"));
        timestamp = Long.parseLong(FileOperations.readFileAsString(paramContext, "inmobi.cache.data.events.timestamp"));
        if (timestamp != -1L) {
          continue;
        }
        timestamp = System.currentTimeMillis() / 1000L;
        a(c);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          events = 0L;
        }
      }
    }
  }
  
  public static void resetFile(Context paramContext)
  {
    try
    {
      FileOperations.writeStringToFile(paramContext, "inmobi.cache.data", "", false);
      events = 0L;
      timestamp = System.currentTimeMillis() / 1000L;
      a(paramContext);
      return;
    }
    catch (IOException paramContext)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Someting went wrong while saving metrics log to persistent storage", paramContext);
    }
  }
  
  /* Error */
  public static void saveLocalCache(Context arg0)
  {
    // Byte code:
    //   0: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3: iconst_0
    //   4: iconst_1
    //   5: invokevirtual 113	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   8: ifne +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: ldc 8
    //   15: getstatic 119	com/inmobi/androidsdk/impl/metric/Queuer:queuer	Lcom/inmobi/androidsdk/impl/metric/Queuer;
    //   18: invokevirtual 122	com/inmobi/androidsdk/impl/metric/Queuer:get	()Ljava/lang/String;
    //   21: iconst_1
    //   22: invokestatic 68	com/inmobi/commons/internal/FileOperations:writeStringToFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   25: getstatic 28	com/inmobi/androidsdk/impl/metric/Storage:events	J
    //   28: getstatic 119	com/inmobi/androidsdk/impl/metric/Queuer:queuer	Lcom/inmobi/androidsdk/impl/metric/Queuer;
    //   31: getfield 125	com/inmobi/androidsdk/impl/metric/Queuer:number	J
    //   34: ladd
    //   35: putstatic 28	com/inmobi/androidsdk/impl/metric/Storage:events	J
    //   38: getstatic 119	com/inmobi/androidsdk/impl/metric/Queuer:queuer	Lcom/inmobi/androidsdk/impl/metric/Queuer;
    //   41: invokevirtual 128	com/inmobi/androidsdk/impl/metric/Queuer:reset	()V
    //   44: aload_0
    //   45: invokestatic 95	com/inmobi/androidsdk/impl/metric/Storage:a	(Landroid/content/Context;)V
    //   48: getstatic 134	com/inmobi/androidsdk/impl/metric/Logger:action	Lcom/inmobi/androidsdk/impl/metric/MetricAction;
    //   51: astore_0
    //   52: aload_0
    //   53: ifnull +11 -> 64
    //   56: getstatic 134	com/inmobi/androidsdk/impl/metric/Logger:action	Lcom/inmobi/androidsdk/impl/metric/MetricAction;
    //   59: invokeinterface 139 1 0
    //   64: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   67: iconst_0
    //   68: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   71: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: astore_0
    //   75: aload_0
    //   76: monitorenter
    //   77: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   80: invokevirtual 145	java/lang/Object:notify	()V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_0
    //   92: ldc 100
    //   94: ldc -109
    //   96: aload_0
    //   97: invokestatic 108	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: return
    //   101: astore_0
    //   102: ldc 100
    //   104: ldc 102
    //   106: aload_0
    //   107: invokestatic 108	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: goto -46 -> 64
    //   113: astore_0
    //   114: goto -50 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   86	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	85	86	finally
    //   87	89	86	finally
    //   71	77	91	java/lang/Exception
    //   89	91	91	java/lang/Exception
    //   12	52	101	java/io/IOException
    //   56	64	101	java/io/IOException
    //   56	64	113	java/lang/Exception
  }
  
  public static void saveToLatest()
  {
    saveLocalCache(c);
  }
  
  /* Error */
  public static void sendFile(Context arg0)
  {
    // Byte code:
    //   0: getstatic 40	com/inmobi/androidsdk/impl/metric/Storage:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3: iconst_0
    //   4: iconst_1
    //   5: invokevirtual 113	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   8: ifne +18 -> 26
    //   11: return
    //   12: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: astore_1
    //   16: aload_1
    //   17: monitorenter
    //   18: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   21: invokevirtual 154	java/lang/Object:wait	()V
    //   24: aload_1
    //   25: monitorexit
    //   26: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   29: iconst_0
    //   30: iconst_1
    //   31: invokevirtual 113	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   34: ifeq -22 -> 12
    //   37: ldc 100
    //   39: new 48	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   46: ldc -100
    //   48: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 28	com/inmobi/androidsdk/impl/metric/Storage:events	J
    //   54: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   57: ldc -98
    //   59: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 162	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: invokestatic 164	com/inmobi/androidsdk/impl/metric/Storage:readLocalCache	(Landroid/content/Context;)Ljava/lang/String;
    //   72: astore_1
    //   73: new 166	org/json/JSONObject
    //   76: dup
    //   77: invokespecial 167	org/json/JSONObject:<init>	()V
    //   80: astore_2
    //   81: aload_0
    //   82: aload_0
    //   83: invokestatic 173	com/inmobi/androidsdk/bootstrapper/Initializer:getConfigParams	(Landroid/content/Context;)Lcom/inmobi/androidsdk/bootstrapper/ConfigParams;
    //   86: invokevirtual 179	com/inmobi/androidsdk/bootstrapper/ConfigParams:getUID	()Lcom/inmobi/commons/uid/UID;
    //   89: invokestatic 185	com/inmobi/commons/uid/UIDUtil:getMap	(Landroid/content/Context;Lcom/inmobi/commons/uid/UID;)Ljava/util/Map;
    //   92: aload_2
    //   93: invokestatic 189	com/inmobi/commons/uid/UIDUtil:bindToJSON	(Ljava/util/Map;Lorg/json/JSONObject;)V
    //   96: invokestatic 195	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   99: astore_3
    //   100: aload_2
    //   101: ldc -59
    //   103: aload_3
    //   104: bipush 15
    //   106: invokevirtual 200	java/util/Calendar:get	(I)I
    //   109: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload_2
    //   114: ldc -50
    //   116: aload_3
    //   117: invokevirtual 209	java/util/Calendar:getTimeInMillis	()J
    //   120: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload_2
    //   125: invokevirtual 213	org/json/JSONObject:toString	()Ljava/lang/String;
    //   128: astore_2
    //   129: new 48	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   136: aload_2
    //   137: iconst_0
    //   138: aload_2
    //   139: invokevirtual 219	java/lang/String:length	()I
    //   142: iconst_1
    //   143: isub
    //   144: invokevirtual 223	java/lang/String:substring	(II)Ljava/lang/String;
    //   147: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc -31
    //   152: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc -29
    //   157: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: iconst_0
    //   162: aload_1
    //   163: invokevirtual 219	java/lang/String:length	()I
    //   166: iconst_1
    //   167: isub
    //   168: invokevirtual 223	java/lang/String:substring	(II)Ljava/lang/String;
    //   171: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc -27
    //   176: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc -25
    //   181: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore_1
    //   188: aload_0
    //   189: invokestatic 173	com/inmobi/androidsdk/bootstrapper/Initializer:getConfigParams	(Landroid/content/Context;)Lcom/inmobi/androidsdk/bootstrapper/ConfigParams;
    //   192: invokevirtual 235	com/inmobi/androidsdk/bootstrapper/ConfigParams:getMetric	()Lcom/inmobi/androidsdk/bootstrapper/MetricConfigParams;
    //   195: invokevirtual 240	com/inmobi/androidsdk/bootstrapper/MetricConfigParams:getUrl	()Ljava/lang/String;
    //   198: aload_1
    //   199: invokestatic 245	com/inmobi/androidsdk/impl/metric/MetricEndPoint:sendData	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: ldc 100
    //   204: new 48	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   211: ldc -9
    //   213: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: invokestatic 173	com/inmobi/androidsdk/bootstrapper/Initializer:getConfigParams	(Landroid/content/Context;)Lcom/inmobi/androidsdk/bootstrapper/ConfigParams;
    //   220: invokevirtual 235	com/inmobi/androidsdk/bootstrapper/ConfigParams:getMetric	()Lcom/inmobi/androidsdk/bootstrapper/MetricConfigParams;
    //   223: invokevirtual 240	com/inmobi/androidsdk/bootstrapper/MetricConfigParams:getUrl	()Ljava/lang/String;
    //   226: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 162	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload_0
    //   236: invokestatic 249	com/inmobi/androidsdk/impl/metric/Storage:resetFile	(Landroid/content/Context;)V
    //   239: getstatic 134	com/inmobi/androidsdk/impl/metric/Logger:action	Lcom/inmobi/androidsdk/impl/metric/MetricAction;
    //   242: astore_0
    //   243: aload_0
    //   244: ifnull +11 -> 255
    //   247: getstatic 134	com/inmobi/androidsdk/impl/metric/Logger:action	Lcom/inmobi/androidsdk/impl/metric/MetricAction;
    //   250: invokeinterface 252 1 0
    //   255: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   258: iconst_0
    //   259: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   262: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   265: astore_0
    //   266: aload_0
    //   267: monitorenter
    //   268: getstatic 38	com/inmobi/androidsdk/impl/metric/Storage:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   271: invokevirtual 145	java/lang/Object:notify	()V
    //   274: aload_0
    //   275: monitorexit
    //   276: getstatic 40	com/inmobi/androidsdk/impl/metric/Storage:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   279: iconst_0
    //   280: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   283: return
    //   284: astore_0
    //   285: aload_1
    //   286: monitorexit
    //   287: aload_0
    //   288: athrow
    //   289: astore_0
    //   290: ldc 100
    //   292: ldc -2
    //   294: invokestatic 162	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: return
    //   298: astore_0
    //   299: ldc 100
    //   301: ldc_w 256
    //   304: invokestatic 162	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: goto -52 -> 255
    //   310: astore_1
    //   311: aload_0
    //   312: monitorexit
    //   313: aload_1
    //   314: athrow
    //   315: astore_0
    //   316: goto -40 -> 276
    //   319: astore_0
    //   320: goto -65 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	271	1	localObject1	Object
    //   310	4	1	localObject2	Object
    //   80	59	2	localObject3	Object
    //   99	18	3	localCalendar	java.util.Calendar
    // Exception table:
    //   from	to	target	type
    //   18	26	284	finally
    //   285	287	284	finally
    //   12	18	289	java/lang/Exception
    //   287	289	289	java/lang/Exception
    //   37	243	298	java/lang/Exception
    //   268	276	310	finally
    //   311	313	310	finally
    //   262	268	315	java/lang/Exception
    //   313	315	315	java/lang/Exception
    //   247	255	319	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/metric/Storage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */