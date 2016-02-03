package com.amazon.device.ads;

public abstract interface Ad {
    public abstract int getTimeout();

    public abstract boolean isLoading();

    public abstract boolean loadAd();

    public abstract boolean loadAd(AdTargetingOptions paramAdTargetingOptions);

    public abstract void setListener(AdListener paramAdListener);

    public abstract void setTimeout(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/Ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */