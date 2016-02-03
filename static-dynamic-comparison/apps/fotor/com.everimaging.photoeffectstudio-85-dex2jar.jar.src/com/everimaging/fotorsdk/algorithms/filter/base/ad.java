package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.ESaturationMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSSaturationBaseFilterParams;

public class ad
        extends a<d> {
    public ad(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSSaturationBaseFilterParams) b();
        ESaturationMode localESaturationMode = ((RSSaturationBaseFilterParams) localObject).getMode();
        float f = ((RSSaturationBaseFilterParams) localObject).getSaturation();
        localObject = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, ((Allocation) localObject).getType());
        }
        for (; ; ) {
            paramRenderScript = (d) a();
            paramRenderScript.j(f);
            switch (1. a[localESaturationMode.ordinal()])
            {
            }
            for (; ; ) {
                if (this.a != null) {
                    this.a.b();
                }
                return paramContext;
                paramRenderScript.aQ((Allocation) localObject, paramContext);
                continue;
                paramRenderScript.aR((Allocation) localObject, paramContext);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */