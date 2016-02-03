package com.amazon.device.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

class bl {
    private final JSONObject a = new JSONObject();
    private a<?>[] b;
    private Map<String, String> c;
    private p d;

    bl a(p paramp) {
        this.d = paramp;
        return this;
    }

    bl a(Map<String, String> paramMap) {
        this.c = paramMap;
        return this;
    }

    bl a(a<?>[] paramArrayOfa) {
        this.b = paramArrayOfa;
        return this;
    }

    p a() {
        return this.d;
    }

    void a(a<?> parama, Object paramObject) {
        a(parama.a(), paramObject);
    }

    void a(String paramString, Object paramObject) {
        if (paramObject != null) {
        }
        try {
            this.a.put(paramString, paramObject);
            return;
        } catch (JSONException localJSONException) {
            dv.a(bk.g(), "Could not add parameter to JSON %s: %s", new Object[]{paramString, paramObject});
        }
    }

    JSONObject b() {
        return this.a;
    }

    void c() {
        Object localObject1 = this.b;
        int j = localObject1.length;
        int i = 0;
        Object localObject2;
        while (i < j) {
            localObject2 = localObject1[i];
            a((a) localObject2, ((a) localObject2).a(this.d));
            i += 1;
        }
        if (this.c != null) {
            localObject1 = this.c.entrySet().iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                if (!hu.d((String) ((Map.Entry) localObject2).getValue())) {
                    a((String) ((Map.Entry) localObject2).getKey(), ((Map.Entry) localObject2).getValue());
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */