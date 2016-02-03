package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.ads.FlurryAdModule;
import java.util.List;

class bs
  extends jf
{
  bs(br parambr) {}
  
  public void a()
  {
    FlurryAdModule.a(this.a.a, "AdsThreadQueue Single Executor");
    List localList = this.a.a.a(br.a(this.a), br.b(this.a), br.c(this.a), br.d(this.a));
    FlurryAdModule.a(this.a.a).a(localList);
    FlurryAdModule.a(this.a.a).h(br.a(this.a));
    ja.a(3, FlurryAdModule.L(), "fetchAdTaskExecute :setting cache request limit count");
    if (br.e(this.a) != null) {
      ia.a().a(br.e(this.a));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */