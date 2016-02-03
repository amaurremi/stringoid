package com.amazon.device.ads;

abstract interface AdWrapper {
    public abstract Ad getAd();

    public abstract AdData getAdData();

    public abstract IAdLoaderCallback getAdLoaderCallback();

    public abstract int prepareAd(AdLoader.AdReadyToLoadListener paramAdReadyToLoadListener);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */