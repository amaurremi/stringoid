package com.everimaging.fotorsdk.editor.filter;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public abstract class g
        extends a {
    private static final String h = g.class.getSimpleName();
    private static final FotorLoggerFactory.c i = FotorLoggerFactory.a(h, FotorLoggerFactory.LoggerType.CONSOLE);
    protected e g;

    public g(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, BaseParams paramBaseParams) {
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

    public Bitmap a() {
        i.c(new Object[]{"do filter"});
        if ((this.g != null) && (!this.f)) {
            return this.g.b();
        }
        return null;
    }

    protected abstract e a(boolean paramBoolean);

    public void b() {
        super.b();
        try {
            if (this.g != null) {
                this.g.c();
            }
            return;
        } catch (Throwable localThrowable) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */