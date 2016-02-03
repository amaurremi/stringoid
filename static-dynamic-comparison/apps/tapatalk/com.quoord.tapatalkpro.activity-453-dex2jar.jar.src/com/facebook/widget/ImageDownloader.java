package com.facebook.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static WorkQueue downloadQueue;
    private static final Handler handler = new Handler();
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    static {
        downloadQueue = new WorkQueue(8);
    }

    static boolean cancelRequest(ImageRequest arg0) {
        boolean bool = false;
        RequestKey localRequestKey = new RequestKey( ???.getImageUrl(),???.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext localDownloaderContext = (DownloaderContext) pendingRequests.get(localRequestKey);
            if (localDownloaderContext != null) {
                bool = true;
                if (localDownloaderContext.workItem.cancel()) {
                    pendingRequests.remove(localRequestKey);
                }
            } else {
                return bool;
            }
            localDownloaderContext.isCancelled = true;
        }
    }

    private static void download(RequestKey paramRequestKey, Context paramContext) {
        Object localObject7 = null;
        Object localObject6 = null;
        Object localObject12 = null;
        Object localObject13 = null;
        Object localObject11 = null;
        Object localObject10 = null;
        Object localObject8 = null;
        Object localObject9 = null;
        int k = 1;
        int j = 1;
        int i = k;
        Object localObject1 = localObject12;
        Object localObject2 = localObject13;
        for (; ; ) {
            try {
                localHttpURLConnection = (HttpURLConnection) paramRequestKey.url.openConnection();
                localObject6 = localHttpURLConnection;
                i = k;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                localHttpURLConnection.setInstanceFollowRedirects(false);
                localObject6 = localHttpURLConnection;
                i = k;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                switch (localHttpURLConnection.getResponseCode()) {
                    case 301:
                        localObject6 = localHttpURLConnection;
                        i = k;
                        localObject1 = localObject12;
                        localObject7 = localHttpURLConnection;
                        localObject2 = localObject13;
                        localObject5 = localHttpURLConnection.getErrorStream();
                        localObject6 = localHttpURLConnection;
                        i = k;
                        localObject1 = localObject5;
                        localObject7 = localHttpURLConnection;
                        localObject2 = localObject5;
                        paramContext = new InputStreamReader((InputStream) localObject5);
                        localObject6 = localHttpURLConnection;
                        i = k;
                        localObject1 = localObject5;
                        localObject7 = localHttpURLConnection;
                        localObject2 = localObject5;
                        localObject3 = new char[''];
                        localObject6 = localHttpURLConnection;
                        i = k;
                        localObject1 = localObject5;
                        localObject7 = localHttpURLConnection;
                        localObject2 = localObject5;
                        localObject4 = new StringBuilder();
                }
            } catch (IOException paramContext) {
                HttpURLConnection localHttpURLConnection;
                int m;
                Object localObject14;
                Utility.closeQuietly((Closeable) localObject1);
                Utility.disconnectQuietly((URLConnection) localObject6);
                Object localObject3 = localObject8;
                continue;
                localObject6 = localHttpURLConnection;
                i = k;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                Object localObject5 = ImageResponseCache.interceptAndCacheImageStream(paramContext, localHttpURLConnection);
                localObject6 = localHttpURLConnection;
                i = k;
                localObject1 = localObject5;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject5;
                localObject3 = BitmapFactory.decodeStream((InputStream) localObject5);
                Object localObject4 = localObject10;
                continue;
                localObject6 = localHttpURLConnection;
                i = k;
                localObject1 = localObject5;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject5;
                ((StringBuilder) localObject4).append((char[]) localObject3, 0, m);
                continue;
            } finally {
                Utility.closeQuietly((Closeable) localObject2);
                Utility.disconnectQuietly((URLConnection) localObject7);
            }
            localObject6 = localHttpURLConnection;
            i = k;
            localObject1 = localObject5;
            localObject7 = localHttpURLConnection;
            localObject2 = localObject5;
            m = paramContext.read((char[]) localObject3, 0, localObject3.length);
            if (m <= 0) {
                localObject6 = localHttpURLConnection;
                i = k;
                localObject1 = localObject5;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject5;
                Utility.closeQuietly(paramContext);
                localObject6 = localHttpURLConnection;
                i = k;
                localObject1 = localObject5;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject5;
                localObject4 = new FacebookException(((StringBuilder) localObject4).toString());
                localObject3 = localObject9;
                Utility.closeQuietly((Closeable) localObject5);
                Utility.disconnectQuietly(localHttpURLConnection);
                i = j;
                paramContext = (Context) localObject4;
                if (i != 0) {
                    issueResponse(paramRequestKey, paramContext, (Bitmap) localObject3, false);
                }
                return;
                m = 0;
                k = 0;
                localObject6 = localHttpURLConnection;
                i = m;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                localObject14 = localHttpURLConnection.getHeaderField("location");
                localObject3 = localObject9;
                localObject4 = localObject10;
                j = k;
                localObject5 = localObject11;
                localObject6 = localHttpURLConnection;
                i = m;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                if (Utility.isNullOrEmpty((String) localObject14)) {
                    continue;
                }
                localObject6 = localHttpURLConnection;
                i = m;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                localObject14 = new URL((String) localObject14);
                localObject6 = localHttpURLConnection;
                i = m;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                UrlRedirectCache.cacheUrlRedirect(paramContext, paramRequestKey.url, (URL) localObject14);
                localObject6 = localHttpURLConnection;
                i = m;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                paramContext = removePendingRequest(paramRequestKey);
                localObject3 = localObject9;
                localObject4 = localObject10;
                j = k;
                localObject5 = localObject11;
                if (paramContext == null) {
                    continue;
                }
                localObject3 = localObject9;
                localObject4 = localObject10;
                j = k;
                localObject5 = localObject11;
                localObject6 = localHttpURLConnection;
                i = m;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                if (paramContext.isCancelled) {
                    continue;
                }
                localObject6 = localHttpURLConnection;
                i = m;
                localObject1 = localObject12;
                localObject7 = localHttpURLConnection;
                localObject2 = localObject13;
                enqueueCacheRead(paramContext.request, new RequestKey((URL) localObject14, paramRequestKey.tag), false);
                localObject3 = localObject9;
                localObject4 = localObject10;
                j = k;
                localObject5 = localObject11;
                continue;
            }
        }
    }

    static void downloadAsync(ImageRequest paramImageRequest) {
        if (paramImageRequest == null) {
            return;
        }
        RequestKey localRequestKey = new RequestKey(paramImageRequest.getImageUrl(), paramImageRequest.getCallerTag());
        for (; ; ) {
            synchronized (pendingRequests) {
                DownloaderContext localDownloaderContext = (DownloaderContext) pendingRequests.get(localRequestKey);
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

    private static void enqueueCacheRead(ImageRequest paramImageRequest, RequestKey paramRequestKey, boolean paramBoolean) {
        enqueueRequest(paramImageRequest, paramRequestKey, cacheReadQueue, new CacheReadWorkItem(paramImageRequest.getContext(), paramRequestKey, paramBoolean));
    }

    private static void enqueueDownload(ImageRequest paramImageRequest, RequestKey paramRequestKey) {
        enqueueRequest(paramImageRequest, paramRequestKey, downloadQueue, new DownloadImageWorkItem(paramImageRequest.getContext(), paramRequestKey));
    }

    private static void enqueueRequest(ImageRequest paramImageRequest, RequestKey paramRequestKey, WorkQueue paramWorkQueue, Runnable paramRunnable) {
        synchronized (pendingRequests) {
            DownloaderContext localDownloaderContext = new DownloaderContext(null);
            localDownloaderContext.request = paramImageRequest;
            pendingRequests.put(paramRequestKey, localDownloaderContext);
            localDownloaderContext.workItem = paramWorkQueue.addActiveWorkItem(paramRunnable);
            return;
        }
    }

    private static void issueResponse(RequestKey paramRequestKey, final Exception paramException, final Bitmap paramBitmap, final boolean paramBoolean) {
        paramRequestKey = removePendingRequest(paramRequestKey);
        if ((paramRequestKey != null) && (!paramRequestKey.isCancelled)) {
            paramRequestKey = paramRequestKey.request;
            final ImageRequest.Callback localCallback = paramRequestKey.getCallback();
            if (localCallback != null) {
                handler.post(new Runnable() {
                    public void run() {
                        ImageResponse localImageResponse = new ImageResponse(ImageDownloader.this, paramException, paramBoolean, paramBitmap);
                        localCallback.onCompleted(localImageResponse);
                    }
                });
            }
        }
    }

    static void prioritizeRequest(ImageRequest arg0) {
        Object localObject1 = new RequestKey( ???.getImageUrl(),???.getCallerTag());
        synchronized (pendingRequests) {
            localObject1 = (DownloaderContext) pendingRequests.get(localObject1);
            if (localObject1 != null) {
                ((DownloaderContext) localObject1).workItem.moveToFront();
            }
            return;
        }
    }

    private static void readFromCache(RequestKey paramRequestKey, Context paramContext, boolean paramBoolean) {
        Object localObject2 = null;
        boolean bool2 = false;
        Object localObject1 = localObject2;
        boolean bool1 = bool2;
        if (paramBoolean) {
            URL localURL = UrlRedirectCache.getRedirectedUrl(paramContext, paramRequestKey.url);
            localObject1 = localObject2;
            bool1 = bool2;
            if (localURL != null) {
                localObject1 = ImageResponseCache.getCachedImageStream(localURL, paramContext);
                if (localObject1 == null) {
                    break label92;
                }
                bool1 = true;
            }
        }
        if (!bool1) {
            localObject1 = ImageResponseCache.getCachedImageStream(paramRequestKey.url, paramContext);
        }
        if (localObject1 != null) {
            paramContext = BitmapFactory.decodeStream((InputStream) localObject1);
            Utility.closeQuietly((Closeable) localObject1);
            issueResponse(paramRequestKey, null, paramContext, bool1);
        }
        label92:
        do {
            return;
            bool1 = false;
            break;
            paramContext = removePendingRequest(paramRequestKey);
        } while ((paramContext == null) || (paramContext.isCancelled));
        enqueueDownload(paramContext.request, paramRequestKey);
    }

    private static DownloaderContext removePendingRequest(RequestKey paramRequestKey) {
        synchronized (pendingRequests) {
            paramRequestKey = (DownloaderContext) pendingRequests.remove(paramRequestKey);
            return paramRequestKey;
        }
    }

    private static class CacheReadWorkItem
            implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private ImageDownloader.RequestKey key;

        CacheReadWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean) {
            this.context = paramContext;
            this.key = paramRequestKey;
            this.allowCachedRedirects = paramBoolean;
        }

        public void run() {
            ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
        }
    }

    private static class DownloadImageWorkItem
            implements Runnable {
        private Context context;
        private ImageDownloader.RequestKey key;

        DownloadImageWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey) {
            this.context = paramContext;
            this.key = paramRequestKey;
        }

        public void run() {
            ImageDownloader.download(this.key, this.context);
        }
    }

    private static class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;
    }

    private static class RequestKey {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        URL url;

        RequestKey(URL paramURL, Object paramObject) {
            this.url = paramURL;
            this.tag = paramObject;
        }

        public boolean equals(Object paramObject) {
            boolean bool2 = false;
            boolean bool1 = bool2;
            if (paramObject != null) {
                bool1 = bool2;
                if ((paramObject instanceof RequestKey)) {
                    paramObject = (RequestKey) paramObject;
                    if ((((RequestKey) paramObject).url != this.url) || (((RequestKey) paramObject).tag != this.tag)) {
                        break label48;
                    }
                    bool1 = true;
                }
            }
            return bool1;
            label48:
            return false;
        }

        public int hashCode() {
            return (this.url.hashCode() + 1073) * 37 + this.tag.hashCode();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/ImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */