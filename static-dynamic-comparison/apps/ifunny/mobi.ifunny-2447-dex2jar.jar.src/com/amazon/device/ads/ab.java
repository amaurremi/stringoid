package com.amazon.device.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.HashMap;
import java.util.Set;

class ab
        implements dj, dk {
    private ah a;
    private final al b;
    private final Context c;
    private final bn d;
    private int e = 20000;
    private ar f;
    private bg g;
    private WebView h;
    private int i;
    private int j;
    private boolean k;

    protected ab() {
        this.b = null;
        this.c = null;
        this.d = null;
    }

    ab(al paramal, bn parambn, Context paramContext) {
        this.b = paramal;
        this.c = paramContext;
        this.d = parambn;
        this.f = a();
    }

    private void a(ai paramai) {
        this.g = a(paramai, this.g);
        if (this.g == null) {
            dv.b("AdController", "No renderer returned, not loading an ad");
            a(new aj(ak.d, "No renderer returned, not loading an ad"));
        }
        do {
            return;
            this.g.a();
            b().a(true);
            long l = System.nanoTime();
            b().n().c(eb.i, l);
            b().n().b(eb.x, l);
            b().n().b(eb.y, l);
        } while (this.g.i());
        t();
        dv.b("AdController", "Ad could not render");
        a(new aj(ak.d, "Ad could not render"));
    }

    private void a(boolean paramBoolean) {
        if (paramBoolean) {
            dy.a().a(b());
        }
    }

    protected static String b(int paramInt1, int paramInt2) {
        return Integer.toString(paramInt1) + "x" + Integer.toString(paramInt2);
    }

    private void t() {
        if (this.g != null) {
            this.g.l();
            this.g.m();
            this.g = null;
        }
    }

    private void u() {
        v();
        cz.a(this.h.getSettings().getUserAgentString());
    }

    private void v() {
        this.h = ig.a().a(this.c);
    }

    private void w() {
        if (this.h != null) {
            this.h.destroy();
            this.h = null;
        }
        this.k = false;
    }

    protected ar a() {
        return new cy("AdController");
    }

    protected bg a(ai paramai, bg parambg) {
        bi localbi = new bi();
        if (localbi.a(paramai, parambg)) {
            dv.b("AdController", "Creating new renderer");
            if (parambg != null) {
                parambg.m();
            }
            if (this.h == null) {
                v();
            }
            paramai = localbi.a(paramai, this.a, this, this.h, this.c);
            this.h = null;
            return paramai;
        }
        dv.b("AdController", "Re-using renderer");
        parambg.a(this.a);
        return parambg;
    }

    public void a(int paramInt) {
        this.e = paramInt;
    }

    public void a(int paramInt1, int paramInt2) {
        this.j = paramInt1;
        this.i = paramInt2;
    }

    public void a(long paramLong) {
        l();
        b().n().b(eb.a, paramLong);
        b().n().b(eb.c, paramLong);
        b().n().b(eb.b, paramLong);
        b().n().b(eb.d, paramLong);
        if (this.d.a()) {
            b().e(i());
        }
        this.k = true;
        Looper localLooper;
        if (cz.t() == null) {
            localLooper = Looper.getMainLooper();
            if (Thread.currentThread() == localLooper.getThread()) {
                u();
            }
        } else {
            return;
        }
        new Handler(localLooper).post(new ac(this));
    }

    protected void a(ah paramah) {
        this.a = paramah;
    }

    public void a(aj paramaj) {
        if ((b() == null) || (b().n().c())) {
            b(paramaj);
            return;
        }
        c(paramaj);
    }

    protected void a(aj paramaj, boolean paramBoolean) {
        new Handler(this.c.getMainLooper()).post(new ae(this, paramaj, paramBoolean));
    }

    public void a(ar paramar) {
        if (paramar == null) {
            this.f = a();
            return;
        }
        this.f = paramar;
    }

    public void a(bd parambd) {
        long l = System.nanoTime();
        n();
        b().n().c(eb.a, l);
        b().n().c(eb.b, l);
        b().n().c(eb.x, l);
        q();
        b().a(false);
        this.k = false;
        new Handler(this.c.getMainLooper()).post(new ad(this, parambd));
    }

    public boolean a(String paramString, HashMap<String, String> paramHashMap) {
        if (this.g != null) {
            return this.g.a(paramString, paramHashMap);
        }
        return false;
    }

    protected ah b() {
        return this.a;
    }

    protected void b(aj paramaj) {
        w();
        a(paramaj, false);
    }

    protected void c(aj paramaj) {
        w();
        d(paramaj);
        a(paramaj, true);
    }

    public boolean c() {
        return this.k;
    }

    public al d() {
        return this.b;
    }

    protected void d(aj paramaj) {
        long l = System.nanoTime();
        b().n().c(eb.y, l);
        if (paramaj.a() != ak.c) {
            b().n().a(eb.s);
        }
        if (b().i()) {
            b().n().a(eb.w);
            b().a(false);
        }
        b().n().c(eb.j, l);
        b().n().c(eb.a, l);
        b().n().c(eb.c, l);
        q();
    }

    public int e() {
        return this.e;
    }

    public boolean f() {
        if (this.g == null) {
            return false;
        }
        return this.g.a(bh.valueOf("EXPANDED"));
    }

    public int g() {
        return this.i;
    }

    public int h() {
        return this.j;
    }

    public String i() {
        if (!this.d.a()) {
            return null;
        }
        return b(h(), g());
    }

    public void j() {
        if (this.g != null) {
            this.g.j();
        }
    }

    public void k() {
        t();
    }

    protected void l() {
        a(new ah(this.d));
    }

    public void m() {
        if (this.g != null) {
            this.g.l();
        }
        if (this.a == null) {
            dv.b("AdController", "We are unable to load the ad due to an internal error.");
            a(new aj(ak.d, "We are unable to load the ad due to an internal error."));
            return;
        }
        ai localai;
        if ((this.a.d() != null) && (!this.a.d().isEmpty())) {
            localai = ai.a(this.a.d());
            if (localai != null) {
            }
        } else {
            dv.b("AdController", "There were no valid creative types returned, and we are unable to load the ad.");
            a(new aj(ak.d, "There were no valid creative types returned, and we are unable to load the ad."));
            return;
        }
        a(localai);
    }

    public void n() {
        hy.j(b().h());
    }

    public void o() {
        new Handler(this.c.getMainLooper()).post(new af(this));
    }

    public void p() {
        new Handler(this.c.getMainLooper()).post(new ag(this));
    }

    protected void q() {
        bs.a(b());
        if (d().e()) {
            b().n().a(eb.C);
        }
        if (g() == 0) {
            b().n().a(eb.D);
        }
        if (this.g != null) {
            b().n().a(eb.E, this.g.d());
        }
    }

    public boolean r() {
        return d().a();
    }

    public ca s() {
        return new bx(this.g, this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */