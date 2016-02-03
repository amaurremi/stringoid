package com.facebook.internal;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONObject;

final class BundleJSONConverter$6
        implements BundleJSONConverter.Setter {
    public void setOnBundle(Bundle paramBundle, String paramString, Object paramObject) {
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    public void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject) {
        JSONArray localJSONArray = new JSONArray();
        paramObject = (String[]) paramObject;
        int j = paramObject.length;
        int i = 0;
        while (i < j) {
            localJSONArray.put(paramObject[i]);
            i += 1;
        }
        paramJSONObject.put(paramString, localJSONArray);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/BundleJSONConverter$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */