package com.amazon.device.ads;

import org.json.JSONObject;

class hd
        extends gt {
    private static final eb a = eb.L;

    public hd() {
        a(a);
        a("SISUpdateDeviceInfoRequest");
        b("/update_dev_info");
    }

    public void a(JSONObject paramJSONObject) {
        String str = du.a(paramJSONObject, "adId", "");
        if (du.a(paramJSONObject, "idChanged", false)) {
            dy.a().b().a(eb.J);
        }
        if (str.length() > 0) {
            dn.i().c().a(str, e());
        }
    }

    public ib d() {
        String str = cx.a("debug.adid", e().e());
        ib localib = super.d();
        if (!hu.c(str)) {
            localib.a("adId", str);
        }
        return localib;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */