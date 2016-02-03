package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.e;

public final class bm
        implements bn.a {
    private final ah kX;
    private final bq ky;
    private final Object li = new Object();
    private final Context mContext;
    private final String nn;
    private final long no;
    private final bi np;
    private final ak nq;
    private final dx nr;
    private br ns;
    private int nt = -2;

    public bm(Context paramContext, String paramString, bq parambq, bj parambj, bi parambi, ah paramah, ak paramak, dx paramdx) {
        this.mContext = paramContext;
        this.nn = paramString;
        this.ky = parambq;
        if (parambj.nd != -1L) {
        }
        for (long l = parambj.nd; ; l = 10000L) {
            this.no = l;
            this.np = parambi;
            this.kX = paramah;
            this.nq = paramak;
            this.nr = paramdx;
            return;
        }
    }

    private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
        for (; ; ) {
            if (this.nt != -2) {
                return;
            }
            b(paramLong1, paramLong2, paramLong3, paramLong4);
        }
    }

    private void a(bl parambl) {
        try {
            if (this.nr.rs < 4100000) {
                if (this.nq.lT) {
                    this.ns.a(e.h(this.mContext), this.kX, this.np.nb, parambl);
                    return;
                }
                this.ns.a(e.h(this.mContext), this.nq, this.kX, this.np.nb, parambl);
                return;
            }
        } catch (RemoteException parambl) {
            dw.c("Could not request ad from mediation adapter.", parambl);
            f(5);
            return;
        }
        if (this.nq.lT) {
            this.ns.a(e.h(this.mContext), this.kX, this.np.nb, this.np.mW, parambl);
            return;
        }
        this.ns.a(e.h(this.mContext), this.nq, this.kX, this.np.nb, this.np.mW, parambl);
    }

    private br aJ() {
        dw.x("Instantiating mediation adapter: " + this.nn);
        try {
            br localbr = this.ky.m(this.nn);
            return localbr;
        } catch (RemoteException localRemoteException) {
            dw.a("Could not instantiate mediation adapter: " + this.nn, localRemoteException);
        }
        return null;
    }

    private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
        long l = SystemClock.elapsedRealtime();
        paramLong1 = paramLong2 - (l - paramLong1);
        paramLong2 = paramLong4 - (l - paramLong3);
        if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
            dw.x("Timed out waiting for adapter.");
            this.nt = 3;
            return;
        }
        try {
            this.li.wait(Math.min(paramLong1, paramLong2));
            return;
        } catch (InterruptedException localInterruptedException) {
            this.nt = -1;
        }
    }

    public bn b(long paramLong1, long paramLong2) {
        synchronized (this.li) {
            long l = SystemClock.elapsedRealtime();
            final Object localObject2 = new bl();
            dv.rp.post(new Runnable() {
                public void run() {
                    synchronized (bm.a(bm.this)) {
                        if (bm.b(bm.this) != -2) {
                            return;
                        }
                        bm.a(bm.this, bm.c(bm.this));
                        if (bm.d(bm.this) == null) {
                            bm.this.f(4);
                            return;
                        }
                    }
                    localObject2.a(bm.this);
                    bm.a(bm.this, localObject2);
                }
            });
            a(l, this.no, paramLong1, paramLong2);
            localObject2 = new bn(this.np, this.ns, this.nn, (bl) localObject2, this.nt);
            return (bn) localObject2;
        }
    }

    public void cancel() {
        synchronized (this.li) {
            try {
                if (this.ns != null) {
                    this.ns.destroy();
                }
                this.nt = -1;
                this.li.notify();
                return;
            } catch (RemoteException localRemoteException) {
                for (; ; ) {
                    dw.c("Could not destroy mediation adapter.", localRemoteException);
                }
            }
        }
    }

    public void f(int paramInt) {
        synchronized (this.li) {
            this.nt = paramInt;
            this.li.notify();
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */