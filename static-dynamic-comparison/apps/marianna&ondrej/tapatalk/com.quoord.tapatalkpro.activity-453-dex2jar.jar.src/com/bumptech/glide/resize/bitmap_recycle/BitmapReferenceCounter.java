package com.bumptech.glide.resize.bitmap_recycle;

import android.graphics.Bitmap;

public abstract interface BitmapReferenceCounter {
    public abstract void acquireBitmap(Bitmap paramBitmap);

    public abstract void releaseBitmap(Bitmap paramBitmap);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/bitmap_recycle/BitmapReferenceCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */