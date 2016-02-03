package com.flurry.sdk;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class ht
        extends hf {
    protected hn b;
    protected int c;
    protected boolean d;
    protected hx e;
    protected boolean f;

    protected ht(int paramInt, hn paramhn) {
        this.c = paramInt;
        this.e = hx.g();
        this.b = paramhn;
        this.d = a(hf.a.e);
    }

    public hf a() {
        return a(new sl());
    }

    public void a(hh paramhh)
            throws IOException, hk {
        if (paramhh == null) {
            f();
            return;
        }
        if (this.b == null) {
            throw new IllegalStateException("No ObjectCodec defined for the generator, can not serialize JsonNode-based trees");
        }
        this.b.a(this, paramhh);
    }

    public void a(Object paramObject)
            throws IOException, hk {
        if (paramObject == null) {
            f();
            return;
        }
        if (this.b != null) {
            this.b.a(this, paramObject);
            return;
        }
        b(paramObject);
    }

    public final boolean a(hf.a parama) {
        return (this.c & parama.c()) != 0;
    }

    public void b()
            throws IOException, he {
        h("start an array");
        this.e = this.e.h();
        if (this.a != null) {
            this.a.e(this);
            return;
        }
        i();
    }

    protected void b(Object paramObject)
            throws IOException, he {
        if (paramObject == null) {
            f();
            return;
        }
        if ((paramObject instanceof String)) {
            b((String) paramObject);
            return;
        }
        if ((paramObject instanceof Number)) {
            Number localNumber = (Number) paramObject;
            if ((localNumber instanceof Integer)) {
                b(localNumber.intValue());
                return;
            }
            if ((localNumber instanceof Long)) {
                a(localNumber.longValue());
                return;
            }
            if ((localNumber instanceof Double)) {
                a(localNumber.doubleValue());
                return;
            }
            if ((localNumber instanceof Float)) {
                a(localNumber.floatValue());
                return;
            }
            if ((localNumber instanceof Short)) {
                b(localNumber.shortValue());
                return;
            }
            if ((localNumber instanceof Byte)) {
                b(localNumber.byteValue());
                return;
            }
            if ((localNumber instanceof BigInteger)) {
                a((BigInteger) localNumber);
                return;
            }
            if ((localNumber instanceof BigDecimal)) {
                a((BigDecimal) localNumber);
                return;
            }
            if ((localNumber instanceof AtomicInteger)) {
                b(((AtomicInteger) localNumber).get());
                return;
            }
            if ((localNumber instanceof AtomicLong)) {
                a(((AtomicLong) localNumber).get());
            }
        } else {
            if ((paramObject instanceof byte[])) {
                a((byte[]) paramObject);
                return;
            }
            if ((paramObject instanceof Boolean)) {
                a(((Boolean) paramObject).booleanValue());
                return;
            }
            if ((paramObject instanceof AtomicBoolean)) {
                a(((AtomicBoolean) paramObject).get());
                return;
            }
        }
        throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + paramObject.getClass().getName() + ")");
    }

    public void c()
            throws IOException, he {
        if (!this.e.a()) {
            i("Current context not an ARRAY but " + this.e.d());
        }
        if (this.a != null) {
            this.a.b(this, this.e.e());
        }
        for (; ; ) {
            this.e = this.e.j();
            return;
            j();
        }
    }

    public void close()
            throws IOException {
        this.f = true;
    }

    public void d()
            throws IOException, he {
        h("start an object");
        this.e = this.e.i();
        if (this.a != null) {
            this.a.b(this);
            return;
        }
        k();
    }

    public void d(String paramString)
            throws IOException, he {
        h("write raw value");
        c(paramString);
    }

    public void e()
            throws IOException, he {
        if (!this.e.c()) {
            i("Current context not an object but " + this.e.d());
        }
        this.e = this.e.j();
        if (this.a != null) {
            this.a.a(this, this.e.e());
            return;
        }
        l();
    }

    public final hx h() {
        return this.e;
    }

    protected abstract void h(String paramString)
            throws IOException, he;

    @Deprecated
    protected void i()
            throws IOException, he {
    }

    protected void i(String paramString)
            throws he {
        throw new he(paramString);
    }

    @Deprecated
    protected void j()
            throws IOException, he {
    }

    @Deprecated
    protected void k()
            throws IOException, he {
    }

    @Deprecated
    protected void l()
            throws IOException, he {
    }

    protected void m() {
        throw new RuntimeException("Internal error: should never end up through this code path");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */