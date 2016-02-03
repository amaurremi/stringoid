package com.everimaging.fotorsdk.algorithms.filter;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.Float4;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Type;
import android.util.Log;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.c;
import com.everimaging.fotorsdk.algorithms.filter.params.TiltShiftParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;

public class e
        extends a<d> {
    private static final String b = e.class.getSimpleName();
    private Allocation c = null;
    private int d = 0;

    public e(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject2 = (TiltShiftParams) b();
        c.a(b, "params:" + localObject2.toString());
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        Object localObject1 = a(paramContext, paramRenderScript, "dst");
        Log.i("SmoothRSFilter", "Src Type: " + localAllocation1.getType());
        Sampler localSampler = Sampler.CLAMP_NEAREST(paramRenderScript);
        paramContext = (Context) localObject1;
        if (localObject1 == null) {
            paramContext = Allocation.createTyped(paramRenderScript, localAllocation1.getType());
        }
        paramContext.copyFrom(localAllocation1);
        if (this.c == null) {
            this.c = Allocation.createTyped(paramRenderScript, localAllocation1.getType(), 2);
        }
        int i = localAllocation1.getType().getX();
        int j = localAllocation1.getType().getY();
        localObject1 = ((TiltShiftParams) localObject2).getMode();
        float f1 = ((TiltShiftParams) localObject2).getBlurStart();
        float f2 = ((TiltShiftParams) localObject2).getBlurRange();
        Float2 localFloat21 = ((TiltShiftParams) localObject2).getBlurNormal();
        Float2 localFloat22 = ((TiltShiftParams) localObject2).getBlurCentralPos();
        Float2 localFloat23 = ((TiltShiftParams) localObject2).getRadiusStart();
        Float4 localFloat4 = ((TiltShiftParams) localObject2).getRotationMatrix();
        int k = ((TiltShiftParams) localObject2).getStrength();
        if (k == 0) {
        }
        for (; ; ) {
            return paramContext;
            localObject2 = (d) a();
            if (k != this.d) {
                Allocation localAllocation2 = Allocation.createSized(paramRenderScript, Element.U32(paramRenderScript), i);
                paramRenderScript = Allocation.createTyped(paramRenderScript, localAllocation1.getType());
                paramRenderScript.copyFrom(localAllocation1);
                ((d) localObject2).a(i);
                ((d) localObject2).b(j);
                ((d) localObject2).f(k);
                ((d) localObject2).j(localAllocation2);
                ((d) localObject2).a(paramRenderScript);
                ((d) localObject2).b(this.c);
                ((d) localObject2).c();
                ((d) localObject2).a(this.c);
                ((d) localObject2).b(paramRenderScript);
                ((d) localObject2).c();
                ((d) localObject2).a(paramRenderScript);
                ((d) localObject2).b(this.c);
                ((d) localObject2).c();
                localAllocation2.destroy();
                paramRenderScript.destroy();
                this.d = k;
            }
            ((d) localObject2).a(localSampler);
            switch (1. a[localObject1.ordinal()])
            {
            }
            while (this.a != null) {
                this.a.b();
                return paramContext;
                ((d) localObject2).f(this.c);
                ((d) localObject2).a(i);
                ((d) localObject2).b(j);
                ((d) localObject2).L(f1);
                ((d) localObject2).M(f2);
                ((d) localObject2).a(localFloat21);
                ((d) localObject2).b(localFloat22);
                ((d) localObject2).bb(localAllocation1, paramContext);
                continue;
                ((d) localObject2).f(this.c);
                ((d) localObject2).a(i);
                ((d) localObject2).b(j);
                ((d) localObject2).M(f2);
                ((d) localObject2).b(localFloat22);
                ((d) localObject2).c(localFloat23);
                ((d) localObject2).a(localFloat4);
                ((d) localObject2).bc(localAllocation1, paramContext);
            }
        }
    }

    protected void d(Context paramContext, RenderScript paramRenderScript) {
        super.d(paramContext, paramRenderScript);
        if (this.c != null) {
            this.c.destroy();
        }
        this.c = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */