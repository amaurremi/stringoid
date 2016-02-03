package org.b.e;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import org.b.g.a.b;

class y
        implements Iterator<Map.Entry<ae, ae>> {
    private static final boolean c;
    private ae[] a;
    private int b;

    static {
        try {
            Class.forName("java.util.AbstractMap.SimpleImmutableEntry");
            c = true;
            return;
        } catch (ClassNotFoundException localClassNotFoundException) {
            localClassNotFoundException = localClassNotFoundException;
            c = false;
            return;
        } finally {
            localObject =finally;
            c = true;
            throw ((Throwable) localObject);
        }
    }

    y(ae[] paramArrayOfae) {
        this.a = paramArrayOfae;
        this.b = 0;
    }

    public Map.Entry<ae, ae> a() {
        if (this.b >= this.a.length) {
            throw new NoSuchElementException();
        }
        Object localObject = this.a[this.b];
        ae localae = this.a[(this.b + 1)];
        if (c) {
        }
        for (localObject = new AbstractMap.SimpleImmutableEntry(localObject, localae); ; localObject = new b(localObject, localae)) {
            localObject = (Map.Entry) localObject;
            this.b += 2;
            return (Map.Entry<ae, ae>) localObject;
        }
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */