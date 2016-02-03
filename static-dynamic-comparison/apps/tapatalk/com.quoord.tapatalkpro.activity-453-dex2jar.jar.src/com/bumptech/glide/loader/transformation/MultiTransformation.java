package com.bumptech.glide.loader.transformation;

import android.graphics.Bitmap;
import com.bumptech.glide.resize.bitmap_recycle.BitmapPool;
import com.bumptech.glide.resize.load.Transformation;

public class MultiTransformation
        extends Transformation {
    private final Transformation[] transformations;

    public MultiTransformation(Transformation... paramVarArgs) {
        if (paramVarArgs.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = paramVarArgs;
    }

    public String getId() {
        StringBuilder localStringBuilder = new StringBuilder();
        Transformation[] arrayOfTransformation = this.transformations;
        int j = arrayOfTransformation.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return localStringBuilder.toString();
            }
            localStringBuilder.append(arrayOfTransformation[i].getId());
            i += 1;
        }
    }

    public Bitmap transform(Bitmap paramBitmap, BitmapPool paramBitmapPool, int paramInt1, int paramInt2) {
        Object localObject = null;
        Transformation[] arrayOfTransformation = this.transformations;
        int j = arrayOfTransformation.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return (Bitmap) localObject;
            }
            Bitmap localBitmap = arrayOfTransformation[i].transform(paramBitmap, paramBitmapPool, paramInt1, paramInt2);
            if ((localObject != null) && (localObject != localBitmap) && (!paramBitmapPool.put((Bitmap) localObject))) {
                ((Bitmap) localObject).recycle();
            }
            localObject = localBitmap;
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/transformation/MultiTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */