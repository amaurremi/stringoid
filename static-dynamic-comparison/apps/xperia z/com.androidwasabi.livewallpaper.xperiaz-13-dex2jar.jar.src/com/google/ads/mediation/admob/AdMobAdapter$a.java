package com.google.ads.mediation.admob;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerListener;

class AdMobAdapter$a
  implements AdListener
{
  private AdMobAdapter$a(AdMobAdapter paramAdMobAdapter) {}
  
  public void onDismissScreen(Ad paramAd)
  {
    AdMobAdapter.a(this.a).onDismissScreen(this.a);
  }
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    AdMobAdapter.a(this.a).onFailedToReceiveAd(this.a, paramErrorCode);
  }
  
  public void onLeaveApplication(Ad paramAd)
  {
    AdMobAdapter.a(this.a).onLeaveApplication(this.a);
  }
  
  public void onPresentScreen(Ad paramAd)
  {
    AdMobAdapter.a(this.a).onClick(this.a);
    AdMobAdapter.a(this.a).onPresentScreen(this.a);
  }
  
  public void onReceiveAd(Ad paramAd)
  {
    AdMobAdapter.a(this.a).onReceivedAd(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapter$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */