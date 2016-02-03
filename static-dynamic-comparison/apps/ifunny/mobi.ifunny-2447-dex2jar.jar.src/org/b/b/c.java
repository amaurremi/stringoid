package org.b.b;

import java.nio.ByteBuffer;

abstract class c
        implements i {
    protected byte[] a;
    protected int b;
    protected final int c;
    protected ByteBuffer d;

    public c(int paramInt) {
        int i = paramInt;
        if (paramInt < 9) {
            i = 9;
        }
        this.c = i;
    }

    private void a() {
        this.a = new byte[this.c];
        this.d = ByteBuffer.wrap(this.a);
    }

    private void a(int paramInt) {
        if (this.a == null) {
            a();
        }
        while (this.c - this.b >= paramInt) {
            return;
        }
        if (!b(this.a, 0, this.b)) {
            this.a = new byte[this.c];
            this.d = ByteBuffer.wrap(this.a);
        }
        this.b = 0;
    }

    public void a(byte paramByte) {
        a(1);
        byte[] arrayOfByte = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfByte[i] = paramByte;
    }

    public void a(byte paramByte1, byte paramByte2) {
        a(2);
        byte[] arrayOfByte = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfByte[i] = paramByte1;
        arrayOfByte = this.a;
        i = this.b;
        this.b = (i + 1);
        arrayOfByte[i] = paramByte2;
    }

    public void a(byte paramByte, double paramDouble) {
        a(9);
        byte[] arrayOfByte = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfByte[i] = paramByte;
        this.d.putDouble(this.b, paramDouble);
        this.b += 8;
    }

    public void a(byte paramByte, float paramFloat) {
        a(5);
        byte[] arrayOfByte = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfByte[i] = paramByte;
        this.d.putFloat(this.b, paramFloat);
        this.b += 4;
    }

    public void a(byte paramByte, int paramInt) {
        a(5);
        byte[] arrayOfByte = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfByte[i] = paramByte;
        this.d.putInt(this.b, paramInt);
        this.b += 4;
    }

    public void a(byte paramByte, long paramLong) {
        a(9);
        byte[] arrayOfByte = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfByte[i] = paramByte;
        this.d.putLong(this.b, paramLong);
        this.b += 8;
    }

    public void a(byte paramByte, short paramShort) {
        a(3);
        byte[] arrayOfByte = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfByte[i] = paramByte;
        this.d.putShort(this.b, paramShort);
        this.b += 2;
    }

    public void a(ByteBuffer paramByteBuffer) {
        int i = paramByteBuffer.remaining();
        if (this.a == null) {
            if (this.c < i) {
                b(paramByteBuffer);
                return;
            }
            a();
        }
        if (i <= this.c - this.b) {
            paramByteBuffer.get(this.a, this.b, i);
            this.b = (i + this.b);
            return;
        }
        if (i <= this.c) {
            if (!b(this.a, 0, this.b)) {
                a();
            }
            this.b = 0;
            paramByteBuffer.get(this.a, 0, i);
            this.b = i;
            return;
        }
        flush();
        b(paramByteBuffer);
    }

    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        if (this.a == null) {
            if (this.c < paramInt2) {
                b(paramArrayOfByte, paramInt1, paramInt2);
                return;
            }
            a();
        }
        if (paramInt2 <= this.c - this.b) {
            System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
            this.b += paramInt2;
            return;
        }
        if (paramInt2 <= this.c) {
            if (!b(this.a, 0, this.b)) {
                a();
            }
            this.b = 0;
            System.arraycopy(paramArrayOfByte, paramInt1, this.a, 0, paramInt2);
            this.b = paramInt2;
            return;
        }
        flush();
        b(paramArrayOfByte, paramInt1, paramInt2);
    }

    protected void b(ByteBuffer paramByteBuffer) {
        if (paramByteBuffer.hasArray()) {
            b(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
            paramByteBuffer.position(paramByteBuffer.limit());
            return;
        }
        byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get(arrayOfByte);
        b(arrayOfByte, 0, arrayOfByte.length);
    }

    protected abstract boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

    public void flush() {
        if (this.b > 0) {
            if (!b(this.a, 0, this.b)) {
                this.a = null;
            }
            this.b = 0;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */