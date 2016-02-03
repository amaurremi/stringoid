package com.everimaging.fotorsdk.algorithms.filter;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSCurveBaseFilterParams;

public class b
        extends a<d> {
    private Allocation b;

    public b(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        d locald = (d) a();
        Object localObject = a(paramContext, paramRenderScript, "dst");
        RSCurveBaseFilterParams localRSCurveBaseFilterParams = (RSCurveBaseFilterParams) b();
        paramContext = (Context) localObject;
        if (localObject == null) {
            paramContext = Allocation.createSized(paramRenderScript, Element.F32(paramRenderScript), 256);
        }
        if (this.b == null) {
            this.b = Allocation.createSized(paramRenderScript, Element.F32_2(paramRenderScript), 5);
        }
        paramRenderScript = localRSCurveBaseFilterParams.getControlPoints();
        int j = paramRenderScript.length / 2;
        if (j > 5) {
            throw new IllegalStateException("max control point is 5,if u want add point please change CurveGenRSFilter class CONTROL_POINT_NUM");
        }
        localObject = new float[10];
        int i = 0;
        while (i < paramRenderScript.length) {
            localObject[i] = paramRenderScript[i];
            i += 1;
        }
        this.b.copyFrom((float[]) localObject);
        locald.p(this.b);
        locald.k(paramContext);
        locald.h(j);
        locald.a();
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */