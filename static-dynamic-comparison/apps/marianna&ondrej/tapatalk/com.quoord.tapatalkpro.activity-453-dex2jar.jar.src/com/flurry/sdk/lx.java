package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.Array;

@kb
public class lx
        extends lo<Object[]> {
    protected final sh a;
    protected final boolean b;
    protected final Class<?> c;
    protected final jg<Object> d;
    protected final jy e;

    public lx(qi paramqi, jg<Object> paramjg, jy paramjy) {
        super(Object[].class);
        this.a = paramqi;
        this.c = paramqi.g().p();
        if (this.c == Object.class) {
        }
        for (boolean bool = true; ; bool = false) {
            this.b = bool;
            this.d = paramjg;
            this.e = paramjy;
            return;
        }
    }

    private final Object[] d(hj paramhj, iz paramiz)
            throws IOException, hk {
        if ((paramhj.e() == hm.h) && (paramiz.a(iy.a.q)) && (paramhj.k().length() == 0)) {
            return null;
        }
        if (!paramiz.a(iy.a.o)) {
            if ((paramhj.e() == hm.h) && (this.c == Byte.class)) {
                return c(paramhj, paramiz);
            }
            throw paramiz.b(this.a.p());
        }
        if (paramhj.e() == hm.m) {
            paramhj = null;
            if (!this.b) {
                break label147;
            }
        }
        label147:
        for (paramiz = new Object[1]; ; paramiz = (Object[]) Array.newInstance(this.c, 1)) {
            paramiz[0] = paramhj;
            return paramiz;
            if (this.e == null) {
                paramhj = this.d.a(paramhj, paramiz);
                break;
            }
            paramhj = this.d.a(paramhj, paramiz, this.e);
            break;
        }
    }

    public Object[] b(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (!paramhj.j()) {
            return d(paramhj, paramiz);
        }
        re localre = paramiz.g();
        Object[] arrayOfObject = localre.a();
        jy localjy = this.e;
        int i = 0;
        Object localObject = paramhj.b();
        if (localObject != hm.e) {
            if (localObject == hm.m) {
                localObject = null;
                label60:
                if (i < arrayOfObject.length) {
                    break label170;
                }
                arrayOfObject = localre.a(arrayOfObject);
                i = 0;
            }
        }
        label170:
        for (; ; ) {
            int j = i + 1;
            arrayOfObject[i] = localObject;
            i = j;
            break;
            if (localjy == null) {
                localObject = this.d.a(paramhj, paramiz);
                break label60;
            }
            localObject = this.d.a(paramhj, paramiz, localjy);
            break label60;
            if (this.b) {
            }
            for (paramhj = localre.a(arrayOfObject, i); ; paramhj = localre.a(arrayOfObject, i, this.c)) {
                paramiz.a(localre);
                return paramhj;
            }
        }
    }

    public Object[] b(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return (Object[]) paramjy.b(paramhj, paramiz);
    }

    protected Byte[] c(hj paramhj, iz paramiz)
            throws IOException, hk {
        paramhj = paramhj.a(paramiz.c());
        paramiz = new Byte[paramhj.length];
        int i = 0;
        int j = paramhj.length;
        while (i < j) {
            paramiz[i] = Byte.valueOf(paramhj[i]);
            i += 1;
        }
        return paramiz;
    }

    public jg<Object> d() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */