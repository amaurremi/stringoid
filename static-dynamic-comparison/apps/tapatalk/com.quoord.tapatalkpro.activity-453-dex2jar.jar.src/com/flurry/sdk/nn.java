package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;

import java.io.IOException;

public class nn
        extends nj {
    protected final String a;

    public nn(sh paramsh, nh paramnh, is paramis, Class<?> paramClass, String paramString) {
        super(paramsh, paramnh, paramis, paramClass);
        this.a = paramString;
    }

    public JsonTypeInfo.As a() {
        return JsonTypeInfo.As.PROPERTY;
    }

    public Object a(hj paramhj, iz paramiz)
            throws IOException, hk {
        Object localObject2 = paramhj.e();
        Object localObject1;
        Object localObject3;
        if (localObject2 == hm.b) {
            localObject1 = paramhj.b();
            localObject3 = null;
            localObject2 = localObject1;
            localObject1 = localObject3;
        }
        for (; ; ) {
            if (localObject2 != hm.f) {
                break label184;
            }
            localObject3 = paramhj.g();
            paramhj.b();
            if (this.a.equals(localObject3)) {
                localObject3 = a(paramiz, paramhj.k());
                localObject2 = paramhj;
                if (localObject1 != null) {
                    localObject2 = so.a(((sq) localObject1).a(paramhj), paramhj);
                }
                ((hj) localObject2).b();
                return ((jg) localObject3).a((hj) localObject2, paramiz);
                if (localObject2 == hm.d) {
                    return a(paramhj, paramiz, null);
                }
                localObject1 = localObject2;
                if (localObject2 == hm.f) {
                    break;
                }
                return a(paramhj, paramiz, null);
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = new sq(null);
            }
            ((sq) localObject2).a((String) localObject3);
            ((sq) localObject2).c(paramhj);
            localObject3 = paramhj.b();
            localObject1 = localObject2;
            localObject2 = localObject3;
        }
        label184:
        return a(paramhj, paramiz, (sq) localObject1);
    }

    protected Object a(hj paramhj, iz paramiz, sq paramsq)
            throws IOException, hk {
        Object localObject;
        if (this.e != null) {
            jg localjg = a(paramiz);
            localObject = paramhj;
            if (paramsq != null) {
                paramsq.e();
                localObject = paramsq.a(paramhj);
                ((hj) localObject).b();
            }
            paramsq = localjg.a((hj) localObject, paramiz);
        }
        do {
            return paramsq;
            localObject = f(paramhj, paramiz);
            paramsq = (sq) localObject;
        } while (localObject != null);
        if (paramhj.e() == hm.d) {
            return super.d(paramhj, paramiz);
        }
        throw paramiz.a(paramhj, hm.f, "missing property '" + this.a + "' that is to contain type id  (for class " + c() + ")");
    }

    public String b() {
        return this.a;
    }

    public Object d(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (paramhj.e() == hm.d) {
            return super.b(paramhj, paramiz);
        }
        return a(paramhj, paramiz);
    }

    protected Object f(hj paramhj, iz paramiz)
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
                        } while (!this.c.p().isAssignableFrom(String.class));
                        return paramhj.k();
                    } while (!this.c.p().isAssignableFrom(Integer.class));
                    return Integer.valueOf(paramhj.t());
                } while (!this.c.p().isAssignableFrom(Double.class));
                return Double.valueOf(paramhj.x());
            } while (!this.c.p().isAssignableFrom(Boolean.class));
            return Boolean.TRUE;
        } while (!this.c.p().isAssignableFrom(Boolean.class));
        return Boolean.FALSE;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */