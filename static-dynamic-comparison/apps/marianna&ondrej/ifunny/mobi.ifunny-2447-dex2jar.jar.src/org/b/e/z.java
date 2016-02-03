package org.b.e;

import java.util.AbstractSet;
import java.util.Iterator;

class z
        extends AbstractSet<ae> {
    private ae[] a;

    z(ae[] paramArrayOfae) {
        this.a = paramArrayOfae;
    }

    public Iterator<ae> iterator() {
        return new ab(this.a, 0);
    }

    public int size() {
        return this.a.length / 2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */