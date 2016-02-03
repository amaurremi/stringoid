package com.flurry.sdk;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class gz<K, V>
        implements Map<K, V> {
    private final ReferenceQueue<K> a = new ReferenceQueue();
    private Map<gz<K, V>.a, V> b = new HashMap();

    private void a() {
        try {
            for (Object localObject1 = this.a.poll(); localObject1 != null; localObject1 = this.a.poll()) {
                localObject1 = (a) localObject1;
                this.b.remove(localObject1);
            }
            return;
        } finally {
        }
    }

    public void clear() {
        this.b.clear();
        a();
    }

    public boolean containsKey(Object paramObject) {
        a();
        return this.b.containsKey(new a(paramObject));
    }

    public boolean containsValue(Object paramObject) {
        a();
        return this.b.containsValue(paramObject);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        a();
        HashSet localHashSet = new HashSet();
        Iterator localIterator = this.b.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            localHashSet.add(new Map.Entry() {
                public K getKey() {
                    return (K) this.a;
                }

                public V getValue() {
                    return (V) this.b;
                }

                public V setValue(V paramAnonymousV) {
                    throw new UnsupportedOperationException();
                }
            });
        }
        return Collections.unmodifiableSet(localHashSet);
    }

    public boolean equals(Object paramObject) {
        return this.b.equals(((gz) paramObject).b);
    }

    public V get(Object paramObject) {
        a();
        return (V) this.b.get(new a(paramObject));
    }

    public int hashCode() {
        a();
        return this.b.hashCode();
    }

    public boolean isEmpty() {
        a();
        return this.b.isEmpty();
    }

    public Set<K> keySet() {
        a();
        HashSet localHashSet = new HashSet();
        Iterator localIterator = this.b.keySet().iterator();
        while (localIterator.hasNext()) {
            localHashSet.add(((a) localIterator.next()).get());
        }
        return Collections.unmodifiableSet(localHashSet);
    }

    public V put(K paramK, V paramV) {
        a();
        return (V) this.b.put(new a(paramK), paramV);
    }

    public void putAll(Map paramMap) {
        throw new UnsupportedOperationException();
    }

    public V remove(Object paramObject) {
        a();
        return (V) this.b.remove(new a(paramObject));
    }

    public int size() {
        a();
        return this.b.size();
    }

    public Collection<V> values() {
        a();
        return this.b.values();
    }

    class a
            extends WeakReference<K> {
        int a;

        a(Object paramObject) {
            super(gz.a(gz.this));
            this.a = System.identityHashCode(paramObject);
        }

        public boolean equals(Object paramObject) {
            if (this == paramObject) {
            }
            do {
                return true;
                paramObject = (a) paramObject;
            } while (get() == ((a) paramObject).get());
            return false;
        }

        public int hashCode() {
            return this.a;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */