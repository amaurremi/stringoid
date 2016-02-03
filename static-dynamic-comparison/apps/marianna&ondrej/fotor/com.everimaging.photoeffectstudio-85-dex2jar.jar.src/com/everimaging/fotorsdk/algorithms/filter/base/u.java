package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Float4;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.EBlendMode;
import com.everimaging.fotorsdk.algorithms.params.base.EBlendType;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSLayerBlendBaseFilterParams;

public class u
        extends a<d> {
    private d b;
    private Allocation c;

    public u(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected void a(EBlendMode paramEBlendMode, Allocation paramAllocation1, Allocation paramAllocation2) {
        switch (1. b[paramEBlendMode.ordinal()])
        {
            default:
                return;
            case 1:
                this.b.D(paramAllocation1, paramAllocation2);
                return;
            case 2:
                this.b.F(paramAllocation1, paramAllocation2);
                return;
            case 3:
                this.b.H(paramAllocation1, paramAllocation2);
                return;
            case 4:
                this.b.J(paramAllocation1, paramAllocation2);
                return;
            case 5:
                this.b.L(paramAllocation1, paramAllocation2);
                return;
            case 6:
                this.b.N(paramAllocation1, paramAllocation2);
                return;
            case 7:
                this.b.P(paramAllocation1, paramAllocation2);
                return;
            case 8:
                this.b.R(paramAllocation1, paramAllocation2);
                return;
            case 9:
                this.b.T(paramAllocation1, paramAllocation2);
                return;
            case 10:
                this.b.V(paramAllocation1, paramAllocation2);
                return;
            case 11:
                this.b.X(paramAllocation1, paramAllocation2);
                return;
            case 12:
                this.b.Z(paramAllocation1, paramAllocation2);
                return;
            case 13:
                this.b.ab(paramAllocation1, paramAllocation2);
                return;
            case 14:
                this.b.ad(paramAllocation1, paramAllocation2);
                return;
            case 15:
                this.b.af(paramAllocation1, paramAllocation2);
                return;
            case 16:
                this.b.ah(paramAllocation1, paramAllocation2);
                return;
            case 17:
                this.b.aj(paramAllocation1, paramAllocation2);
                return;
            case 18:
                this.b.al(paramAllocation1, paramAllocation2);
                return;
            case 19:
                this.b.an(paramAllocation1, paramAllocation2);
                return;
            case 20:
                this.b.ap(paramAllocation1, paramAllocation2);
                return;
            case 21:
                this.b.ar(paramAllocation1, paramAllocation2);
                return;
            case 22:
                this.b.at(paramAllocation1, paramAllocation2);
                return;
            case 23:
                this.b.av(paramAllocation1, paramAllocation2);
                return;
            case 24:
                this.b.ax(paramAllocation1, paramAllocation2);
                return;
            case 25:
                this.b.az(paramAllocation1, paramAllocation2);
                return;
            case 26:
                this.b.aB(paramAllocation1, paramAllocation2);
                return;
        }
        this.b.aD(paramAllocation1, paramAllocation2);
    }

    protected void b(EBlendMode paramEBlendMode, Allocation paramAllocation1, Allocation paramAllocation2) {
        switch (1. b[paramEBlendMode.ordinal()])
        {
            default:
                return;
            case 1:
                this.b.E(paramAllocation1, paramAllocation2);
                return;
            case 2:
                this.b.G(paramAllocation1, paramAllocation2);
                return;
            case 3:
                this.b.I(paramAllocation1, paramAllocation2);
                return;
            case 4:
                this.b.K(paramAllocation1, paramAllocation2);
                return;
            case 5:
                this.b.M(paramAllocation1, paramAllocation2);
                return;
            case 6:
                this.b.O(paramAllocation1, paramAllocation2);
                return;
            case 7:
                this.b.Q(paramAllocation1, paramAllocation2);
                return;
            case 8:
                this.b.S(paramAllocation1, paramAllocation2);
                return;
            case 9:
                this.b.U(paramAllocation1, paramAllocation2);
                return;
            case 10:
                this.b.W(paramAllocation1, paramAllocation2);
                return;
            case 11:
                this.b.Y(paramAllocation1, paramAllocation2);
                return;
            case 12:
                this.b.aa(paramAllocation1, paramAllocation2);
                return;
            case 13:
                this.b.ac(paramAllocation1, paramAllocation2);
                return;
            case 14:
                this.b.ae(paramAllocation1, paramAllocation2);
                return;
            case 15:
                this.b.ag(paramAllocation1, paramAllocation2);
                return;
            case 16:
                this.b.ai(paramAllocation1, paramAllocation2);
                return;
            case 17:
                this.b.ak(paramAllocation1, paramAllocation2);
                return;
            case 18:
                this.b.am(paramAllocation1, paramAllocation2);
                return;
            case 19:
                this.b.ao(paramAllocation1, paramAllocation2);
                return;
            case 20:
                this.b.aq(paramAllocation1, paramAllocation2);
                return;
            case 21:
                this.b.as(paramAllocation1, paramAllocation2);
                return;
            case 22:
                this.b.au(paramAllocation1, paramAllocation2);
                return;
            case 23:
                this.b.aw(paramAllocation1, paramAllocation2);
                return;
            case 24:
                this.b.ay(paramAllocation1, paramAllocation2);
                return;
            case 25:
                this.b.aA(paramAllocation1, paramAllocation2);
                return;
            case 26:
                this.b.aC(paramAllocation1, paramAllocation2);
                return;
        }
        this.b.aE(paramAllocation1, paramAllocation2);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSLayerBlendBaseFilterParams) b();
        EBlendType localEBlendType = ((RSLayerBlendBaseFilterParams) localObject).getType();
        EBlendMode localEBlendMode = ((RSLayerBlendBaseFilterParams) localObject).getMode();
        boolean bool = ((RSLayerBlendBaseFilterParams) localObject).isOpacityTex();
        float f1 = ((RSLayerBlendBaseFilterParams) localObject).getOpacity();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        localObject = a(paramContext, paramRenderScript, "dst");
        if (localObject == null) {
            localObject = Allocation.createTyped(paramRenderScript, localAllocation.getType());
        }
        for (; ; ) {
            paramContext = a(paramContext, paramRenderScript, "texture0");
            if (this.c == null) {
                this.c = Allocation.createTyped(paramRenderScript, paramContext.getType(), 2);
            }
            this.c.copyFrom(paramContext);
            paramContext = Sampler.CLAMP_NEAREST(paramRenderScript);
            int i = localAllocation.getType().getX();
            int j = localAllocation.getType().getY();
            this.b = ((d) a());
            this.b.c(this.c);
            this.b.a(paramContext);
            this.b.a(i);
            this.b.b(j);
            float f2;
            float f3;
            float f6;
            float f4;
            if (!bool) {
                paramContext = new Float4();
                f2 = i;
                f3 = j;
                f6 = this.c.getType().getX();
                f4 = this.c.getType().getY();
                float f5 = Math.max(f2 / f6, f3 / f4);
                f6 *= f5;
                f4 *= f5;
                this.b.K(f1);
                switch (1. a[localEBlendType.ordinal()])
                {
                }
            }
            for (; ; ) {
                if (this.a != null) {
                    this.a.b();
                }
                return (Allocation) localObject;
                a(localEBlendMode, localAllocation, (Allocation) localObject);
                continue;
                paramContext.x = (f2 / f6);
                paramContext.y = (f3 / f4);
                paramContext.z = 0.0F;
                paramContext.w = 0.0F;
                this.b.b(paramContext);
                b(localEBlendMode, localAllocation, (Allocation) localObject);
                continue;
                paramContext.x = (f2 / f6);
                paramContext.y = (f3 / f4);
                paramContext.z = ((f6 - f2) / 2.0F / f2);
                paramContext.w = ((f4 - f3) / 2.0F / f3);
                this.b.b(paramContext);
                b(localEBlendMode, localAllocation, (Allocation) localObject);
                continue;
                this.b.b((Allocation) localObject);
                this.b.aF(localAllocation, (Allocation) localObject);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */