package com.amazon.device.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;

import java.util.Map;

class dd
        extends bg {
    public static final String g = dd.class.getSimpleName();
    protected WebView h;
    protected boolean i = false;
    protected boolean j = false;

    protected dd(ah paramah, dj paramdj, WebView paramWebView, Context paramContext) {
        super(paramah, paramdj, paramContext);
        this.h = paramWebView;
        q();
        if ((Build.VERSION.SDK_INT >= 11) && (this.a.r())) {
            r();
        }
    }

    public void a() {
        q();
        super.a();
    }

    protected void a(bd parambd) {
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.a.d().addView(this.h, localLayoutParams);
        super.a(parambd);
    }

    protected boolean a(bh parambh) {
        return false;
    }

    public boolean a(String paramString) {
        bs.a(paramString, this.b);
        return true;
    }

    protected boolean a(String paramString, Map<String, String> paramMap) {
        return true;
    }

    protected boolean i() {
        if ((t()) || (e()) || (this.j)) {
            return false;
        }
        s();
        return true;
    }

    protected void j() {
    }

    protected boolean k() {
        return true;
    }

    protected void l() {
        if (this.a.d() != null) {
            this.a.d().removeView(this.h);
        }
        this.d = true;
    }

    protected void m() {
        if (t()) {
            dv.e(g, "Called destroy(), but view is already null.");
        }
        for (; ; ) {
            this.e = true;
            return;
            this.h.destroy();
            this.h = null;
        }
    }

    public void p() {
        if ((!this.e) && (!this.i)) {
            this.i = true;
            a(this.c.c());
        }
    }

    protected void q() {
        boolean bool = true;
        this.h.setHorizontalScrollBarEnabled(false);
        this.h.setHorizontalScrollbarOverlay(false);
        this.h.setVerticalScrollBarEnabled(false);
        this.h.setVerticalScrollbarOverlay(false);
        this.h.getSettings().setSupportZoom(false);
        if (!ig.a(true, this.h, g)) {
        }
        for (; ; ) {
            this.j = bool;
            this.h.setBackgroundColor(0);
            bw localbw = new bw(this, this.b);
            localbw.a("amazonmobile", this.a.s());
            this.h.setWebViewClient(localbw);
            return;
            bool = false;
        }
    }

    protected void r() {
        cf.a(this.h);
    }

    protected void s() {
        this.h.loadUrl("about:blank");
        this.i = false;
        String str = this.c.b();
        str = ("<html><meta name=\"viewport\" content=\"width=" + this.a.h() + ", height=" + this.a.g() + ", initial-scale=" + bs.a(c()) + ", minimum-scale=" + c() + ", maximum-scale=" + c() + "\">" + str + "</html>").replace("<head>", "<head><script type=\"text/javascript\">htmlWillCallFinishLoad = 1;</script>");
        this.h.loadDataWithBaseURL("http://amazon-adsystem.amazon.com/", str, "text/html", "utf-8", null);
    }

    protected boolean t() {
        return this.h == null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */