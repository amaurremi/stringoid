package com.millennialmedia.android;

import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.Map;

import org.json.JSONArray;

class BridgeMMCachedVideo
        extends MMJSObject
        implements AdCache.AdCacheTaskListener {
    private boolean a;

    private VideoPlayerActivity a() {
        if ((this.c != null) && (this.c.get() != null) && ((((MMWebView) this.c.get()).i() instanceof MMActivity))) {
            Object localObject = (MMWebView) this.c.get();
            if (localObject != null) {
                localObject = ((MMWebView) localObject).i();
                if ((localObject != null) && ((localObject instanceof MMActivity))) {
                    localObject = (MMActivity) localObject;
                    if ((((MMActivity) localObject).h() != null) && ((((MMActivity) localObject).h() instanceof VideoPlayerActivity))) {
                        return (VideoPlayerActivity) ((MMActivity) localObject).h();
                    }
                }
            }
        }
        return null;
    }

    MMJSResponse a(String paramString, Map<String, String> paramMap) {
        MMJSResponse localMMJSResponse = null;
        if ("availableCachedVideos".equals(paramString)) {
            localMMJSResponse = availableCachedVideos(paramMap);
        }
        do {
            return localMMJSResponse;
            if ("cacheVideo".equals(paramString)) {
                return cacheVideo(paramMap);
            }
            if ("endVideo".equals(paramString)) {
                return endVideo(paramMap);
            }
            if ("pauseVideo".equals(paramString)) {
                return pauseVideo(paramMap);
            }
            if ("playCachedVideo".equals(paramString)) {
                return playCachedVideo(paramMap);
            }
            if ("playVideo".equals(paramString)) {
                return playVideo(paramMap);
            }
            if ("restartVideo".equals(paramString)) {
                return restartVideo(paramMap);
            }
        } while (!"videoIdExists".equals(paramString));
        return videoIdExists(paramMap);
    }

    public MMJSResponse availableCachedVideos(Map<String, String> paramMap) {
        Object localObject = (Context) this.b.get();
        if (localObject != null) {
            paramMap = new JSONArray();
            AdCache.a((Context) localObject, 2, new BridgeMMCachedVideo .1 (this, (Context) localObject, paramMap));
            localObject = new MMJSResponse();
            ((MMJSResponse) localObject).c = 1;
            ((MMJSResponse) localObject).d = paramMap;
            return (MMJSResponse) localObject;
        }
        return null;
    }

    /* Error */
    public MMJSResponse cacheVideo(Map<String, String> paramMap) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 83	com/millennialmedia/android/BridgeMMCachedVideo:b	Ljava/lang/ref/WeakReference;
        //   6: invokevirtual 24	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   9: checkcast 85	android/content/Context
        //   12: astore_3
        //   13: aload_1
        //   14: ldc 119
        //   16: invokeinterface 124 2 0
        //   21: checkcast 43	java/lang/String
        //   24: astore_1
        //   25: aload_1
        //   26: ifnull +266 -> 292
        //   29: aload_3
        //   30: ifnull +262 -> 292
        //   33: new 126	com/millennialmedia/android/HttpGetRequest
        //   36: dup
        //   37: invokespecial 127	com/millennialmedia/android/HttpGetRequest:<init>	()V
        //   40: aload_1
        //   41: invokevirtual 130	com/millennialmedia/android/HttpGetRequest:a	(Ljava/lang/String;)Lorg/apache/http/HttpResponse;
        //   44: astore 4
        //   46: aload 4
        //   48: ifnonnull +16 -> 64
        //   51: ldc -124
        //   53: ldc -122
        //   55: invokestatic 139	com/millennialmedia/android/MMLog:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   58: aconst_null
        //   59: astore_1
        //   60: aload_0
        //   61: monitorexit
        //   62: aload_1
        //   63: areturn
        //   64: aload 4
        //   66: invokeinterface 145 1 0
        //   71: astore 4
        //   73: aload 4
        //   75: ifnonnull +29 -> 104
        //   78: ldc -124
        //   80: ldc -109
        //   82: invokestatic 149	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   85: aconst_null
        //   86: astore_1
        //   87: goto -27 -> 60
        //   90: astore_1
        //   91: ldc -124
        //   93: ldc -105
        //   95: aload_1
        //   96: invokestatic 154	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   99: aconst_null
        //   100: astore_1
        //   101: goto -41 -> 60
        //   104: aload 4
        //   106: invokeinterface 160 1 0
        //   111: lconst_0
        //   112: lcmp
        //   113: ifne +15 -> 128
        //   116: ldc -124
        //   118: ldc -94
        //   120: invokestatic 149	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   123: aconst_null
        //   124: astore_1
        //   125: goto -65 -> 60
        //   128: aload 4
        //   130: invokeinterface 166 1 0
        //   135: astore 5
        //   137: aload 5
        //   139: ifnull +153 -> 292
        //   142: aload 5
        //   144: invokeinterface 172 1 0
        //   149: ifnull +143 -> 292
        //   152: aload 5
        //   154: invokeinterface 172 1 0
        //   159: ldc -82
        //   161: invokevirtual 178	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   164: istore_2
        //   165: iload_2
        //   166: ifeq +126 -> 292
        //   169: new 180	com/millennialmedia/android/VideoAd
        //   172: dup
        //   173: aload 4
        //   175: invokeinterface 184 1 0
        //   180: invokestatic 187	com/millennialmedia/android/HttpGetRequest:a	(Ljava/io/InputStream;)Ljava/lang/String;
        //   183: invokespecial 190	com/millennialmedia/android/VideoAd:<init>	(Ljava/lang/String;)V
        //   186: astore 4
        //   188: aload 4
        //   190: ifnull +102 -> 292
        //   193: aload 4
        //   195: invokevirtual 193	com/millennialmedia/android/VideoAd:b	()Z
        //   198: ifeq +94 -> 292
        //   201: aload 4
        //   203: iconst_3
        //   204: putfield 196	com/millennialmedia/android/VideoAd:e	I
        //   207: aload_3
        //   208: aconst_null
        //   209: aload 4
        //   211: aload_0
        //   212: invokestatic 199	com/millennialmedia/android/AdCache:a	(Landroid/content/Context;Ljava/lang/String;Lcom/millennialmedia/android/CachedAd;Lcom/millennialmedia/android/AdCache$AdCacheTaskListener;)Z
        //   215: istore_2
        //   216: iload_2
        //   217: ifeq +103 -> 320
        //   220: aload_0
        //   221: invokevirtual 204	java/lang/Object:wait	()V
        //   224: aload_0
        //   225: getfield 206	com/millennialmedia/android/BridgeMMCachedVideo:a	Z
        //   228: ifeq +60 -> 288
        //   231: ldc -48
        //   233: iconst_1
        //   234: anewarray 201	java/lang/Object
        //   237: dup
        //   238: iconst_0
        //   239: aload_1
        //   240: aastore
        //   241: invokestatic 212	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   244: invokestatic 215	com/millennialmedia/android/MMJSResponse:a	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
        //   247: astore_1
        //   248: aload_0
        //   249: invokevirtual 218	java/lang/Object:notify	()V
        //   252: goto -192 -> 60
        //   255: astore_1
        //   256: aload_0
        //   257: monitorexit
        //   258: aload_1
        //   259: athrow
        //   260: astore_1
        //   261: ldc -124
        //   263: ldc -36
        //   265: aload_1
        //   266: invokestatic 154	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   269: aconst_null
        //   270: astore_1
        //   271: goto -211 -> 60
        //   274: astore_1
        //   275: ldc -124
        //   277: ldc -36
        //   279: aload_1
        //   280: invokestatic 154	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   283: aconst_null
        //   284: astore_1
        //   285: goto -225 -> 60
        //   288: aload_0
        //   289: invokevirtual 218	java/lang/Object:notify	()V
        //   292: aconst_null
        //   293: astore_1
        //   294: goto -234 -> 60
        //   297: astore_1
        //   298: ldc -124
        //   300: ldc -34
        //   302: aload_1
        //   303: invokestatic 154	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   306: aload_0
        //   307: invokevirtual 218	java/lang/Object:notify	()V
        //   310: goto -18 -> 292
        //   313: astore_1
        //   314: aload_0
        //   315: invokevirtual 218	java/lang/Object:notify	()V
        //   318: aload_1
        //   319: athrow
        //   320: ldc -32
        //   322: iconst_1
        //   323: anewarray 201	java/lang/Object
        //   326: dup
        //   327: iconst_0
        //   328: aload_1
        //   329: aastore
        //   330: invokestatic 212	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   333: invokestatic 226	com/millennialmedia/android/MMJSResponse:b	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
        //   336: astore_1
        //   337: goto -277 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	340	0	this	BridgeMMCachedVideo
        //   0	340	1	paramMap	Map<String, String>
        //   164	53	2	bool	boolean
        //   12	196	3	localContext	Context
        //   44	166	4	localObject	Object
        //   135	18	5	localHeader	org.apache.http.Header
        // Exception table:
        //   from	to	target	type
        //   33	46	90	java/lang/Exception
        //   51	58	90	java/lang/Exception
        //   64	73	90	java/lang/Exception
        //   2	25	255	finally
        //   33	46	255	finally
        //   51	58	255	finally
        //   64	73	255	finally
        //   78	85	255	finally
        //   91	99	255	finally
        //   104	123	255	finally
        //   128	137	255	finally
        //   142	165	255	finally
        //   169	188	255	finally
        //   193	216	255	finally
        //   248	252	255	finally
        //   261	269	255	finally
        //   275	283	255	finally
        //   288	292	255	finally
        //   306	310	255	finally
        //   314	320	255	finally
        //   320	337	255	finally
        //   169	188	260	java/lang/IllegalStateException
        //   169	188	274	java/io/IOException
        //   220	248	297	java/lang/InterruptedException
        //   220	248	313	finally
        //   298	306	313	finally
    }

    public void downloadCompleted(CachedAd paramCachedAd, boolean paramBoolean) {
        try {
            Context localContext = (Context) this.b.get();
            if ((paramBoolean) && (localContext != null)) {
                AdCache.a(localContext, paramCachedAd);
            }
            this.a = paramBoolean;
            notify();
            return;
        } finally {
        }
    }

    public void downloadStart(CachedAd paramCachedAd) {
    }

    public MMJSResponse endVideo(Map<String, String> paramMap) {
        paramMap = a();
        if (paramMap != null) {
            return a(new BridgeMMCachedVideo .3 (this, paramMap));
        }
        return null;
    }

    public MMJSResponse pauseVideo(Map<String, String> paramMap) {
        paramMap = a();
        if (paramMap != null) {
            return a(new BridgeMMCachedVideo .4 (this, paramMap));
        }
        return null;
    }

    public MMJSResponse playCachedVideo(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        String str = (String) paramMap.get("videoId");
        if ((str != null) && (localContext != null)) {
            VideoAd localVideoAd = (VideoAd) AdCache.i(localContext, str);
            if ((localVideoAd != null) && (localVideoAd.a(localContext, null, false))) {
                localVideoAd.a(localContext, b((String) paramMap.get("PROPERTY_EXPANDING")));
                return MMJSResponse.a(String.format("Playing Video(%s)", new Object[]{str}));
            }
        }
        return null;
    }

    public MMJSResponse playVideo(Map<String, String> paramMap) {
        paramMap = a();
        if (paramMap != null) {
            return a(new BridgeMMCachedVideo .2 (this, paramMap));
        }
        return null;
    }

    public MMJSResponse restartVideo(Map<String, String> paramMap) {
        paramMap = a();
        if (paramMap != null) {
            return a(new BridgeMMCachedVideo .5 (this, paramMap));
        }
        return null;
    }

    @Deprecated
    public MMJSResponse videoIdExists(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        paramMap = (String) paramMap.get("videoId");
        if ((paramMap != null) && (localContext != null)) {
            VideoAd localVideoAd = (VideoAd) AdCache.i(localContext, paramMap);
            if ((localVideoAd != null) && (localVideoAd.d(localContext)) && (!localVideoAd.a())) {
                return MMJSResponse.a(paramMap);
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMCachedVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */