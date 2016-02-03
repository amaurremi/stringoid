package com.millennialmedia.a.a.b;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class ae<T>
        implements Iterator<T> {
    af<K, V> b = this.e.c.d;
    af<K, V> c = null;
    int d = this.e.e;

    private ae(w paramw) {
    }

    final af<K, V> b() {
        af localaf = this.b;
        if (localaf == this.e.c) {
            throw new NoSuchElementException();
        }
        if (this.e.e != this.d) {
            throw new ConcurrentModificationException();
        }
        this.b = localaf.d;
        this.c = localaf;
        return localaf;
    }

    public final boolean hasNext() {
        return this.b != this.e.c;
    }

    public final void remove() {
        if (this.c == null) {
            throw new IllegalStateException();
        }
        this.e.a(this.c, true);
        this.c = null;
        this.d = this.e.e;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */