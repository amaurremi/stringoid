package org.b.f;

import java.io.EOFException;
import java.math.BigInteger;

import org.b.c;
import org.b.e.ae;
import org.b.e.f;
import org.b.e.i;
import org.b.e.n;
import org.b.e.q;
import org.b.e.v;

public class g
        extends a {
    protected ae e;
    private final s f = new s();
    private Object[] g = new Object[''];

    public g(org.b.a parama, ae paramae) {
        super(parama);
        this.e = paramae;
    }

    private void v() {
        if (this.e == null) {
            this.e = g();
        }
    }

    private ae w() {
        v();
        this.f.a();
        if (this.f.d() == 0) {
            return this.e;
        }
        ae[] arrayOfae = (ae[]) this.g[this.f.d()];
        return arrayOfae[(arrayOfae.length - this.f.e())];
    }

    protected void a(org.b.c.g paramg) {
        if (paramg.c() != null) {
            paramg.e();
        }
        this.f.a();
        Object localObject = w();
        if ((!((ae) localObject).a()) && (!((ae) localObject).g())) {
            paramg.a((ae) localObject);
            this.f.b();
            if (this.f.d() == 0) {
                this.e = null;
            }
            if (paramg.c() != null) {
                return;
            }
        }
        for (; ; ) {
            this.f.a();
            localObject = w();
            if (((ae) localObject).a()) {
                localObject = ((ae) localObject).b();
                paramg.c(((f) localObject).size());
                this.f.b();
                this.f.a(((f) localObject).size());
                this.g[this.f.d()] = ((f) localObject).n();
            }
            while ((this.f.d() != 0) && (this.f.e() == 0)) {
                if (this.f.f()) {
                    paramg.c(true);
                    this.f.c();
                }
                for (; ; ) {
                    if (this.f.d() == 0) {
                        this.e = null;
                    }
                    if (paramg.c() == null) {
                        break;
                    }
                    return;
                    if (!this.f.g()) {
                        break label246;
                    }
                    paramg.d(true);
                    this.f.c();
                }
                label246:
                throw new RuntimeException("invalid stack");
                if (((ae) localObject).g()) {
                    localObject = ((ae) localObject).l();
                    paramg.d(((org.b.e.s) localObject).size());
                    this.f.b();
                    this.f.b(((org.b.e.s) localObject).size());
                    this.g[this.f.d()] = ((org.b.e.s) localObject).n();
                } else {
                    paramg.a((ae) localObject);
                    this.f.b();
                }
            }
        }
    }

    public void a(boolean paramBoolean) {
        if (!this.f.f()) {
            throw new c("readArrayEnd() is called but readArrayBegin() is not called");
        }
        int j = this.f.e();
        if (j > 0) {
            if (paramBoolean) {
                throw new c("readArrayEnd(check=true) is called but the array is not end");
            }
            int i = 0;
            while (i < j) {
                u();
                i += 1;
            }
        }
        this.f.c();
        if (this.f.d() == 0) {
            this.e = null;
        }
    }

    public void b(boolean paramBoolean) {
        if (!this.f.g()) {
            throw new c("readMapEnd() is called but readMapBegin() is not called");
        }
        int j = this.f.e();
        if (j > 0) {
            if (paramBoolean) {
                throw new c("readMapEnd(check=true) is called but the map is not end");
            }
            int i = 0;
            while (i < j) {
                u();
                i += 1;
            }
        }
        this.f.c();
        if (this.f.d() == 0) {
            this.e = null;
        }
    }

    public void close() {
    }

    public ae e() {
        if (this.f.d() == 0) {
            if (this.e == null) {
                return g();
            }
            ae localae = this.e;
            this.e = null;
            return localae;
        }
        return super.e();
    }

    public boolean f() {
        this.f.a();
        if (w().c()) {
            this.f.b();
            if (this.f.d() == 0) {
                this.e = null;
            }
            return true;
        }
        return false;
    }

    protected ae g() {
        throw new EOFException();
    }

    public boolean h() {
        v();
        if ((this.f.d() > 0) && (this.f.e() <= 0)) {
        }
        do {
            return true;
            if (!w().c()) {
                break;
            }
            this.f.b();
        } while (this.f.d() != 0);
        this.e = null;
        return true;
        return false;
    }

    public boolean i() {
        boolean bool = w().i().n();
        this.f.b();
        return bool;
    }

    public byte j() {
        byte b = w().j().n();
        this.f.b();
        if (this.f.d() == 0) {
            this.e = null;
        }
        return b;
    }

    public short k() {
        short s = w().j().o();
        this.f.b();
        if (this.f.d() == 0) {
            this.e = null;
        }
        return s;
    }

    public int l() {
        int i = w().j().p();
        this.f.b();
        if (this.f.d() == 0) {
            this.e = null;
        }
        return i;
    }

    public long m() {
        long l = w().j().q();
        this.f.b();
        if (this.f.d() == 0) {
            this.e = null;
        }
        return l;
    }

    public BigInteger n() {
        BigInteger localBigInteger = w().j().r();
        this.f.b();
        if (this.f.d() == 0) {
            this.e = null;
        }
        return localBigInteger;
    }

    public float o() {
        float f1 = w().k().n();
        this.f.b();
        if (this.f.d() == 0) {
            this.e = null;
        }
        return f1;
    }

    public double p() {
        double d = w().k().o();
        this.f.b();
        if (this.f.d() == 0) {
            this.e = null;
        }
        return d;
    }

    public byte[] q() {
        byte[] arrayOfByte = w().m().o();
        this.f.b();
        if (this.f.d() == 0) {
            this.e = null;
        }
        return arrayOfByte;
    }

    public String r() {
        String str = w().m().p();
        this.f.b();
        if (this.f.d() == 0) {
            this.e = null;
        }
        return str;
    }

    public int s() {
        Object localObject = w();
        if (!((ae) localObject).a()) {
            throw new c("Expected array but got not array value");
        }
        localObject = ((ae) localObject).b();
        this.f.b();
        this.f.a(((f) localObject).size());
        this.g[this.f.d()] = ((f) localObject).n();
        return ((f) localObject).size();
    }

    public int t() {
        Object localObject = w();
        if (!((ae) localObject).g()) {
            throw new c("Expected map but got not map value");
        }
        localObject = ((ae) localObject).l();
        this.f.b();
        this.f.b(((org.b.e.s) localObject).size());
        this.g[this.f.d()] = ((org.b.e.s) localObject).n();
        return ((org.b.e.s) localObject).size();
    }

    public void u() {
        this.f.a();
        Object localObject = w();
        if ((!((ae) localObject).a()) && (!((ae) localObject).g())) {
            this.f.b();
            if (this.f.d() == 0) {
                this.e = null;
            }
            return;
        }
        int i = this.f.d();
        for (; ; ) {
            if (this.f.e() == 0) {
                this.f.c();
                if (this.f.d() == 0) {
                    this.e = null;
                }
                if (this.f.d() > i) {
                }
            } else {
                this.f.a();
                localObject = w();
                if (((ae) localObject).a()) {
                    localObject = ((ae) localObject).b();
                    this.f.b();
                    this.f.a(((f) localObject).size());
                    this.g[this.f.d()] = ((f) localObject).n();
                } else if (((ae) localObject).g()) {
                    localObject = ((ae) localObject).l();
                    this.f.b();
                    this.f.b(((org.b.e.s) localObject).size());
                    this.g[this.f.d()] = ((org.b.e.s) localObject).n();
                } else {
                    this.f.b();
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */