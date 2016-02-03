package com.flurry.sdk;

import java.io.IOException;
import java.io.OutputStream;

public class gd
        extends gc {
    private byte[] a;
    private int b;
    private a c;
    private int d;

    gd(OutputStream paramOutputStream, int paramInt) {
        a(paramOutputStream, paramInt);
    }

    private void d(int paramInt)
            throws IOException {
        if (this.a.length - this.b < paramInt) {
            h();
        }
    }

    private void e(int paramInt)
            throws IOException {
        if (this.b == this.a.length) {
            h();
        }
        byte[] arrayOfByte = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfByte[i] = ((byte) (paramInt & 0xFF));
    }

    private void h()
            throws IOException {
        if (this.b > 0) {
            this.c.a(this.a, 0, this.b);
            this.b = 0;
        }
    }

    gd a(OutputStream paramOutputStream, int paramInt) {
        if (paramOutputStream == null) {
            throw new NullPointerException("OutputStream cannot be null!");
        }
        if ((this.c != null) && (this.b > 0)) {
        }
        try {
            h();
            this.c = new b(paramOutputStream, null);
            this.b = 0;
            if ((this.a == null) || (this.a.length != paramInt)) {
                this.a = new byte[paramInt];
            }
            this.d = (this.a.length >>> 1);
            if (this.d > 512) {
                this.d = 512;
            }
            return this;
        } catch (IOException paramOutputStream) {
            throw new fk("Failure flushing old output", paramOutputStream);
        }
    }

    public void a(double paramDouble)
            throws IOException {
        d(8);
        this.b += ga.a(paramDouble, this.a, this.b);
    }

    public void a(float paramFloat)
            throws IOException {
        d(4);
        this.b += ga.a(paramFloat, this.a, this.b);
    }

    public void a(boolean paramBoolean)
            throws IOException {
        if (this.a.length == this.b) {
            h();
        }
        this.b += ga.a(paramBoolean, this.a, this.b);
    }

    public void b(long paramLong)
            throws IOException {
        d(10);
        this.b += ga.a(paramLong, this.a, this.b);
    }

    public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws IOException {
        if (paramInt2 > this.d) {
            h();
            this.c.a(paramArrayOfByte, paramInt1, paramInt2);
            return;
        }
        d(paramInt2);
        System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
        this.b += paramInt2;
    }

    public void c(int paramInt)
            throws IOException {
        d(5);
        this.b += ga.a(paramInt, this.a, this.b);
    }

    public void flush()
            throws IOException {
        h();
        this.c.a();
    }

    protected void g()
            throws IOException {
        e(0);
    }

    static abstract class a {
        protected abstract void a()
                throws IOException;

        protected abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException;
    }

    static class b
            extends gd.a {
        private final OutputStream a;

        private b(OutputStream paramOutputStream) {
            this.a = paramOutputStream;
        }

        protected void a()
                throws IOException {
            this.a.flush();
        }

        protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException {
            this.a.write(paramArrayOfByte, paramInt1, paramInt2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */