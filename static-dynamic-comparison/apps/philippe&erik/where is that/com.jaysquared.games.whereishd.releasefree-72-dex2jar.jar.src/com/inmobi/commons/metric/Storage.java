package com.inmobi.commons.metric;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class Storage
{
  MetricConfigParams a = null;
  private String b = "inmobi.cache.data";
  private String c = "inmobi.cache.data.events.number";
  private String d = "inmobi.cache.data.events.timestamp";
  private int e = 0;
  private PreProcessor f = null;
  private Queuer g = null;
  private long h = -1L;
  private long i = -1L;
  private AtomicBoolean j = new AtomicBoolean(false);
  private AtomicBoolean k = new AtomicBoolean(false);
  private Logger.MetricsCallback l = null;
  
  public Storage(int paramInt, String paramString, Queuer paramQueuer, MetricConfigParams paramMetricConfigParams)
  {
    this.a = paramMetricConfigParams;
    this.g = paramQueuer;
    this.e = paramInt;
    this.b = (this.b + "." + paramString);
    this.c = (this.c + "." + paramString);
    this.d = (this.d + "." + paramString);
  }
  
  public Storage(int paramInt, String paramString, Queuer paramQueuer, MetricConfigParams paramMetricConfigParams, PreProcessor paramPreProcessor)
  {
    this(paramInt, paramString, paramQueuer, paramMetricConfigParams);
    this.f = paramPreProcessor;
  }
  
  private void a()
  {
    try
    {
      FileOperations.writeStringToFile(InternalSDKUtil.getContext(), this.c, "" + this.h, false);
      FileOperations.writeStringToFile(InternalSDKUtil.getContext(), this.d, "" + this.i, false);
      return;
    }
    catch (Exception localException)
    {
      this.h = 0L;
    }
  }
  
  public long getEvents()
  {
    return this.h;
  }
  
  public long getTimestamp()
  {
    return this.i;
  }
  
  public String readLocalCache()
  {
    try
    {
      String str = FileOperations.readFileAsString(InternalSDKUtil.getContext(), this.b);
      return str;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Unable to read metric info.");
    }
    return "null,";
  }
  
  public void readNumberOfEventsAndTimeStampFromPersistent()
  {
    if (this.h != -1L) {}
    for (;;)
    {
      return;
      try
      {
        this.h = Long.parseLong(FileOperations.readFileAsString(InternalSDKUtil.getContext(), this.c));
        this.i = Long.parseLong(FileOperations.readFileAsString(InternalSDKUtil.getContext(), this.d));
        if (this.i != -1L) {
          continue;
        }
        this.i = (System.currentTimeMillis() / 1000L);
        a();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.h = 0L;
        }
      }
    }
  }
  
  public void resetFile()
  {
    try
    {
      FileOperations.writeStringToFile(InternalSDKUtil.getContext(), this.b, "", false);
      this.h = 0L;
      this.i = (System.currentTimeMillis() / 1000L);
      a();
      return;
    }
    catch (IOException localIOException)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Someting went wrong while saving metrics log to persistent storage", localIOException);
    }
  }
  
  /* Error */
  public void saveLocalCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: iconst_0
    //   5: iconst_1
    //   6: invokevirtual 154	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getfield 69	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
    //   17: ifnull +16 -> 33
    //   20: aload_0
    //   21: getfield 69	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
    //   24: aload_0
    //   25: getfield 36	com/inmobi/commons/metric/Storage:b	Ljava/lang/String;
    //   28: invokeinterface 160 2 0
    //   33: invokestatic 94	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
    //   36: aload_0
    //   37: getfield 36	com/inmobi/commons/metric/Storage:b	Ljava/lang/String;
    //   40: aload_0
    //   41: getfield 50	com/inmobi/commons/metric/Storage:g	Lcom/inmobi/commons/metric/Queuer;
    //   44: invokevirtual 165	com/inmobi/commons/metric/Queuer:get	()Ljava/lang/String;
    //   47: iconst_1
    //   48: invokestatic 105	com/inmobi/commons/internal/FileOperations:writeStringToFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 56	com/inmobi/commons/metric/Storage:h	J
    //   56: aload_0
    //   57: getfield 50	com/inmobi/commons/metric/Storage:g	Lcom/inmobi/commons/metric/Queuer;
    //   60: invokevirtual 167	com/inmobi/commons/metric/Queuer:a	()J
    //   63: ladd
    //   64: putfield 56	com/inmobi/commons/metric/Storage:h	J
    //   67: aload_0
    //   68: getfield 50	com/inmobi/commons/metric/Storage:g	Lcom/inmobi/commons/metric/Queuer;
    //   71: invokevirtual 170	com/inmobi/commons/metric/Queuer:reset	()V
    //   74: aload_0
    //   75: invokespecial 141	com/inmobi/commons/metric/Storage:a	()V
    //   78: aload_0
    //   79: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   82: iconst_0
    //   83: invokevirtual 173	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   86: aload_0
    //   87: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   90: astore_1
    //   91: aload_1
    //   92: monitorenter
    //   93: aload_0
    //   94: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   97: invokevirtual 176	java/lang/Object:notify	()V
    //   100: aload_1
    //   101: monitorexit
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: monitorexit
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: ldc 115
    //   111: ldc -78
    //   113: aload_1
    //   114: invokestatic 149	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: return
    //   118: astore_1
    //   119: ldc 115
    //   121: ldc -110
    //   123: aload_1
    //   124: invokestatic 149	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto -49 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	Storage
    //   108	6	1	localException	Exception
    //   118	6	1	localIOException	IOException
    //   103	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   93	102	103	finally
    //   104	106	103	finally
    //   86	93	108	java/lang/Exception
    //   106	108	108	java/lang/Exception
    //   33	78	118	java/io/IOException
  }
  
  public void saveToLatest()
  {
    saveLocalCache();
  }
  
  /* Error */
  public void sendFile()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/inmobi/commons/metric/Storage:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: iconst_0
    //   5: iconst_1
    //   6: invokevirtual 154	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   9: ifne +20 -> 29
    //   12: return
    //   13: aload_0
    //   14: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   17: astore_1
    //   18: aload_1
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: invokevirtual 185	java/lang/Object:wait	()V
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_0
    //   30: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   33: iconst_0
    //   34: iconst_1
    //   35: invokevirtual 154	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   38: ifeq -25 -> 13
    //   41: aload_0
    //   42: getfield 69	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
    //   45: ifnull +19 -> 64
    //   48: aload_0
    //   49: getfield 69	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
    //   52: aload_0
    //   53: getfield 52	com/inmobi/commons/metric/Storage:a	Lcom/inmobi/commons/metric/MetricConfigParams;
    //   56: invokevirtual 190	com/inmobi/commons/metric/MetricConfigParams:getUrl	()Ljava/lang/String;
    //   59: invokeinterface 193 2 0
    //   64: ldc 115
    //   66: new 71	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   73: ldc -61
    //   75: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: getfield 56	com/inmobi/commons/metric/Storage:h	J
    //   82: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: ldc -59
    //   87: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 123	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: invokevirtual 199	com/inmobi/commons/metric/Storage:readLocalCache	()Ljava/lang/String;
    //   100: astore_1
    //   101: new 201	org/json/JSONObject
    //   104: dup
    //   105: invokespecial 202	org/json/JSONObject:<init>	()V
    //   108: astore_2
    //   109: invokestatic 94	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
    //   112: aconst_null
    //   113: invokestatic 208	com/inmobi/commons/uid/UIDUtil:getMap	(Landroid/content/Context;Lcom/inmobi/commons/uid/UID;)Ljava/util/Map;
    //   116: aload_2
    //   117: invokestatic 212	com/inmobi/commons/uid/UIDUtil:bindToJSON	(Ljava/util/Map;Lorg/json/JSONObject;)V
    //   120: invokestatic 218	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   123: astore_3
    //   124: aload_2
    //   125: ldc -36
    //   127: aload_3
    //   128: bipush 15
    //   130: invokevirtual 223	java/util/Calendar:get	(I)I
    //   133: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload_2
    //   138: ldc -27
    //   140: aload_3
    //   141: invokevirtual 232	java/util/Calendar:getTimeInMillis	()J
    //   144: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_2
    //   149: ldc -19
    //   151: aload_0
    //   152: getfield 46	com/inmobi/commons/metric/Storage:e	I
    //   155: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   158: pop
    //   159: aload_2
    //   160: ldc -17
    //   162: new 241	org/json/JSONArray
    //   165: dup
    //   166: new 71	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   173: ldc -13
    //   175: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_1
    //   179: iconst_0
    //   180: aload_1
    //   181: invokevirtual 249	java/lang/String:length	()I
    //   184: iconst_1
    //   185: isub
    //   186: invokevirtual 253	java/lang/String:substring	(II)Ljava/lang/String;
    //   189: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc -1
    //   194: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokespecial 257	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   203: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   206: pop
    //   207: aload_2
    //   208: astore_1
    //   209: aload_0
    //   210: getfield 48	com/inmobi/commons/metric/Storage:f	Lcom/inmobi/commons/metric/Storage$PreProcessor;
    //   213: ifnull +14 -> 227
    //   216: aload_0
    //   217: getfield 48	com/inmobi/commons/metric/Storage:f	Lcom/inmobi/commons/metric/Storage$PreProcessor;
    //   220: aload_2
    //   221: invokeinterface 264 2 0
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 265	org/json/JSONObject:toString	()Ljava/lang/String;
    //   231: astore_1
    //   232: ldc 115
    //   234: new 71	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 267
    //   244: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_1
    //   248: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 269
    //   254: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_0
    //   258: getfield 52	com/inmobi/commons/metric/Storage:a	Lcom/inmobi/commons/metric/MetricConfigParams;
    //   261: invokevirtual 190	com/inmobi/commons/metric/MetricConfigParams:getUrl	()Ljava/lang/String;
    //   264: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 123	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_0
    //   274: getfield 52	com/inmobi/commons/metric/Storage:a	Lcom/inmobi/commons/metric/MetricConfigParams;
    //   277: invokevirtual 190	com/inmobi/commons/metric/MetricConfigParams:getUrl	()Ljava/lang/String;
    //   280: aload_1
    //   281: invokestatic 274	com/inmobi/commons/metric/MetricEndPoint:sendData	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: ldc 115
    //   286: new 71	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 276
    //   296: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_0
    //   300: getfield 52	com/inmobi/commons/metric/Storage:a	Lcom/inmobi/commons/metric/MetricConfigParams;
    //   303: invokevirtual 190	com/inmobi/commons/metric/MetricConfigParams:getUrl	()Ljava/lang/String;
    //   306: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 123	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_0
    //   316: invokevirtual 278	com/inmobi/commons/metric/Storage:resetFile	()V
    //   319: aload_0
    //   320: getfield 69	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
    //   323: ifnull +12 -> 335
    //   326: aload_0
    //   327: getfield 69	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
    //   330: invokeinterface 281 1 0
    //   335: aload_0
    //   336: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   339: iconst_0
    //   340: invokevirtual 173	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   343: aload_0
    //   344: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   347: astore_1
    //   348: aload_1
    //   349: monitorenter
    //   350: aload_0
    //   351: getfield 65	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   354: invokevirtual 176	java/lang/Object:notify	()V
    //   357: aload_1
    //   358: monitorexit
    //   359: aload_0
    //   360: getfield 67	com/inmobi/commons/metric/Storage:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   363: iconst_0
    //   364: invokevirtual 173	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   367: return
    //   368: astore_2
    //   369: aload_1
    //   370: monitorexit
    //   371: aload_2
    //   372: athrow
    //   373: astore_1
    //   374: ldc 115
    //   376: ldc_w 283
    //   379: invokestatic 123	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: return
    //   383: astore_1
    //   384: ldc 115
    //   386: ldc_w 285
    //   389: invokestatic 123	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload_0
    //   393: getfield 69	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
    //   396: ifnull -61 -> 335
    //   399: aload_0
    //   400: getfield 69	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
    //   403: invokeinterface 288 1 0
    //   408: goto -73 -> 335
    //   411: astore_2
    //   412: aload_1
    //   413: monitorexit
    //   414: aload_2
    //   415: athrow
    //   416: astore_1
    //   417: ldc 115
    //   419: ldc_w 290
    //   422: invokestatic 123	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: goto -66 -> 359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	Storage
    //   373	1	1	localException1	Exception
    //   383	30	1	localException2	Exception
    //   416	1	1	localException3	Exception
    //   108	113	2	localJSONObject	JSONObject
    //   368	4	2	localObject2	Object
    //   411	4	2	localObject3	Object
    //   123	18	3	localCalendar	java.util.Calendar
    // Exception table:
    //   from	to	target	type
    //   20	29	368	finally
    //   369	371	368	finally
    //   13	20	373	java/lang/Exception
    //   371	373	373	java/lang/Exception
    //   64	207	383	java/lang/Exception
    //   209	227	383	java/lang/Exception
    //   227	335	383	java/lang/Exception
    //   350	359	411	finally
    //   412	414	411	finally
    //   343	350	416	java/lang/Exception
    //   414	416	416	java/lang/Exception
  }
  
  public void setCallback(Logger.MetricsCallback paramMetricsCallback)
  {
    this.l = paramMetricsCallback;
  }
  
  public void setPreprocessor(PreProcessor paramPreProcessor)
  {
    this.f = paramPreProcessor;
  }
  
  public static abstract interface PreProcessor
  {
    public abstract JSONObject process(JSONObject paramJSONObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/metric/Storage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */