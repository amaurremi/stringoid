package org.b.f;

import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;

import org.b.b.e;
import org.b.c.g;

public class m
        extends a {
    protected final e e;
    private final s f = new s();
    private byte g = -63;
    private byte[] h;
    private int i;
    private final i j = new i();
    private final j k = new j();
    private final d l = new d();
    private final h m = new h();
    private final f n = new f();
    private final p o = new p();
    private final c p = new c();
    private final k q = new k();
    private final t r = new t();
    private final o s = new o();

    protected m(org.b.a parama, e parame) {
        super(parama);
        this.e = parame;
    }

    private void a(int paramInt) {
        this.h = new byte[paramInt];
        this.i = 0;
        v();
    }

    private boolean a(org.b.b.b paramb, int paramInt) {
        return this.e.a(paramb, paramInt);
    }

    private boolean a(b paramb, int paramInt) {
        switch (paramInt & 0xFF) {
            case 193:
            case 199:
            case 200:
            case 201:
            case 212:
            case 213:
            case 214:
            case 215:
            case 216:
            default:
                this.g = -63;
                throw new IOException("Invalid byte: " + paramInt);
            case 192:
                paramb.b();
                this.g = -63;
                return true;
            case 194:
                paramb.a(false);
                this.g = -63;
                return true;
            case 195:
                paramb.a(true);
                this.g = -63;
                return true;
            case 202:
                paramb.a(this.e.h());
                this.e.c();
                this.g = -63;
                return true;
            case 203:
                paramb.a(this.e.i());
                this.e.c();
                this.g = -63;
                return true;
            case 204:
                paramb.b(this.e.d());
                this.e.c();
                this.g = -63;
                return true;
            case 205:
                paramb.b(this.e.e());
                this.e.c();
                this.g = -63;
                return true;
            case 206:
                paramb.b(this.e.f());
                this.e.c();
                this.g = -63;
                return true;
            case 207:
                paramb.b(this.e.g());
                this.e.c();
                this.g = -63;
                return true;
            case 208:
                paramb.a(this.e.d());
                this.e.c();
                this.g = -63;
                return true;
            case 209:
                paramb.a(this.e.e());
                this.e.c();
                this.g = -63;
                return true;
            case 210:
                paramb.a(this.e.f());
                this.e.c();
                this.g = -63;
                return true;
            case 211:
                paramb.a(this.e.g());
                this.e.c();
                this.g = -63;
                return true;
            case 196:
            case 217:
                paramInt = this.e.d();
                if (paramInt == 0) {
                    paramb.a();
                    this.e.c();
                    this.g = -63;
                    return true;
                }
                if (paramInt >= this.b) {
                    throw new n(String.format("Size of raw (%d) over limit at %d", new Object[]{Integer.valueOf(paramInt), Integer.valueOf(this.b)}));
                }
                this.e.c();
                if (!a(paramb, paramInt)) {
                    a(paramInt);
                    paramb.a(this.h);
                    this.h = null;
                }
                this.g = -63;
                return true;
            case 197:
            case 218:
                paramInt = this.e.e() & 0xFFFF;
                if (paramInt == 0) {
                    paramb.a();
                    this.e.c();
                    this.g = -63;
                    return true;
                }
                if (paramInt >= this.b) {
                    throw new n(String.format("Size of raw (%d) over limit at %d", new Object[]{Integer.valueOf(paramInt), Integer.valueOf(this.b)}));
                }
                this.e.c();
                if (!a(paramb, paramInt)) {
                    a(paramInt);
                    paramb.a(this.h);
                    this.h = null;
                }
                this.g = -63;
                return true;
            case 198:
            case 219:
                paramInt = this.e.f();
                if (paramInt == 0) {
                    paramb.a();
                    this.e.c();
                    this.g = -63;
                    return true;
                }
                if ((paramInt < 0) || (paramInt >= this.b)) {
                    throw new n(String.format("Size of raw (%d) over limit at %d", new Object[]{Integer.valueOf(paramInt), Integer.valueOf(this.b)}));
                }
                this.e.c();
                if (!a(paramb, paramInt)) {
                    a(paramInt);
                    paramb.a(this.h);
                    this.h = null;
                }
                this.g = -63;
                return true;
            case 220:
                paramInt = this.e.e() & 0xFFFF;
                if (paramInt >= this.c) {
                    throw new n(String.format("Size of array (%d) over limit at %d", new Object[]{Integer.valueOf(paramInt), Integer.valueOf(this.c)}));
                }
                paramb.c(paramInt);
                this.f.b();
                this.f.a(paramInt);
                this.e.c();
                this.g = -63;
                return false;
            case 221:
                paramInt = this.e.f();
                if ((paramInt < 0) || (paramInt >= this.c)) {
                    throw new n(String.format("Size of array (%d) over limit at %d", new Object[]{Integer.valueOf(paramInt), Integer.valueOf(this.c)}));
                }
                paramb.c(paramInt);
                this.f.b();
                this.f.a(paramInt);
                this.e.c();
                this.g = -63;
                return false;
            case 222:
                paramInt = this.e.e() & 0xFFFF;
                if (paramInt >= this.d) {
                    throw new n(String.format("Size of map (%d) over limit at %d", new Object[]{Integer.valueOf(paramInt), Integer.valueOf(this.d)}));
                }
                paramb.d(paramInt);
                this.f.b();
                this.f.b(paramInt);
                this.e.c();
                this.g = -63;
                return false;
        }
        paramInt = this.e.f();
        if ((paramInt < 0) || (paramInt >= this.d)) {
            throw new n(String.format("Size of map (%d) over limit at %d", new Object[]{Integer.valueOf(paramInt), Integer.valueOf(this.d)}));
        }
        paramb.d(paramInt);
        this.f.b();
        this.f.b(paramInt);
        this.e.c();
        this.g = -63;
        return false;
    }

    private byte g() {
        byte b2 = this.g;
        byte b1 = b2;
        if (b2 == -63) {
            b1 = this.e.b();
            this.g = b1;
        }
        return b1;
    }

    private void v() {
        this.i = (this.e.a(this.h, this.i, this.h.length - this.i) + this.i);
        if (this.i < this.h.length) {
            throw new EOFException();
        }
    }

    protected void a(g paramg) {
        if (paramg.c() != null) {
            paramg.e();
        }
        this.r.a(paramg);
        this.f.a();
        if (b(this.r)) {
            this.f.b();
            if (paramg.c() != null) {
                return;
                a(this.r);
            }
        }
        while (this.f.e() == 0) {
            if (this.f.f()) {
                paramg.c(true);
                this.f.c();
            }
            while (paramg.c() != null) {
                return;
                if (!this.f.g()) {
                    break label127;
                }
                paramg.d(true);
                this.f.c();
            }
        }
        label127:
        throw new RuntimeException("invalid stack");
    }

    final void a(b paramb) {
        this.f.a();
        if (b(paramb)) {
            this.f.b();
        }
    }

    public void a(boolean paramBoolean) {
        if (!this.f.f()) {
            throw new org.b.c("readArrayEnd() is called but readArrayBegin() is not called");
        }
        int i2 = this.f.e();
        if (i2 > 0) {
            if (paramBoolean) {
                throw new org.b.c("readArrayEnd(check=true) is called but the array is not end");
            }
            int i1 = 0;
            while (i1 < i2) {
                u();
                i1 += 1;
            }
        }
        this.f.c();
    }

    public void b(boolean paramBoolean) {
        if (!this.f.g()) {
            throw new org.b.c("readMapEnd() is called but readMapBegin() is not called");
        }
        int i2 = this.f.e();
        if (i2 > 0) {
            if (paramBoolean) {
                throw new org.b.c("readMapEnd(check=true) is called but the map is not end");
            }
            int i1 = 0;
            while (i1 < i2) {
                u();
                i1 += 1;
            }
        }
        this.f.c();
    }

    final boolean b(b paramb) {
        if (this.h != null) {
            v();
            paramb.a(this.h);
            this.h = null;
            this.g = -63;
            return true;
        }
        int i1 = g();
        if ((i1 & 0x80) == 0) {
            paramb.a(i1);
            this.g = -63;
            return true;
        }
        if ((i1 & 0xE0) == 224) {
            paramb.a(i1);
            this.g = -63;
            return true;
        }
        if ((i1 & 0xE0) == 160) {
            i1 &= 0x1F;
            if (i1 == 0) {
                paramb.a();
                this.g = -63;
                return true;
            }
            if (!a(paramb, i1)) {
                a(i1);
                paramb.a(this.h);
                this.h = null;
            }
            this.g = -63;
            return true;
        }
        if ((i1 & 0xF0) == 144) {
            i1 &= 0xF;
            paramb.c(i1);
            this.f.b();
            this.f.a(i1);
            this.g = -63;
            return false;
        }
        if ((i1 & 0xF0) == 128) {
            i1 &= 0xF;
            paramb.d(i1);
            this.f.b();
            this.f.b(i1);
            this.g = -63;
            return false;
        }
        return a(paramb, i1);
    }

    public void close() {
        this.e.close();
    }

    protected boolean f() {
        this.f.a();
        if ((g() & 0xFF) == 192) {
            this.f.b();
            this.g = -63;
            return true;
        }
        return false;
    }

    public boolean h() {
        if ((this.f.d() > 0) && (this.f.e() <= 0)) {
            return true;
        }
        if ((g() & 0xFF) == 192) {
            this.f.b();
            this.g = -63;
            return true;
        }
        return false;
    }

    public boolean i() {
        this.f.a();
        int i1 = g() & 0xFF;
        if (i1 == 194) {
            this.f.b();
            this.g = -63;
            return false;
        }
        if (i1 == 195) {
            this.f.b();
            this.g = -63;
            return true;
        }
        throw new org.b.c("Expected Boolean but got not boolean value");
    }

    public byte j() {
        this.f.a();
        b(this.j);
        int i1 = this.j.a;
        if ((i1 < -128) || (i1 > 127)) {
            throw new org.b.c();
        }
        this.f.b();
        return (byte) i1;
    }

    public short k() {
        this.f.a();
        b(this.j);
        int i1 = this.j.a;
        if ((i1 < 32768) || (i1 > 32767)) {
            throw new org.b.c();
        }
        this.f.b();
        return (short) i1;
    }

    public int l() {
        a(this.j);
        return this.j.a;
    }

    public long m() {
        a(this.k);
        return this.k.a;
    }

    public BigInteger n() {
        a(this.l);
        return this.l.a;
    }

    public float o() {
        a(this.m);
        return (float) this.m.a;
    }

    public double p() {
        a(this.m);
        return this.m.a;
    }

    public byte[] q() {
        a(this.n);
        return this.n.a;
    }

    public String r() {
        a(this.o);
        return this.o.a;
    }

    public int s() {
        a(this.p);
        return this.p.a;
    }

    public int t() {
        a(this.q);
        return this.q.a;
    }

    public void u() {
        this.f.a();
        if (b(this.s)) {
            this.f.b();
            return;
        }
        int i1 = this.f.d();
        for (; ; ) {
            if (this.f.e() == 0) {
                this.f.c();
                if (this.f.d() > i1 - 1) {
                }
            } else {
                a(this.s);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */