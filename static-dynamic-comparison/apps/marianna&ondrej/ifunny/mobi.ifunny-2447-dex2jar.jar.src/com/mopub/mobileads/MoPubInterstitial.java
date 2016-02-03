package com.mopub.mobileads;

import android.app.Activity;
import android.location.Location;
import com.mopub.common.LocationService.LocationAwareness;
import com.mopub.common.MoPub;

import java.util.Map;

public class MoPubInterstitial
        implements CustomEventInterstitialAdapter.CustomEventInterstitialAdapterListener {
    private Activity mActivity;
    private String mAdUnitId;
    private MoPubInterstitial.InterstitialState mCurrentInterstitialState;
    private CustomEventInterstitialAdapter mCustomEventInterstitialAdapter;
    private MoPubInterstitial.InterstitialAdListener mInterstitialAdListener;
    private MoPubInterstitial.MoPubInterstitialView mInterstitialView;
    private boolean mIsDestroyed;
    private MoPubInterstitial.MoPubInterstitialListener mListener;

    public MoPubInterstitial(Activity paramActivity, String paramString) {
        this.mActivity = paramActivity;
        this.mAdUnitId = paramString;
        this.mInterstitialView = new MoPubInterstitial.MoPubInterstitialView(this, this.mActivity);
        this.mInterstitialView.setAdUnitId(this.mAdUnitId);
        this.mCurrentInterstitialState = MoPubInterstitial.InterstitialState.NOT_READY;
    }

    private void resetCurrentInterstitial() {
        this.mCurrentInterstitialState = MoPubInterstitial.InterstitialState.NOT_READY;
        if (this.mCustomEventInterstitialAdapter != null) {
            this.mCustomEventInterstitialAdapter.invalidate();
            this.mCustomEventInterstitialAdapter = null;
        }
        this.mIsDestroyed = false;
    }

    private void showCustomEventInterstitial() {
        if (this.mCustomEventInterstitialAdapter != null) {
            this.mCustomEventInterstitialAdapter.showInterstitial();
        }
    }

    @Deprecated
    public void customEventActionWillBegin() {
        if (this.mInterstitialView != null) {
            this.mInterstitialView.registerClick();
        }
    }

    @Deprecated
    public void customEventDidFailToLoadAd() {
        if (this.mInterstitialView != null) {
            this.mInterstitialView.loadFailUrl(MoPubErrorCode.UNSPECIFIED);
        }
    }

    @Deprecated
    public void customEventDidLoadAd() {
        if (this.mInterstitialView != null) {
            this.mInterstitialView.trackImpression();
        }
    }

    public void destroy() {
        this.mIsDestroyed = true;
        if (this.mCustomEventInterstitialAdapter != null) {
            this.mCustomEventInterstitialAdapter.invalidate();
            this.mCustomEventInterstitialAdapter = null;
        }
        this.mInterstitialView.setBannerAdListener(null);
        this.mInterstitialView.destroy();
    }

    public void forceRefresh() {
        resetCurrentInterstitial();
        this.mInterstitialView.forceRefresh();
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    Integer getAdTimeoutDelay() {
        return this.mInterstitialView.getAdTimeoutDelay();
    }

    public MoPubInterstitial.InterstitialAdListener getInterstitialAdListener() {
        return this.mInterstitialAdListener;
    }

    public String getKeywords() {
        return this.mInterstitialView.getKeywords();
    }

    @Deprecated
    public MoPubInterstitial.MoPubInterstitialListener getListener() {
        return this.mListener;
    }

    public Map<String, Object> getLocalExtras() {
        return this.mInterstitialView.getLocalExtras();
    }

    public Location getLocation() {
        return this.mInterstitialView.getLocation();
    }

    @Deprecated
    public LocationService.LocationAwareness getLocationAwareness() {
        return LocationService.LocationAwareness.fromMoPubLocationAwareness(MoPub.getLocationAwareness());
    }

    @Deprecated
    public int getLocationPrecision() {
        return MoPub.getLocationPrecision();
    }

    MoPubInterstitial.MoPubInterstitialView getMoPubInterstitialView() {
        return this.mInterstitialView;
    }

    public boolean getTesting() {
        return this.mInterstitialView.getTesting();
    }

    boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    @Deprecated
    public boolean isFacebookSupported() {
        return false;
    }

    public boolean isReady() {
        return this.mCurrentInterstitialState.isReady();
    }

    public void load() {
        resetCurrentInterstitial();
        this.mInterstitialView.loadAd();
    }

    public void onCustomEventInterstitialClicked() {
        if (isDestroyed()) {
        }
        do {
            return;
            this.mInterstitialView.registerClick();
        } while (this.mInterstitialAdListener == null);
        this.mInterstitialAdListener.onInterstitialClicked(this);
    }

    public void onCustomEventInterstitialDismissed() {
        if (isDestroyed()) {
        }
        do {
            return;
            this.mCurrentInterstitialState = MoPubInterstitial.InterstitialState.NOT_READY;
        } while (this.mInterstitialAdListener == null);
        this.mInterstitialAdListener.onInterstitialDismissed(this);
    }

    public void onCustomEventInterstitialFailed(MoPubErrorCode paramMoPubErrorCode) {
        if (isDestroyed()) {
            return;
        }
        this.mCurrentInterstitialState = MoPubInterstitial.InterstitialState.NOT_READY;
        this.mInterstitialView.loadFailUrl(paramMoPubErrorCode);
    }

    public void onCustomEventInterstitialLoaded() {
        if (this.mIsDestroyed) {
        }
        do {
            return;
            this.mCurrentInterstitialState = MoPubInterstitial.InterstitialState.CUSTOM_EVENT_AD_READY;
            if (this.mInterstitialAdListener != null) {
                this.mInterstitialAdListener.onInterstitialLoaded(this);
                return;
            }
        } while (this.mListener == null);
        this.mListener.OnInterstitialLoaded();
    }

    public void onCustomEventInterstitialShown() {
        if (isDestroyed()) {
        }
        do {
            return;
            this.mInterstitialView.trackImpression();
        } while (this.mInterstitialAdListener == null);
        this.mInterstitialAdListener.onInterstitialShown(this);
    }

    @Deprecated
    public void setFacebookSupported(boolean paramBoolean) {
    }

    public void setInterstitialAdListener(MoPubInterstitial.InterstitialAdListener paramInterstitialAdListener) {
        this.mInterstitialAdListener = paramInterstitialAdListener;
    }

    @Deprecated
    void setInterstitialView(MoPubInterstitial.MoPubInterstitialView paramMoPubInterstitialView) {
        this.mInterstitialView = paramMoPubInterstitialView;
    }

    public void setKeywords(String paramString) {
        this.mInterstitialView.setKeywords(paramString);
    }

    @Deprecated
    public void setListener(MoPubInterstitial.MoPubInterstitialListener paramMoPubInterstitialListener) {
        this.mListener = paramMoPubInterstitialListener;
    }

    public void setLocalExtras(Map<String, Object> paramMap) {
        this.mInterstitialView.setLocalExtras(paramMap);
    }

    @Deprecated
    public void setLocationAwareness(LocationService.LocationAwareness paramLocationAwareness) {
        MoPub.setLocationAwareness(paramLocationAwareness.getNewLocationAwareness());
    }

    @Deprecated
    public void setLocationPrecision(int paramInt) {
        MoPub.setLocationPrecision(paramInt);
    }

    public void setTesting(boolean paramBoolean) {
        this.mInterstitialView.setTesting(paramBoolean);
    }

    public boolean show() {
        switch (MoPubInterstitial
        .1.$SwitchMap$com$mopub$mobileads$MoPubInterstitial$InterstitialState[this.mCurrentInterstitialState.ordinal()])
        {
            default:
                return false;
        }
        showCustomEventInterstitial();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */