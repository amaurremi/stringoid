package com.everimaging.fotorsdk.brush.painter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import com.everimaging.fotorsdk.brush.Brush;
import com.everimaging.fotorsdk.brush.brush.TiltShiftBrush;
import com.everimaging.fotorsdk.brush.toolkit.e;

public class a
        extends com.everimaging.fotorsdk.brush.a {
    private static final String e = a.class.getSimpleName();
    private Bitmap f;
    private Bitmap g;
    private e h;
    private Paint i;
    private Paint j;
    private Paint k;
    private Paint l;

    public a(Context paramContext, TiltShiftBrush paramTiltShiftBrush) {
        super(paramContext);
        this.d = paramTiltShiftBrush;
        this.i = new Paint(4);
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.j = new Paint(4);
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.k = new Paint(4);
        this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.l = new Paint(4);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.i.setFilterBitmap(true);
        this.j.setFilterBitmap(true);
        this.k.setFilterBitmap(true);
        this.h = new e(this);
    }

    public void a() {
        if (this.d != null) {
            this.d.a(this.b);
        }
        invalidate();
    }

    public void a(Bitmap paramBitmap1, Bitmap paramBitmap2) {
        this.f = paramBitmap1;
        this.g = paramBitmap2;
        this.c = Bitmap.createBitmap(paramBitmap2.getWidth(), paramBitmap2.getHeight(), paramBitmap2.getConfig());
        this.b = new Canvas(this.c);
    }

    public void a(Canvas paramCanvas) {
        if ((this.c == null) || (this.c.isRecycled()) || (this.g == null) || (this.g.isRecycled()) || (this.f == null) || (this.f.isRecycled())) {
            Log.e(e, "invalid bitmap is passed in");
            return;
        }
        paramCanvas.drawBitmap(this.c, 0.0F, 0.0F, this.i);
        paramCanvas.drawBitmap(this.g, 0.0F, 0.0F, this.j);
        paramCanvas.drawBitmap(this.f, 0.0F, 0.0F, this.k);
    }

    public e getViewCamera() {
        return this.h;
    }

    public void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if ((this.c == null) || (this.c.isRecycled()) || (this.g == null) || (this.g.isRecycled()) || (this.f == null) || (this.f.isRecycled())) {
            Log.e(e, "invalid bitmap is passed in");
            return;
        }
        this.h.a(paramCanvas);
        float f1 = -this.c.getWidth() / 2.0F;
        float f2 = -this.c.getHeight() / 2.0F;
        paramCanvas.drawBitmap(this.c, f1, f2, this.i);
        paramCanvas.drawBitmap(this.g, f1, f2, this.j);
        paramCanvas.drawBitmap(this.f, f1, f2, this.k);
        this.h.b(paramCanvas);
    }

    public void setViewCamera(e parame) {
        this.h = parame;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/painter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */