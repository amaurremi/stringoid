package com.mopub.nativeads;

import android.graphics.Bitmap;
import com.mopub.common.CacheService;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class ImageDiskTaskManager
        extends TaskManager<Bitmap> {
    private final int mMaxImageWidth;
    private final List<String> mUrls;

    ImageDiskTaskManager(List<String> paramList, TaskManager.TaskManagerListener<Bitmap> paramTaskManagerListener, int paramInt) {
        super(paramList, paramTaskManagerListener);
        this.mMaxImageWidth = paramInt;
        this.mUrls = paramList;
    }

    void execute() {
        if (this.mUrls.isEmpty()) {
            this.mImageTaskManagerListener.onSuccess(this.mResults);
        }
        ImageDiskTaskManager.ImageDiskTaskListener localImageDiskTaskListener = new ImageDiskTaskManager.ImageDiskTaskListener(this, this.mMaxImageWidth);
        Iterator localIterator = this.mUrls.iterator();
        while (localIterator.hasNext()) {
            CacheService.getFromDiskCacheAsync((String) localIterator.next(), localImageDiskTaskListener);
        }
    }

    void failAllTasks() {
        if (this.mFailed.compareAndSet(false, true)) {
            this.mImageTaskManagerListener.onFail();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImageDiskTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */