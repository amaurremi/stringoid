package com.everimaging.fotorsdk.uil.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.everimaging.fotorsdk.uil.core.assist.LoadedFrom;
import com.everimaging.fotorsdk.uil.core.process.a;

class h
        implements Runnable {
    private final f a;
    private final Bitmap b;
    private final g c;
    private final Handler d;

    public h(f paramf, Bitmap paramBitmap, g paramg, Handler paramHandler) {
        this.a = paramf;
        this.b = paramBitmap;
        this.c = paramg;
        this.d = paramHandler;
    }

    public void run() {
        if (this.a.a.u) {
            com.everimaging.fotorsdk.uil.utils.c.a("PostProcess image before displaying [%s]", new Object[]{this.c.b});
        }
        b localb = new b(this.c.e.p().a(this.b), this.c, this.a, LoadedFrom.MEMORY_CACHE);
        localb.a(this.a.a.u);
        if (this.c.e.s()) {
            localb.run();
            return;
        }
        this.d.post(localb);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */