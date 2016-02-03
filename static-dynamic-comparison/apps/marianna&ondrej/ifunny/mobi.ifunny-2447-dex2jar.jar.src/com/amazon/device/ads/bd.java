package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;

public class bd {
    private be a;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;

    protected bd() {
    }

    bd(JSONArray paramJSONArray) {
        int i;
        if (paramJSONArray != null) {
            i = 0;
        }
        for (; ; ) {
            if (i < paramJSONArray.length()) {
                try {
                    switch (paramJSONArray.getInt(i)) {
                        case 1001:
                        case 1002:
                            this.c = true;
                    }
                } catch (JSONException localJSONException) {
                    dv.d("AdProperties", "Unable to parse creative type: %s", new Object[]{localJSONException.getMessage()});
                }
                this.b = true;
                break label207;
                this.a = be.a;
                break label207;
                this.a = be.d;
                break label207;
                this.d = true;
                break label207;
                this.a = be.b;
                break label207;
                this.a = be.c;
            } else {
                return;
            }
            label207:
            i += 1;
        }
    }

    public be a() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */