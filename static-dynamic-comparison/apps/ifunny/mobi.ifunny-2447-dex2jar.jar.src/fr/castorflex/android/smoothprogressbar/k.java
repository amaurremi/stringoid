package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.Interpolator;

public class k
        extends Drawable
        implements Animatable {
    private int[] A;
    private float[] B;
    private final Runnable C = new l(this);
    private final Rect a = new Rect();
    private n b;
    private Interpolator c;
    private Rect d;
    private Paint e;
    private int[] f;
    private int g;
    private boolean h = false;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;
    private float o;
    private boolean p;
    private boolean q;
    private boolean r;
    private float s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private float x;
    private Drawable y;
    private boolean z;

    private k(Interpolator paramInterpolator, int paramInt1, int paramInt2, int[] paramArrayOfInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean1, boolean paramBoolean2, n paramn, boolean paramBoolean3, Drawable paramDrawable, boolean paramBoolean4) {
        this.c = paramInterpolator;
        this.l = paramInt1;
        this.v = 0;
        this.w = this.l;
        this.k = paramInt2;
        this.m = paramFloat2;
        this.n = paramFloat3;
        this.o = paramFloat4;
        this.p = paramBoolean1;
        this.f = paramArrayOfInt;
        this.g = 0;
        this.r = paramBoolean2;
        this.t = false;
        this.y = paramDrawable;
        this.x = paramFloat1;
        this.s = (1.0F / this.l);
        this.e = new Paint();
        this.e.setStrokeWidth(paramFloat1);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setDither(false);
        this.e.setAntiAlias(false);
        this.u = paramBoolean3;
        this.b = paramn;
        this.z = paramBoolean4;
        a();
    }

    private void a(Canvas paramCanvas) {
        float f1 = 1.0F / this.l;
        int i2 = this.g;
        this.B[0] = 0.0F;
        this.B[(this.B.length - 1)] = 1.0F;
        int i3 = i2 - 1;
        int i1 = i3;
        if (i3 < 0) {
            i1 = i3 + this.f.length;
        }
        this.A[0] = this.f[i1];
        i1 = 0;
        float f2;
        while (i1 < this.l) {
            f2 = this.c.getInterpolation(i1 * f1 + this.i);
            this.B[(i1 + 1)] = f2;
            this.A[(i1 + 1)] = this.f[i2];
            i2 = (i2 + 1) % this.f.length;
            i1 += 1;
        }
        this.A[(this.A.length - 1)] = this.f[i2];
        label210:
        label233:
        label237:
        float f3;
        float f4;
        float f5;
        float f6;
        int[] arrayOfInt;
        float[] arrayOfFloat;
        if (this.p) {
            if (this.r) {
                i1 = Math.abs(this.d.left - this.d.right) / 2;
                f1 = i1;
                if (!this.r) {
                    break label380;
                }
                if (!this.p) {
                    break label355;
                }
                i1 = this.d.left;
                f2 = i1;
                f3 = this.d.centerY();
                f4 = this.x / 2.0F;
                f5 = this.d.centerY();
                f6 = this.x / 2.0F;
                arrayOfInt = this.A;
                arrayOfFloat = this.B;
                if (!this.r) {
                    break label392;
                }
            }
        }
        label355:
        label380:
        label392:
        for (paramCanvas = Shader.TileMode.MIRROR; ; paramCanvas = Shader.TileMode.CLAMP) {
            paramCanvas = new LinearGradient(f1, f3 - f4, f2, f6 + f5, arrayOfInt, arrayOfFloat, paramCanvas);
            this.e.setShader(paramCanvas);
            return;
            i1 = this.d.left;
            break;
            f1 = this.d.left;
            break label210;
            i1 = Math.abs(this.d.left - this.d.right) / 2;
            break label233;
            f2 = this.d.right;
            break label237;
        }
    }

    private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2) {
        if (this.y == null) {
        }
        label190:
        do {
            return;
            this.a.top = ((int) ((paramCanvas.getHeight() - this.x) / 2.0F));
            this.a.bottom = ((int) ((paramCanvas.getHeight() + this.x) / 2.0F));
            this.a.left = 0;
            Rect localRect = this.a;
            if (this.r) {
            }
            for (int i1 = paramCanvas.getWidth() / 2; ; i1 = paramCanvas.getWidth()) {
                localRect.right = i1;
                this.y.setBounds(this.a);
                if (isRunning()) {
                    break label190;
                }
                if (!this.r) {
                    break;
                }
                paramCanvas.save();
                paramCanvas.translate(paramCanvas.getWidth() / 2, 0.0F);
                b(paramCanvas, 0.0F, this.a.width());
                paramCanvas.scale(-1.0F, 1.0F);
                b(paramCanvas, 0.0F, this.a.width());
                paramCanvas.restore();
                return;
            }
            b(paramCanvas, 0.0F, this.a.width());
            return;
        } while ((!c()) && (!b()));
        float f1;
        if (paramFloat1 > paramFloat2) {
            f1 = paramFloat2;
            paramFloat2 = paramFloat1;
        }
        for (; ; ) {
            if (f1 > 0.0F) {
                if (!this.r) {
                    break label413;
                }
                paramCanvas.save();
                paramCanvas.translate(paramCanvas.getWidth() / 2, 0.0F);
                if (this.p) {
                    b(paramCanvas, 0.0F, f1);
                    paramCanvas.scale(-1.0F, 1.0F);
                    b(paramCanvas, 0.0F, f1);
                    label276:
                    paramCanvas.restore();
                }
            } else {
                label280:
                if (paramFloat2 > paramCanvas.getWidth()) {
                    break label422;
                }
                if (!this.r) {
                    break label464;
                }
                paramCanvas.save();
                paramCanvas.translate(paramCanvas.getWidth() / 2, 0.0F);
                if (!this.p) {
                    break label424;
                }
                b(paramCanvas, paramFloat2, paramCanvas.getWidth() / 2);
                paramCanvas.scale(-1.0F, 1.0F);
                b(paramCanvas, paramFloat2, paramCanvas.getWidth() / 2);
            }
            for (; ; ) {
                paramCanvas.restore();
                return;
                b(paramCanvas, paramCanvas.getWidth() / 2 - f1, paramCanvas.getWidth() / 2);
                paramCanvas.scale(-1.0F, 1.0F);
                b(paramCanvas, paramCanvas.getWidth() / 2 - f1, paramCanvas.getWidth() / 2);
                break label276;
                label413:
                b(paramCanvas, 0.0F, f1);
                break label280;
                label422:
                break;
                label424:
                b(paramCanvas, 0.0F, paramCanvas.getWidth() / 2 - paramFloat2);
                paramCanvas.scale(-1.0F, 1.0F);
                b(paramCanvas, 0.0F, paramCanvas.getWidth() / 2 - paramFloat2);
            }
            label464:
            b(paramCanvas, paramFloat2, paramCanvas.getWidth());
            return;
            f1 = paramFloat1;
        }
    }

    private void a(Canvas paramCanvas, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2) {
        this.e.setColor(this.f[paramInt2]);
        if (!this.r) {
            paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.e);
            return;
        }
        if (this.p) {
            paramCanvas.drawLine(paramInt1 + paramFloat1, paramFloat2, paramInt1 + paramFloat3, paramFloat4, this.e);
            paramCanvas.drawLine(paramInt1 - paramFloat1, paramFloat2, paramInt1 - paramFloat3, paramFloat4, this.e);
            return;
        }
        paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.e);
        paramCanvas.drawLine(paramInt1 * 2 - paramFloat1, paramFloat2, paramInt1 * 2 - paramFloat3, paramFloat4, this.e);
    }

    private void b(Canvas paramCanvas) {
        if (this.p) {
            paramCanvas.translate(this.d.width(), 0.0F);
            paramCanvas.scale(-1.0F, 1.0F);
        }
        int i2 = this.d.width();
        int i1 = i2;
        if (this.r) {
            i1 = i2 / 2;
        }
        int i4 = this.k + i1 + this.l;
        int i5 = this.d.centerY();
        float f6 = 1.0F / this.l;
        float f2 = 0.0F;
        int i3 = this.g;
        float f1 = f2;
        if (this.v == this.w) {
            f1 = f2;
            if (this.w == this.l) {
                f1 = paramCanvas.getWidth();
            }
        }
        i2 = 0;
        float f4 = 0.0F;
        float f3 = 0.0F;
        f2 = f1;
        f1 = f4;
        float f5;
        float f7;
        if (i2 <= this.w) {
            f5 = i2 * f6 + this.i;
            f4 = Math.max(0.0F, f5 - f6);
            f7 = (int) (Math.abs(this.c.getInterpolation(f4) - this.c.getInterpolation(Math.min(f5, 1.0F))) * i4);
            if (f7 + f4 < i4) {
                f4 = Math.min(f7, this.k);
                label234:
                if (f7 <= f4) {
                    break label399;
                }
                f5 = f7 - f4;
                label249:
                f5 = f3 + f5;
                if ((f5 <= f3) || (i2 < this.v)) {
                    break label416;
                }
                float f8 = Math.max(this.c.getInterpolation(Math.min(this.j, 1.0F)) * i4, Math.min(i1, f3));
                float f9 = Math.min(i1, f5);
                a(paramCanvas, i1, f8, i5, f9, i5, i3);
                if (i2 != this.v) {
                    break label416;
                }
                f2 = f8 - this.k;
            }
        }
        label399:
        label416:
        for (; ; ) {
            if (i2 == this.w) {
                f1 = f3 + f7;
            }
            for (; ; ) {
                i3 = d(i3);
                i2 += 1;
                f3 = f5 + f4;
                break;
                f4 = 0.0F;
                break label234;
                f5 = 0.0F;
                break label249;
                a(paramCanvas, f2, f1);
                return;
            }
        }
    }

    private void b(Canvas paramCanvas, float paramFloat1, float paramFloat2) {
        int i1 = paramCanvas.save();
        paramCanvas.clipRect(paramFloat1, (int) ((paramCanvas.getHeight() - this.x) / 2.0F), paramFloat2, (int) ((paramCanvas.getHeight() + this.x) / 2.0F));
        this.y.draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
    }

    private int d(int paramInt) {
        int i1 = paramInt + 1;
        paramInt = i1;
        if (i1 >= this.f.length) {
            paramInt = 0;
        }
        return paramInt;
    }

    private int e(int paramInt) {
        int i1 = paramInt - 1;
        paramInt = i1;
        if (i1 < 0) {
            paramInt = this.f.length - 1;
        }
        return paramInt;
    }

    private void f(int paramInt) {
        g(paramInt);
        this.i = 0.0F;
        this.t = false;
        this.j = 0.0F;
        this.v = 0;
        this.w = 0;
        this.g = paramInt;
    }

    private void g(int paramInt) {
        if ((paramInt < 0) || (paramInt >= this.f.length)) {
            throw new IllegalArgumentException(String.format("Index %d not valid", new Object[]{Integer.valueOf(paramInt)}));
        }
    }

    protected void a() {
        if (this.z) {
            this.A = new int[this.l + 2];
            this.B = new float[this.l + 2];
            return;
        }
        this.e.setShader(null);
        this.A = null;
        this.B = null;
    }

    public void a(float paramFloat) {
        if (paramFloat < 0.0F) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
        this.m = paramFloat;
        invalidateSelf();
    }

    public void a(int paramInt) {
        a(new int[]{paramInt});
    }

    public void a(Drawable paramDrawable) {
        if (this.y == paramDrawable) {
            return;
        }
        this.y = paramDrawable;
        invalidateSelf();
    }

    public void a(Interpolator paramInterpolator) {
        if (paramInterpolator == null) {
            throw new IllegalArgumentException("Interpolator cannot be null");
        }
        this.c = paramInterpolator;
        invalidateSelf();
    }

    public void a(n paramn) {
        this.b = paramn;
    }

    public void a(boolean paramBoolean) {
        if (this.p == paramBoolean) {
            return;
        }
        this.p = paramBoolean;
        invalidateSelf();
    }

    public void a(int[] paramArrayOfInt) {
        if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        }
        this.g = 0;
        this.f = paramArrayOfInt;
        a();
        invalidateSelf();
    }

    public void b(float paramFloat) {
        if (paramFloat < 0.0F) {
            throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
        }
        this.n = paramFloat;
        invalidateSelf();
    }

    public void b(int paramInt) {
        if (paramInt <= 0) {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
        this.l = paramInt;
        this.s = (1.0F / this.l);
        this.i %= this.s;
        a();
        invalidateSelf();
    }

    public void b(boolean paramBoolean) {
        if (this.r == paramBoolean) {
            return;
        }
        this.r = paramBoolean;
        invalidateSelf();
    }

    public boolean b() {
        return this.w < this.l;
    }

    public void c(float paramFloat) {
        if (paramFloat < 0.0F) {
            throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
        }
        this.o = paramFloat;
        invalidateSelf();
    }

    public void c(int paramInt) {
        if (paramInt < 0) {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
        this.k = paramInt;
        invalidateSelf();
    }

    public void c(boolean paramBoolean) {
        this.u = paramBoolean;
    }

    public boolean c() {
        return this.t;
    }

    public void d(float paramFloat) {
        if (paramFloat < 0.0F) {
            throw new IllegalArgumentException("The strokeWidth must be >= 0");
        }
        this.e.setStrokeWidth(paramFloat);
        invalidateSelf();
    }

    public void d(boolean paramBoolean) {
        if (this.z == paramBoolean) {
            return;
        }
        this.z = paramBoolean;
        a();
        invalidateSelf();
    }

    public void draw(Canvas paramCanvas) {
        this.d = getBounds();
        paramCanvas.clipRect(this.d);
        if (this.q) {
            this.g = e(this.g);
            this.q = false;
            if (c()) {
                this.v += 1;
                if (this.v > this.l) {
                    stop();
                    return;
                }
            }
            if (this.w < this.l) {
                this.w += 1;
            }
        }
        if (this.z) {
            a(paramCanvas);
        }
        b(paramCanvas);
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.h;
    }

    public void scheduleSelf(Runnable paramRunnable, long paramLong) {
        this.h = true;
        super.scheduleSelf(paramRunnable, paramLong);
    }

    public void setAlpha(int paramInt) {
        this.e.setAlpha(paramInt);
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
        this.e.setColorFilter(paramColorFilter);
    }

    public void start() {
        if (this.u) {
            f(0);
        }
        if (isRunning()) {
            return;
        }
        if (this.b != null) {
            this.b.b();
        }
        scheduleSelf(this.C, SystemClock.uptimeMillis() + 16L);
        invalidateSelf();
    }

    public void stop() {
        if (!isRunning()) {
            return;
        }
        if (this.b != null) {
            this.b.a();
        }
        this.h = false;
        unscheduleSelf(this.C);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/fr/castorflex/android/smoothprogressbar/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */