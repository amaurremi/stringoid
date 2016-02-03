package com.facebook.ads;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.HtmlAdHandler;
import com.facebook.ads.internal.action.AdAction;
import com.facebook.ads.internal.action.AdActionFactory;

class AdView$AdWebViewClient
        extends WebViewClient {
    private AdView$AdWebViewClient(AdView paramAdView) {
    }

    public void onLoadResource(WebView paramWebView, String paramString) {
        AdView.access$400(this.this$0).activateAd();
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        if (AdView.access$500(this.this$0) != null) {
            AdView.access$500(this.this$0).onAdClicked(this.this$0);
        }
        paramWebView = Uri.parse(paramString);
        paramWebView = AdActionFactory.getAdAction(this.this$0.getContext(), paramWebView);
        if (paramWebView != null) {
        }
        try {
            paramWebView.execute();
            return true;
        } catch (Exception paramWebView) {
            for (; ; ) {
                Log.e(AdView.access$700(), "Error executing action", paramWebView);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/AdView$AdWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */