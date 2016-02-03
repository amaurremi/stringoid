package com.facebook.ads;

public abstract interface AdListener {
    public abstract void onAdClicked(Ad paramAd);

    public abstract void onAdLoaded(Ad paramAd);

    public abstract void onError(Ad paramAd, AdError paramAdError);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/AdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */