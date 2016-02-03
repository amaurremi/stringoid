package com.mopub.mobileads;

import android.content.Context;
import android.net.Uri;
import com.mopub.mobileads.factories.MraidViewFactory;

import java.util.Map;

class MraidBanner
        extends CustomEventBanner {
    private CustomEventBanner.CustomEventBannerListener mBannerListener;
    private MraidView mMraidView;

    private boolean extrasAreValid(Map<String, String> paramMap) {
        return paramMap.containsKey("Html-Response-Body");
    }

    private void initMraidListener() {
        this.mMraidView.setMraidListener(new MraidBanner .1 (this));
    }

    private void onClose() {
        this.mBannerListener.onBannerCollapsed();
    }

    private void onExpand() {
        this.mBannerListener.onBannerExpanded();
        this.mBannerListener.onBannerClicked();
    }

    private void onFail() {
        this.mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
    }

    private void onOpen() {
        this.mBannerListener.onBannerClicked();
    }

    private void onReady() {
        this.mBannerListener.onBannerLoaded(this.mMraidView);
    }

    private void resetMraidListener() {
        this.mMraidView.setMraidListener(null);
    }

    protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        this.mBannerListener = paramCustomEventBannerListener;
        if (extrasAreValid(paramMap1)) {
            paramCustomEventBannerListener = Uri.decode((String) paramMap1.get("Html-Response-Body"));
            this.mMraidView = MraidViewFactory.create(paramContext, AdConfiguration.extractFromMap(paramMap));
            this.mMraidView.loadHtmlData(paramCustomEventBannerListener);
            initMraidListener();
            return;
        }
        this.mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
    }

    protected void onInvalidate() {
        if (this.mMraidView != null) {
            resetMraidListener();
            this.mMraidView.destroy();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */