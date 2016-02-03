package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdInterstitialListener;
import com.inmobi.androidsdk.IMAdRequest;
import java.lang.reflect.Method;

public class dp
  extends cr
{
  private static final String b = dp.class.getSimpleName();
  private final String c;
  private final boolean d;
  private final Method e;
  
  public dp(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
    this.c = paramBundle.getString("com.flurry.inmobi.MY_APP_ID");
    this.d = paramBundle.getBoolean("com.flurry.inmobi.test");
    this.e = g();
  }
  
  private void a(IMAdInterstitial paramIMAdInterstitial, IMAdInterstitialListener paramIMAdInterstitialListener)
  {
    if ((this.e == null) || (paramIMAdInterstitial == null)) {
      return;
    }
    try
    {
      this.e.invoke(paramIMAdInterstitial, new Object[] { paramIMAdInterstitialListener });
      return;
    }
    catch (Exception paramIMAdInterstitial) {}
  }
  
  private static Method g()
  {
    Method[] arrayOfMethod = IMAdInterstitial.class.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      String str = localMethod.getName();
      if ((str.equals("setIMAdInterstitialListener")) || (str.equals("setImAdInterstitialListener"))) {
        return localMethod;
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    IMAdInterstitial localIMAdInterstitial = new IMAdInterstitial((Activity)b(), this.c);
    a(localIMAdInterstitial, new dq(this));
    IMAdRequest localIMAdRequest = new IMAdRequest();
    if (this.d)
    {
      ja.a(3, b, "InMobi Interstitial set to Test Mode.");
      localIMAdRequest.setTestMode(true);
    }
    localIMAdInterstitial.loadNewAd(localIMAdRequest);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */