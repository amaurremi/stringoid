package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.eu;

final class a
  implements CustomEventBannerListener
{
  private final CustomEventAdapter a;
  private final MediationBannerListener b;
  
  public a(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
  {
    this.a = paramCustomEventAdapter;
    this.b = paramMediationBannerListener;
  }
  
  public void onClick()
  {
    eu.z("Custom event adapter called onFailedToReceiveAd.");
    this.b.onClick(this.a);
  }
  
  public void onDismissScreen()
  {
    eu.z("Custom event adapter called onFailedToReceiveAd.");
    this.b.onDismissScreen(this.a);
  }
  
  public void onFailedToReceiveAd()
  {
    eu.z("Custom event adapter called onFailedToReceiveAd.");
    this.b.onFailedToReceiveAd(this.a, AdRequest.ErrorCode.NO_FILL);
  }
  
  public void onLeaveApplication()
  {
    eu.z("Custom event adapter called onFailedToReceiveAd.");
    this.b.onLeaveApplication(this.a);
  }
  
  public void onPresentScreen()
  {
    eu.z("Custom event adapter called onFailedToReceiveAd.");
    this.b.onPresentScreen(this.a);
  }
  
  public void onReceivedAd(View paramView)
  {
    eu.z("Custom event adapter called onReceivedAd.");
    CustomEventAdapter.a(this.a, paramView);
    this.b.onReceivedAd(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/ads/mediation/customevent/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */