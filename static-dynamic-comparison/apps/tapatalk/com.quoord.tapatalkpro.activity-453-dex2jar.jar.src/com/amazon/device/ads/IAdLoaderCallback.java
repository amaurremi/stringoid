package com.amazon.device.ads;

abstract interface IAdLoaderCallback {
    public abstract void adFailed(AdError paramAdError);

    public abstract void adShown();

    public abstract int getTimeout();

    public abstract void handleResponse();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/IAdLoaderCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */