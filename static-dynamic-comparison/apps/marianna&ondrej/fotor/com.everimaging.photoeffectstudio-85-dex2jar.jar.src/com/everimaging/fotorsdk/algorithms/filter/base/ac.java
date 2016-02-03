package com.everimaging.fotorsdk.algorithms.filter.base;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Script.LaunchOptions;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSRedEyeRemoverBaseFilterParams;

public class ac
        extends a<d> {
    public ac(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RSRedEyeRemoverBaseFilterParams) b();
        Float2 localFloat2 = ((RSRedEyeRemoverBaseFilterParams) localObject).getCenter();
        int i = ((RSRedEyeRemoverBaseFilterParams) localObject).getRadius();
        localObject = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, ((Allocation) localObject).getType());
        }
        for (; ; ) {
            paramContext.copyFrom((Allocation) localObject);
            paramRenderScript = (d) a();
            Script.LaunchOptions localLaunchOptions = new Script.LaunchOptions();
            localLaunchOptions.setX((int) localFloat2.x - i, (int) localFloat2.x + i);
            localLaunchOptions.setY((int) localFloat2.y - i, (int) localFloat2.y + i);
            paramRenderScript.S(localFloat2.x);
            paramRenderScript.T(localFloat2.y);
            paramRenderScript.g(i * i);
            paramRenderScript.aP((Allocation) localObject, paramContext, localLaunchOptions);
            if (this.a != null) {
                this.a.b();
            }
            return paramContext;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/base/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */