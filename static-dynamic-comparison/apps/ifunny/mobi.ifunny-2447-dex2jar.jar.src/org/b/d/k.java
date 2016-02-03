package org.b.d;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class k<E>
        extends a<Collection<E>> {
    private aj<E> a;

    public k(aj<E> paramaj) {
        this.a = paramaj;
    }

    public Collection<E> a(q paramq, Collection<E> paramCollection, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        if (paramCollection == null) {
            paramCollection = new LinkedList();
        }
        for (; ; ) {
            int i = 0;
            while (i < j) {
                paramCollection.add(this.a.a(paramq, null));
                i += 1;
            }
            paramCollection.clear();
        }
        paramq.b();
        return paramCollection;
    }

    public void a(e parame, Collection<E> paramCollection, boolean paramBoolean) {
        if (paramCollection == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.c(paramCollection.size());
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            Object localObject = paramCollection.next();
            this.a.a(parame, localObject);
        }
        parame.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */