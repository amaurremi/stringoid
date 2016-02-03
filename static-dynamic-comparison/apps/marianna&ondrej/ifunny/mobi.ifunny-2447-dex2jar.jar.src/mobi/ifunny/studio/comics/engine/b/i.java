package mobi.ifunny.studio.comics.engine.b;

import mobi.ifunny.studio.comics.engine.c.h;
import mobi.ifunny.studio.comics.engine.f;

public abstract class i {
    private Object a;
    private Object b;
    private Object c;
    private h d;

    public i() {
        this(null, null, null, null);
    }

    public i(h paramh) {
        this(paramh, null, null, null);
    }

    public i(h paramh, Object paramObject) {
        this(paramh, null, null, paramObject);
    }

    public i(h paramh, Object paramObject1, Object paramObject2) {
        this(paramh, paramObject1, paramObject2, null);
    }

    public i(h paramh, Object paramObject1, Object paramObject2, Object paramObject3) {
        this.c = paramObject3;
        this.d = paramh;
        this.b = paramObject1;
        this.a = paramObject2;
    }

    public Object a() {
        return this.b;
    }

    public void a(Object paramObject) {
        this.b = paramObject;
    }

    public abstract void a(f paramf);

    public Object b() {
        return this.a;
    }

    public abstract void b(f paramf);

    public h c() {
        return this.d;
    }

    public void c(f paramf) {
        a(paramf);
    }

    public Object d() {
        return this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */