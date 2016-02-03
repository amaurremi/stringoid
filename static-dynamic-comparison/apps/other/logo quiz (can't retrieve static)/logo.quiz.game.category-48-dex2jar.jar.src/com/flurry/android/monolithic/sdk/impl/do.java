package com.flurry.android.monolithic.sdk.impl;

import com.inmobi.androidsdk.IMAdListener;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import com.inmobi.androidsdk.IMAdView;
import java.util.Collections;

class do
  implements IMAdListener
{
  do(dn paramdn) {}
  
  public void onAdRequestCompleted(IMAdView paramIMAdView)
  {
    this.a.onAdShown(Collections.emptyMap());
    ja.a(3, dn.a(), "InMobi imAdView ad request completed.");
  }
  
  public void onAdRequestFailed(IMAdView paramIMAdView, IMAdRequest.ErrorCode paramErrorCode)
  {
    this.a.onRenderFailed(Collections.emptyMap());
    ja.a(3, dn.a(), "InMobi imAdView ad request failed. " + paramErrorCode.toString());
  }
  
  public void onDismissAdScreen(IMAdView paramIMAdView)
  {
    this.a.onAdClosed(Collections.emptyMap());
    ja.a(3, dn.a(), "InMobi imAdView dismiss ad.");
  }
  
  public void onLeaveApplication(IMAdView paramIMAdView)
  {
    ja.a(3, dn.a(), "InMobi onLeaveApplication");
  }
  
  public void onShowAdScreen(IMAdView paramIMAdView)
  {
    this.a.onAdClicked(Collections.emptyMap());
    ja.a(3, dn.a(), "InMobi imAdView ad shown.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */