package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;

import java.io.IOException;

public class nj
        extends nv {
    public nj(sh paramsh, nh paramnh, is paramis, Class<?> paramClass) {
        super(paramsh, paramnh, paramis, paramClass);
    }

    private final Object f(hj paramhj, iz paramiz)
            throws IOException, hk {
        boolean bool = paramhj.j();
        Object localObject = a(paramiz, e(paramhj, paramiz)).a(paramhj, paramiz);
        if ((bool) && (paramhj.b() != hm.e)) {
            throw paramiz.a(paramhj, hm.e, "expected closing END_ARRAY after type information and deserialized value");
        }
        return localObject;
    }

    public JsonTypeInfo.As a() {
        return JsonTypeInfo.As.WRAPPER_ARRAY;
    }

    public Object a(hj paramhj, iz paramiz)
            throws IOException, hk {
        return f(paramhj, paramiz);
    }

    public Object b(hj paramhj, iz paramiz)
            throws IOException, hk {
        return f(paramhj, paramiz);
    }

    public Object c(hj paramhj, iz paramiz)
            throws IOException, hk {
        return f(paramhj, paramiz);
    }

    public Object d(hj paramhj, iz paramiz)
            throws IOException, hk {
        return f(paramhj, paramiz);
    }

    protected final String e(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (!paramhj.j()) {
            if (((this.b instanceof nw)) && (this.e != null)) {
                return ((nw) this.b).a();
            }
            throw paramiz.a(paramhj, hm.d, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + c());
        }
        if (paramhj.b() != hm.h) {
            if (((this.b instanceof nw)) && (this.e != null)) {
                return ((nw) this.b).a();
            }
            throw paramiz.a(paramhj, hm.h, "need JSON String that contains type id (for subtype of " + c() + ")");
        }
        paramiz = paramhj.k();
        paramhj.b();
        return paramiz;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */