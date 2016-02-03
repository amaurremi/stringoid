package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.WebView;

import java.util.concurrent.atomic.AtomicBoolean;

class AdTrackerWebViewLoader$a
        implements Runnable {
    AdTrackerWebViewLoader$a(AdTrackerWebViewLoader paramAdTrackerWebViewLoader) {
    }

    public void run() {
        if (AdTrackerWebViewLoader.a() != null) {
            AdTrackerWebViewLoader.a().stopLoading();
            AdTrackerWebViewLoader.a().destroy();
            AdTrackerWebViewLoader.a(null);
            AdTrackerWebViewLoader.b().set(false);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */