package com.google.ads.mediation.customevent;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationInterstitialListener;
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
  
  public void onDismissScreen()
  {
    eu.z("Custom event adapter called onDismissScreen.");
    this.c.onDismissScreen(this.b);
  }
  
  public void onFailedToReceiveAd()
  {
    eu.z("Custom event adapter called onFailedToReceiveAd.");
    this.c.onFailedToReceiveAd(this.b, AdRequest.ErrorCode.NO_FILL);
  }
  
  public void onLeaveApplication()
  {
    eu.z("Custom event adapter called onLeaveApplication.");
    this.c.onLeaveApplication(this.b);
  }
  
  public void onPresentScreen()
  {
    eu.z("Custom event adapter called onPresentScreen.");
    this.c.onPresentScreen(this.b);
  }
  
  public void onReceivedAd()
  {
    eu.z("Custom event adapter called onReceivedAd.");
    this.c.onReceivedAd(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/ads/mediation/customevent/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */