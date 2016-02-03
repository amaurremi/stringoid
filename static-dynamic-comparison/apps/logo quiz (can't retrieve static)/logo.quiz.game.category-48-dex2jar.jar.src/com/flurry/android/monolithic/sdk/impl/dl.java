package com.flurry.android.monolithic.sdk.impl;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;
import java.util.Collections;

final class dl
  implements AdListener
{
  private dl(dj paramdj) {}
  
  public void onDismissScreen(Ad paramAd)
  {
    this.a.c(Collections.emptyMap());
    ja.a(3, dj.f(), "Admob Interstitial dismissed from screen.");
  }
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    this.a.d(Collections.emptyMap());
    ja.a(3, dj.f(), "Admob Interstitial failed to receive takeover.");
  }
  
  public void onLeaveApplication(Ad paramAd)
  {
    this.a.b(Collections.emptyMap());
    ja.a(4, dj.f(), "Admob Interstitial leave application.");
  }
  
  public void onPresentScreen(Ad paramAd)
  {
    ja.a(3, dj.f(), "Admob Interstitial present on screen.");
  }
  
  public void onReceiveAd(Ad paramAd)
  {
    if (paramAd == dj.a(this.a))
    {
      ja.a(3, dj.f(), "Admob Interstitial received takeover.");
      this.a.a(Collections.emptyMap());
      dj.a(this.a).show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */