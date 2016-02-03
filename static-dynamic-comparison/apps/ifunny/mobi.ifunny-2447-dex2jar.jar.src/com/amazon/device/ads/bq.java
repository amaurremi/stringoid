package com.amazon.device.ads;

class bq {
    private int a;
    private final cb b;
    private final br c;
    private aj d;

    public bq(aa paramaa, br parambr) {
        this(a(paramaa), parambr);
    }

    bq(cb paramcb, br parambr) {
        this.b = paramcb;
        if (parambr == null) {
            this.c = new br();
            return;
        }
        this.c = parambr;
    }

    static cb a(aa paramaa) {
        if ((paramaa instanceof al)) {
            return new aq((al) paramaa);
        }
        if ((paramaa instanceof do)){
            return new dt(( do)paramaa);
        }
        return null;
    }

    public br a() {
        return this.c;
    }

    void a(int paramInt) {
        this.a = paramInt;
    }

    void a(aj paramaj) {
        this.d = paramaj;
    }

    int b() {
        return this.a;
    }

    aj c() {
        return this.d;
    }

    cb d() {
        return this.b;
    }

    ah e() {
        return this.b.a();
    }

    dk f() {
        return this.b.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */