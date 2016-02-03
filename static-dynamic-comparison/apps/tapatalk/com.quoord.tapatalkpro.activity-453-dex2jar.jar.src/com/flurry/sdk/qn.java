package com.flurry.sdk;

import java.util.Map;

public class qn
        extends qq {
    protected final sh a;
    protected final sh b;

    protected qn(Class<?> paramClass, sh paramsh1, sh paramsh2, Object paramObject1, Object paramObject2) {
        super(paramClass, paramsh1.hashCode() ^ paramsh2.hashCode(), paramObject1, paramObject2);
        this.a = paramsh1;
        this.b = paramsh2;
    }

    public qn a(Object paramObject) {
        return new qn(this.d, this.a, this.b, this.f, paramObject);
    }

    protected sh a(Class<?> paramClass) {
        return new qn(paramClass, this.a, this.b, this.f, this.g);
    }

    protected String a() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.d.getName());
        if (this.a != null) {
            localStringBuilder.append('<');
            localStringBuilder.append(this.a.m());
            localStringBuilder.append(',');
            localStringBuilder.append(this.b.m());
            localStringBuilder.append('>');
        }
        return localStringBuilder.toString();
    }

    public String a(int paramInt) {
        if (paramInt == 0) {
            return "K";
        }
        if (paramInt == 1) {
            return "V";
        }
        return null;
    }

    public qn b(Object paramObject) {
        return new qn(this.d, this.a, this.b.f(paramObject), this.f, this.g);
    }

    public sh b(int paramInt) {
        if (paramInt == 0) {
            return this.a;
        }
        if (paramInt == 1) {
            return this.b;
        }
        return null;
    }

    public sh b(Class<?> paramClass) {
        if (paramClass == this.b.p()) {
            return this;
        }
        return new qn(this.d, this.a, this.b.f(paramClass), this.f, this.g);
    }

    public qn c(Object paramObject) {
        return new qn(this.d, this.a, this.b, paramObject, this.g);
    }

    public sh c(Class<?> paramClass) {
        if (paramClass == this.b.p()) {
            return this;
        }
        return new qn(this.d, this.a, this.b.h(paramClass), this.f, this.g);
    }

    public sh d(Class<?> paramClass) {
        if (paramClass == this.a.p()) {
            return this;
        }
        return new qn(this.d, this.a.f(paramClass), this.b, this.f, this.g);
    }

    public sh e(Class<?> paramClass) {
        if (paramClass == this.a.p()) {
            return this;
        }
        return new qn(this.d, this.a.h(paramClass), this.b, this.f, this.g);
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
            paramObject = (qn) paramObject;
        }
        while ((this.d == ((qn) paramObject).d) && (this.a.equals(((qn) paramObject).a)) && (this.b.equals(((qn) paramObject).b)));
        return false;
    }

    public boolean f() {
        return true;
    }

    public sh g() {
        return this.b;
    }

    public int h() {
        return 2;
    }

    public boolean j() {
        return true;
    }

    public sh k() {
        return this.a;
    }

    public boolean l() {
        return Map.class.isAssignableFrom(this.d);
    }

    public String toString() {
        return "[map-like type; class " + this.d.getName() + ", " + this.a + " -> " + this.b + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */