package com.facebook.ads;

public abstract interface InterstitialAdListener
        extends AdListener {
    public abstract void onInterstitialDismissed(Ad paramAd);

    public abstract void onInterstitialDisplayed(Ad paramAd);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/InterstitialAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */