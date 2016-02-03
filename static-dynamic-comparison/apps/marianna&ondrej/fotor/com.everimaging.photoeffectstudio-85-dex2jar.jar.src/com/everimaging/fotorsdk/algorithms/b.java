package com.everimaging.fotorsdk.algorithms;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.RenderScript;

public class b
        extends d {
    private Bitmap a;
    private Allocation b;

    public static d a(Bitmap paramBitmap) {
        b localb = new b();
        localb.a = paramBitmap;
        return localb;
    }

    protected void finalize()
            throws Throwable {
        this.a = null;
        this.b = null;
        super.finalize();
    }

    public Allocation getFutureAllocation(Context paramContext, RenderScript paramRenderScript) {
        if ((this.b == null) && (this.a != null) && (!this.a.isRecycled())) {
            this.b = Allocation.createFromBitmap(paramRenderScript, this.a, Allocation.MipmapControl.MIPMAP_NONE, 1);
        }
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */