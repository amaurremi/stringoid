package com.amazon.device.ads;

class AdLayoutWrapper
        implements AdWrapper {
    private final AdLayout adLayout;

    AdLayoutWrapper(AdLayout paramAdLayout) {
        this.adLayout = paramAdLayout;
    }

    public Ad getAd() {
        return this.adLayout;
    }

    public AdData getAdData() {
        return this.adLayout.getAdController().getAdData();
    }

    public IAdLoaderCallback getAdLoaderCallback() {
        return this.adLayout.getAdController();
    }

    public int prepareAd(AdLoader.AdReadyToLoadListener paramAdReadyToLoadListener) {
        return this.adLayout.prepareAd(paramAdReadyToLoadListener);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdLayoutWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */