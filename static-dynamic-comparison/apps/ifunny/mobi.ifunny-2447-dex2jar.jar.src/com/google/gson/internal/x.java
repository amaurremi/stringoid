package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class x<T>
        implements Iterator<T> {
    y<K, V> b = this.e.header.d;
    y<K, V> c = null;
    int d = this.e.modCount;

    private x(LinkedHashTreeMap paramLinkedHashTreeMap) {
    }

    final y<K, V> b() {
        y localy = this.b;
        if (localy == this.e.header) {
            throw new NoSuchElementException();
        }
        if (this.e.modCount != this.d) {
            throw new ConcurrentModificationException();
        }
        this.b = localy.d;
        this.c = localy;
        return localy;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */