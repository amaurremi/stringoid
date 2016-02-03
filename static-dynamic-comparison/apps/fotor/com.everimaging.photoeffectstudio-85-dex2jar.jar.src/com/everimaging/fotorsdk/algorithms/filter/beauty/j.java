package com.everimaging.fotorsdk.algorithms.filter.beauty;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Script.LaunchOptions;
import com.everimaging.fotorsdk.algorithms.a;
import com.everimaging.fotorsdk.algorithms.e;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.beauty.RedEyeRemoverParams;

public class j
        extends a<d> {
    public j(RSBaseParams paramRSBaseParams) {
        super(paramRSBaseParams);
    }

    protected Allocation c(Context paramContext, RenderScript paramRenderScript) {
        if (this.a != null) {
            this.a.a();
        }
        Object localObject = (RedEyeRemoverParams) b();
        float f1 = ((RedEyeRemoverParams) localObject).getCenterX();
        float f2 = ((RedEyeRemoverParams) localObject).getCenterY();
        int i = ((RedEyeRemoverParams) localObject).getRadius();
        localObject = a(paramContext, paramRenderScript, "src");
        paramContext = a(paramContext, paramRenderScript, "dst");
        if (paramContext == null) {
            paramContext = Allocation.createTyped(paramRenderScript, ((Allocation) localObject).getType());
        }
        for (; ; ) {
            paramContext.copyFrom((Allocation) localObject);
            paramRenderScript = (d) a();
            Script.LaunchOptions localLaunchOptions = new Script.LaunchOptions();
            localLaunchOptions.setX((int) f1 - i, (int) f1 + i);
            localLaunchOptions.setY((int) f2 - i, (int) f2 + i);
            paramRenderScript.S(f1);
            paramRenderScript.T(f2);
            paramRenderScript.g(i * i);
            paramRenderScript.aP((Allocation) localObject, paramContext, localLaunchOptions);
            if (this.a != null) {
                this.a.b();
            }
            return paramContext;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/beauty/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */