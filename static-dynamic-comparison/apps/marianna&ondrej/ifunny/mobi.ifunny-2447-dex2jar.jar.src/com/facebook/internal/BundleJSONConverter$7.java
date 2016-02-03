package com.facebook.internal;

import android.os.Bundle;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

final class BundleJSONConverter$7
        implements BundleJSONConverter.Setter {
    public void setOnBundle(Bundle paramBundle, String paramString, Object paramObject) {
        paramObject = (JSONArray) paramObject;
        ArrayList localArrayList = new ArrayList();
        if (((JSONArray) paramObject).length() == 0) {
            paramBundle.putStringArrayList(paramString, localArrayList);
            return;
        }
        int i = 0;
        while (i < ((JSONArray) paramObject).length()) {
            Object localObject = ((JSONArray) paramObject).get(i);
            if ((localObject instanceof String)) {
                localArrayList.add((String) localObject);
                i += 1;
            } else {
                throw new IllegalArgumentException("Unexpected type in an array: " + localObject.getClass());
            }
        }
        paramBundle.putStringArrayList(paramString, localArrayList);
    }

    public void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject) {
        throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/BundleJSONConverter$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */