package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;

class i
        extends a<JSONArray> {
    i(String paramString1, String paramString2) {
        super(paramString1, paramString2);
    }

    protected JSONArray b(String paramString) {
        try {
            paramString = new JSONArray(paramString);
            return paramString;
        } catch (JSONException paramString) {
            dv.b(a.e(), "Unable to parse the following value into a JSONArray: %s", new Object[]{a()});
        }
        return null;
    }

    protected JSONArray f() {
        return b(cx.a(b(), null));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */