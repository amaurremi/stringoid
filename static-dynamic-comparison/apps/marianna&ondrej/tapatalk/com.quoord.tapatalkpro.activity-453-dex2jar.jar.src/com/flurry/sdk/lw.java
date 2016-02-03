package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

@kb
public class lw
        extends lo<Map<Object, Object>>
        implements js {
    protected final sh a;
    protected final jl b;
    protected final jg<Object> c;
    protected final jy d;
    protected final kx e;
    protected final boolean f;
    protected ld g;
    protected jg<Object> h;
    protected HashSet<String> i;

    public lw(sh paramsh, kx paramkx, jl paramjl, jg<Object> paramjg, jy paramjy) {
        super(Map.class);
        this.a = paramsh;
        this.b = paramjl;
        this.c = paramjg;
        this.d = paramjy;
        this.e = paramkx;
        if (paramkx.j()) {
        }
        for (this.g = new ld(paramkx); ; this.g = null) {
            this.f = paramkx.h();
            return;
        }
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return paramjy.a(paramhj, paramiz);
    }

    public Map<Object, Object> a(hj paramhj, iz paramiz, Map<Object, Object> paramMap)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if ((localhm != hm.b) && (localhm != hm.f)) {
            throw paramiz.b(e());
        }
        b(paramhj, paramiz, paramMap);
        return paramMap;
    }

    public void a(iy paramiy, jc paramjc)
            throws jh {
        Object localObject;
        if (this.e.i()) {
            localObject = this.e.l();
            if (localObject == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.a + ": value instantiator (" + this.e.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            this.h = a(paramiy, paramjc, (sh) localObject, new is.a(null, (sh) localObject, null, this.e.o()));
        }
        if (this.g != null) {
            localObject = this.g.a().iterator();
            while (((Iterator) localObject).hasNext()) {
                kt localkt = (kt) ((Iterator) localObject).next();
                if (!localkt.f()) {
                    this.g.a(localkt, a(paramiy, paramjc, localkt.a(), localkt));
                }
            }
        }
    }

    protected void a(Throwable paramThrowable, Object paramObject)
            throws IOException {
        while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
            paramThrowable = paramThrowable.getCause();
        }
        if ((paramThrowable instanceof Error)) {
            throw ((Error) paramThrowable);
        }
        if (((paramThrowable instanceof IOException)) && (!(paramThrowable instanceof jh))) {
            throw ((IOException) paramThrowable);
        }
        throw jh.a(paramThrowable, paramObject, null);
    }

    public void a(String[] paramArrayOfString) {
        if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
        }
        for (paramArrayOfString = null; ; paramArrayOfString = qw.a(paramArrayOfString)) {
            this.i = paramArrayOfString;
            return;
        }
    }

    public Map<Object, Object> b(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (this.g != null) {
            return c(paramhj, paramiz);
        }
        if (this.h != null) {
            return (Map) this.e.a(this.h.a(paramhj, paramiz));
        }
        if (!this.f) {
            throw paramiz.a(e(), "No default constructor found");
        }
        Object localObject = paramhj.e();
        if ((localObject != hm.b) && (localObject != hm.f) && (localObject != hm.c)) {
            if (localObject == hm.h) {
                return (Map) this.e.a(paramhj.k());
            }
            throw paramiz.b(e());
        }
        localObject = (Map) this.e.m();
        b(paramhj, paramiz, (Map) localObject);
        return (Map<Object, Object>) localObject;
    }

    protected final void b(hj paramhj, iz paramiz, Map<Object, Object> paramMap)
            throws IOException, hk {
        Object localObject2 = paramhj.e();
        Object localObject1 = localObject2;
        if (localObject2 == hm.b) {
            localObject1 = paramhj.b();
        }
        localObject2 = this.b;
        jg localjg = this.c;
        jy localjy = this.d;
        while (localObject1 == hm.f) {
            localObject1 = paramhj.g();
            Object localObject3 = ((jl) localObject2).a((String) localObject1, paramiz);
            hm localhm = paramhj.b();
            if ((this.i != null) && (this.i.contains(localObject1))) {
                paramhj.d();
                localObject1 = paramhj.b();
            } else {
                if (localhm == hm.m) {
                    localObject1 = null;
                }
                for (; ; ) {
                    paramMap.put(localObject3, localObject1);
                    break;
                    if (localjy == null) {
                        localObject1 = localjg.a(paramhj, paramiz);
                    } else {
                        localObject1 = localjg.a(paramhj, paramiz, localjy);
                    }
                }
            }
        }
    }

    public Map<Object, Object> c(hj paramhj, iz paramiz)
            throws IOException, hk {
        ld localld = this.g;
        lf locallf = localld.a(paramhj, paramiz);
        Object localObject2 = paramhj.e();
        Object localObject1 = localObject2;
        if (localObject2 == hm.b) {
            localObject1 = paramhj.b();
        }
        localObject2 = this.c;
        jy localjy = this.d;
        if (localObject1 == hm.f) {
            Object localObject3 = paramhj.g();
            localObject1 = paramhj.b();
            if ((this.i != null) && (this.i.contains(localObject3))) {
                paramhj.d();
            }
            do {
                localObject1 = paramhj.b();
                break;
                localObject3 = localld.a((String) localObject3);
                if (localObject3 == null) {
                    break label175;
                }
                localObject1 = ((kt) localObject3).a(paramhj, paramiz);
            } while (!locallf.a(((kt) localObject3).j(), localObject1));
            paramhj.b();
            try {
                localObject1 = (Map) localld.a(locallf);
                b(paramhj, paramiz, (Map) localObject1);
                return (Map<Object, Object>) localObject1;
            } catch (Exception paramhj) {
                a(paramhj, this.a.p());
                return null;
            }
            label175:
            localObject3 = paramhj.g();
            localObject3 = this.b.a((String) localObject3, paramiz);
            if (localObject1 == hm.m) {
                localObject1 = null;
            }
            for (; ; ) {
                locallf.a(localObject3, localObject1);
                break;
                if (localjy == null) {
                    localObject1 = ((jg) localObject2).a(paramhj, paramiz);
                } else {
                    localObject1 = ((jg) localObject2).a(paramhj, paramiz, localjy);
                }
            }
        }
        try {
            paramhj = (Map) localld.a(locallf);
            return paramhj;
        } catch (Exception paramhj) {
            a(paramhj, this.a.p());
        }
        return null;
    }

    public jg<Object> d() {
        return this.c;
    }

    public final Class<?> e() {
        return this.a.p();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */