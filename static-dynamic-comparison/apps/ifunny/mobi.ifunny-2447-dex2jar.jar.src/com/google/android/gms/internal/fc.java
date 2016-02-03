package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@ii
public class fc {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    private fc(fe paramfe) {
        this.a = fe.a(paramfe);
        this.b = fe.b(paramfe);
        this.c = fe.c(paramfe);
        this.d = fe.d(paramfe);
        this.e = fe.e(paramfe);
    }

    public JSONObject a() {
        try {
            JSONObject localJSONObject = new JSONObject().put("sms", this.a).put("tel", this.b).put("calendar", this.c).put("storePicture", this.d).put("inlineVideo", this.e);
            return localJSONObject;
        } catch (JSONException localJSONException) {
            mx.b("Error occured while obtaining the MRAID capabilities.", localJSONException);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */