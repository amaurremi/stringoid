package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.millennialmedia.android.MMAdView;

final class ar
  extends m
{
  private static final String d = ar.class.getSimpleName();
  private boolean bL;
  private final String g;
  
  public ar(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit, Bundle paramBundle)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdUnit);
    this.g = paramBundle.getString("com.flurry.millennial.MYAPID");
  }
  
  public final void f()
  {
    MMAdView localMMAdView = new MMAdView((Activity)getContext(), this.g, "MMFullScreenAdTransition", true, null);
    localMMAdView.setId(1897808290);
    localMMAdView.setListener(new cc(this));
    localMMAdView.fetch();
    this.bL = localMMAdView.display();
    if (this.bL)
    {
      Log.d(d, "Millennial MMAdView Interstitial ad displayed immediately:" + System.currentTimeMillis() + " " + this.bL);
      return;
    }
    Log.d(d, "Millennial MMAdView Interstitial ad did not display immediately:" + System.currentTimeMillis() + " " + this.bL);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */