package com.flurry.android;

import android.util.Log;
import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdInterstitial.State;
import com.inmobi.androidsdk.IMAdInterstitialListener;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import java.util.Collections;

final class ca
  implements IMAdInterstitialListener
{
  ca(u paramu) {}
  
  public final void onAdRequestFailed(IMAdInterstitial paramIMAdInterstitial, IMAdRequest.ErrorCode paramErrorCode)
  {
    this.en.onRenderFailed(Collections.emptyMap());
    Log.d(u.d(), "InMobi imAdView ad request failed.");
  }
  
  public final void onAdRequestLoaded(IMAdInterstitial paramIMAdInterstitial)
  {
    this.en.onAdFilled(Collections.emptyMap());
    Log.d(u.d(), "InMobi Interstitial ad request completed.");
    if (IMAdInterstitial.State.READY.equals(paramIMAdInterstitial.getState()))
    {
      this.en.onAdShown(Collections.emptyMap());
      paramIMAdInterstitial.show();
    }
  }
  
  public final void onDismissAdScreen(IMAdInterstitial paramIMAdInterstitial)
  {
    this.en.onAdClosed(Collections.emptyMap());
    Log.d(u.d(), "InMobi Interstitial ad dismissed.");
  }
  
  public final void onLeaveApplication(IMAdInterstitial paramIMAdInterstitial)
  {
    Log.d(u.d(), "InMobi onLeaveApplication");
  }
  
  public final void onShowAdScreen(IMAdInterstitial paramIMAdInterstitial)
  {
    Log.d(u.d(), "InMobi Interstitial ad shown.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */