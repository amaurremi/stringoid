package com.mopub.common;

import android.graphics.Bitmap;
import android.support.v4.d.f;

class a
        extends f<String, Bitmap> {
    public a(int paramInt) {
        super(paramInt);
    }

    protected int a(String paramString, Bitmap paramBitmap) {
        if (paramBitmap != null) {
            return paramBitmap.getRowBytes() * paramBitmap.getHeight();
        }
        return super.a(paramString, paramBitmap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */