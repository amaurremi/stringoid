package org.b.b;

import java.io.Closeable;
import java.io.Flushable;
import java.nio.ByteBuffer;

public abstract interface i
        extends Closeable, Flushable {
    public abstract void a(byte paramByte);

    public abstract void a(byte paramByte1, byte paramByte2);

    public abstract void a(byte paramByte, double paramDouble);

    public abstract void a(byte paramByte, float paramFloat);

    public abstract void a(byte paramByte, int paramInt);

    public abstract void a(byte paramByte, long paramLong);

    public abstract void a(byte paramByte, short paramShort);

    public abstract void a(ByteBuffer paramByteBuffer);

    public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */