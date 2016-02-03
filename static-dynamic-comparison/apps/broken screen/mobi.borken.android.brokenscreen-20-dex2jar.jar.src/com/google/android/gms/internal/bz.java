package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public final class bz
  implements MediationBannerListener, MediationInterstitialListener
{
  private final bw nR;
  
  public bz(bw parambw)
  {
    this.nR = parambw;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdClicked must be called on the main UI thread.");
    ev.z("Adapter called onAdClicked.");
    try
    {
      this.nR.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ev.c("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdClicked must be called on the main UI thread.");
    ev.z("Adapter called onAdClicked.");
    try
    {
      this.nR.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ev.c("Could not call onAdClicked.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdClosed must be called on the main UI thread.");
    ev.z("Adapter called onAdClosed.");
    try
    {
      this.nR.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ev.c("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdClosed must be called on the main UI thread.");
    ev.z("Adapter called onAdClosed.");
    try
    {
      this.nR.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ev.c("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    hn.ay("onAdFailedToLoad must be called on the main UI thread.");
    ev.z("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.nR.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ev.c("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    hn.ay("onAdFailedToLoad must be called on the main UI thread.");
    ev.z("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.nR.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ev.c("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdLeftApplication must be called on the main UI thread.");
    ev.z("Adapter called onAdLeftApplication.");
    try
    {
      this.nR.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ev.c("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdLeftApplication must be called on the main UI thread.");
    ev.z("Adapter called onAdLeftApplication.");
    try
    {
      this.nR.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ev.c("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdLoaded must be called on the main UI thread.");
    ev.z("Adapter called onAdLoaded.");
    try
    {
      this.nR.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ev.c("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdLoaded must be called on the main UI thread.");
    ev.z("Adapter called onAdLoaded.");
    try
    {
      this.nR.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ev.c("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdOpened must be called on the main UI thread.");
    ev.z("Adapter called onAdOpened.");
    try
    {
      this.nR.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ev.c("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdOpened must be called on the main UI thread.");
    ev.z("Adapter called onAdOpened.");
    try
    {
      this.nR.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ev.c("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */