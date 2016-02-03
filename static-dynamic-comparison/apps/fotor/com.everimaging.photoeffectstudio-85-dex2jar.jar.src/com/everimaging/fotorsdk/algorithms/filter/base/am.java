package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.Float4;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.ETiltShiftMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSTiltShiftBaseFilterParams;

public class am
        extends a<d> {
    public am(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSTiltShiftBaseFilterParams) b();
        ETiltShiftMode localETiltShiftMode = ((RSTiltShiftBaseFilterParams) localObject).getMode();
        float f1 = ((RSTiltShiftBaseFilterParams) localObject).getBlurStart();
        float f2 = ((RSTiltShiftBaseFilterParams) localObject).getBlurRange();
        Float2 localFloat21 = ((RSTiltShiftBaseFilterParams) localObject).getBlurNormal();
        Float2 localFloat22 = ((RSTiltShiftBaseFilterParams) localObject).getBlurCentralPos();
        Float2 localFloat23 = ((RSTiltShiftBaseFilterParams) localObject).getRadiusStart();
        localObject = ((RSTiltShiftBaseFilterParams) localObject).getRotationMatrix();
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        Allocation localAllocation2 = a(paramContext, paramRenderScript, "dst");
        paramContext = a(paramContext, paramRenderScript, "texture0");
        paramRenderScript = Sampler.CLAMP_LINEAR(paramRenderScript);
        int i = localAllocation1.getType().getX();
        int j = localAllocation1.getType().getY();
        d locald = (d) a();
        locald.a(paramRenderScript);
        switch (1. a[localETiltShiftMode.ordinal()])
        {
        }
        for (; ; ) {
            if (this.a != null) {
                this.a.b();
            }
            return localAllocation2;
            locald.f(paramContext);
            locald.a(i);
            locald.b(j);
            locald.L(f1);
            locald.M(f2);
            locald.a(localFloat21);
            locald.b(localFloat22);
            locald.bb(localAllocation1, localAllocation2);
            continue;
            locald.f(paramContext);
            locald.a(i);
            locald.b(j);
            locald.M(f2);
            locald.b(localFloat22);
            locald.c(localFloat23);
            locald.a((Float4) localObject);
            locald.bc(localAllocation1, localAllocation2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */