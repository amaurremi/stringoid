package com.everimaging.fotorsdk.algorithms.filter.beauty;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.beauty.SmoothingParams;

public class k
        extends com.everimaging.fotorsdk.algorithms.a<d> {
    public k(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (SmoothingParams) b();
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int i = localAllocation1.getType().getX();
        int j = localAllocation1.getType().getY();
        Allocation localAllocation2 = Allocation.createSized(paramRenderScript, Element.U32(paramRenderScript), i);
        d locald = (d) a();
        int k = ((SmoothingParams) localObject).getRadius();
        locald.a(i);
        locald.b(j);
        locald.f(k);
        locald.j(localAllocation2);
        locald.a(localAllocation1);
        locald.b(paramContext);
        locald.c();
        localObject = com.everimaging.fotorsdk.algorithms.cpu.a.a(((SmoothingParams) localObject).getSigma());
        paramRenderScript = Allocation.createSized(paramRenderScript, Element.F32(paramRenderScript), localObject.length);
        paramRenderScript.copyFrom((float[]) localObject);
        locald.b(paramContext);
        locald.o(paramRenderScript);
        locald.i(localAllocation1, paramContext);
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/beauty/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */