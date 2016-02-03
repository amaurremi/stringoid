package com.bumptech.glide.resize.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public abstract interface BitmapPool {
    public abstract void clearMemory();

    public abstract Bitmap get(int paramInt1, int paramInt2, Bitmap.Config paramConfig);

    public abstract boolean put(Bitmap paramBitmap);

    public abstract void trimMemory(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/bitmap_recycle/BitmapPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */