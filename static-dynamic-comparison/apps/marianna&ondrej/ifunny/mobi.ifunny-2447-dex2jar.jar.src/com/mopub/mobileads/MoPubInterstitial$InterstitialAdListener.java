package com.mopub.mobileads;

public abstract interface MoPubInterstitial$InterstitialAdListener {
    public abstract void onInterstitialClicked(MoPubInterstitial paramMoPubInterstitial);

    public abstract void onInterstitialDismissed(MoPubInterstitial paramMoPubInterstitial);

    public abstract void onInterstitialFailed(MoPubInterstitial paramMoPubInterstitial, MoPubErrorCode paramMoPubErrorCode);

    public abstract void onInterstitialLoaded(MoPubInterstitial paramMoPubInterstitial);

    public abstract void onInterstitialShown(MoPubInterstitial paramMoPubInterstitial);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubInterstitial$InterstitialAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */