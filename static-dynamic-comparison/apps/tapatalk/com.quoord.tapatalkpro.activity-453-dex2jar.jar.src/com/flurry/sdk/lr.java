package com.flurry.sdk;

import java.io.IOException;
import java.util.EnumMap;

public class lr
        extends lz<EnumMap<?, ?>> {
    protected final Class<?> a;
    protected final jg<Enum<?>> b;
    protected final jg<Object> c;

    public lr(Class<?> paramClass, jg<?> paramjg, jg<Object> paramjg1) {
        super(EnumMap.class);
        this.a = paramClass;
        this.b = paramjg;
        this.c = paramjg1;
    }

    private EnumMap<?, ?> d() {
        return new EnumMap(this.a);
    }

    public Object a(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return paramjy.a(paramhj, paramiz);
    }

    public EnumMap<?, ?> b(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (paramhj.e() != hm.b) {
            throw paramiz.b(EnumMap.class);
        }
        EnumMap localEnumMap = d();
        if (paramhj.b() != hm.c) {
            Enum localEnum = (Enum) this.b.a(paramhj, paramiz);
            if (localEnum == null) {
                throw paramiz.b(this.a, "value not one of declared Enum instance names");
            }
            if (paramhj.b() == hm.m) {
            }
            for (Object localObject = null; ; localObject = this.c.a(paramhj, paramiz)) {
                localEnumMap.put(localEnum, localObject);
                break;
            }
        }
        return localEnumMap;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */