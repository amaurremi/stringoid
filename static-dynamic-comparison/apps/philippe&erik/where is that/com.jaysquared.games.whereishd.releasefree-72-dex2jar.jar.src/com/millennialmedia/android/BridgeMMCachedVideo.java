package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONArray;

class BridgeMMCachedVideo
  extends MMJSObject
  implements AdCache.AdCacheTaskListener
{
  private boolean success;
  
  private VideoPlayerActivity getVPA()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mmWebViewRef != null)
    {
      localObject1 = localObject2;
      if (this.mmWebViewRef.get() != null)
      {
        localObject1 = localObject2;
        if ((((MMWebView)this.mmWebViewRef.get()).getActivity() instanceof MMActivity))
        {
          Object localObject3 = (MMWebView)this.mmWebViewRef.get();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = ((MMWebView)localObject3).getActivity();
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if ((localObject3 instanceof MMActivity))
              {
                localObject3 = (MMActivity)localObject3;
                localObject1 = localObject2;
                if (((MMActivity)localObject3).getWrappedActivity() != null)
                {
                  localObject1 = localObject2;
                  if ((((MMActivity)localObject3).getWrappedActivity() instanceof VideoPlayerActivity)) {
                    localObject1 = (VideoPlayerActivity)((MMActivity)localObject3).getWrappedActivity();
                  }
                }
              }
            }
          }
        }
      }
    }
    return (VideoPlayerActivity)localObject1;
  }
  
  public MMJSResponse availableCachedVideos(final HashMap<String, String> paramHashMap)
  {
    final Object localObject = (Context)this.contextRef.get();
    if (localObject != null)
    {
      paramHashMap = new JSONArray();
      AdCache.iterateCachedAds((Context)localObject, 2, new AdCache.Iterator()
      {
        boolean callback(CachedAd paramAnonymousCachedAd)
        {
          if (((paramAnonymousCachedAd instanceof VideoAd)) && (paramAnonymousCachedAd.isOnDisk(localObject)) && (!paramAnonymousCachedAd.isExpired())) {
            paramHashMap.put(paramAnonymousCachedAd.getId());
          }
          return true;
        }
      });
      localObject = new MMJSResponse();
      ((MMJSResponse)localObject).result = 1;
      ((MMJSResponse)localObject).response = paramHashMap;
      return (MMJSResponse)localObject;
    }
    return null;
  }
  
  /* Error */
  public MMJSResponse cacheVideo(HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 54	com/millennialmedia/android/BridgeMMCachedVideo:contextRef	Ljava/lang/ref/WeakReference;
    //   8: invokevirtual 35	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   11: checkcast 56	android/content/Context
    //   14: astore 4
    //   16: aload_1
    //   17: ldc 92
    //   19: invokevirtual 97	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 99	java/lang/String
    //   25: astore 5
    //   27: aload_3
    //   28: astore_1
    //   29: aload 5
    //   31: ifnull +34 -> 65
    //   34: aload_3
    //   35: astore_1
    //   36: aload 4
    //   38: ifnull +27 -> 65
    //   41: new 101	com/millennialmedia/android/HttpGetRequest
    //   44: dup
    //   45: invokespecial 102	com/millennialmedia/android/HttpGetRequest:<init>	()V
    //   48: aload 5
    //   50: invokevirtual 105	com/millennialmedia/android/HttpGetRequest:get	(Ljava/lang/String;)Lorg/apache/http/HttpResponse;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnonnull +14 -> 69
    //   58: ldc 107
    //   60: invokestatic 113	com/millennialmedia/android/MMSDK$Log:i	(Ljava/lang/String;)V
    //   63: aload_3
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: areturn
    //   69: aload_1
    //   70: invokeinterface 119 1 0
    //   75: astore 6
    //   77: aload 6
    //   79: ifnonnull +49 -> 128
    //   82: ldc 121
    //   84: invokestatic 124	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   87: aload_3
    //   88: astore_1
    //   89: goto -24 -> 65
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: new 126	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   105: ldc -127
    //   107: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 124	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   123: aload_3
    //   124: astore_1
    //   125: goto -60 -> 65
    //   128: aload 6
    //   130: invokeinterface 146 1 0
    //   135: lconst_0
    //   136: lcmp
    //   137: ifne +13 -> 150
    //   140: ldc -108
    //   142: invokestatic 124	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   145: aload_3
    //   146: astore_1
    //   147: goto -82 -> 65
    //   150: aload 6
    //   152: invokeinterface 152 1 0
    //   157: astore 7
    //   159: aload_3
    //   160: astore_1
    //   161: aload 7
    //   163: ifnull -98 -> 65
    //   166: aload_3
    //   167: astore_1
    //   168: aload 7
    //   170: invokeinterface 157 1 0
    //   175: ifnull -110 -> 65
    //   178: aload 7
    //   180: invokeinterface 157 1 0
    //   185: ldc -97
    //   187: invokevirtual 163	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   190: istore_2
    //   191: aload_3
    //   192: astore_1
    //   193: iload_2
    //   194: ifeq -129 -> 65
    //   197: new 165	com/millennialmedia/android/VideoAd
    //   200: dup
    //   201: aload 6
    //   203: invokeinterface 169 1 0
    //   208: invokestatic 173	com/millennialmedia/android/HttpGetRequest:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   211: invokespecial 175	com/millennialmedia/android/VideoAd:<init>	(Ljava/lang/String;)V
    //   214: astore 6
    //   216: aload_3
    //   217: astore_1
    //   218: aload 6
    //   220: ifnull -155 -> 65
    //   223: aload_3
    //   224: astore_1
    //   225: aload 6
    //   227: invokevirtual 179	com/millennialmedia/android/VideoAd:isValid	()Z
    //   230: ifeq -165 -> 65
    //   233: aload 6
    //   235: iconst_3
    //   236: putfield 182	com/millennialmedia/android/VideoAd:downloadPriority	I
    //   239: aload 4
    //   241: aconst_null
    //   242: aload 6
    //   244: aload_0
    //   245: invokestatic 186	com/millennialmedia/android/AdCache:startDownloadTask	(Landroid/content/Context;Ljava/lang/String;Lcom/millennialmedia/android/CachedAd;Lcom/millennialmedia/android/AdCache$AdCacheTaskListener;)Z
    //   248: istore_2
    //   249: iload_2
    //   250: ifeq +115 -> 365
    //   253: aload_0
    //   254: invokevirtual 191	java/lang/Object:wait	()V
    //   257: aload_0
    //   258: getfield 193	com/millennialmedia/android/BridgeMMCachedVideo:success	Z
    //   261: ifeq +58 -> 319
    //   264: ldc -61
    //   266: iconst_1
    //   267: anewarray 188	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload 5
    //   274: aastore
    //   275: invokestatic 199	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   278: invokestatic 203	com/millennialmedia/android/MMJSResponse:responseWithSuccess	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   281: astore_1
    //   282: aload_0
    //   283: invokevirtual 206	java/lang/Object:notify	()V
    //   286: goto -221 -> 65
    //   289: astore_1
    //   290: aload_1
    //   291: invokevirtual 209	java/lang/IllegalStateException:printStackTrace	()V
    //   294: ldc -45
    //   296: invokestatic 124	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   299: aload_3
    //   300: astore_1
    //   301: goto -236 -> 65
    //   304: astore_1
    //   305: aload_1
    //   306: invokevirtual 212	java/io/IOException:printStackTrace	()V
    //   309: ldc -45
    //   311: invokestatic 124	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   314: aload_3
    //   315: astore_1
    //   316: goto -251 -> 65
    //   319: aload_0
    //   320: invokevirtual 206	java/lang/Object:notify	()V
    //   323: aload_3
    //   324: astore_1
    //   325: goto -260 -> 65
    //   328: astore_1
    //   329: aload_1
    //   330: invokestatic 216	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/Throwable;)V
    //   333: ldc -38
    //   335: iconst_1
    //   336: anewarray 188	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: aload_1
    //   342: invokevirtual 219	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   345: aastore
    //   346: invokestatic 222	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: invokevirtual 206	java/lang/Object:notify	()V
    //   353: aload_3
    //   354: astore_1
    //   355: goto -290 -> 65
    //   358: astore_1
    //   359: aload_0
    //   360: invokevirtual 206	java/lang/Object:notify	()V
    //   363: aload_1
    //   364: athrow
    //   365: ldc -32
    //   367: iconst_1
    //   368: anewarray 188	java/lang/Object
    //   371: dup
    //   372: iconst_0
    //   373: aload 5
    //   375: aastore
    //   376: invokestatic 199	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   379: invokestatic 227	com/millennialmedia/android/MMJSResponse:responseWithError	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   382: astore_1
    //   383: goto -318 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	BridgeMMCachedVideo
    //   0	386	1	paramHashMap	HashMap<String, String>
    //   190	60	2	bool	boolean
    //   1	353	3	localObject1	Object
    //   14	226	4	localContext	Context
    //   25	349	5	str	String
    //   75	168	6	localObject2	Object
    //   157	22	7	localHeader	org.apache.http.Header
    // Exception table:
    //   from	to	target	type
    //   4	27	92	finally
    //   41	54	92	finally
    //   58	63	92	finally
    //   69	77	92	finally
    //   82	87	92	finally
    //   98	123	92	finally
    //   128	145	92	finally
    //   150	159	92	finally
    //   168	191	92	finally
    //   197	216	92	finally
    //   225	249	92	finally
    //   282	286	92	finally
    //   290	299	92	finally
    //   305	314	92	finally
    //   319	323	92	finally
    //   349	353	92	finally
    //   359	365	92	finally
    //   365	383	92	finally
    //   41	54	97	java/lang/Exception
    //   58	63	97	java/lang/Exception
    //   69	77	97	java/lang/Exception
    //   197	216	289	java/lang/IllegalStateException
    //   197	216	304	java/io/IOException
    //   253	282	328	java/lang/InterruptedException
    //   253	282	358	finally
    //   329	349	358	finally
  }
  
  public void downloadCompleted(CachedAd paramCachedAd, boolean paramBoolean)
  {
    try
    {
      Context localContext = (Context)this.contextRef.get();
      if ((paramBoolean) && (localContext != null)) {
        AdCache.save(localContext, paramCachedAd);
      }
      this.success = paramBoolean;
      notify();
      return;
    }
    finally {}
  }
  
  public void downloadStart(CachedAd paramCachedAd) {}
  
  public MMJSResponse endVideo(final HashMap<String, String> paramHashMap)
  {
    paramHashMap = getVPA();
    if (paramHashMap != null) {
      runOnUiThreadFuture(new Callable()
      {
        public MMJSResponse call()
        {
          paramHashMap.endVideo();
          return MMJSResponse.responseWithSuccess();
        }
      });
    }
    return null;
  }
  
  public MMJSResponse pauseVideo(final HashMap<String, String> paramHashMap)
  {
    paramHashMap = getVPA();
    if (paramHashMap != null) {
      runOnUiThreadFuture(new Callable()
      {
        public MMJSResponse call()
        {
          paramHashMap.pauseVideoByUser();
          return MMJSResponse.responseWithSuccess();
        }
      });
    }
    return null;
  }
  
  public MMJSResponse playCachedVideo(HashMap<String, String> paramHashMap)
  {
    Object localObject2 = null;
    Context localContext = (Context)this.contextRef.get();
    String str = (String)paramHashMap.get("videoId");
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (localContext != null)
      {
        VideoAd localVideoAd = (VideoAd)AdCache.load(localContext, str);
        localObject1 = localObject2;
        if (localVideoAd != null)
        {
          localObject1 = localObject2;
          if (localVideoAd.canShow(localContext, null, false))
          {
            localVideoAd.show(localContext, getAdImplId((String)paramHashMap.get("PROPERTY_EXPANDING")));
            localObject1 = MMJSResponse.responseWithSuccess(String.format("Playing Video(%s)", new Object[] { str }));
          }
        }
      }
    }
    return (MMJSResponse)localObject1;
  }
  
  public MMJSResponse playVideo(final HashMap<String, String> paramHashMap)
  {
    paramHashMap = getVPA();
    if (paramHashMap != null) {
      runOnUiThreadFuture(new Callable()
      {
        public MMJSResponse call()
        {
          paramHashMap.resumeVideo();
          return MMJSResponse.responseWithSuccess();
        }
      });
    }
    return null;
  }
  
  public MMJSResponse restartVideo(final HashMap<String, String> paramHashMap)
  {
    paramHashMap = getVPA();
    if (paramHashMap != null) {
      runOnUiThreadFuture(new Callable()
      {
        public MMJSResponse call()
        {
          paramHashMap.restartVideo();
          return MMJSResponse.responseWithSuccess();
        }
      });
    }
    return null;
  }
  
  @Deprecated
  public MMJSResponse videoIdExists(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    paramHashMap = (String)paramHashMap.get("videoId");
    if ((paramHashMap != null) && (localContext != null))
    {
      VideoAd localVideoAd = (VideoAd)AdCache.load(localContext, paramHashMap);
      if ((localVideoAd != null) && (localVideoAd.isOnDisk(localContext)) && (!localVideoAd.isExpired())) {
        return MMJSResponse.responseWithSuccess(paramHashMap);
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/BridgeMMCachedVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */