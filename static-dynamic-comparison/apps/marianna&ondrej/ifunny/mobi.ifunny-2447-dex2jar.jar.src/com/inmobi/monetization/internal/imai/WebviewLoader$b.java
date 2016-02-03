package com.inmobi.monetization.internal.imai;

import android.webkit.WebView;
import com.inmobi.commons.internal.Log;

import java.util.concurrent.atomic.AtomicBoolean;

class WebviewLoader$b
        implements Runnable {
    WebviewLoader$b(WebviewLoader paramWebviewLoader) {
    }

    public void run() {
        try {
            if (WebviewLoader.a(this.a) != null) {
                WebviewLoader.b.set(false);
            }
            WebviewLoader.a(this.a).stopLoading();
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Exception stop loading", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/WebviewLoader$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */