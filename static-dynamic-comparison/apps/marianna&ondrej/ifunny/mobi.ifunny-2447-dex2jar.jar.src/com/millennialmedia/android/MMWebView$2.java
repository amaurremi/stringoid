package com.millennialmedia.android;

class MMWebView$2
        implements Runnable {
    MMWebView$2(MMWebView paramMMWebView, String paramString1, String paramString2) {
    }

    public void run() {
        if (HandShake.a(this.c.getContext()).e) {
            this.c.c();
        }
        for (; ; ) {
            this.c.d = true;
            this.c.loadDataWithBaseURL(this.a, this.b, "text/html", "UTF-8", null);
            return;
            if (this.c.i == 0) {
                this.c.b();
            } else {
                this.c.a();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */