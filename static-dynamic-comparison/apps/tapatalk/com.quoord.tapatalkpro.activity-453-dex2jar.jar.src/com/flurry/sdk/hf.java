package com.flurry.sdk;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class hf
        implements Closeable {
    protected ho a;

    public abstract hf a();

    public hf a(int paramInt) {
        return this;
    }

    public hf a(ho paramho) {
        this.a = paramho;
        return this;
    }

    public hf a(id paramid) {
        return this;
    }

    public abstract void a(char paramChar)
            throws IOException, he;

    public abstract void a(double paramDouble)
            throws IOException, he;

    public abstract void a(float paramFloat)
            throws IOException, he;

    public abstract void a(long paramLong)
            throws IOException, he;

    public abstract void a(ha paramha, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException, he;

    public abstract void a(hh paramhh)
            throws IOException, hk;

    public void a(hp paramhp)
            throws IOException, he {
        a(paramhp.a());
    }

    public void a(im paramim)
            throws IOException, he {
        a(paramim.a());
    }

    public abstract void a(Object paramObject)
            throws IOException, hk;

    public abstract void a(String paramString)
            throws IOException, he;

    public final void a(String paramString, int paramInt)
            throws IOException, he {
        a(paramString);
        b(paramInt);
    }

    public void a(String paramString1, String paramString2)
            throws IOException, he {
        a(paramString1);
        b(paramString2);
    }

    public final void a(String paramString, boolean paramBoolean)
            throws IOException, he {
        a(paramString);
        a(paramBoolean);
    }

    public abstract void a(BigDecimal paramBigDecimal)
            throws IOException, he;

    public abstract void a(BigInteger paramBigInteger)
            throws IOException, he;

    public abstract void a(boolean paramBoolean)
            throws IOException, he;

    public void a(byte[] paramArrayOfByte)
            throws IOException, he {
        a(hb.a(), paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public abstract void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he;

    public abstract void b()
            throws IOException, he;

    public abstract void b(int paramInt)
            throws IOException, he;

    public void b(hp paramhp)
            throws IOException, he {
        b(paramhp.a());
    }

    public abstract void b(String paramString)
            throws IOException, he;

    public abstract void b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException, he;

    public abstract void c()
            throws IOException, he;

    public abstract void c(String paramString)
            throws IOException, he;

    public abstract void close()
            throws IOException;

    public abstract void d()
            throws IOException, he;

    public abstract void d(String paramString)
            throws IOException, he;

    public abstract void e()
            throws IOException, he;

    public abstract void e(String paramString)
            throws IOException, he, UnsupportedOperationException;

    public abstract void f()
            throws IOException, he;

    public final void f(String paramString)
            throws IOException, he {
        a(paramString);
        b();
    }

    public abstract void g()
            throws IOException;

    public final void g(String paramString)
            throws IOException, he {
        a(paramString);
        d();
    }

    public static enum a {
        final boolean h;
        final int i;

        private a(boolean paramBoolean) {
            this.h = paramBoolean;
            this.i = (1 << ordinal());
        }

        public static int a() {
            int m = 0;
            a[] arrayOfa = values();
            int i1 = arrayOfa.length;
            int k = 0;
            while (k < i1) {
                a locala = arrayOfa[k];
                int n = m;
                if (locala.b()) {
                    n = m | locala.c();
                }
                k += 1;
                m = n;
            }
            return m;
        }

        public boolean b() {
            return this.h;
        }

        public int c() {
            return this.i;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */