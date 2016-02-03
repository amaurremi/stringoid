package com.everimaging.fotorsdk.editor.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.everimaging.bitmap.EIBitmapTool;
import com.everimaging.fotorsdk.algorithms.jni.FotorSDKAlgorithmsNative;
import com.everimaging.fotorsdk.brush.brush.TiltShiftBrush;
import com.everimaging.fotorsdk.editor.filter.params.TiltShiftParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class k
        extends g {
    private static final Object h = new Object();
    private static final String i = k.class.getSimpleName();
    private final FotorLoggerFactory.c j = FotorLoggerFactory.a(i, FotorLoggerFactory.LoggerType.CONSOLE);
    private a k;

    public k(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, TiltShiftParams paramTiltShiftParams) {
        super(parama, paramBitmap1, paramBitmap2, paramTiltShiftParams);
    }

    public Bitmap a() {
        synchronized (h) {
            TiltShiftParams localTiltShiftParams = (TiltShiftParams) this.e;
            int m = localTiltShiftParams.getProcessImgWidth();
            int n = localTiltShiftParams.getProcessImgHeight();
            int i1 = this.c.getWidth();
            int i2 = this.c.getHeight();
            localTiltShiftParams.applyScale(Math.min(i1 / m, i2 / n));
            Bitmap localBitmap2 = BitmapUtils.createBitmap(this.c.getWidth(), this.c.getHeight(), this.c.getConfig());
            Object localObject1 = new TiltShiftBrush();
            ((TiltShiftBrush) localObject1).a(localTiltShiftParams.getMode());
            ((TiltShiftBrush) localObject1).a(localTiltShiftParams.getCenterX());
            ((TiltShiftBrush) localObject1).b(localTiltShiftParams.getCenterY());
            ((TiltShiftBrush) localObject1).c(localTiltShiftParams.getDegress());
            ((TiltShiftBrush) localObject1).a(localTiltShiftParams.getInnerRadius(), localTiltShiftParams.getInnerRadiusY(), localTiltShiftParams.getOuterRadiusValue());
            Canvas localCanvas = new Canvas(localBitmap2);
            ((TiltShiftBrush) localObject1).a(localCanvas);
            localObject1 = new Paint(4);
            ((Paint) localObject1).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Paint localPaint = new Paint(4);
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
            ((Paint) localObject1).setFilterBitmap(true);
            localPaint.setFilterBitmap(true);
            localCanvas.drawBitmap(this.c, 0.0F, 0.0F, (Paint) localObject1);
            Bitmap localBitmap1 = this.d;
            localObject1 = localBitmap1;
            if (localBitmap1 == null) {
                localObject1 = BitmapUtils.createBitmap(this.c.getWidth(), this.c.getHeight(), this.c.getConfig());
            }
            FotorSDKAlgorithmsNative.gaussian(this.c, (Bitmap) localObject1, localTiltShiftParams.getStrength());
            if ((localObject1 == null) || (((Bitmap) localObject1).isRecycled())) {
                return null;
            }
            localCanvas.drawBitmap((Bitmap) localObject1, 0.0F, 0.0F, localPaint);
            this.j.c(new Object[]{"blur bitmap:" + localObject1 + ",dst bitmap:" + this.d});
            if (!EIBitmapTool.a(localBitmap2, (Bitmap) localObject1)) {
                return localBitmap2;
            }
            if ((localBitmap2 != null) && (!localBitmap2.isRecycled())) {
                localBitmap2.recycle();
            }
            return (Bitmap) localObject1;
        }
    }

    protected e a(boolean paramBoolean) {
        if (paramBoolean) {
            this.k = new com.everimaging.fotorsdk.editor.filter.rs.f(this.b, this.c, this.d, e());
            return null;
        }
        this.k = new com.everimaging.fotorsdk.editor.filter.jni.f(this.a, this.c, this.d, e());
        return null;
    }

    public TiltShiftParams e() {
        return (TiltShiftParams) this.e;
    }

    public Bitmap f() {
        if (this.k != null) {
            return this.k.a();
        }
        return null;
    }

    public static abstract interface a {
        public abstract Bitmap a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */