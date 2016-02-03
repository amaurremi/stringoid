package com.google.android.gms.a;

import com.google.android.gms.internal.hb;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bf {
    private final Map<String, String> a;
    private final long b;
    private final String c;
    private final List<hb> d;

    public bf(Map<String, String> paramMap, long paramLong, String paramString, List<hb> paramList) {
        this.a = paramMap;
        this.b = paramLong;
        this.c = paramString;
        this.d = paramList;
    }

    public Map<String, String> a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public List<hb> d() {
        return this.d;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PATH: ");
        localStringBuilder.append(this.c);
        if (this.a != null) {
            localStringBuilder.append("  PARAMS: ");
            Iterator localIterator = this.a.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                localStringBuilder.append((String) localEntry.getKey());
                localStringBuilder.append("=");
                localStringBuilder.append((String) localEntry.getValue());
                localStringBuilder.append(",  ");
            }
        }
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */