package com.everimaging.fotorsdk.editor.filter.jni;

import android.content.Context;
import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.editor.filter.e;

public abstract class c
        implements e {
    protected Bitmap a;
    protected Bitmap b;
    protected BaseParams c;
    protected boolean d;

    public c(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, BaseParams paramBaseParams) {
        this.a = paramBitmap1;
        this.b = paramBitmap2;
        this.c = paramBaseParams;
        this.d = false;
    }

    public void c() {
        this.d = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/jni/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */