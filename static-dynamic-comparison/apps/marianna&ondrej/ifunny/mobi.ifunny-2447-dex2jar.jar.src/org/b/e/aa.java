package org.b.e;

import java.util.AbstractCollection;
import java.util.Iterator;

class aa
        extends AbstractCollection<ae> {
    private ae[] a;

    aa(ae[] paramArrayOfae) {
        this.a = paramArrayOfae;
    }

    public Iterator<ae> iterator() {
        return new ab(this.a, 1);
    }

    public int size() {
        return this.a.length / 2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */