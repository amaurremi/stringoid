package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class b<T>
        extends a<T> {
    private al a;

    public b(al paramal) {
        this.a = paramal;
    }

    public T a(q paramq, T paramT, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            paramq = null;
        }
        do {
            do {
                return paramq;
                if (paramT == null) {
                    throw new c("convert into unknown type is invalid");
                }
                paramT = paramq.a(paramT);
                paramq = paramT;
            } while (!paramBoolean);
            paramq = paramT;
        } while (paramT != null);
        throw new c("Unexpected nil value");
    }

    public void a(e parame, T paramT, boolean paramBoolean) {
        if (paramT == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        this.a.a(paramT.getClass()).a(parame, paramT);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */