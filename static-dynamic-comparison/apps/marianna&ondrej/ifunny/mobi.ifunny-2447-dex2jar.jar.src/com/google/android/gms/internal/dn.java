package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.b.d;

@ii
public final class dn
        implements dq {
    private final String a;
    private final dt b;
    private final long c;
    private final dh d;
    private final av e;
    private final ay f;
    private final Context g;
    private final Object h = new Object();
    private final gt i;
    private dx j;
    private int k = -2;

    public dn(Context paramContext, String paramString, dt paramdt, di paramdi, dh paramdh, av paramav, ay paramay, gt paramgt) {
        this.g = paramContext;
        this.b = paramdt;
        this.d = paramdh;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString)) {
            this.a = b();
            if (paramdi.b == -1L) {
                break label106;
            }
        }
        label106:
        for (long l = paramdi.b; ; l = 10000L) {
            this.c = l;
            this.e = paramav;
            this.f = paramay;
            this.i = paramgt;
            return;
            this.a = paramString;
            break;
        }
    }

    private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
        for (; ; ) {
            if (this.k != -2) {
                return;
            }
            b(paramLong1, paramLong2, paramLong3, paramLong4);
        }
    }

    private void a(dl paramdl) {
        try {
            if (this.i.d < 4100000) {
                if (this.f.e) {
                    this.j.a(d.a(this.g), this.e, this.d.g, paramdl);
                    return;
                }
                this.j.a(d.a(this.g), this.f, this.e, this.d.g, paramdl);
                return;
            }
        } catch (RemoteException paramdl) {
            mx.d("Could not request ad from mediation adapter.", paramdl);
            a(5);
            return;
        }
        if (this.f.e) {
            this.j.a(d.a(this.g), this.e, this.d.g, this.d.a, paramdl);
            return;
        }
        this.j.a(d.a(this.g), this.f, this.e, this.d.g, this.d.a, paramdl);
    }

    private String b() {
        try {
            if (!TextUtils.isEmpty(this.d.e)) {
                if (this.b.b(this.d.e)) {
                    return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
                }
                return "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException localRemoteException) {
            mx.e("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
        long l = SystemClock.elapsedRealtime();
        paramLong1 = paramLong2 - (l - paramLong1);
        paramLong2 = paramLong4 - (l - paramLong3);
        if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
            mx.c("Timed out waiting for adapter.");
            this.k = 3;
            return;
        }
        try {
            this.h.wait(Math.min(paramLong1, paramLong2));
            return;
        } catch (InterruptedException localInterruptedException) {
            this.k = -1;
        }
    }

    private dx c() {
        mx.c("Instantiating mediation adapter: " + this.a);
        try {
            dx localdx = this.b.a(this.a);
            return localdx;
        } catch (RemoteException localRemoteException) {
            mx.a("Could not instantiate mediation adapter: " + this.a, localRemoteException);
        }
        return null;
    }

    public dp a(long paramLong1, long paramLong2) {
        synchronized (this.h) {
            long l = SystemClock.elapsedRealtime();
            Object localObject2 = new dl();
            mv.a.post(new do (this, (dl) localObject2));
            a(l, this.c, paramLong1, paramLong2);
            localObject2 = new dp(this.d, this.j, this.a, (dl) localObject2, this.k);
            return (dp) localObject2;
        }
    }

    public void a() {
        synchronized (this.h) {
            try {
                if (this.j != null) {
                    this.j.c();
                }
                this.k = -1;
                this.h.notify();
                return;
            } catch (RemoteException localRemoteException) {
                for (; ; ) {
                    mx.d("Could not destroy mediation adapter.", localRemoteException);
                }
            }
        }
    }

    public void a(int paramInt) {
        synchronized (this.h) {
            this.k = paramInt;
            this.h.notify();
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */