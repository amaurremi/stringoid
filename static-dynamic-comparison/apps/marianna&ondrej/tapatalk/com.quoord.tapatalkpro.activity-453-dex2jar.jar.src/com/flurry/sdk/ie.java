package com.flurry.sdk;

public final class ie {
    protected final Object a;
    protected hc b;
    protected final boolean c;
    protected final si d;
    protected byte[] e = null;
    protected byte[] f = null;
    protected char[] g = null;
    protected char[] h = null;
    protected char[] i = null;

    public ie(si paramsi, Object paramObject, boolean paramBoolean) {
        this.d = paramsi;
        this.a = paramObject;
        this.c = paramBoolean;
    }

    public final Object a() {
        return this.a;
    }

    public void a(hc paramhc) {
        this.b = paramhc;
    }

    public final void a(byte[] paramArrayOfByte) {
        if (paramArrayOfByte != null) {
            if (paramArrayOfByte != this.e) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.e = null;
            this.d.a(si.a.a, paramArrayOfByte);
        }
    }

    public final void a(char[] paramArrayOfChar) {
        if (paramArrayOfChar != null) {
            if (paramArrayOfChar != this.g) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.g = null;
            this.d.a(si.b.a, paramArrayOfChar);
        }
    }

    public final char[] a(int paramInt) {
        if (this.i != null) {
            throw new IllegalStateException("Trying to call allocNameCopyBuffer() second time");
        }
        this.i = this.d.a(si.b.d, paramInt);
        return this.i;
    }

    public final hc b() {
        return this.b;
    }

    public final void b(byte[] paramArrayOfByte) {
        if (paramArrayOfByte != null) {
            if (paramArrayOfByte != this.f) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.f = null;
            this.d.a(si.a.b, paramArrayOfByte);
        }
    }

    public final void b(char[] paramArrayOfChar) {
        if (paramArrayOfChar != null) {
            if (paramArrayOfChar != this.h) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.h = null;
            this.d.a(si.b.b, paramArrayOfChar);
        }
    }

    public final void c(char[] paramArrayOfChar) {
        if (paramArrayOfChar != null) {
            if (paramArrayOfChar != this.i) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.i = null;
            this.d.a(si.b.d, paramArrayOfChar);
        }
    }

    public final boolean c() {
        return this.c;
    }

    public final sp d() {
        return new sp(this.d);
    }

    public final byte[] e() {
        if (this.e != null) {
            throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
        }
        this.e = this.d.a(si.a.a);
        return this.e;
    }

    public final byte[] f() {
        if (this.f != null) {
            throw new IllegalStateException("Trying to call allocWriteEncodingBuffer() second time");
        }
        this.f = this.d.a(si.a.b);
        return this.f;
    }

    public final char[] g() {
        if (this.g != null) {
            throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
        }
        this.g = this.d.a(si.b.a);
        return this.g;
    }

    public final char[] h() {
        if (this.h != null) {
            throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
        }
        this.h = this.d.a(si.b.b);
        return this.h;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */