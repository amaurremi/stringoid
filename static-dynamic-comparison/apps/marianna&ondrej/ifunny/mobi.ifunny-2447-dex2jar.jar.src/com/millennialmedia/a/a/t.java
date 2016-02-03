package com.millennialmedia.a.a;

import com.millennialmedia.a.a.b.ai;
import com.millennialmedia.a.a.d.d;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class t {
    public Number a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean g() {
        return this instanceof r;
    }

    public boolean h() {
        return this instanceof w;
    }

    public boolean i() {
        return this instanceof y;
    }

    public boolean j() {
        return this instanceof v;
    }

    public w k() {
        if (h()) {
            return (w) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public r l() {
        if (g()) {
            return (r) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public y m() {
        if (i()) {
            return (y) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    Boolean n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Object localObject = new StringWriter();
            d locald = new d((Writer) localObject);
            locald.b(true);
            ai.a(this, locald);
            localObject = ((StringWriter) localObject).toString();
            return (String) localObject;
        } catch (IOException localIOException) {
            throw new AssertionError(localIOException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */