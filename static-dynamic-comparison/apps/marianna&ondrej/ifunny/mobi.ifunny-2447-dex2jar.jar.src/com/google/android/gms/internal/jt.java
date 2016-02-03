package com.google.android.gms.internal;

class jt
        implements Runnable {
    jt(jq paramjq) {
    }

    public void run() {
        for (; ; ) {
            synchronized (jq.a(this.a)) {
                if (jq.c(this.a).e != -2) {
                    return;
                }
                jq.d(this.a).f().a(this.a);
                if (jq.c(this.a).e == -3) {
                    mx.d("Loading URL in WebView: " + jq.c(this.a).b);
                    jq.d(this.a).loadUrl(jq.c(this.a).b);
                    return;
                }
            }
            mx.d("Loading HTML in WebView.");
            jq.d(this.a).loadDataWithBaseURL(lw.a(jq.c(this.a).b), jq.c(this.a).c, "text/html", "UTF-8", null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */