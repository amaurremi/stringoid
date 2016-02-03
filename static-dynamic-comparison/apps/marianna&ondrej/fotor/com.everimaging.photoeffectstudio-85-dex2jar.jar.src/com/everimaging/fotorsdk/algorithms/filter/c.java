package com.everimaging.fotorsdk.algorithms.filter;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Type;
import android.support.v8.renderscript.Type.Builder;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSMosaicBaseFilterParams;

public class c
        extends a<d> {
    public c(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject1 = (RSMosaicBaseFilterParams) b();
        Object localObject2 = ((RSMosaicBaseFilterParams) localObject1).getMode();
        float f = ((RSMosaicBaseFilterParams) localObject1).getBlurPixels();
        localObject1 = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        int i = ((Allocation) localObject1).getType().getX();
        int j = ((Allocation) localObject1).getType().getY();
        if (f <= 1.0F) {
            paramRenderScript = (RenderScript) localObject1;
            return paramRenderScript;
        }
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, ((Allocation) localObject1).getType());
        }
        for (; ; ) {
            d locald = (d) a();
            Type.Builder localBuilder = new Type.Builder(paramRenderScript, Element.RGBA_8888(paramRenderScript));
            Sampler localSampler = Sampler.CLAMP_NEAREST(paramRenderScript);
            switch (1. a[localObject2.ordinal()])
            {
            }
            for (; ; ) {
                paramRenderScript = paramContext;
                if (this.a == null) {
                    break;
                }
                this.a.b();
                return paramContext;
                locald.a((Allocation) localObject1);
                locald.U(f);
                locald.aL((Allocation) localObject1, paramContext);
                continue;
                localBuilder.setX((int) Math.ceil(i / f));
                localBuilder.setY((int) Math.ceil(j / f));
                localObject2 = Allocation.createTyped(paramRenderScript, localBuilder.create());
                paramRenderScript = Allocation.createTyped(paramRenderScript, localBuilder.create(), Allocation.MipmapControl.MIPMAP_NONE, 2);
                locald.c((Allocation) localObject1);
                locald.a(i);
                locald.b(j);
                locald.U(f);
                locald.aM((Allocation) localObject2, paramRenderScript);
                locald.c(paramRenderScript);
                locald.a(localSampler);
                locald.K(1.0F);
                locald.D((Allocation) localObject1, paramContext);
                ((Allocation) localObject2).destroy();
                paramRenderScript.destroy();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */