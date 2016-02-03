package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.mopub.common.LocationService.LocationAwareness;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import com.mopub.mobileads.factories.CustomEventBannerAdapterFactory;

import java.util.Collections;
import java.util.Map;

public class MoPubView
        extends FrameLayout {
    public static final String AD_HANDLER = "/m/ad";
    public static final int DEFAULT_LOCATION_PRECISION = 6;
    public static final String HOST = "ads.mopub.com";
    public static final String HOST_FOR_TESTING = "testing.ads.mopub.com";
    private MoPubView.MopubAdReporter adReporter;
    protected AdViewController mAdViewController;
    private MoPubView.BannerAdListener mBannerAdListener;
    private Context mContext;
    protected CustomEventBannerAdapter mCustomEventBannerAdapter;
    private MoPubView.OnAdClickedListener mOnAdClickedListener;
    private MoPubView.OnAdClosedListener mOnAdClosedListener;
    private MoPubView.OnAdFailedListener mOnAdFailedListener;
    private MoPubView.OnAdLoadedListener mOnAdLoadedListener;
    private MoPubView.OnAdPresentedOverlayListener mOnAdPresentedOverlayListener;
    private MoPubView.OnAdWillLoadListener mOnAdWillLoadListener;
    private BroadcastReceiver mScreenStateReceiver;
    private int mScreenVisibility;

    public MoPubView(Context paramContext) {
        this(paramContext, null);
    }

    public MoPubView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        ManifestUtils.checkWebViewActivitiesDeclared(paramContext);
        this.mContext = paramContext;
        this.mScreenVisibility = getVisibility();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (WebViewDatabase.getInstance(paramContext) == null) {
            MoPubLog.e("Disabling MoPub. Local cache file is inaccessible so MoPub will fail if we try to create a WebView. Details of this Android bug found at:http://code.google.com/p/android/issues/detail?id=10789");
            return;
        }
        this.mAdViewController = AdViewControllerFactory.create(paramContext, this);
        registerScreenStateBroadcastReceiver();
    }

    private void registerScreenStateBroadcastReceiver() {
        this.mScreenStateReceiver = new MoPubView .1 (this);
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        this.mContext.registerReceiver(this.mScreenStateReceiver, localIntentFilter);
    }

    private void setAdVisibility(int paramInt) {
        if (this.mAdViewController == null) {
            return;
        }
        if (Visibility.isScreenVisible(paramInt)) {
            this.mAdViewController.unpauseRefresh();
            return;
        }
        this.mAdViewController.pauseRefresh();
    }

    private void unregisterScreenStateBroadcastReceiver() {
        try {
            this.mContext.unregisterReceiver(this.mScreenStateReceiver);
            return;
        } catch (Exception localException) {
            MoPubLog.d("Failed to unregister screen state broadcast receiver (never registered).");
        }
    }

    protected void adClicked() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerClicked(this);
        }
        while (this.mOnAdClickedListener == null) {
            return;
        }
        this.mOnAdClickedListener.OnAdClicked(this);
    }

    protected void adClosed() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerCollapsed(this);
        }
        while (this.mOnAdClosedListener == null) {
            return;
        }
        this.mOnAdClosedListener.OnAdClosed(this);
    }

    protected void adFailed(MoPubErrorCode paramMoPubErrorCode) {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerFailed(this, paramMoPubErrorCode);
        }
        while (this.mOnAdFailedListener == null) {
            return;
        }
        this.mOnAdFailedListener.OnAdFailed(this);
    }

    protected void adLoaded() {
        MoPubLog.d("adLoaded");
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerLoaded(this);
        }
        while (this.mOnAdLoadedListener == null) {
            return;
        }
        this.mOnAdLoadedListener.OnAdLoaded(this);
    }

    protected void adPresentedOverlay() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerExpanded(this);
        }
        while (this.mOnAdPresentedOverlayListener == null) {
            return;
        }
        this.mOnAdPresentedOverlayListener.OnAdPresentedOverlay(this);
    }

    @Deprecated
    protected void adWillLoad(String paramString) {
        MoPubLog.d("adWillLoad: " + paramString);
        if (this.mOnAdWillLoadListener != null) {
            this.mOnAdWillLoadListener.OnAdWillLoad(this, paramString);
        }
    }

    @Deprecated
    public void customEventActionWillBegin() {
        if (this.mAdViewController != null) {
            this.mAdViewController.customEventActionWillBegin();
        }
    }

    @Deprecated
    public void customEventDidFailToLoadAd() {
        if (this.mAdViewController != null) {
            this.mAdViewController.customEventDidFailToLoadAd();
        }
    }

    @Deprecated
    public void customEventDidLoadAd() {
        if (this.mAdViewController != null) {
            this.mAdViewController.customEventDidLoadAd();
        }
    }

    public void destroy() {
        unregisterScreenStateBroadcastReceiver();
        removeAllViews();
        if (this.mAdViewController != null) {
            this.mAdViewController.cleanup();
            this.mAdViewController = null;
        }
        if (this.mCustomEventBannerAdapter != null) {
            this.mCustomEventBannerAdapter.invalidate();
            this.mCustomEventBannerAdapter = null;
        }
    }

    public void forceRefresh() {
        if (this.mCustomEventBannerAdapter != null) {
            this.mCustomEventBannerAdapter.invalidate();
            this.mCustomEventBannerAdapter = null;
        }
        if (this.mAdViewController != null) {
            this.mAdViewController.forceRefresh();
        }
    }

    public Activity getActivity() {
        return (Activity) this.mContext;
    }

    public int getAdHeight() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getAdHeight();
        }
        return 0;
    }

    Integer getAdTimeoutDelay() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getAdTimeoutDelay();
        }
        return null;
    }

    public String getAdUnitId() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getAdUnitId();
        }
        return null;
    }

    AdViewController getAdViewController() {
        return this.mAdViewController;
    }

    public int getAdWidth() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getAdWidth();
        }
        return 0;
    }

    public boolean getAutorefreshEnabled() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getAutorefreshEnabled();
        }
        MoPubLog.d("Can't get autorefresh status for destroyed MoPubView. Returning false.");
        return false;
    }

    public MoPubView.BannerAdListener getBannerAdListener() {
        return this.mBannerAdListener;
    }

    public String getClickthroughUrl() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getClickthroughUrl();
        }
        return null;
    }

    public String getKeywords() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getKeywords();
        }
        return null;
    }

    public Map<String, Object> getLocalExtras() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getLocalExtras();
        }
        return Collections.emptyMap();
    }

    public Location getLocation() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getLocation();
        }
        return null;
    }

    @Deprecated
    public LocationService.LocationAwareness getLocationAwareness() {
        return LocationService.LocationAwareness.fromMoPubLocationAwareness(MoPub.getLocationAwareness());
    }

    @Deprecated
    public int getLocationPrecision() {
        return MoPub.getLocationPrecision();
    }

    public String getResponseString() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getResponseString();
        }
        return null;
    }

    public boolean getTesting() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getTesting();
        }
        MoPubLog.d("Can't get testing status for destroyed MoPubView. Returning false.");
        return false;
    }

    @Deprecated
    public boolean isFacebookSupported() {
        return false;
    }

    public void loadAd() {
        if (this.mAdViewController != null) {
            this.mAdViewController.loadAd();
        }
    }

    protected void loadCustomEvent(Map<String, String> paramMap) {
        if (paramMap == null) {
            MoPubLog.d("Couldn't invoke custom event because the server did not specify one.");
            loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        if (this.mCustomEventBannerAdapter != null) {
            this.mCustomEventBannerAdapter.invalidate();
        }
        MoPubLog.d("Loading custom event adapter.");
        this.mCustomEventBannerAdapter = CustomEventBannerAdapterFactory.create(this, (String) paramMap.get(ResponseHeader.CUSTOM_EVENT_NAME.getKey()), (String) paramMap.get(ResponseHeader.CUSTOM_EVENT_DATA.getKey()));
        this.mCustomEventBannerAdapter.loadAd();
    }

    protected void loadFailUrl(MoPubErrorCode paramMoPubErrorCode) {
        if (this.mAdViewController != null) {
            this.mAdViewController.loadFailUrl(paramMoPubErrorCode);
        }
    }

    protected void nativeAdLoaded() {
        if (this.mAdViewController != null) {
            this.mAdViewController.scheduleRefreshTimerIfEnabled();
        }
        adLoaded();
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        if (Visibility.hasScreenVisibilityChanged(this.mScreenVisibility, paramInt)) {
            this.mScreenVisibility = paramInt;
            setAdVisibility(this.mScreenVisibility);
        }
    }

    @TargetApi(11)
    public void pause() {
        if (this.mCustomEventBannerAdapter != null) {
            this.mCustomEventBannerAdapter.pause();
        }
        if (Build.VERSION.SDK_INT < 11) {
        }
        for (; ; ) {
            return;
            int i = 0;
            while (i < getChildCount()) {
                View localView = getChildAt(i);
                if ((localView instanceof WebView)) {
                    ((WebView) localView).onPause();
                }
                i += 1;
            }
        }
    }

    protected void registerClick() {
        if (this.mAdViewController != null) {
            this.mAdViewController.registerClick();
            adClicked();
        }
    }

    void report(String paramString) {
        if (this.adReporter != null) {
            post(new MoPubView .2 (this, paramString));
        }
    }

    @TargetApi(11)
    public void resume() {
        if (this.mCustomEventBannerAdapter != null) {
            this.mCustomEventBannerAdapter.resume();
        }
        if (Build.VERSION.SDK_INT < 11) {
        }
        for (; ; ) {
            return;
            int i = 0;
            while (i < getChildCount()) {
                View localView = getChildAt(i);
                if ((localView instanceof WebView)) {
                    ((WebView) localView).onResume();
                }
                i += 1;
            }
        }
    }

    public void setAdContentView(View paramView) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setAdContentView(paramView);
        }
    }

    public void setAdReporter(MoPubView.MopubAdReporter paramMopubAdReporter) {
        this.adReporter = paramMopubAdReporter;
    }

    public void setAdUnitId(String paramString) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setAdUnitId(paramString);
        }
    }

    public void setAutorefreshEnabled(boolean paramBoolean) {
        if (this.mAdViewController != null) {
            this.mAdViewController.forceSetAutorefreshEnabled(paramBoolean);
        }
    }

    public void setBannerAdListener(MoPubView.BannerAdListener paramBannerAdListener) {
        this.mBannerAdListener = paramBannerAdListener;
    }

    public void setClickthroughUrl(String paramString) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setClickthroughUrl(paramString);
        }
    }

    @Deprecated
    public void setFacebookSupported(boolean paramBoolean) {
    }

    public void setKeywords(String paramString) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setKeywords(paramString);
        }
    }

    public void setLocalExtras(Map<String, Object> paramMap) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setLocalExtras(paramMap);
        }
    }

    public void setLocation(Location paramLocation) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setLocation(paramLocation);
        }
    }

    @Deprecated
    public void setLocationAwareness(LocationService.LocationAwareness paramLocationAwareness) {
        MoPub.setLocationAwareness(paramLocationAwareness.getNewLocationAwareness());
    }

    @Deprecated
    public void setLocationPrecision(int paramInt) {
        MoPub.setLocationPrecision(paramInt);
    }

    @Deprecated
    public void setOnAdClickedListener(MoPubView.OnAdClickedListener paramOnAdClickedListener) {
        this.mOnAdClickedListener = paramOnAdClickedListener;
    }

    @Deprecated
    public void setOnAdClosedListener(MoPubView.OnAdClosedListener paramOnAdClosedListener) {
        this.mOnAdClosedListener = paramOnAdClosedListener;
    }

    @Deprecated
    public void setOnAdFailedListener(MoPubView.OnAdFailedListener paramOnAdFailedListener) {
        this.mOnAdFailedListener = paramOnAdFailedListener;
    }

    @Deprecated
    public void setOnAdLoadedListener(MoPubView.OnAdLoadedListener paramOnAdLoadedListener) {
        this.mOnAdLoadedListener = paramOnAdLoadedListener;
    }

    @Deprecated
    public void setOnAdPresentedOverlayListener(MoPubView.OnAdPresentedOverlayListener paramOnAdPresentedOverlayListener) {
        this.mOnAdPresentedOverlayListener = paramOnAdPresentedOverlayListener;
    }

    @Deprecated
    public void setOnAdWillLoadListener(MoPubView.OnAdWillLoadListener paramOnAdWillLoadListener) {
        this.mOnAdWillLoadListener = paramOnAdWillLoadListener;
    }

    public void setTesting(boolean paramBoolean) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setTesting(paramBoolean);
        }
    }

    public void setTimeout(int paramInt) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setTimeout(paramInt);
        }
    }

    protected void trackNativeImpression() {
        MoPubLog.d("Tracking impression for native adapter.");
        if (this.mAdViewController != null) {
            this.mAdViewController.trackImpression();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */