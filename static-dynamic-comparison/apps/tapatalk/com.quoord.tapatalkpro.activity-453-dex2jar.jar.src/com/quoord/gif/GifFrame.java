package com.quoord.gif;

import android.graphics.Bitmap;

public class GifFrame {
    public int delay;
    public Bitmap image;
    public GifFrame nextFrame = null;

    public GifFrame(Bitmap paramBitmap, int paramInt) {
        this.image = paramBitmap;
        this.delay = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/gif/GifFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */