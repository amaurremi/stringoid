package android.support.v4.d;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
        extends m<K, V>
        implements Map<K, V> {
    g<K, V> a;

    private g<K, V> b() {
        if (this.a == null) {
            this.a = new b(this);
        }
        return this.a;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    public Set<K> keySet() {
        return b().e();
    }

    public void putAll(Map<? extends K, ? extends V> paramMap) {
        a(this.h + paramMap.size());
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            put(localEntry.getKey(), localEntry.getValue());
        }
    }

    public Collection<V> values() {
        return b().f();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */