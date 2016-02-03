package com.mopub.mobileads;

import android.content.Context;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.f;
import com.mopub.common.util.Views;

import java.util.Map;

import mobi.ifunny.f.a;

class AdMobGeneric
        extends CustomEventBanner {
    private static final String TAG = a.a;
    private f mAdMobView;
    private CustomEventBanner.CustomEventBannerListener mBannerListener;

    protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        this.mBannerListener = paramCustomEventBannerListener;
        paramCustomEventBannerListener = (String) paramMap1.get("pub_id");
        if (paramCustomEventBannerListener == null) {
            this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        this.mAdMobView = new f(paramContext);
        this.mAdMobView.setAdUnitId(paramCustomEventBannerListener);
        this.mAdMobView.setAdSize(e.g);
        this.mAdMobView.setAdListener(new AdMobGeneric.AdViewListener(this, null));
        paramContext = new d().a();
        this.mAdMobView.a(paramContext);
    }

    protected void onInvalidate() {
        if (this.mAdMobView != null) {
            this.mAdMobView.setAdListener(null);
            Views.removeFromParent(this.mAdMobView);
            this.mAdMobView.a();
        }
    }

    protected void onPause() {
        this.mAdMobView.b();
    }

    protected void onResume() {
        this.mAdMobView.c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdMobGeneric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */