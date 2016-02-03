package com.everimaging.fotorsdk.editor.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;

public abstract class a {
    protected Context a;
    protected a b;
    protected Bitmap c;
    protected Bitmap d;
    protected BaseParams e;
    protected boolean f;

    public a(a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, BaseParams paramBaseParams) {
        this.b = parama;
        this.a = parama.getContext();
        this.c = paramBitmap1;
        this.d = paramBitmap2;
        this.e = paramBaseParams;
        this.f = false;
    }

    public abstract Bitmap a();

    public void b() {
        this.e = null;
        this.f = true;
    }

    public Bitmap c() {
        return this.d;
    }

    public Bitmap d() {
        return this.c;
    }

    protected void finalize()
            throws Throwable {
        if (!this.f) {
            b();
        }
        super.finalize();
    }

    public static abstract interface a {
        public abstract Context getContext();

        public abstract RenderScript getRenderScript();

        public abstract d getScript_BaseFilter();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */