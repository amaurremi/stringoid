package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import com.greystripe.sdk.GSAd;
import com.greystripe.sdk.GSAdErrorCode;
import com.greystripe.sdk.GSAdListener;
import com.greystripe.sdk.GSFullscreenAd;
import java.util.Map;

class GreystripeInterstitial
  extends CustomEventInterstitial
  implements GSAdListener
{
  public static final String DEFAULT_GREYSTRIPE_APP_ID = "YOUR_GREYSTRIPE_APP_ID";
  private GSFullscreenAd mGreystripeAd;
  private CustomEventInterstitial.CustomEventInterstitialListener mInterstitialListener;
  
  protected void loadInterstitial(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    this.mInterstitialListener = paramCustomEventInterstitialListener;
    this.mGreystripeAd = new GSFullscreenAd(paramContext, "YOUR_GREYSTRIPE_APP_ID");
    this.mGreystripeAd.addListener(this);
    this.mGreystripeAd.fetch();
  }
  
  public void onAdClickthrough(GSAd paramGSAd)
  {
    Log.d("MoPub", "Greystripe interstitial ad clicked.");
    this.mInterstitialListener.onInterstitialClicked();
    this.mInterstitialListener.onInterstitialDismissed();
  }
  
  public void onAdCollapse(GSAd paramGSAd) {}
  
  public void onAdDismissal(GSAd paramGSAd)
  {
    Log.d("MoPub", "Greystripe interstitial ad dismissed.");
    this.mInterstitialListener.onInterstitialDismissed();
  }
  
  public void onAdExpansion(GSAd paramGSAd) {}
  
  public void onFailedToFetchAd(GSAd paramGSAd, GSAdErrorCode paramGSAdErrorCode)
  {
    Log.d("MoPub", "Greystripe interstitial ad failed to load.");
    this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
  }
  
  public void onFetchedAd(GSAd paramGSAd)
  {
    if ((this.mGreystripeAd != null) && (this.mGreystripeAd.isAdReady()))
    {
      Log.d("MoPub", "Greysripe interstitial ad loaded successfully.");
      this.mInterstitialListener.onInterstitialLoaded();
      return;
    }
    this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
  }
  
  protected void onInvalidate()
  {
    this.mGreystripeAd.removeListener(this);
  }
  
  protected void showInterstitial()
  {
    if (!this.mGreystripeAd.isAdReady())
    {
      this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
      return;
    }
    Log.d("MoPub", "Showing Greystripe interstitial ad.");
    this.mGreystripeAd.display();
    this.mInterstitialListener.onInterstitialShown();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/GreystripeInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */