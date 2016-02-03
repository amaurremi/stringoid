package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Float3;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSMultiplyMatrixPlusBiasBaseFilterParams;

public class z
        extends a<d> {
    public z(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSMultiplyMatrixPlusBiasBaseFilterParams) b();
        Float3 localFloat31 = ((RSMultiplyMatrixPlusBiasBaseFilterParams) localObject).getVectorR();
        Float3 localFloat32 = ((RSMultiplyMatrixPlusBiasBaseFilterParams) localObject).getVectorG();
        Float3 localFloat33 = ((RSMultiplyMatrixPlusBiasBaseFilterParams) localObject).getVectorB();
        localObject = ((RSMultiplyMatrixPlusBiasBaseFilterParams) localObject).getVectorBias();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        paramRenderScript = (d) a();
        paramRenderScript.i(localFloat31);
        paramRenderScript.j(localFloat32);
        paramRenderScript.k(localFloat33);
        paramRenderScript.l((Float3) localObject);
        paramRenderScript.aN(localAllocation, paramContext);
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */