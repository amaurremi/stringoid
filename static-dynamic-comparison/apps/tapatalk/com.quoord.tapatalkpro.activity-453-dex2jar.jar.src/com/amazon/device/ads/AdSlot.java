package com.amazon.device.ads;

class AdSlot {
    private AdError adError;
    private final AdTargetingOptions adOptions;
    private final AdWrapper adWrapper;
    private int slotNumber;

    public AdSlot(Ad paramAd, AdTargetingOptions paramAdTargetingOptions) {
        this(createAdWrapper(paramAd), paramAdTargetingOptions);
    }

    AdSlot(AdWrapper paramAdWrapper, AdTargetingOptions paramAdTargetingOptions) {
        this.adWrapper = paramAdWrapper;
        if (paramAdTargetingOptions == null) {
            this.adOptions = new AdTargetingOptions();
            return;
        }
        this.adOptions = paramAdTargetingOptions;
    }

    static AdWrapper createAdWrapper(Ad paramAd) {
        if ((paramAd instanceof AdLayout)) {
            return new AdLayoutWrapper((AdLayout) paramAd);
        }
        if ((paramAd instanceof InterstitialAd)) {
            return new InterstitialAdWrapper((InterstitialAd) paramAd);
        }
        return null;
    }

    public Ad getAd() {
        return this.adWrapper.getAd();
    }

    AdData getAdData() {
        return this.adWrapper.getAdData();
    }

    AdError getAdError() {
        return this.adError;
    }

    IAdLoaderCallback getAdLoaderCallback() {
        return this.adWrapper.getAdLoaderCallback();
    }

    public AdTargetingOptions getAdTargetingOptions() {
        return this.adOptions;
    }

    AdWrapper getAdWrapper() {
        return this.adWrapper;
    }

    int getSlotNumber() {
        return this.slotNumber;
    }

    void setAdError(AdError paramAdError) {
        this.adError = paramAdError;
    }

    void setSlotNumber(int paramInt) {
        this.slotNumber = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */