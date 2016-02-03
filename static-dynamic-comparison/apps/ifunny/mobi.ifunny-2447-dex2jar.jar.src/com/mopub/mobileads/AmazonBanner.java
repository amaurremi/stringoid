package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import com.amazon.device.ads.al;
import com.amazon.device.ads.bf;
import com.amazon.device.ads.br;
import com.mopub.common.util.Views;

import java.util.Map;

import mobi.ifunny.d;
import mobi.ifunny.f.a;

class AmazonBanner
        extends CustomEventBanner {
    private static final String TAG = a.a;
    private al adView;
    private CustomEventBanner.CustomEventBannerListener bannerListener;

    protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        this.bannerListener = paramCustomEventBannerListener;
        if ((paramContext == null) || (!(paramContext instanceof Activity))) {
            d.e(TAG, "Invalid context");
            this.bannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        paramCustomEventBannerListener = (Activity) paramContext;
        paramMap = (String) paramMap1.get("pub_id");
        paramMap1 = (String) paramMap1.get("floor_microd");
        if ((paramMap == null) || (paramMap1 == null)) {
            d.e(TAG, String.format("Invalid params (pubId == %s, floorMicroD == %s)", new Object[]{paramMap, paramMap1}));
            this.bannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        d.c(TAG, "Amazon pub id " + paramMap + " floor " + paramMap1);
        try {
            bf.a(paramMap);
            bf.a(false);
            bf.b(false);
            paramContext = a.c(paramContext);
            if (paramContext == null) {
                this.bannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
        } catch (Exception paramContext) {
            d.e(TAG, String.format("Amazon failed to set app key (%s)", new Object[]{paramMap}));
            this.bannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        this.adView = new al(paramCustomEventBannerListener, paramContext);
        paramContext = new FrameLayout.LayoutParams(-2, -2);
        this.adView.setLayoutParams(paramContext);
        this.adView.setListener(new AmazonBanner.AmazonBannerListener(this, null));
        paramContext = new br().a("ec", paramMap1);
        this.adView.a(paramContext);
    }

    protected void onInvalidate() {
        if (this.adView != null) {
            this.adView.setListener(null);
            Views.removeFromParent(this.adView);
            this.adView.j();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AmazonBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */