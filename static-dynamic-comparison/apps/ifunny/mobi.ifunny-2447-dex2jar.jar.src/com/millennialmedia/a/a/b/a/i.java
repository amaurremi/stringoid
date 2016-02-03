package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.d.d;
import com.millennialmedia.a.a.r;
import com.millennialmedia.a.a.t;
import com.millennialmedia.a.a.v;
import com.millennialmedia.a.a.w;
import com.millennialmedia.a.a.y;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class i
        extends d {
    private static final Writer a = new j();
    private static final y b = new y("closed");
    private final List<t> c = new ArrayList();
    private String d;
    private t e = v.a;

    public i() {
        super(a);
    }

    private void a(t paramt) {
        if (this.d != null) {
            if ((!paramt.j()) || (i())) {
                ((w) j()).a(this.d, paramt);
            }
            this.d = null;
            return;
        }
        if (this.c.isEmpty()) {
            this.e = paramt;
            return;
        }
        t localt = j();
        if ((localt instanceof r)) {
            ((r) localt).a(paramt);
            return;
        }
        throw new IllegalStateException();
    }

    private t j() {
        return (t) this.c.get(this.c.size() - 1);
    }

    public d a(long paramLong) {
        a(new y(Long.valueOf(paramLong)));
        return this;
    }

    public d a(Number paramNumber) {
        if (paramNumber == null) {
            return f();
        }
        if (!g()) {
            double d1 = paramNumber.doubleValue();
            if ((Double.isNaN(d1)) || (Double.isInfinite(d1))) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + paramNumber);
            }
        }
        a(new y(paramNumber));
        return this;
    }

    public d a(String paramString) {
        if ((this.c.isEmpty()) || (this.d != null)) {
            throw new IllegalStateException();
        }
        if ((j() instanceof w)) {
            this.d = paramString;
            return this;
        }
        throw new IllegalStateException();
    }

    public d a(boolean paramBoolean) {
        a(new y(Boolean.valueOf(paramBoolean)));
        return this;
    }

    public t a() {
        if (!this.c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.c);
        }
        return this.e;
    }

    public d b() {
        r localr = new r();
        a(localr);
        this.c.add(localr);
        return this;
    }

    public d b(String paramString) {
        if (paramString == null) {
            return f();
        }
        a(new y(paramString));
        return this;
    }

    public d c() {
        if ((this.c.isEmpty()) || (this.d != null)) {
            throw new IllegalStateException();
        }
        if ((j() instanceof r)) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    public void close() {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add(b);
    }

    public d d() {
        w localw = new w();
        a(localw);
        this.c.add(localw);
        return this;
    }

    public d e() {
        if ((this.c.isEmpty()) || (this.d != null)) {
            throw new IllegalStateException();
        }
        if ((j() instanceof w)) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    public d f() {
        a(v.a);
        return this;
    }

    public void flush() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */