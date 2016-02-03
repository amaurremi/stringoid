package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.WebView;

import java.util.concurrent.atomic.AtomicBoolean;

class AdTrackerWebViewLoader$c
        implements Runnable {
    AdTrackerWebViewLoader$c(AdTrackerWebViewLoader paramAdTrackerWebViewLoader) {
    }

    public void run() {
        if (AdTrackerWebViewLoader.a() != null) {
            AdTrackerWebViewLoader.b().set(false);
        }
        AdTrackerWebViewLoader.a().stopLoading();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */