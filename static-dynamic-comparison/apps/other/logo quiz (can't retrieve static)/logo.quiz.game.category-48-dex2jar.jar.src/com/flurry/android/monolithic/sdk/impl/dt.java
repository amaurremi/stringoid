package com.flurry.android.monolithic.sdk.impl;

import com.jumptap.adtag.JtAdView;
import com.jumptap.adtag.JtAdViewListener;
import java.util.Collections;

class dt
  implements JtAdViewListener
{
  dt(ds paramds) {}
  
  public void onAdError(JtAdView paramJtAdView, int paramInt1, int paramInt2)
  {
    ja.a(3, ds.a(), "Jumptap AdView error.");
    this.a.onRenderFailed(Collections.emptyMap());
  }
  
  public void onFocusChange(JtAdView paramJtAdView, int paramInt, boolean paramBoolean)
  {
    ja.a(3, ds.a(), "Jumptap AdView focus changed.");
  }
  
  public void onInterstitialDismissed(JtAdView paramJtAdView, int paramInt)
  {
    this.a.onAdClosed(Collections.emptyMap());
    ja.a(3, ds.a(), "Jumptap AdView dismissed.");
  }
  
  public void onNewAd(JtAdView paramJtAdView, int paramInt, String paramString)
  {
    this.a.onAdShown(Collections.emptyMap());
    ja.a(3, ds.a(), "Jumptap AdView new ad.");
  }
  
  public void onNoAdFound(JtAdView paramJtAdView, int paramInt)
  {
    this.a.onRenderFailed(Collections.emptyMap());
    ja.a(3, ds.a(), "Jumptap AdView no ad found.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */