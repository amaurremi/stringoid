package com.millennialmedia.android;

class MMWebView$1
        implements Runnable {
    MMWebView$1(MMWebView paramMMWebView, MMAdImpl paramMMAdImpl, String paramString1, String paramString2) {
    }

    public void run() {
        if (HandShake.a(this.d.getContext()).e) {
            this.d.c();
        }
        for (; ; ) {
            MMAd localMMAd = this.a.d();
            if ((localMMAd != null) && ((localMMAd instanceof MMLayout))) {
                ((MMLayout) localMMAd).m();
            }
            this.d.d = true;
            this.d.loadDataWithBaseURL(this.b, this.c, "text/html", "UTF-8", null);
            return;
            if (this.d.i == 0) {
                this.d.b();
            } else {
                this.d.a();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */