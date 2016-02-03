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
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSFrameBaseFilterParams;

public class m
        extends a<d> {
    private RSFrameBaseFilterParams b;

    public m(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        this.b = ((RSFrameBaseFilterParams) b());
        Object localObject2 = this.b.getMode();
        Float2 localFloat21 = this.b.getThickness();
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        Object localObject1 = a(paramContext, paramRenderScript, "dst");
        Allocation localAllocation2 = a(paramContext, paramRenderScript, "texture0");
        Sampler localSampler = Sampler.CLAMP_LINEAR(paramRenderScript);
        int i = localAllocation1.getType().getX();
        int j = localAllocation1.getType().getY();
        float f1 = i / j;
        Float2 localFloat22 = new Float2();
        if (localObject1 == null) {
        }
        for (paramContext = Allocation.createTyped(paramRenderScript, localAllocation1.getType()); ; paramContext = (Context) localObject1) {
            paramRenderScript = (d) a();
            paramRenderScript.c(localAllocation2);
            paramRenderScript.a(localSampler);
            paramRenderScript.a(i);
            paramRenderScript.b(j);
            switch (1. a[localObject2.ordinal()])
            {
            }
            for (; ; ) {
                if (this.a != null) {
                    this.a.b();
                }
                return paramContext;
                localObject1 = d();
                localObject2 = new Float2();
                localFloat21 = new Float2(localFloat21.x, localFloat21.y);
                if (i < j) {
                    localFloat21.x = localFloat21.x;
                }
                for (localFloat21.y = (localFloat21.y * i / j); ; localFloat21.y = localFloat21.y) {
                    ((Float2) localObject2).x = (localObject1[1].z / localObject1[3].z * localFloat21.x);
                    ((Float2) localObject2).y = (localObject1[3].w / localObject1[1].w * localFloat21.y);
                    paramRenderScript.d(localFloat21);
                    paramRenderScript.e((Float2) localObject2);
                    paramRenderScript.a((Float4[]) localObject1);
                    paramRenderScript.o(localAllocation1, paramContext);
                    break;
                    localFloat21.x = (localFloat21.x / i * j);
                }
                paramRenderScript.p(localAllocation1, paramContext);
                continue;
                paramRenderScript.N(f1);
                paramRenderScript.q(localAllocation1, paramContext);
                continue;
                float f2 = localAllocation2.getType().getX() / localAllocation2.getType().getY();
                localFloat22.x = localFloat21.x;
                if (f1 < 1.0F) {
                    localFloat22.x *= f1;
                }
                f1 = localFloat22.x / f1;
                paramRenderScript.d(localFloat22);
                paramRenderScript.O(f2 * f1);
                paramRenderScript.r(localAllocation1, paramContext);
                continue;
                f2 = localAllocation2.getType().getX() / localAllocation2.getType().getY();
                localFloat22.x = localFloat21.x;
                if (f1 > 1.0F) {
                    localFloat22.x *= f1;
                }
                f2 = localFloat22.x / f2;
                paramRenderScript.d(localFloat22);
                paramRenderScript.P(f2 * f1);
                paramRenderScript.s(localAllocation1, paramContext);
            }
        }
    }

    protected Float4[] d() {
        Float4[] arrayOfFloat41 = this.b.getBorderBlock();
        Float4[] arrayOfFloat42 = new Float4[8];
        float f1 = this.b.getWidth();
        float f2 = this.b.getHeight();
        int i = 0;
        while (i < 8) {
            arrayOfFloat42[i] = new Float4();
            arrayOfFloat41[i].x /= f1;
            arrayOfFloat41[i].y /= f2;
            arrayOfFloat41[i].z /= f1;
            arrayOfFloat41[i].w /= f2;
            i += 1;
        }
        return arrayOfFloat42;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */