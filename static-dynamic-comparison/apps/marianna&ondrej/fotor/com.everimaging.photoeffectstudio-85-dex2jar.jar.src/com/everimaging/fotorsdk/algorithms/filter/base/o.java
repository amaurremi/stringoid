package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Float3;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSGradientColorBaseFilterParams;

public class o
        extends a<d> {
    public o(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSGradientColorBaseFilterParams) b();
        float f = ((RSGradientColorBaseFilterParams) localObject).getRatio();
        Float3 localFloat31 = ((RSGradientColorBaseFilterParams) localObject).getGradientColor0();
        Float3 localFloat32 = ((RSGradientColorBaseFilterParams) localObject).getGradientColor1();
        Float3 localFloat33 = ((RSGradientColorBaseFilterParams) localObject).getGradientColor3();
        Float3 localFloat34 = ((RSGradientColorBaseFilterParams) localObject).getGradientColor4();
        localObject = ((RSGradientColorBaseFilterParams) localObject).getGradientColorDefault();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int i = localAllocation.getType().getX();
        int j = localAllocation.getType().getY();
        paramRenderScript = (d) a();
        paramRenderScript.a(i);
        paramRenderScript.b(j);
        paramRenderScript.s(f);
        paramRenderScript.b(localFloat31);
        paramRenderScript.c(localFloat32);
        paramRenderScript.e(localFloat33);
        paramRenderScript.f(localFloat34);
        paramRenderScript.d((Float3) localObject);
        paramRenderScript.u(localAllocation, paramContext);
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */