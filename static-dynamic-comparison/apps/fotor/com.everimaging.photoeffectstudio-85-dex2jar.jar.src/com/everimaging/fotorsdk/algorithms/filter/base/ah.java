package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.ESmoothMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSSmoothBaseFilterParams;

public class ah
        extends a<d> {
    public ah(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSSmoothBaseFilterParams) b();
        ESmoothMode localESmoothMode = ((RSSmoothBaseFilterParams) localObject).getMode();
        int i = ((RSSmoothBaseFilterParams) localObject).getRadius();
        localObject = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int j = ((Allocation) localObject).getType().getX();
        int k = ((Allocation) localObject).getType().getY();
        paramRenderScript = Allocation.createSized(paramRenderScript, Element.U32(paramRenderScript), j);
        d locald = (d) a();
        locald.a(j);
        locald.b(k);
        locald.f(i);
        locald.j(paramRenderScript);
        switch (1. a[localESmoothMode.ordinal()])
        {
        }
        for (; ; ) {
            paramRenderScript.destroy();
            if (this.a != null) {
                this.a.b();
            }
            return paramContext;
            locald.a((Allocation) localObject);
            locald.b(paramContext);
            locald.c();
            continue;
            locald.a(paramContext);
            locald.b((Allocation) localObject);
            locald.c();
            locald.a((Allocation) localObject);
            locald.b(paramContext);
            locald.c();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */