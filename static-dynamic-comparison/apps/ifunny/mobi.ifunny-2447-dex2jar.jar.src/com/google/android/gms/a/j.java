package com.google.android.gms.a;

import android.text.TextUtils;
import com.google.android.gms.a.a.a;
import com.google.android.gms.a.a.b;
import com.google.android.gms.a.a.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class j<T extends j> {
    b a;
    Map<String, List<a>> b = new HashMap();
    List<c> c = new ArrayList();
    List<a> d = new ArrayList();
    private Map<String, String> e = new HashMap();

    public T a(int paramInt, String paramString) {
        a(at.a(paramInt), paramString);
        return this;
    }

    public final T a(String paramString1, String paramString2) {
        bl.a().a(bm.a);
        if (paramString1 != null) {
            this.e.put(paramString1, paramString2);
            return this;
        }
        bt.d(" HitBuilder.set() called with a null paramName.");
        return this;
    }

    public Map<String, String> a() {
        HashMap localHashMap = new HashMap(this.e);
        if (this.a != null) {
            localHashMap.putAll(this.a.a());
        }
        Iterator localIterator = this.c.iterator();
        int i = 1;
        while (localIterator.hasNext()) {
            localHashMap.putAll(((c) localIterator.next()).a(at.c(i)));
            i += 1;
        }
        localIterator = this.d.iterator();
        i = 1;
        while (localIterator.hasNext()) {
            localHashMap.putAll(((a) localIterator.next()).a(at.b(i)));
            i += 1;
        }
        localIterator = this.b.entrySet().iterator();
        i = 1;
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            Object localObject = (List) localEntry.getValue();
            String str = at.e(i);
            localObject = ((List) localObject).iterator();
            int j = 1;
            while (((Iterator) localObject).hasNext()) {
                localHashMap.putAll(((a) ((Iterator) localObject).next()).a(str + at.d(j)));
                j += 1;
            }
            if (!TextUtils.isEmpty((CharSequence) localEntry.getKey())) {
                localHashMap.put(str + "nm", localEntry.getKey());
            }
            i += 1;
        }
        return localHashMap;
    }

    public T d(String paramString) {
        bl.a().a(bm.d);
        paramString = ab.b(paramString);
        if (TextUtils.isEmpty(paramString)) {
            return this;
        }
        paramString = ab.a(paramString);
        a("&cc", (String) paramString.get("utm_content"));
        a("&cm", (String) paramString.get("utm_medium"));
        a("&cn", (String) paramString.get("utm_campaign"));
        a("&cs", (String) paramString.get("utm_source"));
        a("&ck", (String) paramString.get("utm_term"));
        a("&ci", (String) paramString.get("utm_id"));
        a("&gclid", (String) paramString.get("gclid"));
        a("&dclid", (String) paramString.get("dclid"));
        a("&gmob_t", (String) paramString.get("gmob_t"));
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */