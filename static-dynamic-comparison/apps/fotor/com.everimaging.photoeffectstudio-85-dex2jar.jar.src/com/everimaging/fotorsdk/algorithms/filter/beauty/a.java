package com.everimaging.fotorsdk.algorithms.filter.beauty;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Script.LaunchOptions;
import android.support.v8.renderscript.Type;
import android.support.v8.renderscript.Type.Builder;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.EBlendMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.beauty.BlemishFixParams;

public class a
        extends com.everimaging.fotorsdk.algorithms.a<d> {
    public a(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject1 = (BlemishFixParams) b();
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        paramContext.copyFrom(localAllocation1);
        int i = ((BlemishFixParams) localObject1).getCenterX();
        int j = ((BlemishFixParams) localObject1).getCenterY();
        int k = ((BlemishFixParams) localObject1).getRadius();
        int m = k * 2 + 1;
        Object localObject2 = new Type.Builder(paramRenderScript, Element.U8_4(paramRenderScript));
        ((Type.Builder) localObject2).setX(m);
        ((Type.Builder) localObject2).setY(m);
        localObject1 = Allocation.createTyped(paramRenderScript, ((Type.Builder) localObject2).create());
        localObject2 = Allocation.createTyped(paramRenderScript, ((Type.Builder) localObject2).create(), Allocation.MipmapControl.MIPMAP_NONE, 2);
        ((Allocation) localObject1).copy2DRangeFrom(0, 0, k, m, localAllocation1, i - k - k, j - k);
        ((Allocation) localObject1).copy2DRangeFrom(k, 0, k + 1, m, localAllocation1, i + k, j - k);
        Allocation localAllocation2 = Allocation.createSized(paramRenderScript, Element.U32(paramRenderScript), m);
        d locald = (d) a();
        locald.a((Allocation) localObject1);
        locald.b((Allocation) localObject2);
        locald.a(m);
        locald.b(m);
        locald.f(8);
        locald.j(localAllocation2);
        locald.c();
        m = localAllocation1.getType().getX();
        int n = localAllocation1.getType().getY();
        paramRenderScript = Sampler.CLAMP_NEAREST(paramRenderScript);
        Script.LaunchOptions localLaunchOptions = new Script.LaunchOptions();
        localLaunchOptions.setX(i - k, i + k);
        localLaunchOptions.setY(j - k, j + k);
        locald.c((Allocation) localObject2);
        locald.a(paramRenderScript);
        locald.a(m);
        locald.b(n);
        locald.m(i - k);
        locald.n(j - k);
        locald.o(i + k);
        locald.p(j + k);
        locald.S(i);
        locald.T(j);
        locald.g(k * k);
        locald.l(EBlendMode.EBM_LIGHTEN.ordinal());
        locald.a(localAllocation1, paramContext);
        ((Allocation) localObject1).destroy();
        ((Allocation) localObject2).destroy();
        localAllocation2.destroy();
        if (this.a != null) {
            this.a.b();
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/beauty/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */