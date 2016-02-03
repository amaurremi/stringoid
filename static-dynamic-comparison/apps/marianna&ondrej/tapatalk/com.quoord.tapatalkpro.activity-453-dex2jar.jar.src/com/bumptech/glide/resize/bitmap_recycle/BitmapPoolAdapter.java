package com.bumptech.glide.resize.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class BitmapPoolAdapter
        implements BitmapPool {
    public void clearMemory() {
    }

    public Bitmap get(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
        return null;
    }

    public boolean put(Bitmap paramBitmap) {
        return false;
    }

    public void trimMemory(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/bitmap_recycle/BitmapPoolAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */