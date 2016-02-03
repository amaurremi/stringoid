package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSConstColorBaseFilterParams;

public class e
        extends a<d> {
    public e(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSConstColorBaseFilterParams) b();
        float f1 = ((RSConstColorBaseFilterParams) localObject).getRed();
        float f2 = ((RSConstColorBaseFilterParams) localObject).getGreen();
        float f3 = ((RSConstColorBaseFilterParams) localObject).getBlue();
        localObject = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        paramRenderScript = (d) a();
        paramRenderScript.t(f1);
        paramRenderScript.v(f2);
        paramRenderScript.x(f3);
        paramRenderScript.f((Allocation) localObject, paramContext);
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */