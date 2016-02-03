package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSMinBaseFilterParams;

public class x
        extends a<d> {
    public x(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        int i = ((RSMinBaseFilterParams) b()).getRadius();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int j = localAllocation.getType().getX();
        int k = localAllocation.getType().getY();
        if (i == 0) {
            paramRenderScript = localAllocation;
            return paramRenderScript;
        }
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, localAllocation.getType());
        }
        for (; ; ) {
            paramRenderScript = (d) a();
            paramRenderScript.a(localAllocation);
            paramRenderScript.a(j);
            paramRenderScript.b(k);
            paramRenderScript.f(i);
            paramRenderScript.aJ(localAllocation, paramContext);
            paramRenderScript = paramContext;
            if (this.a == null) {
                break;
            }
            this.a.b();
            return paramContext;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */