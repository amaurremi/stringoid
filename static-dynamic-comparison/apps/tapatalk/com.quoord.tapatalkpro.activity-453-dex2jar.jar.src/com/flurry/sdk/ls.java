package com.flurry.sdk;

import java.io.IOException;
import java.util.EnumSet;

public class ls
        extends lz<EnumSet<?>> {
    protected final Class<Enum> a;
    protected final jg<Enum<?>> b;

    public ls(Class<?> paramClass, jg<?> paramjg) {
        super(EnumSet.class);
        this.a = paramClass;
        this.b = paramjg;
    }

    private EnumSet d() {
        return EnumSet.noneOf(this.a);
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return paramjy.b(paramhj, paramiz);
    }

    public EnumSet<?> b(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (!paramhj.j()) {
            throw paramiz.b(EnumSet.class);
        }
        EnumSet localEnumSet = d();
        for (; ; ) {
            hm localhm = paramhj.b();
            if (localhm == hm.e) {
                break;
            }
            if (localhm == hm.m) {
                throw paramiz.b(this.a);
            }
            localEnumSet.add((Enum) this.b.a(paramhj, paramiz));
        }
        return localEnumSet;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */