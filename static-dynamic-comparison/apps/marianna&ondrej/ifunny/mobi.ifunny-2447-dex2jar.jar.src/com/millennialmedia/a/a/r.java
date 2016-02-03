package com.millennialmedia.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class r
        extends t
        implements Iterable<t> {
    private final List<t> a = new ArrayList();

    public Number a() {
        if (this.a.size() == 1) {
            return ((t) this.a.get(0)).a();
        }
        throw new IllegalStateException();
    }

    public void a(t paramt) {
        Object localObject = paramt;
        if (paramt == null) {
            localObject = v.a;
        }
        this.a.add(localObject);
    }

    public String b() {
        if (this.a.size() == 1) {
            return ((t) this.a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    public double c() {
        if (this.a.size() == 1) {
            return ((t) this.a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    public long d() {
        if (this.a.size() == 1) {
            return ((t) this.a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    public int e() {
        if (this.a.size() == 1) {
            return ((t) this.a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof r)) && (((r) paramObject).a.equals(this.a)));
    }

    public boolean f() {
        if (this.a.size() == 1) {
            return ((t) this.a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Iterator<t> iterator() {
        return this.a.iterator();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */