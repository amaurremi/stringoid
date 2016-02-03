package com.flurry.sdk;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class mt
        extends mq {
    protected final mu a;
    protected final Type c;
    protected final int d;

    public mt(mu parammu, Type paramType, mv parammv, int paramInt) {
        super(parammv);
        this.a = parammu;
        this.c = paramType;
        this.d = paramInt;
    }

    public mt a(mv parammv) {
        if (parammv == this.b) {
            return this;
        }
        return this.a.a(this.d, parammv);
    }

    public <A extends Annotation> A a(Class<A> paramClass) {
        return this.b.a(paramClass);
    }

    public AnnotatedElement a() {
        return null;
    }

    public void a(Object paramObject1, Object paramObject2)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + h().getName());
    }

    public String b() {
        return "";
    }

    public Type c() {
        return this.c;
    }

    public Class<?> d() {
        if ((this.c instanceof Class)) {
            return (Class) this.c;
        }
        return qs.a().a(this.c).p();
    }

    public Type e() {
        return this.c;
    }

    public mu f() {
        return this.a;
    }

    public int g() {
        return this.d;
    }

    public Class<?> h() {
        return this.a.h();
    }

    public Member i() {
        return this.a.i();
    }

    public String toString() {
        return "[parameter #" + g() + ", annotations: " + this.b + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */