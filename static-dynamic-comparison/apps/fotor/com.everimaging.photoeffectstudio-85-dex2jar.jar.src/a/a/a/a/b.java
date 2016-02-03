package a.a.a.a;

import android.content.Context;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class b {
    private static b a;
    private Timer b = new Timer();
    private a c = new a();
    private f d;
    private boolean e;
    private double f;
    private double g;
    private int h;
    private c i;

    private b() {
        this.b.schedule(new TimerTask() {
            public void run() {
                b.a(b.this);
            }
        }, 60000L, 60000L);
        this.e = false;
        this.f = 0.0D;
        this.h = 0;
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private void f() {
        if (!this.e) {
        }
        do {
            return;
            double d1 = System.currentTimeMillis() / 1000.0D;
            this.f += d1 - this.g;
            this.g = d1;
            int j = (int) this.f;
            this.c.a(j);
            this.f -= j;
        } while (this.d.a() <= 0);
        this.c.c(this.d.b());
    }

    // second parameter is a url
    public void a(Context paramContext, String paramString1, String paramString2) {
        if (!org.OpenUDID.a.b()) {
            org.OpenUDID.a.a(paramContext);
        }
        this.i = new c(paramContext);
        this.c.a(paramContext);
        this.c.b(paramString1);
        this.c.a(paramString2);
        this.c.a(this.i);
        this.d = new f(this.i);
    }

    public void a(String paramString, int paramInt) {
        this.d.a(paramString, paramInt);
        if (this.d.a() >= 10) {
            this.c.c(this.d.b());
        }
    }

    public void a(String paramString, Map<String, String> paramMap, int paramInt) {
        this.d.a(paramString, paramMap, paramInt);
        if (this.d.a() >= 10) {
            this.c.c(this.d.b());
        }
    }

    public void b() {
        this.h += 1;
        if (this.h == 1) {
            d();
        }
    }

    public void c() {
        this.h -= 1;
        if (this.h == 0) {
            e();
        }
    }

    public void d() {
        this.g = (System.currentTimeMillis() / 1000.0D);
        this.c.a();
        this.e = true;
    }

    public void e() {
        if (this.d.a() > 0) {
            this.c.c(this.d.b());
        }
        double d1 = System.currentTimeMillis() / 1000.0D;
        double d2 = this.f;
        this.f = (d1 - this.g + d2);
        int j = (int) this.f;
        this.c.b(j);
        this.f -= j;
        this.e = false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */