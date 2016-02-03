package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import com.greystripe.sdk.GSAd;
import com.greystripe.sdk.GSAdErrorCode;
import com.greystripe.sdk.GSAdListener;
import com.greystripe.sdk.GSMobileBannerAdView;
import java.util.Map;

class GreystripeBanner
  extends CustomEventBanner
  implements GSAdListener
{
  public static final String DEFAULT_GREYSTRIPE_APP_ID = "YOUR_GREYSTRIPE_APP_ID";
  private CustomEventBanner.CustomEventBannerListener mBannerListener;
  private GSMobileBannerAdView mGreystripeAd;
  
  protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    this.mBannerListener = paramCustomEventBannerListener;
    this.mGreystripeAd = new GSMobileBannerAdView(paramContext, "YOUR_GREYSTRIPE_APP_ID");
    this.mGreystripeAd.addListener(this);
    this.mGreystripeAd.refresh();
  }
  
  public void onAdClickthrough(GSAd paramGSAd)
  {
    Log.d("MoPub", "Greystripe banner ad clicked.");
    this.mBannerListener.onBannerClicked();
  }
  
  public void onAdCollapse(GSAd paramGSAd) {}
  
  public void onAdDismissal(GSAd paramGSAd)
  {
    Log.d("MoPub", "Greystripe banner ad modal dismissed.");
  }
  
  public void onAdExpansion(GSAd paramGSAd) {}
  
  public void onFailedToFetchAd(GSAd paramGSAd, GSAdErrorCode paramGSAdErrorCode)
  {
    Log.d("MoPub", "Greystripe banner ad failed to load.");
    this.mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
  }
  
  public void onFetchedAd(GSAd paramGSAd)
  {
    if (this.mGreystripeAd != null) {}
    for (int i = 1; (i & this.mGreystripeAd.isAdReady()) != 0; i = 0)
    {
      Log.d("MoPub", "Greystripe banner ad loaded successfully. Showing ad...");
      this.mBannerListener.onBannerLoaded(this.mGreystripeAd);
      return;
    }
    this.mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
  }
  
  protected void onInvalidate()
  {
    this.mGreystripeAd.removeListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/GreystripeBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */