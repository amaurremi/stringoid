package org.b.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class ab<K, V>
        extends a<Map<K, V>> {
    private aj<K> a;
    private aj<V> b;

    public ab(aj<K> paramaj, aj<V> paramaj1) {
        this.a = paramaj;
        this.b = paramaj1;
    }

    public Map<K, V> a(q paramq, Map<K, V> paramMap, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.t();
        if (paramMap != null) {
            paramMap.clear();
        }
        for (; ; ) {
            int i = 0;
            while (i < j) {
                paramMap.put(this.a.a(paramq, null), this.b.a(paramq, null));
                i += 1;
            }
            paramMap = new HashMap(j);
        }
        paramq.c();
        return paramMap;
    }

    public void a(e parame, Map<K, V> paramMap, boolean paramBoolean) {
        if (!(paramMap instanceof Map)) {
            if (paramMap == null) {
                if (paramBoolean) {
                    throw new c("Attempted to write null");
                }
                parame.d();
                return;
            }
            throw new c("Target is not a Map but " + paramMap.getClass());
        }
        parame.d(paramMap.size());
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            this.a.a(parame, localEntry.getKey());
            this.b.a(parame, localEntry.getValue());
        }
        parame.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */