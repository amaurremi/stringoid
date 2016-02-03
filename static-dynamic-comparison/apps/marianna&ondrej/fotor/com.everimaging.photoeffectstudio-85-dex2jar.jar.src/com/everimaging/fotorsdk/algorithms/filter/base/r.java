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
import com.everimaging.fotorsdk.algorithms.params.base.RSHalfToneBaseFilterParams;

public class r
        extends a<d> {
    public r(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSHalfToneBaseFilterParams) b();
        boolean bool = ((RSHalfToneBaseFilterParams) localObject).isGray();
        int i = ((RSHalfToneBaseFilterParams) localObject).getAmount();
        Float3 localFloat3 = ((RSHalfToneBaseFilterParams) localObject).getHalfToneColor0();
        localObject = ((RSHalfToneBaseFilterParams) localObject).getHalfToneColor1();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int j = localAllocation.getType().getX();
        int k = localAllocation.getType().getY();
        paramRenderScript = (d) a();
        paramRenderScript.a(j);
        paramRenderScript.b(k);
        paramRenderScript.a(bool);
        paramRenderScript.e(i);
        if (!bool) {
            paramRenderScript.g(localFloat3);
            paramRenderScript.h((Float3) localObject);
        }
        paramRenderScript.v(localAllocation, paramContext);
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */