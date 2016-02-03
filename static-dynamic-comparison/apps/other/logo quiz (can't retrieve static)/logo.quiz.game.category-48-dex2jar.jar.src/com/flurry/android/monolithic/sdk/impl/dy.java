package com.flurry.android.monolithic.sdk.impl;

import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.RequestListener;
import java.util.Collections;

class dy
  implements RequestListener
{
  dy(dx paramdx) {}
  
  public void MMAdOverlayLaunched(MMAd paramMMAd)
  {
    this.a.onAdClicked(Collections.emptyMap());
    ja.a(3, dx.a(), "Millennial MMAdView banner overlay launched.");
  }
  
  public void MMAdRequestIsCaching(MMAd paramMMAd)
  {
    ja.a(3, dx.a(), "Millennial MMAdView banner request is caching.");
  }
  
  public void requestCompleted(MMAd paramMMAd)
  {
    this.a.onAdShown(Collections.emptyMap());
    ja.a(3, dx.a(), "Millennial MMAdView returned ad." + System.currentTimeMillis());
  }
  
  public void requestFailed(MMAd paramMMAd, MMException paramMMException)
  {
    this.a.onRenderFailed(Collections.emptyMap());
    ja.a(3, dx.a(), String.format("Millennial MMAdView failed to load ad with error: %d %s.", new Object[] { Integer.valueOf(paramMMException.getCode()), paramMMException.getMessage() }));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */