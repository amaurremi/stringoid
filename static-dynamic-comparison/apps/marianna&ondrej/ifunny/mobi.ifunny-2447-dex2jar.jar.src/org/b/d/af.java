package org.b.d;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class af<E>
        extends a<Set<E>> {
    private aj<E> a;

    public af(aj<E> paramaj) {
        this.a = paramaj;
    }

    public Set<E> a(q paramq, Set<E> paramSet, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        if (paramSet == null) {
            paramSet = new HashSet(j);
        }
        for (; ; ) {
            int i = 0;
            while (i < j) {
                paramSet.add(this.a.a(paramq, null));
                i += 1;
            }
            paramSet.clear();
        }
        paramq.b();
        return paramSet;
    }

    public void a(e parame, Set<E> paramSet, boolean paramBoolean) {
        if (!(paramSet instanceof Set)) {
            if (paramSet == null) {
                if (paramBoolean) {
                    throw new c("Attempted to write null");
                }
                parame.d();
                return;
            }
            throw new c("Target is not a List but " + paramSet.getClass());
        }
        parame.c(paramSet.size());
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
            Object localObject = paramSet.next();
            this.a.a(parame, localObject);
        }
        parame.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */