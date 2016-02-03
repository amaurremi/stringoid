package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.EHSVSaturation;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSHSVSaturationBaseFilterParams;

public class q
        extends a<d> {
    public q(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        RSHSVSaturationBaseFilterParams localRSHSVSaturationBaseFilterParams = (RSHSVSaturationBaseFilterParams) b();
        EHSVSaturation localEHSVSaturation = localRSHSVSaturationBaseFilterParams.getMode();
        float f1 = localRSHSVSaturationBaseFilterParams.getRed();
        float f2 = localRSHSVSaturationBaseFilterParams.getYellow();
        float f3 = localRSHSVSaturationBaseFilterParams.getGreen();
        float f4 = localRSHSVSaturationBaseFilterParams.getCyan();
        float f5 = localRSHSVSaturationBaseFilterParams.getBlue();
        float f6 = localRSHSVSaturationBaseFilterParams.getMagenta();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        paramRenderScript = (d) a();
        paramRenderScript.t(f1);
        paramRenderScript.u(f2);
        paramRenderScript.v(f3);
        paramRenderScript.w(f4);
        paramRenderScript.x(f5);
        paramRenderScript.y(f6);
        switch (1. a[localEHSVSaturation.ordinal()])
        {
        }
        for (; ; ) {
            if (this.a != null) {
                this.a.b();
            }
            return paramContext;
            paramRenderScript.A(localAllocation, paramContext);
            continue;
            paramRenderScript.i(localRSHSVSaturationBaseFilterParams.getHue());
            paramRenderScript.B(localAllocation, paramContext);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */