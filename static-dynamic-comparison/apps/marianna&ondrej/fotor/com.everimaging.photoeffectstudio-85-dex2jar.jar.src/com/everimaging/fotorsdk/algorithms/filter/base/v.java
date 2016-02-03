package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.cpu.b;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.ELevelMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSLevelBaseFilterParams;

public class v
        extends a<d> {
    private Allocation b;
    private int[] c;

    public v(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        RSLevelBaseFilterParams localRSLevelBaseFilterParams = (RSLevelBaseFilterParams) b();
        ELevelMode localELevelMode = localRSLevelBaseFilterParams.getMode();
        Allocation localAllocation1 = a(paramContext, paramRenderScript, "src");
        Allocation localAllocation2 = a(paramContext, paramRenderScript, "dst");
        int i = localAllocation1.getType().getX();
        int j = localAllocation1.getType().getY();
        d locald = (d) a();
        locald.a(localAllocation1);
        locald.a(i);
        locald.b(j);
        switch (1. a[localELevelMode.ordinal()])
        {
        }
        for (; ; ) {
            if (this.a != null) {
                this.a.b();
            }
            return localAllocation2;
            f(paramContext, paramRenderScript);
            continue;
            f(paramContext, paramRenderScript);
            paramContext = new int['Ѐ'];
            this.b.copyTo(paramContext);
            this.c = new int['Ā'];
            i = 0;
            while (i < 256) {
                this.c[i] = paramContext[(i * 4 + 3)];
                i += 1;
            }
            float f1 = localRSLevelBaseFilterParams.getDark();
            float f2 = localRSLevelBaseFilterParams.getLight();
            float f3 = localRSLevelBaseFilterParams.getSaturation();
            i = localAllocation1.getType().getX();
            j = localAllocation1.getType().getY();
            paramContext = new b(f1, f2, f3, this.c, i * j);
            paramContext.d();
            f1 = paramContext.a();
            f2 = paramContext.b();
            f3 = paramContext.c();
            locald.j(f1);
            locald.l(f2);
            locald.m(f3);
            locald.aG(localAllocation1, localAllocation2);
            continue;
            f1 = localRSLevelBaseFilterParams.getDark();
            f2 = localRSLevelBaseFilterParams.getLight();
            locald.e(f1);
            locald.f(f2);
            locald.aH(localAllocation1, localAllocation2);
            continue;
            f1 = localRSLevelBaseFilterParams.getDark();
            f2 = localRSLevelBaseFilterParams.getLight();
            f3 = localRSLevelBaseFilterParams.getGamma();
            locald.e(f1);
            locald.f(f2);
            locald.g(f3);
            locald.aI(localAllocation1, localAllocation2);
        }
    }

    protected void f(Context paramContext, RenderScript paramRenderScript) {
        Element localElement = Element.U32_4(paramRenderScript);
        int[] arrayOfInt = new int['Ѐ'];
        a(paramContext, paramRenderScript, "src");
        this.b = Allocation.createSized(paramRenderScript, localElement, 256);
        this.b.copy1DRangeFrom(0, 256, arrayOfInt);
        paramContext = (d) a();
        paramContext.e(this.b);
        paramContext.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */