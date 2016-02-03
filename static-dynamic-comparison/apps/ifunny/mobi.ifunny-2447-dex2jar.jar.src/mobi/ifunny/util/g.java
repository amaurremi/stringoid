package mobi.ifunny.util;

import java.util.HashMap;

public class g<K, V>
        extends HashMap<K, V> {
    private V a;

    public void a(V paramV) {
        this.a = paramV;
    }

    public V get(Object paramObject) {
        if (containsKey(paramObject)) {
            return (V) super.get(paramObject);
        }
        return (V) this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */