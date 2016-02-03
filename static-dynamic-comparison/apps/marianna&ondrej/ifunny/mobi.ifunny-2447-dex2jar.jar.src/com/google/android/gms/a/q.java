package com.google.android.gms.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class q {
    private final Map<String, Integer> a = new HashMap();
    private final Map<String, String> b = new HashMap();
    private final boolean c;
    private final String d;

    q(String paramString, boolean paramBoolean) {
        this.c = paramBoolean;
        this.d = paramString;
    }

    String a() {
        if (!this.c) {
            return "";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.d);
        Iterator localIterator = this.a.keySet().iterator();
        String str;
        while (localIterator.hasNext()) {
            str = (String) localIterator.next();
            localStringBuilder.append("&").append(str).append("=").append(this.a.get(str));
        }
        localIterator = this.b.keySet().iterator();
        while (localIterator.hasNext()) {
            str = (String) localIterator.next();
            localStringBuilder.append("&").append(str).append("=").append((String) this.b.get(str));
        }
        return localStringBuilder.toString();
    }

    void a(String paramString, int paramInt) {
        if (!this.c) {
            return;
        }
        Integer localInteger2 = (Integer) this.a.get(paramString);
        Integer localInteger1 = localInteger2;
        if (localInteger2 == null) {
            localInteger1 = Integer.valueOf(0);
        }
        this.a.put(paramString, Integer.valueOf(localInteger1.intValue() + paramInt));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */