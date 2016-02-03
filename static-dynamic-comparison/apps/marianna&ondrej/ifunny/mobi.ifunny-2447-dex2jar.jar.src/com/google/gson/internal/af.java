package com.google.gson.internal;

import java.util.Map.Entry;

final class af<K, V>
        implements Map.Entry<K, V> {
    af<K, V> a;
    af<K, V> b;
    af<K, V> c;
    af<K, V> d;
    af<K, V> e;
    final K f;
    V g;
    int h;

    af() {
        this.f = null;
        this.e = this;
        this.d = this;
    }

    af(af<K, V> paramaf1, K paramK, af<K, V> paramaf2, af<K, V> paramaf3) {
        this.a = paramaf1;
        this.f = paramK;
        this.h = 1;
        this.d = paramaf2;
        this.e = paramaf3;
        paramaf3.d = this;
        paramaf2.e = this;
    }

    public af<K, V> a() {
        Object localObject1 = this.b;
        Object localObject2 = this;
        while (localObject1 != null) {
            af localaf = ((af) localObject1).b;
            localObject2 = localObject1;
            localObject1 = localaf;
        }
        return (af<K, V>) localObject2;
    }

    public af<K, V> b() {
        Object localObject1 = this.c;
        Object localObject2 = this;
        while (localObject1 != null) {
            af localaf = ((af) localObject1).c;
            localObject2 = localObject1;
            localObject1 = localaf;
        }
        return (af<K, V>) localObject2;
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
                if (this.g != null) {
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
            } while (!this.g.equals(((Map.Entry) paramObject).getValue()));
        }
    }

    public K getKey() {
        return (K) this.f;
    }

    public V getValue() {
        return (V) this.g;
    }

    public int hashCode() {
        int j = 0;
        int i;
        if (this.f == null) {
            i = 0;
            if (this.g != null) {
                break label33;
            }
        }
        for (; ; ) {
            return i ^ j;
            i = this.f.hashCode();
            break;
            label33:
            j = this.g.hashCode();
        }
    }

    public V setValue(V paramV) {
        Object localObject = this.g;
        this.g = paramV;
        return (V) localObject;
    }

    public String toString() {
        return this.f + "=" + this.g;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */