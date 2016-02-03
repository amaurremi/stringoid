package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.EEmbossMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSEmbossBaseFilterParams;

public class k
        extends a<d> {
    public k(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSEmbossBaseFilterParams) b();
        EEmbossMode localEEmbossMode = ((RSEmbossBaseFilterParams) localObject).getMode();
        float f = ((RSEmbossBaseFilterParams) localObject).getStrength();
        localObject = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        Sampler localSampler = Sampler.CLAMP_LINEAR(paramRenderScript);
        int i = ((Allocation) localObject).getType().getX();
        int j = ((Allocation) localObject).getType().getY();
        Float2 localFloat2 = new Float2(1.0F / i, 1.0F / j);
        paramRenderScript = Allocation.createTyped(paramRenderScript, ((Allocation) localObject).getType(), 2);
        paramRenderScript.copyFrom((Allocation) localObject);
        d locald = (d) a();
        locald.a(paramRenderScript);
        locald.a(localSampler);
        locald.a(i);
        locald.b(j);
        locald.B(f);
        locald.f(localFloat2);
        switch (1. a[localEEmbossMode.ordinal()])
        {
        }
        for (; ; ) {
            paramRenderScript.destroy();
            if (this.a != null) {
                this.a.b();
            }
            return paramContext;
            locald.l((Allocation) localObject, paramContext);
            continue;
            locald.m((Allocation) localObject, paramContext);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */