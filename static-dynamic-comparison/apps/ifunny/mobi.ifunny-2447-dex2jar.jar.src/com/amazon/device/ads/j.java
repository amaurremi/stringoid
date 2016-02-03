package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

class j
        extends a<JSONObject> {
    j(String paramString1, String paramString2) {
        super(paramString1, paramString2);
    }

    protected JSONObject b(String paramString) {
        try {
            paramString = new JSONObject(paramString);
            return paramString;
        } catch (JSONException paramString) {
            dv.b(a.e(), "Unable to parse the following value into a JSONObject: %s", new Object[]{a()});
        }
        return null;
    }

    protected JSONObject f() {
        return b(cx.a(b(), null));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */