package org.b.f;

import java.nio.ByteBuffer;

final class f
        extends b {
    byte[] a;

    f() {
        super("raw value");
    }

    void a() {
        this.a = new byte[0];
    }

    public void a(ByteBuffer paramByteBuffer, boolean paramBoolean) {
        this.a = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(this.a);
    }

    void a(byte[] paramArrayOfByte) {
        this.a = paramArrayOfByte;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */