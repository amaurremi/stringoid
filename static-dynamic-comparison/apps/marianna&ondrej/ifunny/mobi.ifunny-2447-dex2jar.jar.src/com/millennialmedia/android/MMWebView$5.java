package com.millennialmedia.android;

import android.view.ViewGroup.LayoutParams;

class MMWebView$5
        implements Runnable {
    MMWebView$5(MMWebView paramMMWebView, MMAdView paramMMAdView) {
    }

    void a() {
        if ((MMSDK.c()) && (!MMWebView.a(this.b))) {
            ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
            localLayoutParams.width = this.b.l;
            localLayoutParams.height = this.b.k;
            this.b.l = -50;
            this.b.k = -50;
            this.b.requestLayout();
        }
    }

    public void run() {
        synchronized (this.b) {
            this.a.a();
            a();
            this.b.n();
            this.b.d = true;
            this.b.invalidate();
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */