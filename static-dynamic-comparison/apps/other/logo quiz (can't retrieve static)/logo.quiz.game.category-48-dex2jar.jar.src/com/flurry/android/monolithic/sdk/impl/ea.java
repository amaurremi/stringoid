package com.flurry.android.monolithic.sdk.impl;

import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.RequestListener;
import java.util.Collections;

class ea
  implements RequestListener
{
  ea(dz paramdz) {}
  
  public void MMAdOverlayLaunched(MMAd paramMMAd)
  {
    this.a.a(Collections.emptyMap());
    this.a.c(Collections.emptyMap());
    ja.a(3, dz.f(), "Millennial MMAdView Interstitial overlay launched." + System.currentTimeMillis());
  }
  
  public void MMAdRequestIsCaching(MMAd paramMMAd)
  {
    ja.a(3, dz.f(), "Millennial MMAdView Interstitial request is caching.");
  }
  
  public void requestCompleted(MMAd paramMMAd)
  {
    ja.a(3, dz.f(), "Millennial MMAdView returned interstitial ad: " + System.currentTimeMillis());
    if (!dz.a(this.a)) {
      this.a.b.display();
    }
  }
  
  public void requestFailed(MMAd paramMMAd, MMException paramMMException)
  {
    this.a.d(Collections.emptyMap());
    ja.a(3, dz.f(), "Millennial MMAdView Interstitial failed to load ad.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */