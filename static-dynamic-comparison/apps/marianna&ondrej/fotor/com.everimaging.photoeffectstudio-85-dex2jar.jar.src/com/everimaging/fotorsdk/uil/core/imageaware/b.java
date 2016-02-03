package com.everimaging.fotorsdk.uil.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.everimaging.fotorsdk.uil.core.assist.ViewScaleType;
import com.everimaging.fotorsdk.uil.core.assist.e;

public class b
        implements a {
    protected final String a;
    protected final e b;
    protected final ViewScaleType c;

    public b(String paramString, e parame, ViewScaleType paramViewScaleType) {
        this.a = paramString;
        this.b = parame;
        this.c = paramViewScaleType;
    }

    public int a() {
        return this.b.a();
    }

    public boolean a(int paramInt) {
        return true;
    }

    public boolean a(Bitmap paramBitmap) {
        return true;
    }

    public boolean a(Drawable paramDrawable) {
        return true;
    }

    public int b() {
        return this.b.b();
    }

    public ViewScaleType c() {
        return this.c;
    }

    public View d() {
        return null;
    }

    public boolean e() {
        return false;
    }

    public int f() {
        if (TextUtils.isEmpty(this.a)) {
            return super.hashCode();
        }
        return this.a.hashCode();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/imageaware/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */