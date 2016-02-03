package com.everimaging.fotorsdk.editor.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;

public abstract class a {
    protected b a;
    protected boolean b;
    protected PointF c;
    protected float[] d;
    protected float[] e;
    protected float f;
    protected float g;
    protected float h;
    protected float i;
    protected RectF j;
    protected Context k;
    protected Matrix l;
    protected int m;

    protected a(Context paramContext) {
        this.k = paramContext;
        this.c = new PointF();
        this.j = new RectF();
        this.d = new float[8];
        this.e = new float[8];
        this.l = new Matrix();
        this.f = 1.0F;
        this.g = 0.0F;
        this.h = 0.0F;
        this.i = 0.0F;
        this.b = true;
        this.m = 0;
    }

    protected float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        float f1 = paramFloat1 - (this.c.x + this.j.left);
        float f2 = paramFloat2 - (this.c.y + this.j.top);
        paramFloat3 -= this.c.x + this.j.left;
        paramFloat4 -= this.c.y + this.j.top;
        paramFloat1 = (float) ((f1 * paramFloat3 + f2 * paramFloat4) / (Math.sqrt(f1 * f1 + f2 * f2) * Math.sqrt(paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4)));
        if ((paramFloat1 > 0.999999F) && (paramFloat1 < 1.000001F)) {
            return 0.0F;
        }
        paramFloat2 = (float) Math.acos(paramFloat1);
        paramFloat1 = paramFloat2;
        if (f1 * paramFloat4 - f2 * paramFloat3 < 0.0F) {
            paramFloat1 = -paramFloat2;
        }
        return paramFloat1 * 180.0F / 3.14F;
    }

    public PointF a() {
        return this.c;
    }

    public void a(float paramFloat) {
        float f1;
        if (paramFloat < 0.0F) {
            f1 = paramFloat + 360.0F;
        }
        for (; ; ) {
            this.i = f1;
            return;
            f1 = paramFloat;
            if (paramFloat >= 360.0F) {
                f1 = paramFloat - 360.0F;
            }
        }
    }

    public abstract void a(Canvas paramCanvas);

    public abstract void a(Canvas paramCanvas, float paramFloat1, float paramFloat2);

    public void a(PointF paramPointF) {
        this.c = paramPointF;
    }

    public void a(RectF paramRectF) {
        this.j = new RectF(paramRectF);
    }

    public void a(b paramb) {
        this.a = paramb;
    }

    public void a(boolean paramBoolean) {
        this.b = paramBoolean;
    }

    protected boolean a(PointF paramPointF, PointF[] paramArrayOfPointF) {
        boolean bool = false;
        PointF[] arrayOfPointF = paramArrayOfPointF;
        PointF localPointF1;
        if (paramArrayOfPointF == null) {
            paramArrayOfPointF = new PointF((int) this.e[0], (int) this.e[1]);
            localPointF1 = new PointF((int) this.e[2], (int) this.e[3]);
            PointF localPointF2 = new PointF((int) this.e[4], (int) this.e[5]);
            PointF localPointF3 = new PointF((int) this.e[6], (int) this.e[7]);
            arrayOfPointF = new PointF[4];
            arrayOfPointF[0] = paramArrayOfPointF;
            arrayOfPointF[1] = localPointF1;
            arrayOfPointF[2] = localPointF2;
            arrayOfPointF[3] = localPointF3;
        }
        int n = 0;
        int i1 = 0;
        if (n < arrayOfPointF.length) {
            paramArrayOfPointF = arrayOfPointF[n];
            localPointF1 = arrayOfPointF[((n + 1) % arrayOfPointF.length)];
            int i2;
            if (paramArrayOfPointF.y == localPointF1.y) {
                i2 = i1;
            }
            for (; ; ) {
                n += 1;
                i1 = i2;
                break;
                i2 = i1;
                if (paramPointF.y >= Math.min(paramArrayOfPointF.y, localPointF1.y)) {
                    i2 = i1;
                    if (paramPointF.y < Math.max(paramArrayOfPointF.y, localPointF1.y)) {
                        i2 = i1;
                        if ((paramPointF.y - paramArrayOfPointF.y) * (localPointF1.x - paramArrayOfPointF.x) / (localPointF1.y - paramArrayOfPointF.y) + paramArrayOfPointF.x > paramPointF.x) {
                            i2 = i1 + 1;
                        }
                    }
                }
            }
        }
        if (i1 % 2 == 1) {
            bool = true;
        }
        return bool;
    }

    public abstract boolean a(MotionEvent paramMotionEvent);

    public RectF b() {
        return new RectF(this.j);
    }

    public void b(float paramFloat) {
        this.f = paramFloat;
    }

    public abstract void b(RectF paramRectF);

    public float c() {
        return this.i;
    }

    public void c(float paramFloat) {
        this.g = paramFloat;
    }

    public float d() {
        return this.f;
    }

    public void d(float paramFloat) {
        this.h = paramFloat;
    }

    public float e() {
        return this.g;
    }

    public float f() {
        return this.h;
    }

    public static abstract class a {
        protected long a;
        protected long b;
        protected float c;
        protected float d;
        protected boolean e = true;

        public a(long paramLong, float paramFloat1, float paramFloat2) {
            this.b = paramLong;
            this.c = paramFloat1;
            this.d = paramFloat2;
        }

        protected abstract float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

        public float a(long paramLong) {
            paramLong -= this.a;
            if (paramLong < 0L) {
                f1 = this.c;
                this.e = true;
                return f1;
            }
            if (paramLong >= this.b) {
                f1 = this.d;
                this.e = true;
                return f1;
            }
            float f1 = this.d;
            float f2 = this.c;
            return a((float) paramLong, this.c, f1 - f2, (float) this.b);
        }

        public void a() {
            this.e = false;
            this.a = AnimationUtils.currentAnimationTimeMillis();
        }

        public boolean b() {
            return this.e;
        }
    }

    public static abstract interface b {
        public abstract void a(a.a parama);

        public abstract void a(a parama);

        public abstract void b(a parama);

        public abstract void c(a parama);

        public abstract void d(a parama);
    }

    public class c
            extends a.a {
        public c(long paramLong, float paramFloat1, float paramFloat2) {
            super(paramFloat1, paramFloat2);
        }

        private float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
            paramFloat1 /= paramFloat4;
            return paramFloat1 * (paramFloat3 * paramFloat1 * paramFloat1) + paramFloat2;
        }

        protected float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
            return b(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */