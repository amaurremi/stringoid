package com.flurry.sdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class fv<D> {
    private final ft a;
    private fn b;

    protected fv(fn paramfn, ft paramft) {
        this(paramft);
        a(paramfn);
    }

    protected fv(ft paramft) {
        this.a = paramft;
    }

    private void b(fn paramfn, Object paramObject) {
        throw new fl("Not a " + paramfn + ": " + paramObject);
    }

    protected int a(fn paramfn, Object paramObject) {
        return this.a.a(paramfn, paramObject);
    }

    protected long a(Object paramObject) {
        return ((Collection) paramObject).size();
    }

    protected NullPointerException a(NullPointerException paramNullPointerException, String paramString) {
        paramString = new NullPointerException(paramNullPointerException.getMessage() + paramString);
        if (paramNullPointerException.getCause() == null) {
        }
        for (; ; ) {
            paramString.initCause(paramNullPointerException);
            return paramString;
            paramNullPointerException = paramNullPointerException.getCause();
        }
    }

    public void a(fn paramfn) {
        this.b = paramfn;
    }

    protected void a(fn paramfn, Object paramObject, gi paramgi)
            throws IOException {
        for (; ; ) {
            try {
                switch (1. a[paramfn.a().ordinal()])
                {
                    case 1:
                        b(paramfn, paramObject);
                        return;
                }
            } catch (NullPointerException paramObject) {
                throw a((NullPointerException) paramObject, " of " + paramfn.g());
            }
            b(paramfn, paramObject, paramgi);
            return;
            c(paramfn, paramObject, paramgi);
            return;
            d(paramfn, paramObject, paramgi);
            return;
            e(paramfn, paramObject, paramgi);
            return;
            int i = a(paramfn, paramObject);
            paramgi.b(i);
            a((fn) paramfn.k().get(i), paramObject, paramgi);
            return;
            g(paramfn, paramObject, paramgi);
            return;
            f(paramfn, paramObject, paramgi);
            return;
            c(paramObject, paramgi);
            return;
            paramgi.c(((Number) paramObject).intValue());
            return;
            paramgi.b(((Long) paramObject).longValue());
            return;
            paramgi.a(((Float) paramObject).floatValue());
            return;
            paramgi.a(((Double) paramObject).doubleValue());
            return;
            paramgi.a(((Boolean) paramObject).booleanValue());
            return;
            paramgi.a();
            return;
        }
    }

    public void a(D paramD, gi paramgi)
            throws IOException {
        a(this.b, paramD, paramgi);
    }

    protected Iterator<? extends Object> b(Object paramObject) {
        return ((Collection) paramObject).iterator();
    }

    protected void b(fn paramfn, Object paramObject, gi paramgi)
            throws IOException {
        Object localObject1 = this.a.a(paramObject, paramfn);
        Iterator localIterator = paramfn.b().iterator();
        while (localIterator.hasNext()) {
            paramfn = (fn.f) localIterator.next();
            Object localObject2 = this.a.b(paramObject, paramfn.a(), paramfn.b(), localObject1);
            try {
                a(paramfn.c(), localObject2, paramgi);
            } catch (NullPointerException paramObject) {
                throw a((NullPointerException) paramObject, " in field " + paramfn.a());
            }
        }
    }

    protected void b(Object paramObject, gi paramgi)
            throws IOException {
        paramgi.a((CharSequence) paramObject);
    }

    protected int c(Object paramObject) {
        return ((Map) paramObject).size();
    }

    protected void c(fn paramfn, Object paramObject, gi paramgi)
            throws IOException {
        paramgi.a(paramfn.c(paramObject.toString()));
    }

    protected void c(Object paramObject, gi paramgi)
            throws IOException {
        paramgi.a((ByteBuffer) paramObject);
    }

    protected Iterable<Map.Entry<Object, Object>> d(Object paramObject) {
        return ((Map) paramObject).entrySet();
    }

    protected void d(fn paramfn, Object paramObject, gi paramgi)
            throws IOException {
        paramfn = paramfn.i();
        long l = a(paramObject);
        paramgi.b();
        paramgi.a(l);
        paramObject = b(paramObject);
        while (((Iterator) paramObject).hasNext()) {
            paramgi.c();
            a(paramfn, ((Iterator) paramObject).next(), paramgi);
        }
        paramgi.d();
    }

    protected void e(fn paramfn, Object paramObject, gi paramgi)
            throws IOException {
        paramfn = paramfn.j();
        int i = c(paramObject);
        paramgi.e();
        paramgi.a(i);
        paramObject = d(paramObject).iterator();
        while (((Iterator) paramObject).hasNext()) {
            Map.Entry localEntry = (Map.Entry) ((Iterator) paramObject).next();
            paramgi.c();
            b(localEntry.getKey(), paramgi);
            a(paramfn, localEntry.getValue(), paramgi);
        }
        paramgi.f();
    }

    protected void f(fn paramfn, Object paramObject, gi paramgi)
            throws IOException {
        b(paramObject, paramgi);
    }

    protected void g(fn paramfn, Object paramObject, gi paramgi)
            throws IOException {
        paramgi.b(((fx) paramObject).b(), 0, paramfn.l());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/fv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */