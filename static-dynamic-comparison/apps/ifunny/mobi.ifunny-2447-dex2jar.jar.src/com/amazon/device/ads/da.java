package com.amazon.device.ads;

class da {
    private static final String a = da.class.getSimpleName();

    private void a(boolean paramBoolean) {
        he.a().d("gps-available", paramBoolean);
    }

    private boolean c() {
        return he.a().a("gps-available", true);
    }

    private boolean d() {
        return he.a().a("gps-available");
    }

    public db a() {
        if (!c()) {
            dv.a(a, "The Google Play Services Advertising Identifier feature is not available.");
            return db.a();
        }
        if ((!d()) && (!gr.a("com.google.android.gms.ads.identifier.AdvertisingIdClient"))) {
            dv.a(a, "The Google Play Services Advertising Identifier feature is not available.");
            a(false);
            return db.a();
        }
        db localdb = b().a();
        a(localdb.b());
        return localdb;
    }

    protected dc b() {
        return new dc();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */