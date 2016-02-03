package com.everimaging.fotorsdk.brush.brush;

import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.everimaging.fotorsdk.brush.Brush;
import com.everimaging.fotorsdk.brush.toolkit.DirtyRegion;

public class SmudgeBrush
        extends Brush {
    private float a = 10.0F;
    private int b = 255;
    private float c = 4.0F;
    private float d = 1.0F;
    private float e = 1.0F;
    private Paint f = null;
    private Path g = null;
    private PathMeasure h = null;
    private float i;
    private float j;
    private float k;
    private boolean l;
    private DrawStyle m = DrawStyle.CIRCLE;
    private DirtyRegion n = new DirtyRegion();

    public SmudgeBrush() {
        b();
        a(false);
    }

    public void a(float paramFloat) {
        this.a = paramFloat;
    }

    public void a(float paramFloat1, float paramFloat2, Canvas paramCanvas) {
        this.g.moveTo(paramFloat1, paramFloat2);
        this.i = paramFloat1;
        this.j = paramFloat2;
        this.k = 0.0F;
        this.n.a(paramFloat1, paramFloat2);
        this.l = false;
    }

    public void a(int paramInt) {
        this.b = paramInt;
    }

    public void a(Canvas paramCanvas) {
        paramCanvas.drawPath(this.g, this.f);
    }

    public void a(DrawStyle paramDrawStyle) {
        this.m = paramDrawStyle;
    }

    public void a(DirtyRegion paramDirtyRegion) {
        float f1 = (2.0F - this.d) * this.c;
        paramDirtyRegion.left -= f1;
        paramDirtyRegion.top -= f1;
        paramDirtyRegion.right += f1;
        paramDirtyRegion.bottom = (f1 + paramDirtyRegion.bottom);
        b(paramDirtyRegion);
    }

    public void a(boolean paramBoolean) {
        if (!paramBoolean) {
            this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            return;
        }
        this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public void b() {
        this.f.setAntiAlias(true);
        this.f.setDither(true);
        if (this.m == DrawStyle.CIRCLE) {
            this.f.setStyle(Paint.Style.FILL);
        }
        for (; ; ) {
            this.f.setStrokeJoin(Paint.Join.ROUND);
            this.f.setStrokeCap(Paint.Cap.ROUND);
            this.f.setColor(-1);
            this.f.setAlpha(this.b);
            this.f.setStrokeWidth(this.c * 2.0F - (1.0F - this.d) * this.c * 2.0F);
            if ((this.d <= 0.0F) || (this.d >= 1.0F) || (this.c <= 0.0F)) {
                break;
            }
            this.f.setMaskFilter(new BlurMaskFilter((1.0F - this.d) * this.c, BlurMaskFilter.Blur.NORMAL));
            return;
            if (this.m == DrawStyle.PATH) {
                this.f.setStyle(Paint.Style.STROKE);
            }
        }
        this.f.setMaskFilter(null);
    }

    public void b(float paramFloat) {
        this.c = paramFloat;
    }

    public void b(float paramFloat1, float paramFloat2, Canvas paramCanvas) {
        float f2 = Math.abs(paramFloat1 - this.i);
        float f3 = Math.abs(paramFloat2 - this.j);
        float f4 = (this.i + paramFloat1) / 2.0F;
        float f5 = (this.j + paramFloat2) / 2.0F;
        float f1 = this.c * this.e;
        float[] arrayOfFloat1 = new float[2];
        float[] arrayOfFloat2 = new float[2];
        if (this.m == DrawStyle.PATH) {
            this.n.b(this.i, this.j);
            this.n.b(f4, f5);
        }
        int i1;
        int i2;
        if ((f2 >= this.a) || (f3 >= this.a)) {
            this.g.quadTo(this.i, this.j, f4, f5);
            this.i = paramFloat1;
            this.j = paramFloat2;
            if (this.m != DrawStyle.CIRCLE) {
                break label327;
            }
            this.h.setPath(this.g, false);
            paramFloat1 = this.h.getLength();
            i1 = 0;
            i2 = i1;
            if (paramFloat1 > this.k) {
                if (this.k + f1 <= paramFloat1) {
                    break label259;
                }
                i2 = i1;
            }
        }
        for (; ; ) {
            if (i2 != 0) {
                a(this.n);
                this.n.a(arrayOfFloat1[0], arrayOfFloat1[1]);
                this.l = true;
            }
            if (this.m == DrawStyle.PATH) {
                a(paramCanvas);
            }
            return;
            label259:
            this.k += f1;
            this.h.getPosTan(this.k, arrayOfFloat1, arrayOfFloat2);
            paramCanvas.drawCircle(arrayOfFloat1[0], arrayOfFloat1[1], this.c, this.f);
            this.n.b(arrayOfFloat1[0], arrayOfFloat1[1]);
            i1 = 1;
            break;
            label327:
            if (this.m == DrawStyle.PATH) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        }
    }

    public void c() {
        this.g.reset();
    }

    public void c(float paramFloat) {
        this.d = paramFloat;
    }

    public boolean c(float paramFloat1, float paramFloat2, Canvas paramCanvas) {
        this.g.lineTo(this.i, this.j);
        this.g.reset();
        return this.l;
    }

    public static enum DrawStyle {
        CIRCLE, PATH;

        private DrawStyle() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/brush/SmudgeBrush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */