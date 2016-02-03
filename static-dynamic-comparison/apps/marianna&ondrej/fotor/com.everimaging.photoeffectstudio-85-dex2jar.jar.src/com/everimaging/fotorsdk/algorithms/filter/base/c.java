package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSBrightnessBaseFilterParams;

public class c
        extends a<d> {
    public c(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        float f = ((RSBrightnessBaseFilterParams) b()).getBrightness();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        if (f == 0.0F) {
            paramRenderScript = localAllocation;
            return paramRenderScript;
        }
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, localAllocation.getType());
        }
        for (; ; ) {
            paramRenderScript = (d) a();
            paramRenderScript.c(f);
            paramRenderScript.c(localAllocation, paramContext);
            paramRenderScript = paramContext;
            if (this.a == null) {
                break;
            }
            this.a.b();
            return paramContext;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */