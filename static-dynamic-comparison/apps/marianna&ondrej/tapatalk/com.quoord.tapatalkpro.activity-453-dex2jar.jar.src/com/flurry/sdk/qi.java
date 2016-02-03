package com.flurry.sdk;

import java.lang.reflect.Array;

public final class qi
        extends qq {
    protected final sh a;
    protected final Object b;

    private qi(sh paramsh, Object paramObject1, Object paramObject2, Object paramObject3) {
        super(paramObject1.getClass(), paramsh.hashCode(), paramObject2, paramObject3);
        this.a = paramsh;
        this.b = paramObject1;
    }

    public static qi a(sh paramsh, Object paramObject1, Object paramObject2) {
        return new qi(paramsh, Array.newInstance(paramsh.p(), 0), null, null);
    }

    public qi a(Object paramObject) {
        if (paramObject == this.g) {
            return this;
        }
        return new qi(this.a, this.b, this.f, paramObject);
    }

    protected sh a(Class<?> paramClass) {
        if (!paramClass.isArray()) {
            throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + toString() + " to class " + paramClass.getName());
        }
        paramClass = paramClass.getComponentType();
        return a(qs.a().a(paramClass), this.f, this.g);
    }

    protected String a() {
        return this.d.getName();
    }

    public String a(int paramInt) {
        if (paramInt == 0) {
            return "E";
        }
        return null;
    }

    public qi b(Object paramObject) {
        if (paramObject == this.a.o()) {
            return this;
        }
        return new qi(this.a.f(paramObject), this.b, this.f, this.g);
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
        return a(this.a.f(paramClass), this.f, this.g);
    }

    public boolean b() {
        return true;
    }

    public qi c(Object paramObject) {
        if (paramObject == this.f) {
            return this;
        }
        return new qi(this.a, this.b, paramObject, this.g);
    }

    public sh c(Class<?> paramClass) {
        if (paramClass == this.a.p()) {
            return this;
        }
        return a(this.a.h(paramClass), this.f, this.g);
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return this.a.e();
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
        } while (paramObject.getClass() != getClass());
        paramObject = (qi) paramObject;
        return this.a.equals(((qi) paramObject).a);
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

    public String toString() {
        return "[array type, component type: " + this.a + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */