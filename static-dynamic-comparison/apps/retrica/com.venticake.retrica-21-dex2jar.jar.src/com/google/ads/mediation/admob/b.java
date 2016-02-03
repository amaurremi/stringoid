package com.google.ads.mediation.admob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

final class b
  extends AdListener
{
  private final AdMobAdapter a;
  private final MediationInterstitialListener b;
  
  public b(AdMobAdapter paramAdMobAdapter, MediationInterstitialListener paramMediationInterstitialListener)
  {
    this.a = paramAdMobAdapter;
    this.b = paramMediationInterstitialListener;
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
    this.b.onAdOpened(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/ads/mediation/admob/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */