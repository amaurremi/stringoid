package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.inneractive.api.ads.sdk.InneractiveAdView;
import com.inneractive.api.ads.sdk.InneractiveAdView.AdType;
import com.inneractive.api.ads.sdk.InneractiveAdView.MediationName;

import java.util.Map;

import mobi.ifunny.d;
import mobi.ifunny.f.a;

class InneractiveBanner
        extends CustomEventBanner {
    private static final String TAG = a.a;
    private InneractiveAdView inneractiveAd;

    public void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        d.c(TAG, "Inneractive custom event loadBanner");
        if (paramContext == null) {
            paramCustomEventBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        paramMap = (String) paramMap1.get("pub_id");
        if (TextUtils.isEmpty(paramMap)) {
            d.e("MoPub", "Inneractive pub id is not set");
            paramCustomEventBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        d.c("MoPub", "Inneractive pub id " + paramMap);
        paramCustomEventBannerListener = new InneractiveBanner .1 (this, paramCustomEventBannerListener);
        this.inneractiveAd = new InneractiveAdView(paramContext, paramMap, InneractiveAdView.AdType.Banner);
        this.inneractiveAd.setBannerAdListener(paramCustomEventBannerListener);
        this.inneractiveAd.setMediationName(InneractiveAdView.MediationName.MOPUB);
        this.inneractiveAd.loadAd();
    }

    public void onInvalidate() {
        d.c(TAG, "Inneractive custom event onInvalidate");
        if (this.inneractiveAd != null) {
            this.inneractiveAd.destroy();
            this.inneractiveAd = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/InneractiveBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */