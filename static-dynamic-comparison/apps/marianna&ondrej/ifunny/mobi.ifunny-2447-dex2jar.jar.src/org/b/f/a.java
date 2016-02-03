package org.b.f;

import java.nio.ByteBuffer;

import org.b.c.g;
import org.b.d.aj;
import org.b.e.ae;

public abstract class a
        implements q {
    protected org.b.a a;
    protected int b = 134217728;
    protected int c = 4194304;
    protected int d = 2097152;

    protected a(org.b.a parama) {
        this.a = parama;
    }

    public <T> T a(Class<T> paramClass) {
        if (f()) {
            return null;
        }
        return (T) this.a.a(paramClass).a(this, null);
    }

    public <T> T a(T paramT) {
        if (f()) {
            return null;
        }
        return (T) this.a.a(paramT.getClass()).a(this, paramT);
    }

    public <T> T a(aj<T> paramaj) {
        if (f()) {
            return null;
        }
        return (T) paramaj.a(this, null);
    }

    public ByteBuffer a() {
        return ByteBuffer.wrap(q());
    }

    protected abstract void a(g paramg);

    public void b() {
        a(false);
    }

    public void c() {
        b(false);
    }

    public r d() {
        return new r(this);
    }

    public ae e() {
        g localg = new g(this.a);
        a(localg);
        return localg.c();
    }

    protected abstract boolean f();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */