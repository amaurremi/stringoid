package com.everimaging.fotorsdk.algorithms;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptC;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;

import java.util.HashMap;
import java.util.Map;

public abstract class f {
    protected e a;
    private Allocation b;
    private Map<String, d> c = new HashMap();
    private RSBaseParams d;

    public f(RSBaseParams paramRSBaseParams) {
        this.d = paramRSBaseParams;
    }

    public final Allocation a(Context paramContext, RenderScript paramRenderScript, String paramString) {
        paramString = (d) this.c.get(paramString);
        if (paramString == null) {
            return null;
        }
        return paramString.getFutureAllocation(paramContext, paramRenderScript);
    }

    public final f a(String paramString, Bitmap paramBitmap) {
        this.c.put(paramString, b.a(paramBitmap));
        return this;
    }

    public final f a(String paramString, d paramd) {
        this.c.put(paramString, paramd);
        return this;
    }

    public final f a(String paramString, h paramh) {
        this.c.put(paramString, paramh);
        return this;
    }

    void a(Context paramContext, RenderScript paramRenderScript) {
        this.c.clear();
        d(paramContext, paramRenderScript);
    }

    abstract void a(Context paramContext, ScriptC paramScriptC);

    public void a(e parame) {
        this.a = parame;
    }

    protected abstract Allocation b(Context paramContext, RenderScript paramRenderScript);

    public RSBaseParams b() {
        return this.d;
    }

    final Allocation c() {
        return this.b;
    }

    protected void d(Context paramContext, RenderScript paramRenderScript) {
    }

    Allocation e(Context paramContext, RenderScript paramRenderScript)
            throws IllegalStateException {
        this.b = b(paramContext, paramRenderScript);
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */