package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

final class ac
        extends AbstractSet<K> {
    ac(LinkedTreeMap paramLinkedTreeMap) {
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object paramObject) {
        return this.a.containsKey(paramObject);
    }

    public Iterator<K> iterator() {
        return new ad(this);
    }

    public boolean remove(Object paramObject) {
        return this.a.removeInternalByKey(paramObject) != null;
    }

    public int size() {
        return this.a.size;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */