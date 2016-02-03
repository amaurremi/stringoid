package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;

import java.lang.ref.WeakReference;

import org.json.JSONException;
import org.json.JSONObject;

class AdProperties {
    private static final String b = AdProperties.class.getName();
    WeakReference<Context> a;

    AdProperties(Context paramContext) {
        this.a = new WeakReference(paramContext);
    }

    private JSONObject d() {
        JSONObject localJSONObject = new JSONObject();
        if (a().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            localJSONObject.put("android.permission.ACCESS_FINE_LOCATION", bool);
            return localJSONObject;
        }
    }

    private JSONObject e() {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("height", b());
        localJSONObject.put("width", c());
        return localJSONObject;
    }

    private JSONObject f() {
        JSONObject localJSONObject = new JSONObject();
        Context localContext = a();
        localJSONObject.put("sms", Boolean.parseBoolean(MMSDK.t(localContext)));
        localJSONObject.put("tel", Boolean.parseBoolean(MMSDK.u(localContext)));
        localJSONObject.put("calendar", MMSDK.b());
        localJSONObject.put("storePicture", false);
        localJSONObject.put("inlineVideo", true);
        return localJSONObject;
    }

    Context a() {
        return (Context) this.a.get();
    }

    String b() {
        DisplayMetrics localDisplayMetrics = a().getResources().getDisplayMetrics();
        return String.valueOf((int) (localDisplayMetrics.heightPixels / localDisplayMetrics.density));
    }

    String c() {
        DisplayMetrics localDisplayMetrics = a().getResources().getDisplayMetrics();
        return String.valueOf((int) (localDisplayMetrics.widthPixels / localDisplayMetrics.density));
    }

    public JSONObject getAdProperties(View paramView) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("screen", e());
            localJSONObject.put("ad", Utils.a(paramView));
            localJSONObject.put("do", MMSDK.v(a()));
            localJSONObject.put("supports", f());
            localJSONObject.put("device", BridgeMMDevice.a(a()));
            localJSONObject.put("permissions", d());
            localJSONObject.put("maxSize", e());
            return localJSONObject;
        } catch (JSONException paramView) {
            MMLog.a(b, "Error when building ad properties", paramView);
        }
        return localJSONObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */