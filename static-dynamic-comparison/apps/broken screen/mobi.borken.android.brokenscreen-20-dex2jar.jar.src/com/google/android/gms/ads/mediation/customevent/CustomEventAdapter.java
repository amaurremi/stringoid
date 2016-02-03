package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.ev;

public final class CustomEventAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter
{
  private View n;
  private CustomEventBanner sT;
  private CustomEventInterstitial sU;
  
  private static <T> T a(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      ev.D("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    return null;
  }
  
  private void a(View paramView)
  {
    this.n = paramView;
  }
  
  public View getBannerView()
  {
    return this.n;
  }
  
  public void onDestroy()
  {
    if (this.sT != null) {
      this.sT.onDestroy();
    }
    if (this.sU != null) {
      this.sU.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.sT != null) {
      this.sT.onPause();
    }
    if (this.sU != null) {
      this.sU.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.sT != null) {
      this.sT.onResume();
    }
    if (this.sU != null) {
      this.sU.onResume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.sT = ((CustomEventBanner)a(paramBundle1.getString("class_name")));
    if (this.sT == null)
    {
      paramMediationBannerListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.sT.requestBannerAd(paramContext, new a(this, paramMediationBannerListener), paramBundle1.getString("parameter"), paramAdSize, paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.sU = ((CustomEventInterstitial)a(paramBundle1.getString("class_name")));
    if (this.sU == null)
    {
      paramMediationInterstitialListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.sU.requestInterstitialAd(paramContext, new b(this, paramMediationInterstitialListener), paramBundle1.getString("parameter"), paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void showInterstitial()
  {
    this.sU.showInterstitial();
  }
  
  private static final class a
    implements CustomEventBannerListener
  {
    private final MediationBannerListener l;
    private final CustomEventAdapter sV;
    
    public a(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.sV = paramCustomEventAdapter;
      this.l = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      ev.z("Custom event adapter called onAdClicked.");
      this.l.onAdClicked(this.sV);
    }
    
    public void onAdClosed()
    {
      ev.z("Custom event adapter called onAdClosed.");
      this.l.onAdClosed(this.sV);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      ev.z("Custom event adapter called onAdFailedToLoad.");
      this.l.onAdFailedToLoad(this.sV, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      ev.z("Custom event adapter called onAdLeftApplication.");
      this.l.onAdLeftApplication(this.sV);
    }
    
    public void onAdLoaded(View paramView)
    {
      ev.z("Custom event adapter called onAdLoaded.");
      CustomEventAdapter.a(this.sV, paramView);
      this.l.onAdLoaded(this.sV);
    }
    
    public void onAdOpened()
    {
      ev.z("Custom event adapter called onAdOpened.");
      this.l.onAdOpened(this.sV);
    }
  }
  
  private class b
    implements CustomEventInterstitialListener
  {
    private final MediationInterstitialListener m;
    private final CustomEventAdapter sV;
    
    public b(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.sV = paramCustomEventAdapter;
      this.m = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      ev.z("Custom event adapter called onAdClicked.");
      this.m.onAdClicked(this.sV);
    }
    
    public void onAdClosed()
    {
      ev.z("Custom event adapter called onAdClosed.");
      this.m.onAdClosed(this.sV);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      ev.z("Custom event adapter called onFailedToReceiveAd.");
      this.m.onAdFailedToLoad(this.sV, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      ev.z("Custom event adapter called onAdLeftApplication.");
      this.m.onAdLeftApplication(this.sV);
    }
    
    public void onAdLoaded()
    {
      ev.z("Custom event adapter called onReceivedAd.");
      this.m.onAdLoaded(CustomEventAdapter.this);
    }
    
    public void onAdOpened()
    {
      ev.z("Custom event adapter called onAdOpened.");
      this.m.onAdOpened(this.sV);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/ads/mediation/customevent/CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */