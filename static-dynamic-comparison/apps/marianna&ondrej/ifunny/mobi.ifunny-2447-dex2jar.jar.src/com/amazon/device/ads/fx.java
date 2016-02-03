package com.amazon.device.ads;

import java.util.Locale;

class fx
        extends ft {
    private final gm a;

    fx(gm paramgm) {
        this.a = paramgm;
    }

    public static fx a(gm paramgm) {
        return new fx(paramgm);
    }

    public String a() {
        return "state: '" + this.a.toString().toLowerCase(Locale.US) + "'";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */