package org.b.c;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import org.b.b.i;
import org.b.c;

public class d
        extends a {
    protected final i b;
    private f c = new f();

    protected d(org.b.a parama, i parami) {
        super(parama);
        this.b = parami;
    }

    protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        if (paramInt2 < 32) {
            this.b.a((byte) (paramInt2 | 0xA0));
        }
        for (; ; ) {
            this.b.a(paramArrayOfByte, paramInt1, paramInt2);
            this.c.b();
            return;
            if (paramInt2 < 65536) {
                this.b.a((byte) -38, (short) paramInt2);
            } else {
                this.b.a((byte) -37, paramInt2);
            }
        }
    }

    protected void b(byte paramByte) {
        if (paramByte < -32) {
            this.b.a((byte) -48, paramByte);
        }
        for (; ; ) {
            this.c.b();
            return;
            this.b.a(paramByte);
        }
    }

    protected void b(double paramDouble) {
        this.b.a((byte) -53, paramDouble);
        this.c.b();
    }

    protected void b(float paramFloat) {
        this.b.a((byte) -54, paramFloat);
        this.c.b();
    }

    protected void b(int paramInt) {
        if (paramInt < -32) {
            if (paramInt < 32768) {
                this.b.a((byte) -46, paramInt);
            }
        }
        for (; ; ) {
            this.c.b();
            return;
            if (paramInt < -128) {
                this.b.a((byte) -47, (short) paramInt);
            } else {
                this.b.a((byte) -48, (byte) paramInt);
                continue;
                if (paramInt < 128) {
                    this.b.a((byte) paramInt);
                } else if (paramInt < 256) {
                    this.b.a((byte) -52, (byte) paramInt);
                } else if (paramInt < 65536) {
                    this.b.a((byte) -51, (short) paramInt);
                } else {
                    this.b.a((byte) -50, paramInt);
                }
            }
        }
    }

    protected void b(long paramLong) {
        if (paramLong < -32L) {
            if (paramLong < -32768L) {
                if (paramLong < -2147483648L) {
                    this.b.a((byte) -45, paramLong);
                }
            }
        }
        for (; ; ) {
            this.c.b();
            return;
            this.b.a((byte) -46, (int) paramLong);
            continue;
            if (paramLong < -128L) {
                this.b.a((byte) -47, (short) (int) paramLong);
            } else {
                this.b.a((byte) -48, (byte) (int) paramLong);
                continue;
                if (paramLong < 128L) {
                    this.b.a((byte) (int) paramLong);
                } else if (paramLong < 65536L) {
                    if (paramLong < 256L) {
                        this.b.a((byte) -52, (byte) (int) paramLong);
                    } else {
                        this.b.a((byte) -51, (short) (int) paramLong);
                    }
                } else if (paramLong < 4294967296L) {
                    this.b.a((byte) -50, (int) paramLong);
                } else {
                    this.b.a((byte) -49, paramLong);
                }
            }
        }
    }

    protected void b(String paramString) {
        try {
            paramString = paramString.getBytes("UTF-8");
            a(paramString, 0, paramString.length);
            this.c.b();
            return;
        } catch (UnsupportedEncodingException paramString) {
            throw new c(paramString);
        }
    }

    protected void b(BigInteger paramBigInteger) {
        if (paramBigInteger.bitLength() <= 63) {
            b(paramBigInteger.longValue());
            this.c.b();
            return;
        }
        if ((paramBigInteger.bitLength() == 64) && (paramBigInteger.signum() == 1)) {
            this.b.a((byte) -49, paramBigInteger.longValue());
            this.c.b();
            return;
        }
        throw new c("MessagePack can't serialize BigInteger larger than (2^64)-1");
    }

    /* Error */
    protected void b(java.nio.ByteBuffer paramByteBuffer) {
        // Byte code:
        //   0: aload_1
        //   1: invokevirtual 116	java/nio/ByteBuffer:remaining	()I
        //   4: istore_2
        //   5: iload_2
        //   6: bipush 32
        //   8: if_icmpge +47 -> 55
        //   11: aload_0
        //   12: getfield 22	org/b/c/d:b	Lorg/b/b/i;
        //   15: iload_2
        //   16: sipush 160
        //   19: ior
        //   20: i2b
        //   21: invokeinterface 30 2 0
        //   26: aload_1
        //   27: invokevirtual 119	java/nio/ByteBuffer:position	()I
        //   30: istore_2
        //   31: aload_0
        //   32: getfield 22	org/b/c/d:b	Lorg/b/b/i;
        //   35: aload_1
        //   36: invokeinterface 121 2 0
        //   41: aload_1
        //   42: iload_2
        //   43: invokevirtual 124	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
        //   46: pop
        //   47: aload_0
        //   48: getfield 20	org/b/c/d:c	Lorg/b/c/f;
        //   51: invokevirtual 34	org/b/c/f:b	()V
        //   54: return
        //   55: iload_2
        //   56: ldc 35
        //   58: if_icmpge +19 -> 77
        //   61: aload_0
        //   62: getfield 22	org/b/c/d:b	Lorg/b/b/i;
        //   65: bipush -38
        //   67: iload_2
        //   68: i2s
        //   69: invokeinterface 38 3 0
        //   74: goto -48 -> 26
        //   77: aload_0
        //   78: getfield 22	org/b/c/d:b	Lorg/b/b/i;
        //   81: bipush -37
        //   83: iload_2
        //   84: invokeinterface 41 3 0
        //   89: goto -63 -> 26
        //   92: astore_3
        //   93: aload_1
        //   94: iload_2
        //   95: invokevirtual 124	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
        //   98: pop
        //   99: aload_3
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	d
        //   0	101	1	paramByteBuffer	java.nio.ByteBuffer
        //   4	91	2	i	int
        //   92	8	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   31	41	92	finally
    }

    protected void b(short paramShort) {
        if (paramShort < -32) {
            if (paramShort < -128) {
                this.b.a((byte) -47, paramShort);
            }
        }
        for (; ; ) {
            this.c.b();
            return;
            this.b.a((byte) -48, (byte) paramShort);
            continue;
            if (paramShort < 128) {
                this.b.a((byte) paramShort);
            } else if (paramShort < 256) {
                this.b.a((byte) -52, (byte) paramShort);
            } else {
                this.b.a((byte) -51, paramShort);
            }
        }
    }

    protected void b(boolean paramBoolean) {
        if (paramBoolean) {
            this.b.a((byte) -61);
        }
        for (; ; ) {
            this.c.b();
            return;
            this.b.a((byte) -62);
        }
    }

    public e c(int paramInt) {
        if (paramInt < 16) {
            this.b.a((byte) (paramInt | 0x90));
        }
        for (; ; ) {
            this.c.b();
            this.c.a(paramInt);
            return this;
            if (paramInt < 65536) {
                this.b.a((byte) -36, (short) paramInt);
            } else {
                this.b.a((byte) -35, paramInt);
            }
        }
    }

    public e c(boolean paramBoolean) {
        if (!this.c.f()) {
            throw new c("writeArrayEnd() is called but writeArrayBegin() is not called");
        }
        int j = this.c.e();
        if (j > 0) {
            if (paramBoolean) {
                throw new c("writeArrayEnd(check=true) is called but the array is not end: " + j);
            }
            int i = 0;
            while (i < j) {
                d();
                i += 1;
            }
        }
        this.c.c();
        return this;
    }

    public void close() {
        this.b.close();
    }

    public e d() {
        this.b.a((byte) -64);
        this.c.b();
        return this;
    }

    public e d(int paramInt) {
        if (paramInt < 16) {
            this.b.a((byte) (paramInt | 0x80));
        }
        for (; ; ) {
            this.c.b();
            this.c.b(paramInt);
            return this;
            if (paramInt < 65536) {
                this.b.a((byte) -34, (short) paramInt);
            } else {
                this.b.a((byte) -33, paramInt);
            }
        }
    }

    public e d(boolean paramBoolean) {
        if (!this.c.g()) {
            throw new c("writeMapEnd() is called but writeMapBegin() is not called");
        }
        int j = this.c.e();
        if (j > 0) {
            if (paramBoolean) {
                throw new c("writeMapEnd(check=true) is called but the map is not end: " + j);
            }
            int i = 0;
            while (i < j) {
                d();
                i += 1;
            }
        }
        this.c.c();
        return this;
    }

    public void flush() {
        this.b.flush();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */