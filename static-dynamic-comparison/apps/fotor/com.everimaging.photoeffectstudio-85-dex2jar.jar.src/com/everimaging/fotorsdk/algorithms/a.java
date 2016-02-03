package com.everimaging.fotorsdk.algorithms;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptC;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;

public abstract class a<T extends ScriptC>
        extends f {
    private static final String b = a.class.getSimpleName();
    private T c;

    public a(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected final T a() {
        return this.c;
    }

    final void a(Context paramContext, RenderScript paramRenderScript) {
        this.c = null;
        super.a(paramContext, paramRenderScript);
    }

    void a(Context paramContext, ScriptC paramScriptC) {
        this.c = paramScriptC;
    }

    protected Allocation b(Context paramContext, RenderScript paramRenderScript)
            throws IllegalStateException {
        if (a() == null) {
            throw new IllegalStateException("script is null,you must set script first.");
        }
        return c(paramContext, paramRenderScript);
    }

    protected abstract Allocation c(Context paramContext, RenderScript paramRenderScript);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */