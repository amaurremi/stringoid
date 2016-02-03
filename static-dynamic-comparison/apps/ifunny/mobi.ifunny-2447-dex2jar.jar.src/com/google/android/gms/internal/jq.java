package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.google.ads.mediation.admob.AdMobAdapter;

import java.util.List;

@ii
public class jq
        extends lo
        implements nd {
    private final dt a;
    private final jo b;
    private final mz c;
    private final Object d = new Object();
    private final Context e;
    private final Object f = new Object();
    private final ld g;
    private fk h;
    private boolean i = false;
    private df j;
    private di k;
    private dp l;

    public jq(Context paramContext, ld paramld, mz parammz, dt paramdt, jo paramjo) {
        this.e = paramContext;
        this.g = paramld;
        this.h = paramld.b;
        this.c = parammz;
        this.a = paramdt;
        this.b = paramjo;
        this.k = paramld.c;
    }

    private void a(fi paramfi, long paramLong) {
        synchronized (this.d) {
            this.j = new df(this.e, paramfi, this.a, this.k);
            this.l = this.j.a(paramLong, 60000L);
            switch (this.l.a) {
                default:
                    throw new jv("Unexpected mediation result: " + this.l.a, 0);
            }
        }
        throw new jv("No fill from any mediation ad networks.", 3);
    }

    private void b(long paramLong) {
        mv.a.post(new jt(this));
        c(paramLong);
    }

    private void c(long paramLong) {
        do {
            if (!d(paramLong)) {
                throw new jv("Timed out waiting for WebView to finish loading.", 2);
            }
        } while (!this.i);
    }

    private boolean d(long paramLong) {
        paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
        if (paramLong <= 0L) {
            return false;
        }
        try {
            this.f.wait(paramLong);
            return true;
        } catch (InterruptedException localInterruptedException) {
            throw new jv("Ad request cancelled.", -1);
        }
    }

    public void a() {
        for (; ; ) {
            int m;
            long l1;
            synchronized (this.f) {
                mx.a("AdRendererBackgroundTask started.");
                Object localObject1 = this.g.a;
                m = this.g.e;
                try {
                    l1 = SystemClock.elapsedRealtime();
                    if (this.h.h) {
                        a((fi) localObject1, l1);
                        av localav = ((fi) localObject1).c;
                        mz localmz = this.c;
                        List localList1 = this.h.d;
                        List localList2 = this.h.f;
                        List localList3 = this.h.j;
                        int n = this.h.l;
                        l1 = this.h.k;
                        String str2 = ((fi) localObject1).i;
                        boolean bool = this.h.h;
                        if (this.l == null) {
                            break label447;
                        }
                        localObject1 = this.l.b;
                        if (this.l == null) {
                            break label453;
                        }
                        dx localdx = this.l.c;
                        if (this.l == null) {
                            break label431;
                        }
                        str1 = this.l.d;
                        di localdi = this.k;
                        if (this.l == null) {
                            break label441;
                        }
                        localdl = this.l.e;
                        localObject1 = new lc(localav, localmz, localList1, m, localList2, localList3, n, l1, str2, bool, (dh) localObject1, localdx, str1, localdi, localdl, this.h.i, this.g.d, this.h.g, this.g.f, this.h.n, this.h.o, this.g.h, null);
                        mv.a.post(new js(this, (lc) localObject1));
                        return;
                    }
                    if (!this.h.p) {
                        break label390;
                    }
                    a(l1);
                    continue;
                    if (m != -1) {
                        break label398;
                    }
                } catch (jv localjv) {
                    m = localjv.a();
                    if (m == 3) {
                    }
                }
                mx.c(localjv.getMessage());
                if (this.h != null) {
                    break label409;
                }
                this.h = new fk(m);
                mv.a.post(new jr(this));
            }
            label390:
            b(l1);
            continue;
            label398:
            mx.e(localjv.getMessage());
            continue;
            label409:
            this.h = new fk(m, this.h.k);
            continue;
            label431:
            String str1 = AdMobAdapter.class.getName();
            continue;
            label441:
            dl localdl = null;
            continue;
            label447:
            Object localObject3 = null;
            continue;
            label453:
            Object localObject4 = null;
        }
    }

    protected void a(long paramLong) {
        Object localObject = this.c.e();
        int n;
        if (((ay) localObject).e) {
            n = this.e.getResources().getDisplayMetrics().widthPixels;
        }
        for (int m = this.e.getResources().getDisplayMetrics().heightPixels; ; m = ((ay) localObject).d) {
            localObject = new jk(this, this.c, n, m);
            mv.a.post(new ju(this, (jk) localObject));
            c(paramLong);
            if (!((jk) localObject).c()) {
                break;
            }
            mx.a("Ad-Network indicated no fill with passback URL.");
            throw new jv("AdNetwork sent passback url", 3);
            n = ((ay) localObject).g;
        }
        if (!((jk) localObject).d()) {
            throw new jv("AdNetwork timed out", 2);
        }
    }

    public void a(mz arg1) {
        synchronized (this.f) {
            mx.a("WebView finished loading.");
            this.i = true;
            this.f.notify();
            return;
        }
    }

    public void b() {
        synchronized (this.d) {
            this.c.stopLoading();
            lw.a(this.c);
            if (this.j != null) {
                this.j.a();
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */