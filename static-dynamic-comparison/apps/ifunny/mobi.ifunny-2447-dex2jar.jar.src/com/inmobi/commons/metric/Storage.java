package com.inmobi.commons.metric;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Storage {
    MetricConfigParams a = null;
    private String b = "inmobi.cache.data";
    private String c = "inmobi.cache.data.events.number";
    private String d = "inmobi.cache.data.events.timestamp";
    private int e = 0;
    private Storage.PreProcessor f = null;
    private Queuer g = null;
    private long h = -1L;
    private long i = -1L;
    private AtomicBoolean j = new AtomicBoolean(false);
    private AtomicBoolean k = new AtomicBoolean(false);
    private Logger.MetricsCallback l = null;

    public Storage(int paramInt, String paramString, Queuer paramQueuer, MetricConfigParams paramMetricConfigParams) {
        this.a = paramMetricConfigParams;
        this.g = paramQueuer;
        this.e = paramInt;
        this.b = (this.b + "." + paramString);
        this.c = (this.c + "." + paramString);
        this.d = (this.d + "." + paramString);
    }

    public Storage(int paramInt, String paramString, Queuer paramQueuer, MetricConfigParams paramMetricConfigParams, Storage.PreProcessor paramPreProcessor) {
        this(paramInt, paramString, paramQueuer, paramMetricConfigParams);
        this.f = paramPreProcessor;
    }

    private void a() {
        try {
            FileOperations.writeStringToFile(InternalSDKUtil.getContext(), this.c, "" + this.h, false);
            FileOperations.writeStringToFile(InternalSDKUtil.getContext(), this.d, "" + this.i, false);
            return;
        } catch (Exception localException) {
            this.h = 0L;
        }
    }

    public long getEvents() {
        return this.h;
    }

    public long getTimestamp() {
        return this.i;
    }

    public String readLocalCache() {
        try {
            String str = FileOperations.readFileAsString(InternalSDKUtil.getContext(), this.b);
            return str;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Unable to read metric info.");
        }
        return "null,";
    }

    public void readNumberOfEventsAndTimeStampFromPersistent() {
        if (this.h != -1L) {
        }
        for (; ; ) {
            return;
            try {
                this.h = Long.parseLong(FileOperations.readFileAsString(InternalSDKUtil.getContext(), this.c));
                this.i = Long.parseLong(FileOperations.readFileAsString(InternalSDKUtil.getContext(), this.d));
                if (this.i != -1L) {
                    continue;
                }
                this.i = (System.currentTimeMillis() / 1000L);
                a();
                return;
            } catch (Exception localException) {
                for (; ; ) {
                    this.h = 0L;
                }
            }
        }
    }

    public void resetFile() {
        try {
            FileOperations.writeStringToFile(InternalSDKUtil.getContext(), this.b, "", false);
            this.h = 0L;
            this.i = (System.currentTimeMillis() / 1000L);
            a();
            return;
        } catch (IOException localIOException) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Someting went wrong while saving metrics log to persistent storage", localIOException);
        }
    }

    /* Error */
    public void saveLocalCache() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   4: iconst_0
        //   5: iconst_1
        //   6: invokevirtual 151	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
        //   9: ifne +4 -> 13
        //   12: return
        //   13: aload_0
        //   14: getfield 66	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
        //   17: ifnull +16 -> 33
        //   20: aload_0
        //   21: getfield 66	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
        //   24: aload_0
        //   25: getfield 33	com/inmobi/commons/metric/Storage:b	Ljava/lang/String;
        //   28: invokeinterface 157 2 0
        //   33: invokestatic 91	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
        //   36: aload_0
        //   37: getfield 33	com/inmobi/commons/metric/Storage:b	Ljava/lang/String;
        //   40: aload_0
        //   41: getfield 47	com/inmobi/commons/metric/Storage:g	Lcom/inmobi/commons/metric/Queuer;
        //   44: invokevirtual 162	com/inmobi/commons/metric/Queuer:get	()Ljava/lang/String;
        //   47: iconst_1
        //   48: invokestatic 102	com/inmobi/commons/internal/FileOperations:writeStringToFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
        //   51: aload_0
        //   52: aload_0
        //   53: getfield 53	com/inmobi/commons/metric/Storage:h	J
        //   56: aload_0
        //   57: getfield 47	com/inmobi/commons/metric/Storage:g	Lcom/inmobi/commons/metric/Queuer;
        //   60: invokevirtual 164	com/inmobi/commons/metric/Queuer:a	()J
        //   63: ladd
        //   64: putfield 53	com/inmobi/commons/metric/Storage:h	J
        //   67: aload_0
        //   68: getfield 47	com/inmobi/commons/metric/Storage:g	Lcom/inmobi/commons/metric/Queuer;
        //   71: invokevirtual 167	com/inmobi/commons/metric/Queuer:reset	()V
        //   74: aload_0
        //   75: invokespecial 138	com/inmobi/commons/metric/Storage:a	()V
        //   78: aload_0
        //   79: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   82: iconst_0
        //   83: invokevirtual 170	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
        //   86: aload_0
        //   87: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   90: astore_1
        //   91: aload_1
        //   92: monitorenter
        //   93: aload_0
        //   94: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   97: invokevirtual 173	java/lang/Object:notify	()V
        //   100: aload_1
        //   101: monitorexit
        //   102: return
        //   103: astore_2
        //   104: aload_1
        //   105: monitorexit
        //   106: aload_2
        //   107: athrow
        //   108: astore_1
        //   109: ldc 112
        //   111: ldc -81
        //   113: aload_1
        //   114: invokestatic 146	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   117: return
        //   118: astore_1
        //   119: ldc 112
        //   121: ldc -113
        //   123: aload_1
        //   124: invokestatic 146	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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

    public void saveToLatest() {
        saveLocalCache();
    }

    /* Error */
    public void sendFile() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 64	com/inmobi/commons/metric/Storage:k	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   4: iconst_0
        //   5: iconst_1
        //   6: invokevirtual 151	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
        //   9: ifne +20 -> 29
        //   12: return
        //   13: aload_0
        //   14: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   17: astore_1
        //   18: aload_1
        //   19: monitorenter
        //   20: aload_0
        //   21: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   24: invokevirtual 182	java/lang/Object:wait	()V
        //   27: aload_1
        //   28: monitorexit
        //   29: aload_0
        //   30: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   33: iconst_0
        //   34: iconst_1
        //   35: invokevirtual 151	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
        //   38: ifeq -25 -> 13
        //   41: aload_0
        //   42: getfield 66	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
        //   45: ifnull +19 -> 64
        //   48: aload_0
        //   49: getfield 66	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
        //   52: aload_0
        //   53: getfield 49	com/inmobi/commons/metric/Storage:a	Lcom/inmobi/commons/metric/MetricConfigParams;
        //   56: invokevirtual 187	com/inmobi/commons/metric/MetricConfigParams:getUrl	()Ljava/lang/String;
        //   59: invokeinterface 190 2 0
        //   64: ldc 112
        //   66: new 68	java/lang/StringBuilder
        //   69: dup
        //   70: invokespecial 69	java/lang/StringBuilder:<init>	()V
        //   73: ldc -64
        //   75: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   78: aload_0
        //   79: getfield 53	com/inmobi/commons/metric/Storage:h	J
        //   82: invokevirtual 96	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   85: ldc -62
        //   87: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   90: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   93: invokestatic 120	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   96: aload_0
        //   97: invokevirtual 196	com/inmobi/commons/metric/Storage:readLocalCache	()Ljava/lang/String;
        //   100: astore_1
        //   101: new 198	org/json/JSONObject
        //   104: dup
        //   105: invokestatic 204	com/inmobi/commons/uid/UID:getInstance	()Lcom/inmobi/commons/uid/UID;
        //   108: aconst_null
        //   109: invokevirtual 208	com/inmobi/commons/uid/UID:getMapForEncryption	(Ljava/util/Map;)Ljava/util/Map;
        //   112: invokestatic 211	com/inmobi/commons/internal/InternalSDKUtil:getEncodedMap	(Ljava/util/Map;)Ljava/util/Map;
        //   115: invokespecial 214	org/json/JSONObject:<init>	(Ljava/util/Map;)V
        //   118: astore_2
        //   119: invokestatic 219	java/util/Calendar:getInstance	()Ljava/util/Calendar;
        //   122: astore_3
        //   123: aload_2
        //   124: ldc -35
        //   126: aload_3
        //   127: bipush 15
        //   129: invokevirtual 224	java/util/Calendar:get	(I)I
        //   132: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   135: pop
        //   136: aload_2
        //   137: ldc -26
        //   139: aload_3
        //   140: invokevirtual 233	java/util/Calendar:getTimeInMillis	()J
        //   143: invokevirtual 236	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
        //   146: pop
        //   147: aload_2
        //   148: ldc -18
        //   150: aload_0
        //   151: getfield 43	com/inmobi/commons/metric/Storage:e	I
        //   154: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   157: pop
        //   158: aload_2
        //   159: ldc -16
        //   161: new 242	org/json/JSONArray
        //   164: dup
        //   165: new 68	java/lang/StringBuilder
        //   168: dup
        //   169: invokespecial 69	java/lang/StringBuilder:<init>	()V
        //   172: ldc -12
        //   174: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   177: aload_1
        //   178: iconst_0
        //   179: aload_1
        //   180: invokevirtual 250	java/lang/String:length	()I
        //   183: iconst_1
        //   184: isub
        //   185: invokevirtual 254	java/lang/String:substring	(II)Ljava/lang/String;
        //   188: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   191: ldc_w 256
        //   194: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   197: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   200: invokespecial 258	org/json/JSONArray:<init>	(Ljava/lang/String;)V
        //   203: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   206: pop
        //   207: aload_2
        //   208: astore_1
        //   209: aload_0
        //   210: getfield 45	com/inmobi/commons/metric/Storage:f	Lcom/inmobi/commons/metric/Storage$PreProcessor;
        //   213: ifnull +14 -> 227
        //   216: aload_0
        //   217: getfield 45	com/inmobi/commons/metric/Storage:f	Lcom/inmobi/commons/metric/Storage$PreProcessor;
        //   220: aload_2
        //   221: invokeinterface 267 2 0
        //   226: astore_1
        //   227: aload_1
        //   228: invokevirtual 268	org/json/JSONObject:toString	()Ljava/lang/String;
        //   231: astore_1
        //   232: ldc 112
        //   234: new 68	java/lang/StringBuilder
        //   237: dup
        //   238: invokespecial 69	java/lang/StringBuilder:<init>	()V
        //   241: ldc_w 270
        //   244: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   247: aload_1
        //   248: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   251: ldc_w 272
        //   254: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   257: aload_0
        //   258: getfield 49	com/inmobi/commons/metric/Storage:a	Lcom/inmobi/commons/metric/MetricConfigParams;
        //   261: invokevirtual 187	com/inmobi/commons/metric/MetricConfigParams:getUrl	()Ljava/lang/String;
        //   264: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   267: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   270: invokestatic 120	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   273: aload_0
        //   274: getfield 49	com/inmobi/commons/metric/Storage:a	Lcom/inmobi/commons/metric/MetricConfigParams;
        //   277: invokevirtual 187	com/inmobi/commons/metric/MetricConfigParams:getUrl	()Ljava/lang/String;
        //   280: aload_1
        //   281: invokestatic 277	com/inmobi/commons/metric/MetricEndPoint:sendData	(Ljava/lang/String;Ljava/lang/String;)V
        //   284: ldc 112
        //   286: new 68	java/lang/StringBuilder
        //   289: dup
        //   290: invokespecial 69	java/lang/StringBuilder:<init>	()V
        //   293: ldc_w 279
        //   296: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   299: aload_0
        //   300: getfield 49	com/inmobi/commons/metric/Storage:a	Lcom/inmobi/commons/metric/MetricConfigParams;
        //   303: invokevirtual 187	com/inmobi/commons/metric/MetricConfigParams:getUrl	()Ljava/lang/String;
        //   306: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   309: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   312: invokestatic 120	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   315: aload_0
        //   316: invokevirtual 281	com/inmobi/commons/metric/Storage:resetFile	()V
        //   319: aload_0
        //   320: getfield 66	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
        //   323: ifnull +12 -> 335
        //   326: aload_0
        //   327: getfield 66	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
        //   330: invokeinterface 284 1 0
        //   335: aload_0
        //   336: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   339: iconst_0
        //   340: invokevirtual 170	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
        //   343: aload_0
        //   344: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   347: astore_1
        //   348: aload_1
        //   349: monitorenter
        //   350: aload_0
        //   351: getfield 62	com/inmobi/commons/metric/Storage:j	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   354: invokevirtual 173	java/lang/Object:notify	()V
        //   357: aload_1
        //   358: monitorexit
        //   359: aload_0
        //   360: getfield 64	com/inmobi/commons/metric/Storage:k	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   363: iconst_0
        //   364: invokevirtual 170	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
        //   367: return
        //   368: astore_2
        //   369: aload_1
        //   370: monitorexit
        //   371: aload_2
        //   372: athrow
        //   373: astore_1
        //   374: ldc 112
        //   376: ldc_w 286
        //   379: invokestatic 120	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   382: return
        //   383: astore_1
        //   384: ldc 112
        //   386: ldc_w 288
        //   389: invokestatic 120	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   392: aload_0
        //   393: getfield 66	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
        //   396: ifnull -61 -> 335
        //   399: aload_0
        //   400: getfield 66	com/inmobi/commons/metric/Storage:l	Lcom/inmobi/commons/metric/Logger$MetricsCallback;
        //   403: invokeinterface 291 1 0
        //   408: goto -73 -> 335
        //   411: astore_2
        //   412: aload_1
        //   413: monitorexit
        //   414: aload_2
        //   415: athrow
        //   416: astore_1
        //   417: ldc 112
        //   419: ldc_w 293
        //   422: invokestatic 120	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   425: goto -66 -> 359
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	428	0	this	Storage
        //   373	1	1	localException1	Exception
        //   383	30	1	localException2	Exception
        //   416	1	1	localException3	Exception
        //   118	103	2	localJSONObject	org.json.JSONObject
        //   368	4	2	localObject2	Object
        //   411	4	2	localObject3	Object
        //   122	18	3	localCalendar	java.util.Calendar
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

    public void setCallback(Logger.MetricsCallback paramMetricsCallback) {
        this.l = paramMetricsCallback;
    }

    public void setPreprocessor(Storage.PreProcessor paramPreProcessor) {
        this.f = paramPreProcessor;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/metric/Storage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */