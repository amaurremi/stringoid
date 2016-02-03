package org.b.g.a;

import java.io.Serializable;
import java.util.Map.Entry;

public class b<K, V>
        implements Serializable, Map.Entry<K, V> {
    private static final long serialVersionUID = -4564047655287765373L;
    private final K a;
    private final V b;

    public b(K paramK, V paramV) {
        this.a = paramK;
        this.b = paramV;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof Map.Entry)) {
                break label90;
            }
            paramObject = (Map.Entry) paramObject;
            if (this.a != null) {
                break label53;
            }
            if (((Map.Entry) paramObject).getKey() != null) {
                break;
            }
            if (this.b != null) {
                break label72;
            }
        } while (((Map.Entry) paramObject).getValue() == null);
        label53:
        label72:
        while (!this.b.equals(((Map.Entry) paramObject).getValue())) {
            do {
                return false;
            } while (!this.a.equals(((Map.Entry) paramObject).getKey()));
            break;
        }
        return true;
        label90:
        return false;
    }

    public K getKey() {
        return (K) this.a;
    }

    public V getValue() {
        return (V) this.b;
    }

    public int hashCode() {
        int j = 0;
        int i;
        if (this.a == null) {
            i = 0;
            if (this.b != null) {
                break label33;
            }
        }
        for (; ; ) {
            return i ^ j;
            i = this.a.hashCode();
            break;
            label33:
            j = this.b.hashCode();
        }
    }

    public V setValue(V paramV) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return this.a + "=" + this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/g/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */