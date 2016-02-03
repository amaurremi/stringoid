package com.umeng.analytics.b;

import android.content.Context;
import com.umeng.analytics.d.d;

public class o {
    private static final String h = "successful_request";
    private static final String i = "failed_requests ";
    private static final String j = "last_request_spent_ms";
    private static final String k = "last_request_time";
    private static final String l = "first_activate_time";
    public int a;
    public int b;
    public long c;
    private final int d = 3600000;
    private int e;
    private long f = 0L;
    private long g = 0L;
    private Context m;

    public o(Context paramContext) {
        b(paramContext);
    }

    public static d a(Context paramContext) {
        paramContext = m.a(paramContext);
        d locald = new d();
        locald.c(paramContext.a("failed_requests ", 0));
        locald.d(paramContext.a("last_request_spent_ms", 0));
        locald.a(paramContext.a("successful_request", 0));
        return locald;
    }

    private void b(Context paramContext) {
        this.m = paramContext.getApplicationContext();
        paramContext = m.a(paramContext);
        this.a = paramContext.a("successful_request", 0);
        this.b = paramContext.a("failed_requests ", 0);
        this.e = paramContext.a("last_request_spent_ms", 0);
        this.c = paramContext.a("last_request_time", 0L);
    }

    public int a() {
        if (this.e > 3600000) {
            return 3600000;
        }
        return this.e;
    }

    public boolean b() {
        return this.c == 0L;
    }

    public void c() {
        this.a += 1;
        this.c = this.f;
    }

    public void d() {
        this.b += 1;
    }

    public void e() {
        this.f = System.currentTimeMillis();
    }

    public void f() {
        this.e = ((int) (System.currentTimeMillis() - this.f));
    }

    public void g() {
        m.a(this.m).a().a("successful_request", this.a).a("failed_requests ", this.b).a("last_request_spent_ms", this.e).a("last_request_time", this.c).b();
    }

    public void h() {
        m.a(this.m).a().a("first_activate_time", System.currentTimeMillis()).b();
    }

    public boolean i() {
        if (this.g == 0L) {
            this.g = m.a(this.m).a("first_activate_time", 0L);
        }
        return this.g == 0L;
    }

    public long j() {
        if (i()) {
            return System.currentTimeMillis();
        }
        return this.g;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */