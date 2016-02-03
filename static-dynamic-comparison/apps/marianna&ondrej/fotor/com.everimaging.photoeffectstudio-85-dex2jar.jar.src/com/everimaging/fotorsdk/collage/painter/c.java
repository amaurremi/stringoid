package com.everimaging.fotorsdk.collage.painter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.everimaging.fotorsdk.collage.params.CollageSlotItemParam;
import com.everimaging.fotorsdk.filter.FxEffectFilter;
import com.everimaging.fotorsdk.filter.FxEffectFilter.Level;
import com.everimaging.fotorsdk.filter.a.a;
import com.everimaging.fotorsdk.filter.params.EffectsParams;
import com.everimaging.fotorsdk.imagepicker.Picture;
import com.everimaging.fotorsdk.plugins.g;
import com.everimaging.fotorsdk.plugins.h;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class c
        implements ICollagePainter {
    private a.a a;
    private Context b;
    private CollageSlotItemParam c;
    private int d;
    private int e;
    private Bitmap f;
    private float g;
    private Path h;
    private Paint i;
    private int j = 0;

    public c(a.a parama, CollageSlotItemParam paramCollageSlotItemParam, Path paramPath, int paramInt1, int paramInt2) {
        this.a = parama;
        this.b = parama.getContext();
        this.c = paramCollageSlotItemParam;
        this.h = paramPath;
        this.d = paramInt1;
        this.e = paramInt2;
    }

    private void a() {
        Picture localPicture = this.c.getPicture();
        this.f = BitmapUtils.rotateBitmap(BitmapDecodeUtils.decode(this.b, localPicture.g(), this.d, this.e), this.c.getImageAngle(), this.c.isFlipV(), this.c.isFlipH());
        c();
        this.g = Math.min(this.c.getThumbnailWidth() / this.f.getWidth(), this.c.getThumbnailHeight() / this.f.getHeight());
        this.i = new Paint();
        this.i.setColor(-3355444);
    }

    private void b() {
        if (this.f != null) {
            if (!this.f.isRecycled()) {
                this.f.recycle();
            }
            this.f = null;
        }
    }

    private void c() {
        Object localObject = this.c.getEffectParams();
        if ((localObject != null) && (this.f != null)) {
            g localg = (g) h.a(this.b, ((EffectsParams) localObject).getFeaturePack());
            localObject = new FxEffectFilter(this.a, this.f, null, (EffectsParams) localObject, FxEffectFilter.Level.ORIGINAL);
            ((FxEffectFilter) localObject).a(localg);
            this.f = ((FxEffectFilter) localObject).c();
            ((FxEffectFilter) localObject).a();
        }
    }

    public void a(int paramInt) {
        this.j = paramInt;
    }

    public void a(Canvas paramCanvas, float paramFloat) {
        a();
        if (this.f == null) {
            return;
        }
        Object localObject = new RectF();
        this.h.computeBounds((RectF) localObject, true);
        int k = this.f.getWidth();
        int m = this.f.getHeight();
        float f1 = ((RectF) localObject).left + ((RectF) localObject).width() / 2.0F;
        float f2 = ((RectF) localObject).top + ((RectF) localObject).height() / 2.0F;
        float f3 = this.c.getDisplayCenterX();
        float f4 = k;
        float f5 = this.c.getDisplayCenterY();
        float f6 = m;
        k = paramCanvas.saveLayer((RectF) localObject, null, 31);
        this.i.setXfermode(null);
        paramCanvas.drawPath(this.h, this.i);
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        paramCanvas.save();
        paramFloat = this.g * this.c.getUserScale() / paramFloat;
        localObject = new Matrix();
        ((Matrix) localObject).postTranslate(f1 - f4 * f3, f2 - f6 * f5);
        ((Matrix) localObject).postScale(paramFloat, paramFloat, f1, f2);
        paramCanvas.concat((Matrix) localObject);
        paramCanvas.drawBitmap(this.f, 0.0F, 0.0F, this.i);
        paramCanvas.restore();
        paramCanvas.restoreToCount(k);
        b();
    }

    public int d() {
        return this.j;
    }

    public ICollagePainter.PainterType e() {
        return ICollagePainter.PainterType.Slot;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/painter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */