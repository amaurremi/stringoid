package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Map;

class fc {
    private static Map<String, fj> a = new HashMap();

    static {
        a.put("close", new fd());
        a.put("expand", new fe());
        a.put("usecustomclose", new ff());
        a.put("open", new fg());
        a.put("playVideo", new fh());
        a.put("log", new fi());
    }

    static ew a(String paramString, Map<String, String> paramMap, fy paramfy) {
        paramString = (fj) a.get(paramString);
        if (paramString != null) {
            return paramString.a(paramMap, paramfy);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */