package com.everimaging.fotorsdk.editor.filter.rs;

import android.content.Context;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Type;
import com.everimaging.fotorsdk.algorithms.RSFilterFactory;
import com.everimaging.fotorsdk.algorithms.RSFilterFactory.Filters;
import com.everimaging.fotorsdk.algorithms.d;
import com.everimaging.fotorsdk.algorithms.f;
import com.everimaging.fotorsdk.algorithms.g;
import com.everimaging.fotorsdk.algorithms.params.base.RSCurveBaseFilterParams;
import com.everimaging.fotorsdk.editor.filter.a.a;
import com.everimaging.fotorsdk.editor.filter.c.a;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class b
        implements c.a {
    private static final String a = b.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private g c;
    private RSCurveBaseFilterParams d;
    private Allocation e;

    public b(a.a parama) {
        this.c = new g(parama.getContext(), parama.getRenderScript(), parama.getScript_BaseFilter());
        this.d = new RSCurveBaseFilterParams();
        f localf = RSFilterFactory.a(RSFilterFactory.Filters.CURVE_GEN, this.d);
        this.e = Allocation.createSized(parama.getRenderScript(), Element.F32(parama.getRenderScript()), 256);
        localf.a("dst", new d() {
            public Allocation getFutureAllocation(Context paramAnonymousContext, RenderScript paramAnonymousRenderScript) {
                return b.a(b.this);
            }
        });
        this.c.a(localf);
    }

    public void a() {
        try {
            b.c(new Object[]{"destory"});
            if (this.c != null) {
                this.c.e();
            }
            return;
        } catch (Throwable localThrowable) {
        }
    }

    public float[] a(float[] paramArrayOfFloat) {
        Object localObject = null;
        this.d.setControlPoints(paramArrayOfFloat);
        Allocation localAllocation = this.c.d();
        paramArrayOfFloat = (float[]) localObject;
        if (localAllocation != null) {
            paramArrayOfFloat = new float[localAllocation.getType().getCount()];
            localAllocation.copyTo(paramArrayOfFloat);
        }
        return paramArrayOfFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/rs/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */