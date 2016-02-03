package com.amazon.device.ads;

import org.json.JSONObject;

class z
        extends j {
    z() {
        super("uinfo", "debug.ui");
    }

    protected JSONObject c(p paramp) {
        if (p.b(paramp).b().f()) {
            int i = p.b(paramp).b().e();
            paramp = new JSONObject();
            du.b(paramp, "age", String.valueOf(i));
            return paramp;
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */