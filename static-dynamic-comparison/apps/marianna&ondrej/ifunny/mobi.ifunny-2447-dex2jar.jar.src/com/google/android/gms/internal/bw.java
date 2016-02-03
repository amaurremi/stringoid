package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@ii
public class bw {
    private te a;
    private q b;
    private JSONObject c;

    public bw(te paramte, q paramq, JSONObject paramJSONObject) {
        this.a = paramte;
        this.b = paramq;
        this.c = paramJSONObject;
    }

    public void a() {
        this.a.j();
    }

    public void a(String paramString, int paramInt) {
        try {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("asset", paramInt);
            localJSONObject.put("template", paramString);
            paramString = new JSONObject();
            paramString.put("ad", this.c);
            paramString.put("click", localJSONObject);
            this.b.a("google.afma.nativeAds.handleClick", paramString);
            return;
        } catch (JSONException paramString) {
            mx.b("Unable to create click JSON.", paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */