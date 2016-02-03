package com.mobileapptracker;

import android.content.Context;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.lang.ref.WeakReference;

final class i
        implements Runnable {
    private final WeakReference b;

    public i(g paramg, Context paramContext) {
        this.b = new WeakReference(paramContext);
    }

    public final void run() {
        try {
            WebView localWebView = new WebView((Context) this.b.get());
            String str = localWebView.getSettings().getUserAgentString();
            localWebView.destroy();
            g.a(this.a, str);
            return;
        } catch (Exception localException) {
            while (!g.a(this.a)) {
            }
            Log.d("MobileAppTracker", "Could not get user agent");
            localException.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mobileapptracker/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */