package com.millennialmedia.android;

import android.view.ViewGroup.LayoutParams;

class MMWebView$4
        implements Runnable {
    MMWebView$4(MMWebView paramMMWebView, MMAdView paramMMAdView, DTOResizeParameters paramDTOResizeParameters) {
    }

    private void a() {
        if (MMWebView.a(this.c)) {
            ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
            this.c.l = localLayoutParams.width;
            this.c.k = localLayoutParams.height;
            if (this.c.l <= 0) {
                this.c.l = this.c.getWidth();
            }
            if (this.c.k <= 0) {
                this.c.k = this.c.getHeight();
            }
        }
    }

    private void a(DTOResizeParameters paramDTOResizeParameters) {
        MMAdView localMMAdView = this.a;
        localMMAdView.getClass();
        paramDTOResizeParameters = new MMAdView.BannerBounds(localMMAdView, paramDTOResizeParameters);
        a();
        paramDTOResizeParameters.a(this.c.getLayoutParams());
    }

    public void run() {
        synchronized (this.c) {
            this.c.d = true;
            this.a.a(this.b);
            a(this.b);
            this.c.loadUrl("javascript:MMJS.sdk.setState('resized');");
            this.c.c = "resized";
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */