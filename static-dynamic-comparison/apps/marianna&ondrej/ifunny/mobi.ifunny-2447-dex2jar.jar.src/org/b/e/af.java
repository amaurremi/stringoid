package org.b.e;

import java.math.BigInteger;
import java.nio.ByteBuffer;

public final class af {
    public static f a(ae[] paramArrayOfae, boolean paramBoolean) {
        if (paramArrayOfae.length == 0) {
            return g.o();
        }
        return new g(paramArrayOfae, paramBoolean);
    }

    public static i a(boolean paramBoolean) {
        if (paramBoolean) {
            return ad.o();
        }
        return m.o();
    }

    public static n a(double paramDouble) {
        return new l(paramDouble);
    }

    public static n a(float paramFloat) {
        return new o(paramFloat);
    }

    public static q a(byte paramByte) {
        return new p(paramByte);
    }

    public static q a(int paramInt) {
        return new p(paramInt);
    }

    public static q a(long paramLong) {
        return new r(paramLong);
    }

    public static q a(BigInteger paramBigInteger) {
        return new h(paramBigInteger);
    }

    public static q a(short paramShort) {
        return new p(paramShort);
    }

    public static t a() {
        return t.n();
    }

    public static v a(String paramString) {
        return new ac(paramString);
    }

    public static v a(ByteBuffer paramByteBuffer) {
        int i = paramByteBuffer.position();
        try {
            Object localObject1 = new byte[paramByteBuffer.remaining()];
            paramByteBuffer.get((byte[]) localObject1);
            localObject1 = new j((byte[]) localObject1, true);
            return (v) localObject1;
        } finally {
            paramByteBuffer.position(i);
        }
    }

    public static v a(byte[] paramArrayOfByte) {
        return a(paramArrayOfByte, false);
    }

    public static v a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        return new j(paramArrayOfByte, paramInt1, paramInt2);
    }

    public static v a(byte[] paramArrayOfByte, boolean paramBoolean) {
        return new j(paramArrayOfByte, paramBoolean);
    }

    public static s b(ae[] paramArrayOfae, boolean paramBoolean) {
        if (paramArrayOfae.length == 0) {
            return w.o();
        }
        return new w(paramArrayOfae, paramBoolean);
    }

    public static v b() {
        return j.n();
    }

    public static f c() {
        return g.o();
    }

    public static s d() {
        return w.o();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */