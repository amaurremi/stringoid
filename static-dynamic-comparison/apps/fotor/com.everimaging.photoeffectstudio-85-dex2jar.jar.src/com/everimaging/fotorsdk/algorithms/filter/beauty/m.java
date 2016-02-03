package com.everimaging.fotorsdk.algorithms.filter.beauty;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.beauty.WrinklesParams;

public class m
        extends a<d> {
    public m(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        WrinklesParams localWrinklesParams = (WrinklesParams) b();
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int i = localAllocation1.getType().getX();
        int j = localAllocation1.getType().getY();
        Allocation localAllocation2 = Allocation.createSized(paramRenderScript, Element.U32(paramRenderScript), i);
        d locald = (d) a();
        Allocation localAllocation3 = Allocation.createTyped(paramRenderScript, localAllocation1.getType());
        int k = localWrinklesParams.getRadius();
        locald.a(i);
        locald.b(j);
        locald.f(k);
        locald.j(localAllocation2);
        locald.a(localAllocation1);
        locald.b(localAllocation3);
        locald.c();
        Allocation localAllocation4 = Allocation.createTyped(paramRenderScript, localAllocation1.getType(), 2);
        i = localWrinklesParams.getNoiseMin();
        j = localWrinklesParams.getNoiseMax();
        locald.j(i);
        locald.k(j);
        locald.aO(localAllocation1, localAllocation4);
        paramRenderScript = Sampler.CLAMP_NEAREST(paramRenderScript);
        float f = localWrinklesParams.getNoiseOpacity();
        locald.c(localAllocation4);
        locald.a(paramRenderScript);
        locald.K(f);
        locald.T(localAllocation3, paramContext);
        localAllocation2.destroy();
        localAllocation3.destroy();
        localAllocation4.destroy();
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/beauty/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */