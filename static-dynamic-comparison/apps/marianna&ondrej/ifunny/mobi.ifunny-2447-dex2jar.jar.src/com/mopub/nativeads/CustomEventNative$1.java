package com.mopub.nativeads;

import android.graphics.Bitmap;

import java.util.Map;

class CustomEventNative$1
        implements ImageService.ImageServiceListener {
    CustomEventNative$1(CustomEventNative paramCustomEventNative, CustomEventNative.ImageListener paramImageListener) {
    }

    public void onFail() {
        this.val$imageListener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
    }

    public void onSuccess(Map<String, Bitmap> paramMap) {
        this.val$imageListener.onImagesCached();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/CustomEventNative$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */