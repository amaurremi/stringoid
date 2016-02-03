package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class ae<T>
        implements Iterator<T> {
    af<K, V> b = this.e.header.d;
    af<K, V> c = null;
    int d = this.e.modCount;

    private ae(LinkedTreeMap paramLinkedTreeMap) {
    }

    final af<K, V> b() {
        af localaf = this.b;
        if (localaf == this.e.header) {
            throw new NoSuchElementException();
        }
        if (this.e.modCount != this.d) {
            throw new ConcurrentModificationException();
        }
        this.b = localaf.d;
        this.c = localaf;
        return localaf;
    }

    public final boolean hasNext() {
        return this.b != this.e.header;
    }

    public final void remove() {
        if (this.c == null) {
            throw new IllegalStateException();
        }
        this.e.removeInternal(this.c, true);
        this.c = null;
        this.d = this.e.modCount;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */