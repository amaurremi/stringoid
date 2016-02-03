package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class InneractiveInternalBrowserActivity$2
        extends WebChromeClient {
    InneractiveInternalBrowserActivity$2(InneractiveInternalBrowserActivity paramInneractiveInternalBrowserActivity) {
    }

    public final void onProgressChanged(WebView paramWebView, int paramInt) {
        Activity localActivity = (Activity) paramWebView.getContext();
        localActivity.setTitle("Page is Loading...");
        localActivity.setProgress(paramInt * 100);
        if (paramInt == 100) {
            localActivity.setTitle(paramWebView.getUrl());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInternalBrowserActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */