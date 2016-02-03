package com.everimaging.fotorsdk.editor.filter.jni;

import com.everimaging.fotorsdk.algorithms.jni.FotorSDKAlgorithmsNative;
import com.everimaging.fotorsdk.algorithms.params.base.ECurveMode;
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
    private RSCurveBaseFilterParams c = new RSCurveBaseFilterParams();

    public b(a.a parama) {
        this.c.setMode(ECurveMode.GEN_CURVE);
    }

    public void a() {
        try {
            b.c(new Object[]{"destory"});
            return;
        } catch (Throwable localThrowable) {
        }
    }

    public float[] a(float[] paramArrayOfFloat) {
        b.c(new Object[]{"compute with jni"});
        this.c.setControlPoints(paramArrayOfFloat);
        return FotorSDKAlgorithmsNative.nativeGenCurve(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/jni/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */