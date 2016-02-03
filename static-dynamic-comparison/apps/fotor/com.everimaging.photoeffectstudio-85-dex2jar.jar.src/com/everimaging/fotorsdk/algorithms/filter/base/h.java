package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.EDifferenceBlendMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSDifferenceBlendBaseFilterParams;

public class h
        extends com.everimaging.fotorsdk.algorithms.a<d> {
    public h(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSDifferenceBlendBaseFilterParams) b();
        EDifferenceBlendMode localEDifferenceBlendMode = ((RSDifferenceBlendBaseFilterParams) localObject).getMode();
        Allocation localAllocation = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, localAllocation.getType());
        }
        for (; ; ) {
            d locald = (d) a();
            switch (1. a[localEDifferenceBlendMode.ordinal()])
            {
            }
            for (localObject = null; ; localObject = com.everimaging.fotorsdk.algorithms.cpu.a.a(((RSDifferenceBlendBaseFilterParams) localObject).getSigma())) {
                paramRenderScript = Allocation.createSized(paramRenderScript, Element.F32(paramRenderScript), localObject.length);
                paramRenderScript.copyFrom((float[]) localObject);
                locald.b(paramContext);
                locald.o(paramRenderScript);
                locald.i(localAllocation, paramContext);
                if (this.a != null) {
                    this.a.b();
                }
                return paramContext;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */