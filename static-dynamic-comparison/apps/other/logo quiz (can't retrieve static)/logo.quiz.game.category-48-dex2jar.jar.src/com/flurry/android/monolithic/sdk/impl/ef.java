package com.flurry.android.monolithic.sdk.impl;

import com.mobclix.android.sdk.MobclixFullScreenAdView;
import com.mobclix.android.sdk.MobclixFullScreenAdViewListener;
import java.util.Collections;

class ef
  implements MobclixFullScreenAdViewListener
{
  ef(ee paramee) {}
  
  public String keywords()
  {
    ja.a(3, ee.f(), "Mobclix keyword callback.");
    return null;
  }
  
  public void onDismissAd(MobclixFullScreenAdView paramMobclixFullScreenAdView)
  {
    this.a.c(Collections.emptyMap());
    ja.a(3, ee.f(), "Mobclix Interstitial ad dismissed.");
  }
  
  public void onFailedLoad(MobclixFullScreenAdView paramMobclixFullScreenAdView, int paramInt)
  {
    this.a.d(Collections.emptyMap());
    ja.a(3, ee.f(), "Mobclix Interstitial ad failed to load.");
  }
  
  public void onFinishLoad(MobclixFullScreenAdView paramMobclixFullScreenAdView)
  {
    ja.a(3, ee.f(), "Mobclix Interstitial ad successfully loaded.");
  }
  
  public void onPresentAd(MobclixFullScreenAdView paramMobclixFullScreenAdView)
  {
    this.a.a(Collections.emptyMap());
    ja.a(3, ee.f(), "Mobclix Interstitial ad successfully shown.");
  }
  
  public String query()
  {
    ja.a(3, ee.f(), "Mobclix query callback.");
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */