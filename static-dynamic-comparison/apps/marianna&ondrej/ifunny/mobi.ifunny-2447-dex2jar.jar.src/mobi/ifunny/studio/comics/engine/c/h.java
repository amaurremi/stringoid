package mobi.ifunny.studio.comics.engine.c;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region.Op;
import mobi.ifunny.studio.comics.a.e;
import mobi.ifunny.util.ah;

public abstract class h
        implements Cloneable {
    private int A = 0;
    protected Paint a;
    protected final int b = 3;
    private final j c;
    private boolean d;
    private RectF e;
    private RectF f;
    private Matrix g;
    private boolean h;
    private boolean i;
    private Paint j;
    private Paint k;
    private PointF l;
    private float m;
    private float n;
    private RectF o;
    private RectF p;
    private int q;
    private int r;
    private int s;
    private int t;
    private float u;
    private float v;
    private float w;
    private boolean x;
    private boolean y;
    private i z;

    public h(j paramj) {
        this.c = paramj;
        this.q = ah.d;
        int i1 = ah.e;
        this.e = new RectF();
        this.f = new RectF();
        this.g = new Matrix();
        this.o = new RectF();
        this.p = new RectF();
        this.n = ah.h;
        this.a = new Paint(3);
        this.j = new Paint(1);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(ah.g);
        this.j.setPathEffect(new DashPathEffect(new float[]{10.0F, 10.0F}, 0.0F));
        this.j.setColor(i1);
        this.l = ah.a;
        this.m = ah.b;
        this.k = new Paint(1);
        this.k.setStrokeWidth(ah.f);
        b(1.0F);
        c(255);
        this.r = 0;
        this.s = 0;
        this.t = ah.c;
        this.i = false;
        this.d = true;
    }

    private void a() {
        this.g.setTranslate(this.e.centerX(), this.e.centerY());
        this.g.preScale(this.v, this.v);
        this.g.preRotate(this.w);
        this.g.preTranslate(-this.e.centerX(), -this.e.centerY());
        e.a(this.e, this.f, this.g);
        this.o.set(-this.t - this.r, -this.t - this.s, this.m + this.r + this.t, this.m + this.r + this.t);
        this.o.offset(this.f.right - this.o.right - this.l.x, this.f.bottom - this.o.bottom - this.l.y);
        this.p.set(this.o);
        this.p.inset(-this.n, -this.n);
    }

    private void c(Canvas paramCanvas) {
        int i1 = paramCanvas.save();
        paramCanvas.drawRect(this.f, this.j);
        paramCanvas.clipRect(this.o, Region.Op.REPLACE);
        paramCanvas.translate(this.o.left, this.o.top);
        d(paramCanvas);
        paramCanvas.restoreToCount(i1);
    }

    private void d(Canvas paramCanvas) {
        float f1 = this.m / 2.0F;
        PointF localPointF = new PointF(this.o.width() / 2.0F, this.o.height() / 2.0F);
        this.k.setStyle(Paint.Style.FILL);
        this.k.setShadowLayer(this.t, this.r, this.s, -1063017565);
        this.k.setColor(-1);
        f1 -= 1.0F;
        paramCanvas.drawCircle(localPointF.x, localPointF.y, f1, this.k);
        this.k.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        this.k.setColor(this.q);
        paramCanvas.drawCircle(localPointF.x, localPointF.y, f1 * 0.85F, this.k);
    }

    public float A() {
        return this.v;
    }

    public float B() {
        return this.w;
    }

    public Paint C() {
        return this.a;
    }

    public void a(float paramFloat) {
        float f1 = u();
        float f2 = v();
        this.e.right = (this.e.left + paramFloat);
        a(f1, f2, paramFloat, f2);
    }

    public void a(float paramFloat1, float paramFloat2) {
        float f1 = u();
        float f2 = v();
        this.e.right = (this.e.left + paramFloat1);
        this.e.bottom = (this.e.top + paramFloat2);
        a(f1, f2, paramFloat1, paramFloat2);
    }

    protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        if ((this.e == null) || ((paramFloat1 == paramFloat3) && (paramFloat2 == paramFloat4))) {
            return;
        }
        this.u = (u() / v());
        a();
    }

    protected abstract void a(Canvas paramCanvas);

    public void a(Paint paramPaint) {
        Paint localPaint = paramPaint;
        if (paramPaint == null) {
            localPaint = new Paint();
        }
        this.a = localPaint;
        if (this.z != null) {
            this.z.a(this, localPaint);
        }
    }

    public void b() {
    }

    public void b(float paramFloat) {
        this.v = paramFloat;
        a();
    }

    public void b(Canvas paramCanvas) {
        if (!this.d) {
        }
        label166:
        label170:
        for (; ; ) {
            return;
            int i1 = paramCanvas.save();
            paramCanvas.clipRect(this.f, Region.Op.REPLACE);
            float f2 = this.e.width() / 2.0F;
            float f3 = this.e.height() / 2.0F;
            paramCanvas.translate(this.e.left + f2, this.e.top + f3);
            float f1;
            if (m()) {
                f1 = -this.v;
                paramCanvas.scale(f1, this.v);
                paramCanvas.rotate(this.w);
                paramCanvas.translate(-f2, -f3);
                a(paramCanvas);
                paramCanvas.restoreToCount(i1);
                if ((this.c != j.f) && (this.i)) {
                    break label166;
                }
            }
            for (i1 = 1; ; i1 = 0) {
                if ((!this.h) || (i1 == 0)) {
                    break label170;
                }
                c(paramCanvas);
                return;
                f1 = this.v;
                break;
            }
        }
    }

    public void b(PointF paramPointF) {
        float f1 = paramPointF.x - this.e.left;
        float f2 = paramPointF.y - this.e.top;
        this.e.offset(f1, f2);
        this.f.offset(f1, f2);
        this.o.offset(f1, f2);
        this.p.offset(f1, f2);
    }

    public void b(RectF paramRectF) {
        c(new PointF(paramRectF.centerX(), paramRectF.centerY()));
    }

    public void b(boolean paramBoolean) {
        this.d = paramBoolean;
    }

    public void c(float paramFloat) {
        this.w = paramFloat;
        a();
    }

    public void c(int paramInt) {
        this.a.setAlpha(paramInt);
    }

    public void c(PointF paramPointF) {
        float f1 = u() / 2.0F;
        float f2 = v() / 2.0F;
        b(new PointF(paramPointF.x - f1, paramPointF.y - f2));
    }

    public void c(RectF paramRectF) {
        float f1 = u();
        float f2 = v();
        this.e = paramRectF;
        a(f1, f2, paramRectF.width(), paramRectF.height());
    }

    public void c(boolean paramBoolean) {
        this.i = paramBoolean;
    }

    public Object clone() {
        h localh = (h) super.clone();
        localh.a = new Paint(this.a);
        localh.j = new Paint(this.j);
        localh.o = new RectF(this.o);
        localh.p = new RectF(this.p);
        localh.k = new Paint(this.k);
        localh.f = new RectF(this.f);
        localh.g = new Matrix();
        localh.l = new PointF(this.l.x, this.l.y);
        localh.c(new RectF(this.e));
        return localh;
    }

    public void d(int paramInt) {
        this.A = paramInt;
        if (this.A == 0) {
            return;
        }
        int i1 = i() - this.A;
        paramInt = i1;
        if (i1 < 0) {
            paramInt = 0;
        }
        c(paramInt);
    }

    public void d(boolean paramBoolean) {
        this.x = paramBoolean;
    }

    public void e(int paramInt) {
        this.a.setColor(paramInt);
    }

    public void e(boolean paramBoolean) {
        this.h = paramBoolean;
    }

    public void f(boolean paramBoolean) {
        this.y = paramBoolean;
    }

    public int i() {
        return this.a.getAlpha();
    }

    public RectF k() {
        return this.p;
    }

    public void l() {
        if (!this.x) {
        }
        for (boolean bool = true; ; bool = false) {
            this.x = bool;
            return;
        }
    }

    public boolean m() {
        return this.x;
    }

    public j n() {
        return this.c;
    }

    public boolean o() {
        return this.y;
    }

    public RectF p() {
        return this.f;
    }

    public PointF q() {
        return new PointF(this.e.left, this.e.top);
    }

    public PointF r() {
        return new PointF(this.e.centerX(), this.e.centerY());
    }

    public float s() {
        return this.e.centerX();
    }

    public float t() {
        return this.e.centerY();
    }

    public float u() {
        return this.e.width();
    }

    public float v() {
        return this.e.height();
    }

    public RectF w() {
        return this.e;
    }

    public int x() {
        return this.A;
    }

    public void y() {
        int i1 = 255;
        if (this.A == 0) {
            return;
        }
        int i2 = i() + this.A;
        if (i2 > 255) {
        }
        for (; ; ) {
            c(i1);
            this.A = 0;
            return;
            i1 = i2;
        }
    }

    public int z() {
        return this.a.getColor();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */