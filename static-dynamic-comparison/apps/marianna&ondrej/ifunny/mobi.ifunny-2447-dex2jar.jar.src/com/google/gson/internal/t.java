package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class t
        extends AbstractSet<Map.Entry<K, V>> {
    t(LinkedHashTreeMap paramLinkedHashTreeMap) {
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object paramObject) {
        return ((paramObject instanceof Map.Entry)) && (this.a.findByEntry((Map.Entry) paramObject) != null);
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new u(this);
    }

    public boolean remove(Object paramObject) {
        if (!(paramObject instanceof Map.Entry)) {
        }
        do {
            return false;
            paramObject = this.a.findByEntry((Map.Entry) paramObject);
        } while (paramObject == null);
        this.a.removeInternal((y) paramObject, true);
        return true;
    }

    public int size() {
        return this.a.size;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */