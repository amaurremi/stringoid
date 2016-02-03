package com.inmobi.monetization.internal.imai;

import android.webkit.WebView;
import com.inmobi.commons.internal.Log;

import java.util.concurrent.atomic.AtomicBoolean;

class WebviewLoader$c
        implements Runnable {
    WebviewLoader$c(WebviewLoader paramWebviewLoader) {
    }

    public void run() {
        try {
            if (WebviewLoader.a(this.a) != null) {
                WebviewLoader.a(this.a).stopLoading();
                WebviewLoader.a(this.a).destroy();
                WebviewLoader.a(this.a, null);
                WebviewLoader.b.set(false);
            }
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Exception deinit webview ", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/WebviewLoader$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */