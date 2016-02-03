package com.mopub.mobileads;

import android.content.Context;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.f;
import com.mopub.common.util.Views;

import java.util.Map;

class GooglePlayServicesBanner
        extends CustomEventBanner {
    private static final String AD_HEIGHT_KEY = "adHeight";
    private static final String AD_UNIT_ID_KEY = "adUnitID";
    private static final String AD_WIDTH_KEY = "adWidth";
    private static final String LOCATION_KEY = "location";
    private CustomEventBanner.CustomEventBannerListener mBannerListener;
    private f mGoogleAdView;

    private e calculateAdSize(int paramInt1, int paramInt2) {
        if ((paramInt1 <= e.a.b()) && (paramInt2 <= e.a.a())) {
            return e.a;
        }
        if ((paramInt1 <= e.e.b()) && (paramInt2 <= e.e.a())) {
            return e.e;
        }
        if ((paramInt1 <= e.b.b()) && (paramInt2 <= e.b.a())) {
            return e.b;
        }
        if ((paramInt1 <= e.d.b()) && (paramInt2 <= e.d.a())) {
            return e.d;
        }
        return null;
    }

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
    f getGoogleAdView() {
        return this.mGoogleAdView;
    }

    protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        this.mBannerListener = paramCustomEventBannerListener;
        if (extrasAreValid(paramMap1)) {
            paramCustomEventBannerListener = (String) paramMap1.get("adUnitID");
            int i = Integer.parseInt((String) paramMap1.get("adWidth"));
            int j = Integer.parseInt((String) paramMap1.get("adHeight"));
            this.mGoogleAdView = new f(paramContext);
            this.mGoogleAdView.setAdListener(new GooglePlayServicesBanner.AdViewListener(this, null));
            this.mGoogleAdView.setAdUnitId(paramCustomEventBannerListener);
            paramContext = calculateAdSize(i, j);
            if (paramContext == null) {
                this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            }
        } else {
            this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        this.mGoogleAdView.setAdSize(paramContext);
        paramContext = new d().a();
        try {
            this.mGoogleAdView.a(paramContext);
            return;
        } catch (NoClassDefFoundError paramContext) {
            this.mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    protected void onInvalidate() {
        Views.removeFromParent(this.mGoogleAdView);
        if (this.mGoogleAdView != null) {
            this.mGoogleAdView.setAdListener(null);
            this.mGoogleAdView.a();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/GooglePlayServicesBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */