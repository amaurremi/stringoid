package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import com.google.android.gms.ads.mediation.MediationBannerListener;
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
  
  public void onAdClicked()
  {
    eu.z("Custom event adapter called onAdClicked.");
    this.b.onAdClicked(this.a);
  }
  
  public void onAdClosed()
  {
    eu.z("Custom event adapter called onAdClosed.");
    this.b.onAdClosed(this.a);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    eu.z("Custom event adapter called onAdFailedToLoad.");
    this.b.onAdFailedToLoad(this.a, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    eu.z("Custom event adapter called onAdLeftApplication.");
    this.b.onAdLeftApplication(this.a);
  }
  
  public void onAdLoaded(View paramView)
  {
    eu.z("Custom event adapter called onAdLoaded.");
    CustomEventAdapter.a(this.a, paramView);
    this.b.onAdLoaded(this.a);
  }
  
  public void onAdOpened()
  {
    eu.z("Custom event adapter called onAdOpened.");
    this.b.onAdOpened(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/ads/mediation/customevent/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */