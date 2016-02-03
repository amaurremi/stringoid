package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.cpu.c;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSWhiteBalanceBaseFilterParams;

public class ao
        extends a<d> {
    public ao(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSWhiteBalanceBaseFilterParams) b();
        float f1 = ((RSWhiteBalanceBaseFilterParams) localObject).getTemperature();
        float f2 = ((RSWhiteBalanceBaseFilterParams) localObject).getTint();
        localObject = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, ((Allocation) localObject).getType());
        }
        for (; ; ) {
            paramRenderScript = (d) a();
            paramRenderScript.C(f1);
            paramRenderScript.D(f2);
            paramRenderScript.a(new c().a(f1, f2));
            paramRenderScript.bk((Allocation) localObject, paramContext);
            if (this.a != null) {
                this.a.b();
            }
            return paramContext;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */