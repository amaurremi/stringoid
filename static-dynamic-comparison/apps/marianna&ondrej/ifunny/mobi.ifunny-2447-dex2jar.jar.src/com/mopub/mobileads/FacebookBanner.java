package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.mopub.common.util.Views;

import java.util.Map;

public class FacebookBanner
        extends CustomEventBanner
        implements AdListener {
    private static final String PLACEMENT_ID_KEY = "placement_id";
    private CustomEventBanner.CustomEventBannerListener mBannerListener;
    private AdView mFacebookBanner;

    private boolean extrasAreValid(Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("placement_id");
        return (paramMap != null) && (paramMap.length() > 0);
    }

    @Deprecated
    AdView getAdView() {
        return this.mFacebookBanner;
    }

    protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        this.mBannerListener = paramCustomEventBannerListener;
        if (extrasAreValid(paramMap1)) {
            this.mFacebookBanner = new AdView(paramContext, (String) paramMap1.get("placement_id"), AdSize.BANNER_320_50);
            this.mFacebookBanner.setAdListener(this);
            this.mFacebookBanner.loadAd();
            return;
        }
        this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    public void onAdClicked(Ad paramAd) {
        Log.d("MoPub", "Facebook banner ad clicked.");
        this.mBannerListener.onBannerClicked();
    }

    public void onAdLoaded(Ad paramAd) {
        Log.d("MoPub", "Facebook banner ad loaded successfully. Showing ad...");
        this.mBannerListener.onBannerLoaded(this.mFacebookBanner);
    }

    public void onError(Ad paramAd, AdError paramAdError) {
        Log.d("MoPub", "Facebook banner ad failed to load.");
        if (paramAdError == AdError.NO_FILL) {
            this.mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
            return;
        }
        if (paramAdError == AdError.INTERNAL_ERROR) {
            this.mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        this.mBannerListener.onBannerFailed(MoPubErrorCode.UNSPECIFIED);
    }

    protected void onInvalidate() {
        if (this.mFacebookBanner != null) {
            Views.removeFromParent(this.mFacebookBanner);
            this.mFacebookBanner.destroy();
            this.mFacebookBanner = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/FacebookBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */