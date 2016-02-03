package org.b.d;

import java.math.BigInteger;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class d
        extends a<BigInteger> {
    static final d a = new d();

    public static d a() {
        return a;
    }

    public BigInteger a(q paramq, BigInteger paramBigInteger, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return paramq.n();
    }

    public void a(e parame, BigInteger paramBigInteger, boolean paramBoolean) {
        if (paramBigInteger == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramBigInteger);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */