package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.Method;

public final class ks {
    protected final is a;
    protected final Method b;
    protected final sh c;
    protected jg<Object> d;

    public ks(is paramis, mr parammr, sh paramsh, jg<Object> paramjg) {
        this(paramis, parammr.e(), paramsh, paramjg);
    }

    public ks(is paramis, Method paramMethod, sh paramsh, jg<Object> paramjg) {
        this.a = paramis;
        this.c = paramsh;
        this.b = paramMethod;
        this.d = paramjg;
    }

    private String d() {
        return this.b.getDeclaringClass().getName();
    }

    public is a() {
        return this.a;
    }

    public ks a(jg<Object> paramjg) {
        return new ks(this.a, this.b, this.c, paramjg);
    }

    public final Object a(hj paramhj, iz paramiz)
            throws IOException, hk {
        if (paramhj.e() == hm.m) {
            return null;
        }
        return this.d.a(paramhj, paramiz);
    }

    public final void a(hj paramhj, iz paramiz, Object paramObject, String paramString)
            throws IOException, hk {
        a(paramObject, paramString, a(paramhj, paramiz));
    }

    protected void a(Exception paramException, String paramString, Object paramObject)
            throws IOException {
        if ((paramException instanceof IllegalArgumentException)) {
            if (paramObject == null) {
                paramObject = "[NULL]";
                paramString = new StringBuilder("Problem deserializing \"any\" property '").append(paramString);
                paramString.append("' of class " + d() + " (expected type: ").append(this.c);
                paramString.append("; actual type: ").append((String) paramObject).append(")");
                paramObject = paramException.getMessage();
                if (paramObject == null) {
                    break label128;
                }
                paramString.append(", problem: ").append((String) paramObject);
            }
            for (; ; ) {
                throw new jh(paramString.toString(), null, paramException);
                paramObject = paramObject.getClass().getName();
                break;
                label128:
                paramString.append(" (no error message provided)");
            }
        }
        if ((paramException instanceof IOException)) {
            throw ((IOException) paramException);
        }
        paramString = paramException;
        if ((paramException instanceof RuntimeException)) {
            throw ((RuntimeException) paramException);
        }
        while (paramString.getCause() != null) {
            paramString = paramString.getCause();
        }
        throw new jh(paramString.getMessage(), null, paramString);
    }

    public final void a(Object paramObject1, String paramString, Object paramObject2)
            throws IOException {
        try {
            this.b.invoke(paramObject1, new Object[]{paramString, paramObject2});
            return;
        } catch (Exception paramObject1) {
            a((Exception) paramObject1, paramString, paramObject2);
        }
    }

    public boolean b() {
        return this.d != null;
    }

    public sh c() {
        return this.c;
    }

    public String toString() {
        return "[any property on class " + d() + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */