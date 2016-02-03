package com.google.ads.mediation.admob;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationInterstitialListener;

class AdMobAdapter$b
  implements AdListener
{
  private AdMobAdapter$b(AdMobAdapter paramAdMobAdapter) {}
  
  public void onDismissScreen(Ad paramAd)
  {
    AdMobAdapter.b(this.a).onDismissScreen(this.a);
  }
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    AdMobAdapter.b(this.a).onFailedToReceiveAd(this.a, paramErrorCode);
  }
  
  public void onLeaveApplication(Ad paramAd)
  {
    AdMobAdapter.b(this.a).onLeaveApplication(this.a);
  }
  
  public void onPresentScreen(Ad paramAd)
  {
    AdMobAdapter.b(this.a).onPresentScreen(this.a);
  }
  
  public void onReceiveAd(Ad paramAd)
  {
    AdMobAdapter.b(this.a).onReceivedAd(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapter$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */