package com.everimaging.fotorsdk.brush.painter.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MotionEvent;
import com.everimaging.fotorsdk.brush.Brush;
import com.everimaging.fotorsdk.brush.b;
import com.everimaging.fotorsdk.brush.brush.SmudgeBrush;
import com.everimaging.fotorsdk.brush.toolkit.e;

public class a
        extends b {
    boolean d;
    boolean e;
    boolean f = false;
    private int g = 255;
    private SmudgeBrush h;
    private Bitmap i;
    private Canvas j;
    private Paint k = new Paint(4);
    private Paint l;
    private Paint m;
    private Paint n;

    public a(Context paramContext) {
        super(paramContext);
        this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.l = new Paint(4);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.m = new Paint(4);
        this.m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.n = new Paint(4);
        this.n.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.k.setFilterBitmap(true);
        this.l.setFilterBitmap(true);
        this.m.setFilterBitmap(true);
        this.d = false;
        if (Build.VERSION.SDK_INT < 11) {
            this.d = true;
        }
        this.e = true;
    }

    public static void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4) {
        if (paramBitmap4 != null) {
            paramBitmap4 = new Canvas(paramBitmap4);
            Paint localPaint = new Paint();
            localPaint.setFilterBitmap(true);
            localPaint.setAntiAlias(true);
            localPaint.setDither(true);
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            paramBitmap4.drawBitmap(paramBitmap3, 0.0F, 0.0F, localPaint);
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            paramBitmap4.drawBitmap(paramBitmap2, 0.0F, 0.0F, localPaint);
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
            paramBitmap4.drawBitmap(paramBitmap1, 0.0F, 0.0F, localPaint);
        }
    }

    public void a(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            paramBitmap = new Canvas(paramBitmap);
            paramBitmap.drawBitmap(this.i, 0.0F, 0.0F, this.k);
            paramBitmap.drawBitmap(this.c, 0.0F, 0.0F, this.l);
            paramBitmap.drawBitmap(this.b, 0.0F, 0.0F, this.m);
        }
    }

    public void a(Bitmap paramBitmap1, Bitmap paramBitmap2) {
        super.a(paramBitmap1, paramBitmap2);
        this.i = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
        this.j = new Canvas(this.i);
        this.j.drawPaint(this.n);
    }

    public void b() {
        this.j.drawPaint(this.n);
        invalidate();
    }

    public Canvas getCanvas() {
        return this.j;
    }

    public int getIntensity() {
        return this.g;
    }

    public Bitmap getMaskBitmap() {
        return this.i;
    }

    public SmudgeBrush getSmudgeBrush() {
        return this.h;
    }

    public void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.i == null) {
            Log.w("Smudge Painter", "no bitmap");
            return;
        }
        this.a.a(paramCanvas);
        float f1 = -this.i.getWidth() / 2.0F;
        float f2 = -this.i.getHeight() / 2.0F;
        if ((this.a.b()) || (this.a.c())) {
            this.e = false;
            if ((this.e) || (!this.d)) {
                break label144;
            }
            this.k.setAlpha(255);
            paramCanvas.drawBitmap(this.b, f1, f2, this.k);
            this.k.setAlpha(this.g);
        }
        for (; ; ) {
            this.a.b(paramCanvas);
            return;
            this.e = true;
            break;
            label144:
            paramCanvas.drawBitmap(this.i, f1, f2, this.k);
            paramCanvas.drawBitmap(this.c, f1, f2, this.l);
            paramCanvas.drawBitmap(this.b, f1, f2, this.m);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.b == null) {
            Log.w("Smudge Painter", "None brush set!");
            return false;
        }
        int i1 = paramMotionEvent.getAction();
        if (i1 == 0) {
            a(paramMotionEvent);
        }
        while (this.a.a(paramMotionEvent)) {
            this.f = true;
            return true;
            if (i1 == 1) {
                c(paramMotionEvent);
            }
        }
        Object localObject = this.a.e(paramMotionEvent.getX(), paramMotionEvent.getY());
        switch (i1) {
        }
        for (; ; ) {
            return true;
            if (this.e) {
                this.f = false;
                this.h.a(localObject[0], localObject[1], this.j);
                continue;
                if ((this.e) && (!this.f)) {
                    this.h.b(localObject[0], localObject[1], this.j);
                    if (this.h.a() == null) {
                        invalidate();
                    }
                    for (; ; ) {
                        b(paramMotionEvent);
                        break;
                        localObject = this.h.a();
                        localObject = this.a.a((RectF) localObject);
                        invalidate(Brush.a(this.a.b((RectF) localObject)));
                    }
                    if ((!this.e) || (this.f)) {
                        this.e = true;
                        Log.i("Smudge Painter", "smudge: true");
                        this.h.c();
                    } else {
                        boolean bool = this.h.c(localObject[0], localObject[1], this.j);
                        invalidate();
                        if (bool) {
                            a();
                        }
                    }
                }
            }
        }
    }

    public void setErase(boolean paramBoolean) {
        this.h.a(paramBoolean);
    }

    public void setIntensity(int paramInt) {
        this.g = paramInt;
        this.k.setAlpha(this.g);
    }

    public void setMaskBitmap(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            this.i = paramBitmap;
            this.j = new Canvas(this.i);
            invalidate();
        }
    }

    public void setSmudgeBrush(SmudgeBrush paramSmudgeBrush) {
        this.h = paramSmudgeBrush;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/painter/beauty/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */