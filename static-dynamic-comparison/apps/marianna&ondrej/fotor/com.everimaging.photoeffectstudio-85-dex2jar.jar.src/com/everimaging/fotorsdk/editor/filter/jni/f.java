package com.everimaging.fotorsdk.editor.filter.jni;

import android.content.Context;
import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.jni.FotorSDKAlgorithmsNative;
import com.everimaging.fotorsdk.editor.filter.k.a;
import com.everimaging.fotorsdk.editor.filter.params.TiltShiftParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class f
        implements k.a {
    private static final Object a = new Object();
    private static final String b = f.class.getSimpleName();
    private final FotorLoggerFactory.c c = FotorLoggerFactory.a(b, FotorLoggerFactory.LoggerType.CONSOLE);
    private Bitmap d;
    private Bitmap e;
    private TiltShiftParams f;

    public f(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, TiltShiftParams paramTiltShiftParams) {
        this.c.c(new Object[]{"JNITiltShiftFilter constructor"});
        this.d = paramBitmap1;
        this.e = paramBitmap2;
        this.f = paramTiltShiftParams;
    }

    public Bitmap a() {
        synchronized (a) {
            TiltShiftParams localTiltShiftParams = this.f;
            this.c.c(new Object[]{"compute blur mask radius:" + localTiltShiftParams.getStrength()});
            this.c.a();
            Bitmap localBitmap2 = this.e;
            Bitmap localBitmap1 = localBitmap2;
            if (localBitmap2 == null) {
                localBitmap1 = BitmapUtils.createBitmap(this.d.getWidth(), this.d.getHeight(), this.d.getConfig());
            }
            FotorSDKAlgorithmsNative.gaussian(this.d, localBitmap1, localTiltShiftParams.getStrength());
            this.c.c(new Object[]{"compute blur speed time:" + this.c.b()});
            return localBitmap1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/jni/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */