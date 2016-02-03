package com.amazon.device.ads;

import java.util.Vector;

class ec {
    protected Vector<ee> a = new Vector(60);
    private String b;

    public Vector<ee> a() {
        return this.a;
    }

    public void a(be parambe) {
        this.b = parambe.a();
    }

    public void a(eb parameb) {
        this.a.add(new ef(parameb, 1));
    }

    public void a(eb parameb, long paramLong) {
        this.a.add(new ej(parameb, paramLong));
    }

    public void a(eb parameb, String paramString) {
        this.a.add(new ei(parameb, paramString));
    }

    public String b() {
        return this.b;
    }

    public void b(eb parameb) {
        b(parameb, System.nanoTime());
    }

    public void b(eb parameb, long paramLong) {
        paramLong = hu.a(paramLong);
        this.a.add(new eg(parameb, paramLong));
    }

    public void c(eb parameb) {
        c(parameb, System.nanoTime());
    }

    public void c(eb parameb, long paramLong) {
        paramLong = hu.a(paramLong);
        this.a.add(new eh(parameb, paramLong));
    }

    public boolean c() {
        return this.a.isEmpty();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */