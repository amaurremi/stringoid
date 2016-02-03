package com.amazon.device.ads;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class en
        extends WebChromeClient {
    en(el paramel) {
    }

    public void onProgressChanged(WebView paramWebView, int paramInt) {
        Activity localActivity = (Activity) paramWebView.getContext();
        localActivity.setTitle("Loading...");
        localActivity.setProgress(paramInt * 100);
        if (paramInt == 100) {
            localActivity.setTitle(paramWebView.getUrl());
        }
        el.a(this.a, paramWebView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */