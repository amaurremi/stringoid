package com.flurry.sdk;

import java.io.IOException;
import java.util.HashMap;

public abstract class nv
        extends jy {
    protected final nh b;
    protected final sh c;
    protected final is d;
    protected final sh e;
    protected final HashMap<String, jg<Object>> f;
    protected jg<Object> g;

    protected nv(sh paramsh, nh paramnh, is paramis, Class<?> paramClass) {
        this.c = paramsh;
        this.b = paramnh;
        this.d = paramis;
        this.f = new HashMap();
        if (paramClass == null) {
            this.e = null;
            return;
        }
        this.e = paramsh.g(paramClass);
    }

    protected final jg<Object> a(iz paramiz)
            throws IOException, hk {
        if (this.e == null) {
            return null;
        }
        synchronized (this.e) {
            if (this.g == null) {
                this.g = paramiz.b().a(paramiz.a(), this.e, this.d);
            }
            paramiz = this.g;
            return paramiz;
        }
    }

    protected final jg<Object> a(iz paramiz, String paramString)
            throws IOException, hk {
        Object localObject2;
        Object localObject1;
        synchronized (this.f) {
            localObject2 = (jg) this.f.get(paramString);
            localObject1 = localObject2;
            if (localObject2 == null) {
                localObject2 = this.b.a(paramString);
                if (localObject2 != null) {
                    break label93;
                }
                if (this.e == null) {
                    throw paramiz.a(this.c, paramString);
                }
            }
        }
        for (paramiz = a(paramiz); ; paramiz = paramiz.b().a(paramiz.a(), (sh) localObject1, this.d)) {
            this.f.put(paramString, paramiz);
            localObject1 = paramiz;
            return (jg<Object>) localObject1;
            label93:
            localObject1 = localObject2;
            if (this.c != null) {
                localObject1 = localObject2;
                if (this.c.getClass() == localObject2.getClass()) {
                    localObject1 = this.c.f(((sh) localObject2).p());
                }
            }
        }
    }

    public String b() {
        return null;
    }

    public String c() {
        return this.c.p().getName();
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append('[').append(getClass().getName());
        localStringBuilder.append("; base-type:").append(this.c);
        localStringBuilder.append("; id-resolver: ").append(this.b);
        localStringBuilder.append(']');
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */