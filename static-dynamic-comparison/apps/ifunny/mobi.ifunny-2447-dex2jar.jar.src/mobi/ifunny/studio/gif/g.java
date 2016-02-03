package mobi.ifunny.studio.gif;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;

class g {
    private Typeface a;
    private Rect b;
    private Rect c;
    private Point d;
    private int e;
    private int f;
    private int g;
    private float h;
    private int i;

    private void h() {
        if (this.b == null) {
            return;
        }
        if (this.c == null) {
            this.c = new Rect();
        }
        this.c.left = ((int) (this.b.left * this.h));
        this.c.right = ((int) (this.b.right * this.h));
        this.c.top = ((int) (this.b.top * this.h));
        this.c.bottom = ((int) (this.b.bottom * this.h));
    }

    public Typeface a() {
        return this.a;
    }

    public void a(float paramFloat) {
        this.h = paramFloat;
        h();
    }

    public void a(int paramInt) {
        this.e = paramInt;
    }

    public void a(Point paramPoint) {
        this.d = paramPoint;
    }

    public void a(Rect paramRect) {
        if (this.b == null) {
            this.b = new Rect();
        }
        this.b.set(paramRect);
        h();
    }

    public void a(Typeface paramTypeface) {
        this.a = paramTypeface;
    }

    public Point b() {
        return this.d;
    }

    public void b(int paramInt) {
        this.f = paramInt;
    }

    public int c() {
        return this.f;
    }

    public void c(int paramInt) {
        this.g = paramInt;
    }

    public int d() {
        return this.g;
    }

    public void d(int paramInt) {
        this.i = paramInt;
    }

    public int e() {
        return this.i;
    }

    public Rect f() {
        return this.c;
    }

    public int g() {
        return (int) (this.e * this.h);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */