package com.mopub.common.util;

import com.mopub.common.logging.MoPubLog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Json {
    public static <T> T getJsonValue(JSONObject paramJSONObject, String paramString, Class<T> paramClass) {
        if ((paramJSONObject == null) || (paramString == null) || (paramClass == null)) {
            throw new IllegalArgumentException("Cannot pass any null argument to getJsonValue");
        }
        paramJSONObject = paramJSONObject.opt(paramString);
        if (paramJSONObject == null) {
            MoPubLog.w("Tried to get Json value with key: " + paramString + ", but it was null");
            return null;
        }
        if (!paramClass.isInstance(paramJSONObject)) {
            MoPubLog.w("Tried to get Json value with key: " + paramString + ", of type: " + paramClass.toString() + ", its type did not match");
            return null;
        }
        return (T) paramClass.cast(paramJSONObject);
    }

    public static String[] jsonArrayToStringArray(String paramString) {
        paramString = "{key:" + paramString + "}";
        try {
            JSONArray localJSONArray = ((JSONObject) new JSONTokener(paramString).nextValue()).getJSONArray("key");
            String[] arrayOfString = new String[localJSONArray.length()];
            int i = 0;
            for (; ; ) {
                paramString = arrayOfString;
                if (i >= arrayOfString.length) {
                    break;
                }
                arrayOfString[i] = localJSONArray.getString(i);
                i += 1;
            }
            return paramString;
        } catch (JSONException paramString) {
            paramString = new String[0];
        }
    }

    public static Map<String, String> jsonStringToMap(String paramString) {
        HashMap localHashMap = new HashMap();
        if ((paramString == null) || (paramString.equals(""))) {
            return localHashMap;
        }
        paramString = (JSONObject) new JSONTokener(paramString).nextValue();
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            localHashMap.put(str, paramString.getString(str));
        }
        return localHashMap;
    }

    public static String mapToJsonString(Map<String, String> paramMap) {
        if (paramMap == null) {
            return "{}";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        paramMap = paramMap.entrySet().iterator();
        for (int i = 1; paramMap.hasNext(); i = 0) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            if (i == 0) {
                localStringBuilder.append(",");
            }
            localStringBuilder.append("\"");
            localStringBuilder.append((String) localEntry.getKey());
            localStringBuilder.append("\":\"");
            localStringBuilder.append((String) localEntry.getValue());
            localStringBuilder.append("\"");
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/Json.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */