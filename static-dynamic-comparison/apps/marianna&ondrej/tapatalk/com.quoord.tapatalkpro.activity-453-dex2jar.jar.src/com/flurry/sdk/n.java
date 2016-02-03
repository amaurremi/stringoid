package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

@SuppressLint({"SetJavaScriptEnabled"})
public final class n
        extends RelativeLayout
        implements View.OnClickListener {
    private final String a = getClass().getSimpleName();
    private WebView b;
    private WebViewClient c;
    private WebChromeClient d;
    private boolean e;
    private boolean f = true;
    private ProgressDialog g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private final int k = 0;
    private final int l = 1;
    private final int m = 2;
    private f n;
    private c o;
    private d p;
    private boolean q;

    @TargetApi(11)
    public n(Context paramContext, String paramString, boolean paramBoolean) {
        super(paramContext);
        this.b = new WebView(paramContext);
        this.c = new b(null);
        this.d = new a(null);
        this.f = paramBoolean;
        this.b.getSettings().setJavaScriptEnabled(true);
        this.b.getSettings().setUseWideViewPort(true);
        this.b.getSettings().setLoadWithOverviewMode(true);
        this.b.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.b.getSettings().setDisplayZoomControls(false);
        }
        this.b.setWebViewClient(this.c);
        this.b.setWebChromeClient(this.d);
        this.b.loadUrl(paramString);
        this.h = new ImageView(paramContext);
        this.h.setId(0);
        this.h.setImageDrawable(getResources().getDrawable(17301560));
        this.h.setOnClickListener(this);
        this.i = new ImageView(paramContext);
        this.i.setId(1);
        this.i.setImageDrawable(getResources().getDrawable(17301580));
        this.i.setOnClickListener(this);
        this.j = new ImageView(paramContext);
        this.j.setId(2);
        this.j.setImageDrawable(getResources().getDrawable(17301565));
        this.j.setOnClickListener(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(this.b);
        paramContext = new RelativeLayout.LayoutParams(-2, -2);
        paramContext.addRule(14);
        addView(this.h, paramContext);
        paramContext = new RelativeLayout.LayoutParams(-2, -2);
        paramContext.addRule(9);
        addView(this.i, paramContext);
        paramContext = new RelativeLayout.LayoutParams(-2, -2);
        paramContext.addRule(11);
        addView(this.j, paramContext);
    }

    public void a(Context paramContext) {
        if (this.g == null) {
            if (paramContext != null) {
                this.g = new ProgressDialog(paramContext);
                this.g.setProgressStyle(0);
                this.g.setMessage("Loading...");
                this.g.setCancelable(true);
                this.g.setCanceledOnTouchOutside(false);
                this.g.show();
            }
        }
        while (this.g.isShowing()) {
            return;
            eo.a(3, this.a, "Context is null, cannot create progress dialog.");
            return;
        }
        this.g.show();
    }

    public boolean a() {
        return (this.e) || ((this.b != null) && (this.b.canGoBack()));
    }

    public boolean b() {
        return this.f;
    }

    public void c() {
        if (this.e) {
            this.d.onHideCustomView();
        }
        while (this.b == null) {
            return;
        }
        this.b.goBack();
    }

    @TargetApi(11)
    public void d() {
        if (this.b != null) {
            e();
            removeView(this.b);
            this.b.stopLoading();
            if (Build.VERSION.SDK_INT >= 11) {
                this.b.onPause();
            }
            this.b.destroy();
            this.b = null;
        }
    }

    public void e() {
        if ((this.g != null) && (this.g.isShowing())) {
            this.g.dismiss();
            this.g = null;
        }
    }

    public c getBasicWebViewClosingHandler() {
        return this.o;
    }

    public d getBasicWebViewFullScreenTransitionHandler() {
        return this.p;
    }

    public f getBasicWebViewUrlLoadingHandler() {
        return this.n;
    }

    public String getUrl() {
        String str = null;
        if (this.b != null) {
            str = this.b.getUrl();
        }
        return str;
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
        }
        do {
            do {
                do {
                    return;
                } while (this.o == null);
                this.o.a(this, e.c);
                return;
            } while ((this.b == null) || (!this.b.canGoForward()));
            this.b.goForward();
            return;
            if ((this.b != null) && (this.b.canGoBack())) {
                this.b.goBack();
                return;
            }
        } while (this.o == null);
        if (b()) {
            this.o.a(this, e.c);
            return;
        }
        this.o.a(this, e.b);
    }

    public void setBasicWebViewClosingHandler(c paramc) {
        this.o = paramc;
    }

    public void setBasicWebViewFullScreenTransitionHandler(d paramd) {
        this.p = paramd;
    }

    public void setBasicWebViewUrlLoadingHandler(f paramf) {
        this.n = paramf;
    }

    final class a
            extends WebChromeClient {
        private a() {
        }

        public void onHideCustomView() {
            eo.a(3, n.a(n.this), "onHideCustomView()");
            if (n.e(n.this) != null) {
                n.e(n.this).a(n.this);
            }
            n.b(n.this, false);
        }

        public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
            eo.a(3, n.a(n.this), "onShowCustomView(14)");
            n.b(n.this, true);
            if (n.e(n.this) != null) {
                n.e(n.this).a(n.this, paramView, paramInt, new n.g(n.this, paramCustomViewCallback));
            }
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
            eo.a(3, n.a(n.this), "onShowCustomView(7)");
            n.b(n.this, true);
            if (n.e(n.this) != null) {
                n.e(n.this).a(n.this, paramView, new n.g(n.this, paramCustomViewCallback));
            }
        }
    }

    final class b
            extends WebViewClient {
        private b() {
        }

        public void onPageFinished(WebView paramWebView, String paramString) {
            eo.a(3, n.a(n.this), "onPageFinished: url = " + paramString);
            if ((paramString == null) || (paramWebView == null) || (paramWebView != n.b(n.this))) {
                return;
            }
            n.a(n.this, false);
        }

        public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
            eo.a(3, n.a(n.this), "onPageStarted: url = " + paramString);
            if ((paramString == null) || (paramWebView == null) || (paramWebView != n.b(n.this))) {
                return;
            }
            n.this.e();
            if (n.d(n.this)) {
                boolean bool = false;
                if (n.c(n.this) != null) {
                    bool = n.c(n.this).a(n.this, paramString, n.d(n.this));
                }
                if (bool) {
                    paramWebView.stopLoading();
                }
            }
            n.a(n.this, true);
        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            eo.a(3, n.a(n.this), "shouldOverrideUrlLoading: url = " + paramString);
            if ((paramString == null) || (paramWebView == null) || (paramWebView != n.b(n.this))) {
                return false;
            }
            if (n.c(n.this) != null) {
            }
            for (boolean bool = n.c(n.this).a(n.this, paramString, n.d(n.this)); ; bool = false) {
                n.a(n.this, false);
                return bool;
            }
        }
    }

    public static abstract interface c {
        public abstract void a(n paramn, n.e parame);
    }

    public static abstract interface d {
        public abstract void a(n paramn);

        public abstract void a(n paramn, View paramView, int paramInt, a parama);

        public abstract void a(n paramn, View paramView, a parama);

        public static abstract interface a {
            public abstract void a();
        }
    }

    public static enum e {
        private e() {
        }
    }

    public static abstract interface f {
        public abstract boolean a(n paramn, String paramString, boolean paramBoolean);
    }

    final class g
            implements n.d.a {
        private WebChromeClient.CustomViewCallback b;

        public g(WebChromeClient.CustomViewCallback paramCustomViewCallback) {
            this.b = paramCustomViewCallback;
        }

        public void a() {
            if (this.b != null) {
                this.b.onCustomViewHidden();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */