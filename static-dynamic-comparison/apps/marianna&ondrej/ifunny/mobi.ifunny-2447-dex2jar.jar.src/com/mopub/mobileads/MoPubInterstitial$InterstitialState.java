package com.mopub.mobileads;

enum MoPubInterstitial$InterstitialState {
    CUSTOM_EVENT_AD_READY, NOT_READY;

    private MoPubInterstitial$InterstitialState() {
    }

    boolean isReady() {
        return this != NOT_READY;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubInterstitial$InterstitialState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */