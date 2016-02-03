package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class du {
    protected static int a(JSONArray paramJSONArray, int paramInt1, int paramInt2) {
        return paramJSONArray.optInt(paramInt1, paramInt2);
    }

    protected static int a(JSONObject paramJSONObject, String paramString, int paramInt) {
        return paramJSONObject.optInt(paramString, paramInt);
    }

    protected static long a(JSONObject paramJSONObject, String paramString, long paramLong) {
        return paramJSONObject.optLong(paramString, paramLong);
    }

    protected static String a(JSONObject paramJSONObject, String paramString1, String paramString2) {
        return paramJSONObject.optString(paramString1, paramString2);
    }

    protected static JSONArray a(JSONObject paramJSONObject, String paramString) {
        return paramJSONObject.optJSONArray(paramString);
    }

    protected static JSONObject a(String paramString) {
        try {
            paramString = new JSONObject(paramString);
            return paramString;
        } catch (JSONException paramString) {
        }
        return null;
    }

    protected static JSONObject a(JSONArray paramJSONArray, int paramInt) {
        try {
            paramJSONArray = paramJSONArray.getJSONObject(paramInt);
            return paramJSONArray;
        } catch (JSONException paramJSONArray) {
        }
        return null;
    }

    protected static boolean a(JSONObject paramJSONObject, String paramString, boolean paramBoolean) {
        return paramJSONObject.optBoolean(paramString, paramBoolean);
    }

    protected static void b(JSONObject paramJSONObject, String paramString, int paramInt) {
        try {
            paramJSONObject.put(paramString, paramInt);
            return;
        } catch (JSONException paramJSONObject) {
        }
    }

    protected static void b(JSONObject paramJSONObject, String paramString, long paramLong) {
        try {
            paramJSONObject.put(paramString, paramLong);
            return;
        } catch (JSONException paramJSONObject) {
        }
    }

    protected static void b(JSONObject paramJSONObject, String paramString1, String paramString2) {
        if ((paramString2 != null) && (!paramString2.equals(""))) {
        }
        try {
            paramJSONObject.put(paramString1, paramString2);
            return;
        } catch (JSONException paramJSONObject) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */