package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.util.List;

import org.json.JSONObject;

class HandShake$Scheme {
    String a;
    int b;

    HandShake$Scheme(HandShake paramHandShake) {
    }

    HandShake$Scheme(HandShake paramHandShake, String paramString, int paramInt) {
        this.a = paramString;
        this.b = paramInt;
    }

    void a(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            return;
        }
        this.a = paramJSONObject.optString("scheme", null);
        this.b = paramJSONObject.optInt("schemeid");
    }

    boolean a(Context paramContext) {
        if (this.a.contains("://")) {
        }
        for (Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.a)); paramContext.getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0; localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.a + "://"))) {
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HandShake$Scheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */