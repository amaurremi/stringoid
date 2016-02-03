package mobi.ifunny.studio.comics.engine.c;

import android.graphics.RectF;

public class e
        implements Cloneable {
    private d a;
    private f b;
    private RectF c;
    private float d;
    private float e;
    private boolean f;

    public e() {
    }

    public e(d paramd, f paramf, RectF paramRectF, float paramFloat1, float paramFloat2, boolean paramBoolean) {
        this.a = paramd;
        this.c = paramRectF;
        this.d = paramFloat1;
        this.e = paramFloat2;
        this.f = paramBoolean;
        this.b = paramf;
    }

    public d a() {
        return this.a;
    }

    public void a(float paramFloat) {
        this.d = paramFloat;
    }

    public void a(RectF paramRectF) {
        this.c = paramRectF;
    }

    public void a(d paramd) {
        this.a = paramd;
    }

    public void a(f paramf) {
        this.b = paramf;
    }

    public void a(boolean paramBoolean) {
        this.f = paramBoolean;
    }

    public f b() {
        return this.b;
    }

    public void b(float paramFloat) {
        this.e = paramFloat;
    }

    public boolean c() {
        return this.f;
    }

    public Object clone() {
        e locale = (e) super.clone();
        if (this.c != null) {
            locale.c = new RectF(this.c);
        }
        if (this.a != null) {
            locale.a = ((d) this.a.clone());
        }
        if (this.b != null) {
            locale.b = ((f) this.b.clone());
        }
        return locale;
    }

    public RectF d() {
        return this.c;
    }

    public float e() {
        return this.d;
    }

    public float f() {
        return this.e;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */