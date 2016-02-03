package com.everimaging.fotorsdk.algorithms.filter.beauty;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.beauty.BlushParams;

public class b
        extends a<d> {
    public b(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        BlushParams localBlushParams = (BlushParams) b();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        Sampler localSampler = Sampler.CLAMP_NEAREST(paramRenderScript);
        int i = localAllocation.getType().getX();
        int j = localAllocation.getType().getY();
        d locald = (d) a();
        paramRenderScript = Allocation.createTyped(paramRenderScript, localAllocation.getType(), 2);
        float f1 = localBlushParams.getRed();
        float f2 = localBlushParams.getGreen();
        float f3 = localBlushParams.getBlue();
        locald.t(f1);
        locald.v(f2);
        locald.x(f3);
        locald.f(localAllocation, paramRenderScript);
        locald.c(paramRenderScript);
        locald.a(localSampler);
        locald.a(i);
        locald.b(j);
        locald.K(1.0F);
        locald.D(localAllocation, paramContext);
        paramRenderScript.destroy();
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/beauty/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */