package org.b.e;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class x
        extends AbstractSet<Map.Entry<ae, ae>> {
    private ae[] a;

    x(ae[] paramArrayOfae) {
        this.a = paramArrayOfae;
    }

    public Iterator<Map.Entry<ae, ae>> iterator() {
        return new y(this.a);
    }

    public int size() {
        return this.a.length / 2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */