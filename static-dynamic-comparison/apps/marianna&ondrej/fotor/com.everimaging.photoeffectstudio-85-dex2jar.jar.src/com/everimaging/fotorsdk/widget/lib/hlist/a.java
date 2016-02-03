package com.everimaging.fotorsdk.widget.lib.hlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class a {
    private final int A;
    private final int B;
    private final int C;
    private final int D;
    private final int a;
    private final Drawable b;
    private final Drawable c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final int h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private long u;
    private float v;
    private final Interpolator w;
    private int x = 0;
    private float y;
    private final Rect z = new Rect();

    public a(Context paramContext, int paramInt) {
        Resources localResources = paramContext.getResources();
        int i1 = localResources.getIdentifier("fotor_hlv_overscroll_edge", "drawable", paramContext.getPackageName());
        if (i1 > 0) {
            this.b = localResources.getDrawable(i1);
            i1 = localResources.getIdentifier("fotor_hlv_overscroll_glow", "drawable", paramContext.getPackageName());
            if (i1 > 0) {
                this.c = localResources.getDrawable(i1);
                this.a = paramInt;
                this.A = this.b.getIntrinsicHeight();
                this.B = this.c.getIntrinsicHeight();
                this.C = this.c.getIntrinsicWidth();
                this.D = ((int) (Math.min(this.B * 4.0F * this.B / this.C * 0.6F, this.B * 4.0F) + 0.5F));
                this.h = ((int) (localResources.getDisplayMetrics().density * 300.0F + 0.5F));
                this.w = new DecelerateInterpolator();
            }
        } else {
            throw new IllegalStateException("Cannot find resource 'hlv_overscroll_edge'");
        }
        throw new IllegalStateException("Cannot find resource 'hlv_overscroll_glow'");
    }

    private void d() {
        float f1 = Math.min((float) (AnimationUtils.currentAnimationTimeMillis() - this.u) / this.v, 1.0F);
        float f2 = this.w.getInterpolation(f1);
        this.i = (this.m + (this.n - this.m) * f2);
        this.j = (this.o + (this.p - this.o) * f2);
        this.k = (this.q + (this.r - this.q) * f2);
        this.l = (this.s + (this.t - this.s) * f2);
        if (f1 >= 0.999F) {
        }
        switch (this.x) {
            default:
                return;
            case 2:
                this.x = 3;
                this.u = AnimationUtils.currentAnimationTimeMillis();
                this.v = 1000.0F;
                this.m = this.i;
                this.o = this.j;
                this.q = this.k;
                this.s = this.l;
                this.n = 0.0F;
                this.p = 0.0F;
                this.r = 0.0F;
                this.t = 0.0F;
                return;
            case 1:
                this.x = 4;
                this.u = AnimationUtils.currentAnimationTimeMillis();
                this.v = 1000.0F;
                this.m = this.i;
                this.o = this.j;
                this.q = this.k;
                this.s = this.l;
                this.n = 0.0F;
                this.p = 0.0F;
                this.r = 0.0F;
                this.t = 0.0F;
                return;
            case 4:
                if (this.t != 0.0F) {
                }
                for (f1 = 1.0F / (this.t * this.t); ; f1 = Float.MAX_VALUE) {
                    float f3 = this.o;
                    this.j = (f1 * (f2 * (this.p - this.o)) + f3);
                    this.x = 3;
                    return;
                }
        }
        this.x = 0;
    }

    public Rect a(boolean paramBoolean) {
        int i1 = 0;
        this.z.set(0, 0, this.d, this.D);
        Rect localRect = this.z;
        int i2 = this.f;
        int i3 = this.g;
        if (paramBoolean) {
            i1 = this.D;
        }
        localRect.offset(i2, i3 - i1);
        return this.z;
    }

    public void a(float paramFloat) {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        if ((this.x == 4) && ((float) (l1 - this.u) < this.v)) {
            return;
        }
        if (this.x != 1) {
            this.l = 1.0F;
        }
        this.x = 1;
        this.u = l1;
        this.v = 167.0F;
        this.y += paramFloat;
        float f1 = Math.abs(this.y);
        float f2 = Math.max(0.6F, Math.min(f1, 1.0F));
        this.m = f2;
        this.i = f2;
        f1 = Math.max(0.5F, Math.min(f1 * 7.0F, 1.0F));
        this.o = f1;
        this.j = f1;
        f1 = Math.min(1.0F, this.k + Math.abs(paramFloat) * 1.1F);
        this.q = f1;
        this.k = f1;
        f2 = Math.abs(paramFloat);
        f1 = f2;
        if (paramFloat > 0.0F) {
            f1 = f2;
            if (this.y < 0.0F) {
                f1 = -f2;
            }
        }
        if (this.y == 0.0F) {
            this.l = 0.0F;
        }
        paramFloat = Math.min(4.0F, Math.max(0.0F, f1 * 7.0F + this.l));
        this.s = paramFloat;
        this.l = paramFloat;
        this.n = this.i;
        this.p = this.j;
        this.r = this.k;
        this.t = this.l;
    }

    public void a(int paramInt) {
        this.x = 2;
        paramInt = Math.max(100, Math.abs(paramInt));
        this.u = AnimationUtils.currentAnimationTimeMillis();
        this.v = (0.1F + paramInt * 0.03F);
        this.m = 0.0F;
        this.o = 0.0F;
        this.j = 0.0F;
        this.q = 0.5F;
        this.s = 0.0F;
        this.n = Math.max(0, Math.min(paramInt * 8, 1));
        this.p = Math.max(0.5F, Math.min(paramInt * 8, 1.0F));
        this.t = Math.min(0.025F + paramInt / 100 * paramInt * 1.5E-4F, 1.75F);
        this.r = Math.max(this.q, Math.min(paramInt * 16 * 1.0E-5F, 1.0F));
    }

    public void a(int paramInt1, int paramInt2) {
        this.d = paramInt1;
        this.e = paramInt2;
    }

    public boolean a() {
        return this.x == 0;
    }

    public boolean a(Canvas paramCanvas) {
        boolean bool = false;
        d();
        this.c.setAlpha((int) (Math.max(0.0F, Math.min(this.k, 1.0F)) * 255.0F));
        int i1 = (int) Math.min(this.B * this.l * this.B / this.C * 0.6F, this.B * 4.0F);
        int i2;
        if (this.a == 0) {
            this.c.setBounds(0, 0, this.d, i1);
            this.c.draw(paramCanvas);
            this.b.setAlpha((int) (Math.max(0.0F, Math.min(this.i, 1.0F)) * 255.0F));
            i2 = (int) (this.A * this.j);
            if (this.a != 0) {
                break label212;
            }
            this.b.setBounds(0, 0, this.d, i2);
        }
        for (; ; ) {
            this.b.draw(paramCanvas);
            if ((this.x == 3) && (i1 == 0) && (i2 == 0)) {
                this.x = 0;
            }
            if (this.x != 0) {
                bool = true;
            }
            return bool;
            this.c.setBounds(0, 0, this.d, i1);
            break;
            label212:
            this.b.setBounds(0, 0, this.d, i2);
        }
    }

    public void b() {
        this.x = 0;
    }

    public void b(int paramInt1, int paramInt2) {
        this.f = paramInt1;
        this.g = paramInt2;
    }

    public void c() {
        this.y = 0.0F;
        if ((this.x != 1) && (this.x != 4)) {
            return;
        }
        this.x = 3;
        this.m = this.i;
        this.o = this.j;
        this.q = this.k;
        this.s = this.l;
        this.n = 0.0F;
        this.p = 0.0F;
        this.r = 0.0F;
        this.t = 0.0F;
        this.u = AnimationUtils.currentAnimationTimeMillis();
        this.v = 1000.0F;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/hlist/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */