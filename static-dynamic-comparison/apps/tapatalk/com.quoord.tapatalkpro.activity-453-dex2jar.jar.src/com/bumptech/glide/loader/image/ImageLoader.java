package com.bumptech.glide.loader.image;

import android.graphics.Bitmap;
import com.bumptech.glide.loader.stream.StreamLoader;
import com.bumptech.glide.resize.load.Transformation;

public abstract interface ImageLoader {
    public abstract void clear();

    public abstract Object fetchImage(String paramString, StreamLoader paramStreamLoader, Transformation paramTransformation, int paramInt1, int paramInt2, ImageReadyCallback paramImageReadyCallback);

    public static abstract interface ImageReadyCallback {
        public abstract void onException(Exception paramException);

        public abstract boolean onImageReady(Bitmap paramBitmap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/image/ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */