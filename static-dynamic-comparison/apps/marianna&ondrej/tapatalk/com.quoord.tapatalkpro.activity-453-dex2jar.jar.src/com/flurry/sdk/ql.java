package com.flurry.sdk;

public final class ql
        extends qk {
    private ql(Class<?> paramClass, sh paramsh, Object paramObject1, Object paramObject2) {
        super(paramClass, paramsh, paramObject1, paramObject2);
    }

    public static ql a(Class<?> paramClass, sh paramsh) {
        return new ql(paramClass, paramsh, null, null);
    }

    protected sh a(Class<?> paramClass) {
        return new ql(paramClass, this.a, null, null);
    }

    public sh b(Class<?> paramClass) {
        if (paramClass == this.a.p()) {
            return this;
        }
        return new ql(this.d, this.a.f(paramClass), this.f, this.g);
    }

    public sh c(Class<?> paramClass) {
        if (paramClass == this.a.p()) {
            return this;
        }
        return new ql(this.d, this.a.h(paramClass), this.f, this.g);
    }

    public ql g(Object paramObject) {
        return new ql(this.d, this.a, this.f, paramObject);
    }

    public ql h(Object paramObject) {
        return new ql(this.d, this.a.f(paramObject), this.f, this.g);
    }

    public ql i(Object paramObject) {
        return new ql(this.d, this.a, paramObject, this.g);
    }

    public String toString() {
        return "[collection type; class " + this.d.getName() + ", contains " + this.a + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */