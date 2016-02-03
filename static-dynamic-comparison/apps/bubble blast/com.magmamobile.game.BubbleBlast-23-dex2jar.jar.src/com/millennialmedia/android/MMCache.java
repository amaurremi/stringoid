package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;

class MMCache
  extends MMJSObject
  implements AdCache.AdCacheTaskListener
{
  private boolean success;
  
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
          if ((paramAnonymousCachedAd.getType() == 1) && (paramAnonymousCachedAd.isOnDisk(localObject)) && (!paramAnonymousCachedAd.isExpired())) {
            paramHashMap.put(paramAnonymousCachedAd.id);
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
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/millennialmedia/android/MMCache:contextRef	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 27	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 29	android/content/Context
    //   12: astore_3
    //   13: aload_1
    //   14: ldc 65
    //   16: invokevirtual 70	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 72	java/lang/String
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +265 -> 289
    //   27: aload_3
    //   28: ifnull +261 -> 289
    //   31: getstatic 78	java/lang/System:out	Ljava/io/PrintStream;
    //   34: aload_1
    //   35: invokevirtual 84	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   38: new 86	com/millennialmedia/android/HttpGetRequest
    //   41: dup
    //   42: invokespecial 87	com/millennialmedia/android/HttpGetRequest:<init>	()V
    //   45: aload_1
    //   46: invokevirtual 90	com/millennialmedia/android/HttpGetRequest:get	(Ljava/lang/String;)Lorg/apache/http/HttpResponse;
    //   49: astore_1
    //   50: aload_1
    //   51: ifnonnull +14 -> 65
    //   54: ldc 92
    //   56: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: areturn
    //   65: aload_1
    //   66: invokeinterface 103 1 0
    //   71: astore_1
    //   72: aload_1
    //   73: ifnonnull +44 -> 117
    //   76: ldc 105
    //   78: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   81: aconst_null
    //   82: astore_1
    //   83: goto -22 -> 61
    //   86: astore_1
    //   87: new 107	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   94: ldc 110
    //   96: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 118	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -53 -> 61
    //   117: aload_1
    //   118: invokeinterface 127 1 0
    //   123: lconst_0
    //   124: lcmp
    //   125: ifne +13 -> 138
    //   128: ldc -127
    //   130: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   133: aconst_null
    //   134: astore_1
    //   135: goto -74 -> 61
    //   138: aload_1
    //   139: invokeinterface 133 1 0
    //   144: astore 4
    //   146: aload 4
    //   148: ifnull +141 -> 289
    //   151: aload 4
    //   153: invokeinterface 138 1 0
    //   158: ifnull +131 -> 289
    //   161: aload 4
    //   163: invokeinterface 138 1 0
    //   168: ldc -116
    //   170: invokevirtual 144	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   173: istore_2
    //   174: iload_2
    //   175: ifeq +114 -> 289
    //   178: new 146	com/millennialmedia/android/VideoAd
    //   181: dup
    //   182: aload_1
    //   183: invokeinterface 150 1 0
    //   188: invokestatic 154	com/millennialmedia/android/HttpGetRequest:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   191: invokespecial 156	com/millennialmedia/android/VideoAd:<init>	(Ljava/lang/String;)V
    //   194: astore_1
    //   195: aload_1
    //   196: ifnull +93 -> 289
    //   199: aload_1
    //   200: invokevirtual 160	com/millennialmedia/android/VideoAd:isValid	()Z
    //   203: istore_2
    //   204: iload_2
    //   205: ifeq +84 -> 289
    //   208: aload_1
    //   209: iconst_3
    //   210: putfield 163	com/millennialmedia/android/VideoAd:downloadPriority	I
    //   213: aload_3
    //   214: aconst_null
    //   215: aload_1
    //   216: aload_0
    //   217: invokestatic 167	com/millennialmedia/android/AdCache:startDownloadTask	(Landroid/content/Context;Ljava/lang/String;Lcom/millennialmedia/android/CachedAd;Lcom/millennialmedia/android/AdCache$AdCacheTaskListener;)V
    //   220: aload_0
    //   221: invokevirtual 172	java/lang/Object:wait	()V
    //   224: aload_0
    //   225: getfield 174	com/millennialmedia/android/MMCache:success	Z
    //   228: ifeq +61 -> 289
    //   231: invokestatic 178	com/millennialmedia/android/MMJSResponse:responseWithSuccess	()Lcom/millennialmedia/android/MMJSResponse;
    //   234: astore_1
    //   235: goto -174 -> 61
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 181	java/lang/IllegalStateException:printStackTrace	()V
    //   243: ldc -73
    //   245: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   248: aconst_null
    //   249: astore_1
    //   250: goto -189 -> 61
    //   253: astore_1
    //   254: aload_1
    //   255: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   258: ldc -73
    //   260: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   263: aconst_null
    //   264: astore_1
    //   265: goto -204 -> 61
    //   268: astore_1
    //   269: aload_1
    //   270: invokestatic 188	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/Throwable;)V
    //   273: ldc -66
    //   275: iconst_1
    //   276: anewarray 169	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: aload_1
    //   282: invokevirtual 191	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   285: aastore
    //   286: invokestatic 194	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aconst_null
    //   290: astore_1
    //   291: goto -230 -> 61
    //   294: astore_1
    //   295: aload_0
    //   296: monitorexit
    //   297: aload_1
    //   298: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	MMCache
    //   0	299	1	paramHashMap	HashMap<String, String>
    //   173	32	2	bool	boolean
    //   12	202	3	localContext	Context
    //   144	18	4	localHeader	org.apache.http.Header
    // Exception table:
    //   from	to	target	type
    //   38	50	86	java/lang/Exception
    //   54	59	86	java/lang/Exception
    //   65	72	86	java/lang/Exception
    //   178	195	238	java/lang/IllegalStateException
    //   178	195	253	java/io/IOException
    //   208	235	268	java/lang/InterruptedException
    //   2	23	294	finally
    //   31	38	294	finally
    //   38	50	294	finally
    //   54	59	294	finally
    //   65	72	294	finally
    //   76	81	294	finally
    //   87	112	294	finally
    //   117	133	294	finally
    //   138	146	294	finally
    //   151	174	294	finally
    //   178	195	294	finally
    //   199	204	294	finally
    //   208	235	294	finally
    //   239	248	294	finally
    //   254	263	294	finally
    //   269	289	294	finally
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
  
  public MMJSResponse playCachedVideo(HashMap<String, String> paramHashMap)
  {
    Object localObject1 = null;
    Context localContext = (Context)this.contextRef.get();
    Object localObject2 = (String)paramHashMap.get("videoId");
    paramHashMap = (HashMap<String, String>)localObject1;
    if (localObject2 != null)
    {
      paramHashMap = (HashMap<String, String>)localObject1;
      if (localContext != null)
      {
        localObject2 = (VideoAd)AdCache.load(localContext, (String)localObject2);
        paramHashMap = (HashMap<String, String>)localObject1;
        if (localObject2 != null)
        {
          paramHashMap = (HashMap<String, String>)localObject1;
          if (((VideoAd)localObject2).canShow(localContext, null, false))
          {
            ((VideoAd)localObject2).show(localContext, null);
            paramHashMap = MMJSResponse.responseWithSuccess();
          }
        }
      }
    }
    return paramHashMap;
  }
  
  public MMJSResponse videoIdExists(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    paramHashMap = (String)paramHashMap.get("videoId");
    if ((paramHashMap != null) && (localContext != null))
    {
      paramHashMap = (VideoAd)AdCache.load(localContext, paramHashMap);
      if ((paramHashMap != null) && (paramHashMap.isOnDisk(localContext)) && (!paramHashMap.isExpired())) {
        return MMJSResponse.responseWithSuccess();
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/MMCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */