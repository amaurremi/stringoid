package com.flurry.sdk;

import java.io.IOException;

public class gn {
    protected final a a;
    protected gq[] b;
    protected int c;

    public gn(gq paramgq, a parama)
            throws IOException {
        this.a = parama;
        this.b = new gq[5];
        this.b[0] = paramgq;
        this.c = 1;
    }

    private void f() {
        gq[] arrayOfgq = new gq[this.b.length + Math.max(this.b.length, 1024)];
        System.arraycopy(this.b, 0, arrayOfgq, 0, this.b.length);
        this.b = arrayOfgq;
    }

    public final gq a(gq paramgq)
            throws IOException {
        for (; ; ) {
            Object localObject = this.b;
            int i = this.c - 1;
            this.c = i;
            localObject = localObject[i];
            if (localObject == paramgq) {
                return (gq) localObject;
            }
            gq.i locali = ((gq) localObject).a;
            if (locali == gq.i.f) {
                localObject = this.a.a(paramgq, (gq) localObject);
                if (localObject != null) {
                    return (gq) localObject;
                }
            } else {
                if (locali == gq.i.a) {
                    throw new fl("Attempt to process a " + paramgq + " when a " + localObject + " was expected.");
                }
                if ((locali == gq.i.d) && (paramgq == ((gq.j) localObject).z)) {
                    return paramgq;
                }
                b((gq) localObject);
            }
        }
    }

    public final void a()
            throws IOException {
        while (this.c > 1) {
            gq localgq = this.b[(this.c - 1)];
            if (localgq.a == gq.i.f) {
                this.c -= 1;
                this.a.a(null, localgq);
            } else {
                if (localgq.a == gq.i.a) {
                    break;
                }
                this.c -= 1;
                b(localgq);
            }
        }
    }

    public final void b()
            throws IOException {
        while (this.c >= 1) {
            gq localgq = this.b[(this.c - 1)];
            if ((localgq.a != gq.i.f) || (!((gq.g) localgq).A)) {
                break;
            }
            this.c -= 1;
            this.a.a(null, localgq);
        }
    }

    public final void b(gq paramgq) {
        paramgq = paramgq.b;
        while (this.c + paramgq.length > this.b.length) {
            f();
        }
        System.arraycopy(paramgq, 0, this.b, this.c, paramgq.length);
        int i = this.c;
        this.c = (paramgq.length + i);
    }

    public gq c() {
        gq[] arrayOfgq = this.b;
        int i = this.c - 1;
        this.c = i;
        return arrayOfgq[i];
    }

    public void c(gq paramgq) {
        if (this.c == this.b.length) {
            f();
        }
        gq[] arrayOfgq = this.b;
        int i = this.c;
        this.c = (i + 1);
        arrayOfgq[i] = paramgq;
    }

    public gq d() {
        return this.b[(this.c - 1)];
    }

    public void e() {
        this.c = 1;
    }

    public static abstract interface a {
        public abstract gq a(gq paramgq1, gq paramgq2)
                throws IOException;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */