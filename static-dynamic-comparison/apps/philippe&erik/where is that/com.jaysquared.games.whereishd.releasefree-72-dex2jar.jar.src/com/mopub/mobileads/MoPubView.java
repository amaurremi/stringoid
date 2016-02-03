package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.mopub.common.LocationService.LocationAwareness;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import com.mopub.mobileads.factories.CustomEventBannerAdapterFactory;
import com.mopub.mobileads.util.ResponseHeader;
import java.util.Collections;
import java.util.Map;

public class MoPubView
  extends FrameLayout
{
  public static final String AD_HANDLER = "/m/ad";
  public static final int DEFAULT_LOCATION_PRECISION = 6;
  public static final String HOST = "ads.mopub.com";
  public static final String HOST_FOR_TESTING = "testing.ads.mopub.com";
  protected AdViewController mAdViewController;
  private BannerAdListener mBannerAdListener;
  private Context mContext;
  protected CustomEventBannerAdapter mCustomEventBannerAdapter;
  private boolean mIsInForeground;
  private LocationService.LocationAwareness mLocationAwareness;
  private OnAdClickedListener mOnAdClickedListener;
  private OnAdClosedListener mOnAdClosedListener;
  private OnAdFailedListener mOnAdFailedListener;
  private OnAdLoadedListener mOnAdLoadedListener;
  private OnAdPresentedOverlayListener mOnAdPresentedOverlayListener;
  private OnAdWillLoadListener mOnAdWillLoadListener;
  private boolean mPreviousAutorefreshSetting = false;
  private BroadcastReceiver mScreenStateReceiver;
  
  public MoPubView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MoPubView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    if (getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsInForeground = bool;
      this.mLocationAwareness = LocationService.LocationAwareness.NORMAL;
      setHorizontalScrollBarEnabled(false);
      setVerticalScrollBarEnabled(false);
      if (WebViewDatabase.getInstance(paramContext) != null) {
        break;
      }
      Log.e("MoPub", "Disabling MoPub. Local cache file is inaccessible so MoPub will fail if we try to create a WebView. Details of this Android bug found at:http://code.google.com/p/android/issues/detail?id=10789");
      return;
    }
    this.mAdViewController = AdViewControllerFactory.create(paramContext, this);
    registerScreenStateBroadcastReceiver();
  }
  
  private void registerScreenStateBroadcastReceiver()
  {
    if (this.mAdViewController == null) {
      return;
    }
    this.mScreenStateReceiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
          if (MoPubView.this.mIsInForeground)
          {
            Log.d("MoPub", "Screen sleep with ad in foreground, disable refresh");
            if (MoPubView.this.mAdViewController != null)
            {
              MoPubView.access$102(MoPubView.this, MoPubView.this.mAdViewController.getAutorefreshEnabled());
              MoPubView.this.mAdViewController.setAutorefreshEnabled(false);
            }
          }
        }
        do
        {
          do
          {
            return;
            Log.d("MoPub", "Screen sleep but ad in background; refresh should already be disabled");
            return;
          } while (!paramAnonymousIntent.getAction().equals("android.intent.action.USER_PRESENT"));
          if (!MoPubView.this.mIsInForeground) {
            break;
          }
          Log.d("MoPub", "Screen wake / ad in foreground, reset refresh");
        } while (MoPubView.this.mAdViewController == null);
        MoPubView.this.mAdViewController.setAutorefreshEnabled(MoPubView.this.mPreviousAutorefreshSetting);
        return;
        Log.d("MoPub", "Screen wake but ad in background; don't enable refresh");
      }
    };
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.mContext.registerReceiver(this.mScreenStateReceiver, localIntentFilter);
  }
  
  private void unregisterScreenStateBroadcastReceiver()
  {
    try
    {
      this.mContext.unregisterReceiver(this.mScreenStateReceiver);
      return;
    }
    catch (Exception localException)
    {
      Log.d("MoPub", "Failed to unregister screen state broadcast receiver (never registered).");
    }
  }
  
  protected void adClicked()
  {
    if (this.mBannerAdListener != null) {
      this.mBannerAdListener.onBannerClicked(this);
    }
    while (this.mOnAdClickedListener == null) {
      return;
    }
    this.mOnAdClickedListener.OnAdClicked(this);
  }
  
  protected void adClosed()
  {
    if (this.mBannerAdListener != null) {
      this.mBannerAdListener.onBannerCollapsed(this);
    }
    while (this.mOnAdClosedListener == null) {
      return;
    }
    this.mOnAdClosedListener.OnAdClosed(this);
  }
  
  protected void adFailed(MoPubErrorCode paramMoPubErrorCode)
  {
    if (this.mBannerAdListener != null) {
      this.mBannerAdListener.onBannerFailed(this, paramMoPubErrorCode);
    }
    while (this.mOnAdFailedListener == null) {
      return;
    }
    this.mOnAdFailedListener.OnAdFailed(this);
  }
  
  protected void adLoaded()
  {
    Log.d("MoPub", "adLoaded");
    if (this.mBannerAdListener != null) {
      this.mBannerAdListener.onBannerLoaded(this);
    }
    while (this.mOnAdLoadedListener == null) {
      return;
    }
    this.mOnAdLoadedListener.OnAdLoaded(this);
  }
  
  protected void adPresentedOverlay()
  {
    if (this.mBannerAdListener != null) {
      this.mBannerAdListener.onBannerExpanded(this);
    }
    while (this.mOnAdPresentedOverlayListener == null) {
      return;
    }
    this.mOnAdPresentedOverlayListener.OnAdPresentedOverlay(this);
  }
  
  @Deprecated
  protected void adWillLoad(String paramString)
  {
    Log.d("MoPub", "adWillLoad: " + paramString);
    if (this.mOnAdWillLoadListener != null) {
      this.mOnAdWillLoadListener.OnAdWillLoad(this, paramString);
    }
  }
  
  @Deprecated
  public void customEventActionWillBegin()
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.customEventActionWillBegin();
    }
  }
  
  @Deprecated
  public void customEventDidFailToLoadAd()
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.customEventDidFailToLoadAd();
    }
  }
  
  @Deprecated
  public void customEventDidLoadAd()
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.customEventDidLoadAd();
    }
  }
  
  public void destroy()
  {
    unregisterScreenStateBroadcastReceiver();
    removeAllViews();
    if (this.mAdViewController != null)
    {
      this.mAdViewController.cleanup();
      this.mAdViewController = null;
    }
    if (this.mCustomEventBannerAdapter != null)
    {
      this.mCustomEventBannerAdapter.invalidate();
      this.mCustomEventBannerAdapter = null;
    }
  }
  
  public void forceRefresh()
  {
    if (this.mCustomEventBannerAdapter != null)
    {
      this.mCustomEventBannerAdapter.invalidate();
      this.mCustomEventBannerAdapter = null;
    }
    if (this.mAdViewController != null) {
      this.mAdViewController.forceRefresh();
    }
  }
  
  public Activity getActivity()
  {
    return (Activity)this.mContext;
  }
  
  public int getAdHeight()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getAdHeight();
    }
    return 0;
  }
  
  Integer getAdTimeoutDelay()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getAdTimeoutDelay();
    }
    return null;
  }
  
  public String getAdUnitId()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getAdUnitId();
    }
    return null;
  }
  
  AdViewController getAdViewController()
  {
    return this.mAdViewController;
  }
  
  public int getAdWidth()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getAdWidth();
    }
    return 0;
  }
  
  public boolean getAutorefreshEnabled()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getAutorefreshEnabled();
    }
    Log.d("MoPub", "Can't get autorefresh status for destroyed MoPubView. Returning false.");
    return false;
  }
  
  public BannerAdListener getBannerAdListener()
  {
    return this.mBannerAdListener;
  }
  
  public String getClickthroughUrl()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getClickthroughUrl();
    }
    return null;
  }
  
  public String getKeywords()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getKeywords();
    }
    return null;
  }
  
  public Map<String, Object> getLocalExtras()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getLocalExtras();
    }
    return Collections.emptyMap();
  }
  
  public Location getLocation()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getLocation();
    }
    return null;
  }
  
  public LocationService.LocationAwareness getLocationAwareness()
  {
    return this.mLocationAwareness;
  }
  
  public int getLocationPrecision()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getLocationPrecision();
    }
    return 0;
  }
  
  public String getResponseString()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getResponseString();
    }
    return null;
  }
  
  public boolean getTesting()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.getTesting();
    }
    Log.d("MoPub", "Can't get testing status for destroyed MoPubView. Returning false.");
    return false;
  }
  
  public boolean isFacebookSupported()
  {
    if (this.mAdViewController != null) {
      return this.mAdViewController.isFacebookSupported();
    }
    return false;
  }
  
  public void loadAd()
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.loadAd();
    }
  }
  
  protected void loadCustomEvent(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      Log.d("MoPub", "Couldn't invoke custom event because the server did not specify one.");
      loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
      return;
    }
    if (this.mCustomEventBannerAdapter != null) {
      this.mCustomEventBannerAdapter.invalidate();
    }
    Log.d("MoPub", "Loading custom event adapter.");
    this.mCustomEventBannerAdapter = CustomEventBannerAdapterFactory.create(this, (String)paramMap.get(ResponseHeader.CUSTOM_EVENT_NAME.getKey()), (String)paramMap.get(ResponseHeader.CUSTOM_EVENT_DATA.getKey()));
    this.mCustomEventBannerAdapter.loadAd();
  }
  
  protected void loadFailUrl(MoPubErrorCode paramMoPubErrorCode)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.loadFailUrl(paramMoPubErrorCode);
    }
  }
  
  protected void nativeAdLoaded()
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.scheduleRefreshTimerIfEnabled();
    }
    adLoaded();
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    if (this.mAdViewController == null) {
      return;
    }
    if (paramInt == 0)
    {
      Log.d("MoPub", "Ad Unit (" + this.mAdViewController.getAdUnitId() + ") going visible: enabling refresh");
      this.mIsInForeground = true;
      this.mAdViewController.setAutorefreshEnabled(true);
      return;
    }
    Log.d("MoPub", "Ad Unit (" + this.mAdViewController.getAdUnitId() + ") going invisible: disabling refresh");
    this.mIsInForeground = false;
    this.mAdViewController.setAutorefreshEnabled(false);
  }
  
  protected void registerClick()
  {
    if (this.mAdViewController != null)
    {
      this.mAdViewController.registerClick();
      adClicked();
    }
  }
  
  public void setAdContentView(View paramView)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setAdContentView(paramView);
    }
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setAdUnitId(paramString);
    }
  }
  
  public void setAutorefreshEnabled(boolean paramBoolean)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setAutorefreshEnabled(paramBoolean);
    }
  }
  
  public void setBannerAdListener(BannerAdListener paramBannerAdListener)
  {
    this.mBannerAdListener = paramBannerAdListener;
  }
  
  public void setClickthroughUrl(String paramString)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setClickthroughUrl(paramString);
    }
  }
  
  public void setFacebookSupported(boolean paramBoolean)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setFacebookSupported(paramBoolean);
    }
  }
  
  public void setKeywords(String paramString)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setKeywords(paramString);
    }
  }
  
  public void setLocalExtras(Map<String, Object> paramMap)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setLocalExtras(paramMap);
    }
  }
  
  public void setLocation(Location paramLocation)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setLocation(paramLocation);
    }
  }
  
  public void setLocationAwareness(LocationService.LocationAwareness paramLocationAwareness)
  {
    this.mLocationAwareness = paramLocationAwareness;
  }
  
  public void setLocationPrecision(int paramInt)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setLocationPrecision(paramInt);
    }
  }
  
  @Deprecated
  public void setOnAdClickedListener(OnAdClickedListener paramOnAdClickedListener)
  {
    this.mOnAdClickedListener = paramOnAdClickedListener;
  }
  
  @Deprecated
  public void setOnAdClosedListener(OnAdClosedListener paramOnAdClosedListener)
  {
    this.mOnAdClosedListener = paramOnAdClosedListener;
  }
  
  @Deprecated
  public void setOnAdFailedListener(OnAdFailedListener paramOnAdFailedListener)
  {
    this.mOnAdFailedListener = paramOnAdFailedListener;
  }
  
  @Deprecated
  public void setOnAdLoadedListener(OnAdLoadedListener paramOnAdLoadedListener)
  {
    this.mOnAdLoadedListener = paramOnAdLoadedListener;
  }
  
  @Deprecated
  public void setOnAdPresentedOverlayListener(OnAdPresentedOverlayListener paramOnAdPresentedOverlayListener)
  {
    this.mOnAdPresentedOverlayListener = paramOnAdPresentedOverlayListener;
  }
  
  @Deprecated
  public void setOnAdWillLoadListener(OnAdWillLoadListener paramOnAdWillLoadListener)
  {
    this.mOnAdWillLoadListener = paramOnAdWillLoadListener;
  }
  
  public void setTesting(boolean paramBoolean)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setTesting(paramBoolean);
    }
  }
  
  public void setTimeout(int paramInt)
  {
    if (this.mAdViewController != null) {
      this.mAdViewController.setTimeout(paramInt);
    }
  }
  
  protected void trackNativeImpression()
  {
    Log.d("MoPub", "Tracking impression for native adapter.");
    if (this.mAdViewController != null) {
      this.mAdViewController.trackImpression();
    }
  }
  
  public static abstract interface BannerAdListener
  {
    public abstract void onBannerClicked(MoPubView paramMoPubView);
    
    public abstract void onBannerCollapsed(MoPubView paramMoPubView);
    
    public abstract void onBannerExpanded(MoPubView paramMoPubView);
    
    public abstract void onBannerFailed(MoPubView paramMoPubView, MoPubErrorCode paramMoPubErrorCode);
    
    public abstract void onBannerLoaded(MoPubView paramMoPubView);
  }
  
  @Deprecated
  public static abstract interface OnAdClickedListener
  {
    public abstract void OnAdClicked(MoPubView paramMoPubView);
  }
  
  @Deprecated
  public static abstract interface OnAdClosedListener
  {
    public abstract void OnAdClosed(MoPubView paramMoPubView);
  }
  
  @Deprecated
  public static abstract interface OnAdFailedListener
  {
    public abstract void OnAdFailed(MoPubView paramMoPubView);
  }
  
  @Deprecated
  public static abstract interface OnAdLoadedListener
  {
    public abstract void OnAdLoaded(MoPubView paramMoPubView);
  }
  
  @Deprecated
  public static abstract interface OnAdPresentedOverlayListener
  {
    public abstract void OnAdPresentedOverlay(MoPubView paramMoPubView);
  }
  
  @Deprecated
  public static abstract interface OnAdWillLoadListener
  {
    public abstract void OnAdWillLoad(MoPubView paramMoPubView, String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MoPubView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */