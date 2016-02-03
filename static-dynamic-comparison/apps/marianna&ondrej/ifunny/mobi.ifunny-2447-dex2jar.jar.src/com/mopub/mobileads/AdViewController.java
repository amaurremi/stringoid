package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper.GpsHelperListener;
import com.mopub.common.LocationService;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.factories.AdFetcherFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.http.HttpResponse;

public class AdViewController {
    static final int DEFAULT_REFRESH_TIME_MILLISECONDS = 60000;
    static final int MINIMUM_REFRESH_TIME_MILLISECONDS = 10000;
    private static final FrameLayout.LayoutParams WRAP_AND_CENTER_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-2, -2, 17);
    private static WeakHashMap<View, Boolean> sViewShouldHonorServerDimensions = new WeakHashMap();
    private AdConfiguration mAdConfiguration;
    private AdFetcher mAdFetcher;
    private boolean mAdWasLoaded;
    private boolean mAutoRefreshEnabled = true;
    private final Context mContext;
    private GpsHelper.GpsHelperListener mGpsHelperListener;
    private Handler mHandler;
    private boolean mIsDestroyed;
    private boolean mIsLoading;
    private boolean mIsTesting;
    private String mKeywords;
    private Map<String, Object> mLocalExtras = new HashMap();
    private Location mLocation;
    private MoPubView mMoPubView;
    private boolean mPreviousAutoRefreshSetting = true;
    private final Runnable mRefreshRunnable;
    private String mUrl;
    private final WebViewAdUrlGenerator mUrlGenerator;

    public AdViewController(Context paramContext, MoPubView paramMoPubView) {
        this.mContext = paramContext;
        this.mMoPubView = paramMoPubView;
        this.mUrlGenerator = new WebViewAdUrlGenerator(paramContext);
        this.mAdConfiguration = new AdConfiguration(this.mContext);
        this.mAdFetcher = AdFetcherFactory.create(this, this.mAdConfiguration.getUserAgent());
        this.mGpsHelperListener = new AdViewController.AdViewControllerGpsHelperListener(this);
        GpsHelper.asyncFetchAdvertisingInfo(this.mContext);
        this.mRefreshRunnable = new AdViewController .1 (this);
        this.mHandler = new Handler();
    }

    private void cancelRefreshTimer() {
        this.mHandler.removeCallbacks(this.mRefreshRunnable);
    }

    private FrameLayout.LayoutParams getAdLayoutParams(View paramView) {
        int i = this.mAdConfiguration.getWidth();
        int j = this.mAdConfiguration.getHeight();
        if ((getShouldHonorServerDimensions(paramView)) && (i > 0) && (j > 0)) {
            return new FrameLayout.LayoutParams(Dips.asIntPixels(i, this.mContext), Dips.asIntPixels(j, this.mContext), 17);
        }
        return WRAP_AND_CENTER_LAYOUT_PARAMS;
    }

    private String getServerHostname() {
        if (this.mIsTesting) {
            return "testing.ads.mopub.com";
        }
        return "ads.mopub.com";
    }

    private static boolean getShouldHonorServerDimensions(View paramView) {
        return sViewShouldHonorServerDimensions.get(paramView) != null;
    }

    private boolean isNetworkAvailable() {
        if (this.mContext.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
            return true;
        }
        NetworkInfo localNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    private void setAutorefreshEnabled(boolean paramBoolean) {
        int i;
        String str1;
        label28:
        String str2;
        if ((this.mAdWasLoaded) && (this.mAutoRefreshEnabled != paramBoolean)) {
            i = 1;
            if (i != 0) {
                if (!paramBoolean) {
                    break label110;
                }
                str1 = "enabled";
                if (this.mAdConfiguration == null) {
                    break label116;
                }
                str2 = this.mAdConfiguration.getAdUnitId();
                label44:
                MoPubLog.d("Refresh " + str1 + " for ad unit (" + str2 + ").");
            }
            this.mAutoRefreshEnabled = paramBoolean;
            if ((!this.mAdWasLoaded) || (!this.mAutoRefreshEnabled)) {
                break label122;
            }
            scheduleRefreshTimerIfEnabled();
        }
        label110:
        label116:
        label122:
        while (this.mAutoRefreshEnabled) {
            return;
            i = 0;
            break;
            str1 = "disabled";
            break label28;
            str2 = null;
            break label44;
        }
        cancelRefreshTimer();
    }

    protected static void setShouldHonorServerDimensions(View paramView) {
        sViewShouldHonorServerDimensions.put(paramView, Boolean.valueOf(true));
    }

    void adDidFail(MoPubErrorCode paramMoPubErrorCode) {
        MoPubLog.i("Ad failed to load.");
        setNotLoading();
        scheduleRefreshTimerIfEnabled();
        getMoPubView().adFailed(paramMoPubErrorCode);
    }

    void cleanup() {
        if (this.mIsDestroyed) {
            return;
        }
        setAutorefreshEnabled(false);
        cancelRefreshTimer();
        this.mAdFetcher.cleanup();
        this.mAdFetcher = null;
        this.mAdConfiguration.cleanup();
        this.mMoPubView = null;
        this.mIsDestroyed = true;
    }

    void configureUsingHttpResponse(HttpResponse paramHttpResponse) {
        this.mAdConfiguration.addHttpResponse(paramHttpResponse);
    }

    @Deprecated
    public void customEventActionWillBegin() {
        registerClick();
    }

    @Deprecated
    public void customEventDidFailToLoadAd() {
        loadFailUrl(MoPubErrorCode.UNSPECIFIED);
    }

    @Deprecated
    public void customEventDidLoadAd() {
        setNotLoading();
        trackImpression();
        scheduleRefreshTimerIfEnabled();
    }

    void fetchAd(String paramString) {
        if (this.mAdFetcher != null) {
            this.mAdFetcher.fetchAdForUrl(paramString);
        }
    }

    void forceRefresh() {
        setNotLoading();
        loadAd();
    }

    void forceSetAutorefreshEnabled(boolean paramBoolean) {
        this.mPreviousAutoRefreshSetting = paramBoolean;
        setAutorefreshEnabled(paramBoolean);
    }

    String generateAdUrl() {
        return this.mUrlGenerator.withAdUnitId(this.mAdConfiguration.getAdUnitId()).withKeywords(this.mKeywords).withLocation(this.mLocation).generateUrlString(getServerHostname());
    }

    AdConfiguration getAdConfiguration() {
        return this.mAdConfiguration;
    }

    public int getAdHeight() {
        return this.mAdConfiguration.getHeight();
    }

    Integer getAdTimeoutDelay() {
        return this.mAdConfiguration.getAdTimeoutDelay();
    }

    public String getAdUnitId() {
        return this.mAdConfiguration.getAdUnitId();
    }

    public int getAdWidth() {
        return this.mAdConfiguration.getWidth();
    }

    public boolean getAutorefreshEnabled() {
        return this.mAutoRefreshEnabled;
    }

    public String getClickthroughUrl() {
        return this.mAdConfiguration.getClickthroughUrl();
    }

    public String getKeywords() {
        return this.mKeywords;
    }

    Map<String, Object> getLocalExtras() {
        if (this.mLocalExtras != null) {
            return new HashMap(this.mLocalExtras);
        }
        return new HashMap();
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public MoPubView getMoPubView() {
        return this.mMoPubView;
    }

    public String getRedirectUrl() {
        return this.mAdConfiguration.getRedirectUrl();
    }

    int getRefreshTimeMilliseconds() {
        return this.mAdConfiguration.getRefreshTimeMilliseconds();
    }

    public String getResponseString() {
        return this.mAdConfiguration.getResponseString();
    }

    public boolean getTesting() {
        return this.mIsTesting;
    }

    boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    @Deprecated
    public boolean isFacebookSupported() {
        return false;
    }

    public void loadAd() {
        this.mAdWasLoaded = true;
        if (this.mAdConfiguration.getAdUnitId() == null) {
            MoPubLog.d("Can't load an ad in this ad view because the ad unit ID is null. Did you forget to call setAdUnitId()?");
            return;
        }
        if (!isNetworkAvailable()) {
            MoPubLog.d("Can't load an ad because there is no network connectivity.");
            scheduleRefreshTimerIfEnabled();
            return;
        }
        if (this.mLocation == null) {
            this.mLocation = LocationService.getLastKnownLocation(this.mContext, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
        }
        GpsHelper.asyncFetchAdvertisingInfoIfNotCached(this.mContext, this.mGpsHelperListener);
    }

    void loadFailUrl(MoPubErrorCode paramMoPubErrorCode) {
        this.mIsLoading = false;
        StringBuilder localStringBuilder = new StringBuilder().append("MoPubErrorCode: ");
        if (paramMoPubErrorCode == null) {
        }
        for (paramMoPubErrorCode = ""; ; paramMoPubErrorCode = paramMoPubErrorCode.toString()) {
            Log.v("MoPub", paramMoPubErrorCode);
            if (this.mAdConfiguration.getFailUrl() == null) {
                break;
            }
            MoPubLog.d("Loading failover url: " + this.mAdConfiguration.getFailUrl());
            loadNonJavascript(this.mAdConfiguration.getFailUrl());
            return;
        }
        adDidFail(MoPubErrorCode.NO_FILL);
    }

    void loadNonJavascript(String paramString) {
        if (paramString == null) {
        }
        do {
            return;
            MoPubLog.d("Loading url: " + paramString);
            if (!this.mIsLoading) {
                break;
            }
        } while (this.mAdConfiguration.getAdUnitId() == null);
        MoPubLog.i("Already loading an ad for " + this.mAdConfiguration.getAdUnitId() + ", wait to finish.");
        return;
        this.mUrl = paramString;
        this.mAdConfiguration.setFailUrl(null);
        this.mIsLoading = true;
        fetchAd(this.mUrl);
    }

    void pauseRefresh() {
        this.mPreviousAutoRefreshSetting = this.mAutoRefreshEnabled;
        setAutorefreshEnabled(false);
    }

    void registerClick() {
        new Thread(new AdViewController .3 (this)).start();
    }

    public void reload() {
        MoPubLog.d("Reload ad: " + this.mUrl);
        loadNonJavascript(this.mUrl);
    }

    void scheduleRefreshTimerIfEnabled() {
        cancelRefreshTimer();
        if ((this.mAutoRefreshEnabled) && (this.mAdConfiguration.getRefreshTimeMilliseconds() > 0)) {
            this.mHandler.postDelayed(this.mRefreshRunnable, this.mAdConfiguration.getRefreshTimeMilliseconds());
        }
    }

    void setAdContentView(View paramView) {
        this.mHandler.post(new AdViewController .4 (this, paramView));
    }

    public void setAdUnitId(String paramString) {
        this.mAdConfiguration.setAdUnitId(paramString);
    }

    @Deprecated
    public void setClickthroughUrl(String paramString) {
        this.mAdConfiguration.setClickthroughUrl(paramString);
    }

    @Deprecated
    public void setFacebookSupported(boolean paramBoolean) {
    }

    void setFailUrl(String paramString) {
        this.mAdConfiguration.setFailUrl(paramString);
    }

    @Deprecated
    void setGpsHelperListener(GpsHelper.GpsHelperListener paramGpsHelperListener) {
        this.mGpsHelperListener = paramGpsHelperListener;
    }

    public void setKeywords(String paramString) {
        this.mKeywords = paramString;
    }

    void setLocalExtras(Map<String, Object> paramMap) {
        if (paramMap != null) {
        }
        for (paramMap = new HashMap(paramMap); ; paramMap = new HashMap()) {
            this.mLocalExtras = paramMap;
            return;
        }
    }

    public void setLocation(Location paramLocation) {
        this.mLocation = paramLocation;
    }

    void setNotLoading() {
        this.mIsLoading = false;
    }

    @Deprecated
    void setRefreshTimeMilliseconds(int paramInt) {
        this.mAdConfiguration.setRefreshTimeMilliseconds(paramInt);
    }

    public void setTesting(boolean paramBoolean) {
        this.mIsTesting = paramBoolean;
    }

    public void setTimeout(int paramInt) {
        if (this.mAdFetcher != null) {
            this.mAdFetcher.setTimeout(paramInt);
        }
    }

    void trackImpression() {
        new Thread(new AdViewController .2 (this)).start();
    }

    void unpauseRefresh() {
        setAutorefreshEnabled(this.mPreviousAutoRefreshSetting);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */