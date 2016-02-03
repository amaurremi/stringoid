package com.inmobi.monetization.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;

import java.util.ArrayList;

class f
        extends WebViewClient {
    f(g paramg) {
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        Log.internal("[InMobi]-[Monetization]", "Native ad context code loaded");
        g.a(this.a, true);
        if ((g.a(this.a) != null) && (!g.a(this.a).isEmpty())) {
            int i = 0;
            while (i < g.a(this.a).size()) {
                this.a.b((String) g.a(this.a).get(i));
                i += 1;
            }
            g.a(this.a).clear();
            g.a(this.a, null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */