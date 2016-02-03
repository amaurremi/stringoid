package com.flurry.sdk;

public final class qo
        extends qn {
    private qo(Class<?> paramClass, sh paramsh1, sh paramsh2, Object paramObject1, Object paramObject2) {
        super(paramClass, paramsh1, paramsh2, paramObject1, paramObject2);
    }

    public static qo a(Class<?> paramClass, sh paramsh1, sh paramsh2) {
        return new qo(paramClass, paramsh1, paramsh2, null, null);
    }

    protected sh a(Class<?> paramClass) {
        return new qo(paramClass, this.a, this.b, this.f, this.g);
    }

    public sh b(Class<?> paramClass) {
        if (paramClass == this.b.p()) {
            return this;
        }
        return new qo(this.d, this.a, this.b.f(paramClass), this.f, this.g);
    }

    public sh c(Class<?> paramClass) {
        if (paramClass == this.b.p()) {
            return this;
        }
        return new qo(this.d, this.a, this.b.h(paramClass), this.f, this.g);
    }

    public sh d(Class<?> paramClass) {
        if (paramClass == this.a.p()) {
            return this;
        }
        return new qo(this.d, this.a.f(paramClass), this.b, this.f, this.g);
    }

    public sh e(Class<?> paramClass) {
        if (paramClass == this.a.p()) {
            return this;
        }
        return new qo(this.d, this.a.h(paramClass), this.b, this.f, this.g);
    }

    public qo g(Object paramObject) {
        return new qo(this.d, this.a, this.b, this.f, paramObject);
    }

    public qo h(Object paramObject) {
        return new qo(this.d, this.a, this.b.f(paramObject), this.f, this.g);
    }

    public qo i(Object paramObject) {
        return new qo(this.d, this.a, this.b, paramObject, this.g);
    }

    public String toString() {
        return "[map type; class " + this.d.getName() + ", " + this.a + " -> " + this.b + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */