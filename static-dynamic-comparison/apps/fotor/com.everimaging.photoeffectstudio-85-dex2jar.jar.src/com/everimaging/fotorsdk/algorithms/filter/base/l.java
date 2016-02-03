package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSFacetBaseFilterParams;

public class l
        extends a<d> {
    public l(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        Object localObject = (RSFacetBaseFilterParams) b();
        int i = ((RSFacetBaseFilterParams) localObject).getRadius();
        int j = ((RSFacetBaseFilterParams) localObject).getIntensityLevel();
        localObject = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int k = ((Allocation) localObject).getType().getX();
        int m = ((Allocation) localObject).getType().getY();
        if ((i <= 0) || (j <= 0)) {
            paramRenderScript = (RenderScript) localObject;
            return paramRenderScript;
        }
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, ((Allocation) localObject).getType());
        }
        for (; ; ) {
            paramRenderScript = (d) a();
            paramRenderScript.a((Allocation) localObject);
            paramRenderScript.a(k);
            paramRenderScript.b(m);
            paramRenderScript.f(i);
            paramRenderScript.i(j);
            paramRenderScript.n((Allocation) localObject, paramContext);
            paramRenderScript = paramContext;
            if (this.a == null) {
                break;
            }
            this.a.b();
            return paramContext;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */