package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class aa
        extends a<Long> {
    static final aa a = new aa();

    public static aa a() {
        return a;
    }

    public Long a(q paramq, Long paramLong, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return Long.valueOf(paramq.m());
    }

    public void a(e parame, Long paramLong, boolean paramBoolean) {
        if (paramLong == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramLong.longValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */