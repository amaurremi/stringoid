package com.inmobi.monetization.internal.imai;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.inmobi.commons.internal.Log;

import java.util.concurrent.atomic.AtomicBoolean;

class WebviewLoader$d
        implements Runnable {
    WebviewLoader$d(WebviewLoader paramWebviewLoader, Context paramContext) {
    }

    public void run() {
        try {
            WebviewLoader.a(this.b, new WebView(this.a));
            WebviewLoader.b = new AtomicBoolean(false);
            WebviewLoader.a(this.b).setWebViewClient(new WebviewLoader.MyWebViewClient());
            WebviewLoader.a(this.b).getSettings().setJavaScriptEnabled(true);
            WebviewLoader.a(this.b).getSettings().setPluginState(WebSettings.PluginState.ON);
            WebviewLoader.a(this.b).getSettings().setCacheMode(2);
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Exception init webview", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/WebviewLoader$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */