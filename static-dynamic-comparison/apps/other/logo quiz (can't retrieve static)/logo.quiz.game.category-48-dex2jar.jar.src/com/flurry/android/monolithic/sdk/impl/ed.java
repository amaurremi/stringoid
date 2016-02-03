package com.flurry.android.monolithic.sdk.impl;

import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixAdViewListener;
import java.util.Collections;

class ed
  implements MobclixAdViewListener
{
  ed(ec paramec) {}
  
  public String keywords()
  {
    ja.a(3, ec.a(), "Mobclix keyword callback.");
    return null;
  }
  
  public void onAdClick(MobclixAdView paramMobclixAdView)
  {
    this.a.onAdClicked(Collections.emptyMap());
    ja.a(3, ec.a(), "Mobclix AdView ad clicked.");
  }
  
  public void onCustomAdTouchThrough(MobclixAdView paramMobclixAdView, String paramString)
  {
    this.a.onAdClicked(Collections.emptyMap());
    ja.a(3, ec.a(), "Mobclix AdView custom ad clicked.");
  }
  
  public void onFailedLoad(MobclixAdView paramMobclixAdView, int paramInt)
  {
    this.a.onRenderFailed(Collections.emptyMap());
    ja.a(3, ec.a(), "Mobclix AdView ad failed to load.");
  }
  
  public boolean onOpenAllocationLoad(MobclixAdView paramMobclixAdView, int paramInt)
  {
    ja.a(3, ec.a(), "Mobclix AdView loaded an open allocation ad.");
    return true;
  }
  
  public void onSuccessfulLoad(MobclixAdView paramMobclixAdView)
  {
    this.a.onAdShown(Collections.emptyMap());
    ja.a(3, ec.a(), "Mobclix AdView ad successfully loaded.");
  }
  
  public String query()
  {
    ja.a(3, ec.a(), "Mobclix query callback.");
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */