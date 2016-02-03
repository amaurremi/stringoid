package com.facebook.internal;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class BundleJSONConverter {
    private static final Map<Class<?>, BundleJSONConverter.Setter> SETTERS = new HashMap();

    static {
        SETTERS.put(Boolean.class, new BundleJSONConverter .1 ());
        SETTERS.put(Integer.class, new BundleJSONConverter .2 ());
        SETTERS.put(Long.class, new BundleJSONConverter .3 ());
        SETTERS.put(Double.class, new BundleJSONConverter .4 ());
        SETTERS.put(String.class, new BundleJSONConverter .5 ());
        SETTERS.put(String[].class, new BundleJSONConverter .6 ());
        SETTERS.put(JSONArray.class, new BundleJSONConverter .7 ());
    }

    public static Bundle convertToBundle(JSONObject paramJSONObject) {
        Bundle localBundle = new Bundle();
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            Object localObject = paramJSONObject.get(str);
            if ((localObject != null) && (localObject != JSONObject.NULL)) {
                if ((localObject instanceof JSONObject)) {
                    localBundle.putBundle(str, convertToBundle((JSONObject) localObject));
                } else {
                    BundleJSONConverter.Setter localSetter = (BundleJSONConverter.Setter) SETTERS.get(localObject.getClass());
                    if (localSetter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + localObject.getClass());
                    }
                    localSetter.setOnBundle(localBundle, str, localObject);
                }
            }
        }
        return localBundle;
    }

    public static JSONObject convertToJSON(Bundle paramBundle) {
        JSONObject localJSONObject = new JSONObject();
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            Object localObject1 = paramBundle.get(str);
            if (localObject1 != null) {
                Object localObject2;
                if ((localObject1 instanceof List)) {
                    localObject2 = new JSONArray();
                    localObject1 = ((List) localObject1).iterator();
                    while (((Iterator) localObject1).hasNext()) {
                        ((JSONArray) localObject2).put((String) ((Iterator) localObject1).next());
                    }
                    localJSONObject.put(str, localObject2);
                } else if ((localObject1 instanceof Bundle)) {
                    localJSONObject.put(str, convertToJSON((Bundle) localObject1));
                } else {
                    localObject2 = (BundleJSONConverter.Setter) SETTERS.get(localObject1.getClass());
                    if (localObject2 == null) {
                        throw new IllegalArgumentException("Unsupported type: " + localObject1.getClass());
                    }
                    ((BundleJSONConverter.Setter) localObject2).setOnJSON(localJSONObject, str, localObject1);
                }
            }
        }
        return localJSONObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/BundleJSONConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */