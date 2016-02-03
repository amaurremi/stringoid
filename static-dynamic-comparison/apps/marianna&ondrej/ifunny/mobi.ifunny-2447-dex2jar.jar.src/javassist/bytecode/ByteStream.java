package javassist.bytecode;

import java.io.OutputStream;

final class ByteStream
        extends OutputStream {
    private byte[] buf;
    private int count;

    public ByteStream() {
        this(32);
    }

    public ByteStream(int paramInt) {
        this.buf = new byte[paramInt];
        this.count = 0;
    }

    private void writeUTF2(String paramString, int paramInt1, int paramInt2) {
        int j = paramInt2;
        int k = paramInt1;
        if (j < paramInt1) {
            int m = paramString.charAt(j);
            if (m > 2047) {
                i = k + 2;
            }
            for (; ; ) {
                j += 1;
                k = i;
                break;
                if (m != 0) {
                    i = k;
                    if (m <= 127) {
                    }
                } else {
                    i = k + 1;
                }
            }
        }
        if (k > 65535) {
            throw new RuntimeException("encoded string too long: " + paramInt1 + k + " bytes");
        }
        enlarge(k + 2);
        int i = this.count;
        byte[] arrayOfByte = this.buf;
        arrayOfByte[i] = ((byte) (k >>> 8));
        arrayOfByte[(i + 1)] = ((byte) k);
        j = paramInt2 + 2 + i;
        i = paramInt2;
        paramInt2 = j;
        if (i < paramInt1) {
            k = paramString.charAt(i);
            if ((1 <= k) && (k <= 127)) {
                j = paramInt2 + 1;
                arrayOfByte[paramInt2] = ((byte) k);
                paramInt2 = j;
            }
            for (; ; ) {
                i += 1;
                break;
                if (k > 2047) {
                    arrayOfByte[paramInt2] = ((byte) (k >> 12 & 0xF | 0xE0));
                    arrayOfByte[(paramInt2 + 1)] = ((byte) (k >> 6 & 0x3F | 0x80));
                    arrayOfByte[(paramInt2 + 2)] = ((byte) (k & 0x3F | 0x80));
                    paramInt2 += 3;
                } else {
                    arrayOfByte[paramInt2] = ((byte) (k >> 6 & 0x1F | 0xC0));
                    arrayOfByte[(paramInt2 + 1)] = ((byte) (k & 0x3F | 0x80));
                    paramInt2 += 2;
                }
            }
        }
        this.count = paramInt2;
    }

    public void enlarge(int paramInt) {
        paramInt = this.count + paramInt;
        if (paramInt > this.buf.length) {
            int i = this.buf.length << 1;
            if (i <= paramInt) {
                break label55;
            }
            paramInt = i;
        }
        label55:
        for (; ; ) {
            byte[] arrayOfByte = new byte[paramInt];
            System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
            this.buf = arrayOfByte;
            return;
        }
    }

    public int getPos() {
        return this.count;
    }

    public int size() {
        return this.count;
    }

    public byte[] toByteArray() {
        byte[] arrayOfByte = new byte[this.count];
        System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
        return arrayOfByte;
    }

    public void write(int paramInt) {
        enlarge(1);
        int i = this.count;
        this.buf[i] = ((byte) paramInt);
        this.count = (i + 1);
    }

    public void write(int paramInt1, int paramInt2) {
        this.buf[paramInt1] = ((byte) paramInt2);
    }

    public void write(byte[] paramArrayOfByte) {
        write(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        enlarge(paramInt2);
        System.arraycopy(paramArrayOfByte, paramInt1, this.buf, this.count, paramInt2);
        this.count += paramInt2;
    }

    public void writeBlank(int paramInt) {
        enlarge(paramInt);
        this.count += paramInt;
    }

    public void writeDouble(double paramDouble) {
        writeLong(Double.doubleToLongBits(paramDouble));
    }

    public void writeFloat(float paramFloat) {
        writeInt(Float.floatToIntBits(paramFloat));
    }

    public void writeInt(int paramInt) {
        enlarge(4);
        int i = this.count;
        this.buf[i] = ((byte) (paramInt >>> 24));
        this.buf[(i + 1)] = ((byte) (paramInt >>> 16));
        this.buf[(i + 2)] = ((byte) (paramInt >>> 8));
        this.buf[(i + 3)] = ((byte) paramInt);
        this.count = (i + 4);
    }

    public void writeInt(int paramInt1, int paramInt2) {
        this.buf[paramInt1] = ((byte) (paramInt2 >>> 24));
        this.buf[(paramInt1 + 1)] = ((byte) (paramInt2 >>> 16));
        this.buf[(paramInt1 + 2)] = ((byte) (paramInt2 >>> 8));
        this.buf[(paramInt1 + 3)] = ((byte) paramInt2);
    }

    public void writeLong(long paramLong) {
        enlarge(8);
        int i = this.count;
        this.buf[i] = ((byte) (int) (paramLong >>> 56));
        this.buf[(i + 1)] = ((byte) (int) (paramLong >>> 48));
        this.buf[(i + 2)] = ((byte) (int) (paramLong >>> 40));
        this.buf[(i + 3)] = ((byte) (int) (paramLong >>> 32));
        this.buf[(i + 4)] = ((byte) (int) (paramLong >>> 24));
        this.buf[(i + 5)] = ((byte) (int) (paramLong >>> 16));
        this.buf[(i + 6)] = ((byte) (int) (paramLong >>> 8));
        this.buf[(i + 7)] = ((byte) (int) paramLong);
        this.count = (i + 8);
    }

    public void writeShort(int paramInt) {
        enlarge(2);
        int i = this.count;
        this.buf[i] = ((byte) (paramInt >>> 8));
        this.buf[(i + 1)] = ((byte) paramInt);
        this.count = (i + 2);
    }

    public void writeShort(int paramInt1, int paramInt2) {
        this.buf[paramInt1] = ((byte) (paramInt2 >>> 8));
        this.buf[(paramInt1 + 1)] = ((byte) paramInt2);
    }

    public void writeTo(OutputStream paramOutputStream) {
        paramOutputStream.write(this.buf, 0, this.count);
    }

    public void writeUTF(String paramString) {
        int k = paramString.length();
        int i = this.count;
        enlarge(k + 2);
        byte[] arrayOfByte = this.buf;
        int j = i + 1;
        arrayOfByte[i] = ((byte) (k >>> 8));
        i = j + 1;
        arrayOfByte[j] = ((byte) k);
        j = 0;
        while (j < k) {
            int m = paramString.charAt(j);
            if ((1 <= m) && (m <= 127)) {
                arrayOfByte[i] = ((byte) m);
                j += 1;
                i += 1;
            } else {
                writeUTF2(paramString, k, j);
                return;
            }
        }
        this.count = i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ByteStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */