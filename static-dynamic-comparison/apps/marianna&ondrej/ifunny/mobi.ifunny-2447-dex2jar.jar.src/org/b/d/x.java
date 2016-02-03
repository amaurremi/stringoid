package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class x
        extends a<Integer> {
    static final x a = new x();

    public static x a() {
        return a;
    }

    public Integer a(q paramq, Integer paramInteger, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return Integer.valueOf(paramq.l());
    }

    public void a(e parame, Integer paramInteger, boolean paramBoolean) {
        if (paramInteger == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramInteger.intValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */