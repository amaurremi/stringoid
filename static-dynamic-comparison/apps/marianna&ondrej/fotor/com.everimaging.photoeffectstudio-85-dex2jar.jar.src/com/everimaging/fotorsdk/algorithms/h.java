package com.everimaging.fotorsdk.algorithms;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;

public abstract class h
        extends d {
    abstract Allocation a();

    public final Allocation getFutureAllocation(Context paramContext, RenderScript paramRenderScript) {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */