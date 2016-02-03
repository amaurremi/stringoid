package com.google.android.gms.a;

import android.app.Activity;
import com.google.android.gms.internal.pq;
import com.google.android.gms.internal.pr;

import java.util.HashMap;
import java.util.Map;

class n
        implements d {
    private boolean b = false;
    private int c = 0;
    private long d = -1L;
    private boolean e = false;
    private long f;
    private pq g = pr.c();

    public n(m paramm) {
    }

    private void e() {
        c localc = c.a();
        if (localc == null) {
            bt.a("GoogleAnalytics isn't initialized for the Tracker!");
            return;
        }
        if ((this.d >= 0L) || (this.b)) {
            localc.a(m.a(this.a));
            return;
        }
        localc.b(m.a(this.a));
    }

    public long a() {
        return this.d;
    }

    public void a(long paramLong) {
        this.d = paramLong;
        e();
    }

    public void a(Activity paramActivity) {
        bl.a().a(bm.ai);
        if ((this.c == 0) && (d())) {
            this.e = true;
        }
        this.c += 1;
        HashMap localHashMap;
        m localm;
        if (this.b) {
            localHashMap = new HashMap();
            localHashMap.put("&t", "screenview");
            bl.a().a(true);
            localm = this.a;
            if (m.b(this.a) == null) {
                break label121;
            }
        }
        label121:
        for (paramActivity = m.b(this.a).a(paramActivity); ; paramActivity = paramActivity.getClass().getCanonicalName()) {
            localm.a("&cd", paramActivity);
            this.a.a(localHashMap);
            bl.a().a(false);
            return;
        }
    }

    public void a(boolean paramBoolean) {
        this.b = paramBoolean;
        e();
    }

    public void b(Activity paramActivity) {
        bl.a().a(bm.aj);
        this.c -= 1;
        this.c = Math.max(0, this.c);
        if (this.c == 0) {
            this.f = this.g.b();
        }
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        boolean bool = this.e;
        this.e = false;
        return bool;
    }

    boolean d() {
        return this.g.b() >= this.f + Math.max(1000L, this.d);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */