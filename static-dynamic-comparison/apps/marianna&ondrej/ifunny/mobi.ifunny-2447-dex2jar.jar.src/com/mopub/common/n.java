package com.mopub.common;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class n
        extends WebChromeClient {
    n(MoPubBrowser paramMoPubBrowser) {
    }

    public void onProgressChanged(WebView paramWebView, int paramInt) {
        this.a.setTitle("Loading...");
        this.a.setProgress(paramInt * 100);
        if (paramInt == 100) {
            this.a.setTitle(paramWebView.getUrl());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */