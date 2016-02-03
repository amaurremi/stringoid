package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import org.json.JSONException;
import org.json.JSONObject;

@ii
public class jc
        extends lo
        implements jx {
    private final ja a;
    private final Object b = new Object();
    private final Context c;
    private final Object d = new Object();
    private final kc e;
    private final pv f;
    private lo g;
    private fk h;
    private di i;

    public jc(Context paramContext, kc paramkc, pv parampv, ja paramja) {
        this.a = paramja;
        this.c = paramContext;
        this.e = paramkc;
        this.f = parampv;
    }

    private ay a(fi paramfi) {
        if (this.h.m == null) {
            throw new jh("The ad response must specify one of the supported ad sizes.", 0);
        }
        Object localObject = this.h.m.split("x");
        if (localObject.length != 2) {
            throw new jh("Could not parse the ad size from the ad response: " + this.h.m, 0);
        }
        for (; ; ) {
            int j;
            ay localay;
            try {
                int n = Integer.parseInt(localObject[0]);
                int i1 = Integer.parseInt(localObject[1]);
                localObject = paramfi.d.h;
                int i2 = localObject.length;
                j = 0;
                if (j >= i2) {
                    break;
                }
                localay = localObject[j];
                float f1 = this.c.getResources().getDisplayMetrics().density;
                if (localay.f == -1) {
                    k = (int) (localay.g / f1);
                    if (localay.c != -2) {
                        break label253;
                    }
                    m = (int) (localay.d / f1);
                    if ((n != k) || (i1 != m)) {
                        break label263;
                    }
                    return new ay(localay, paramfi.d.h);
                }
            } catch (NumberFormatException paramfi) {
                throw new jh("Could not parse the ad size from the ad response: " + this.h.m, 0);
            }
            int k = localay.f;
            continue;
            label253:
            int m = localay.c;
            continue;
            label263:
            j += 1;
        }
        throw new jh("The ad size from the ad response was not one of the requested sizes: " + this.h.m, 0);
    }

    private void a(long paramLong) {
        do {
            if (!b(paramLong)) {
                throw new jh("Timed out waiting for ad response.", 2);
            }
        } while (this.h == null);
        synchronized (this.b) {
            this.g = null;
            if ((this.h.e != -2) && (this.h.e != -3)) {
                throw new jh("There was a problem getting an ad response. ErrorCode: " + this.h.e, this.h.e);
            }
        }
    }

    private void a(boolean paramBoolean) {
        lj.a().a(paramBoolean);
        ad localad = lj.a().a(this.c);
        if ((localad != null) && (!localad.isAlive())) {
            mx.a("start fetching content...");
            localad.a();
        }
    }

    private boolean b(long paramLong) {
        paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
        if (paramLong <= 0L) {
            return false;
        }
        try {
            this.d.wait(paramLong);
            return true;
        } catch (InterruptedException localInterruptedException) {
            throw new jh("Ad request cancelled.", -1);
        }
    }

    private void c() {
        if (this.h.e == -3) {
        }
        do {
            return;
            if (TextUtils.isEmpty(this.h.c)) {
                throw new jh("No fill from ad server.", 3);
            }
            lj.a(this.c, this.h.u);
        } while (!this.h.h);
        try {
            this.i = new di(this.h.c);
            return;
        } catch (JSONException localJSONException) {
            throw new jh("Could not parse mediation config: " + this.h.c, 0);
        }
    }

    public void a() {
        for (; ; ) {
            int j;
            long l2;
            long l1;
            synchronized (this.d) {
                mx.a("AdLoaderBackgroundTask started.");
                Object localObject1 = this.f.a().a(this.c);
                fi localfi = new fi(this.e, (String) localObject1);
                j = -2;
                l2 = -1L;
                l1 = l2;
                long l3;
                try {
                    l3 = SystemClock.elapsedRealtime();
                    l1 = l2;
                    lo locallo = jw.a(this.c, localfi, this);
                    l1 = l2;
                    localObject1 = this.b;
                    l1 = l2;
                    try {
                        this.g = locallo;
                        if (this.g != null) {
                            continue;
                        }
                        throw new jh("Could not start the ad request service.", 0);
                    } finally {
                        l1 = l2;
                    }
                    j = localjh1.a();
                } catch (jh localjh1) {
                    localObject1 = null;
                }
                if ((j == 3) || (j == -1)) {
                    mx.c(localjh1.getMessage());
                    if (this.h != null) {
                        break label365;
                    }
                    this.h = new fk(j);
                    mv.a.post(new je(this));
                    boolean bool = TextUtils.isEmpty(this.h.r);
                    if (bool) {
                        break label397;
                    }
                }
                try {
                    localJSONObject = new JSONObject(this.h.r);
                    localObject1 = new ld(localfi, this.h, this.i, (ay) localObject1, j, l1, this.h.n, localJSONObject);
                    mv.a.post(new jg(this, (ld) localObject1));
                    return;
                } catch (Exception localException) {
                    JSONObject localJSONObject;
                    mx.b("Error parsing the JSON for Active View.", localException);
                }
                l1 = l2;
                a(l3);
                l1 = l2;
                l2 = SystemClock.elapsedRealtime();
                l1 = l2;
                c();
                l1 = l2;
                if (localfi.d.h == null) {
                    break label411;
                }
                l1 = l2;
                localObject1 = a(localfi);
                try {
                    a(this.h.v);
                    l1 = l2;
                } catch (jh localjh2) {
                    Object localObject5;
                    l1 = l2;
                }
                mx.e(localJSONObject.getMessage());
            }
            label365:
            this.h = new fk(j, this.h.k);
            continue;
            label397:
            localObject5 = null;
            continue;
            continue;
            label411:
            Object localObject3 = null;
        }
    }

    public void a(fk paramfk) {
        synchronized (this.d) {
            mx.a("Received ad response.");
            this.h = paramfk;
            this.d.notify();
            return;
        }
    }

    public void b() {
        synchronized (this.b) {
            if (this.g != null) {
                this.g.f();
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */