package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;

import java.util.Map;

class fu
        extends bg
        implements gf, gg, gj, gk {
    protected fy g;
    private WebView h;

    protected fu(ah paramah, dj paramdj, WebView paramWebView, Context paramContext) {
        super(paramah, paramdj, paramContext);
        this.h = paramWebView;
    }

    protected void a(bd parambd) {
        super.a(parambd);
    }

    public void a(fy paramfy) {
        a(this.c.c());
    }

    public void a(fy paramfy, gm paramgm) {
        if (!f()) {
            this.a.p();
        }
    }

    public void a(fy paramfy, String paramString) {
        if (g()) {
            o().a(paramString);
        }
    }

    protected boolean a(bh parambh) {
        if (this.g == null) {
            dv.e("MraidRenderer", "Unable to retrieve ad state.");
            return false;
        }
        switch (fv.a[parambh.ordinal()]) {
            default:
                return false;
        }
        return this.g.n().i();
    }

    public boolean a(String paramString) {
        if (g()) {
            return bs.a(paramString, this.b);
        }
        return false;
    }

    protected boolean a(String paramString, Map<String, String> paramMap) {
        dv.a("MraidRenderer", "sendCommand: %s", new Object[]{paramString});
        if ((paramString.equals("close")) && (this.g != null) && (this.g.n().i())) {
            this.g.n().j();
            return true;
        }
        return false;
    }

    public void b(fy paramfy) {
        if (!f()) {
            this.a.o();
        }
    }

    protected boolean i() {
        if (e()) {
        }
        do {
            return false;
            this.g = q();
        } while ((this.g.h()) || (!this.g.a(this.c.b())));
        r();
        return true;
    }

    protected void j() {
        if (this.g != null) {
            this.g.j();
        }
    }

    protected boolean k() {
        return false;
    }

    protected void l() {
        if ((!this.d) && (!this.e)) {
        }
        try {
            this.a.d().removeAllViews();
            this.d = true;
            return;
        } catch (NullPointerException localNullPointerException) {
            for (; ; ) {
            }
        }
    }

    protected void m() {
        if (this.g != null) {
            this.g.k();
            this.g = null;
            this.e = true;
        }
        this.h = null;
    }

    public void p() {
        if (this.g == null) {
            dv.e("MraidRenderer", "Call to onPageFinished() ignored because view is null.");
            return;
        }
        this.g.v();
    }

    protected fy q() {
        return new fy(this, this.a.h(), this.a.g(), c(), this.b, this.h);
    }

    @SuppressLint({"InlinedApi"})
    protected void r() {
        this.g.a(this);
        this.g.a(this);
        this.g.a(this);
        this.g.a(this);
        this.a.d().removeAllViews();
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.a.d().addView(this.g, localLayoutParams);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */