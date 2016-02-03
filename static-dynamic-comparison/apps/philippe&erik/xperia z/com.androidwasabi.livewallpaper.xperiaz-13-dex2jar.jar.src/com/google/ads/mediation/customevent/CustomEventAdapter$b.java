package com.google.ads.mediation.customevent;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.b;

class CustomEventAdapter$b
  implements CustomEventInterstitialListener
{
  private final MediationInterstitialListener b;
  
  public CustomEventAdapter$b(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
  {
    this.b = paramMediationInterstitialListener;
  }
  
  private String a()
  {
    return "Interstitial custom event labeled '" + CustomEventAdapter.a(this.a) + "'";
  }
  
  public void onDismissScreen()
  {
    b.a(a() + " called onDismissScreen().");
    this.b.onDismissScreen(this.a);
  }
  
  public void onFailedToReceiveAd()
  {
    b.a(a() + " called onFailedToReceiveAd().");
    this.b.onFailedToReceiveAd(this.a, AdRequest.ErrorCode.NO_FILL);
  }
  
  public void onLeaveApplication()
  {
    try
    {
      b.a(a() + " called onLeaveApplication().");
      this.b.onLeaveApplication(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onPresentScreen()
  {
    b.a(a() + " called onPresentScreen().");
    this.b.onPresentScreen(this.a);
  }
  
  public void onReceivedAd()
  {
    b.a(a() + " called onReceivedAd.");
    this.b.onReceivedAd(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */