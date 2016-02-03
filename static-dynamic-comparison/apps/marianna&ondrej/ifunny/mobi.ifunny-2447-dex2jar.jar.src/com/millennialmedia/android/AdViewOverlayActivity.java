package com.millennialmedia.android;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class AdViewOverlayActivity
        extends MMBaseActivity {
    boolean a;
    boolean b;
    private AdViewOverlayView d;
    private OverlaySettings e;

    private void a(String paramString) {
        if ("landscape".equalsIgnoreCase(paramString)) {
            setRequestedOrientation(0);
        }
        while (!"portrait".equalsIgnoreCase(paramString)) {
            return;
        }
        setRequestedOrientation(1);
    }

    private void g() {
        if (this.c.getRequestedOrientation() == 0) {
            setRequestedOrientation(0);
            return;
        }
        if (this.c.getRequestedOrientation() == 8) {
            setRequestedOrientation(8);
            return;
        }
        if (this.c.getRequestedOrientation() == 9) {
            setRequestedOrientation(9);
            return;
        }
        setRequestedOrientation(1);
    }

    void E_() {
        setRequestedOrientation(-1);
    }

    protected void a(Bundle paramBundle) {
        if (this.d != null) {
            paramBundle.putInt("adViewId", this.d.getId());
        }
        super.a(paramBundle);
    }

    void a(boolean paramBoolean) {
        this.e.h = paramBoolean;
        if (paramBoolean) {
            E_();
            return;
        }
        g();
    }

    void b() {
        this.e.c = "portrait";
        this.e.h = false;
        setRequestedOrientation(1);
    }

    protected void b(Bundle paramBundle) {
        super.b(paramBundle);
    }

    void c() {
        this.e.c = "landscape";
        this.e.h = false;
        setRequestedOrientation(0);
    }

    protected void d() {
        this.b = false;
        MMLog.b("AdViewOverlayActivity", "Overlay onResume");
        if (this.d != null) {
            if (this.a) {
                this.d.q();
            }
            this.d.addBlackView();
            if ((this.d.h != null) && (this.d.h.k != null) && (this.d.h.k.b != null)) {
                this.d.h.k.b.onResumeWebView();
            }
        }
        super.d();
    }

    protected void e() {
        this.b = true;
        MMLog.b("AdViewOverlayActivity", "Overlay onPause");
        BridgeMMMedia.Audio localAudio = BridgeMMMedia.Audio.a(this.c);
        if (localAudio != null) {
        }
        try {
            localAudio.b();
            if (this.d != null) {
                this.d.p();
                if ((this.d.h != null) && (this.d.h.k != null) && (this.d.h.k.b != null)) {
                    this.d.h.k.b.onPauseWebView();
                }
            }
            setResult(0);
            super.e();
            return;
        } finally {
        }
    }

    protected void f() {
        super.f();
    }

    public void finish() {
        if (this.d != null) {
            if (!this.d.d()) {
                this.d.k();
            }
            this.d.j();
        }
        this.d = null;
        super.finish();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        if (this.d != null) {
            this.d.i();
        }
        super.onConfigurationChanged(paramConfiguration);
    }

    protected void onCreate(Bundle paramBundle) {
        setTheme(16973840);
        super.onCreate(paramBundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().clearFlags(1024);
        getWindow().addFlags(2048);
        getWindow().addFlags(16777216);
        paramBundle = getIntent();
        this.e = ((OverlaySettings) paramBundle.getParcelableExtra("settings"));
        if (this.e == null) {
            this.e = new OverlaySettings();
        }
        this.e.a();
        if (this.e.c != null) {
            a(this.e.c);
        }
        if (this.e.h) {
            E_();
            if (paramBundle != null) {
                paramBundle = paramBundle.getData();
                if (paramBundle != null) {
                    MMLog.a("AdViewOverlayActivity", String.format("Path: %s", new Object[]{paramBundle.getLastPathSegment()}));
                }
            }
            paramBundle = new RelativeLayout(this.c);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(13);
            paramBundle.setId(885394873);
            paramBundle.setLayoutParams(localLayoutParams);
            this.d = new AdViewOverlayView(this, this.e);
            paramBundle.addView(this.d);
            setContentView(paramBundle);
            if (getLastNonConfigurationInstance() == null) {
                if (!this.e.b()) {
                    break label355;
                }
                if ((this.d.h != null) && (this.d.h.k != null) && (this.d.h.k.b != null)) {
                    this.d.h.k.b.r();
                }
                if (this.e.d()) {
                    this.d.a(this.e.d);
                }
            }
        }
        for (; ; ) {
            this.e.c = null;
            return;
            g();
            break;
            label355:
            if (!this.e.b()) {
                this.d.a(this.e.i, this.e.j);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        MMLog.b("AdViewOverlayActivity", "Overlay onDestroy");
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.d != null)) {
            this.d.c();
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public Object onRetainNonConfigurationInstance() {
        if (this.d != null) {
            return this.d.a();
        }
        return null;
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
        this.a = paramBoolean;
        if ((!this.b) && (paramBoolean)) {
            this.d.q();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */