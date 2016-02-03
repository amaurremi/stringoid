package com.inneractive.api.ads.sdk;

final class IAmraidWebView$b$1
        implements Runnable {
    IAmraidWebView$b$1(IAmraidWebView.b paramb) {
    }

    public final void run() {
        if (this.this$1.this$0.mWebChromeClient != null) {
            this.this$1.this$0.mWebChromeClient.onHideCustomView();
            InneractiveAdView.Log.d("Inneractive_debug", "native closeHTML5VideoInterface started");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebView$b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */