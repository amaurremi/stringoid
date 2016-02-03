package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

@ii
public final class gp {
    public static int a(Intent paramIntent) {
        paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
        if (paramIntent == null) {
            mx.e("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if ((paramIntent instanceof Integer)) {
            return ((Integer) paramIntent).intValue();
        }
        if ((paramIntent instanceof Long)) {
            return (int) ((Long) paramIntent).longValue();
        }
        mx.e("Unexpected type for intent response code. " + paramIntent.getClass().getName());
        return 5;
    }

    public static int a(Bundle paramBundle) {
        paramBundle = paramBundle.get("RESPONSE_CODE");
        if (paramBundle == null) {
            mx.e("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if ((paramBundle instanceof Integer)) {
            return ((Integer) paramBundle).intValue();
        }
        if ((paramBundle instanceof Long)) {
            return (int) ((Long) paramBundle).longValue();
        }
        mx.e("Unexpected type for intent response code. " + paramBundle.getClass().getName());
        return 5;
    }

    public static String a(String paramString) {
        if (paramString == null) {
            return null;
        }
        try {
            paramString = new JSONObject(paramString).getString("developerPayload");
            return paramString;
        } catch (JSONException paramString) {
            mx.e("Fail to parse purchase data");
        }
        return null;
    }

    public static String b(Intent paramIntent) {
        if (paramIntent == null) {
            return null;
        }
        return paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public static String b(String paramString) {
        if (paramString == null) {
            return null;
        }
        try {
            paramString = new JSONObject(paramString).getString("purchaseToken");
            return paramString;
        } catch (JSONException paramString) {
            mx.e("Fail to parse purchase data");
        }
        return null;
    }

    public static String c(Intent paramIntent) {
        if (paramIntent == null) {
            return null;
        }
        return paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */