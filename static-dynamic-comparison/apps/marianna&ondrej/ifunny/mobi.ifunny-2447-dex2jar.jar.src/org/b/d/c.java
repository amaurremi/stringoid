package org.b.d;

import java.math.BigDecimal;

import org.b.c.e;
import org.b.f.q;

public class c
        extends a<BigDecimal> {
    static final c a = new c();

    public static c a() {
        return a;
    }

    public BigDecimal a(q paramq, BigDecimal paramBigDecimal, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return new BigDecimal(paramq.r());
    }

    public void a(e parame, BigDecimal paramBigDecimal, boolean paramBoolean) {
        if (paramBigDecimal == null) {
            if (paramBoolean) {
                throw new org.b.c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramBigDecimal.toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */