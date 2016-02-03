package org.b.d;

import java.nio.ByteBuffer;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class h
        extends a<ByteBuffer> {
    static final h a = new h();

    public static h a() {
        return a;
    }

    public ByteBuffer a(q paramq, ByteBuffer paramByteBuffer, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return paramq.a();
    }

    public void a(e parame, ByteBuffer paramByteBuffer, boolean paramBoolean) {
        if (paramByteBuffer == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramByteBuffer);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */