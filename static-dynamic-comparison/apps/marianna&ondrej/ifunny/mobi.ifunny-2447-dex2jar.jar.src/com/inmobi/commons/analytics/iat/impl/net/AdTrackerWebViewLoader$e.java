package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.internal.InternalSDKUtil;

import java.util.concurrent.atomic.AtomicBoolean;

class AdTrackerWebViewLoader$e
        implements Runnable {
    AdTrackerWebViewLoader$e(AdTrackerWebViewLoader paramAdTrackerWebViewLoader) {
    }

    public void run() {
        AdTrackerWebViewLoader.a(new AtomicBoolean(false));
        AdTrackerWebViewLoader.a(new WebView(InternalSDKUtil.getContext()));
        AdTrackerWebViewLoader.a().setWebViewClient(new AdTrackerWebViewLoader.MyWebViewClient(this.a));
        AdTrackerWebViewLoader.a().getSettings().setJavaScriptEnabled(true);
        AdTrackerWebViewLoader.a().getSettings().setCacheMode(2);
        AdTrackerWebViewLoader.a().addJavascriptInterface(new AdTrackerWebViewLoader.JSInterface(), "iatsdk");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */