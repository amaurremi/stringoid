package com.flurry.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class oc
        extends jp {
    protected final String a;
    protected final hq b;
    protected od c = null;
    protected oa d = null;
    protected od e = null;
    protected ob f = null;
    protected nz g = null;
    protected oe h = null;
    protected HashMap<Class<?>, Class<?>> i = null;

    public oc(String paramString, hq paramhq) {
        this.a = paramString;
        this.b = paramhq;
    }

    public oc a(Class<?> paramClass, jl paramjl) {
        if (this.f == null) {
            this.f = new ob();
        }
        this.f.a(paramClass, paramjl);
        return this;
    }

    public String a() {
        return this.a;
    }

    public void a(jp.a parama) {
        if (this.c != null) {
            parama.a(this.c);
        }
        if (this.d != null) {
            parama.a(this.d);
        }
        if (this.e != null) {
            parama.b(this.e);
        }
        if (this.f != null) {
            parama.a(this.f);
        }
        if (this.g != null) {
            parama.a(this.g);
        }
        if (this.h != null) {
            parama.a(this.h);
        }
        if (this.i != null) {
            Iterator localIterator = this.i.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                parama.a((Class) localEntry.getKey(), (Class) localEntry.getValue());
            }
        }
    }

    public hq b() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/oc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */