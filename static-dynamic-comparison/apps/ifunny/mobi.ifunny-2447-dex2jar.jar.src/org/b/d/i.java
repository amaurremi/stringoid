package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class i
        extends a<Byte> {
    static final i a = new i();

    public static i a() {
        return a;
    }

    public Byte a(q paramq, Byte paramByte, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return Byte.valueOf(paramq.j());
    }

    public void a(e parame, Byte paramByte, boolean paramBoolean) {
        if (paramByte == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramByte.byteValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */