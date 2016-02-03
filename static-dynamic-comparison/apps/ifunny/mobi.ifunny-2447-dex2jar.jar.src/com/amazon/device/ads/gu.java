package com.amazon.device.ads;

import org.json.JSONObject;

class gu
        extends gt {
    private static final eb a = eb.K;

    public gu() {
        a(a);
        a("SISGenerateDIDRequest");
        b("/generate_did");
    }

    public void a(JSONObject paramJSONObject) {
        paramJSONObject = du.a(paramJSONObject, "adId", "");
        if (paramJSONObject.length() > 0) {
            dn.i().c().a(paramJSONObject, e());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */