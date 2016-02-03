package com.everimaging.fotorsdk.uil.cache.memory.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class a<K, V>
        implements com.everimaging.fotorsdk.uil.cache.memory.a<K, V> {
    private final com.everimaging.fotorsdk.uil.cache.memory.a<K, V> a;
    private final Comparator<K> b;

    public a(com.everimaging.fotorsdk.uil.cache.memory.a<K, V> parama, Comparator<K> paramComparator) {
        this.a = parama;
        this.b = paramComparator;
    }

    public V a(K paramK) {
        return (V) this.a.a(paramK);
    }

    public Collection<K> a() {
        return this.a.a();
    }

    public boolean a(K paramK, V paramV) {
        for (; ; ) {
            synchronized (this.a) {
                Iterator localIterator = this.a.a().iterator();
                if (localIterator.hasNext()) {
                    localObject = localIterator.next();
                    if (this.b.compare(paramK, localObject) != 0) {
                        continue;
                    }
                    if (localObject != null) {
                        this.a.b(localObject);
                    }
                    return this.a.a(paramK, paramV);
                }
            }
            Object localObject = null;
        }
    }

    public void b(K paramK) {
        this.a.b(paramK);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/cache/memory/impl/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */