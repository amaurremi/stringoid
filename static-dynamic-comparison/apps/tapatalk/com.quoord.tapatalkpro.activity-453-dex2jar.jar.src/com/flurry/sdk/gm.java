package com.flurry.sdk;

import java.io.IOException;
import java.nio.ByteBuffer;

public class gm
        extends gk
        implements gn.a {
    protected gf c;

    gm(gq paramgq, gf paramgf)
            throws IOException {
        super(paramgq);
        a(paramgf);
    }

    private void b(int paramInt)
            throws IOException {
        this.a.a(gq.k);
        gq.h localh = (gq.h) this.a.c();
        if (paramInt != localh.A) {
            throw new fl("Incorrect length for fixed binary: expected " + localh.A + " but received " + paramInt + " bytes.");
        }
    }

    public gm a(gf paramgf)
            throws IOException {
        this.a.e();
        this.c = paramgf;
        return this;
    }

    public gq a(gq paramgq1, gq paramgq2)
            throws IOException {
        return null;
    }

    public gy a(gy paramgy)
            throws IOException {
        this.a.a(gq.i);
        return this.c.a(paramgy);
    }

    public ByteBuffer a(ByteBuffer paramByteBuffer)
            throws IOException {
        this.a.a(gq.j);
        return this.c.a(paramByteBuffer);
    }

    protected void a()
            throws IOException {
        this.a.a(gq.k);
        gq.h localh = (gq.h) this.a.c();
        this.c.a(localh.A);
    }

    public void a(int paramInt)
            throws IOException {
        b(paramInt);
        this.c.a(paramInt);
    }

    public void b()
            throws IOException {
        this.a.a(gq.c);
        this.c.b();
    }

    public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        b(paramInt2);
        this.c.b(paramArrayOfByte, paramInt1, paramInt2);
    }

    public boolean c()
            throws IOException {
        this.a.a(gq.d);
        return this.c.c();
    }

    public int d()
            throws IOException {
        this.a.a(gq.e);
        return this.c.d();
    }

    public long e()
            throws IOException {
        this.a.a(gq.f);
        return this.c.e();
    }

    public float f()
            throws IOException {
        this.a.a(gq.g);
        return this.c.f();
    }

    public double g()
            throws IOException {
        this.a.a(gq.h);
        return this.c.g();
    }

    public String h()
            throws IOException {
        this.a.a(gq.i);
        return this.c.h();
    }

    public void i()
            throws IOException {
        this.a.a(gq.i);
        this.c.i();
    }

    public void j()
            throws IOException {
        this.a.a(gq.j);
        this.c.j();
    }

    public int k()
            throws IOException {
        this.a.a(gq.l);
        gq.h localh = (gq.h) this.a.c();
        int i = this.c.k();
        if ((i < 0) || (i >= localh.A)) {
            throw new fl("Enumeration out of range: max is " + localh.A + " but received " + i);
        }
        return i;
    }

    public long m()
            throws IOException {
        this.a.a(gq.n);
        long l = this.c.m();
        if (l == 0L) {
            this.a.a(gq.o);
        }
        return l;
    }

    public long n()
            throws IOException {
        this.a.b();
        long l = this.c.n();
        if (l == 0L) {
            this.a.a(gq.o);
        }
        return l;
    }

    public long o()
            throws IOException {
        this.a.a(gq.n);
        for (long l = this.c.o(); l != 0L; l = this.c.o()) {
            while (l > 0L) {
                this.a.f();
                l -= 1L;
            }
        }
        this.a.a(gq.o);
        return 0L;
    }

    public long p()
            throws IOException {
        this.a.a(gq.p);
        long l = this.c.p();
        if (l == 0L) {
            this.a.a(gq.q);
        }
        return l;
    }

    public long q()
            throws IOException {
        this.a.b();
        long l = this.c.q();
        if (l == 0L) {
            this.a.a(gq.q);
        }
        return l;
    }

    public long r()
            throws IOException {
        this.a.a(gq.p);
        for (long l = this.c.r(); l != 0L; l = this.c.r()) {
            while (l > 0L) {
                this.a.f();
                l -= 1L;
            }
        }
        this.a.a(gq.q);
        return 0L;
    }

    public int s()
            throws IOException {
        this.a.a(gq.m);
        gq.a locala = (gq.a) this.a.c();
        int i = this.c.s();
        this.a.c(locala.a(i));
        return i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */