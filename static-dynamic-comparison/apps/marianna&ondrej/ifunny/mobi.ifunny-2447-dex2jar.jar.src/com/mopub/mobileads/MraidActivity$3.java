package com.mopub.mobileads;

class MraidActivity$3
        extends MraidView.BaseMraidListener {
    MraidActivity$3(MraidActivity paramMraidActivity) {
    }

    public void onClose(MraidView paramMraidView, MraidView.ViewState paramViewState) {
        MraidActivity.access$000(this.this$0).loadUrl(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getUrl());
        this.this$0.finish();
    }

    public void onOpen(MraidView paramMraidView) {
        EventForwardingBroadcastReceiver.broadcastAction(this.this$0, this.this$0.getBroadcastIdentifier(), "com.mopub.action.interstitial.click");
    }

    public void onReady(MraidView paramMraidView) {
        MraidActivity.access$000(this.this$0).loadUrl(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
        this.this$0.showInterstitialCloseButton();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidActivity$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */