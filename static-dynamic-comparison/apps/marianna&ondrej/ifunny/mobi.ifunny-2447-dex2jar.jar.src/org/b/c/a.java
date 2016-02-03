package org.b.c;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import org.b.d.aj;
import org.b.e.ae;

public abstract class a
        implements e {
    protected org.b.a a;

    protected a(org.b.a parama) {
        this.a = parama;
    }

    public e a() {
        c(true);
        return this;
    }

    public e a(byte paramByte) {
        b(paramByte);
        return this;
    }

    public e a(double paramDouble) {
        b(paramDouble);
        return this;
    }

    public e a(float paramFloat) {
        b(paramFloat);
        return this;
    }

    public e a(int paramInt) {
        b(paramInt);
        return this;
    }

    public e a(long paramLong) {
        b(paramLong);
        return this;
    }

    public e a(Object paramObject) {
        if (paramObject == null) {
            d();
            return this;
        }
        this.a.a(paramObject.getClass()).a(this, paramObject);
        return this;
    }

    public e a(Short paramShort) {
        if (paramShort == null) {
            d();
            return this;
        }
        b(paramShort.shortValue());
        return this;
    }

    public e a(String paramString) {
        if (paramString == null) {
            d();
            return this;
        }
        b(paramString);
        return this;
    }

    public e a(BigInteger paramBigInteger) {
        if (paramBigInteger == null) {
            d();
            return this;
        }
        b(paramBigInteger);
        return this;
    }

    public e a(ByteBuffer paramByteBuffer) {
        if (paramByteBuffer == null) {
            d();
            return this;
        }
        b(paramByteBuffer);
        return this;
    }

    public e a(ae paramae) {
        if (paramae == null) {
            d();
            return this;
        }
        paramae.a(this);
        return this;
    }

    public e a(short paramShort) {
        b(paramShort);
        return this;
    }

    public e a(boolean paramBoolean) {
        b(paramBoolean);
        return this;
    }

    public e a(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            d();
            return this;
        }
        b(paramArrayOfByte);
        return this;
    }

    protected abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

    public e b() {
        d(true);
        return this;
    }

    protected abstract void b(byte paramByte);

    protected abstract void b(double paramDouble);

    protected abstract void b(float paramFloat);

    protected abstract void b(int paramInt);

    protected abstract void b(long paramLong);

    protected abstract void b(String paramString);

    protected abstract void b(BigInteger paramBigInteger);

    protected abstract void b(ByteBuffer paramByteBuffer);

    protected abstract void b(short paramShort);

    protected abstract void b(boolean paramBoolean);

    protected void b(byte[] paramArrayOfByte) {
        a(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public void close() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */