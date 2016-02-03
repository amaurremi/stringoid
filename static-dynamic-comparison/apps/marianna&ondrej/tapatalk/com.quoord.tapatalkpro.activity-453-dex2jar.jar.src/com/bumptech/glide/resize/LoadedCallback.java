package com.bumptech.glide.resize;

import android.graphics.Bitmap;

public abstract interface LoadedCallback {
    public abstract void onLoadCompleted(Bitmap paramBitmap);

    public abstract void onLoadFailed(Exception paramException);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/LoadedCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */