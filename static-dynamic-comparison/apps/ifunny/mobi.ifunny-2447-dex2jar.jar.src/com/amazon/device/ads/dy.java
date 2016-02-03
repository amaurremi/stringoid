package com.amazon.device.ads;

class dy {
    private static final String a = dy.class.getSimpleName();
    private static dy b = new dy();
    private ec c = new ec();

    public static dy a() {
        return b;
    }

    private void a(hy paramhy) {
        ho.a(new dz(this, paramhy));
    }

    public void a(ah paramah) {
        bc localbc = new bc(paramah);
        if (localbc.b()) {
            paramah = this.c;
            this.c = new ec();
            localbc.a(paramah);
            a(localbc.a());
            return;
        }
        paramah.o();
    }

    public ec b() {
        return this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */