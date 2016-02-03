package com.bumptech.glide.resize.cache;

import android.graphics.Bitmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LruMemoryCache
        implements MemoryCache {
    private final LinkedHashMap<String, Bitmap> cache = new LinkedHashMap(15, 0.75F, true);
    private int currentSize = 0;
    private MemoryCache.ImageRemovedListener imageRemovedListener;
    private final int maxSize;

    public LruMemoryCache(int paramInt) {
        this.maxSize = paramInt;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private static int getSize(Bitmap paramBitmap) {
        return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }

    private void trimToSize(int paramInt) {
        for (; ; ) {
            if (this.currentSize <= paramInt) {
                return;
            }
            Map.Entry localEntry = (Map.Entry) this.cache.entrySet().iterator().next();
            Bitmap localBitmap = (Bitmap) localEntry.getValue();
            this.currentSize -= getSize(localBitmap);
            this.cache.remove(localEntry.getKey());
            if (this.imageRemovedListener != null) {
                this.imageRemovedListener.onImageRemoved(localBitmap);
            }
        }
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public boolean contains(String paramString) {
        return this.cache.get(paramString) != null;
    }

    public Bitmap get(String paramString) {
        return (Bitmap) this.cache.get(paramString);
    }

    public Bitmap put(String paramString, Bitmap paramBitmap) {
        this.currentSize += getSize(paramBitmap);
        paramString = (Bitmap) this.cache.put(paramString, paramBitmap);
        evict();
        return paramString;
    }

    public void setImageRemovedListener(MemoryCache.ImageRemovedListener paramImageRemovedListener) {
        this.imageRemovedListener = paramImageRemovedListener;
    }

    public void trimMemory(int paramInt) {
        if (paramInt >= 60) {
            clearMemory();
        }
        while (paramInt < 40) {
            return;
        }
        trimToSize(this.currentSize / 2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/cache/LruMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */