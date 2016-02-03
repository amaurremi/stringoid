package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

class PreCacheWorker
  extends Thread
{
  private static boolean busy;
  private Context appContext;
  private DTOCachedVideo[] cachedVideos;
  private volatile boolean downloadedNewVideos = false;
  private String noVideosToCacheURL;
  
  private PreCacheWorker(DTOCachedVideo[] paramArrayOfDTOCachedVideo, Context paramContext, String paramString)
  {
    this.cachedVideos = paramArrayOfDTOCachedVideo;
    this.noVideosToCacheURL = paramString;
    this.appContext = paramContext.getApplicationContext();
  }
  
  private void handleContent(DTOCachedVideo paramDTOCachedVideo, HttpEntity paramHttpEntity)
  {
    Object localObject = paramHttpEntity.getContentType();
    if (localObject != null)
    {
      localObject = ((Header)localObject).getValue();
      if ((localObject == null) || (!((String)localObject).equalsIgnoreCase("application/json"))) {
        break label38;
      }
      handleJson(paramDTOCachedVideo, paramHttpEntity);
    }
    label38:
    while ((localObject == null) || (!((String)localObject).startsWith("video/"))) {
      return;
    }
    handleVideoFile(paramDTOCachedVideo, paramHttpEntity);
  }
  
  /* Error */
  private void handleJson(final DTOCachedVideo paramDTOCachedVideo, HttpEntity paramHttpEntity)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: invokeinterface 82 1 0
    //   8: invokestatic 88	com/millennialmedia/android/HttpGetRequest:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   11: astore 4
    //   13: aload_3
    //   14: astore_2
    //   15: aload 4
    //   17: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +13 -> 33
    //   23: new 96	com/millennialmedia/android/VideoAd
    //   26: dup
    //   27: aload 4
    //   29: invokespecial 99	com/millennialmedia/android/VideoAd:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +40 -> 74
    //   37: aload_2
    //   38: invokevirtual 103	com/millennialmedia/android/VideoAd:isValid	()Z
    //   41: ifeq +33 -> 74
    //   44: aload_2
    //   45: iconst_1
    //   46: putfield 107	com/millennialmedia/android/VideoAd:downloadPriority	I
    //   49: aload_0
    //   50: getfield 34	com/millennialmedia/android/PreCacheWorker:appContext	Landroid/content/Context;
    //   53: aconst_null
    //   54: aload_2
    //   55: new 6	com/millennialmedia/android/PreCacheWorker$1
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: invokespecial 110	com/millennialmedia/android/PreCacheWorker$1:<init>	(Lcom/millennialmedia/android/PreCacheWorker;Lcom/millennialmedia/android/DTOCachedVideo;)V
    //   64: invokestatic 116	com/millennialmedia/android/AdCache:startDownloadTask	(Landroid/content/Context;Ljava/lang/String;Lcom/millennialmedia/android/CachedAd;Lcom/millennialmedia/android/AdCache$AdCacheTaskListener;)Z
    //   67: ifeq +30 -> 97
    //   70: aload_0
    //   71: invokevirtual 121	java/lang/Object:wait	()V
    //   74: return
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 124	java/lang/IllegalStateException:printStackTrace	()V
    //   80: ldc 126
    //   82: invokestatic 131	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   85: return
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   91: ldc 126
    //   93: invokestatic 131	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   96: return
    //   97: aload_1
    //   98: getfield 137	com/millennialmedia/android/DTOCachedVideo:preCacheStartURL	Ljava/lang/String;
    //   101: invokestatic 142	com/millennialmedia/android/MMSDK$Event:logEvent	(Ljava/lang/String;)V
    //   104: aload_1
    //   105: getfield 145	com/millennialmedia/android/DTOCachedVideo:preCacheFailedURL	Ljava/lang/String;
    //   108: invokestatic 142	com/millennialmedia/android/MMSDK$Event:logEvent	(Ljava/lang/String;)V
    //   111: return
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 146	java/lang/InterruptedException:printStackTrace	()V
    //   117: ldc -108
    //   119: iconst_1
    //   120: anewarray 118	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_1
    //   126: invokevirtual 151	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   129: aastore
    //   130: invokestatic 155	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	PreCacheWorker
    //   0	134	1	paramDTOCachedVideo	DTOCachedVideo
    //   0	134	2	paramHttpEntity	HttpEntity
    //   1	13	3	localObject	Object
    //   11	17	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	13	75	java/lang/IllegalStateException
    //   15	33	75	java/lang/IllegalStateException
    //   2	13	86	java/io/IOException
    //   15	33	86	java/io/IOException
    //   44	74	112	java/lang/InterruptedException
    //   97	111	112	java/lang/InterruptedException
  }
  
  private void handleVideoFile(DTOCachedVideo paramDTOCachedVideo, HttpEntity paramHttpEntity)
  {
    if (!TextUtils.isEmpty(paramDTOCachedVideo.videoFileId))
    {
      MMSDK.Event.logEvent(paramDTOCachedVideo.preCacheStartURL);
      if (AdCache.downloadComponentToCache(paramDTOCachedVideo.url, paramDTOCachedVideo.videoFileId + "video.dat", this.appContext)) {
        MMSDK.Event.logEvent(paramDTOCachedVideo.preCacheCompleteURL);
      }
    }
    else
    {
      return;
    }
    MMSDK.Event.logEvent(paramDTOCachedVideo.preCacheFailedURL);
  }
  
  static void preCacheVideos(DTOCachedVideo[] paramArrayOfDTOCachedVideo, Context paramContext, String paramString)
  {
    try
    {
      if (!busy)
      {
        busy = true;
        new PreCacheWorker(paramArrayOfDTOCachedVideo, paramContext, paramString).start();
      }
      return;
    }
    finally
    {
      paramArrayOfDTOCachedVideo = finally;
      throw paramArrayOfDTOCachedVideo;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/millennialmedia/android/PreCacheWorker:cachedVideos	[Lcom/millennialmedia/android/DTOCachedVideo;
    //   6: ifnull +177 -> 183
    //   9: aload_0
    //   10: getfield 24	com/millennialmedia/android/PreCacheWorker:cachedVideos	[Lcom/millennialmedia/android/DTOCachedVideo;
    //   13: astore_3
    //   14: aload_3
    //   15: arraylength
    //   16: istore_2
    //   17: iconst_0
    //   18: istore_1
    //   19: iload_1
    //   20: iload_2
    //   21: if_icmpge +162 -> 183
    //   24: aload_3
    //   25: iload_1
    //   26: aaload
    //   27: astore 4
    //   29: new 84	com/millennialmedia/android/HttpGetRequest
    //   32: dup
    //   33: invokespecial 192	com/millennialmedia/android/HttpGetRequest:<init>	()V
    //   36: aload 4
    //   38: getfield 161	com/millennialmedia/android/DTOCachedVideo:url	Ljava/lang/String;
    //   41: invokevirtual 196	com/millennialmedia/android/HttpGetRequest:get	(Ljava/lang/String;)Lorg/apache/http/HttpResponse;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnonnull +11 -> 59
    //   51: ldc -58
    //   53: invokestatic 131	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   56: goto +183 -> 239
    //   59: aload 5
    //   61: invokeinterface 204 1 0
    //   66: astore 5
    //   68: aload 5
    //   70: ifnonnull +82 -> 152
    //   73: ldc -50
    //   75: invokestatic 131	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   78: goto +161 -> 239
    //   81: astore_3
    //   82: ldc 2
    //   84: monitorenter
    //   85: iconst_0
    //   86: putstatic 183	com/millennialmedia/android/PreCacheWorker:busy	Z
    //   89: aload_0
    //   90: getfield 22	com/millennialmedia/android/PreCacheWorker:downloadedNewVideos	Z
    //   93: ifne +27 -> 120
    //   96: aload_0
    //   97: getfield 26	com/millennialmedia/android/PreCacheWorker:noVideosToCacheURL	Ljava/lang/String;
    //   100: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +17 -> 120
    //   106: aload_0
    //   107: getfield 24	com/millennialmedia/android/PreCacheWorker:cachedVideos	[Lcom/millennialmedia/android/DTOCachedVideo;
    //   110: ifnonnull +10 -> 120
    //   113: aload_0
    //   114: getfield 26	com/millennialmedia/android/PreCacheWorker:noVideosToCacheURL	Ljava/lang/String;
    //   117: invokestatic 142	com/millennialmedia/android/MMSDK$Event:logEvent	(Ljava/lang/String;)V
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_3
    //   124: athrow
    //   125: astore_3
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_3
    //   129: athrow
    //   130: astore 4
    //   132: ldc -48
    //   134: iconst_1
    //   135: anewarray 118	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload 4
    //   142: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   145: aastore
    //   146: invokestatic 211	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: goto +90 -> 239
    //   152: aload 5
    //   154: invokeinterface 215 1 0
    //   159: lconst_0
    //   160: lcmp
    //   161: ifne +11 -> 172
    //   164: ldc -39
    //   166: invokestatic 131	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   169: goto +70 -> 239
    //   172: aload_0
    //   173: aload 4
    //   175: aload 5
    //   177: invokespecial 219	com/millennialmedia/android/PreCacheWorker:handleContent	(Lcom/millennialmedia/android/DTOCachedVideo;Lorg/apache/http/HttpEntity;)V
    //   180: goto +59 -> 239
    //   183: ldc 2
    //   185: monitorenter
    //   186: iconst_0
    //   187: putstatic 183	com/millennialmedia/android/PreCacheWorker:busy	Z
    //   190: aload_0
    //   191: getfield 22	com/millennialmedia/android/PreCacheWorker:downloadedNewVideos	Z
    //   194: ifne +27 -> 221
    //   197: aload_0
    //   198: getfield 26	com/millennialmedia/android/PreCacheWorker:noVideosToCacheURL	Ljava/lang/String;
    //   201: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifne +17 -> 221
    //   207: aload_0
    //   208: getfield 24	com/millennialmedia/android/PreCacheWorker:cachedVideos	[Lcom/millennialmedia/android/DTOCachedVideo;
    //   211: ifnonnull +10 -> 221
    //   214: aload_0
    //   215: getfield 26	com/millennialmedia/android/PreCacheWorker:noVideosToCacheURL	Ljava/lang/String;
    //   218: invokestatic 142	com/millennialmedia/android/MMSDK$Event:logEvent	(Ljava/lang/String;)V
    //   221: ldc 2
    //   223: monitorexit
    //   224: aload_0
    //   225: monitorexit
    //   226: return
    //   227: astore_3
    //   228: ldc 2
    //   230: monitorexit
    //   231: aload_3
    //   232: athrow
    //   233: astore_3
    //   234: ldc 2
    //   236: monitorexit
    //   237: aload_3
    //   238: athrow
    //   239: iload_1
    //   240: iconst_1
    //   241: iadd
    //   242: istore_1
    //   243: goto -224 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	PreCacheWorker
    //   18	225	1	i	int
    //   16	6	2	j	int
    //   13	12	3	arrayOfDTOCachedVideo	DTOCachedVideo[]
    //   81	43	3	localObject1	Object
    //   125	4	3	localObject2	Object
    //   227	5	3	localObject3	Object
    //   233	5	3	localObject4	Object
    //   27	10	4	localDTOCachedVideo	DTOCachedVideo
    //   130	44	4	localException	Exception
    //   44	132	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	81	finally
    //   29	46	81	finally
    //   51	56	81	finally
    //   59	68	81	finally
    //   73	78	81	finally
    //   132	149	81	finally
    //   152	169	81	finally
    //   172	180	81	finally
    //   82	85	125	finally
    //   123	125	125	finally
    //   183	186	125	finally
    //   231	233	125	finally
    //   237	239	125	finally
    //   29	46	130	java/lang/Exception
    //   51	56	130	java/lang/Exception
    //   59	68	130	java/lang/Exception
    //   186	221	227	finally
    //   221	224	227	finally
    //   228	231	227	finally
    //   85	120	233	finally
    //   120	123	233	finally
    //   234	237	233	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/PreCacheWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */