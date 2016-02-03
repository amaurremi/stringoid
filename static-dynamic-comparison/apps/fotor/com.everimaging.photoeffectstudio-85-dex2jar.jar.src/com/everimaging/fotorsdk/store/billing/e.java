package com.everimaging.fotorsdk.store.billing;

import org.json.JSONException;
import org.json.JSONObject;

public class e {
    String a;
    String b;
    String c;
    String d;
    long e;
    int f;
    String g;
    String h;
    String i;
    String j;

    public e(String paramString1, String paramString2, String paramString3)
            throws JSONException {
        this.a = paramString1;
        this.i = paramString2;
        paramString1 = new JSONObject(this.i);
        this.b = paramString1.optString("orderId");
        this.c = paramString1.optString("packageName");
        this.d = paramString1.optString("productId");
        this.e = paramString1.optLong("purchaseTime");
        this.f = paramString1.optInt("purchaseState");
        this.g = paramString1.optString("developerPayload");
        this.h = paramString1.optString("token", paramString1.optString("purchaseToken"));
        this.j = paramString3;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.h;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.a + "):" + this.i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/billing/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */