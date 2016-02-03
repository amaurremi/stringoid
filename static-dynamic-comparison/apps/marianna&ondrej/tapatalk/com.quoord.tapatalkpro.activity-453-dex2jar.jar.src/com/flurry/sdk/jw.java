package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public abstract class jw {
    protected static final sh a = qs.a().a(Object.class);
    protected final ju b;
    protected final Class<?> c;

    protected jw(ju paramju) {
        this.b = paramju;
        if (paramju == null) {
        }
        for (paramju = null; ; paramju = this.b.f()) {
            this.c = paramju;
            return;
        }
    }

    public abstract jk<Object> a(sh paramsh, is paramis)
            throws jh;

    public abstract jk<Object> a(sh paramsh, boolean paramBoolean, is paramis)
            throws jh;

    public abstract jk<Object> a(Class<?> paramClass, is paramis)
            throws jh;

    public abstract jk<Object> a(Class<?> paramClass, boolean paramBoolean, is paramis)
            throws jh;

    public sh a(sh paramsh, Class<?> paramClass) {
        return this.b.a(paramsh, paramClass);
    }

    public sh a(Type paramType) {
        return this.b.m().a(paramType);
    }

    public final Class<?> a() {
        return this.c;
    }

    public abstract void a(long paramLong, hf paramhf)
            throws IOException, hk;

    public final void a(hf paramhf)
            throws IOException, hk {
        d().a(null, paramhf, this);
    }

    public abstract void a(ju paramju, hf paramhf, Object paramObject, jv paramjv)
            throws IOException, he;

    public final void a(Object paramObject, hf paramhf)
            throws IOException, hk {
        if (paramObject == null) {
            d().a(null, paramhf, this);
            return;
        }
        a(paramObject.getClass(), true, null).a(paramObject, paramhf, this);
    }

    public abstract void a(Date paramDate, hf paramhf)
            throws IOException, hk;

    public final boolean a(ju.a parama) {
        return this.b.a(parama);
    }

    public abstract jk<Object> b(sh paramsh, is paramis)
            throws jh;

    public final on b() {
        return this.b.h();
    }

    public abstract void b(long paramLong, hf paramhf)
            throws IOException, hk;

    public abstract void b(Date paramDate, hf paramhf)
            throws IOException, hk;

    public abstract jk<Object> c();

    public abstract jk<Object> d();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/jw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */