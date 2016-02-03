package com.inneractive.api.ads.sdk;

import android.webkit.JavascriptInterface;

final class IAmraidWebView$a {
    IAmraidWebView$a(IAmraidWebView paramIAmraidWebView) {
    }

    @JavascriptInterface
    public final boolean receiveJavascriptAdWidth(String paramString) {
        InneractiveAdView.Log.v("Inneractive_verbose", "workaround ad zoom");
        InneractiveAdView.Log.v("Inneractive_verbose", "width JS :" + paramString);
        if (Integer.parseInt(paramString) != 0) {
            InneractiveAdView.Log.v("Inneractive_verbose", "width WebView: " + String.valueOf(this.this$0.getWidth()));
            paramString = String.valueOf(this.this$0.getWidth() / Integer.parseInt(paramString));
            InneractiveAdView.Log.v("Inneractive_verbose", "workaround ad zoom: " + paramString);
            IAmraidWebView.access$400(this.this$0, new IAmraidWebView.a .1 (this, paramString));
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebView$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */