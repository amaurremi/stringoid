package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMInterstitial;
import com.inmobi.monetization.IMInterstitial.State;
import com.inmobi.monetization.IMInterstitialListener;
import java.util.HashMap;
import java.util.Map;

public class InMobiInterstitial
  extends CustomEventInterstitial
  implements IMInterstitialListener
{
  private static boolean isAppInitialized = false;
  private IMInterstitial iMInterstitial;
  private CustomEventInterstitial.CustomEventInterstitialListener mInterstitialListener;
  
  protected void loadInterstitial(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    this.mInterstitialListener = paramCustomEventInterstitialListener;
    paramCustomEventInterstitialListener = null;
    if ((paramContext instanceof Activity)) {
      paramCustomEventInterstitialListener = (Activity)paramContext;
    }
    if (paramCustomEventInterstitialListener == null)
    {
      this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.UNSPECIFIED);
      return;
    }
    if (!isAppInitialized)
    {
      InMobi.initialize(paramCustomEventInterstitialListener, "YOUR_INMOBI_APP_ID");
      isAppInitialized = true;
    }
    this.iMInterstitial = new IMInterstitial(paramCustomEventInterstitialListener, "YOUR_INMOBI_APP_ID");
    paramContext = new HashMap();
    paramContext.put("tp", "c_mopub");
    paramContext.put("tp-ver", "2.0");
    this.iMInterstitial.setRequestParams(paramContext);
    this.iMInterstitial.setIMInterstitialListener(this);
    this.iMInterstitial.loadInterstitial();
  }
  
  public void onDismissInterstitialScreen(IMInterstitial paramIMInterstitial)
  {
    this.mInterstitialListener.onInterstitialDismissed();
  }
  
  public void onInterstitialFailed(IMInterstitial paramIMInterstitial, IMErrorCode paramIMErrorCode)
  {
    if (paramIMErrorCode == IMErrorCode.INTERNAL_ERROR)
    {
      this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramIMErrorCode == IMErrorCode.INVALID_REQUEST)
    {
      this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
      return;
    }
    if (paramIMErrorCode == IMErrorCode.NETWORK_ERROR)
    {
      this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
      return;
    }
    if (paramIMErrorCode == IMErrorCode.NO_FILL)
    {
      this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NO_FILL);
      return;
    }
    this.mInterstitialListener.onInterstitialFailed(MoPubErrorCode.UNSPECIFIED);
  }
  
  public void onInterstitialInteraction(IMInterstitial paramIMInterstitial, Map<String, String> paramMap)
  {
    this.mInterstitialListener.onInterstitialClicked();
  }
  
  public void onInterstitialLoaded(IMInterstitial paramIMInterstitial)
  {
    this.mInterstitialListener.onInterstitialLoaded();
  }
  
  public void onInvalidate()
  {
    if (this.iMInterstitial != null)
    {
      this.iMInterstitial.setIMInterstitialListener(null);
      this.iMInterstitial.destroy();
    }
  }
  
  public void onLeaveApplication(IMInterstitial paramIMInterstitial) {}
  
  public void onShowInterstitialScreen(IMInterstitial paramIMInterstitial)
  {
    this.mInterstitialListener.onInterstitialShown();
  }
  
  public void showInterstitial()
  {
    if ((this.iMInterstitial != null) && (IMInterstitial.State.READY.equals(this.iMInterstitial.getState()))) {
      this.iMInterstitial.show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/InMobiInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */