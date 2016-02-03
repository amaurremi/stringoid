package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

class af
        implements Runnable {
    ValueCallback<String> a = new ag(this);

    af(ad paramad, aa paramaa, WebView paramWebView) {
    }

    public void run() {
        if (this.c.getSettings().getJavaScriptEnabled()) {
            this.c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */