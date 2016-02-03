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
import com.mopub.common.LocationService.LocationAwareness;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.factories.AdFetcherFactory;
import com.mopub.mobileads.factories.HttpClientFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

public class AdViewController
{
  static final int DEFAULT_REFRESH_TIME_MILLISECONDS = 60000;
  static final int MINIMUM_REFRESH_TIME_MILLISECONDS = 10000;
  private static final FrameLayout.LayoutParams WRAP_AND_CENTER_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-2, -2, 17);
  private static WeakHashMap<View, Boolean> sViewShouldHonorServerDimensions = new WeakHashMap();
  private AdConfiguration mAdConfiguration;
  private AdFetcher mAdFetcher;
  private boolean mAutoRefreshEnabled = true;
  private final Context mContext;
  private GpsHelper.GpsHelperListener mGpsHelperListener;
  private Handler mHandler;
  private boolean mIsDestroyed;
  private boolean mIsFacebookSupported = true;
  private boolean mIsLoading;
  private boolean mIsTesting;
  private String mKeywords;
  private Map<String, Object> mLocalExtras = new HashMap();
  private Location mLocation;
  private LocationService.LocationAwareness mLocationAwareness = LocationService.LocationAwareness.NORMAL;
  private int mLocationPrecision = 6;
  private MoPubView mMoPubView;
  private final Runnable mRefreshRunnable;
  private String mUrl;
  private final WebViewAdUrlGenerator mUrlGenerator;
  
  public AdViewController(Context paramContext, MoPubView paramMoPubView)
  {
    this.mContext = paramContext;
    this.mMoPubView = paramMoPubView;
    this.mUrlGenerator = new WebViewAdUrlGenerator(paramContext);
    this.mAdConfiguration = new AdConfiguration(this.mContext);
    this.mAdFetcher = AdFetcherFactory.create(this, this.mAdConfiguration.getUserAgent());
    this.mGpsHelperListener = new AdViewControllerGpsHelperListener();
    GpsHelper.asyncFetchAdvertisingInfo(this.mContext);
    this.mRefreshRunnable = new Runnable()
    {
      public void run()
      {
        AdViewController.this.loadAd();
      }
    };
    this.mHandler = new Handler();
  }
  
  private void cancelRefreshTimer()
  {
    this.mHandler.removeCallbacks(this.mRefreshRunnable);
  }
  
  private FrameLayout.LayoutParams getAdLayoutParams(View paramView)
  {
    int i = this.mAdConfiguration.getWidth();
    int j = this.mAdConfiguration.getHeight();
    if ((getShouldHonorServerDimensions(paramView)) && (i > 0) && (j > 0)) {
      return new FrameLayout.LayoutParams(Dips.asIntPixels(i, this.mContext), Dips.asIntPixels(j, this.mContext), 17);
    }
    return WRAP_AND_CENTER_LAYOUT_PARAMS;
  }
  
  private String getServerHostname()
  {
    if (this.mIsTesting) {
      return "testing.ads.mopub.com";
    }
    return "ads.mopub.com";
  }
  
  private static boolean getShouldHonorServerDimensions(View paramView)
  {
    return sViewShouldHonorServerDimensions.get(paramView) != null;
  }
  
  private boolean isNetworkAvailable()
  {
    if (this.mContext.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return true;
      localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while ((localNetworkInfo != null) && (localNetworkInfo.isConnected()));
    return false;
  }
  
  protected static void setShouldHonorServerDimensions(View paramView)
  {
    sViewShouldHonorServerDimensions.put(paramView, Boolean.valueOf(true));
  }
  
  void adDidFail(MoPubErrorCode paramMoPubErrorCode)
  {
    Log.i("MoPub", "Ad failed to load.");
    setNotLoading();
    scheduleRefreshTimerIfEnabled();
    getMoPubView().adFailed(paramMoPubErrorCode);
  }
  
  void cleanup()
  {
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
  
  void configureUsingHttpResponse(HttpResponse paramHttpResponse)
  {
    this.mAdConfiguration.addHttpResponse(paramHttpResponse);
  }
  
  @Deprecated
  public void customEventActionWillBegin()
  {
    registerClick();
  }
  
  @Deprecated
  public void customEventDidFailToLoadAd()
  {
    loadFailUrl(MoPubErrorCode.UNSPECIFIED);
  }
  
  @Deprecated
  public void customEventDidLoadAd()
  {
    setNotLoading();
    trackImpression();
    scheduleRefreshTimerIfEnabled();
  }
  
  void fetchAd(String paramString)
  {
    if (this.mAdFetcher != null) {
      this.mAdFetcher.fetchAdForUrl(paramString);
    }
  }
  
  void forceRefresh()
  {
    setNotLoading();
    loadAd();
  }
  
  String generateAdUrl()
  {
    return this.mUrlGenerator.withAdUnitId(this.mAdConfiguration.getAdUnitId()).withKeywords(this.mKeywords).withFacebookSupported(this.mIsFacebookSupported).withLocation(this.mLocation).generateUrlString(getServerHostname());
  }
  
  AdConfiguration getAdConfiguration()
  {
    return this.mAdConfiguration;
  }
  
  public int getAdHeight()
  {
    return this.mAdConfiguration.getHeight();
  }
  
  Integer getAdTimeoutDelay()
  {
    return this.mAdConfiguration.getAdTimeoutDelay();
  }
  
  public String getAdUnitId()
  {
    return this.mAdConfiguration.getAdUnitId();
  }
  
  public int getAdWidth()
  {
    return this.mAdConfiguration.getWidth();
  }
  
  public boolean getAutorefreshEnabled()
  {
    return this.mAutoRefreshEnabled;
  }
  
  public String getClickthroughUrl()
  {
    return this.mAdConfiguration.getClickthroughUrl();
  }
  
  public String getKeywords()
  {
    return this.mKeywords;
  }
  
  Map<String, Object> getLocalExtras()
  {
    if (this.mLocalExtras != null) {
      return new HashMap(this.mLocalExtras);
    }
    return new HashMap();
  }
  
  public Location getLocation()
  {
    return this.mLocation;
  }
  
  int getLocationPrecision()
  {
    return this.mLocationPrecision;
  }
  
  public MoPubView getMoPubView()
  {
    return this.mMoPubView;
  }
  
  public String getRedirectUrl()
  {
    return this.mAdConfiguration.getRedirectUrl();
  }
  
  int getRefreshTimeMilliseconds()
  {
    return this.mAdConfiguration.getRefreshTimeMilliseconds();
  }
  
  public String getResponseString()
  {
    return this.mAdConfiguration.getResponseString();
  }
  
  public boolean getTesting()
  {
    return this.mIsTesting;
  }
  
  boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public boolean isFacebookSupported()
  {
    return this.mIsFacebookSupported;
  }
  
  public void loadAd()
  {
    if (this.mAdConfiguration.getAdUnitId() == null)
    {
      Log.d("MoPub", "Can't load an ad in this ad view because the ad unit ID is null. Did you forget to call setAdUnitId()?");
      return;
    }
    if (!isNetworkAvailable())
    {
      Log.d("MoPub", "Can't load an ad because there is no network connectivity.");
      scheduleRefreshTimerIfEnabled();
      return;
    }
    if (this.mLocation == null) {
      this.mLocation = LocationService.getLastKnownLocation(this.mContext, this.mLocationPrecision, this.mLocationAwareness);
    }
    GpsHelper.asyncFetchAdvertisingInfoIfNotCached(this.mContext, this.mGpsHelperListener);
  }
  
  void loadFailUrl(MoPubErrorCode paramMoPubErrorCode)
  {
    this.mIsLoading = false;
    StringBuilder localStringBuilder = new StringBuilder().append("MoPubErrorCode: ");
    if (paramMoPubErrorCode == null) {}
    for (paramMoPubErrorCode = "";; paramMoPubErrorCode = paramMoPubErrorCode.toString())
    {
      Log.v("MoPub", paramMoPubErrorCode);
      if (this.mAdConfiguration.getFailUrl() == null) {
        break;
      }
      Log.d("MoPub", "Loading failover url: " + this.mAdConfiguration.getFailUrl());
      loadNonJavascript(this.mAdConfiguration.getFailUrl());
      return;
    }
    adDidFail(MoPubErrorCode.NO_FILL);
  }
  
  void loadNonJavascript(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      Log.d("MoPub", "Loading url: " + paramString);
      if (!this.mIsLoading) {
        break;
      }
    } while (this.mAdConfiguration.getAdUnitId() == null);
    Log.i("MoPub", "Already loading an ad for " + this.mAdConfiguration.getAdUnitId() + ", wait to finish.");
    return;
    this.mUrl = paramString;
    this.mAdConfiguration.setFailUrl(null);
    this.mIsLoading = true;
    fetchAd(this.mUrl);
  }
  
  void registerClick()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        if (AdViewController.this.mAdConfiguration.getClickthroughUrl() == null) {
          return;
        }
        DefaultHttpClient localDefaultHttpClient = HttpClientFactory.create();
        try
        {
          Log.d("MoPub", "Tracking click for: " + AdViewController.this.mAdConfiguration.getClickthroughUrl());
          HttpGet localHttpGet = new HttpGet(AdViewController.this.mAdConfiguration.getClickthroughUrl());
          localHttpGet.addHeader("User-Agent", AdViewController.this.mAdConfiguration.getUserAgent());
          localDefaultHttpClient.execute(localHttpGet);
          return;
        }
        catch (Exception localException)
        {
          Log.d("MoPub", "Click tracking failed: " + AdViewController.this.mAdConfiguration.getClickthroughUrl(), localException);
          return;
        }
        finally
        {
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
    }).start();
  }
  
  public void reload()
  {
    Log.d("MoPub", "Reload ad: " + this.mUrl);
    loadNonJavascript(this.mUrl);
  }
  
  void scheduleRefreshTimerIfEnabled()
  {
    cancelRefreshTimer();
    if ((this.mAutoRefreshEnabled) && (this.mAdConfiguration.getRefreshTimeMilliseconds() > 0)) {
      this.mHandler.postDelayed(this.mRefreshRunnable, this.mAdConfiguration.getRefreshTimeMilliseconds());
    }
  }
  
  void setAdContentView(final View paramView)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        MoPubView localMoPubView = AdViewController.this.getMoPubView();
        if (localMoPubView == null) {
          return;
        }
        localMoPubView.removeAllViews();
        localMoPubView.addView(paramView, AdViewController.this.getAdLayoutParams(paramView));
      }
    });
  }
  
  public void setAdUnitId(String paramString)
  {
    this.mAdConfiguration.setAdUnitId(paramString);
  }
  
  public void setAutorefreshEnabled(boolean paramBoolean)
  {
    this.mAutoRefreshEnabled = paramBoolean;
    if (this.mAdConfiguration.getAdUnitId() != null) {
      Log.d("MoPub", "Automatic refresh for " + this.mAdConfiguration + " set to: " + paramBoolean + ".");
    }
    if (this.mAutoRefreshEnabled)
    {
      scheduleRefreshTimerIfEnabled();
      return;
    }
    cancelRefreshTimer();
  }
  
  @Deprecated
  public void setClickthroughUrl(String paramString)
  {
    this.mAdConfiguration.setClickthroughUrl(paramString);
  }
  
  public void setFacebookSupported(boolean paramBoolean)
  {
    this.mIsFacebookSupported = paramBoolean;
  }
  
  void setFailUrl(String paramString)
  {
    this.mAdConfiguration.setFailUrl(paramString);
  }
  
  @Deprecated
  void setGpsHelperListener(GpsHelper.GpsHelperListener paramGpsHelperListener)
  {
    this.mGpsHelperListener = paramGpsHelperListener;
  }
  
  public void setKeywords(String paramString)
  {
    this.mKeywords = paramString;
  }
  
  void setLocalExtras(Map<String, Object> paramMap)
  {
    if (paramMap != null) {}
    for (paramMap = new HashMap(paramMap);; paramMap = new HashMap())
    {
      this.mLocalExtras = paramMap;
      return;
    }
  }
  
  public void setLocation(Location paramLocation)
  {
    this.mLocation = paramLocation;
  }
  
  void setLocationPrecision(int paramInt)
  {
    this.mLocationPrecision = Math.max(0, paramInt);
  }
  
  void setNotLoading()
  {
    this.mIsLoading = false;
  }
  
  @Deprecated
  void setRefreshTimeMilliseconds(int paramInt)
  {
    this.mAdConfiguration.setRefreshTimeMilliseconds(paramInt);
  }
  
  public void setTesting(boolean paramBoolean)
  {
    this.mIsTesting = paramBoolean;
  }
  
  public void setTimeout(int paramInt)
  {
    if (this.mAdFetcher != null) {
      this.mAdFetcher.setTimeout(paramInt);
    }
  }
  
  void trackImpression()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        if (AdViewController.this.mAdConfiguration.getImpressionUrl() == null) {
          return;
        }
        DefaultHttpClient localDefaultHttpClient = HttpClientFactory.create();
        try
        {
          HttpGet localHttpGet = new HttpGet(AdViewController.this.mAdConfiguration.getImpressionUrl());
          localHttpGet.addHeader("User-Agent", AdViewController.this.mAdConfiguration.getUserAgent());
          localDefaultHttpClient.execute(localHttpGet);
          return;
        }
        catch (Exception localException)
        {
          Log.d("MoPub", "Impression tracking failed : " + AdViewController.this.mAdConfiguration.getImpressionUrl(), localException);
          return;
        }
        finally
        {
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
    }).start();
  }
  
  class AdViewControllerGpsHelperListener
    implements GpsHelper.GpsHelperListener
  {
    AdViewControllerGpsHelperListener() {}
    
    public void onFetchAdInfoCompleted()
    {
      String str = AdViewController.this.generateAdUrl();
      AdViewController.this.loadNonJavascript(str);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/AdViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */