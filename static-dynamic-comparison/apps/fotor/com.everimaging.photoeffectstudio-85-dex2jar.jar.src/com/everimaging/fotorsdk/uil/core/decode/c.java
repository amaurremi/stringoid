package com.everimaging.fotorsdk.uil.core.decode;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.everimaging.fotorsdk.uil.core.assist.ImageScaleType;
import com.everimaging.fotorsdk.uil.core.assist.ViewScaleType;
import com.everimaging.fotorsdk.uil.core.assist.e;
import com.everimaging.fotorsdk.uil.core.download.ImageDownloader;

public class c {
    private final String a;
    private final String b;
    private final e c;
    private final ImageScaleType d;
    private final ViewScaleType e;
    private final ImageDownloader f;
    private final Object g;
    private final boolean h;
    private final BitmapFactory.Options i;

    public c(String paramString1, String paramString2, e parame, ViewScaleType paramViewScaleType, ImageDownloader paramImageDownloader, com.everimaging.fotorsdk.uil.core.c paramc) {
        this.a = paramString1;
        this.b = paramString2;
        this.c = parame;
        this.d = paramc.j();
        this.e = paramViewScaleType;
        this.f = paramImageDownloader;
        this.g = paramc.n();
        this.h = paramc.m();
        this.i = new BitmapFactory.Options();
        a(paramc.k(), this.i);
    }

    private void a(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2) {
        paramOptions2.inDensity = paramOptions1.inDensity;
        paramOptions2.inDither = paramOptions1.inDither;
        paramOptions2.inInputShareable = paramOptions1.inInputShareable;
        paramOptions2.inJustDecodeBounds = paramOptions1.inJustDecodeBounds;
        paramOptions2.inPreferredConfig = paramOptions1.inPreferredConfig;
        paramOptions2.inPurgeable = paramOptions1.inPurgeable;
        paramOptions2.inSampleSize = paramOptions1.inSampleSize;
        paramOptions2.inScaled = paramOptions1.inScaled;
        paramOptions2.inScreenDensity = paramOptions1.inScreenDensity;
        paramOptions2.inTargetDensity = paramOptions1.inTargetDensity;
        paramOptions2.inTempStorage = paramOptions1.inTempStorage;
        if (Build.VERSION.SDK_INT >= 10) {
            b(paramOptions1, paramOptions2);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            c(paramOptions1, paramOptions2);
        }
    }

    @TargetApi(10)
    private void b(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2) {
        paramOptions2.inPreferQualityOverSpeed = paramOptions1.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private void c(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2) {
        paramOptions2.inBitmap = paramOptions1.inBitmap;
        paramOptions2.inMutable = paramOptions1.inMutable;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public e c() {
        return this.c;
    }

    public ImageScaleType d() {
        return this.d;
    }

    public ViewScaleType e() {
        return this.e;
    }

    public ImageDownloader f() {
        return this.f;
    }

    public Object g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public BitmapFactory.Options i() {
        return this.i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/decode/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */