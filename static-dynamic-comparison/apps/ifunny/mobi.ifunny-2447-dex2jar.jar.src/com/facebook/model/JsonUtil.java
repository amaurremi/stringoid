package com.facebook.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

class JsonUtil {
    static void jsonObjectClear(JSONObject paramJSONObject) {
        paramJSONObject = paramJSONObject.keys();
        while (paramJSONObject.hasNext()) {
            paramJSONObject.next();
            paramJSONObject.remove();
        }
    }

    static boolean jsonObjectContainsValue(JSONObject paramJSONObject, Object paramObject) {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext()) {
            Object localObject = paramJSONObject.opt((String) localIterator.next());
            if ((localObject != null) && (localObject.equals(paramObject))) {
                return true;
            }
        }
        return false;
    }

    static Set<Map.Entry<String, Object>> jsonObjectEntrySet(JSONObject paramJSONObject) {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            localHashSet.add(new JsonUtil.JSONObjectEntry(str, paramJSONObject.opt(str)));
        }
        return localHashSet;
    }

    static Set<String> jsonObjectKeySet(JSONObject paramJSONObject) {
        HashSet localHashSet = new HashSet();
        paramJSONObject = paramJSONObject.keys();
        while (paramJSONObject.hasNext()) {
            localHashSet.add(paramJSONObject.next());
        }
        return localHashSet;
    }

    static void jsonObjectPutAll(JSONObject paramJSONObject, Map<String, Object> paramMap) {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            try {
                paramJSONObject.putOpt((String) localEntry.getKey(), localEntry.getValue());
            } catch (JSONException paramJSONObject) {
                throw new IllegalArgumentException(paramJSONObject);
            }
        }
    }

    static Collection<Object> jsonObjectValues(JSONObject paramJSONObject) {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext()) {
            localArrayList.add(paramJSONObject.opt((String) localIterator.next()));
        }
        return localArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/model/JsonUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */