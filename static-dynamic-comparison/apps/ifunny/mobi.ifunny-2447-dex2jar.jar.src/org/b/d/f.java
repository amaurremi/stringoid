package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class f
        extends a<Boolean> {
    static final f a = new f();

    public static f a() {
        return a;
    }

    public Boolean a(q paramq, Boolean paramBoolean, boolean paramBoolean1) {
        if ((!paramBoolean1) && (paramq.h())) {
            return null;
        }
        return Boolean.valueOf(paramq.i());
    }

    public void a(e parame, Boolean paramBoolean, boolean paramBoolean1) {
        if (paramBoolean == null) {
            if (paramBoolean1) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramBoolean.booleanValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */