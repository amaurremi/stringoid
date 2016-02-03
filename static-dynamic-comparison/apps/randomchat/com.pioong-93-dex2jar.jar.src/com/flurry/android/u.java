package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdRequest;

class u
  extends m
{
  private static final String d = u.class.getSimpleName();
  private final boolean P;
  private final String g;
  
  public u(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdUnit);
    this.g = paramBundle.getString("com.flurry.inmobi.MY_APP_ID");
    this.P = paramBundle.getBoolean("com.flurry.inmobi.test");
  }
  
  public final void f()
  {
    IMAdInterstitial localIMAdInterstitial = new IMAdInterstitial((Activity)getContext(), this.g);
    localIMAdInterstitial.setImAdInterstitialListener(new ca(this));
    IMAdRequest localIMAdRequest = new IMAdRequest();
    if (this.P)
    {
      Log.d(d, "InMobi Interstitial set to Test Mode.");
      localIMAdRequest.setTestMode(true);
    }
    localIMAdInterstitial.loadNewAd(localIMAdRequest);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */