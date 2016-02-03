package com.google.gson.internal;

import java.util.Map.Entry;

final class y<K, V>
        implements Map.Entry<K, V> {
    y<K, V> a;
    y<K, V> b;
    y<K, V> c;
    y<K, V> d;
    y<K, V> e;
    final K f;
    final int g;
    V h;
    int i;

    y() {
        this.f = null;
        this.g = -1;
        this.e = this;
        this.d = this;
    }

    y(y<K, V> paramy1, K paramK, int paramInt, y<K, V> paramy2, y<K, V> paramy3) {
        this.a = paramy1;
        this.f = paramK;
        this.g = paramInt;
        this.i = 1;
        this.d = paramy2;
        this.e = paramy3;
        paramy3.d = this;
        paramy2.e = this;
    }

    public y<K, V> a() {
        Object localObject1 = this.b;
        Object localObject2 = this;
        while (localObject1 != null) {
            y localy = ((y) localObject1).b;
            localObject2 = localObject1;
            localObject1 = localy;
        }
        return (y<K, V>) localObject2;
    }

    public y<K, V> b() {
        Object localObject1 = this.c;
        Object localObject2 = this;
        while (localObject1 != null) {
            y localy = ((y) localObject1).c;
            localObject2 = localObject1;
            localObject1 = localy;
        }
        return (y<K, V>) localObject2;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof Map.Entry)) {
            paramObject = (Map.Entry) paramObject;
            if (this.f != null) {
                break label56;
            }
            bool1 = bool2;
            if (((Map.Entry) paramObject).getKey() == null) {
                if (this.h != null) {
                    break label77;
                }
                bool1 = bool2;
                if (((Map.Entry) paramObject).getValue() != null) {
                }
            }
        }
        for (; ; ) {
            bool1 = true;
            label56:
            label77:
            do {
                do {
                    return bool1;
                    bool1 = bool2;
                } while (!this.f.equals(((Map.Entry) paramObject).getKey()));
                break;
                bool1 = bool2;
            } while (!this.h.equals(((Map.Entry) paramObject).getValue()));
        }
    }

    public K getKey() {
        return (K) this.f;
    }

    public V getValue() {
        return (V) this.h;
    }

    public int hashCode() {
        int k = 0;
        int j;
        if (this.f == null) {
            j = 0;
            if (this.h != null) {
                break label33;
            }
        }
        for (; ; ) {
            return j ^ k;
            j = this.f.hashCode();
            break;
            label33:
            k = this.h.hashCode();
        }
    }

    public V setValue(V paramV) {
        Object localObject = this.h;
        this.h = paramV;
        return (V) localObject;
    }

    public String toString() {
        return this.f + "=" + this.h;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */