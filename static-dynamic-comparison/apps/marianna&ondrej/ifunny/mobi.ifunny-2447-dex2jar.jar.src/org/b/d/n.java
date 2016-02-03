package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class n
        extends a<Double> {
    static final n a = new n();

    public static n a() {
        return a;
    }

    public Double a(q paramq, Double paramDouble, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return Double.valueOf(paramq.p());
    }

    public void a(e parame, Double paramDouble, boolean paramBoolean) {
        if (paramDouble == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramDouble.doubleValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */