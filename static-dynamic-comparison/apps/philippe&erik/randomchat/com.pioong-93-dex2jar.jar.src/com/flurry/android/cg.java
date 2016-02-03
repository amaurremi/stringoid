package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import com.mobclix.android.sdk.MobclixFullScreenAdView;

final class cg
  extends m
{
  private static final String d = cg.class.getSimpleName();
  
  public cg(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdUnit);
  }
  
  public final void f()
  {
    MobclixFullScreenAdView localMobclixFullScreenAdView = new MobclixFullScreenAdView((Activity)getContext());
    localMobclixFullScreenAdView.addMobclixAdViewListener(new au(this));
    localMobclixFullScreenAdView.requestAndDisplayAd();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */