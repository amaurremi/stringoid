package org.b.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class y<E>
        extends a<List<E>> {
    private aj<E> a;

    public y(aj<E> paramaj) {
        this.a = paramaj;
    }

    public List<E> a(q paramq, List<E> paramList, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        if (paramList == null) {
            paramList = new ArrayList(j);
        }
        for (; ; ) {
            int i = 0;
            while (i < j) {
                paramList.add(this.a.a(paramq, null));
                i += 1;
            }
            paramList.clear();
        }
        paramq.b();
        return paramList;
    }

    public void a(e parame, List<E> paramList, boolean paramBoolean) {
        if (!(paramList instanceof List)) {
            if (paramList == null) {
                if (paramBoolean) {
                    throw new c("Attempted to write null");
                }
                parame.d();
                return;
            }
            throw new c("Target is not a List but " + paramList.getClass());
        }
        parame.c(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            Object localObject = paramList.next();
            this.a.a(parame, localObject);
        }
        parame.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */