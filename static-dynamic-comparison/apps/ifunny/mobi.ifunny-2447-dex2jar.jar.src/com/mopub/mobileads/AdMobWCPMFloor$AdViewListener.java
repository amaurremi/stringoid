package com.mopub.mobileads;

import com.google.android.gms.ads.a;
import mobi.ifunny.d;

class AdMobWCPMFloor$AdViewListener
        extends a {
    private AdMobWCPMFloor$AdViewListener(AdMobWCPMFloor paramAdMobWCPMFloor) {
    }

    public void onAdFailedToLoad(int paramInt) {
        d.b(AdMobWCPMFloor.access$100(), "Google Play Services banner ad failed to load. Code: " + paramInt);
        if (AdMobWCPMFloor.access$200(this.this$0) != null) {
            AdMobWCPMFloor.access$200(this.this$0).onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public void onAdLoaded() {
        d.b(AdMobWCPMFloor.access$100(), "Google Play Services banner ad loaded successfully. Showing ad...");
        if (AdMobWCPMFloor.access$200(this.this$0) != null) {
            AdMobWCPMFloor.access$200(this.this$0).onBannerLoaded(AdMobWCPMFloor.access$300(this.this$0));
        }
    }

    public void onAdOpened() {
        d.b(AdMobWCPMFloor.access$100(), "Google Play Services banner ad clicked.");
        if (AdMobWCPMFloor.access$200(this.this$0) != null) {
            AdMobWCPMFloor.access$200(this.this$0).onBannerClicked();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdMobWCPMFloor$AdViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */