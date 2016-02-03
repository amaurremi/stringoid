package com.mopub.mobileads;

import android.webkit.WebView;
import android.webkit.WebViewClient;

final class MraidActivity$2
        extends WebViewClient {
    MraidActivity$2(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener) {
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        this.val$customEventInterstitialListener.onInterstitialLoaded();
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */