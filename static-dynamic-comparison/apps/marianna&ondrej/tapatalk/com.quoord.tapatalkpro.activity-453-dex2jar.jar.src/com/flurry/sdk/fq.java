package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class fq<T extends fz> {
    private static final ConcurrentMap<String, ConcurrentMap<Integer, Object>> a = new ConcurrentHashMap();
    private static final fn.f[] b = new fn.f[0];
    private final fn c;
    private final fn.f[] d;
    private final boolean[] e;
    private final ft f;
    private gc g = null;
    private gb h = null;

    protected fq(fn paramfn, ft paramft) {
        this.c = paramfn;
        this.f = paramft;
        this.d = ((fn.f[]) paramfn.b().toArray(b));
        this.e = new boolean[this.d.length];
    }

    protected static boolean b(fn.f paramf, Object paramObject) {
        if (paramObject != null) {
            return true;
        }
        paramf = paramf.c();
        paramObject = paramf.a();
        if (paramObject == fn.v.n) {
            return true;
        }
        if (paramObject == fn.v.e) {
            paramf = paramf.k().iterator();
            while (paramf.hasNext()) {
                if (((fn) paramf.next()).a() == fn.v.n) {
                    return true;
                }
            }
        }
        return false;
    }

    protected Object a(fn.f paramf)
            throws IOException {
        hh localhh = paramf.e();
        if (localhh == null) {
            throw new fk("Field " + paramf + " not set and has no default value");
        }
        if ((localhh.h()) && ((paramf.c().a() == fn.v.n) || ((paramf.c().a() == fn.v.e) && (((fn) paramf.c().k().get(0)).a() == fn.v.n)))) {
            return null;
        }
        Object localObject2 = (ConcurrentMap) a.get(this.c.g());
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            a.putIfAbsent(this.c.g(), new ConcurrentHashMap(this.d.length));
            localObject1 = (ConcurrentMap) a.get(this.c.g());
        }
        Object localObject3 = ((ConcurrentMap) localObject1).get(Integer.valueOf(paramf.b()));
        localObject2 = localObject3;
        if (localObject3 == null) {
            localObject2 = new ByteArrayOutputStream();
            this.g = gj.a().a((OutputStream) localObject2, this.g);
            go.a(this.g, paramf.c(), localhh);
            this.g.flush();
            this.h = gg.a().a(((ByteArrayOutputStream) localObject2).toByteArray(), this.h);
            localObject2 = this.f.a(paramf.c()).a(null, this.h);
            ((ConcurrentMap) localObject1).putIfAbsent(Integer.valueOf(paramf.b()), localObject2);
        }
        return this.f.b(paramf.c(), localObject2);
    }

    protected void a(fn.f paramf, Object paramObject) {
        if (b(paramf, paramObject)) {
        }
        while (paramf.e() != null) {
            return;
        }
        throw new fk("Field " + paramf + " does not accept null values");
    }

    protected final fn.f[] b() {
        return this.d;
    }

    protected final boolean[] c() {
        return this.e;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            do {
                return true;
                if (paramObject == null) {
                    return false;
                }
                if (getClass() != paramObject.getClass()) {
                    return false;
                }
                paramObject = (fq) paramObject;
                if (!Arrays.equals(this.e, ((fq) paramObject).e)) {
                    return false;
                }
                if (this.c != null) {
                    break;
                }
            } while (((fq) paramObject).c == null);
            return false;
        } while (this.c.equals(((fq) paramObject).c));
        return false;
    }

    public int hashCode() {
        int j = Arrays.hashCode(this.e);
        if (this.c == null) {
        }
        for (int i = 0; ; i = this.c.hashCode()) {
            return i + (j + 31) * 31;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */