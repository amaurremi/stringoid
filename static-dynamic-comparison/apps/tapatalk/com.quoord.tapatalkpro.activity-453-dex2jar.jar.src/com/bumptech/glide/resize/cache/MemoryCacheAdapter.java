package com.bumptech.glide.resize.cache;

import android.graphics.Bitmap;

public class MemoryCacheAdapter
        implements MemoryCache {
    private MemoryCache.ImageRemovedListener listener;

    public void clearMemory() {
    }

    public boolean contains(String paramString) {
        return false;
    }

    public Bitmap get(String paramString) {
        return null;
    }

    public Bitmap put(String paramString, Bitmap paramBitmap) {
        this.listener.onImageRemoved(paramBitmap);
        return null;
    }

    public void setImageRemovedListener(MemoryCache.ImageRemovedListener paramImageRemovedListener) {
        this.listener = paramImageRemovedListener;
    }

    public void trimMemory(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/cache/MemoryCacheAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */