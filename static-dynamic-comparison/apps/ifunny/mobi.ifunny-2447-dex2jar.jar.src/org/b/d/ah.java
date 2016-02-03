package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class ah
        extends a<Short> {
    static final ah a = new ah();

    public static ah a() {
        return a;
    }

    public Short a(q paramq, Short paramShort, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return Short.valueOf(paramq.k());
    }

    public void a(e parame, Short paramShort, boolean paramBoolean) {
        if (paramShort == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramShort);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */