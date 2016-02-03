package com.mopub.mobileads;

public abstract interface CustomEventInterstitial$CustomEventInterstitialListener {
    public abstract void onInterstitialClicked();

    public abstract void onInterstitialDismissed();

    public abstract void onInterstitialFailed(MoPubErrorCode paramMoPubErrorCode);

    public abstract void onInterstitialLoaded();

    public abstract void onInterstitialShown();

    public abstract void onLeaveApplication();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/CustomEventInterstitial$CustomEventInterstitialListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */