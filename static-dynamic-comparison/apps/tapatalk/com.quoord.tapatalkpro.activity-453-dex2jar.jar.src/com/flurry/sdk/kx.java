package com.flurry.sdk;

import java.io.IOException;

public abstract class kx {
    public Object a(double paramDouble)
            throws IOException, hk {
        throw new jh("Can not instantiate value of type " + a() + " from JSON floating-point number");
    }

    public Object a(int paramInt)
            throws IOException, hk {
        throw new jh("Can not instantiate value of type " + a() + " from JSON int number");
    }

    public Object a(long paramLong)
            throws IOException, hk {
        throw new jh("Can not instantiate value of type " + a() + " from JSON long number");
    }

    public Object a(Object paramObject)
            throws IOException, hk {
        throw new jh("Can not instantiate value of type " + a() + " using delegate");
    }

    public Object a(String paramString)
            throws IOException, hk {
        throw new jh("Can not instantiate value of type " + a() + " from JSON String");
    }

    public Object a(boolean paramBoolean)
            throws IOException, hk {
        throw new jh("Can not instantiate value of type " + a() + " from JSON boolean value");
    }

    public Object a(Object[] paramArrayOfObject)
            throws IOException, hk {
        throw new jh("Can not instantiate value of type " + a() + " with arguments");
    }

    public abstract String a();

    public boolean b() {
        return (h()) || (i()) || (j()) || (c()) || (d()) || (e()) || (f()) || (g());
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return n() != null;
    }

    public boolean i() {
        return l() != null;
    }

    public boolean j() {
        return false;
    }

    public kt[] k() {
        return null;
    }

    public sh l() {
        return null;
    }

    public Object m()
            throws IOException, hk {
        throw new jh("Can not instantiate value of type " + a() + "; no default creator found");
    }

    public mu n() {
        return null;
    }

    public mu o() {
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */