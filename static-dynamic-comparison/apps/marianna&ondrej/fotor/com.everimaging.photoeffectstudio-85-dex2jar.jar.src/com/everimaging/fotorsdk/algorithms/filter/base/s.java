package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSHighlightsBaseFilterParams;

public class s
        extends a<d> {
    public s(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        float f = ((RSHighlightsBaseFilterParams) b()).getHighlights();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, localAllocation.getType());
        }
        for (; ; ) {
            paramRenderScript = (d) a();
            paramRenderScript.h(f);
            paramRenderScript.w(localAllocation, paramContext);
            if (this.a != null) {
                this.a.b();
            }
            return paramContext;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */