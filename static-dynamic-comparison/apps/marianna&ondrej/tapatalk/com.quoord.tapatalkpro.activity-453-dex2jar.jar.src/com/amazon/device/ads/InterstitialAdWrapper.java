package com.amazon.device.ads;

class InterstitialAdWrapper
        implements AdWrapper {
    private final InterstitialAd interstitialAd;

    InterstitialAdWrapper(InterstitialAd paramInterstitialAd) {
        this.interstitialAd = paramInterstitialAd;
    }

    public Ad getAd() {
        return this.interstitialAd;
    }

    public AdData getAdData() {
        return this.interstitialAd.getAdData();
    }

    public IAdLoaderCallback getAdLoaderCallback() {
        return this.interstitialAd.getAdLoaderCallback();
    }

    public int prepareAd(AdLoader.AdReadyToLoadListener paramAdReadyToLoadListener) {
        return this.interstitialAd.prepareAd(paramAdReadyToLoadListener);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/InterstitialAdWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */