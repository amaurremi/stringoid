package com.amazon.device.ads;

import java.util.Locale;

class fs
        extends ft {
    private final gl a;

    fs(gl paramgl) {
        this.a = paramgl;
    }

    public static fs a(gl paramgl) {
        return new fs(paramgl);
    }

    public String a() {
        return "placementType: '" + this.a.toString().toLowerCase(Locale.US) + "'";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */