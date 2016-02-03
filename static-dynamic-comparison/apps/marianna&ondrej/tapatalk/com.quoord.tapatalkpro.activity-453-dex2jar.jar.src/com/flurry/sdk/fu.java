package com.flurry.sdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fu<D>
        implements ge<D> {
    private static final ThreadLocal<Map<fn, Map<fn, gl>>> f = new ThreadLocal() {
        protected Map<fn, Map<fn, gl>> a() {
            return new gz();
        }
    };
    private final ft a;
    private fn b;
    private fn c;
    private gl d = null;
    private final Thread e;

    public fu() {
        this(null, null, ft.a());
    }

    protected fu(fn paramfn1, fn paramfn2, ft paramft) {
        this.b = paramfn1;
        this.c = paramfn2;
        this.a = paramft;
        this.e = Thread.currentThread();
    }

    public ft a() {
        return this.a;
    }

    protected final gl a(fn paramfn1, fn paramfn2)
            throws IOException {
        Thread localThread = Thread.currentThread();
        if ((localThread == this.e) && (this.d != null)) {
            paramfn1 = this.d;
            return paramfn1;
        }
        Object localObject = (Map) ((Map) f.get()).get(paramfn1);
        if (localObject == null) {
            localObject = new gz();
            ((Map) f.get()).put(paramfn1, localObject);
        }
        for (; ; ) {
            gl localgl2 = (gl) ((Map) localObject).get(paramfn2);
            gl localgl1 = localgl2;
            if (localgl2 == null) {
                localgl1 = gg.a().a(fn.a(paramfn1, paramfn2), paramfn2, null);
                ((Map) localObject).put(paramfn2, localgl1);
            }
            paramfn1 = localgl1;
            if (localThread != this.e) {
                break;
            }
            this.d = localgl1;
            return localgl1;
        }
    }

    protected Object a(fn paramfn, gf paramgf)
            throws IOException {
        return a((String) paramfn.c().get(paramgf.k()), paramfn);
    }

    protected Object a(Object paramObject) {
        if ((paramObject instanceof fr)) {
            return ((fr) paramObject).b();
        }
        return null;
    }

    protected Object a(Object paramObject, int paramInt) {
        if ((paramObject instanceof Map)) {
            ((Map) paramObject).clear();
            return paramObject;
        }
        return new HashMap(paramInt);
    }

    protected Object a(Object paramObject, int paramInt, fn paramfn) {
        if ((paramObject instanceof Collection)) {
            ((Collection) paramObject).clear();
            return paramObject;
        }
        return new ft.a(paramInt, paramfn);
    }

    protected Object a(Object paramObject, fn paramfn, gf paramgf)
            throws IOException {
        paramObject = (fx) this.a.c(paramObject, paramfn);
        paramgf.b(((fx) paramObject).b(), 0, paramfn.l());
        return paramObject;
    }

    protected Object a(Object paramObject, fn paramfn, gl paramgl)
            throws IOException {
        switch (2. a[paramfn.a().ordinal()])
        {
            default:
                throw new fk("Unknown type: " + paramfn);
            case 1:
                return b(paramObject, paramfn, paramgl);
            case 2:
                return a(paramfn, paramgl);
            case 3:
                return c(paramObject, paramfn, paramgl);
            case 4:
                return d(paramObject, paramfn, paramgl);
            case 5:
                return a(paramObject, (fn) paramfn.k().get(paramgl.s()), paramgl);
            case 6:
                return a(paramObject, paramfn, paramgl);
            case 7:
                return b(paramObject, paramfn, paramgl);
            case 8:
                return c(paramObject, paramgl);
            case 9:
                return c(paramObject, paramfn, paramgl);
            case 10:
                return Long.valueOf(paramgl.e());
            case 11:
                return Float.valueOf(paramgl.f());
            case 12:
                return Double.valueOf(paramgl.g());
            case 13:
                return Boolean.valueOf(paramgl.c());
        }
        paramgl.b();
        return null;
    }

    public D a(D paramD, gf paramgf)
            throws IOException {
        gl localgl = a(this.b, this.c);
        localgl.a(paramgf);
        paramD = a(paramD, this.c, localgl);
        localgl.v();
        return paramD;
    }

    protected Object a(String paramString, fn paramfn) {
        return new ft.b(paramfn, paramString);
    }

    protected void a(Object paramObject1, long paramLong, Object paramObject2) {
        ((Collection) paramObject1).add(paramObject2);
    }

    protected void a(Object paramObject1, Object paramObject2, Object paramObject3) {
        ((Map) paramObject1).put(paramObject2, paramObject3);
    }

    protected Object b(Object paramObject, fn paramfn, gf paramgf)
            throws IOException {
        ft localft = this.a;
        localft = this.a;
        if ("String".equals(paramfn.a("avro.java.string"))) {
            return paramgf.h();
        }
        return b(paramObject, paramgf);
    }

    protected Object b(Object paramObject, fn paramfn, gl paramgl)
            throws IOException {
        Object localObject1 = this.a.d(paramObject, paramfn);
        Object localObject2 = this.a.a(localObject1, paramfn);
        fn.f[] arrayOff = paramgl.u();
        int j = arrayOff.length;
        int i = 0;
        if (i < j) {
            fn.f localf = arrayOff[i];
            int k = localf.b();
            String str = localf.a();
            if (paramObject != null) {
            }
            for (paramfn = this.a.b(localObject1, str, k, localObject2); ; paramfn = null) {
                this.a.a(localObject1, str, k, a(paramfn, localf.c(), paramgl), localObject2);
                i += 1;
                break;
            }
        }
        return localObject1;
    }

    protected Object b(Object paramObject, gf paramgf)
            throws IOException {
        if ((paramObject instanceof gy)) {
        }
        for (paramObject = (gy) paramObject; ; paramObject = null) {
            return paramgf.a((gy) paramObject);
        }
    }

    protected Object c(Object paramObject, fn paramfn, gf paramgf)
            throws IOException {
        return Integer.valueOf(paramgf.d());
    }

    protected Object c(Object paramObject, fn paramfn, gl paramgl)
            throws IOException {
        fn localfn = paramfn.i();
        long l1 = paramgl.m();
        long l2 = 0L;
        if (l1 > 0L) {
            paramObject = a(paramObject, (int) l1, paramfn);
            long l3;
            do {
                for (l3 = 0L; l3 < l1; l3 += 1L) {
                    a(paramObject, l2 + l3, a(a(paramObject), localfn, paramgl));
                }
                l2 += l1;
                l3 = paramgl.n();
                l1 = l3;
            } while (l3 > 0L);
            return paramObject;
        }
        return a(paramObject, 0, paramfn);
    }

    protected Object c(Object paramObject, gf paramgf)
            throws IOException {
        if ((paramObject instanceof ByteBuffer)) {
        }
        for (paramObject = (ByteBuffer) paramObject; ; paramObject = null) {
            return paramgf.a((ByteBuffer) paramObject);
        }
    }

    protected Object d(Object paramObject, fn paramfn, gl paramgl)
            throws IOException {
        fn localfn = paramfn.j();
        long l1 = paramgl.p();
        paramObject = a(paramObject, (int) l1);
        if (l1 > 0L) {
            long l2;
            do {
                int i = 0;
                while (i < l1) {
                    a(paramObject, b(null, paramfn, paramgl), a(null, localfn, paramgl));
                    i += 1;
                }
                l2 = paramgl.q();
                l1 = l2;
            } while (l2 > 0L);
        }
        return paramObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */