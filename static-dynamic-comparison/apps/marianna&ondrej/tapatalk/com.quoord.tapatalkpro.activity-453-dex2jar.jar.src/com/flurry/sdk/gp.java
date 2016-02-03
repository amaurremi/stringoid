package com.flurry.sdk;

import java.io.IOException;

public class gp
        extends gn {
    private final a e;

    static {
        if (!gp.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            d = bool;
            return;
        }
    }

    public gp(gq paramgq, gn.a parama, a parama1)
            throws IOException {
        super(paramgq, parama);
        this.e = parama1;
    }

    public final void a(int paramInt)
            throws IOException {
        while (paramInt < this.c) {
            gq localgq = this.b[(this.c - 1)];
            if (localgq.a != gq.i.a) {
                if ((localgq.a == gq.i.f) || (localgq.a == gq.i.g)) {
                    this.e.l();
                } else {
                    this.c -= 1;
                    b(localgq);
                }
            } else {
                this.e.t();
            }
        }
    }

    public final void d(gq paramgq)
            throws IOException {
        int i = this.c;
        c(paramgq);
        a(i);
    }

    public final void f()
            throws IOException {
        int i = this.c;
        Object localObject = this.b;
        int j = this.c - 1;
        this.c = j;
        localObject = localObject[j];
        if ((!d) && (((gq) localObject).a != gq.i.d)) {
            throw new AssertionError();
        }
        b((gq) localObject);
        a(i);
    }

    public static abstract interface a {
        public abstract void l()
                throws IOException;

        public abstract void t()
                throws IOException;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */