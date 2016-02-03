package com.mopub.mobileads;

import android.webkit.WebView;
import android.webkit.WebViewClient;

final class MoPubActivity$2
        extends WebViewClient {
    MoPubActivity$2(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener) {
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        if (paramString.equals("mopub://finishLoad")) {
            this.val$customEventInterstitialListener.onInterstitialLoaded();
        }
        for (; ; ) {
            return true;
            if (paramString.equals("mopub://failLoad")) {
                this.val$customEventInterstitialListener.onInterstitialFailed(null);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */