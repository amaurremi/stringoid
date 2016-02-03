package com.mopub.mobileads;

final class MraidActivity$1
        implements MraidView.MraidListener {
    MraidActivity$1(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener) {
    }

    public void onClose(MraidView paramMraidView, MraidView.ViewState paramViewState) {
    }

    public void onExpand(MraidView paramMraidView) {
    }

    public void onFailure(MraidView paramMraidView) {
        this.val$customEventInterstitialListener.onInterstitialFailed(null);
    }

    public void onOpen(MraidView paramMraidView) {
    }

    public void onReady(MraidView paramMraidView) {
        this.val$customEventInterstitialListener.onInterstitialLoaded();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */