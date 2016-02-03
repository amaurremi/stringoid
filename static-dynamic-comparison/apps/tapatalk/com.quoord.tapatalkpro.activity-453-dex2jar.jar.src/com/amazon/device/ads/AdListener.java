package com.amazon.device.ads;

public abstract interface AdListener {
    public abstract void onAdCollapsed(Ad paramAd);

    public abstract void onAdDismissed(Ad paramAd);

    public abstract void onAdExpanded(Ad paramAd);

    public abstract void onAdFailedToLoad(Ad paramAd, AdError paramAdError);

    public abstract void onAdLoaded(Ad paramAd, AdProperties paramAdProperties);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */