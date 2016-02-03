package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;

public class ai
        extends a<d> {
    public ai(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        Allocation localAllocation2 = a(paramContext, paramRenderScript, "dst");
        Object localObject = a(paramContext, paramRenderScript, "texture0");
        paramContext = Allocation.createTyped(paramRenderScript, ((Allocation) localObject).getType(), 2);
        paramContext.copyFrom((Allocation) localObject);
        paramRenderScript = Sampler.CLAMP_LINEAR(paramRenderScript);
        int i = localAllocation1.getType().getX();
        int j = localAllocation1.getType().getY();
        localObject = (d) a();
        ((d) localObject).a(i);
        ((d) localObject).b(j);
        ((d) localObject).b(localAllocation2);
        ((d) localObject).c(paramContext);
        ((d) localObject).a(paramRenderScript);
        ((d) localObject).aX(localAllocation1, localAllocation2);
        paramContext.destroy();
        if (this.a != null) {
            this.a.b();
        }
        return localAllocation2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */