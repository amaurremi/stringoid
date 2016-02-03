package com.everimaging.fotorsdk.editor.filter;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.editor.filter.params.MosaicParams;

public class f
        extends g {
    private a h;

    public f(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, BaseParams paramBaseParams) {
        super(parama, paramBitmap1, paramBitmap2, paramBaseParams);
    }

    protected e a(boolean paramBoolean) {
        if (paramBoolean) {
            localObject = new com.everimaging.fotorsdk.editor.filter.rs.e(this.b, this.c, this.d, e());
            this.h = ((a) localObject);
            return (e) localObject;
        }
        Object localObject = new com.everimaging.fotorsdk.editor.filter.jni.e(this.a, this.c, this.d, e());
        this.h = ((a) localObject);
        return (e) localObject;
    }

    public MosaicParams e() {
        return (MosaicParams) this.e;
    }

    public Bitmap f() {
        return this.h.a();
    }

    public static abstract interface a {
        public abstract Bitmap a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */