package com.millennialmedia.a.a.b;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class aa
        extends AbstractSet<Map.Entry<K, V>> {
    aa(w paramw) {
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object paramObject) {
        return ((paramObject instanceof Map.Entry)) && (this.a.a((Map.Entry) paramObject) != null);
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new ab(this);
    }

    public boolean remove(Object paramObject) {
        if (!(paramObject instanceof Map.Entry)) {
        }
        do {
            return false;
            paramObject = this.a.a((Map.Entry) paramObject);
        } while (paramObject == null);
        this.a.a((af) paramObject, true);
        return true;
    }

    public int size() {
        return this.a.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */