package com.everimaging.fotorsdk.algorithms.filter.beauty;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.beauty.MascaraParams;

public class i
        extends a<d> {
    public i(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        int i = ((MascaraParams) b()).getRadius();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int j = localAllocation.getType().getX();
        int k = localAllocation.getType().getY();
        paramRenderScript = Allocation.createSized(paramRenderScript, Element.U32(paramRenderScript), j);
        d locald = (d) a();
        locald.j(paramRenderScript);
        locald.a(localAllocation);
        locald.b(paramContext);
        locald.a(j);
        locald.b(k);
        locald.f(i);
        locald.d();
        paramRenderScript.destroy();
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/beauty/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */