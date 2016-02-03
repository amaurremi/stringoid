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

public class ag
        extends a<d> {
    public ag(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        Allocation localAllocation2 = this.a.a("1.jpg", 2);
        Allocation localAllocation3 = this.a.a("2.jpg", 2);
        Allocation localAllocation4 = this.a.a("3.jpg", 2);
        paramRenderScript = Sampler.CLAMP_NEAREST(paramRenderScript);
        int i = localAllocation2.getType().getX();
        int j = localAllocation2.getType().getY();
        d locald = (d) a();
        locald.g(localAllocation2);
        locald.h(localAllocation3);
        locald.i(localAllocation4);
        locald.a(paramRenderScript);
        locald.c(i);
        locald.d(j);
        locald.a(0.0F);
        locald.b(0.82F);
        locald.n(0.0F);
        locald.o(0.15F);
        locald.p(0.4F);
        locald.q(0.6F);
        locald.r(0.8F);
        locald.aW(localAllocation1, paramContext);
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */