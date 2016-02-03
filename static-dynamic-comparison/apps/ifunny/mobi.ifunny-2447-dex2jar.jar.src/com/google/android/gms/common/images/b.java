package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import com.google.android.gms.internal.pc;

final class b
        extends pc<f, Bitmap> {
    protected int a(f paramf, Bitmap paramBitmap) {
        return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }

    protected void a(boolean paramBoolean, f paramf, Bitmap paramBitmap1, Bitmap paramBitmap2) {
        super.a(paramBoolean, paramf, paramBitmap1, paramBitmap2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/images/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */