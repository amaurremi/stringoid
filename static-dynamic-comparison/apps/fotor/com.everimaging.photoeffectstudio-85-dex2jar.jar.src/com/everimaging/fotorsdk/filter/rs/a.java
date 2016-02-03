package com.everimaging.fotorsdk.filter.rs;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.g;
import com.everimaging.fotorsdk.filter.a.a;
import com.everimaging.fotorsdk.filter.b;

public abstract class a
        implements b {
    protected RenderScript a;
    protected Context b;
    protected g c;
    protected Bitmap d;
    protected Bitmap e;
    protected BaseParams f;

    public a(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, BaseParams paramBaseParams) {
        this.a = parama.getRenderScript();
        this.b = parama.getContext();
        this.d = paramBitmap1;
        this.e = paramBitmap2;
        this.f = paramBaseParams;
        this.c = new g(this.b, this.a, parama.getScript_BaseFilter());
    }

    public void b() {
        try {
            if (this.c != null) {
                this.c.e();
            }
            return;
        } catch (Throwable localThrowable) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/filter/rs/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */