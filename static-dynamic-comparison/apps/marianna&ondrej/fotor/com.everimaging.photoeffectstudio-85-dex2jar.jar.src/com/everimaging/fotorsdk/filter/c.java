package com.everimaging.fotorsdk.filter;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public abstract class c
        extends a {
    private static final String h = c.class.getSimpleName();
    private static final FotorLoggerFactory.c i = FotorLoggerFactory.a(h, FotorLoggerFactory.LoggerType.CONSOLE);
    protected b g;

    public c(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, BaseParams paramBaseParams) {
        super(parama, paramBitmap1, paramBitmap2, paramBaseParams);
        boolean bool;
        if (parama.getRenderScript() != null) {
            bool = true;
            paramBitmap1 = i;
            if (!bool) {
                break label64;
            }
        }
        label64:
        for (parama = "run in renderscript mode"; ; parama = " run in jni mode") {
            paramBitmap1.c(new Object[]{parama});
            this.g = a(bool);
            return;
            bool = false;
            break;
        }
    }

    protected abstract b a(boolean paramBoolean);

    public void a() {
        super.a();
        try {
            if (this.g != null) {
                this.g.b();
            }
            return;
        } catch (Throwable localThrowable) {
        }
    }

    public Bitmap c() {
        i.c(new Object[]{"do filter"});
        if ((this.g != null) && (!this.f)) {
            return this.g.a();
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/filter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */