package com.mopub.nativeads;

import android.graphics.Bitmap;
import com.mopub.common.DownloadResponse;
import com.mopub.common.logging.MoPubLog;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ImageService$ImageDownloadResponseListener
        implements TaskManager.TaskManagerListener<DownloadResponse> {
    private final Map<String, Bitmap> mBitmaps;
    private final ImageService.ImageServiceListener mImageServiceListener;

    ImageService$ImageDownloadResponseListener(ImageService.ImageServiceListener paramImageServiceListener, Map<String, Bitmap> paramMap) {
        this.mImageServiceListener = paramImageServiceListener;
        this.mBitmaps = paramMap;
    }

    public void onFail() {
        this.mImageServiceListener.onFail();
    }

    public void onSuccess(Map<String, DownloadResponse> paramMap) {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            Bitmap localBitmap = ImageService.asBitmap((DownloadResponse) localEntry.getValue(), ImageService.access$000());
            String str = (String) localEntry.getKey();
            if (localBitmap == null) {
                MoPubLog.d("Error decoding image for url: " + (String) localEntry.getKey());
                onFail();
                return;
            }
            ImageService.putDataInCache(str, localBitmap, ((DownloadResponse) localEntry.getValue()).getByteArray());
            this.mBitmaps.put(str, localBitmap);
        }
        this.mImageServiceListener.onSuccess(this.mBitmaps);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImageService$ImageDownloadResponseListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */