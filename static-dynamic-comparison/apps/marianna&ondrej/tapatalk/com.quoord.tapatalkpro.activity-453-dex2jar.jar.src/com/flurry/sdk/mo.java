package com.flurry.sdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class mo
        extends mu {
    protected final Constructor<?> a;

    public mo(Constructor<?> paramConstructor, mv parammv, mv[] paramArrayOfmv) {
        super(parammv, paramArrayOfmv);
        if (paramConstructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this.a = paramConstructor;
    }

    public sh a(qr paramqr) {
        return a(paramqr, this.a.getTypeParameters());
    }

    public Class<?> a(int paramInt) {
        Class[] arrayOfClass = this.a.getParameterTypes();
        if (paramInt >= arrayOfClass.length) {
            return null;
        }
        return arrayOfClass[paramInt];
    }

    public final Object a(Object paramObject)
            throws Exception {
        return this.a.newInstance(new Object[]{paramObject});
    }

    public final Object a(Object[] paramArrayOfObject)
            throws Exception {
        return this.a.newInstance(paramArrayOfObject);
    }

    public void a(Object paramObject1, Object paramObject2)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + h().getName());
    }

    public String b() {
        return this.a.getName();
    }

    public Type b(int paramInt) {
        Type[] arrayOfType = this.a.getGenericParameterTypes();
        if (paramInt >= arrayOfType.length) {
            return null;
        }
        return arrayOfType[paramInt];
    }

    public Type c() {
        return d();
    }

    public Class<?> d() {
        return this.a.getDeclaringClass();
    }

    public Constructor<?> e() {
        return this.a;
    }

    public int f() {
        return this.a.getParameterTypes().length;
    }

    public final Object g()
            throws Exception {
        return this.a.newInstance(new Object[0]);
    }

    public Class<?> h() {
        return this.a.getDeclaringClass();
    }

    public Member i() {
        return this.a;
    }

    public String toString() {
        return "[constructor for " + b() + ", annotations: " + this.b + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */