package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.WebView;
import com.inmobi.commons.internal.Log;

import java.util.concurrent.atomic.AtomicBoolean;

class AdTrackerWebViewLoader$b
        implements Runnable {
    AdTrackerWebViewLoader$b(AdTrackerWebViewLoader paramAdTrackerWebViewLoader) {
    }

    public void run() {
        AdTrackerWebViewLoader.b(this.a, System.currentTimeMillis());
        AdTrackerWebViewLoader.b().set(true);
        Log.internal("[InMobi]-[AdTracker]-4.5.1", "Load Webview: " + AdTrackerNetworkInterface.b());
        AdTrackerWebViewLoader.a().loadUrl(AdTrackerNetworkInterface.b());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */