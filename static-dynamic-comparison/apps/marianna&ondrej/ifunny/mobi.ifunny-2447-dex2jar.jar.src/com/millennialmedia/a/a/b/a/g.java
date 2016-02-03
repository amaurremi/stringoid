package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.r;
import com.millennialmedia.a.a.v;
import com.millennialmedia.a.a.w;
import com.millennialmedia.a.a.y;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class g
        extends a {
    private static final Reader a = new h();
    private static final Object b = new Object();
    private final List<Object> c;

    private void a(c paramc) {
        if (f() != paramc) {
            throw new IllegalStateException("Expected " + paramc + " but was " + f());
        }
    }

    private Object q() {
        return this.c.get(this.c.size() - 1);
    }

    private Object r() {
        return this.c.remove(this.c.size() - 1);
    }

    public void a() {
        a(c.a);
        r localr = (r) q();
        this.c.add(localr.iterator());
    }

    public void b() {
        a(c.b);
        r();
        r();
    }

    public void c() {
        a(c.c);
        w localw = (w) q();
        this.c.add(localw.o().iterator());
    }

    public void close() {
        this.c.clear();
        this.c.add(b);
    }

    public void d() {
        a(c.d);
        r();
        r();
    }

    public boolean e() {
        c localc = f();
        return (localc != c.d) && (localc != c.b);
    }

    public c f() {
        if (this.c.isEmpty()) {
            return c.j;
        }
        Object localObject = q();
        if ((localObject instanceof Iterator)) {
            boolean bool = this.c.get(this.c.size() - 2) instanceof w;
            localObject = (Iterator) localObject;
            if (((Iterator) localObject).hasNext()) {
                if (bool) {
                    return c.e;
                }
                this.c.add(((Iterator) localObject).next());
                return f();
            }
            if (bool) {
                return c.d;
            }
            return c.b;
        }
        if ((localObject instanceof w)) {
            return c.c;
        }
        if ((localObject instanceof r)) {
            return c.a;
        }
        if ((localObject instanceof y)) {
            localObject = (y) localObject;
            if (((y) localObject).q()) {
                return c.f;
            }
            if (((y) localObject).o()) {
                return c.h;
            }
            if (((y) localObject).p()) {
                return c.g;
            }
            throw new AssertionError();
        }
        if ((localObject instanceof v)) {
            return c.i;
        }
        if (localObject == b) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    public String g() {
        a(c.e);
        Map.Entry localEntry = (Map.Entry) ((Iterator) q()).next();
        this.c.add(localEntry.getValue());
        return (String) localEntry.getKey();
    }

    public String h() {
        c localc = f();
        if ((localc != c.f) && (localc != c.g)) {
            throw new IllegalStateException("Expected " + c.f + " but was " + localc);
        }
        return ((y) r()).b();
    }

    public boolean i() {
        a(c.h);
        return ((y) r()).f();
    }

    public void j() {
        a(c.i);
        r();
    }

    public double k() {
        c localc = f();
        if ((localc != c.g) && (localc != c.f)) {
            throw new IllegalStateException("Expected " + c.g + " but was " + localc);
        }
        double d = ((y) q()).c();
        if ((!p()) && ((Double.isNaN(d)) || (Double.isInfinite(d)))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + d);
        }
        r();
        return d;
    }

    public long l() {
        c localc = f();
        if ((localc != c.g) && (localc != c.f)) {
            throw new IllegalStateException("Expected " + c.g + " but was " + localc);
        }
        long l = ((y) q()).d();
        r();
        return l;
    }

    public int m() {
        c localc = f();
        if ((localc != c.g) && (localc != c.f)) {
            throw new IllegalStateException("Expected " + c.g + " but was " + localc);
        }
        int i = ((y) q()).e();
        r();
        return i;
    }

    public void n() {
        if (f() == c.e) {
            g();
            return;
        }
        r();
    }

    public void o() {
        a(c.e);
        Map.Entry localEntry = (Map.Entry) ((Iterator) q()).next();
        this.c.add(localEntry.getValue());
        this.c.add(new y((String) localEntry.getKey()));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */