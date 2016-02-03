package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public final class bv
  implements MediationBannerListener, MediationInterstitialListener
{
  private final bs nG;
  
  public bv(bs parambs)
  {
    this.nG = parambs;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    fq.aj("onClick must be called on the main UI thread.");
    dw.v("Adapter called onClick.");
    try
    {
      this.nG.P();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      dw.c("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    fq.aj("onAdClosed must be called on the main UI thread.");
    dw.v("Adapter called onAdClosed.");
    try
    {
      this.nG.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      dw.c("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    fq.aj("onAdClosed must be called on the main UI thread.");
    dw.v("Adapter called onAdClosed.");
    try
    {
      this.nG.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      dw.c("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    fq.aj("onAdFailedToLoad must be called on the main UI thread.");
    dw.v("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.nG.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      dw.c("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    fq.aj("onAdFailedToLoad must be called on the main UI thread.");
    dw.v("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.nG.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      dw.c("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    fq.aj("onAdLeftApplication must be called on the main UI thread.");
    dw.v("Adapter called onAdLeftApplication.");
    try
    {
      this.nG.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      dw.c("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    fq.aj("onAdLeftApplication must be called on the main UI thread.");
    dw.v("Adapter called onAdLeftApplication.");
    try
    {
      this.nG.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      dw.c("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    fq.aj("onAdLoaded must be called on the main UI thread.");
    dw.v("Adapter called onAdLoaded.");
    try
    {
      this.nG.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      dw.c("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    fq.aj("onAdLoaded must be called on the main UI thread.");
    dw.v("Adapter called onAdLoaded.");
    try
    {
      this.nG.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      dw.c("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    fq.aj("onAdOpened must be called on the main UI thread.");
    dw.v("Adapter called onAdOpened.");
    try
    {
      this.nG.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      dw.c("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    fq.aj("onAdOpened must be called on the main UI thread.");
    dw.v("Adapter called onAdOpened.");
    try
    {
      this.nG.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      dw.c("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */