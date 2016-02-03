package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMBroadcastReceiver;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import java.util.Map;

class MillennialInterstitial
  extends CustomEventInterstitial
{
  public static final String APID_KEY = "adUnitID";
  private MillennialBroadcastReceiver mBroadcastReceiver;
  private CustomEventInterstitial.CustomEventInterstitialListener mInterstitialListener;
  private MMInterstitial mMillennialInterstitial;
  
  private boolean extrasAreValid(Map<String, String> paramMap)
  {
    return paramMap.containsKey("adUnitID");
  }
  
  protected void loadInterstitial(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    this.mInterstitialListener = paramCustomEventInterstitialListener;
    if (extrasAreValid(paramMap1))
    {
      paramCustomEventInterstitialListener = (String)paramMap1.get("adUnitID");
      MMSDK.initialize(paramContext);
      MMSDK.setBroadcastEvents(true);
      this.mBroadcastReceiver = new MillennialBroadcastReceiver();
      this.mBroadcastReceiver.register(paramContext);
      paramMap = (Location)paramMap.get("location");
      if (paramMap != null) {
        MMRequest.setUserLocation(paramMap);
      }
      this.mMillennialInterstitial = new MMInterstitial(paramContext);
      if (this.mMillennialInterstitial.isAdAvailable())
      {
        Log.d("MoPub", "Millennial interstitial ad already loaded.");
        this.mInterstitialListener.onInterstitialLoaded();
      }
    }
    else
    {
      this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
      return;
    }
    this.mMillennialInterstitial.setMMRequest(new MMRequest());
    this.mMillennialInterstitial.setApid(paramCustomEventInterstitialListener);
    this.mMillennialInterstitial.fetch();
  }
  
  protected void onInvalidate()
  {
    this.mMillennialInterstitial.setListener(null);
    this.mBroadcastReceiver.unregister();
  }
  
  protected void showInterstitial()
  {
    if (this.mMillennialInterstitial.isAdAvailable())
    {
      this.mMillennialInterstitial.display();
      return;
    }
    Log.d("MoPub", "Tried to show a Millennial interstitial ad before it finished loading. Please try again.");
  }
  
  class MillennialBroadcastReceiver
    extends MMBroadcastReceiver
  {
    private Context mContext;
    
    MillennialBroadcastReceiver() {}
    
    private void fetchFinished(MoPubErrorCode paramMoPubErrorCode)
    {
      if (MillennialInterstitial.this.mMillennialInterstitial.isAdAvailable())
      {
        Log.d("MoPub", "Millennial interstitial ad loaded successfully.");
        MillennialInterstitial.this.mInterstitialListener.onInterstitialLoaded();
        return;
      }
      Log.d("MoPub", "Millennial interstitial ad failed to load.");
      MillennialInterstitial.this.mInterstitialListener.onInterstitialFailed(paramMoPubErrorCode);
    }
    
    public void displayStarted(MMAd paramMMAd)
    {
      super.displayStarted(paramMMAd);
      Log.d("MoPub", "Showing Millennial interstitial ad.");
      MillennialInterstitial.this.mInterstitialListener.onInterstitialShown();
    }
    
    public void fetchFailure(MMAd paramMMAd)
    {
      super.fetchFailure(paramMMAd);
      fetchFinished(MoPubErrorCode.NETWORK_NO_FILL);
    }
    
    public void fetchFinishedCaching(MMAd paramMMAd)
    {
      super.fetchFinishedCaching(paramMMAd);
      fetchFinished(MoPubErrorCode.NETWORK_INVALID_STATE);
    }
    
    public void getAdFailure(MMAd paramMMAd)
    {
      super.getAdFailure(paramMMAd);
      Log.d("MoPub", "Millennial interstitial ad failed to load.");
      MillennialInterstitial.this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
    }
    
    public void intentStarted(MMAd paramMMAd, String paramString)
    {
      super.intentStarted(paramMMAd, paramString);
      Log.d("MoPub", "Millennial interstitial ad clicked.");
      MillennialInterstitial.this.mInterstitialListener.onInterstitialClicked();
    }
    
    public void overlayClosed(MMAd paramMMAd)
    {
      super.overlayClosed(paramMMAd);
      Log.d("MoPub", "Millennial interstitial ad dismissed.");
      MillennialInterstitial.this.mInterstitialListener.onInterstitialDismissed();
    }
    
    void register(Context paramContext)
    {
      this.mContext = paramContext;
      paramContext.registerReceiver(this, MMBroadcastReceiver.createIntentFilter());
    }
    
    void unregister()
    {
      try
      {
        this.mContext.unregisterReceiver(this);
        return;
      }
      catch (Exception localException)
      {
        Log.d("MoPub", "Unable to unregister MMBroadcastReceiver", localException);
        return;
      }
      finally
      {
        this.mContext = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MillennialInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */