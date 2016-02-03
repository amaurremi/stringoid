package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.e.ae;
import org.b.f.q;

public class am
        extends a<ae> {
    static final am a = new am();

    public static am a() {
        return a;
    }

    public ae a(q paramq, ae paramae, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return paramq.e();
    }

    public void a(e parame, ae paramae, boolean paramBoolean) {
        if (paramae == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        paramae.a(parame);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */