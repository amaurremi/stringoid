package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

import java.util.concurrent.Future;

import org.json.JSONObject;

@ii
public class kp
        implements kn<bv> {
    public bv b(kk paramkk, JSONObject paramJSONObject) {
        Future localFuture = paramkk.a(paramJSONObject, "image", true);
        paramkk = paramkk.a(paramJSONObject, "secondary_image", false);
        return new bv(paramJSONObject.getString("headline"), (Drawable) localFuture.get(), paramJSONObject.getString("body"), (Drawable) paramkk.get(), paramJSONObject.getString("call_to_action"), paramJSONObject.getString("attribution"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */