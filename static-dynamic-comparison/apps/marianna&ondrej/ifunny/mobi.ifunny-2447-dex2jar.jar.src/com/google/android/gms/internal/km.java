package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

class km
        implements mr<Drawable> {
    km(kk paramkk, boolean paramBoolean) {
    }

    public Drawable a() {
        this.b.a(2, this.a);
        return null;
    }

    public Drawable a(InputStream paramInputStream) {
        try {
            paramInputStream = pt.a(paramInputStream);
            if (paramInputStream == null) {
                this.b.a(2, this.a);
                return null;
            }
        } catch (IOException paramInputStream) {
            for (; ; ) {
                paramInputStream = null;
            }
            paramInputStream = BitmapFactory.decodeByteArray(paramInputStream, 0, paramInputStream.length);
            if (paramInputStream == null) {
                this.b.a(2, this.a);
                return null;
            }
        }
        return new BitmapDrawable(Resources.getSystem(), paramInputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/km.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */