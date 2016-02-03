package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.mopub.mobileads.factories.CustomEventInterstitialFactory;
import com.mopub.mobileads.util.Json;
import java.util.HashMap;
import java.util.Map;

public class CustomEventInterstitialAdapter
  implements CustomEventInterstitial.CustomEventInterstitialListener
{
  public static final int DEFAULT_INTERSTITIAL_TIMEOUT_DELAY = 30000;
  private Context mContext;
  private CustomEventInterstitial mCustomEventInterstitial;
  private CustomEventInterstitialAdapterListener mCustomEventInterstitialAdapterListener;
  private final Handler mHandler = new Handler();
  private boolean mInvalidated;
  private Map<String, Object> mLocalExtras;
  private final MoPubInterstitial mMoPubInterstitial;
  private Map<String, String> mServerExtras;
  private final Runnable mTimeout;
  
  public CustomEventInterstitialAdapter(MoPubInterstitial paramMoPubInterstitial, String paramString1, String paramString2)
  {
    this.mMoPubInterstitial = paramMoPubInterstitial;
    this.mServerExtras = new HashMap();
    this.mLocalExtras = new HashMap();
    this.mContext = paramMoPubInterstitial.getActivity();
    this.mTimeout = new Runnable()
    {
      public void run()
      {
        Log.d("MoPub", "Third-party network timed out.");
        CustomEventInterstitialAdapter.this.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        CustomEventInterstitialAdapter.this.invalidate();
      }
    };
    Log.d("MoPub", "Attempting to invoke custom event: " + paramString1);
    try
    {
      this.mCustomEventInterstitial = CustomEventInterstitialFactory.create(paramString1);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          this.mServerExtras = Json.jsonStringToMap(paramString2);
          this.mLocalExtras = paramMoPubInterstitial.getLocalExtras();
          if (paramMoPubInterstitial.getLocation() != null) {
            this.mLocalExtras.put("location", paramMoPubInterstitial.getLocation());
          }
          paramMoPubInterstitial = paramMoPubInterstitial.getMoPubInterstitialView().getAdViewController();
          if (paramMoPubInterstitial != null) {
            this.mLocalExtras.put("Ad-Configuration", paramMoPubInterstitial.getAdConfiguration());
          }
          return;
          localException = localException;
          Log.d("MoPub", "Couldn't locate or instantiate custom event: " + paramString1 + ".");
          if (this.mCustomEventInterstitialAdapterListener != null) {
            this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialFailed(MoPubErrorCode.ADAPTER_NOT_FOUND);
          }
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          Log.d("MoPub", "Failed to create Map from JSON: " + paramString2);
        }
      }
    }
  }
  
  private void cancelTimeout()
  {
    this.mHandler.removeCallbacks(this.mTimeout);
  }
  
  private int getTimeoutDelayMilliseconds()
  {
    if ((this.mMoPubInterstitial == null) || (this.mMoPubInterstitial.getAdTimeoutDelay() == null) || (this.mMoPubInterstitial.getAdTimeoutDelay().intValue() < 0)) {
      return 30000;
    }
    return this.mMoPubInterstitial.getAdTimeoutDelay().intValue() * 1000;
  }
  
  void invalidate()
  {
    if (this.mCustomEventInterstitial != null) {
      this.mCustomEventInterstitial.onInvalidate();
    }
    this.mCustomEventInterstitial = null;
    this.mContext = null;
    this.mServerExtras = null;
    this.mLocalExtras = null;
    this.mCustomEventInterstitialAdapterListener = null;
    this.mInvalidated = true;
  }
  
  boolean isInvalidated()
  {
    return this.mInvalidated;
  }
  
  void loadInterstitial()
  {
    if ((isInvalidated()) || (this.mCustomEventInterstitial == null)) {
      return;
    }
    if (getTimeoutDelayMilliseconds() > 0) {
      this.mHandler.postDelayed(this.mTimeout, getTimeoutDelayMilliseconds());
    }
    this.mCustomEventInterstitial.loadInterstitial(this.mContext, this, this.mLocalExtras, this.mServerExtras);
  }
  
  public void onInterstitialClicked()
  {
    if (isInvalidated()) {}
    while (this.mCustomEventInterstitialAdapterListener == null) {
      return;
    }
    this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialClicked();
  }
  
  public void onInterstitialDismissed()
  {
    if (isInvalidated()) {}
    while (this.mCustomEventInterstitialAdapterListener == null) {
      return;
    }
    this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialDismissed();
  }
  
  public void onInterstitialFailed(MoPubErrorCode paramMoPubErrorCode)
  {
    if (isInvalidated()) {}
    while (this.mCustomEventInterstitialAdapterListener == null) {
      return;
    }
    MoPubErrorCode localMoPubErrorCode = paramMoPubErrorCode;
    if (paramMoPubErrorCode == null) {
      localMoPubErrorCode = MoPubErrorCode.UNSPECIFIED;
    }
    cancelTimeout();
    this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialFailed(localMoPubErrorCode);
  }
  
  public void onInterstitialLoaded()
  {
    if (isInvalidated()) {}
    do
    {
      return;
      cancelTimeout();
    } while (this.mCustomEventInterstitialAdapterListener == null);
    this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialLoaded();
  }
  
  public void onInterstitialShown()
  {
    if (isInvalidated()) {}
    while (this.mCustomEventInterstitialAdapterListener == null) {
      return;
    }
    this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialShown();
  }
  
  public void onLeaveApplication()
  {
    onInterstitialClicked();
  }
  
  void setAdapterListener(CustomEventInterstitialAdapterListener paramCustomEventInterstitialAdapterListener)
  {
    this.mCustomEventInterstitialAdapterListener = paramCustomEventInterstitialAdapterListener;
  }
  
  @Deprecated
  void setCustomEventInterstitial(CustomEventInterstitial paramCustomEventInterstitial)
  {
    this.mCustomEventInterstitial = paramCustomEventInterstitial;
  }
  
  void showInterstitial()
  {
    if ((isInvalidated()) || (this.mCustomEventInterstitial == null)) {
      return;
    }
    this.mCustomEventInterstitial.showInterstitial();
  }
  
  static abstract interface CustomEventInterstitialAdapterListener
  {
    public abstract void onCustomEventInterstitialClicked();
    
    public abstract void onCustomEventInterstitialDismissed();
    
    public abstract void onCustomEventInterstitialFailed(MoPubErrorCode paramMoPubErrorCode);
    
    public abstract void onCustomEventInterstitialLoaded();
    
    public abstract void onCustomEventInterstitialShown();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/CustomEventInterstitialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */