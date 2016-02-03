package com.flurry.sdk;

import java.io.IOException;

public class km
        extends jg<Object> {
    protected final sh a;
    protected final boolean b;
    protected final boolean c;
    protected final boolean d;
    protected final boolean e;

    public km(sh paramsh) {
        this.a = paramsh;
        paramsh = paramsh.p();
        this.b = paramsh.isAssignableFrom(String.class);
        if ((paramsh == Boolean.TYPE) || (paramsh.isAssignableFrom(Boolean.class))) {
            bool1 = true;
            this.c = bool1;
            if ((paramsh != Integer.TYPE) && (!paramsh.isAssignableFrom(Integer.class))) {
                break label103;
            }
        }
        label103:
        for (boolean bool1 = true; ; bool1 = false) {
            this.d = bool1;
            if (paramsh != Double.TYPE) {
                bool1 = bool2;
                if (!paramsh.isAssignableFrom(Double.class)) {
                }
            } else {
                bool1 = true;
            }
            this.e = bool1;
            return;
            bool1 = false;
            break;
        }
    }

    public Object a(hj paramhj, iz paramiz)
            throws IOException, hk {
        throw paramiz.a(this.a.p(), "abstract types can only be instantiated with additional type information");
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        Object localObject = b(paramhj, paramiz);
        if (localObject != null) {
            return localObject;
        }
        return paramjy.a(paramhj, paramiz);
    }

    protected Object b(hj paramhj, iz paramiz)
            throws IOException, hk {
        switch (1. a[paramhj.e().ordinal()])
        {
        }
        do {
            do {
                do {
                    do {
                        do {
                            return null;
                        } while (!this.b);
                        return paramhj.k();
                    } while (!this.d);
                    return Integer.valueOf(paramhj.t());
                } while (!this.e);
                return Double.valueOf(paramhj.x());
            } while (!this.c);
            return Boolean.TRUE;
        } while (!this.c);
        return Boolean.FALSE;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/km.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */