package com.flurry.sdk;

import java.io.IOException;
import java.util.Collection;

@kb
public class ln
        extends lo<Collection<Object>>
        implements js {
    protected final sh a;
    protected final jg<Object> b;
    protected final jy c;
    protected final kx d;
    protected jg<Object> e;

    public ln(sh paramsh, jg<Object> paramjg, jy paramjy, kx paramkx) {
        super(paramsh.p());
        this.a = paramsh;
        this.b = paramjg;
        this.c = paramjy;
        this.d = paramkx;
    }

    private final Collection<Object> b(hj paramhj, iz paramiz, Collection<Object> paramCollection)
            throws IOException, hk {
        if (!paramiz.a(iy.a.o)) {
            throw paramiz.b(this.a.p());
        }
        jg localjg = this.b;
        jy localjy = this.c;
        if (paramhj.e() == hm.m) {
            paramhj = null;
        }
        for (; ; ) {
            paramCollection.add(paramhj);
            return paramCollection;
            if (localjy == null) {
                paramhj = localjg.a(paramhj, paramiz);
            } else {
                paramhj = localjg.a(paramhj, paramiz, localjy);
            }
        }
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return paramjy.b(paramhj, paramiz);
    }

    public Collection<Object> a(hj paramhj, iz paramiz, Collection<Object> paramCollection)
            throws IOException, hk {
        Object localObject;
        if (!paramhj.j()) {
            localObject = b(paramhj, paramiz, paramCollection);
        }
        jg localjg;
        jy localjy;
        hm localhm;
        do {
            return (Collection<Object>) localObject;
            localjg = this.b;
            localjy = this.c;
            localhm = paramhj.b();
            localObject = paramCollection;
        } while (localhm == hm.e);
        if (localhm == hm.m) {
            localObject = null;
        }
        for (; ; ) {
            paramCollection.add(localObject);
            break;
            if (localjy == null) {
                localObject = localjg.a(paramhj, paramiz);
            } else {
                localObject = localjg.a(paramhj, paramiz, localjy);
            }
        }
    }

    public void a(iy paramiy, jc paramjc)
            throws jh {
        if (this.d.i()) {
            sh localsh = this.d.l();
            if (localsh == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.a + ": value instantiator (" + this.d.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            this.e = a(paramiy, paramjc, localsh, new is.a(null, localsh, null, this.d.o()));
        }
    }

    public Collection<Object> b(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (this.e != null) {
            return (Collection) this.d.a(this.e.a(paramhj, paramiz));
        }
        if (paramhj.e() == hm.h) {
            String str = paramhj.k();
            if (str.length() == 0) {
                return (Collection) this.d.a(str);
            }
        }
        return a(paramhj, paramiz, (Collection) this.d.m());
    }

    public jg<Object> d() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */