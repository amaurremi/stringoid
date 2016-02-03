package com.mopub.nativeads;

import android.graphics.Bitmap;
import com.mopub.common.logging.MoPubLog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ImageService$ImageDiskTaskManagerListener
        implements TaskManager.TaskManagerListener<Bitmap> {
    private final Map<String, Bitmap> mBitmaps;
    private final ImageService.ImageServiceListener mImageServiceListener;

    ImageService$ImageDiskTaskManagerListener(ImageService.ImageServiceListener paramImageServiceListener, Map<String, Bitmap> paramMap) {
        this.mImageServiceListener = paramImageServiceListener;
        this.mBitmaps = paramMap;
    }

    public void onFail() {
        this.mImageServiceListener.onFail();
    }

    public void onSuccess(Map<String, Bitmap> paramMap) {
        ArrayList localArrayList = new ArrayList();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            if (localEntry.getValue() == null) {
                localArrayList.add(localEntry.getKey());
            } else {
                ImageService.putBitmapInCache((String) localEntry.getKey(), (Bitmap) localEntry.getValue());
                this.mBitmaps.put(localEntry.getKey(), localEntry.getValue());
            }
        }
        if (localArrayList.isEmpty()) {
            this.mImageServiceListener.onSuccess(this.mBitmaps);
            return;
        }
        try {
            paramMap = new ImageDownloadTaskManager(localArrayList, new ImageService.ImageDownloadResponseListener(this.mImageServiceListener, this.mBitmaps), ImageService.access$000());
            paramMap.execute();
            return;
        } catch (IllegalArgumentException paramMap) {
            MoPubLog.d("Unable to initialize ImageDownloadTaskManager", paramMap);
            this.mImageServiceListener.onFail();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImageService$ImageDiskTaskManagerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */