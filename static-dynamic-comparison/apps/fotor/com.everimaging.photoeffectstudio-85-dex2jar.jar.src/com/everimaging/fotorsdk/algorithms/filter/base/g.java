package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSCurveBaseFilterParams;

public class g
        extends a<d> {
    private RenderScript b;
    private d c;

    public g(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation a(Allocation paramAllocation1, Allocation paramAllocation2, Allocation paramAllocation3, Allocation paramAllocation4) {
        this.c.l(paramAllocation2);
        this.c.m(paramAllocation3);
        this.c.n(paramAllocation4);
        this.c.d(paramAllocation1);
        this.c.r(paramAllocation1);
        return paramAllocation1;
    }

    protected Allocation a(float[] paramArrayOfFloat) {
        Allocation localAllocation1 = Allocation.createSized(this.b, Element.F32_2(this.b), paramArrayOfFloat.length / 2);
        localAllocation1.copyFrom(paramArrayOfFloat);
        Allocation localAllocation2 = Allocation.createSized(this.b, Element.F32(this.b), 256);
        this.c.p(localAllocation1);
        this.c.k(localAllocation2);
        this.c.h(paramArrayOfFloat.length / 2);
        this.c.a();
        return localAllocation2;
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject1 = (RSCurveBaseFilterParams) b();
        Object localObject2 = ((RSCurveBaseFilterParams) localObject1).getMode();
        this.b = paramRenderScript;
        this.c = ((d) a());
        switch (1. a[localObject2.ordinal()])
        {
            default:
                return null;
            case 1:
                return d();
            case 2:
                return a(((RSCurveBaseFilterParams) localObject1).getControlPoints());
            case 3:
                paramContext = Allocation.createSized(this.b, Element.U8_4(this.b), 256);
                a(paramContext, ((RSCurveBaseFilterParams) localObject1).getCurveR(), ((RSCurveBaseFilterParams) localObject1).getCurveG(), ((RSCurveBaseFilterParams) localObject1).getCurveB());
                return paramContext;
        }
        paramContext = a(paramContext, paramRenderScript, "table_texture0");
        paramRenderScript = ((RSCurveBaseFilterParams) localObject1).getControlPointsR();
        localObject2 = ((RSCurveBaseFilterParams) localObject1).getControlPointsG();
        localObject1 = ((RSCurveBaseFilterParams) localObject1).getControlPointsB();
        a(paramContext, a(paramRenderScript), a((float[]) localObject2), a((float[]) localObject1));
        return paramContext;
    }

    protected Allocation d() {
        Allocation localAllocation = Allocation.createSized(this.b, Element.F32(this.b), 256);
        this.c.k(localAllocation);
        this.c.q(localAllocation);
        return localAllocation;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */