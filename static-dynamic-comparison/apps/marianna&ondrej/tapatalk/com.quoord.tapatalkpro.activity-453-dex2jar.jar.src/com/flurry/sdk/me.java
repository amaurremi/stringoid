package com.flurry.sdk;

import java.io.IOException;
import java.util.Collection;

@kb
public final class me
        extends lo<Collection<String>>
        implements js {
    protected final sh a;
    protected final jg<String> b;
    protected final boolean c;
    protected final kx d;
    protected jg<Object> e;

    public me(sh paramsh, jg<?> paramjg, kx paramkx) {
        super(paramsh.p());
        this.a = paramsh;
        this.b = paramjg;
        this.d = paramkx;
        this.c = a(paramjg);
    }

    private Collection<String> b(hj paramhj, iz paramiz, Collection<String> paramCollection)
            throws IOException, hk {
        jg localjg = this.b;
        Object localObject = paramhj.b();
        if (localObject != hm.e) {
            if (localObject == hm.m) {
            }
            for (localObject = null; ; localObject = (String) localjg.a(paramhj, paramiz)) {
                paramCollection.add(localObject);
                break;
            }
        }
        return paramCollection;
    }

    private final Collection<String> c(hj paramhj, iz paramiz, Collection<String> paramCollection)
            throws IOException, hk {
        if (!paramiz.a(iy.a.o)) {
            throw paramiz.b(this.a.p());
        }
        jg localjg = this.b;
        if (paramhj.e() == hm.m) {
            paramhj = null;
        }
        for (; ; ) {
            paramCollection.add(paramhj);
            return paramCollection;
            if (localjg == null) {
                paramhj = paramhj.k();
            } else {
                paramhj = (String) localjg.a(paramhj, paramiz);
            }
        }
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return paramjy.b(paramhj, paramiz);
    }

    public Collection<String> a(hj paramhj, iz paramiz, Collection<String> paramCollection)
            throws IOException, hk {
        if (!paramhj.j()) {
            paramiz = c(paramhj, paramiz, paramCollection);
        }
        hm localhm;
        do {
            return paramiz;
            if (!this.c) {
                return b(paramhj, paramiz, paramCollection);
            }
            localhm = paramhj.b();
            paramiz = paramCollection;
        } while (localhm == hm.e);
        if (localhm == hm.m) {
        }
        for (paramiz = null; ; paramiz = paramhj.k()) {
            paramCollection.add(paramiz);
            break;
        }
    }

    public void a(iy paramiy, jc paramjc)
            throws jh {
        mu localmu = this.d.o();
        if (localmu != null) {
            sh localsh = this.d.l();
            this.e = a(paramiy, paramjc, localsh, new is.a(null, localsh, null, localmu));
        }
    }

    public Collection<String> b(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (this.e != null) {
            return (Collection) this.d.a(this.e.a(paramhj, paramiz));
        }
        return a(paramhj, paramiz, (Collection) this.d.m());
    }

    public jg<Object> d() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/me.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */