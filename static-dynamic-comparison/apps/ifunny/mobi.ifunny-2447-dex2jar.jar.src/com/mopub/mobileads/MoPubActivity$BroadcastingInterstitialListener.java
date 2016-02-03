package com.mopub.mobileads;

class MoPubActivity$BroadcastingInterstitialListener
        implements CustomEventInterstitial.CustomEventInterstitialListener {
    MoPubActivity$BroadcastingInterstitialListener(MoPubActivity paramMoPubActivity) {
    }

    public void onInterstitialClicked() {
        EventForwardingBroadcastReceiver.broadcastAction(this.this$0, this.this$0.getBroadcastIdentifier(), "com.mopub.action.interstitial.click");
    }

    public void onInterstitialDismissed() {
    }

    public void onInterstitialFailed(MoPubErrorCode paramMoPubErrorCode) {
        EventForwardingBroadcastReceiver.broadcastAction(this.this$0, this.this$0.getBroadcastIdentifier(), "com.mopub.action.interstitial.fail");
        this.this$0.finish();
    }

    public void onInterstitialLoaded() {
        MoPubActivity.access$000(this.this$0).loadUrl(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
    }

    public void onInterstitialShown() {
    }

    public void onLeaveApplication() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubActivity$BroadcastingInterstitialListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */