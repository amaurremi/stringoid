package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;

public class t
        extends a<d> {
    public t(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int i = localAllocation.getType().getX();
        int j = localAllocation.getType().getY();
        paramRenderScript = (d) a();
        paramRenderScript.a(localAllocation);
        paramRenderScript.b(paramContext);
        paramRenderScript.a(i);
        paramRenderScript.b(j);
        paramRenderScript.C(localAllocation, paramContext);
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */