package com.google.ads.mediation.admob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.mediation.MediationBannerListener;

final class a
  extends AdListener
{
  private final AdMobAdapter a;
  private final MediationBannerListener b;
  
  public a(AdMobAdapter paramAdMobAdapter, MediationBannerListener paramMediationBannerListener)
  {
    this.a = paramAdMobAdapter;
    this.b = paramMediationBannerListener;
  }
  
  public void onAdClosed()
  {
    this.b.onAdClosed(this.a);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    this.b.onAdFailedToLoad(this.a, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    this.b.onAdLeftApplication(this.a);
  }
  
  public void onAdLoaded()
  {
    this.b.onAdLoaded(this.a);
  }
  
  public void onAdOpened()
  {
    this.b.onAdClicked(this.a);
    this.b.onAdOpened(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/ads/mediation/admob/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */