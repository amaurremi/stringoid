package com.mopub.nativeads;

import android.graphics.Bitmap;

import java.util.Map;

abstract interface ImageService$ImageServiceListener {
    public abstract void onFail();

    public abstract void onSuccess(Map<String, Bitmap> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImageService$ImageServiceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */