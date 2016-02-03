package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class s
        extends a<Float> {
    static final s a = new s();

    public static s a() {
        return a;
    }

    public Float a(q paramq, Float paramFloat, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return Float.valueOf(paramq.o());
    }

    public void a(e parame, Float paramFloat, boolean paramBoolean) {
        if (paramFloat == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramFloat.floatValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */