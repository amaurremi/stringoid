package com.everimaging.fotorsdk.uil.core;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.uil.core.assist.LoadedFrom;

final class b
        implements Runnable {
    private final Bitmap a;
    private final String b;
    private final com.everimaging.fotorsdk.uil.core.imageaware.a c;
    private final String d;
    private final com.everimaging.fotorsdk.uil.core.display.a e;
    private final com.everimaging.fotorsdk.uil.core.assist.c f;
    private final f g;
    private final LoadedFrom h;
    private boolean i;

    public b(Bitmap paramBitmap, g paramg, f paramf, LoadedFrom paramLoadedFrom) {
        this.a = paramBitmap;
        this.b = paramg.a;
        this.c = paramg.c;
        this.d = paramg.b;
        this.e = paramg.e.q();
        this.f = paramg.f;
        this.g = paramf;
        this.h = paramLoadedFrom;
    }

    private boolean a() {
        String str = this.g.a(this.c);
        return !this.d.equals(str);
    }

    void a(boolean paramBoolean) {
        this.i = paramBoolean;
    }

    public void run() {
        if (this.c.e()) {
            if (this.i) {
                com.everimaging.fotorsdk.uil.utils.c.a("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[]{this.d});
            }
            this.f.b(this.b, this.c.d());
            return;
        }
        if (a()) {
            if (this.i) {
                com.everimaging.fotorsdk.uil.utils.c.a("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[]{this.d});
            }
            this.f.b(this.b, this.c.d());
            return;
        }
        if (this.i) {
            com.everimaging.fotorsdk.uil.utils.c.a("Display image in ImageAware (loaded from %1$s) [%2$s]", new Object[]{this.h, this.d});
        }
        this.e.a(this.a, this.c, this.h);
        this.f.a(this.b, this.c.d(), this.a);
        this.g.b(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */