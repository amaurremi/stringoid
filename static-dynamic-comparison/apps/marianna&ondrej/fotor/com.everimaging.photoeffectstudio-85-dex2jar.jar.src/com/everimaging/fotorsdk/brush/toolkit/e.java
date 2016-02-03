package com.everimaging.fotorsdk.brush.toolkit;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

public class e
        implements a.a {
    boolean a;
    boolean b;
    boolean c;
    private View d;
    private float[] e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private b m;
    private b n;
    private float o;
    private float p;
    private a q;
    private float r;
    private float s;
    private a t;

    public e(View paramView) {
        this.d = paramView;
        this.e = new float[2];
        this.h = 1.0F;
        this.k = 1.0F;
        this.j = this.k;
        this.l = (this.k * 5.0F);
        this.m = new b();
        this.m.a(new DecelerateInterpolator());
        this.n = new b();
        this.n.a(new DecelerateInterpolator());
        this.q = new a(this);
        this.a = false;
        this.b = false;
        this.c = true;
    }

    protected final float a(float paramFloat) {
        float f1 = 0.0F;
        if (paramFloat > 0.0F) {
            f1 = 1.0F;
        }
        while (paramFloat >= 0.0F) {
            return f1;
        }
        return -1.0F;
    }

    public final RectF a(RectF paramRectF) {
        float[] arrayOfFloat = f(paramRectF.left, paramRectF.top);
        paramRectF = f(paramRectF.right, paramRectF.bottom);
        return new RectF(arrayOfFloat[0], arrayOfFloat[1], paramRectF[0], paramRectF[1]);
    }

    public void a() {
        Log.i("View Camera", "scale pan end");
        float f1 = this.h;
        if (!this.n.b()) {
            f1 = this.n.a();
        }
        float f2;
        if (this.h < this.j) {
            f1 = this.j;
            f2 = this.j;
            this.n.a(this.h);
            this.n.b(new float[]{f2});
            this.n.a('È');
            this.n.c();
        }
        if (this.h > this.l) {
            f1 = this.l;
            f2 = this.l;
            this.n.a(this.h);
            this.n.b(new float[]{f2});
            this.n.a('È');
            this.n.c();
        }
        float[] arrayOfFloat = c(this.e[0], this.e[1], f1);
        if ((arrayOfFloat[0] != this.e[0]) || (arrayOfFloat[1] != this.e[1])) {
            f1 = arrayOfFloat[0];
            f2 = arrayOfFloat[1];
            this.m.a(this.e);
            this.m.b(new float[]{f1, f2});
            this.m.a('È');
            this.m.c();
        }
        this.a = false;
        if ((!this.n.b()) || (!this.m.b())) {
            this.b = true;
        }
        this.d.postInvalidate();
    }

    public void a(float paramFloat1, float paramFloat2) {
        Log.i("View Camera", "scale pan focus");
        this.n.d();
        this.m.d();
        this.b = false;
        this.i = this.h;
        this.f = this.e[0];
        this.g = this.e[1];
        this.r = paramFloat1;
        this.s = paramFloat2;
        this.a = true;
    }

    public void a(float paramFloat1, float paramFloat2, float paramFloat3) {
        float f3 = this.i * paramFloat1;
        float f1 = f3;
        float f2 = paramFloat1;
        if (this.c) {
            f1 = f3;
            if (f3 < this.j) {
                paramFloat1 = this.j;
                f1 = (float) Math.pow(2.0F, f3 / this.j - 1.0F) * paramFloat1;
            }
            paramFloat1 = f1;
            if (f1 > this.l) {
                paramFloat1 = this.l / (float) Math.pow(2.0F, this.l / f1 - 1.0F);
            }
            f2 = paramFloat1 / this.i;
            f1 = paramFloat1;
        }
        this.h = f1;
        if (this.t != null) {
            this.t.a(this.h);
        }
        f3 = this.f;
        float f4 = (this.r - this.d.getWidth() / 2.0F) * (1.0F - f2) / f1;
        paramFloat1 = this.g;
        f2 = (this.s - this.d.getHeight() / 2.0F) * (1.0F - f2) / f1;
        paramFloat2 = f3 - f4 - paramFloat2 / f1;
        paramFloat1 = paramFloat1 - f2 - paramFloat3 / f1;
        this.e[0] = paramFloat2;
        this.e[1] = paramFloat1;
        if (this.c) {
            float[] arrayOfFloat1 = c(paramFloat2, paramFloat1, f1);
            paramFloat2 -= arrayOfFloat1[0];
            paramFloat1 -= arrayOfFloat1[1];
            float[] arrayOfFloat2 = this.e;
            paramFloat3 = arrayOfFloat1[0];
            f2 = (float) Math.pow(0.1F, Math.abs(paramFloat2 * f1 / this.d.getWidth()));
            arrayOfFloat2[0] = (a(paramFloat2) * (1.0F - f2) * this.d.getWidth() / 4.0F / f1 + paramFloat3);
            arrayOfFloat2 = this.e;
            paramFloat2 = arrayOfFloat1[1];
            paramFloat3 = (float) Math.pow(0.1F, Math.abs(paramFloat1 * f1 / this.d.getHeight()));
            arrayOfFloat2[1] = (a(paramFloat1) * (1.0F - paramFloat3) * this.d.getHeight() / 4.0F / f1 + paramFloat2);
        }
        this.d.postInvalidate();
    }

    public void a(Canvas paramCanvas) {
        e();
        paramCanvas.save();
        paramCanvas.translate(this.d.getWidth() / 2.0F, this.d.getHeight() / 2.0F);
        paramCanvas.scale(this.h, this.h);
        paramCanvas.translate(-this.e[0], -this.e[1]);
    }

    public void a(a parama) {
        this.t = parama;
    }

    public void a(boolean paramBoolean) {
        this.c = paramBoolean;
        if (this.c) {
            this.q.a();
            return;
        }
        this.q.b();
    }

    public boolean a(MotionEvent paramMotionEvent) {
        return this.q.a(paramMotionEvent);
    }

    public final RectF b(RectF paramRectF) {
        float[] arrayOfFloat = g(paramRectF.left, paramRectF.top);
        paramRectF = g(paramRectF.right, paramRectF.bottom);
        return new RectF(arrayOfFloat[0], arrayOfFloat[1], paramRectF[0], paramRectF[1]);
    }

    public void b(float paramFloat1, float paramFloat2) {
        this.o = paramFloat1;
        this.p = paramFloat2;
    }

    public void b(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.j = paramFloat1;
        this.k = paramFloat2;
        this.l = paramFloat3;
        this.h = paramFloat2;
        if (this.t != null) {
            this.t.a(this.h);
        }
    }

    public void b(Canvas paramCanvas) {
        paramCanvas.restore();
    }

    public boolean b() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public final float[] c(float paramFloat1, float paramFloat2) {
        return new float[]{this.e[0] + (paramFloat1 - this.d.getWidth() / 2.0F) / this.h, this.e[1] + (paramFloat2 - this.d.getHeight() / 2.0F) / this.h};
    }

    protected final float[] c(float paramFloat1, float paramFloat2, float paramFloat3) {
        float f2 = 0.0F;
        float f1;
        if (this.o * paramFloat3 < this.d.getWidth()) {
            f1 = 0.0F;
        }
        label45:
        label187:
        label189:
        label193:
        for (; ; ) {
            float f3;
            float f4;
            if (this.p * paramFloat3 < this.d.getHeight()) {
                paramFloat1 = f2;
                return new float[]{f1, paramFloat1};
                f3 = this.d.getWidth() / 2.0F / paramFloat3;
                f1 = -this.o / 2.0F;
                f4 = this.o / 2.0F;
                if (paramFloat1 - f3 >= f1) {
                    break label189;
                }
            }
            for (f1 += f3; ; f1 = paramFloat1) {
                if (paramFloat1 + f3 <= f4) {
                    break label193;
                }
                f1 = f4 - f3;
                break;
                paramFloat3 = this.d.getHeight() / 2.0F / paramFloat3;
                paramFloat1 = this.p / 2.0F;
                f2 = -this.p / 2.0F;
                if (paramFloat2 + paramFloat3 > paramFloat1) {
                }
                for (paramFloat1 -= paramFloat3; ; paramFloat1 = paramFloat2) {
                    if (paramFloat2 - paramFloat3 >= f2) {
                        break label187;
                    }
                    paramFloat1 = f2 + paramFloat3;
                    break;
                }
                break label45;
            }
        }
    }

    public float d() {
        return this.h;
    }

    public final float[] d(float paramFloat1, float paramFloat2) {
        return new float[]{this.o / 2.0F + paramFloat1, this.p / 2.0F + paramFloat2};
    }

    protected final void e() {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        if (!this.b) {
        }
        do {
            return;
            if ((this.n.b()) && (this.m.b())) {
                this.b = false;
                return;
            }
            this.d.postInvalidate();
            if (!this.n.b()) {
                this.h = this.n.b(l1);
                if (this.t != null) {
                    this.t.a(this.h);
                }
            }
        } while (this.m.b());
        this.e = this.m.c(l1);
    }

    public final float[] e(float paramFloat1, float paramFloat2) {
        float[] arrayOfFloat = c(paramFloat1, paramFloat2);
        return d(arrayOfFloat[0], arrayOfFloat[1]);
    }

    public final float[] f(float paramFloat1, float paramFloat2) {
        return new float[]{paramFloat1 - this.o / 2.0F, paramFloat2 - this.p / 2.0F};
    }

    public final float[] g(float paramFloat1, float paramFloat2) {
        return new float[]{(paramFloat1 - this.e[0]) * this.h + this.d.getWidth() / 2.0F, (paramFloat2 - this.e[1]) * this.h + this.d.getHeight() / 2.0F};
    }

    public static abstract interface a {
        public abstract void a(float paramFloat);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/toolkit/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */