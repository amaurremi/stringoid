package com.google.ads;

import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.util.b;

class h$2
  implements Runnable
{
  h$2(h paramh, MediationInterstitialAdapter paramMediationInterstitialAdapter) {}
  
  public void run()
  {
    try
    {
      this.a.showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.b("Error while telling adapter (" + this.b.h() + ") ad to show interstitial: ", localThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/h$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */