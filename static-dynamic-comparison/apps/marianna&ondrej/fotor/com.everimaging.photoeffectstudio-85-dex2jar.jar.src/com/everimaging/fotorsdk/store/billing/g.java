package com.everimaging.fotorsdk.store.billing;

import org.json.JSONException;
import org.json.JSONObject;

public class g {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;

    public g(String paramString1, String paramString2)
            throws JSONException {
        this.a = paramString1;
        this.g = paramString2;
        paramString1 = new JSONObject(this.g);
        this.b = paramString1.optString("productId");
        this.c = paramString1.optString("type");
        this.d = paramString1.optString("price");
        this.e = paramString1.optString("title");
        this.f = paramString1.optString("description");
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.d;
    }

    public String toString() {
        return "SkuDetails:" + this.g;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/billing/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */