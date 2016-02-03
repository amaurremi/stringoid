package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;

public class aj
        extends a<d> {
    public aj(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        Allocation localAllocation2 = a(paramContext, paramRenderScript, "dst");
        paramContext = a(paramContext, paramRenderScript, "table_texture0");
        paramRenderScript = (d) a();
        paramRenderScript.d(paramContext);
        paramRenderScript.aY(localAllocation1, localAllocation2);
        if (this.a != null) {
            this.a.b();
        }
        return localAllocation2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */