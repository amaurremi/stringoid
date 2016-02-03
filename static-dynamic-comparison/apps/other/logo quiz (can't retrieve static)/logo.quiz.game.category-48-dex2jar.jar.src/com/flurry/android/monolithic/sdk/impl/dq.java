package com.flurry.android.monolithic.sdk.impl;

import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdInterstitial.State;
import com.inmobi.androidsdk.IMAdInterstitialListener;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import java.util.Collections;

class dq
  implements IMAdInterstitialListener
{
  dq(dp paramdp) {}
  
  public void onAdRequestFailed(IMAdInterstitial paramIMAdInterstitial, IMAdRequest.ErrorCode paramErrorCode)
  {
    this.a.d(Collections.emptyMap());
    ja.a(3, dp.f(), "InMobi imAdView ad request failed.");
  }
  
  public void onAdRequestLoaded(IMAdInterstitial paramIMAdInterstitial)
  {
    ja.a(3, dp.f(), "InMobi Interstitial ad request completed.");
    if (IMAdInterstitial.State.READY.equals(paramIMAdInterstitial.getState()))
    {
      this.a.a(Collections.emptyMap());
      paramIMAdInterstitial.show();
    }
  }
  
  public void onDismissAdScreen(IMAdInterstitial paramIMAdInterstitial)
  {
    this.a.c(Collections.emptyMap());
    ja.a(3, dp.f(), "InMobi Interstitial ad dismissed.");
  }
  
  public void onLeaveApplication(IMAdInterstitial paramIMAdInterstitial)
  {
    ja.a(3, dp.f(), "InMobi onLeaveApplication");
  }
  
  public void onShowAdScreen(IMAdInterstitial paramIMAdInterstitial)
  {
    ja.a(3, dp.f(), "InMobi Interstitial ad shown.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */