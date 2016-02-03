package org.b.d;

import org.b.b;
import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class ac
        extends a<b> {
    private Class<?> a;

    ac(Class<?> paramClass) {
        this.a = paramClass;
    }

    public b a(q paramq, b paramb, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        if (paramb == null) {
        }
        for (; ; ) {
            try {
                paramb = (b) this.a.newInstance();
                paramb.a(paramq);
                return paramb;
            } catch (InstantiationException paramq) {
                throw new c(paramq);
            } catch (IllegalAccessException paramq) {
                throw new c(paramq);
            }
        }
    }

    public void a(e parame, b paramb, boolean paramBoolean) {
        if (paramb == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        paramb.a(parame);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */