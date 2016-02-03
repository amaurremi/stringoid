package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;
import java.util.Map;

class GoogleAdMobInterstitial
  extends CustomEventInterstitial
  implements AdListener
{
  public static final String AD_UNIT_ID_KEY = "adUnitID";
  public static final String LOCATION_KEY = "location";
  private boolean mHasAlreadyRegisteredClick;
  private InterstitialAd mInterstitialAd;
  private CustomEventInterstitial.CustomEventInterstitialListener mInterstitialListener;
  
  private Location extractLocation(Map<String, Object> paramMap)
  {
    paramMap = paramMap.get("location");
    if ((paramMap instanceof Location)) {
      return (Location)paramMap;
    }
    return null;
  }
  
  private boolean extrasAreValid(Map<String, String> paramMap)
  {
    return paramMap.containsKey("adUnitID");
  }
  
  @Deprecated
  InterstitialAd getAdMobInterstitial()
  {
    return this.mInterstitialAd;
  }
  
  protected void loadInterstitial(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    this.mInterstitialListener = paramCustomEventInterstitialListener;
    if (!(paramContext instanceof Activity))
    {
      this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
      return;
    }
    if (extrasAreValid(paramMap1))
    {
      paramCustomEventInterstitialListener = (String)paramMap1.get("adUnitID");
      this.mInterstitialAd = new InterstitialAd((Activity)paramContext, paramCustomEventInterstitialListener);
      this.mInterstitialAd.setAdListener(this);
      paramContext = new AdRequest();
      paramCustomEventInterstitialListener = extractLocation(paramMap);
      if (paramCustomEventInterstitialListener != null) {
        paramContext.setLocation(paramCustomEventInterstitialListener);
      }
      this.mInterstitialAd.loadAd(paramContext);
      return;
    }
    this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
  }
  
  public void onDismissScreen(Ad paramAd)
  {
    Log.d("MoPub", "Google AdMob interstitial ad dismissed.");
    this.mInterstitialListener.onInterstitialDismissed();
  }
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    Log.d("MoPub", "Google AdMob interstitial ad failed to load.");
    this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
  }
  
  protected void onInvalidate()
  {
    if (this.mInterstitialAd != null) {
      this.mInterstitialAd.setAdListener(null);
    }
  }
  
  public void onLeaveApplication(Ad paramAd)
  {
    if (!this.mHasAlreadyRegisteredClick)
    {
      Log.d("MoPub", "Google AdMob interstitial ad clicked.");
      this.mHasAlreadyRegisteredClick = true;
      this.mInterstitialListener.onInterstitialClicked();
    }
  }
  
  public void onPresentScreen(Ad paramAd)
  {
    Log.d("MoPub", "Showing Google AdMob interstitial ad.");
    this.mInterstitialListener.onInterstitialShown();
  }
  
  public void onReceiveAd(Ad paramAd)
  {
    Log.d("MoPub", "Google AdMob interstitial ad loaded successfully.");
    this.mInterstitialListener.onInterstitialLoaded();
  }
  
  protected void showInterstitial()
  {
    if (this.mInterstitialAd.isReady())
    {
      this.mInterstitialAd.show();
      return;
    }
    Log.d("MoPub", "Tried to show a Google AdMob interstitial ad before it finished loading. Please try again.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/GoogleAdMobInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */