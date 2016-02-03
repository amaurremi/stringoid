package com.flurry.android.monolithic.sdk.impl;

import com.jumptap.adtag.JtAdView;
import com.jumptap.adtag.JtAdViewListener;
import java.util.Collections;

class dv
  implements JtAdViewListener
{
  dv(du paramdu) {}
  
  public void onAdError(JtAdView paramJtAdView, int paramInt1, int paramInt2)
  {
    ja.a(3, du.f(), "Jumptap Interstitial error.");
    this.a.d(Collections.emptyMap());
  }
  
  public void onFocusChange(JtAdView paramJtAdView, int paramInt, boolean paramBoolean)
  {
    ja.a(3, du.f(), "Jumptap Interstitial focus changed.");
  }
  
  public void onInterstitialDismissed(JtAdView paramJtAdView, int paramInt)
  {
    this.a.c(Collections.emptyMap());
    ja.a(3, du.f(), "Jumptap Interstitial dismissed.");
  }
  
  public void onNewAd(JtAdView paramJtAdView, int paramInt, String paramString)
  {
    this.a.a(Collections.emptyMap());
    ja.a(3, du.f(), "Jumptap Interstitial new ad.");
  }
  
  public void onNoAdFound(JtAdView paramJtAdView, int paramInt)
  {
    this.a.d(Collections.emptyMap());
    ja.a(3, du.f(), "Jumptap Interstitial no ad found.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */