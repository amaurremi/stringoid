package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyAd;
import com.jirbo.adcolony.AdColonyAdListener;
import com.jirbo.adcolony.AdColonyVideoAd;
import com.mopub.mobileads.util.Json;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AdColonyInterstitial
  extends CustomEventInterstitial
  implements AdColonyAdListener
{
  private static final String ALL_ZONE_IDS_KEY = "allZoneIds";
  private static final String APP_ID_KEY = "appId";
  private static final String CLIENT_OPTIONS_KEY = "clientOptions";
  private static final String[] DEFAULT_ALL_ZONE_IDS = { "ZONE_ID_1", "ZONE_ID_2", "..." };
  private static final String DEFAULT_APP_ID = "YOUR_AD_COLONY_APP_ID_HERE";
  private static final String DEFAULT_CLIENT_OPTIONS = "version=YOUR_APP_VERSION_HERE,store:google";
  private static final String DEFAULT_ZONE_ID = "YOUR_CURRENT_ZONE_ID";
  private static final String ZONE_ID_KEY = "zoneId";
  private static boolean isAdColonyConfigured = false;
  private AdColonyVideoAd mAdColonyVideoAd;
  private CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;
  private final Handler mHandler = new Handler();
  private boolean mIsLoading;
  private final ScheduledThreadPoolExecutor mScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
  
  private String[] extractAllZoneIds(Map<String, String> paramMap)
  {
    String[] arrayOfString = Json.jsonArrayToStringArray((String)paramMap.get("allZoneIds"));
    paramMap = arrayOfString;
    if (arrayOfString.length == 0)
    {
      paramMap = new String[1];
      paramMap[0] = "";
    }
    return paramMap;
  }
  
  private boolean extrasAreValid(Map<String, String> paramMap)
  {
    return (paramMap.containsKey("clientOptions")) && (paramMap.containsKey("appId")) && (paramMap.containsKey("allZoneIds")) && (paramMap.containsKey("zoneId"));
  }
  
  private void scheduleOnInterstitialLoaded()
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if (AdColonyInterstitial.this.mAdColonyVideoAd.isReady())
        {
          Log.d("MoPub", "AdColony interstitial ad successfully loaded.");
          AdColonyInterstitial.access$102(AdColonyInterstitial.this, false);
          AdColonyInterstitial.this.mScheduledThreadPoolExecutor.shutdownNow();
          AdColonyInterstitial.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              AdColonyInterstitial.this.mCustomEventInterstitialListener.onInterstitialLoaded();
            }
          });
        }
      }
    };
    if (!this.mIsLoading)
    {
      this.mScheduledThreadPoolExecutor.scheduleAtFixedRate(local1, 1L, 1L, TimeUnit.SECONDS);
      this.mIsLoading = true;
    }
  }
  
  @Deprecated
  ScheduledThreadPoolExecutor getScheduledThreadPoolExecutor()
  {
    return this.mScheduledThreadPoolExecutor;
  }
  
  protected void loadInterstitial(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    if (!(paramContext instanceof Activity))
    {
      paramCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
      return;
    }
    String str1 = "version=YOUR_APP_VERSION_HERE,store:google";
    paramMap = "YOUR_AD_COLONY_APP_ID_HERE";
    String[] arrayOfString = DEFAULT_ALL_ZONE_IDS;
    String str2 = "YOUR_CURRENT_ZONE_ID";
    this.mCustomEventInterstitialListener = paramCustomEventInterstitialListener;
    paramCustomEventInterstitialListener = arrayOfString;
    if (extrasAreValid(paramMap1))
    {
      str1 = (String)paramMap1.get("clientOptions");
      paramMap = (String)paramMap1.get("appId");
      paramCustomEventInterstitialListener = extractAllZoneIds(paramMap1);
      str2 = (String)paramMap1.get("zoneId");
    }
    if (!isAdColonyConfigured)
    {
      AdColony.configure((Activity)paramContext, str1, paramMap, paramCustomEventInterstitialListener);
      isAdColonyConfigured = true;
    }
    this.mAdColonyVideoAd = new AdColonyVideoAd(str2);
    this.mAdColonyVideoAd.withListener(this);
    scheduleOnInterstitialLoaded();
  }
  
  public void onAdColonyAdAttemptFinished(AdColonyAd paramAdColonyAd)
  {
    Log.d("MoPub", "AdColony interstitial ad dismissed.");
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        AdColonyInterstitial.this.mCustomEventInterstitialListener.onInterstitialDismissed();
      }
    });
  }
  
  public void onAdColonyAdStarted(AdColonyAd paramAdColonyAd)
  {
    Log.d("MoPub", "AdColony interstitial ad shown.");
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        AdColonyInterstitial.this.mCustomEventInterstitialListener.onInterstitialShown();
      }
    });
  }
  
  protected void onInvalidate()
  {
    if (this.mAdColonyVideoAd != null) {
      this.mAdColonyVideoAd.withListener(null);
    }
    this.mScheduledThreadPoolExecutor.shutdownNow();
    this.mIsLoading = false;
  }
  
  @Deprecated
  void resetAdColonyConfigured()
  {
    isAdColonyConfigured = false;
  }
  
  protected void showInterstitial()
  {
    if (this.mAdColonyVideoAd.isReady())
    {
      this.mAdColonyVideoAd.show();
      return;
    }
    Log.d("MoPub", "Tried to show a AdColony interstitial ad before it finished loading. Please try again.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/AdColonyInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */