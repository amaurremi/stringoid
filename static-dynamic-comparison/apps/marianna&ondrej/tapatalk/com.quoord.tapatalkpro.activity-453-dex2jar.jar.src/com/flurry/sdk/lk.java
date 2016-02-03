package com.flurry.sdk;

import java.io.IOException;

abstract class lk<N extends hh>
        extends lz<N> {
    public lk(Class<N> paramClass) {
        super(paramClass);
    }

    protected final rw a(hj paramhj, iz paramiz, rs paramrs)
            throws IOException, hk {
        rw localrw = paramrs.c();
        Object localObject2 = paramhj.e();
        Object localObject1 = localObject2;
        if (localObject2 == hm.b) {
            localObject1 = paramhj.b();
        }
        if (localObject1 == hm.f) {
            localObject2 = paramhj.g();
            switch (1. a[paramhj.b().ordinal()])
            {
                default:
                    localObject1 = c(paramhj, paramiz, paramrs);
            }
            for (; ; ) {
                hh localhh = localrw.a((String) localObject2, (hh) localObject1);
                if (localhh != null) {
                    a((String) localObject2, localrw, localhh, (hh) localObject1);
                }
                localObject1 = paramhj.b();
                break;
                localObject1 = a(paramhj, paramiz, paramrs);
                continue;
                localObject1 = b(paramhj, paramiz, paramrs);
                continue;
                localObject1 = paramrs.a(paramhj.k());
            }
        }
        return localrw;
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return paramjy.d(paramhj, paramiz);
    }

    protected void a(String paramString, rw paramrw, hh paramhh1, hh paramhh2)
            throws hk {
    }

    protected final rj b(hj paramhj, iz paramiz, rs paramrs)
            throws IOException, hk {
        rj localrj = paramrs.b();
        for (; ; ) {
            switch (1. a[paramhj.b().ordinal()])
            {
                default:
                    localrj.a(c(paramhj, paramiz, paramrs));
                    break;
                case 1:
                    localrj.a(a(paramhj, paramiz, paramrs));
                    break;
                case 2:
                    localrj.a(b(paramhj, paramiz, paramrs));
                    break;
                case 3:
                    localrj.a(paramrs.a(paramhj.k()));
            }
        }
        return localrj;
    }

    protected final hh c(hj paramhj, iz paramiz, rs paramrs)
            throws IOException, hk {
        switch (1. a[paramhj.e().ordinal()])
        {
            case 4:
            default:
                throw paramiz.b(f());
            case 1:
                return a(paramhj, paramiz, paramrs);
            case 2:
                return b(paramhj, paramiz, paramrs);
            case 5:
                return a(paramhj, paramiz, paramrs);
            case 6:
                paramhj = paramhj.z();
                if (paramhj == null) {
                    return paramrs.a();
                }
                if (paramhj.getClass() == byte[].class) {
                    return paramrs.a((byte[]) paramhj);
                }
                return paramrs.a(paramhj);
            case 3:
                return paramrs.a(paramhj.k());
            case 7:
                hj.b localb = paramhj.q();
                if ((localb == hj.b.c) || (paramiz.a(iy.a.h))) {
                    return paramrs.a(paramhj.v());
                }
                if (localb == hj.b.a) {
                    return paramrs.a(paramhj.t());
                }
                return paramrs.a(paramhj.u());
            case 8:
                if ((paramhj.q() == hj.b.f) || (paramiz.a(iy.a.g))) {
                    return paramrs.a(paramhj.y());
                }
                return paramrs.a(paramhj.x());
            case 9:
                return paramrs.a(true);
            case 10:
                return paramrs.a(false);
        }
        return paramrs.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */