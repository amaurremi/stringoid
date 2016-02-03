package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class g
        extends a<byte[]> {
    static final g a = new g();

    public static g a() {
        return a;
    }

    public void a(e parame, byte[] paramArrayOfByte, boolean paramBoolean) {
        if (paramArrayOfByte == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramArrayOfByte);
    }

    public byte[] a(q paramq, byte[] paramArrayOfByte, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return paramq.q();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */