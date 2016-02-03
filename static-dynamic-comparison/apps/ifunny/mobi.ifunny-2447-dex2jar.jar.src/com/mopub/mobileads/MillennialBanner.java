package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;

import java.util.Map;

class MillennialBanner
        extends CustomEventBanner {
    public static final String AD_HEIGHT_KEY = "adHeight";
    public static final String AD_WIDTH_KEY = "adWidth";
    public static final String APID_KEY = "adUnitID";
    private CustomEventBanner.CustomEventBannerListener mBannerListener;
    private MMAdView mMillennialAdView;

    private boolean extrasAreValid(Map<String, String> paramMap) {
        try {
            Integer.parseInt((String) paramMap.get("adWidth"));
            Integer.parseInt((String) paramMap.get("adHeight"));
            return paramMap.containsKey("adUnitID");
        } catch (NumberFormatException paramMap) {
        }
        return false;
    }

    @Deprecated
    MMAdView getMMAdView() {
        return this.mMillennialAdView;
    }

    protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        this.mBannerListener = paramCustomEventBannerListener;
        if (extrasAreValid(paramMap1)) {
            paramCustomEventBannerListener = (String) paramMap1.get("adUnitID");
            int i = Integer.parseInt((String) paramMap1.get("adWidth"));
            int j = Integer.parseInt((String) paramMap1.get("adHeight"));
            MMSDK.initialize(paramContext);
            this.mMillennialAdView = new MMAdView(paramContext);
            this.mMillennialAdView.setListener(new MillennialBanner.MillennialBannerRequestListener(this));
            this.mMillennialAdView.setApid(paramCustomEventBannerListener);
            this.mMillennialAdView.setWidth(i);
            this.mMillennialAdView.setHeight(j);
            paramContext = (Location) paramMap.get("location");
            if (paramContext != null) {
                MMRequest.setUserLocation(paramContext);
            }
            this.mMillennialAdView.setMMRequest(new MMRequest());
            this.mMillennialAdView.setId(MMSDK.getDefaultAdId());
            AdViewController.setShouldHonorServerDimensions(this.mMillennialAdView);
            this.mMillennialAdView.getAd();
            return;
        }
        this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    protected void onInvalidate() {
        if (this.mMillennialAdView != null) {
            this.mMillennialAdView.setListener(null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MillennialBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */