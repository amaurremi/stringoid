package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import com.google.ads.AdRequest;
import com.google.ads.InterstitialAd;

public final class dj
  extends cr
{
  private static final String b = dj.class.getSimpleName();
  private final String c;
  private final String d;
  private final boolean e;
  private final InterstitialAd f;
  
  public dj(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
    this.c = paramBundle.getString("com.flurry.admob.MY_AD_UNIT_ID");
    this.d = paramBundle.getString("com.flurry.admob.MYTEST_AD_DEVICE_ID");
    this.e = paramBundle.getBoolean("com.flurry.admob.test");
    this.f = new InterstitialAd((Activity)b(), this.c);
    this.f.setAdListener(new dl(this, null));
  }
  
  public void a()
  {
    AdRequest localAdRequest = new AdRequest();
    if (this.e)
    {
      ja.a(3, b, "Admob AdView set to Test Mode.");
      localAdRequest.addTestDevice(AdRequest.TEST_EMULATOR);
      if (!TextUtils.isEmpty(this.d)) {
        localAdRequest.addTestDevice(this.d);
      }
    }
    this.f.loadAd(localAdRequest);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */