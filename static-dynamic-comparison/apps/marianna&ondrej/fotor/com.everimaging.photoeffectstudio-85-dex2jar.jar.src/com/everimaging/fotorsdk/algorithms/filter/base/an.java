package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.Float4;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.EBlendMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSVignetteBaseFilterParams;

public class an
        extends a<d> {
    private boolean b;
    private float c;
    private float d;
    private float e;
    private float f;

    public an(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected void a(float paramFloat1, float paramFloat2) {
        if (paramFloat1 > 0.0F) {
            this.b = true;
        }
        for (this.c = paramFloat1; ; this.c = (-paramFloat1)) {
            paramFloat1 = (float) Math.pow(2.0D, paramFloat2 * 0.01D);
            this.d = (paramFloat1 * paramFloat1);
            this.e = (this.d + 1.0F);
            paramFloat1 = this.d / this.e;
            this.f = (paramFloat1 * paramFloat1);
            return;
            this.b = false;
        }
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        RSVignetteBaseFilterParams localRSVignetteBaseFilterParams = (RSVignetteBaseFilterParams) b();
        Object localObject = localRSVignetteBaseFilterParams.getMode();
        float f1 = localRSVignetteBaseFilterParams.getVignetteStart();
        float f2 = localRSVignetteBaseFilterParams.getVignetteRange();
        float f3 = localRSVignetteBaseFilterParams.getAmount();
        float f4 = localRSVignetteBaseFilterParams.getCenter();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int i = localAllocation.getType().getX();
        int j = localAllocation.getType().getY();
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, localAllocation.getType());
        }
        for (; ; ) {
            paramRenderScript = (d) a();
            paramRenderScript.a(i);
            paramRenderScript.b(j);
            switch (1. a[localObject.ordinal()])
            {
            }
            for (; ; ) {
                if (this.a != null) {
                    this.a.b();
                }
                return paramContext;
                paramRenderScript.E(f1);
                paramRenderScript.F(f2);
                paramRenderScript.bd(localAllocation, paramContext);
                continue;
                paramRenderScript.E(f1);
                paramRenderScript.F(f2);
                paramRenderScript.be(localAllocation, paramContext);
                continue;
                a(f3, f4);
                paramRenderScript.b(this.b);
                paramRenderScript.G(this.c);
                paramRenderScript.H(this.d);
                paramRenderScript.I(this.e);
                paramRenderScript.J(this.f);
                paramRenderScript.bf(localAllocation, paramContext);
                continue;
                localObject = localRSVignetteBaseFilterParams.getBlendMode();
                Float4 localFloat4 = localRSVignetteBaseFilterParams.getColor();
                f1 = localRSVignetteBaseFilterParams.getIntensity();
                Float2 localFloat21 = localRSVignetteBaseFilterParams.getVignette();
                Float2 localFloat22 = localRSVignetteBaseFilterParams.getVignetteCenter();
                i = localRSVignetteBaseFilterParams.getType();
                paramRenderScript.l(((EBlendMode) localObject).ordinal());
                paramRenderScript.c(localFloat4);
                paramRenderScript.R(f1);
                paramRenderScript.g(localFloat21);
                paramRenderScript.h(localFloat22);
                switch (i) {
                    default:
                        break;
                    case 0:
                        paramRenderScript.bg(localAllocation, paramContext);
                        break;
                    case 1:
                        paramRenderScript.bh(localAllocation, paramContext);
                        break;
                    case 2:
                        paramRenderScript.bi(localAllocation, paramContext);
                        break;
                    case 3:
                        paramRenderScript.bj(localAllocation, paramContext);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */