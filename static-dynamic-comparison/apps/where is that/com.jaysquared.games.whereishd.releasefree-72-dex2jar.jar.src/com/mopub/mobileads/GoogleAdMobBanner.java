package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.mopub.common.util.Views;
import java.util.Map;

class GoogleAdMobBanner
  extends CustomEventBanner
  implements AdListener
{
  public static final String AD_HEIGHT_KEY = "adHeight";
  public static final String AD_UNIT_ID_KEY = "adUnitID";
  public static final String AD_WIDTH_KEY = "adWidth";
  public static final String LOCATION_KEY = "location";
  private AdView mAdMobView;
  private CustomEventBanner.CustomEventBannerListener mBannerListener;
  
  private AdSize calculateAdSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= AdSize.BANNER.getWidth()) && (paramInt2 <= AdSize.BANNER.getHeight())) {
      return AdSize.BANNER;
    }
    if ((paramInt1 <= AdSize.IAB_MRECT.getWidth()) && (paramInt2 <= AdSize.IAB_MRECT.getHeight())) {
      return AdSize.IAB_MRECT;
    }
    if ((paramInt1 <= AdSize.IAB_BANNER.getWidth()) && (paramInt2 <= AdSize.IAB_BANNER.getHeight())) {
      return AdSize.IAB_BANNER;
    }
    if ((paramInt1 <= AdSize.IAB_LEADERBOARD.getWidth()) && (paramInt2 <= AdSize.IAB_LEADERBOARD.getHeight())) {
      return AdSize.IAB_LEADERBOARD;
    }
    return null;
  }
  
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
    try
    {
      Integer.parseInt((String)paramMap.get("adWidth"));
      Integer.parseInt((String)paramMap.get("adHeight"));
      return paramMap.containsKey("adUnitID");
    }
    catch (NumberFormatException paramMap) {}
    return false;
  }
  
  @Deprecated
  AdView getAdMobView()
  {
    return this.mAdMobView;
  }
  
  protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    this.mBannerListener = paramCustomEventBannerListener;
    if (!(paramContext instanceof Activity))
    {
      this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
      return;
    }
    if (extrasAreValid(paramMap1))
    {
      paramCustomEventBannerListener = (String)paramMap1.get("adUnitID");
      int i = Integer.parseInt((String)paramMap1.get("adWidth"));
      int j = Integer.parseInt((String)paramMap1.get("adHeight"));
      paramMap1 = calculateAdSize(i, j);
      if (paramMap1 == null)
      {
        Log.d("MoPub", "Unsupported AdMob ad size: " + i + "x" + j);
        this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
      }
    }
    else
    {
      this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
      return;
    }
    this.mAdMobView = new AdView((Activity)paramContext, paramMap1, paramCustomEventBannerListener);
    this.mAdMobView.setAdListener(this);
    paramContext = new AdRequest();
    paramCustomEventBannerListener = extractLocation(paramMap);
    if (paramCustomEventBannerListener != null) {
      paramContext.setLocation(paramCustomEventBannerListener);
    }
    this.mAdMobView.loadAd(paramContext);
  }
  
  public void onDismissScreen(Ad paramAd) {}
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    Log.d("MoPub", "Google AdMob banner ad failed to load.");
    this.mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
  }
  
  protected void onInvalidate()
  {
    this.mAdMobView.setAdListener(null);
    Views.removeFromParent(this.mAdMobView);
    this.mAdMobView.destroy();
  }
  
  public void onLeaveApplication(Ad paramAd) {}
  
  public void onPresentScreen(Ad paramAd)
  {
    Log.d("MoPub", "Google AdMob banner ad clicked.");
    this.mBannerListener.onBannerClicked();
  }
  
  public void onReceiveAd(Ad paramAd)
  {
    Log.d("MoPub", "Google AdMob banner ad loaded successfully. Showing ad...");
    this.mBannerListener.onBannerLoaded(this.mAdMobView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/GoogleAdMobBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */