package com.everimaging.fotorsdk.widget.lib.hlist;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class c {
    private static float f = 8.0F;
    private static float g = 1.0F / a(1.0F);
    private int a;
    private final a b;
    private final a c;
    private Interpolator d;
    private final boolean e;

    public c(Context paramContext) {
        this(paramContext, null);
    }

    public c(Context paramContext, Interpolator paramInterpolator) {
        this(paramContext, paramInterpolator, true);
    }

    public c(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean) {
        this.d = paramInterpolator;
        this.e = paramBoolean;
        this.b = new a(paramContext);
        this.c = new a(paramContext);
    }

    public static float a(float paramFloat) {
        paramFloat = f * paramFloat;
        if (paramFloat < 1.0F) {
        }
        for (paramFloat -= 1.0F - (float) Math.exp(-paramFloat); ; paramFloat = (1.0F - (float) Math.exp(1.0F - paramFloat)) * (1.0F - 0.36787945F) + 0.36787945F) {
            return paramFloat * g;
        }
    }

    public void a(int paramInt1, int paramInt2, int paramInt3) {
        this.b.c(paramInt1, paramInt2, paramInt3);
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        this.a = 0;
        this.b.a(paramInt1, paramInt3, paramInt5);
        this.c.a(paramInt2, paramInt4, paramInt5);
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
        a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
        if ((this.e) && (!a())) {
            float f1 = a.c(this.b);
            float f2 = a.c(this.c);
            if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2))) {
                paramInt3 = (int) (f1 + paramInt3);
                paramInt4 = (int) (paramInt4 + f2);
            }
        }
        for (; ; ) {
            this.a = 1;
            this.b.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
            this.c.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
            return;
        }
    }

    void a(Interpolator paramInterpolator) {
        this.d = paramInterpolator;
    }

    public final boolean a() {
        return (a.a(this.b)) && (a.a(this.c));
    }

    public boolean a(float paramFloat1, float paramFloat2) {
        int i = a.e(this.b);
        int j = a.d(this.b);
        int k = a.e(this.c);
        int m = a.d(this.c);
        return (!a()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
    }

    public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        this.a = 1;
        boolean bool1 = this.b.b(paramInt1, paramInt3, paramInt4);
        boolean bool2 = this.c.b(paramInt2, paramInt5, paramInt6);
        return (bool1) || (bool2);
    }

    public final int b() {
        return a.b(this.b);
    }

    public final void b(float paramFloat) {
        this.b.a(paramFloat);
        this.c.a(paramFloat);
    }

    public float c() {
        return FloatMath.sqrt(a.c(this.b) * a.c(this.b) + a.c(this.c) * a.c(this.c));
    }

    public boolean d() {
        if (a()) {
            return false;
        }
        switch (this.a) {
        }
        for (; ; ) {
            return true;
            long l = AnimationUtils.currentAnimationTimeMillis() - a.g(this.b);
            int i = a.f(this.b);
            if (l < i) {
                float f1 = (float) l / i;
                if (this.d == null) {
                }
                for (f1 = a(f1); ; f1 = this.d.getInterpolation(f1)) {
                    this.b.b(f1);
                    this.c.b(f1);
                    break;
                }
            }
            e();
            continue;
            if ((!a.a(this.b)) && (!this.b.c()) && (!this.b.b())) {
                this.b.a();
            }
            if ((!a.a(this.c)) && (!this.c.c()) && (!this.c.b())) {
                this.c.a();
            }
        }
    }

    public void e() {
        this.b.a();
        this.c.a();
    }

    static class a {
        private static float p;
        private static final float[] q;
        private static final float[] r;
        private int a;
        private int b;
        private int c;
        private int d;
        private float e;
        private float f;
        private long g;
        private int h;
        private int i;
        private int j;
        private boolean k = true;
        private int l;
        private float m = ViewConfiguration.getScrollFriction();
        private int n = 0;
        private float o;

        static {
            float f2 = 0.0F;
            p = (float) (Math.log(0.78D) / Math.log(0.9D));
            q = new float[101];
            r = new float[101];
            int i1 = 0;
            float f1 = 0.0F;
            if (i1 < 100) {
                float f5 = i1 / 100.0F;
                float f3 = 1.0F;
                label55:
                float f4 = (f3 - f1) / 2.0F + f1;
                float f6 = 3.0F * f4 * (1.0F - f4);
                float f7 = ((1.0F - f4) * 0.175F + 0.35000002F * f4) * f6 + f4 * f4 * f4;
                if (Math.abs(f7 - f5) < 1.0E-5D) {
                    q[i1] = (f4 * (f4 * f4) + f6 * ((1.0F - f4) * 0.5F + f4));
                    f3 = 1.0F;
                }
                for (; ; ) {
                    f4 = (f3 - f2) / 2.0F + f2;
                    f6 = 3.0F * f4 * (1.0F - f4);
                    f7 = ((1.0F - f4) * 0.5F + f4) * f6 + f4 * f4 * f4;
                    if (Math.abs(f7 - f5) < 1.0E-5D) {
                        r[i1] = (f4 * (f4 * f4) + ((1.0F - f4) * 0.175F + 0.35000002F * f4) * f6);
                        i1 += 1;
                        break;
                        if (f7 > f5) {
                            f3 = f4;
                            break label55;
                        }
                        f1 = f4;
                        break label55;
                    }
                    if (f7 > f5) {
                        f3 = f4;
                    } else {
                        f2 = f4;
                    }
                }
            }
            float[] arrayOfFloat = q;
            r[100] = 1.0F;
            arrayOfFloat[100] = 1.0F;
        }

        a(Context paramContext) {
            this.o = (paramContext.getResources().getDisplayMetrics().density * 160.0F * 386.0878F * 0.84F);
        }

        private static float a(int paramInt) {
            if (paramInt > 0) {
                return -2000.0F;
            }
            return 2000.0F;
        }

        private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
            int i3 = 1;
            if ((paramInt1 > paramInt2) && (paramInt1 < paramInt3)) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.k = true;
                return;
            }
            int i1;
            int i2;
            label43:
            int i4;
            if (paramInt1 > paramInt3) {
                i1 = 1;
                if (i1 == 0) {
                    break label78;
                }
                i2 = paramInt3;
                i4 = paramInt1 - i2;
                if (i4 * paramInt4 < 0) {
                    break label84;
                }
            }
            for (; ; ) {
                if (i3 == 0) {
                    break label90;
                }
                g(paramInt1, i2, paramInt4);
                return;
                i1 = 0;
                break;
                label78:
                i2 = paramInt2;
                break label43;
                label84:
                i3 = 0;
            }
            label90:
            if (c(paramInt4) > Math.abs(i4)) {
                if (i1 != 0) {
                    if (i1 == 0) {
                        break label137;
                    }
                    paramInt3 = paramInt1;
                }
                label137:
                for (; ; ) {
                    a(paramInt1, paramInt4, paramInt2, paramInt3, this.l);
                    return;
                    paramInt2 = paramInt1;
                    break;
                }
            }
            e(paramInt1, i2, paramInt4);
        }

        private double b(int paramInt) {
            return Math.log(0.35F * Math.abs(paramInt) / (this.m * this.o));
        }

        private double c(int paramInt) {
            double d1 = b(paramInt);
            double d2 = p;
            double d3 = this.m * this.o;
            return Math.exp(d1 * (p / (d2 - 1.0D))) * d3;
        }

        private int d(int paramInt) {
            return (int) (Math.exp(b(paramInt) / (p - 1.0D)) * 1000.0D);
        }

        private void d() {
            float f2 = this.d * this.d / (Math.abs(this.f) * 2.0F);
            float f3 = Math.signum(this.d);
            float f1 = f2;
            if (f2 > this.l) {
                this.f = (-f3 * this.d * this.d / (this.l * 2.0F));
                f1 = this.l;
            }
            this.l = ((int) f1);
            this.n = 2;
            int i1 = this.a;
            if (this.d > 0) {
            }
            for (; ; ) {
                this.c = ((int) f1 + i1);
                this.h = (-(int) (1000.0F * this.d / this.f));
                return;
                f1 = -f1;
            }
        }

        private void d(int paramInt1, int paramInt2, int paramInt3) {
            float f1 = Math.abs((paramInt3 - paramInt1) / (paramInt2 - paramInt1));
            paramInt1 = (int) (100.0F * f1);
            if (paramInt1 < 100) {
                float f2 = paramInt1 / 100.0F;
                float f3 = (paramInt1 + 1) / 100.0F;
                float f4 = r[paramInt1];
                float f5 = r[(paramInt1 + 1)];
                this.h = ((int) (((f1 - f2) / (f3 - f2) * (f5 - f4) + f4) * this.h));
            }
        }

        private void e(int paramInt1, int paramInt2, int paramInt3) {
            this.k = false;
            this.n = 1;
            this.a = paramInt1;
            this.c = paramInt2;
            paramInt1 -= paramInt2;
            this.f = a(paramInt1);
            this.d = (-paramInt1);
            this.l = Math.abs(paramInt1);
            this.h = ((int) (1000.0D * Math.sqrt(-2.0D * paramInt1 / this.f)));
        }

        private void f(int paramInt1, int paramInt2, int paramInt3) {
            float f1 = -paramInt3 / this.f;
            float f2 = (float) Math.sqrt((paramInt3 * paramInt3 / 2.0F / Math.abs(this.f) + Math.abs(paramInt2 - paramInt1)) * 2.0D / Math.abs(this.f));
            this.g -= (int) ((f2 - f1) * 1000.0F);
            this.a = paramInt2;
            this.d = ((int) (-this.f * f2));
        }

        private void g(int paramInt1, int paramInt2, int paramInt3) {
            if (paramInt3 == 0) {
            }
            for (int i1 = paramInt1 - paramInt2; ; i1 = paramInt3) {
                this.f = a(i1);
                f(paramInt1, paramInt2, paramInt3);
                d();
                return;
            }
        }

        void a() {
            this.b = this.c;
            this.k = true;
        }

        void a(float paramFloat) {
            this.m = paramFloat;
        }

        void a(int paramInt1, int paramInt2, int paramInt3) {
            this.k = false;
            this.a = paramInt1;
            this.c = (paramInt1 + paramInt2);
            this.g = AnimationUtils.currentAnimationTimeMillis();
            this.h = paramInt3;
            this.f = 0.0F;
            this.d = 0;
        }

        void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
            this.l = paramInt5;
            this.k = false;
            this.d = paramInt2;
            this.e = paramInt2;
            this.i = 0;
            this.h = 0;
            this.g = AnimationUtils.currentAnimationTimeMillis();
            this.a = paramInt1;
            this.b = paramInt1;
            if ((paramInt1 > paramInt4) || (paramInt1 < paramInt3)) {
                a(paramInt1, paramInt3, paramInt4, paramInt2);
            }
            do {
                return;
                this.n = 0;
                double d1 = 0.0D;
                if (paramInt2 != 0) {
                    paramInt5 = d(paramInt2);
                    this.i = paramInt5;
                    this.h = paramInt5;
                    d1 = c(paramInt2);
                }
                this.j = ((int) (d1 * Math.signum(paramInt2)));
                this.c = (this.j + paramInt1);
                if (this.c < paramInt3) {
                    d(this.a, this.c, paramInt3);
                    this.c = paramInt3;
                }
            } while (this.c <= paramInt4);
            d(this.a, this.c, paramInt4);
            this.c = paramInt4;
        }

        void b(float paramFloat) {
            this.b = (this.a + Math.round((this.c - this.a) * paramFloat));
        }

        boolean b() {
            boolean bool2 = false;
            boolean bool1 = bool2;
            switch (this.n) {
            }
            for (; ; ) {
                c();
                bool1 = true;
                do {
                    return bool1;
                    bool1 = bool2;
                } while (this.h >= this.i);
                this.a = this.c;
                this.d = ((int) this.e);
                this.f = a(this.d);
                this.g += this.h;
                d();
                continue;
                this.g += this.h;
                e(this.c, this.a, 0);
            }
        }

        boolean b(int paramInt1, int paramInt2, int paramInt3) {
            this.k = true;
            this.c = paramInt1;
            this.a = paramInt1;
            this.d = 0;
            this.g = AnimationUtils.currentAnimationTimeMillis();
            this.h = 0;
            if (paramInt1 < paramInt2) {
                e(paramInt1, paramInt2, 0);
            }
            while (!this.k) {
                return true;
                if (paramInt1 > paramInt3) {
                    e(paramInt1, paramInt3, 0);
                }
            }
            return false;
        }

        void c(int paramInt1, int paramInt2, int paramInt3) {
            if (this.n == 0) {
                this.l = paramInt3;
                this.g = AnimationUtils.currentAnimationTimeMillis();
                a(paramInt1, paramInt2, paramInt2, (int) this.e);
            }
        }

        boolean c() {
            long l1 = AnimationUtils.currentAnimationTimeMillis() - this.g;
            if (l1 > this.h) {
                return false;
            }
            double d1 = 0.0D;
            switch (this.n) {
            }
            for (; ; ) {
                int i1 = this.a;
                this.b = ((int) Math.round(d1) + i1);
                return true;
                float f3 = (float) l1 / this.i;
                i1 = (int) (100.0F * f3);
                float f2 = 1.0F;
                float f1 = 0.0F;
                if (i1 < 100) {
                    f2 = i1 / 100.0F;
                    f1 = (i1 + 1) / 100.0F;
                    f4 = q[i1];
                    f1 = (q[(i1 + 1)] - f4) / (f1 - f2);
                    f2 = (f3 - f2) * f1 + f4;
                }
                d1 = f2 * this.j;
                this.e = (f1 * this.j / this.i * 1000.0F);
                continue;
                f1 = (float) l1 / 1000.0F;
                this.e = (this.d + this.f * f1);
                f2 = this.d;
                d1 = f1 * (this.f * f1) / 2.0F + f2 * f1;
                continue;
                f1 = (float) l1 / this.h;
                f2 = f1 * f1;
                f3 = Math.signum(this.d);
                d1 = this.l * f3 * (3.0F * f2 - 2.0F * f1 * f2);
                float f4 = this.l;
                this.e = ((-f1 + f2) * (f3 * f4 * 6.0F));
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/hlist/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */