package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import com.millennialmedia.android.MMInterstitial;

public final class dz
  extends cr
{
  private static final String c = dz.class.getSimpleName();
  MMInterstitial b;
  private boolean d;
  private final String e;
  
  public dz(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
    this.e = paramBundle.getString("com.flurry.millennial.MYAPIDINTERSTITIAL");
  }
  
  public void a()
  {
    this.b = new MMInterstitial((Activity)b());
    this.b.setApid(this.e);
    ea localea = new ea(this);
    this.b.setListener(localea);
    this.b.fetch();
    this.d = this.b.display();
    if (this.d)
    {
      ja.a(3, c, "Millennial MMAdView Interstitial ad displayed immediately:" + System.currentTimeMillis() + " " + this.d);
      return;
    }
    ja.a(3, c, "Millennial MMAdView Interstitial ad did not display immediately:" + System.currentTimeMillis() + " " + this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */