package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JSONUtils {
    protected static boolean getBooleanFromJSON(JSONObject paramJSONObject, String paramString, boolean paramBoolean) {
        return paramJSONObject.optBoolean(paramString, paramBoolean);
    }

    protected static int getIntegerFromJSON(JSONObject paramJSONObject, String paramString, int paramInt) {
        return paramJSONObject.optInt(paramString, paramInt);
    }

    protected static int getIntegerFromJSONArray(JSONArray paramJSONArray, int paramInt1, int paramInt2) {
        return paramJSONArray.optInt(paramInt1, paramInt2);
    }

    protected static JSONArray getJSONArrayFromJSON(JSONObject paramJSONObject, String paramString) {
        return paramJSONObject.optJSONArray(paramString);
    }

    protected static JSONObject getJSONObjectFromJSONArray(JSONArray paramJSONArray, int paramInt) {
        try {
            paramJSONArray = paramJSONArray.getJSONObject(paramInt);
            return paramJSONArray;
        } catch (JSONException paramJSONArray) {
        }
        return null;
    }

    protected static JSONObject getJSONObjectFromString(String paramString) {
        try {
            paramString = new JSONObject(paramString);
            return paramString;
        } catch (JSONException paramString) {
        }
        return null;
    }

    protected static long getLongFromJSON(JSONObject paramJSONObject, String paramString, long paramLong) {
        return paramJSONObject.optLong(paramString, paramLong);
    }

    protected static String getStringFromJSON(JSONObject paramJSONObject, String paramString1, String paramString2) {
        return paramJSONObject.optString(paramString1, paramString2);
    }

    protected static void put(JSONObject paramJSONObject, String paramString, int paramInt) {
        try {
            paramJSONObject.put(paramString, paramInt);
            return;
        } catch (JSONException paramJSONObject) {
        }
    }

    protected static void put(JSONObject paramJSONObject, String paramString, long paramLong) {
        try {
            paramJSONObject.put(paramString, paramLong);
            return;
        } catch (JSONException paramJSONObject) {
        }
    }

    protected static void put(JSONObject paramJSONObject, String paramString1, String paramString2) {
        if ((paramString2 != null) && (!paramString2.equals(""))) {
        }
        try {
            paramJSONObject.put(paramString1, paramString2);
            return;
        } catch (JSONException paramJSONObject) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/JSONUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */