package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

class PreCacheWorker
        extends Thread {
    private static boolean a;
    private DTOCachedVideo[] b;
    private Context c;
    private String d;
    private volatile boolean e = false;

    private PreCacheWorker(DTOCachedVideo[] paramArrayOfDTOCachedVideo, Context paramContext, String paramString) {
        this.b = paramArrayOfDTOCachedVideo;
        this.d = paramString;
        this.c = paramContext.getApplicationContext();
    }

    private void a(DTOCachedVideo paramDTOCachedVideo, HttpEntity paramHttpEntity) {
        Object localObject = paramHttpEntity.getContentType();
        if (localObject != null) {
            localObject = ((Header) localObject).getValue();
            if ((localObject == null) || (!((String) localObject).equalsIgnoreCase("application/json"))) {
                break label38;
            }
            b(paramDTOCachedVideo, paramHttpEntity);
        }
        label38:
        while ((localObject == null) || (!((String) localObject).startsWith("video/"))) {
            return;
        }
        c(paramDTOCachedVideo, paramHttpEntity);
    }

    static void a(DTOCachedVideo[] paramArrayOfDTOCachedVideo, Context paramContext, String paramString) {
        try {
            if (!a) {
                a = true;
                new PreCacheWorker(paramArrayOfDTOCachedVideo, paramContext, paramString).start();
            }
            return;
        } finally {
            paramArrayOfDTOCachedVideo =finally;
            throw paramArrayOfDTOCachedVideo;
        }
    }

    /* Error */
    private void b(DTOCachedVideo paramDTOCachedVideo, HttpEntity paramHttpEntity) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: aload_2
        //   3: invokeinterface 82 1 0
        //   8: invokestatic 87	com/millennialmedia/android/HttpGetRequest:a	(Ljava/io/InputStream;)Ljava/lang/String;
        //   11: astore 4
        //   13: aload_3
        //   14: astore_2
        //   15: aload 4
        //   17: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   20: ifne +13 -> 33
        //   23: new 95	com/millennialmedia/android/VideoAd
        //   26: dup
        //   27: aload 4
        //   29: invokespecial 98	com/millennialmedia/android/VideoAd:<init>	(Ljava/lang/String;)V
        //   32: astore_2
        //   33: aload_2
        //   34: ifnull +40 -> 74
        //   37: aload_2
        //   38: invokevirtual 101	com/millennialmedia/android/VideoAd:b	()Z
        //   41: ifeq +33 -> 74
        //   44: aload_2
        //   45: iconst_1
        //   46: putfield 104	com/millennialmedia/android/VideoAd:e	I
        //   49: aload_0
        //   50: getfield 32	com/millennialmedia/android/PreCacheWorker:c	Landroid/content/Context;
        //   53: aconst_null
        //   54: aload_2
        //   55: new 106	com/millennialmedia/android/PreCacheWorker$1
        //   58: dup
        //   59: aload_0
        //   60: aload_1
        //   61: invokespecial 109	com/millennialmedia/android/PreCacheWorker$1:<init>	(Lcom/millennialmedia/android/PreCacheWorker;Lcom/millennialmedia/android/DTOCachedVideo;)V
        //   64: invokestatic 114	com/millennialmedia/android/AdCache:a	(Landroid/content/Context;Ljava/lang/String;Lcom/millennialmedia/android/CachedAd;Lcom/millennialmedia/android/AdCache$AdCacheTaskListener;)Z
        //   67: ifeq +34 -> 101
        //   70: aload_0
        //   71: invokevirtual 119	java/lang/Object:wait	()V
        //   74: return
        //   75: astore_1
        //   76: aload_1
        //   77: invokevirtual 122	java/lang/IllegalStateException:printStackTrace	()V
        //   80: ldc 124
        //   82: ldc 126
        //   84: invokestatic 131	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   87: return
        //   88: astore_1
        //   89: aload_1
        //   90: invokevirtual 132	java/io/IOException:printStackTrace	()V
        //   93: ldc 124
        //   95: ldc 126
        //   97: invokestatic 131	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   100: return
        //   101: aload_1
        //   102: getfield 136	com/millennialmedia/android/DTOCachedVideo:a	Ljava/lang/String;
        //   105: invokestatic 140	com/millennialmedia/android/MMSDK$Event:a	(Ljava/lang/String;)V
        //   108: aload_1
        //   109: getfield 142	com/millennialmedia/android/DTOCachedVideo:b	Ljava/lang/String;
        //   112: invokestatic 140	com/millennialmedia/android/MMSDK$Event:a	(Ljava/lang/String;)V
        //   115: return
        //   116: astore_1
        //   117: aload_1
        //   118: invokevirtual 143	java/lang/InterruptedException:printStackTrace	()V
        //   121: ldc 124
        //   123: ldc -111
        //   125: aload_1
        //   126: invokestatic 148	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   129: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	130	0	this	PreCacheWorker
        //   0	130	1	paramDTOCachedVideo	DTOCachedVideo
        //   0	130	2	paramHttpEntity	HttpEntity
        //   1	13	3	localObject	Object
        //   11	17	4	str	String
        // Exception table:
        //   from	to	target	type
        //   2	13	75	java/lang/IllegalStateException
        //   15	33	75	java/lang/IllegalStateException
        //   2	13	88	java/io/IOException
        //   15	33	88	java/io/IOException
        //   44	74	116	java/lang/InterruptedException
        //   101	115	116	java/lang/InterruptedException
    }

    private void c(DTOCachedVideo paramDTOCachedVideo, HttpEntity paramHttpEntity) {
        if (!TextUtils.isEmpty(paramDTOCachedVideo.e)) {
            MMSDK.Event.a(paramDTOCachedVideo.a);
            if (AdCache.a(paramDTOCachedVideo.d, paramDTOCachedVideo.e + "video.dat", this.c)) {
                MMSDK.Event.a(paramDTOCachedVideo.c);
            }
        } else {
            return;
        }
        MMSDK.Event.a(paramDTOCachedVideo.b);
    }

    /* Error */
    public void run() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 22	com/millennialmedia/android/PreCacheWorker:b	[Lcom/millennialmedia/android/DTOCachedVideo;
        //   6: ifnull +185 -> 191
        //   9: aload_0
        //   10: getfield 22	com/millennialmedia/android/PreCacheWorker:b	[Lcom/millennialmedia/android/DTOCachedVideo;
        //   13: astore_3
        //   14: aload_3
        //   15: arraylength
        //   16: istore_2
        //   17: iconst_0
        //   18: istore_1
        //   19: iload_1
        //   20: iload_2
        //   21: if_icmpge +170 -> 191
        //   24: aload_3
        //   25: iload_1
        //   26: aaload
        //   27: astore 4
        //   29: new 84	com/millennialmedia/android/HttpGetRequest
        //   32: dup
        //   33: invokespecial 172	com/millennialmedia/android/HttpGetRequest:<init>	()V
        //   36: aload 4
        //   38: getfield 151	com/millennialmedia/android/DTOCachedVideo:d	Ljava/lang/String;
        //   41: invokevirtual 175	com/millennialmedia/android/HttpGetRequest:a	(Ljava/lang/String;)Lorg/apache/http/HttpResponse;
        //   44: astore 5
        //   46: aload 5
        //   48: ifnonnull +13 -> 61
        //   51: ldc 124
        //   53: ldc -79
        //   55: invokestatic 131	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   58: goto +189 -> 247
        //   61: aload 5
        //   63: invokeinterface 183 1 0
        //   68: astore 5
        //   70: aload 5
        //   72: ifnonnull +86 -> 158
        //   75: ldc 124
        //   77: ldc -71
        //   79: invokestatic 131	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   82: goto +165 -> 247
        //   85: astore_3
        //   86: ldc 2
        //   88: monitorenter
        //   89: iconst_0
        //   90: putstatic 66	com/millennialmedia/android/PreCacheWorker:a	Z
        //   93: aload_0
        //   94: getfield 20	com/millennialmedia/android/PreCacheWorker:e	Z
        //   97: ifne +27 -> 124
        //   100: aload_0
        //   101: getfield 24	com/millennialmedia/android/PreCacheWorker:d	Ljava/lang/String;
        //   104: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   107: ifne +17 -> 124
        //   110: aload_0
        //   111: getfield 22	com/millennialmedia/android/PreCacheWorker:b	[Lcom/millennialmedia/android/DTOCachedVideo;
        //   114: ifnonnull +10 -> 124
        //   117: aload_0
        //   118: getfield 24	com/millennialmedia/android/PreCacheWorker:d	Ljava/lang/String;
        //   121: invokestatic 140	com/millennialmedia/android/MMSDK$Event:a	(Ljava/lang/String;)V
        //   124: ldc 2
        //   126: monitorexit
        //   127: aload_3
        //   128: athrow
        //   129: astore_3
        //   130: aload_0
        //   131: monitorexit
        //   132: aload_3
        //   133: athrow
        //   134: astore 4
        //   136: ldc 124
        //   138: ldc -69
        //   140: iconst_1
        //   141: anewarray 116	java/lang/Object
        //   144: dup
        //   145: iconst_0
        //   146: aload 4
        //   148: aastore
        //   149: invokestatic 191	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   152: invokestatic 131	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   155: goto +92 -> 247
        //   158: aload 5
        //   160: invokeinterface 195 1 0
        //   165: lconst_0
        //   166: lcmp
        //   167: ifne +13 -> 180
        //   170: ldc 124
        //   172: ldc -59
        //   174: invokestatic 131	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   177: goto +70 -> 247
        //   180: aload_0
        //   181: aload 4
        //   183: aload 5
        //   185: invokespecial 199	com/millennialmedia/android/PreCacheWorker:a	(Lcom/millennialmedia/android/DTOCachedVideo;Lorg/apache/http/HttpEntity;)V
        //   188: goto +59 -> 247
        //   191: ldc 2
        //   193: monitorenter
        //   194: iconst_0
        //   195: putstatic 66	com/millennialmedia/android/PreCacheWorker:a	Z
        //   198: aload_0
        //   199: getfield 20	com/millennialmedia/android/PreCacheWorker:e	Z
        //   202: ifne +27 -> 229
        //   205: aload_0
        //   206: getfield 24	com/millennialmedia/android/PreCacheWorker:d	Ljava/lang/String;
        //   209: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   212: ifne +17 -> 229
        //   215: aload_0
        //   216: getfield 22	com/millennialmedia/android/PreCacheWorker:b	[Lcom/millennialmedia/android/DTOCachedVideo;
        //   219: ifnonnull +10 -> 229
        //   222: aload_0
        //   223: getfield 24	com/millennialmedia/android/PreCacheWorker:d	Ljava/lang/String;
        //   226: invokestatic 140	com/millennialmedia/android/MMSDK$Event:a	(Ljava/lang/String;)V
        //   229: ldc 2
        //   231: monitorexit
        //   232: aload_0
        //   233: monitorexit
        //   234: return
        //   235: astore_3
        //   236: ldc 2
        //   238: monitorexit
        //   239: aload_3
        //   240: athrow
        //   241: astore_3
        //   242: ldc 2
        //   244: monitorexit
        //   245: aload_3
        //   246: athrow
        //   247: iload_1
        //   248: iconst_1
        //   249: iadd
        //   250: istore_1
        //   251: goto -232 -> 19
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	254	0	this	PreCacheWorker
        //   18	233	1	i	int
        //   16	6	2	j	int
        //   13	12	3	arrayOfDTOCachedVideo	DTOCachedVideo[]
        //   85	43	3	localObject1	Object
        //   129	4	3	localObject2	Object
        //   235	5	3	localObject3	Object
        //   241	5	3	localObject4	Object
        //   27	10	4	localDTOCachedVideo	DTOCachedVideo
        //   134	48	4	localException	Exception
        //   44	140	5	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   2	17	85	finally
        //   29	46	85	finally
        //   51	58	85	finally
        //   61	70	85	finally
        //   75	82	85	finally
        //   136	155	85	finally
        //   158	177	85	finally
        //   180	188	85	finally
        //   86	89	129	finally
        //   127	129	129	finally
        //   191	194	129	finally
        //   239	241	129	finally
        //   245	247	129	finally
        //   29	46	134	java/lang/Exception
        //   51	58	134	java/lang/Exception
        //   61	70	134	java/lang/Exception
        //   89	124	235	finally
        //   124	127	235	finally
        //   236	239	235	finally
        //   194	229	241	finally
        //   229	232	241	finally
        //   242	245	241	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/PreCacheWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */