package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.vungle.sdk.VunglePub;
import com.vungle.sdk.VunglePub.EventListener;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class VungleInterstitial
  extends CustomEventInterstitial
  implements VunglePub.EventListener
{
  private static final String APP_ID_KEY = "appId";
  public static final String DEFAULT_VUNGLE_APP_ID = "YOUR_DEFAULT_VUNGLE_APP_ID";
  private CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;
  private final Handler mHandler = new Handler();
  private boolean mIsLoading;
  private final ScheduledThreadPoolExecutor mScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
  
  private boolean extrasAreValid(Map<String, String> paramMap)
  {
    return paramMap.containsKey("appId");
  }
  
  private void scheduleOnInterstitialLoaded()
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if (VunglePub.isVideoAvailable())
        {
          Log.d("MoPub", "Vungle interstitial ad successfully loaded.");
          VungleInterstitial.this.mScheduledThreadPoolExecutor.shutdownNow();
          VungleInterstitial.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              VungleInterstitial.this.mCustomEventInterstitialListener.onInterstitialLoaded();
            }
          });
          VungleInterstitial.access$302(VungleInterstitial.this, false);
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
    this.mCustomEventInterstitialListener = paramCustomEventInterstitialListener;
    if (paramContext == null)
    {
      this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
      return;
    }
    if (extrasAreValid(paramMap1)) {}
    for (paramCustomEventInterstitialListener = (String)paramMap1.get("appId");; paramCustomEventInterstitialListener = "YOUR_DEFAULT_VUNGLE_APP_ID")
    {
      VunglePub.setEventListener(this);
      VunglePub.init(paramContext, paramCustomEventInterstitialListener);
      scheduleOnInterstitialLoaded();
      return;
    }
  }
  
  protected void onInvalidate()
  {
    VunglePub.setEventListener(null);
    this.mScheduledThreadPoolExecutor.shutdownNow();
    this.mIsLoading = false;
  }
  
  public void onVungleAdEnd()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        Log.d("MoPub", "Vungle interstitial ad dismissed.");
        VungleInterstitial.this.mCustomEventInterstitialListener.onInterstitialDismissed();
      }
    });
  }
  
  public void onVungleAdStart()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        Log.d("MoPub", "Showing Vungle interstitial ad.");
        VungleInterstitial.this.mCustomEventInterstitialListener.onInterstitialShown();
      }
    });
  }
  
  public void onVungleView(double paramDouble1, double paramDouble2)
  {
    Log.d("MoPub", String.format("%.1f%% of Vungle video watched.", new Object[] { Double.valueOf(paramDouble1 / paramDouble2 * 100.0D) }));
  }
  
  protected void showInterstitial()
  {
    if (VunglePub.isVideoAvailable(true))
    {
      VunglePub.displayAdvert();
      return;
    }
    Log.d("MoPub", "Tried to show a Vungle interstitial ad before it finished loading. Please try again.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/VungleInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */