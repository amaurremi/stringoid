package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.ads.FlurryAdModule;

public class bp
  extends jf
{
  public bp(FlurryAdModule paramFlurryAdModule) {}
  
  public void a()
  {
    FlurryAdModule.a(this.a, "AdsThreadQueue Single Executor");
    bq localbq = new bq(this);
    this.a.a(localbq);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */