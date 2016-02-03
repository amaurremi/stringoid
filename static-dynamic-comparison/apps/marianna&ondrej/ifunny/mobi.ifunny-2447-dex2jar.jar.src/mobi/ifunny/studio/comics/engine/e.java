package mobi.ifunny.studio.comics.engine;

import android.graphics.PointF;
import android.graphics.RectF;

public final class e {
    private RectF a = new RectF();
    private RectF b = new RectF();
    private RectF c = new RectF();
    private RectF d = new RectF();
    private float e;
    private float f;
    private float g;

    public static RectF a(RectF paramRectF) {
        float f1 = -paramRectF.left;
        float f2 = -paramRectF.top;
        return new RectF(f1, f2, paramRectF.width() + f1, paramRectF.height() + f2);
    }

    public static RectF a(RectF paramRectF, float paramFloat) {
        RectF localRectF = new RectF();
        localRectF.set(paramRectF.left / paramFloat, paramRectF.top / paramFloat, paramRectF.right / paramFloat, paramRectF.bottom / paramFloat);
        return localRectF;
    }

    public static RectF a(RectF paramRectF, float paramFloat1, float paramFloat2) {
        paramRectF = new RectF(paramRectF);
        paramRectF.offset(paramFloat1, paramFloat2);
        return paramRectF;
    }

    public static RectF a(RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3) {
        return a(a(paramRectF, paramFloat1, paramFloat2), paramFloat3);
    }

    public void a() {
        this.f = 0.0F;
        this.g = 0.0F;
        this.e = 1.0F;
        this.d.setEmpty();
        this.a.setEmpty();
        this.b.setEmpty();
        this.c.setEmpty();
    }

    public void a(float paramFloat) {
        this.e = paramFloat;
        if (this.d != null) {
            this.b = a(this.d, paramFloat);
            this.c = a(this.b);
        }
    }

    public void a(PointF paramPointF) {
        this.a = new RectF(0.0F, 0.0F, paramPointF.x, paramPointF.y);
        this.d = a(this.a, this.f, this.g);
        this.b = a(this.d, this.e);
        this.c = a(this.b);
    }

    public RectF b() {
        return this.a;
    }

    public void b(float paramFloat) {
        this.f = paramFloat;
        if (this.a != null) {
            this.d = a(this.a, paramFloat, this.g);
            this.b = a(this.d, this.e);
            this.c = a(this.b);
        }
    }

    public PointF c() {
        if (this.a == null) {
            return new PointF(0.0F, 0.0F);
        }
        return new PointF(this.a.width(), this.a.height());
    }

    public void c(float paramFloat) {
        this.g = paramFloat;
        if (this.a != null) {
            this.d = a(this.a, this.f, paramFloat);
            this.b = a(this.d, this.e);
            this.c = a(this.b);
        }
    }

    public RectF d() {
        return this.b;
    }

    public RectF e() {
        return this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */