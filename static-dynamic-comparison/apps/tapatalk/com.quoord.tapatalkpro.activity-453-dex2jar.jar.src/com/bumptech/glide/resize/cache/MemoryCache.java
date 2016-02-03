package com.bumptech.glide.resize.cache;

import android.graphics.Bitmap;

public abstract interface MemoryCache {
    public abstract void clearMemory();

    public abstract boolean contains(String paramString);

    public abstract Bitmap get(String paramString);

    public abstract Bitmap put(String paramString, Bitmap paramBitmap);

    public abstract void setImageRemovedListener(ImageRemovedListener paramImageRemovedListener);

    public abstract void trimMemory(int paramInt);

    public static abstract interface ImageRemovedListener {
        public abstract void onImageRemoved(Bitmap paramBitmap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/cache/MemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */