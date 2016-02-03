package com.flurry.sdk;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class rc<K, V>
        extends LinkedHashMap<K, V> {
    protected final int a;

    public rc(int paramInt1, int paramInt2) {
        super(paramInt1, 0.8F, true);
        this.a = paramInt2;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry) {
        return size() > this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */