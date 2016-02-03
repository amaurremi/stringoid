package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.eu;

class b
  implements CustomEventInterstitialListener
{
  private final CustomEventAdapter b;
  private final MediationInterstitialListener c;
  
  public b(CustomEventAdapter paramCustomEventAdapter1, CustomEventAdapter paramCustomEventAdapter2, MediationInterstitialListener paramMediationInterstitialListener)
  {
    this.b = paramCustomEventAdapter2;
    this.c = paramMediationInterstitialListener;
  }
  
  public void onAdClicked()
  {
    eu.z("Custom event adapter called onAdClicked.");
    this.c.onAdClicked(this.b);
  }
  
  public void onAdClosed()
  {
    eu.z("Custom event adapter called onAdClosed.");
    this.c.onAdClosed(this.b);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    eu.z("Custom event adapter called onFailedToReceiveAd.");
    this.c.onAdFailedToLoad(this.b, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    eu.z("Custom event adapter called onAdLeftApplication.");
    this.c.onAdLeftApplication(this.b);
  }
  
  public void onAdLoaded()
  {
    eu.z("Custom event adapter called onReceivedAd.");
    this.c.onAdLoaded(this.a);
  }
  
  public void onAdOpened()
  {
    eu.z("Custom event adapter called onAdOpened.");
    this.c.onAdOpened(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/ads/mediation/customevent/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */