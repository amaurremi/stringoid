package com.mopub.mobileads;

enum BaseInterstitialActivity$JavaScriptWebViewCallbacks {
    WEB_VIEW_DID_APPEAR("javascript:webviewDidAppear();"), WEB_VIEW_DID_CLOSE("javascript:webviewDidClose();");

    private String mUrl;

    private BaseInterstitialActivity$JavaScriptWebViewCallbacks(String paramString) {
        this.mUrl = paramString;
    }

    protected String getUrl() {
        return this.mUrl;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/BaseInterstitialActivity$JavaScriptWebViewCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */