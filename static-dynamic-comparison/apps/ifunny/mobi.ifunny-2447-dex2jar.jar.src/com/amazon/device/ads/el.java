package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class el
        implements di {
    protected static final String a = el.class.getSimpleName();
    private WebView b;
    private ImageButton c;
    private ImageButton d;
    private ImageButton e;
    private ImageButton f;
    private ImageButton g;
    private Activity h;
    private boolean i;

    private ImageButton a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        ImageButton localImageButton = new ImageButton(this.h);
        localImageButton.setImageBitmap(BitmapFactory.decodeFile(paramString));
        paramString = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
        paramString.addRule(paramInt1, paramInt2);
        paramString.addRule(12);
        localImageButton.setLayoutParams(paramString);
        localImageButton.setBackgroundColor(0);
        localImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return localImageButton;
    }

    @SuppressLint({"InlinedApi"})
    private void a(Intent paramIntent) {
        Object localObject = new DisplayMetrics();
        ((WindowManager) this.h.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
        float f1 = ((DisplayMetrics) localObject).density;
        int m = (int) (50.0F * f1 + 0.5F);
        int n = (int) (f1 * 3.0F + 0.5F);
        if (this.i) {
        }
        for (int j = 5; ; j = 4) {
            int k = ((DisplayMetrics) localObject).widthPixels / j;
            j = k;
            if (k > m * 2) {
                j = m * 2;
            }
            localObject = new RelativeLayout(this.h);
            ((RelativeLayout) localObject).setId(10280);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, m + n);
            localLayoutParams.addRule(12);
            ((RelativeLayout) localObject).setLayoutParams(localLayoutParams);
            ((RelativeLayout) localObject).setBackgroundColor(-986896);
            ho.a(new et(this, paramIntent, (ViewGroup) localObject, j, m), new Void[0]);
            paramIntent = new View(this.h);
            paramIntent.setBackgroundColor(-3355444);
            localLayoutParams = new RelativeLayout.LayoutParams(-1, n);
            localLayoutParams.addRule(10);
            paramIntent.setLayoutParams(localLayoutParams);
            ((RelativeLayout) localObject).addView(paramIntent);
            this.b = ig.a().a(this.h);
            paramIntent = new RelativeLayout.LayoutParams(-1, -1);
            paramIntent.addRule(2, ((RelativeLayout) localObject).getId());
            this.b.setLayoutParams(paramIntent);
            paramIntent = new RelativeLayout(this.h);
            paramIntent.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            paramIntent.addView(this.b);
            paramIntent.addView((View) localObject);
            localObject = new LinearLayout(this.h);
            ((LinearLayout) localObject).setOrientation(1);
            ((LinearLayout) localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            ((LinearLayout) localObject).addView(paramIntent);
            this.h.setContentView((View) localObject);
            return;
        }
    }

    private void b(Intent paramIntent) {
        ig.a(true, this.b, a);
        this.b.loadUrl(paramIntent.getStringExtra("extra_url"));
        this.b.setWebViewClient(new em(this));
        this.b.setWebChromeClient(new en(this));
    }

    private void c(Intent paramIntent) {
        this.c.setOnClickListener(new eo(this));
        this.d.setOnClickListener(new ep(this));
        this.e.setOnClickListener(new eq(this));
        this.f.setOnClickListener(new er(this));
        if (this.i) {
            this.g.setOnClickListener(new es(this, paramIntent));
        }
    }

    private void c(WebView paramWebView) {
        if ((this.c != null) && (this.d != null)) {
            if (!paramWebView.canGoBack()) {
                break label49;
            }
            cf.a(this.c, 255);
        }
        while (paramWebView.canGoForward()) {
            cf.a(this.d, 255);
            return;
            label49:
            cf.a(this.c, 102);
        }
        cf.a(this.d, 102);
    }

    private void j() {
        CookieSyncManager.createInstance(this.h);
        CookieSyncManager.getInstance().startSync();
    }

    public void a() {
    }

    public void a(Activity paramActivity) {
        this.h = paramActivity;
    }

    protected void a(WebView paramWebView) {
        cf.a(paramWebView);
    }

    protected boolean a(int paramInt) {
        return Build.VERSION.SDK_INT >= paramInt;
    }

    public void b() {
        this.h.getWindow().requestFeature(2);
        this.h.getWindow().setFeatureInt(2, -1);
        Intent localIntent = this.h.getIntent();
        this.i = localIntent.getBooleanExtra("extra_open_btn", false);
        a(localIntent);
        b(localIntent);
        j();
    }

    protected void b(WebView paramWebView) {
        cf.b(paramWebView);
    }

    public void c() {
        dv.b(a, "onPause");
        WebView localWebView = f();
        if (a(11)) {
            a(localWebView);
        }
        for (; ; ) {
            if (h()) {
                localWebView.pauseTimers();
            }
            CookieSyncManager.getInstance().stopSync();
            return;
            dv.e(a, "Unable to call WebView.onPause");
        }
    }

    public void d() {
        dv.b(a, "onResume");
        WebView localWebView = f();
        if (a(11)) {
            b(localWebView);
        }
        for (; ; ) {
            if (i()) {
                localWebView.resumeTimers();
            }
            CookieSyncManager.getInstance().startSync();
            return;
            dv.e(a, "Unable to call WebView.onResume");
        }
    }

    public void e() {
    }

    protected WebView f() {
        return this.b;
    }

    protected boolean g() {
        return he.a().a("shouldPauseWebViewTimersInWebViewRelatedActivities", false);
    }

    protected boolean h() {
        return (f() != null) && (g());
    }

    protected boolean i() {
        return (f() != null) && (g());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */