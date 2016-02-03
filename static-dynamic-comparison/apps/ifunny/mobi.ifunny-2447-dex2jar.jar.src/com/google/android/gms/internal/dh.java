package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

@ii
public final class dh {
    public final String a;
    public final String b;
    public final List<String> c;
    public final String d;
    public final String e;
    public final List<String> f;
    public final String g;

    public dh(JSONObject paramJSONObject) {
        this.b = paramJSONObject.getString("id");
        Object localObject1 = paramJSONObject.getJSONArray("adapters");
        ArrayList localArrayList = new ArrayList(((JSONArray) localObject1).length());
        int i = 0;
        while (i < ((JSONArray) localObject1).length()) {
            localArrayList.add(((JSONArray) localObject1).getString(i));
            i += 1;
        }
        this.c = Collections.unmodifiableList(localArrayList);
        this.d = paramJSONObject.optString("allocation_id", null);
        this.f = dr.a(paramJSONObject, "imp_urls");
        localObject1 = paramJSONObject.optJSONObject("ad");
        if (localObject1 != null) {
            localObject1 = ((JSONObject) localObject1).toString();
            this.a = ((String) localObject1);
            localObject1 = paramJSONObject.optJSONObject("data");
            if (localObject1 == null) {
                break label164;
            }
        }
        label164:
        for (paramJSONObject = ((JSONObject) localObject1).toString(); ; paramJSONObject = null) {
            this.g = paramJSONObject;
            paramJSONObject = (JSONObject) localObject2;
            if (localObject1 != null) {
                paramJSONObject = ((JSONObject) localObject1).optString("class_name");
            }
            this.e = paramJSONObject;
            return;
            localObject1 = null;
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */