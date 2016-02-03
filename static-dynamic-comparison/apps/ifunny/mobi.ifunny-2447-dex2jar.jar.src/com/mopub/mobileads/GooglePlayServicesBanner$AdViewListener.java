package com.mopub.mobileads;

import android.util.Log;
import com.google.android.gms.ads.a;

class GooglePlayServicesBanner$AdViewListener
        extends a {
    private GooglePlayServicesBanner$AdViewListener(GooglePlayServicesBanner paramGooglePlayServicesBanner) {
    }

    public void onAdClosed() {
    }

    public void onAdFailedToLoad(int paramInt) {
        Log.d("MoPub", "Google Play Services banner ad failed to load.");
        if (GooglePlayServicesBanner.access$100(this.this$0) != null) {
            GooglePlayServicesBanner.access$100(this.this$0).onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public void onAdLeftApplication() {
    }

    public void onAdLoaded() {
        Log.d("MoPub", "Google Play Services banner ad loaded successfully. Showing ad...");
        if (GooglePlayServicesBanner.access$100(this.this$0) != null) {
            GooglePlayServicesBanner.access$100(this.this$0).onBannerLoaded(GooglePlayServicesBanner.access$200(this.this$0));
        }
    }

    public void onAdOpened() {
        Log.d("MoPub", "Google Play Services banner ad clicked.");
        if (GooglePlayServicesBanner.access$100(this.this$0) != null) {
            GooglePlayServicesBanner.access$100(this.this$0).onBannerClicked();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/GooglePlayServicesBanner$AdViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */