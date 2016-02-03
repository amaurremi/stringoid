package com.flurry.sdk;

import java.io.IOException;

public class gl
        extends gm {
    private gf d;

    static {
        if (!gl.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            b = bool;
            return;
        }
    }

    gl(fn paramfn1, fn paramfn2, gf paramgf)
            throws IOException {
        this(a(paramfn1, paramfn2), paramgf);
    }

    private gl(Object paramObject, gf paramgf)
            throws IOException {
        super((gq) paramObject, paramgf);
    }

    public static Object a(fn paramfn1, fn paramfn2)
            throws IOException {
        if (paramfn1 == null) {
            throw new NullPointerException("writer cannot be null!");
        }
        if (paramfn2 == null) {
            throw new NullPointerException("reader cannot be null!");
        }
        return new go().a(paramfn1, paramfn2);
    }

    public gq a(gq paramgq1, gq paramgq2)
            throws IOException {
        if ((paramgq2 instanceof gq.e)) {
            if (paramgq1 == gq.s) {
                return paramgq2;
            }
            return null;
        }
        if ((paramgq2 instanceof gq.k)) {
            paramgq2 = (gq.k) paramgq2;
            if (paramgq2.B != paramgq1) {
                throw new fl("Found " + paramgq2.B + " while looking for " + paramgq1);
            }
            return paramgq2.z;
        }
        if ((paramgq2 instanceof gq.n)) {
            paramgq1 = ((gq.n) paramgq2).z;
            this.a.d(paramgq1);
        }
        for (; ; ) {
            return null;
            if ((paramgq2 instanceof gq.q)) {
                paramgq1 = (gq.a) this.a.c();
                this.a.c(paramgq1.a(this.c.s()));
            } else {
                if ((paramgq2 instanceof gq.d)) {
                    throw new fl(((gq.d) paramgq2).z);
                }
                if ((paramgq2 instanceof gq.b)) {
                    paramgq1 = (gq.b) paramgq2;
                    this.d = this.c;
                    this.c = gg.a().a(paramgq1.z, null);
                } else {
                    if (paramgq2 != gq.x) {
                        break;
                    }
                    this.c = this.d;
                }
            }
        }
        throw new fl("Unknown action: " + paramgq2);
    }

    public long e()
            throws IOException {
        gq localgq = this.a.a(gq.f);
        if (localgq == gq.e) {
            return this.c.d();
        }
        if (localgq == gq.h) {
            return this.c.g();
        }
        if ((!b) && (localgq != gq.f)) {
            throw new AssertionError();
        }
        return this.c.e();
    }

    public float f()
            throws IOException {
        gq localgq = this.a.a(gq.g);
        if (localgq == gq.e) {
            return this.c.d();
        }
        if (localgq == gq.f) {
            return (float) this.c.e();
        }
        if ((!b) && (localgq != gq.g)) {
            throw new AssertionError();
        }
        return this.c.f();
    }

    public double g()
            throws IOException {
        gq localgq = this.a.a(gq.h);
        if (localgq == gq.e) {
            return this.c.d();
        }
        if (localgq == gq.f) {
            return this.c.e();
        }
        if (localgq == gq.g) {
            return this.c.f();
        }
        if ((!b) && (localgq != gq.h)) {
            throw new AssertionError();
        }
        return this.c.g();
    }

    public int k()
            throws IOException {
        this.a.a(gq.l);
        Object localObject = (gq.c) this.a.c();
        int i = this.c.k();
        localObject = localObject.z[i];
        if ((localObject instanceof Integer)) {
            return ((Integer) localObject).intValue();
        }
        throw new fl((String) localObject);
    }

    public void l()
            throws IOException {
        Object localObject = this.a.c();
        if ((localObject instanceof gq.k)) {
            this.a.c(((gq.k) localObject).z);
        }
        do {
            return;
            if ((localObject instanceof gq.n)) {
                this.a.c(((gq.n) localObject).z);
                return;
            }
            if ((localObject instanceof gq.q)) {
                localObject = (gq.a) this.a.c();
                this.a.c(((gq.a) localObject).a(this.c.s()));
                return;
            }
            if ((localObject instanceof gq.d)) {
                throw new fl(((gq.d) localObject).z);
            }
            if ((localObject instanceof gq.b)) {
                localObject = (gq.b) localObject;
                this.d = this.c;
                this.c = gg.a().a(((gq.b) localObject).z, null);
                return;
            }
        } while (localObject != gq.x);
        this.c = this.d;
    }

    public int s()
            throws IOException {
        this.a.a(gq.m);
        gq.p localp = (gq.p) this.a.c();
        this.a.c(localp.B);
        return localp.z;
    }

    public final fn.f[] u()
            throws IOException {
        return ((gq.e) this.a.a(gq.s)).z;
    }

    public final void v()
            throws IOException {
        this.a.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */