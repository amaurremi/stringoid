package com.mopub.mobileads;

import android.net.Uri;
import com.mopub.common.CacheService;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.mobileads.util.vast.VastManager;
import com.mopub.mobileads.util.vast.VastManager.VastManagerListener;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;

import java.util.Map;

class VastVideoInterstitial
        extends ResponseBodyInterstitial
        implements VastManager.VastManagerListener {
    private CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;
    private VastManager mVastManager;
    private String mVastResponse;
    private VastVideoConfiguration mVastVideoConfiguration;

    protected void extractExtras(Map<String, String> paramMap) {
        this.mVastResponse = Uri.decode((String) paramMap.get("Html-Response-Body"));
    }

    @Deprecated
    String getVastResponse() {
        return this.mVastResponse;
    }

    protected void onInvalidate() {
        if (this.mVastManager != null) {
            this.mVastManager.cancel();
        }
        super.onInvalidate();
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfiguration paramVastVideoConfiguration) {
        if (paramVastVideoConfiguration == null) {
            this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
            return;
        }
        this.mVastVideoConfiguration = paramVastVideoConfiguration;
        this.mCustomEventInterstitialListener.onInterstitialLoaded();
    }

    protected void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener) {
        this.mCustomEventInterstitialListener = paramCustomEventInterstitialListener;
        if (!CacheService.initializeDiskCache(this.mContext)) {
            this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_CACHE_ERROR);
            return;
        }
        this.mVastManager = VastManagerFactory.create(this.mContext);
        this.mVastManager.prepareVastVideoConfiguration(this.mVastResponse, this);
    }

    @Deprecated
    void setVastManager(VastManager paramVastManager) {
        this.mVastManager = paramVastManager;
    }

    protected void showInterstitial() {
        MraidVideoPlayerActivity.startVast(this.mContext, this.mVastVideoConfiguration, this.mAdConfiguration);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */