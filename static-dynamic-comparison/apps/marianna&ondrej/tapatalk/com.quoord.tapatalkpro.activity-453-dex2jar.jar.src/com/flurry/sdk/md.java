package com.flurry.sdk;

import java.io.IOException;

public class md
        extends kx {
    protected final String a;
    protected final boolean b;
    protected mu c;
    protected lb[] d;
    protected mu e;
    protected sh f;
    protected mu g;
    protected mu h;
    protected mu i;
    protected mu j;
    protected mu k;
    protected mu l;

    public md(iy paramiy, sh paramsh) {
        boolean bool;
        if (paramiy == null) {
            bool = false;
            this.b = bool;
            if (paramsh != null) {
                break label39;
            }
        }
        label39:
        for (paramiy = "UNKNOWN TYPE"; ; paramiy = paramsh.toString()) {
            this.a = paramiy;
            return;
            bool = paramiy.a(iy.a.q);
            break;
        }
    }

    protected jh a(Throwable paramThrowable) {
        while (paramThrowable.getCause() != null) {
            paramThrowable = paramThrowable.getCause();
        }
        return new jh("Instantiation of " + a() + " value failed: " + paramThrowable.getMessage(), paramThrowable);
    }

    public Object a(double paramDouble)
            throws IOException, hk {
        try {
            if (this.k != null) {
                Object localObject = this.k.a(Double.valueOf(paramDouble));
                return localObject;
            }
        } catch (Exception localException) {
            throw a(localException);
        }
        throw new jh("Can not instantiate value of type " + a() + " from JSON floating-point number; no one-double/Double-arg constructor/factory method");
    }

    public Object a(int paramInt)
            throws IOException, hk {
        try {
            if (this.i != null) {
                return this.i.a(Integer.valueOf(paramInt));
            }
            if (this.j != null) {
                Object localObject = this.j.a(Long.valueOf(paramInt));
                return localObject;
            }
        } catch (Exception localException) {
            throw a(localException);
        }
        throw new jh("Can not instantiate value of type " + a() + " from JSON integral number; no single-int-arg constructor/factory method");
    }

    public Object a(long paramLong)
            throws IOException, hk {
        try {
            if (this.j != null) {
                Object localObject = this.j.a(Long.valueOf(paramLong));
                return localObject;
            }
        } catch (Exception localException) {
            throw a(localException);
        }
        throw new jh("Can not instantiate value of type " + a() + " from JSON long integral number; no single-long-arg constructor/factory method");
    }

    public Object a(Object paramObject)
            throws IOException, hk {
        if (this.g == null) {
            throw new IllegalStateException("No delegate constructor for " + a());
        }
        try {
            paramObject = this.g.a(paramObject);
            return paramObject;
        } catch (ExceptionInInitializerError paramObject) {
            throw a((Throwable) paramObject);
        } catch (Exception paramObject) {
            throw a((Throwable) paramObject);
        }
    }

    public Object a(String paramString)
            throws IOException, hk {
        if (this.h != null) {
            try {
                paramString = this.h.a(paramString);
                return paramString;
            } catch (Exception paramString) {
                throw a(paramString);
            }
        }
        return b(paramString);
    }

    public Object a(boolean paramBoolean)
            throws IOException, hk {
        try {
            if (this.l != null) {
                Object localObject = this.l.a(Boolean.valueOf(paramBoolean));
                return localObject;
            }
        } catch (Exception localException) {
            throw a(localException);
        }
        throw new jh("Can not instantiate value of type " + a() + " from JSON boolean value; no single-boolean/Boolean-arg constructor/factory method");
    }

    public Object a(Object[] paramArrayOfObject)
            throws IOException, hk {
        if (this.e == null) {
            throw new IllegalStateException("No with-args constructor for " + a());
        }
        try {
            paramArrayOfObject = this.e.a(paramArrayOfObject);
            return paramArrayOfObject;
        } catch (ExceptionInInitializerError paramArrayOfObject) {
            throw a(paramArrayOfObject);
        } catch (Exception paramArrayOfObject) {
            throw a(paramArrayOfObject);
        }
    }

    public String a() {
        return this.a;
    }

    public void a(mu parammu) {
        this.h = parammu;
    }

    public void a(mu parammu1, mu parammu2, sh paramsh, mu parammu3, lb[] paramArrayOflb) {
        this.c = parammu1;
        this.g = parammu2;
        this.f = paramsh;
        this.e = parammu3;
        this.d = paramArrayOflb;
    }

    protected Object b(String paramString)
            throws IOException, hk {
        if (this.l != null) {
            String str = paramString.trim();
            if ("true".equals(str)) {
                return a(true);
            }
            if ("false".equals(str)) {
                return a(false);
            }
        }
        if ((this.b) && (paramString.length() == 0)) {
            return null;
        }
        throw new jh("Can not instantiate value of type " + a() + " from JSON String; no single-String constructor/factory method");
    }

    public void b(mu parammu) {
        this.i = parammu;
    }

    public void c(mu parammu) {
        this.j = parammu;
    }

    public boolean c() {
        return this.h != null;
    }

    public void d(mu parammu) {
        this.k = parammu;
    }

    public boolean d() {
        return this.i != null;
    }

    public void e(mu parammu) {
        this.l = parammu;
    }

    public boolean e() {
        return this.j != null;
    }

    public boolean f() {
        return this.k != null;
    }

    public boolean g() {
        return this.l != null;
    }

    public boolean h() {
        return this.c != null;
    }

    public boolean j() {
        return this.e != null;
    }

    public kt[] k() {
        return this.d;
    }

    public sh l() {
        return this.f;
    }

    public Object m()
            throws IOException, hk {
        if (this.c == null) {
            throw new IllegalStateException("No default constructor for " + a());
        }
        try {
            Object localObject = this.c.g();
            return localObject;
        } catch (ExceptionInInitializerError localExceptionInInitializerError) {
            throw a(localExceptionInInitializerError);
        } catch (Exception localException) {
            throw a(localException);
        }
    }

    public mu n() {
        return this.c;
    }

    public mu o() {
        return this.g;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/md.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */