package com.amazon.device.ads;

import java.util.Map;

class ez
        extends ew {
    ez(Map<String, String> paramMap, fy paramfy) {
        super(paramMap, paramfy);
    }

    void a() {
        int i = a("level");
        String str = b("log");
        if (i == -1) {
        }
        while ((str == null) || (str.length() == 0)) {
            return;
        }
        switch (i) {
            case 4:
            default:
                dv.d("MRAIDLog", str);
                return;
            case 3:
                dv.b("MRAIDLog", str);
                return;
            case 2:
                dv.a("MRAIDLog", str);
                return;
            case 5:
                dv.e("MRAIDLog", str);
                return;
        }
        dv.c("MRAIDLog", str);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */