package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public final class by
  implements MediationBannerListener, MediationInterstitialListener
{
  private final bv nT;
  
  public by(bv parambv)
  {
    this.nT = parambv;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hm.ay("onAdClicked must be called on the main UI thread.");
    eu.z("Adapter called onAdClicked.");
    try
    {
      this.nT.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      eu.c("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hm.ay("onAdClicked must be called on the main UI thread.");
    eu.z("Adapter called onAdClicked.");
    try
    {
      this.nT.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      eu.c("Could not call onAdClicked.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hm.ay("onAdClosed must be called on the main UI thread.");
    eu.z("Adapter called onAdClosed.");
    try
    {
      this.nT.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      eu.c("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hm.ay("onAdClosed must be called on the main UI thread.");
    eu.z("Adapter called onAdClosed.");
    try
    {
      this.nT.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      eu.c("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    hm.ay("onAdFailedToLoad must be called on the main UI thread.");
    eu.z("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.nT.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      eu.c("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    hm.ay("onAdFailedToLoad must be called on the main UI thread.");
    eu.z("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.nT.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      eu.c("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hm.ay("onAdLeftApplication must be called on the main UI thread.");
    eu.z("Adapter called onAdLeftApplication.");
    try
    {
      this.nT.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      eu.c("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hm.ay("onAdLeftApplication must be called on the main UI thread.");
    eu.z("Adapter called onAdLeftApplication.");
    try
    {
      this.nT.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      eu.c("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hm.ay("onAdLoaded must be called on the main UI thread.");
    eu.z("Adapter called onAdLoaded.");
    try
    {
      this.nT.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      eu.c("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hm.ay("onAdLoaded must be called on the main UI thread.");
    eu.z("Adapter called onAdLoaded.");
    try
    {
      this.nT.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      eu.c("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hm.ay("onAdOpened must be called on the main UI thread.");
    eu.z("Adapter called onAdOpened.");
    try
    {
      this.nT.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      eu.c("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hm.ay("onAdOpened must be called on the main UI thread.");
    eu.z("Adapter called onAdOpened.");
    try
    {
      this.nT.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      eu.c("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */