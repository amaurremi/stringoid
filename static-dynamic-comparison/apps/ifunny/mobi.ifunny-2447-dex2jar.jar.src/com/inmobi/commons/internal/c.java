package com.inmobi.commons.internal;

import com.inmobi.commons.metric.Storage.PreProcessor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class c
        implements Storage.PreProcessor {
    public JSONObject process(JSONObject paramJSONObject) {
        Object localObject1 = new HashMap();
        for (; ; ) {
            int i;
            Object localObject2;
            try {
                JSONArray localJSONArray1 = paramJSONObject.getJSONArray("payload");
                i = 0;
                if (i < localJSONArray1.length()) {
                    int j = localJSONArray1.getJSONObject(i).getInt("t");
                    localObject2 = (Integer) ((Map) localObject1).get(Integer.valueOf(j));
                    if (localObject2 == null) {
                        ((Map) localObject1).put(Integer.valueOf(j), Integer.valueOf(1));
                    } else {
                        ((Map) localObject1).put(Integer.valueOf(j), Integer.valueOf(((Integer) localObject2).intValue() + 1));
                    }
                }
            } catch (JSONException localJSONException) {
                Log.internal("[InMobi]-4.5.1", "Unable to aggregate data. Sending data as-is.");
                return paramJSONObject;
            }
            JSONArray localJSONArray2 = new JSONArray();
            localObject1 = ((Map) localObject1).entrySet().iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("t", ((Map.Entry) localObject2).getKey());
                localJSONObject.put("v", ((Map.Entry) localObject2).getValue());
                localJSONArray2.put(localJSONObject);
            }
            paramJSONObject.put("payload", localJSONArray2);
            return paramJSONObject;
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */