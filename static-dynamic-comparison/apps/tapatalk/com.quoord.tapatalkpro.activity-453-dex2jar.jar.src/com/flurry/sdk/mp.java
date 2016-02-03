package com.flurry.sdk;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class mp
        extends mq {
    protected final Field a;

    public mp(Field paramField, mv parammv) {
        super(parammv);
        this.a = paramField;
    }

    public mp a(mv parammv) {
        return new mp(this.a, parammv);
    }

    public <A extends Annotation> A a(Class<A> paramClass) {
        return this.b.a(paramClass);
    }

    public void a(Object paramObject1, Object paramObject2)
            throws IllegalArgumentException {
        try {
            this.a.set(paramObject1, paramObject2);
            return;
        } catch (IllegalAccessException paramObject1) {
            throw new IllegalArgumentException("Failed to setValue() for field " + f() + ": " + ((IllegalAccessException) paramObject1).getMessage(), (Throwable) paramObject1);
        }
    }

    public void a(Annotation paramAnnotation) {
        this.b.b(paramAnnotation);
    }

    public String b() {
        return this.a.getName();
    }

    public Type c() {
        return this.a.getGenericType();
    }

    public Class<?> d() {
        return this.a.getType();
    }

    public Field e() {
        return this.a;
    }

    public String f() {
        return h().getName() + "#" + b();
    }

    public Class<?> h() {
        return this.a.getDeclaringClass();
    }

    public Member i() {
        return this.a;
    }

    public String toString() {
        return "[field " + b() + ", annotations: " + this.b + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */