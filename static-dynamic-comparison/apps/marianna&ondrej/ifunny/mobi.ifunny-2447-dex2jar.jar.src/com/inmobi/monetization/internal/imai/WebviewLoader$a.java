package com.inmobi.monetization.internal.imai;

import android.webkit.WebView;
import com.inmobi.commons.internal.Log;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class WebviewLoader$a
        implements Runnable {
    WebviewLoader$a(WebviewLoader paramWebviewLoader, String paramString, HashMap paramHashMap) {
    }

    public void run() {
        try {
            WebviewLoader.b.set(true);
            WebviewLoader.a(this.c).loadUrl(this.a, this.b);
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Exception load in webview", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/WebviewLoader$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */