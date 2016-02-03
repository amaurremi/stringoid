package com.flurry.sdk;

import java.util.Collection;

public class qk
        extends qq {
    protected final sh a;

    protected qk(Class<?> paramClass, sh paramsh, Object paramObject1, Object paramObject2) {
        super(paramClass, paramsh.hashCode(), paramObject1, paramObject2);
        this.a = paramsh;
    }

    public qk a(Object paramObject) {
        return new qk(this.d, this.a, this.f, paramObject);
    }

    protected sh a(Class<?> paramClass) {
        return new qk(paramClass, this.a, this.f, this.g);
    }

    protected String a() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.d.getName());
        if (this.a != null) {
            localStringBuilder.append('<');
            localStringBuilder.append(this.a.m());
            localStringBuilder.append('>');
        }
        return localStringBuilder.toString();
    }

    public String a(int paramInt) {
        if (paramInt == 0) {
            return "E";
        }
        return null;
    }

    public boolean a_() {
        return Collection.class.isAssignableFrom(this.d);
    }

    public qk b(Object paramObject) {
        return new qk(this.d, this.a.f(paramObject), this.f, this.g);
    }

    public sh b(int paramInt) {
        if (paramInt == 0) {
            return this.a;
        }
        return null;
    }

    public sh b(Class<?> paramClass) {
        if (paramClass == this.a.p()) {
            return this;
        }
        return new qk(this.d, this.a.f(paramClass), this.f, this.g);
    }

    public qk c(Object paramObject) {
        return new qk(this.d, this.a, paramObject, this.g);
    }

    public sh c(Class<?> paramClass) {
        if (paramClass == this.a.p()) {
            return this;
        }
        return new qk(this.d, this.a.h(paramClass), this.f, this.g);
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (paramObject == null) {
                return false;
            }
            if (paramObject.getClass() != getClass()) {
                return false;
            }
            paramObject = (qk) paramObject;
        } while ((this.d == ((qk) paramObject).d) && (this.a.equals(((qk) paramObject).a)));
        return false;
    }

    public boolean f() {
        return true;
    }

    public sh g() {
        return this.a;
    }

    public int h() {
        return 1;
    }

    public boolean i() {
        return true;
    }

    public String toString() {
        return "[collection-like type; class " + this.d.getName() + ", contains " + this.a + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */