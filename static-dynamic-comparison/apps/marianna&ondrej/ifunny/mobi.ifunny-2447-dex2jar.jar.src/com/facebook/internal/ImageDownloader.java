package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

import java.io.Closeable;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static Handler handler;
    private static final Map<ImageDownloader.RequestKey, ImageDownloader.DownloaderContext> pendingRequests = new HashMap();

    public static boolean cancelRequest(ImageRequest arg0) {
        ImageDownloader.RequestKey localRequestKey = new ImageDownloader.RequestKey( ???.getImageUri(),???.
        getCallerTag());
        for (; ; ) {
            synchronized (pendingRequests) {
                ImageDownloader.DownloaderContext localDownloaderContext = (ImageDownloader.DownloaderContext) pendingRequests.get(localRequestKey);
                if (localDownloaderContext != null) {
                    if (localDownloaderContext.workItem.cancel()) {
                        pendingRequests.remove(localRequestKey);
                        bool = true;
                        return bool;
                    }
                    localDownloaderContext.isCancelled = true;
                    bool = true;
                }
            }
            boolean bool = false;
        }
    }

    public static void clearCache(Context paramContext) {
        ImageResponseCache.clearCache(paramContext);
        UrlRedirectCache.clearCache(paramContext);
    }

    /* Error */
    private static void download(ImageDownloader.RequestKey paramRequestKey, Context paramContext) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 11
        //   3: aconst_null
        //   4: astore 9
        //   6: aconst_null
        //   7: astore 10
        //   9: iconst_1
        //   10: istore_3
        //   11: iconst_1
        //   12: istore 4
        //   14: iconst_1
        //   15: istore_2
        //   16: new 104	java/net/URL
        //   19: dup
        //   20: aload_0
        //   21: getfield 108	com/facebook/internal/ImageDownloader$RequestKey:uri	Ljava/net/URI;
        //   24: invokevirtual 114	java/net/URI:toString	()Ljava/lang/String;
        //   27: invokespecial 117	java/net/URL:<init>	(Ljava/lang/String;)V
        //   30: invokevirtual 121	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   33: checkcast 123	java/net/HttpURLConnection
        //   36: astore 6
        //   38: aload 6
        //   40: iconst_0
        //   41: invokevirtual 127	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
        //   44: aload 6
        //   46: invokevirtual 131	java/net/HttpURLConnection:getResponseCode	()I
        //   49: lookupswitch	default:+482->531, 200:+273->322, 301:+172->221, 302:+172->221
        //   84: aload 6
        //   86: invokevirtual 135	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
        //   89: astore_1
        //   90: aload_1
        //   91: astore 7
        //   93: aload_1
        //   94: astore 8
        //   96: aload_1
        //   97: astore 9
        //   99: new 137	java/io/InputStreamReader
        //   102: dup
        //   103: aload_1
        //   104: invokespecial 140	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   107: astore 12
        //   109: aload_1
        //   110: astore 7
        //   112: aload_1
        //   113: astore 8
        //   115: aload_1
        //   116: astore 9
        //   118: sipush 128
        //   121: newarray <illegal type>
        //   123: astore 13
        //   125: aload_1
        //   126: astore 7
        //   128: aload_1
        //   129: astore 8
        //   131: aload_1
        //   132: astore 9
        //   134: new 142	java/lang/StringBuilder
        //   137: dup
        //   138: invokespecial 143	java/lang/StringBuilder:<init>	()V
        //   141: astore 14
        //   143: aload_1
        //   144: astore 7
        //   146: aload_1
        //   147: astore 8
        //   149: aload_1
        //   150: astore 9
        //   152: aload 12
        //   154: aload 13
        //   156: iconst_0
        //   157: aload 13
        //   159: arraylength
        //   160: invokevirtual 147	java/io/InputStreamReader:read	([CII)I
        //   163: istore 5
        //   165: iload 5
        //   167: ifle +189 -> 356
        //   170: aload_1
        //   171: astore 7
        //   173: aload_1
        //   174: astore 8
        //   176: aload_1
        //   177: astore 9
        //   179: aload 14
        //   181: aload 13
        //   183: iconst_0
        //   184: iload 5
        //   186: invokevirtual 151	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
        //   189: pop
        //   190: goto -47 -> 143
        //   193: astore_1
        //   194: aload 7
        //   196: invokestatic 157	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   199: aload 6
        //   201: invokestatic 161	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
        //   204: aload 10
        //   206: astore 8
        //   208: iload_2
        //   209: ifeq +11 -> 220
        //   212: aload_0
        //   213: aload_1
        //   214: aload 8
        //   216: iconst_0
        //   217: invokestatic 165	com/facebook/internal/ImageDownloader:issueResponse	(Lcom/facebook/internal/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V
        //   220: return
        //   221: aload 6
        //   223: ldc -89
        //   225: invokevirtual 171	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   228: astore 7
        //   230: aload 7
        //   232: invokestatic 175	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   235: ifne +282 -> 517
        //   238: new 110	java/net/URI
        //   241: dup
        //   242: aload 7
        //   244: invokespecial 176	java/net/URI:<init>	(Ljava/lang/String;)V
        //   247: astore 7
        //   249: aload_1
        //   250: aload_0
        //   251: getfield 108	com/facebook/internal/ImageDownloader$RequestKey:uri	Ljava/net/URI;
        //   254: aload 7
        //   256: invokestatic 180	com/facebook/internal/UrlRedirectCache:cacheUriRedirect	(Landroid/content/Context;Ljava/net/URI;Ljava/net/URI;)V
        //   259: aload_0
        //   260: invokestatic 184	com/facebook/internal/ImageDownloader:removePendingRequest	(Lcom/facebook/internal/ImageDownloader$RequestKey;)Lcom/facebook/internal/ImageDownloader$DownloaderContext;
        //   263: astore_1
        //   264: aload_1
        //   265: ifnull +31 -> 296
        //   268: aload_1
        //   269: getfield 89	com/facebook/internal/ImageDownloader$DownloaderContext:isCancelled	Z
        //   272: ifne +24 -> 296
        //   275: aload_1
        //   276: getfield 188	com/facebook/internal/ImageDownloader$DownloaderContext:request	Lcom/facebook/internal/ImageRequest;
        //   279: new 51	com/facebook/internal/ImageDownloader$RequestKey
        //   282: dup
        //   283: aload 7
        //   285: aload_0
        //   286: getfield 192	com/facebook/internal/ImageDownloader$RequestKey:tag	Ljava/lang/Object;
        //   289: invokespecial 64	com/facebook/internal/ImageDownloader$RequestKey:<init>	(Ljava/net/URI;Ljava/lang/Object;)V
        //   292: iconst_0
        //   293: invokestatic 196	com/facebook/internal/ImageDownloader:enqueueCacheRead	(Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V
        //   296: iconst_0
        //   297: istore_2
        //   298: aconst_null
        //   299: astore 7
        //   301: aconst_null
        //   302: astore_1
        //   303: aload 11
        //   305: astore 8
        //   307: aload_1
        //   308: invokestatic 157	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   311: aload 6
        //   313: invokestatic 161	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
        //   316: aload 7
        //   318: astore_1
        //   319: goto -111 -> 208
        //   322: aload_1
        //   323: aload 6
        //   325: invokestatic 200	com/facebook/internal/ImageResponseCache:interceptAndCacheImageStream	(Landroid/content/Context;Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
        //   328: astore_1
        //   329: aload_1
        //   330: astore 7
        //   332: aload_1
        //   333: astore 8
        //   335: aload_1
        //   336: astore 9
        //   338: aload_1
        //   339: invokestatic 206	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
        //   342: astore 11
        //   344: aconst_null
        //   345: astore 7
        //   347: aload 11
        //   349: astore 8
        //   351: iload_3
        //   352: istore_2
        //   353: goto -46 -> 307
        //   356: aload_1
        //   357: astore 7
        //   359: aload_1
        //   360: astore 8
        //   362: aload_1
        //   363: astore 9
        //   365: aload 12
        //   367: invokestatic 157	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   370: aload_1
        //   371: astore 7
        //   373: aload_1
        //   374: astore 8
        //   376: aload_1
        //   377: astore 9
        //   379: new 208	com/facebook/FacebookException
        //   382: dup
        //   383: aload 14
        //   385: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   388: invokespecial 210	com/facebook/FacebookException:<init>	(Ljava/lang/String;)V
        //   391: astore 12
        //   393: iload_3
        //   394: istore_2
        //   395: aload 11
        //   397: astore 8
        //   399: aload 12
        //   401: astore 7
        //   403: goto -96 -> 307
        //   406: astore_1
        //   407: aload 8
        //   409: astore 7
        //   411: iload 4
        //   413: istore_2
        //   414: aload 7
        //   416: invokestatic 157	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   419: aload 6
        //   421: invokestatic 161	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
        //   424: aload 10
        //   426: astore 8
        //   428: goto -220 -> 208
        //   431: astore_0
        //   432: aconst_null
        //   433: astore_1
        //   434: aload 9
        //   436: invokestatic 157	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   439: aload_1
        //   440: invokestatic 161	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
        //   443: aload_0
        //   444: athrow
        //   445: astore_0
        //   446: aload 6
        //   448: astore_1
        //   449: goto -15 -> 434
        //   452: astore_0
        //   453: aload 6
        //   455: astore_1
        //   456: goto -22 -> 434
        //   459: astore_1
        //   460: aconst_null
        //   461: astore 7
        //   463: aconst_null
        //   464: astore 6
        //   466: iload 4
        //   468: istore_2
        //   469: goto -55 -> 414
        //   472: astore_1
        //   473: aconst_null
        //   474: astore 7
        //   476: iload 4
        //   478: istore_2
        //   479: goto -65 -> 414
        //   482: astore_1
        //   483: aconst_null
        //   484: astore 7
        //   486: iconst_0
        //   487: istore_2
        //   488: goto -74 -> 414
        //   491: astore_1
        //   492: aconst_null
        //   493: astore 7
        //   495: aconst_null
        //   496: astore 6
        //   498: goto -304 -> 194
        //   501: astore_1
        //   502: aconst_null
        //   503: astore 7
        //   505: goto -311 -> 194
        //   508: astore_1
        //   509: aconst_null
        //   510: astore 7
        //   512: iconst_0
        //   513: istore_2
        //   514: goto -320 -> 194
        //   517: iconst_0
        //   518: istore_2
        //   519: aconst_null
        //   520: astore 7
        //   522: aconst_null
        //   523: astore_1
        //   524: aload 11
        //   526: astore 8
        //   528: goto -221 -> 307
        //   531: goto -447 -> 84
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	534	0	paramRequestKey	ImageDownloader.RequestKey
        //   0	534	1	paramContext	Context
        //   15	504	2	i	int
        //   10	384	3	j	int
        //   12	465	4	k	int
        //   163	22	5	m	int
        //   36	461	6	localHttpURLConnection	java.net.HttpURLConnection
        //   91	430	7	localObject1	Object
        //   94	433	8	localObject2	Object
        //   4	431	9	localContext	Context
        //   7	418	10	localObject3	Object
        //   1	524	11	localBitmap	Bitmap
        //   107	293	12	localObject4	Object
        //   123	59	13	arrayOfChar	char[]
        //   141	243	14	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   99	109	193	java/io/IOException
        //   118	125	193	java/io/IOException
        //   134	143	193	java/io/IOException
        //   152	165	193	java/io/IOException
        //   179	190	193	java/io/IOException
        //   338	344	193	java/io/IOException
        //   365	370	193	java/io/IOException
        //   379	393	193	java/io/IOException
        //   99	109	406	java/net/URISyntaxException
        //   118	125	406	java/net/URISyntaxException
        //   134	143	406	java/net/URISyntaxException
        //   152	165	406	java/net/URISyntaxException
        //   179	190	406	java/net/URISyntaxException
        //   338	344	406	java/net/URISyntaxException
        //   365	370	406	java/net/URISyntaxException
        //   379	393	406	java/net/URISyntaxException
        //   16	38	431	finally
        //   38	84	445	finally
        //   84	90	445	finally
        //   221	264	445	finally
        //   268	296	445	finally
        //   322	329	445	finally
        //   99	109	452	finally
        //   118	125	452	finally
        //   134	143	452	finally
        //   152	165	452	finally
        //   179	190	452	finally
        //   338	344	452	finally
        //   365	370	452	finally
        //   379	393	452	finally
        //   16	38	459	java/net/URISyntaxException
        //   38	84	472	java/net/URISyntaxException
        //   84	90	472	java/net/URISyntaxException
        //   322	329	472	java/net/URISyntaxException
        //   221	264	482	java/net/URISyntaxException
        //   268	296	482	java/net/URISyntaxException
        //   16	38	491	java/io/IOException
        //   38	84	501	java/io/IOException
        //   84	90	501	java/io/IOException
        //   322	329	501	java/io/IOException
        //   221	264	508	java/io/IOException
        //   268	296	508	java/io/IOException
    }

    public static void downloadAsync(ImageRequest paramImageRequest) {
        if (paramImageRequest == null) {
            return;
        }
        ImageDownloader.RequestKey localRequestKey = new ImageDownloader.RequestKey(paramImageRequest.getImageUri(), paramImageRequest.getCallerTag());
        for (; ; ) {
            synchronized (pendingRequests) {
                ImageDownloader.DownloaderContext localDownloaderContext = (ImageDownloader.DownloaderContext) pendingRequests.get(localRequestKey);
                if (localDownloaderContext != null) {
                    localDownloaderContext.request = paramImageRequest;
                    localDownloaderContext.isCancelled = false;
                    localDownloaderContext.workItem.moveToFront();
                    return;
                }
            }
            enqueueCacheRead(paramImageRequest, localRequestKey, paramImageRequest.isCachedRedirectAllowed());
        }
    }

    private static void enqueueCacheRead(ImageRequest paramImageRequest, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean) {
        enqueueRequest(paramImageRequest, paramRequestKey, cacheReadQueue, new ImageDownloader.CacheReadWorkItem(paramImageRequest.getContext(), paramRequestKey, paramBoolean));
    }

    private static void enqueueDownload(ImageRequest paramImageRequest, ImageDownloader.RequestKey paramRequestKey) {
        enqueueRequest(paramImageRequest, paramRequestKey, downloadQueue, new ImageDownloader.DownloadImageWorkItem(paramImageRequest.getContext(), paramRequestKey));
    }

    private static void enqueueRequest(ImageRequest paramImageRequest, ImageDownloader.RequestKey paramRequestKey, WorkQueue paramWorkQueue, Runnable paramRunnable) {
        synchronized (pendingRequests) {
            ImageDownloader.DownloaderContext localDownloaderContext = new ImageDownloader.DownloaderContext(null);
            localDownloaderContext.request = paramImageRequest;
            pendingRequests.put(paramRequestKey, localDownloaderContext);
            localDownloaderContext.workItem = paramWorkQueue.addActiveWorkItem(paramRunnable);
            return;
        }
    }

    private static Handler getHandler() {
        try {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            Handler localHandler = handler;
            return localHandler;
        } finally {
        }
    }

    private static void issueResponse(ImageDownloader.RequestKey paramRequestKey, Exception paramException, Bitmap paramBitmap, boolean paramBoolean) {
        paramRequestKey = removePendingRequest(paramRequestKey);
        if ((paramRequestKey != null) && (!paramRequestKey.isCancelled)) {
            paramRequestKey = paramRequestKey.request;
            ImageRequest.Callback localCallback = paramRequestKey.getCallback();
            if (localCallback != null) {
                getHandler().post(new ImageDownloader .1
                (paramRequestKey, paramException, paramBoolean, paramBitmap, localCallback));
            }
        }
    }

    public static void prioritizeRequest(ImageRequest arg0) {
        Object localObject1 = new ImageDownloader.RequestKey( ???.getImageUri(),???.getCallerTag());
        synchronized (pendingRequests) {
            localObject1 = (ImageDownloader.DownloaderContext) pendingRequests.get(localObject1);
            if (localObject1 != null) {
                ((ImageDownloader.DownloaderContext) localObject1).workItem.moveToFront();
            }
            return;
        }
    }

    private static void readFromCache(ImageDownloader.RequestKey paramRequestKey, Context paramContext, boolean paramBoolean) {
        boolean bool = false;
        Object localObject;
        if (paramBoolean) {
            localObject = UrlRedirectCache.getRedirectedUri(paramContext, paramRequestKey.uri);
            if (localObject != null) {
                localObject = ImageResponseCache.getCachedImageStream((URI) localObject, paramContext);
                paramBoolean = bool;
                if (localObject != null) {
                    paramBoolean = true;
                }
            }
        }
        for (; ; ) {
            if (!paramBoolean) {
                localObject = ImageResponseCache.getCachedImageStream(paramRequestKey.uri, paramContext);
            }
            if (localObject != null) {
                paramContext = BitmapFactory.decodeStream((InputStream) localObject);
                Utility.closeQuietly((Closeable) localObject);
                issueResponse(paramRequestKey, null, paramContext, paramBoolean);
            }
            do {
                return;
                paramContext = removePendingRequest(paramRequestKey);
            } while ((paramContext == null) || (paramContext.isCancelled));
            enqueueDownload(paramContext.request, paramRequestKey);
            return;
            paramBoolean = false;
            localObject = null;
        }
    }

    private static ImageDownloader.DownloaderContext removePendingRequest(ImageDownloader.RequestKey paramRequestKey) {
        synchronized (pendingRequests) {
            paramRequestKey = (ImageDownloader.DownloaderContext) pendingRequests.remove(paramRequestKey);
            return paramRequestKey;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/ImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */