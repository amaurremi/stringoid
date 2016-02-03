package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.EHSLAdjustmentMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSHSLAdjustmentBaseFilterParams;

public class p
        extends a<d> {
    public p(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSHSLAdjustmentBaseFilterParams) b();
        EHSLAdjustmentMode localEHSLAdjustmentMode = ((RSHSLAdjustmentBaseFilterParams) localObject).getMode();
        float f1 = ((RSHSLAdjustmentBaseFilterParams) localObject).getHue();
        float f2 = ((RSHSLAdjustmentBaseFilterParams) localObject).getSaturation();
        float f3 = ((RSHSLAdjustmentBaseFilterParams) localObject).getLightness();
        localObject = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        paramRenderScript = (d) a();
        paramRenderScript.i(f1);
        paramRenderScript.j(f2);
        paramRenderScript.k(f3);
        switch (1. a[localEHSLAdjustmentMode.ordinal()])
        {
        }
        for (; ; ) {
            if (this.a != null) {
                this.a.b();
            }
            return paramContext;
            paramRenderScript.y((Allocation) localObject, paramContext);
            continue;
            paramRenderScript.z((Allocation) localObject, paramContext);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */