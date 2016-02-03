package org.b.c;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import org.b.c;
import org.b.e.ae;
import org.b.e.af;

public class g
        extends a {
    private f b = new f();
    private Object[] c = new Object[''];
    private ae d;

    public g() {
        this(new org.b.a());
    }

    public g(org.b.a parama) {
        super(parama);
    }

    private void b(ae paramae) {
        if (this.b.d() <= 0) {
            this.d = paramae;
            return;
        }
        this.b.a();
        ae[] arrayOfae = (ae[]) this.c[this.b.d()];
        arrayOfae[(arrayOfae.length - this.b.e())] = paramae;
        this.b.b();
    }

    private void c(ae paramae) {
        if (this.b.d() <= 0) {
            this.c[0] = paramae;
            return;
        }
        this.b.a();
        ae[] arrayOfae = (ae[]) this.c[this.b.d()];
        arrayOfae[(arrayOfae.length - this.b.e())] = paramae;
        this.b.b();
    }

    public e a(ae paramae) {
        b(paramae);
        return this;
    }

    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        b(af.a(paramArrayOfByte, paramInt1, paramInt2));
    }

    public void b(byte paramByte) {
        b(af.a(paramByte));
    }

    public void b(double paramDouble) {
        b(af.a(paramDouble));
    }

    public void b(float paramFloat) {
        b(af.a(paramFloat));
    }

    public void b(int paramInt) {
        b(af.a(paramInt));
    }

    public void b(long paramLong) {
        b(af.a(paramLong));
    }

    public void b(String paramString) {
        b(af.a(paramString));
    }

    public void b(BigInteger paramBigInteger) {
        b(af.a(paramBigInteger));
    }

    public void b(ByteBuffer paramByteBuffer) {
        b(af.a(paramByteBuffer));
    }

    public void b(short paramShort) {
        b(af.a(paramShort));
    }

    public void b(boolean paramBoolean) {
        b(af.a(paramBoolean));
    }

    public e c(int paramInt) {
        if (paramInt == 0) {
            c(af.c());
            this.b.a(0);
            this.c[this.b.d()] = null;
            return this;
        }
        ae[] arrayOfae = new ae[paramInt];
        c(af.a(arrayOfae, true));
        this.b.a(paramInt);
        this.c[this.b.d()] = arrayOfae;
        return this;
    }

    public e c(boolean paramBoolean) {
        if (!this.b.f()) {
            throw new c("writeArrayEnd() is called but writeArrayBegin() is not called");
        }
        int j = this.b.e();
        if (j > 0) {
            if (paramBoolean) {
                throw new c("writeArrayEnd(check=true) is called but the array is not end");
            }
            int i = 0;
            while (i < j) {
                d();
                i += 1;
            }
        }
        this.b.c();
        if (this.b.d() <= 0) {
            this.d = ((ae) this.c[0]);
        }
        return this;
    }

    public ae c() {
        return this.d;
    }

    public void close() {
    }

    public e d() {
        b(af.a());
        return this;
    }

    public e d(int paramInt) {
        this.b.a();
        if (paramInt == 0) {
            c(af.d());
            this.b.b(0);
            this.c[this.b.d()] = null;
            return this;
        }
        ae[] arrayOfae = new ae[paramInt * 2];
        c(af.b(arrayOfae, true));
        this.b.b(paramInt);
        this.c[this.b.d()] = arrayOfae;
        return this;
    }

    public e d(boolean paramBoolean) {
        if (!this.b.g()) {
            throw new c("writeMapEnd() is called but writeMapBegin() is not called");
        }
        int j = this.b.e();
        if (j > 0) {
            if (paramBoolean) {
                throw new c("writeMapEnd(check=true) is called but the map is not end");
            }
            int i = 0;
            while (i < j) {
                d();
                i += 1;
            }
        }
        this.b.c();
        if (this.b.d() <= 0) {
            this.d = ((ae) this.c[0]);
        }
        return this;
    }

    public void e() {
        this.d = null;
    }

    public void flush() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */