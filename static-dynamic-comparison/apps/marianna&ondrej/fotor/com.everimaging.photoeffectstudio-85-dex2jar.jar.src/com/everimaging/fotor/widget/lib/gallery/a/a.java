package com.everimaging.fotor.widget.lib.gallery.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;

@SuppressLint({"NewApi"})
public class a
        extends ImageView {
    Matrix a;
    int b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    float k;
    float l;
    float[] m;
    float n;
    float o;
    float p;
    float q;
    PointF r;
    float s;
    boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    private View.OnClickListener y;
    private boolean z;

    private void a(float paramFloat1, float paramFloat2) {
        float f1 = Math.round(this.g * this.p);
        float f2 = Math.round(this.h * this.p);
        d();
        if (f1 < this.k) {
            if (this.o + paramFloat2 > 0.0F) {
                paramFloat1 = -this.o;
                f1 = 0.0F;
            }
        }
        for (; ; ) {
            this.a.postTranslate(f1, paramFloat1);
            b();
            return;
            if (this.o + paramFloat2 < -this.f) {
                paramFloat1 = -(this.o + this.f);
                f1 = 0.0F;
                continue;
                if (f2 < this.l) {
                    if (this.n + paramFloat1 > 0.0F) {
                        f1 = -this.n;
                        paramFloat1 = 0.0F;
                        continue;
                    }
                    if (this.n + paramFloat1 < -this.e) {
                        f1 = -(this.n + this.e);
                        paramFloat1 = 0.0F;
                    }
                } else {
                    if (this.n + paramFloat1 > 0.0F) {
                        f2 = -this.n;
                    }
                    for (; ; ) {
                        if (this.o + paramFloat2 <= 0.0F) {
                            break label244;
                        }
                        paramFloat1 = -this.o;
                        f1 = f2;
                        break;
                        f2 = paramFloat1;
                        if (this.n + paramFloat1 < -this.e) {
                            f2 = -(this.n + this.e);
                        }
                    }
                    label244:
                    f1 = f2;
                    paramFloat1 = paramFloat2;
                    if (this.o + paramFloat2 >= -this.f) {
                        continue;
                    }
                    paramFloat1 = -(this.o + this.f);
                    f1 = f2;
                    continue;
                }
                paramFloat2 = 0.0F;
                f1 = paramFloat1;
                paramFloat1 = paramFloat2;
            } else {
                f1 = 0.0F;
                paramFloat1 = paramFloat2;
            }
        }
    }

    private void b() {
        d();
        float f1 = Math.round(this.g * this.p);
        float f2 = Math.round(this.h * this.p);
        this.x = false;
        this.v = false;
        this.w = false;
        this.u = false;
        if (-this.n < 10.0F) {
            this.u = true;
        }
        if (((f1 >= this.k) && (this.n + f1 - this.k < 10.0F)) || ((f1 <= this.k) && (f1 + -this.n <= this.k))) {
            this.w = true;
        }
        if (-this.o < 10.0F) {
            this.v = true;
        }
        if (Math.abs(-this.o + this.l - f2) < 10.0F) {
            this.x = true;
        }
    }

    private void c() {
        this.e = (this.k * this.p - this.k - this.c * 2.0F * this.p);
        this.f = (this.l * this.p - this.l - this.d * 2.0F * this.p);
    }

    private void d() {
        this.a.getValues(this.m);
        this.n = this.m[2];
        this.o = this.m[5];
    }

    public boolean a() {
        if (this.b != 0) {
        }
        while (this.p != this.q) {
            return false;
        }
        return true;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (!this.t) {
        }
        float f1;
        float f2;
        do {
            do {
                return;
                f1 = this.r.x * this.s;
                f2 = this.r.y * this.s;
            } while ((f1 > this.k) || (f2 > this.l));
            this.s *= 0.9F;
        } while ((Math.abs(f1) < 0.1D) && (Math.abs(f2) < 0.1D));
        a(f1, f2);
        setImageMatrix(this.a);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        this.k = View.MeasureSpec.getSize(paramInt1);
        this.l = View.MeasureSpec.getSize(paramInt2);
        float f1 = Math.min(this.k / this.i, this.l / this.j);
        this.a.setScale(f1, f1);
        setImageMatrix(this.a);
        this.p = 1.0F;
        this.d = (this.l - this.j * f1);
        this.c = (this.k - f1 * this.i);
        this.d /= 2.0F;
        this.c /= 2.0F;
        this.a.postTranslate(this.c, this.d);
        this.g = (this.k - this.c * 2.0F);
        this.h = (this.l - this.d * 2.0F);
        c();
        setImageMatrix(this.a);
    }

    public void setImageBitmap(Bitmap paramBitmap) {
        super.setImageBitmap(paramBitmap);
        this.i = paramBitmap.getWidth();
        this.j = paramBitmap.getHeight();
    }

    public void setOnClickListener(View.OnClickListener paramOnClickListener) {
        this.y = paramOnClickListener;
    }

    public void setZoomToOriginalSize(boolean paramBoolean) {
        this.z = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/widget/lib/gallery/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */