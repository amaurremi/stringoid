package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.mopub.common.LocationService.LocationAwareness;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;
import com.mopub.mobileads.util.ResponseHeader;
import java.util.Map;

public class MoPubInterstitial
  implements CustomEventInterstitialAdapter.CustomEventInterstitialAdapterListener
{
  private Activity mActivity;
  private String mAdUnitId;
  private InterstitialState mCurrentInterstitialState;
  private CustomEventInterstitialAdapter mCustomEventInterstitialAdapter;
  private InterstitialAdListener mInterstitialAdListener;
  private MoPubInterstitialView mInterstitialView;
  private boolean mIsDestroyed;
  private MoPubInterstitialListener mListener;
  
  public MoPubInterstitial(Activity paramActivity, String paramString)
  {
    this.mActivity = paramActivity;
    this.mAdUnitId = paramString;
    this.mInterstitialView = new MoPubInterstitialView(this.mActivity);
    this.mInterstitialView.setAdUnitId(this.mAdUnitId);
    this.mCurrentInterstitialState = InterstitialState.NOT_READY;
  }
  
  private void resetCurrentInterstitial()
  {
    this.mCurrentInterstitialState = InterstitialState.NOT_READY;
    if (this.mCustomEventInterstitialAdapter != null)
    {
      this.mCustomEventInterstitialAdapter.invalidate();
      this.mCustomEventInterstitialAdapter = null;
    }
    this.mIsDestroyed = false;
  }
  
  private void showCustomEventInterstitial()
  {
    if (this.mCustomEventInterstitialAdapter != null) {
      this.mCustomEventInterstitialAdapter.showInterstitial();
    }
  }
  
  @Deprecated
  public void customEventActionWillBegin()
  {
    if (this.mInterstitialView != null) {
      this.mInterstitialView.registerClick();
    }
  }
  
  @Deprecated
  public void customEventDidFailToLoadAd()
  {
    if (this.mInterstitialView != null) {
      this.mInterstitialView.loadFailUrl(MoPubErrorCode.UNSPECIFIED);
    }
  }
  
  @Deprecated
  public void customEventDidLoadAd()
  {
    if (this.mInterstitialView != null) {
      this.mInterstitialView.trackImpression();
    }
  }
  
  public void destroy()
  {
    this.mIsDestroyed = true;
    if (this.mCustomEventInterstitialAdapter != null)
    {
      this.mCustomEventInterstitialAdapter.invalidate();
      this.mCustomEventInterstitialAdapter = null;
    }
    this.mInterstitialView.setBannerAdListener(null);
    this.mInterstitialView.destroy();
  }
  
  public void forceRefresh()
  {
    resetCurrentInterstitial();
    this.mInterstitialView.forceRefresh();
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  Integer getAdTimeoutDelay()
  {
    return this.mInterstitialView.getAdTimeoutDelay();
  }
  
  public InterstitialAdListener getInterstitialAdListener()
  {
    return this.mInterstitialAdListener;
  }
  
  public String getKeywords()
  {
    return this.mInterstitialView.getKeywords();
  }
  
  @Deprecated
  public MoPubInterstitialListener getListener()
  {
    return this.mListener;
  }
  
  public Map<String, Object> getLocalExtras()
  {
    return this.mInterstitialView.getLocalExtras();
  }
  
  public Location getLocation()
  {
    return this.mInterstitialView.getLocation();
  }
  
  public LocationService.LocationAwareness getLocationAwareness()
  {
    return this.mInterstitialView.getLocationAwareness();
  }
  
  public int getLocationPrecision()
  {
    return this.mInterstitialView.getLocationPrecision();
  }
  
  MoPubInterstitialView getMoPubInterstitialView()
  {
    return this.mInterstitialView;
  }
  
  public boolean getTesting()
  {
    return this.mInterstitialView.getTesting();
  }
  
  boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public boolean isFacebookSupported()
  {
    return this.mInterstitialView.isFacebookSupported();
  }
  
  public boolean isReady()
  {
    return this.mCurrentInterstitialState.isReady();
  }
  
  public void load()
  {
    resetCurrentInterstitial();
    this.mInterstitialView.loadAd();
  }
  
  public void onCustomEventInterstitialClicked()
  {
    if (isDestroyed()) {}
    do
    {
      return;
      this.mInterstitialView.registerClick();
    } while (this.mInterstitialAdListener == null);
    this.mInterstitialAdListener.onInterstitialClicked(this);
  }
  
  public void onCustomEventInterstitialDismissed()
  {
    if (isDestroyed()) {}
    do
    {
      return;
      this.mCurrentInterstitialState = InterstitialState.NOT_READY;
    } while (this.mInterstitialAdListener == null);
    this.mInterstitialAdListener.onInterstitialDismissed(this);
  }
  
  public void onCustomEventInterstitialFailed(MoPubErrorCode paramMoPubErrorCode)
  {
    if (isDestroyed()) {
      return;
    }
    this.mCurrentInterstitialState = InterstitialState.NOT_READY;
    this.mInterstitialView.loadFailUrl(paramMoPubErrorCode);
  }
  
  public void onCustomEventInterstitialLoaded()
  {
    if (this.mIsDestroyed) {}
    do
    {
      return;
      this.mCurrentInterstitialState = InterstitialState.CUSTOM_EVENT_AD_READY;
      if (this.mInterstitialAdListener != null)
      {
        this.mInterstitialAdListener.onInterstitialLoaded(this);
        return;
      }
    } while (this.mListener == null);
    this.mListener.OnInterstitialLoaded();
  }
  
  public void onCustomEventInterstitialShown()
  {
    if (isDestroyed()) {}
    do
    {
      return;
      this.mInterstitialView.trackImpression();
    } while (this.mInterstitialAdListener == null);
    this.mInterstitialAdListener.onInterstitialShown(this);
  }
  
  public void setFacebookSupported(boolean paramBoolean)
  {
    this.mInterstitialView.setFacebookSupported(paramBoolean);
  }
  
  public void setInterstitialAdListener(InterstitialAdListener paramInterstitialAdListener)
  {
    this.mInterstitialAdListener = paramInterstitialAdListener;
  }
  
  @Deprecated
  void setInterstitialView(MoPubInterstitialView paramMoPubInterstitialView)
  {
    this.mInterstitialView = paramMoPubInterstitialView;
  }
  
  public void setKeywords(String paramString)
  {
    this.mInterstitialView.setKeywords(paramString);
  }
  
  @Deprecated
  public void setListener(MoPubInterstitialListener paramMoPubInterstitialListener)
  {
    this.mListener = paramMoPubInterstitialListener;
  }
  
  public void setLocalExtras(Map<String, Object> paramMap)
  {
    this.mInterstitialView.setLocalExtras(paramMap);
  }
  
  public void setLocationAwareness(LocationService.LocationAwareness paramLocationAwareness)
  {
    this.mInterstitialView.setLocationAwareness(paramLocationAwareness);
  }
  
  public void setLocationPrecision(int paramInt)
  {
    this.mInterstitialView.setLocationPrecision(paramInt);
  }
  
  public void setTesting(boolean paramBoolean)
  {
    this.mInterstitialView.setTesting(paramBoolean);
  }
  
  public boolean show()
  {
    switch (this.mCurrentInterstitialState)
    {
    default: 
      return false;
    }
    showCustomEventInterstitial();
    return true;
  }
  
  public static abstract interface InterstitialAdListener
  {
    public abstract void onInterstitialClicked(MoPubInterstitial paramMoPubInterstitial);
    
    public abstract void onInterstitialDismissed(MoPubInterstitial paramMoPubInterstitial);
    
    public abstract void onInterstitialFailed(MoPubInterstitial paramMoPubInterstitial, MoPubErrorCode paramMoPubErrorCode);
    
    public abstract void onInterstitialLoaded(MoPubInterstitial paramMoPubInterstitial);
    
    public abstract void onInterstitialShown(MoPubInterstitial paramMoPubInterstitial);
  }
  
  private static enum InterstitialState
  {
    CUSTOM_EVENT_AD_READY,  NOT_READY;
    
    private InterstitialState() {}
    
    boolean isReady()
    {
      return this != NOT_READY;
    }
  }
  
  @Deprecated
  public static abstract interface MoPubInterstitialListener
  {
    public abstract void OnInterstitialFailed();
    
    public abstract void OnInterstitialLoaded();
  }
  
  public class MoPubInterstitialView
    extends MoPubView
  {
    public MoPubInterstitialView(Context paramContext)
    {
      super();
      setAutorefreshEnabled(false);
    }
    
    protected void adFailed(MoPubErrorCode paramMoPubErrorCode)
    {
      if (MoPubInterstitial.this.mInterstitialAdListener != null) {
        MoPubInterstitial.this.mInterstitialAdListener.onInterstitialFailed(MoPubInterstitial.this, paramMoPubErrorCode);
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
      if (MoPubInterstitial.this.mCustomEventInterstitialAdapter != null) {
        MoPubInterstitial.this.mCustomEventInterstitialAdapter.invalidate();
      }
      Log.d("MoPub", "Loading custom event interstitial adapter.");
      MoPubInterstitial.access$002(MoPubInterstitial.this, CustomEventInterstitialAdapterFactory.create(MoPubInterstitial.this, (String)paramMap.get(ResponseHeader.CUSTOM_EVENT_NAME.getKey()), (String)paramMap.get(ResponseHeader.CUSTOM_EVENT_DATA.getKey())));
      MoPubInterstitial.this.mCustomEventInterstitialAdapter.setAdapterListener(MoPubInterstitial.this);
      MoPubInterstitial.this.mCustomEventInterstitialAdapter.loadInterstitial();
    }
    
    protected void trackImpression()
    {
      Log.d("MoPub", "Tracking impression for interstitial.");
      if (this.mAdViewController != null) {
        this.mAdViewController.trackImpression();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MoPubInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */