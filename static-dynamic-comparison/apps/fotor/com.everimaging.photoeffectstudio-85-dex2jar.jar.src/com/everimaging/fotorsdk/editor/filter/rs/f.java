package com.everimaging.fotorsdk.editor.filter.rs;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.editor.filter.a.a;
import com.everimaging.fotorsdk.editor.filter.k.a;
import com.everimaging.fotorsdk.editor.filter.params.TiltShiftParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class f
        implements k.a {
    private static final Object a = new Object();
    private static final String b = f.class.getSimpleName();
    private final FotorLoggerFactory.c c = FotorLoggerFactory.a(b, FotorLoggerFactory.LoggerType.CONSOLE);
    private a d;
    private TiltShiftParams e;

    public f(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, TiltShiftParams paramTiltShiftParams) {
        this.d = new a(parama.getRenderScript(), paramBitmap1, paramBitmap2);
        this.e = paramTiltShiftParams;
    }

    public Bitmap a() {
        synchronized (a) {
            Object localObject2 = this.e;
            this.c.c(new Object[]{"compute blur mask radius:" + ((TiltShiftParams) localObject2).getStrength()});
            localObject2 = this.d.a(((TiltShiftParams) localObject2).getStrength());
            return (Bitmap) localObject2;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/rs/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */