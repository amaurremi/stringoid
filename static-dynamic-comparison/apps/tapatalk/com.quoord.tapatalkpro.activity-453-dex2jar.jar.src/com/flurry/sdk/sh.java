package com.flurry.sdk;

import java.lang.reflect.Modifier;

public abstract class sh {
    protected final Class<?> d;
    protected final int e;
    protected Object f;
    protected Object g;

    protected sh(Class<?> paramClass, int paramInt) {
        this.d = paramClass;
        this.e = (paramClass.getName().hashCode() + paramInt);
        this.f = null;
        this.g = null;
    }

    protected abstract sh a(Class<?> paramClass);

    public String a(int paramInt) {
        return null;
    }

    protected void a(Class<?> paramClass1, Class<?> paramClass2) {
        if (!this.d.isAssignableFrom(paramClass1)) {
            throw new IllegalArgumentException("Class " + paramClass1.getName() + " is not assignable to " + this.d.getName());
        }
    }

    public sh b(int paramInt) {
        return null;
    }

    public abstract sh b(Class<?> paramClass);

    public boolean b() {
        return false;
    }

    public abstract sh c(Class<?> paramClass);

    public boolean c() {
        return Modifier.isAbstract(this.d.getModifiers());
    }

    public sh d(Object paramObject) {
        j(paramObject);
        return this;
    }

    public boolean d() {
        if ((this.d.getModifiers() & 0x600) == 0) {
        }
        while (this.d.isPrimitive()) {
            return true;
        }
        return false;
    }

    public abstract sh e(Object paramObject);

    public boolean e() {
        return h() > 0;
    }

    public abstract boolean equals(Object paramObject);

    public sh f(Class<?> paramClass) {
        if (paramClass == this.d) {
            return this;
        }
        a(paramClass, this.d);
        Object localObject = a(paramClass);
        paramClass = (Class<?>) localObject;
        if (this.f != ((sh) localObject).n()) {
            paramClass = ((sh) localObject).d(this.f);
        }
        localObject = paramClass;
        if (this.g != paramClass.o()) {
            localObject = paramClass.f(this.g);
        }
        return (sh) localObject;
    }

    public abstract sh f(Object paramObject);

    public abstract boolean f();

    public sh g() {
        return null;
    }

    public sh g(Class<?> paramClass) {
        if (paramClass == this.d) {
            return this;
        }
        Object localObject = a(paramClass);
        paramClass = (Class<?>) localObject;
        if (this.f != ((sh) localObject).n()) {
            paramClass = ((sh) localObject).d(this.f);
        }
        localObject = paramClass;
        if (this.g != paramClass.o()) {
            localObject = paramClass.f(this.g);
        }
        return (sh) localObject;
    }

    public int h() {
        return 0;
    }

    public sh h(Class<?> paramClass) {
        if (paramClass == this.d) {
            return this;
        }
        a(this.d, paramClass);
        return i(paramClass);
    }

    public final int hashCode() {
        return this.e;
    }

    protected sh i(Class<?> paramClass) {
        return a(paramClass);
    }

    public boolean i() {
        return false;
    }

    @Deprecated
    public void j(Object paramObject) {
        if ((paramObject != null) && (this.f != null)) {
            throw new IllegalStateException("Trying to reset value handler for type [" + toString() + "]; old handler of type " + this.f.getClass().getName() + ", new handler of type " + paramObject.getClass().getName());
        }
        this.f = paramObject;
    }

    public boolean j() {
        return false;
    }

    public sh k() {
        return null;
    }

    public abstract String m();

    public <T> T n() {
        return (T) this.f;
    }

    public <T> T o() {
        return (T) this.g;
    }

    public final Class<?> p() {
        return this.d;
    }

    public boolean q() {
        return Throwable.class.isAssignableFrom(this.d);
    }

    public final boolean r() {
        return this.d.isEnum();
    }

    public final boolean s() {
        return this.d.isInterface();
    }

    public final boolean t() {
        return this.d.isPrimitive();
    }

    public abstract String toString();

    public final boolean u() {
        return Modifier.isFinal(this.d.getModifiers());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/sh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */