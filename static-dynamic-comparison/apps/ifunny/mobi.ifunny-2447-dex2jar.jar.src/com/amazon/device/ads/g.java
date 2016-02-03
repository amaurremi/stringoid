package com.amazon.device.ads;

import android.location.Location;

class g
        extends w {
    g() {
        super("geoloc", "debug.geoloc");
    }

    protected String c(p paramp) {
        if ((cq.a().b(cs.f)) && (p.b(paramp).b().d())) {
            paramp = new ba().a();
            if (paramp != null) {
            }
        } else {
            return null;
        }
        return paramp.getLatitude() + "," + paramp.getLongitude();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */