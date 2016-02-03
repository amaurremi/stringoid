package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import com.mobclix.android.sdk.MobclixFullScreenAdView;

public final class ee
  extends cr
{
  private static final String b = ee.class.getSimpleName();
  
  public ee(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
  }
  
  public void a()
  {
    MobclixFullScreenAdView localMobclixFullScreenAdView = new MobclixFullScreenAdView((Activity)b());
    localMobclixFullScreenAdView.addMobclixAdViewListener(new ef(this));
    localMobclixFullScreenAdView.requestAndDisplayAd();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */