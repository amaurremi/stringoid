package com.mopub.nativeads;

import com.mopub.common.DownloadResponse;
import com.mopub.common.DownloadTask.DownloadTaskListener;
import com.mopub.common.logging.MoPubLog;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class ImageDownloadTaskManager$ImageDownloadTaskListener
        implements DownloadTask.DownloadTaskListener {
    private ImageDownloadTaskManager$ImageDownloadTaskListener(ImageDownloadTaskManager paramImageDownloadTaskManager) {
    }

    public void onComplete(String paramString, DownloadResponse paramDownloadResponse) {
        if ((paramDownloadResponse == null) || (paramDownloadResponse.getStatusCode() != 200)) {
            MoPubLog.d("Failed to download image: " + paramString);
            this.this$0.failAllTasks();
        }
        do {
            return;
            MoPubLog.d("Successfully downloaded image bye array: " + paramString);
            this.this$0.mResults.put(paramString, paramDownloadResponse);
        } while (this.this$0.mCompletedCount.incrementAndGet() != this.this$0.mSize);
        this.this$0.mImageTaskManagerListener.onSuccess(this.this$0.mResults);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImageDownloadTaskManager$ImageDownloadTaskListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */