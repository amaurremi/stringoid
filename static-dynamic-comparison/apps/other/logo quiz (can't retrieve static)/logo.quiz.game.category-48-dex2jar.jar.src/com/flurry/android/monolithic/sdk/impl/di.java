package com.flurry.android.monolithic.sdk.impl;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest.ErrorCode;
import java.util.Collections;

final class di
  implements AdListener
{
  private di(dg paramdg) {}
  
  public void onDismissScreen(Ad paramAd)
  {
    this.a.onAdClosed(Collections.emptyMap());
    ja.a(4, dg.a(), "Admob AdView dismissed from screen.");
  }
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    this.a.onRenderFailed(Collections.emptyMap());
    ja.a(5, dg.a(), "Admob AdView failed to receive ad.");
  }
  
  public void onLeaveApplication(Ad paramAd)
  {
    this.a.onAdClicked(Collections.emptyMap());
    ja.a(4, dg.a(), "Admob AdView leave application.");
  }
  
  public void onPresentScreen(Ad paramAd)
  {
    ja.a(4, dg.a(), "Admob AdView present on screen.");
  }
  
  public void onReceiveAd(Ad paramAd)
  {
    this.a.onAdShown(Collections.emptyMap());
    ja.a(4, dg.a(), "Admob AdView received ad.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */