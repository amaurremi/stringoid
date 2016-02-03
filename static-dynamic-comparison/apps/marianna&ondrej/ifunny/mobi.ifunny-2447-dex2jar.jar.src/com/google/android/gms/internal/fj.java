package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

@ii
public class fj
        extends fz {
    private static final int a = Color.argb(0, 0, 0, 0);
    private final Activity b;
    private dm c;
    private fr d;
    private mz e;
    private fo f;
    private fu g;
    private boolean h;
    private boolean i = false;
    private FrameLayout j;
    private WebChromeClient.CustomViewCallback k;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private RelativeLayout o;

    public fj(Activity paramActivity) {
        this.b = paramActivity;
    }

    public static void a(Context paramContext, dm paramdm) {
        Intent localIntent = new Intent();
        localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
        localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramdm.n.e);
        dm.a(localIntent, paramdm);
        localIntent.addFlags(524288);
        if (!(paramContext instanceof Activity)) {
            localIntent.addFlags(268435456);
        }
        paramContext.startActivity(localIntent);
    }

    private static RelativeLayout.LayoutParams c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
        localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(9);
        return localLayoutParams;
    }

    public void a() {
        this.b.finish();
    }

    public void a(int paramInt) {
        this.b.setRequestedOrientation(paramInt);
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (this.d != null) {
            this.d.setLayoutParams(c(paramInt1, paramInt2, paramInt3, paramInt4));
        }
    }

    public void a(Bundle paramBundle) {
        boolean bool = false;
        if (paramBundle != null) {
            bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.l = bool;
        try {
            this.c = dm.a(this.b.getIntent());
            if (this.c != null) {
                break label66;
            }
            throw new fm("Could not get info for ad overlay.");
        } catch (fm paramBundle) {
            mx.e(paramBundle.getMessage());
            this.b.finish();
        }
        return;
        label66:
        if (this.c.q != null) {
            this.n = this.c.q.b;
            label90:
            if (paramBundle == null) {
                if (this.c.d != null) {
                    this.c.d.s();
                }
                if ((this.c.l != 1) && (this.c.c != null)) {
                    this.c.c.u();
                }
            }
            switch (this.c.l) {
            }
        }
        for (; ; ) {
            throw new fm("Could not determine ad overlay type.");
            this.n = false;
            break label90;
            c(false);
            return;
            this.f = new fo(this.c.e);
            c(false);
            return;
            c(true);
            return;
            if (this.l) {
                this.b.finish();
                return;
            }
            if (fg.a(this.b, this.c.b, this.c.j)) {
                break;
            }
            this.b.finish();
            return;
        }
    }

    public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
        this.j = new FrameLayout(this.b);
        this.j.setBackgroundColor(-16777216);
        this.j.addView(paramView, -1, -1);
        this.b.setContentView(this.j);
        j();
        this.k = paramCustomViewCallback;
        this.i = true;
    }

    public void a(boolean paramBoolean) {
        RelativeLayout.LayoutParams localLayoutParams;
        if (paramBoolean) {
            i1 = 50;
            this.g = new fu(this.b, i1);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(10);
            if (!paramBoolean) {
                break label86;
            }
        }
        label86:
        for (int i1 = 11; ; i1 = 9) {
            localLayoutParams.addRule(i1);
            this.g.a(this.c.h);
            this.o.addView(this.g, localLayoutParams);
            return;
            i1 = 32;
            break;
        }
    }

    public fr b() {
        return this.d;
    }

    public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (this.d == null) {
            this.d = new fr(this.b, this.e);
            this.o.addView(this.d, 0, c(paramInt1, paramInt2, paramInt3, paramInt4));
            this.e.f().a(false);
        }
    }

    public void b(Bundle paramBundle) {
        paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.l);
    }

    public void b(boolean paramBoolean) {
        if (this.g != null) {
            this.g.a(paramBoolean);
        }
    }

    public void c() {
        if ((this.c != null) && (this.i)) {
            a(this.c.k);
        }
        if (this.j != null) {
            this.b.setContentView(this.o);
            j();
            this.j.removeAllViews();
            this.j = null;
        }
        if (this.k != null) {
            this.k.onCustomViewHidden();
            this.k = null;
        }
        this.i = false;
    }

    void c(boolean paramBoolean) {
        if (!this.h) {
            this.b.requestWindowFeature(1);
        }
        Object localObject = this.b.getWindow();
        if ((!this.n) || (this.c.q.c)) {
            ((Window) localObject).setFlags(1024, 1024);
        }
        a(this.c.k);
        if (Build.VERSION.SDK_INT >= 11) {
            mx.a("Enabling hardware acceleration on the AdActivity window.");
            mj.a((Window) localObject);
        }
        this.o = new fn(this.b, this.c.p);
        boolean bool;
        if (!this.n) {
            this.o.setBackgroundColor(-16777216);
            this.b.setContentView(this.o);
            j();
            bool = this.c.e.f().b();
            if (!paramBoolean) {
                break label436;
            }
            this.e = mz.a(this.b, this.c.e.e(), true, bool, null, this.c.n);
            this.e.f().a(null, null, this.c.f, this.c.j, true, this.c.o, this.c.e.f().a());
            this.e.f().a(new fl(this));
            if (this.c.m == null) {
                break label384;
            }
            this.e.loadUrl(this.c.m);
        }
        for (; ; ) {
            this.e.a(this);
            localObject = this.e.getParent();
            if ((localObject != null) && ((localObject instanceof ViewGroup))) {
                ((ViewGroup) localObject).removeView(this.e);
            }
            if (this.n) {
                this.e.setBackgroundColor(a);
            }
            this.o.addView(this.e, -1, -1);
            if (!paramBoolean) {
                m();
            }
            a(bool);
            if (this.e.g()) {
                b(true);
            }
            return;
            this.o.setBackgroundColor(a);
            break;
            label384:
            if (this.c.i != null) {
                this.e.loadDataWithBaseURL(this.c.g, this.c.i, "text/html", "UTF-8", null);
            } else {
                throw new fm("No URL or HTML to display in ad overlay.");
                label436:
                this.e = this.c.e;
                this.e.setContext(this.b);
            }
        }
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
        if ((this.c != null) && (this.c.l == 4)) {
            if (!this.l) {
                break label47;
            }
            this.b.finish();
        }
        for (; ; ) {
            if (this.e != null) {
                lw.b(this.e);
            }
            return;
            label47:
            this.l = true;
        }
    }

    public void g() {
        if (this.d != null) {
            this.d.c();
        }
        c();
        if ((this.e != null) && ((!this.b.isFinishing()) || (this.f == null))) {
            lw.a(this.e);
        }
        l();
    }

    public void h() {
        l();
    }

    public void i() {
        if (this.d != null) {
            this.d.a();
        }
        if (this.e != null) {
            this.o.removeView(this.e);
        }
        l();
    }

    public void j() {
        this.h = true;
    }

    public void k() {
        this.o.removeView(this.g);
        a(true);
    }

    void l() {
        if ((!this.b.isFinishing()) || (this.m)) {
        }
        do {
            do {
                return;
                this.m = true;
            } while (!this.b.isFinishing());
            if (this.e != null) {
                n();
                this.o.removeView(this.e);
                if (this.f != null) {
                    this.e.a(false);
                    this.f.c.addView(this.e, this.f.a, this.f.b);
                }
            }
        } while ((this.c == null) || (this.c.d == null));
        this.c.d.r();
    }

    void m() {
        this.e.c();
    }

    void n() {
        this.e.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */