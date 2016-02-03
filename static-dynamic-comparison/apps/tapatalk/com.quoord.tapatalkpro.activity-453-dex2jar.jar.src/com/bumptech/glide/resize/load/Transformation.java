package com.bumptech.glide.resize.load;

import android.graphics.Bitmap;
import com.bumptech.glide.resize.bitmap_recycle.BitmapPool;

public abstract class Transformation {
    public static Transformation CENTER_CROP = new Transformation() {
        public Bitmap transform(Bitmap paramAnonymousBitmap, BitmapPool paramAnonymousBitmapPool, int paramAnonymousInt1, int paramAnonymousInt2) {
            if ((paramAnonymousInt1 <= 0) || (paramAnonymousInt2 <= 0)) {
                throw new IllegalArgumentException("Cannot center crop image to width=" + paramAnonymousInt1 + " and height=" + paramAnonymousInt2);
            }
            return ImageResizer.centerCrop(paramAnonymousBitmapPool.get(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBitmap.getConfig()), paramAnonymousBitmap, paramAnonymousInt1, paramAnonymousInt2);
        }
    };
    public static Transformation FIT_CENTER = new Transformation() {
        public Bitmap transform(Bitmap paramAnonymousBitmap, BitmapPool paramAnonymousBitmapPool, int paramAnonymousInt1, int paramAnonymousInt2) {
            if ((paramAnonymousInt1 <= 0) || (paramAnonymousInt2 <= 0)) {
                throw new IllegalArgumentException("Cannot fit center image to within width=" + paramAnonymousInt1 + " or height=" + paramAnonymousInt2);
            }
            return ImageResizer.fitInSpace(paramAnonymousBitmap, paramAnonymousInt1, paramAnonymousInt2);
        }
    };
    public static Transformation NONE = new Transformation() {
        public Bitmap transform(Bitmap paramAnonymousBitmap, BitmapPool paramAnonymousBitmapPool, int paramAnonymousInt1, int paramAnonymousInt2) {
            return paramAnonymousBitmap;
        }
    };
    private final String id = getClass().toString();

    public String getId() {
        return this.id;
    }

    public abstract Bitmap transform(Bitmap paramBitmap, BitmapPool paramBitmapPool, int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/load/Transformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */