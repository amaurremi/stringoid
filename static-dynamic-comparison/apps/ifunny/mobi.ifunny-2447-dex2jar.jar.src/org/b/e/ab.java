package org.b.e;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ab
        implements Iterator<ae> {
    private ae[] a;
    private int b;

    ab(ae[] paramArrayOfae, int paramInt) {
        this.a = paramArrayOfae;
        this.b = paramInt;
    }

    public ae a() {
        if (this.b >= this.a.length) {
            throw new NoSuchElementException();
        }
        ae localae = this.a[this.b];
        this.b += 2;
        return localae;
    }

    public boolean hasNext() {
        return this.b < this.a.length;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */