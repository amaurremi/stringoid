package com.flurry.sdk;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;

public abstract class mm {
    public sh a(qr paramqr) {
        return paramqr.a(c());
    }

    public abstract <A extends Annotation> A a(Class<A> paramClass);

    public abstract AnnotatedElement a();

    public abstract String b();

    public final <A extends Annotation> boolean b(Class<A> paramClass) {
        return a(paramClass) != null;
    }

    public abstract Type c();

    public abstract Class<?> d();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */