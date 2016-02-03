package com.flurry.sdk;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class hj
        implements Closeable {
    protected int a;
    protected hm b;
    protected hm c;

    protected hj() {
    }

    protected hj(int paramInt) {
        this.a = paramInt;
    }

    protected hi a(String paramString) {
        return new hi(paramString, i());
    }

    public abstract hn a();

    public boolean a(a parama) {
        return (this.a & parama.c()) != 0;
    }

    public abstract byte[] a(ha paramha)
            throws IOException, hi;

    public abstract hm b()
            throws IOException, hi;

    public hm c()
            throws IOException, hi {
        hm localhm2 = b();
        hm localhm1 = localhm2;
        if (localhm2 == hm.f) {
            localhm1 = b();
        }
        return localhm1;
    }

    public abstract void close()
            throws IOException;

    public abstract hj d()
            throws IOException, hi;

    public hm e() {
        return this.b;
    }

    public void f() {
        if (this.b != null) {
            this.c = this.b;
            this.b = null;
        }
    }

    public abstract String g()
            throws IOException, hi;

    public abstract hg h();

    public abstract hg i();

    public boolean j() {
        return e() == hm.d;
    }

    public abstract String k()
            throws IOException, hi;

    public abstract char[] l()
            throws IOException, hi;

    public abstract int m()
            throws IOException, hi;

    public abstract int n()
            throws IOException, hi;

    public boolean o() {
        return false;
    }

    public abstract Number p()
            throws IOException, hi;

    public abstract b q()
            throws IOException, hi;

    public byte r()
            throws IOException, hi {
        int i = t();
        if ((i < -128) || (i > 127)) {
            throw a("Numeric value (" + k() + ") out of range of Java byte");
        }
        return (byte) i;
    }

    public short s()
            throws IOException, hi {
        int i = t();
        if ((i < 32768) || (i > 32767)) {
            throw a("Numeric value (" + k() + ") out of range of Java short");
        }
        return (short) i;
    }

    public abstract int t()
            throws IOException, hi;

    public abstract long u()
            throws IOException, hi;

    public abstract BigInteger v()
            throws IOException, hi;

    public abstract float w()
            throws IOException, hi;

    public abstract double x()
            throws IOException, hi;

    public abstract BigDecimal y()
            throws IOException, hi;

    public Object z()
            throws IOException, hi {
        return null;
    }

    public static enum a {
        final boolean k;

        private a(boolean paramBoolean) {
            this.k = paramBoolean;
        }

        public static int a() {
            int n = 0;
            a[] arrayOfa = values();
            int i2 = arrayOfa.length;
            int m = 0;
            while (m < i2) {
                a locala = arrayOfa[m];
                int i1 = n;
                if (locala.b()) {
                    i1 = n | locala.c();
                }
                m += 1;
                n = i1;
            }
            return n;
        }

        public boolean a(int paramInt) {
            return (c() & paramInt) != 0;
        }

        public boolean b() {
            return this.k;
        }

        public int c() {
            return 1 << ordinal();
        }
    }

    public static enum b {
        private b() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */