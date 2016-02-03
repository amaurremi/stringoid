package com.amazon.device.ads;

public class DefaultAdListener
        implements AdListener {
    final String LOG_TAG;

    public DefaultAdListener() {
        this(DefaultAdListener.class.getSimpleName());
    }

    DefaultAdListener(String paramString) {
        this.LOG_TAG = paramString;
    }

    public void onAdCollapsed(Ad paramAd) {
        Log.d(this.LOG_TAG, "Default ad listener called - Ad Collapsed.");
    }

    public void onAdDismissed(Ad paramAd) {
        Log.d(this.LOG_TAG, "Default ad listener called - Ad Dismissed.");
    }

    public void onAdExpanded(Ad paramAd) {
        Log.d(this.LOG_TAG, "Default ad listener called - Ad Will Expand.");
    }

    public void onAdFailedToLoad(Ad paramAd, AdError paramAdError) {
        Log.d(this.LOG_TAG, "Default ad listener called - Ad Failed to Load. Error code: %s, Error Message: %s", new Object[]{paramAdError.getCode(), paramAdError.getMessage()});
    }

    public void onAdLoaded(Ad paramAd, AdProperties paramAdProperties) {
        Log.d(this.LOG_TAG, "Default ad listener called - AdLoaded.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/DefaultAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */