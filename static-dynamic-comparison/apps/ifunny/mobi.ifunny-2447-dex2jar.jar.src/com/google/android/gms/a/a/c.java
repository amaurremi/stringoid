package com.google.android.gms.a.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c {
    Map<String, String> a = new HashMap();

    public Map<String, String> a(String paramString) {
        HashMap localHashMap = new HashMap();
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            localHashMap.put(paramString + (String) localEntry.getKey(), localEntry.getValue());
        }
        return localHashMap;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */