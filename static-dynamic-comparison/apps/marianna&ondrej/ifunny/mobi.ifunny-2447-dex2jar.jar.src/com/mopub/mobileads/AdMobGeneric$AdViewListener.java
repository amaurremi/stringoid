package com.mopub.mobileads;

import com.google.android.gms.ads.a;
import mobi.ifunny.d;

class AdMobGeneric$AdViewListener
        extends a {
    private AdMobGeneric$AdViewListener(AdMobGeneric paramAdMobGeneric) {
    }

    public void onAdFailedToLoad(int paramInt) {
        d.b(AdMobGeneric.access$100(), "Google Play Services banner ad failed to load. Code: " + paramInt);
        if (AdMobGeneric.access$200(this.this$0) != null) {
            AdMobGeneric.access$200(this.this$0).onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public void onAdLoaded() {
        d.b(AdMobGeneric.access$100(), "Google Play Services banner ad loaded successfully. Showing ad...");
        if (AdMobGeneric.access$200(this.this$0) != null) {
            AdMobGeneric.access$200(this.this$0).onBannerLoaded(AdMobGeneric.access$300(this.this$0));
        }
    }

    public void onAdOpened() {
        d.b(AdMobGeneric.access$100(), "Google Play Services banner ad clicked.");
        if (AdMobGeneric.access$200(this.this$0) != null) {
            AdMobGeneric.access$200(this.this$0).onBannerClicked();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdMobGeneric$AdViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */