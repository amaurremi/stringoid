package com.facebook.ads;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.HtmlAdHandler;
import com.facebook.ads.internal.action.AdAction;
import com.facebook.ads.internal.action.AdActionFactory;

class InterstitialAdActivity$AdWebViewClient
        extends WebViewClient {
    private static final String FBAD_CLOSE = "close";

    private InterstitialAdActivity$AdWebViewClient(InterstitialAdActivity paramInterstitialAdActivity) {
    }

    public void onLoadResource(WebView paramWebView, String paramString) {
        InterstitialAdActivity.access$100(this.this$0).activateAd();
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        paramWebView = Uri.parse(paramString);
        if (("fbad".equals(paramWebView.getScheme())) && ("close".equals(paramWebView.getAuthority()))) {
            this.this$0.finish();
        }
        do {
            return true;
            InterstitialAdActivity.access$200(this.this$0, "com.facebook.ads.interstitial.clicked");
            paramWebView = AdActionFactory.getAdAction(this.this$0, paramWebView);
        } while (paramWebView == null);
        try {
            paramWebView.execute();
            return true;
        } catch (Exception paramWebView) {
            Log.e(InterstitialAdActivity.access$300(), "Error executing action", paramWebView);
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/InterstitialAdActivity$AdWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */