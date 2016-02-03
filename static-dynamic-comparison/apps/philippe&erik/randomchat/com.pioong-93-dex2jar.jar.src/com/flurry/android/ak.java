package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.ads.AdRequest;
import com.google.ads.InterstitialAd;

final class ak
  extends m
{
  private static final String d = ak.class.getSimpleName();
  private final boolean P;
  private final String bD;
  private final InterstitialAd bI;
  private final String g;
  
  public ak(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdUnit);
    this.g = paramBundle.getString("com.flurry.admob.MY_AD_UNIT_ID");
    this.bD = paramBundle.getString("com.flurry.admob.MYTEST_AD_DEVICE_ID");
    this.P = paramBundle.getBoolean("com.flurry.admob.test");
    this.bI = new InterstitialAd((Activity)getContext(), this.g);
    this.bI.setAdListener(new ch(this));
  }
  
  public final void f()
  {
    AdRequest localAdRequest = new AdRequest();
    if (this.P)
    {
      Log.d(d, "Admob AdView set to Test Mode.");
      localAdRequest.addTestDevice(AdRequest.TEST_EMULATOR);
      if (!TextUtils.isEmpty(this.bD)) {
        localAdRequest.addTestDevice(this.bD);
      }
    }
    this.bI.loadAd(localAdRequest);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */