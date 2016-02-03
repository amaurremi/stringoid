package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.internal.n;

@ez
public final class cy
  implements MediationBannerListener, MediationInterstitialListener
{
  private final cv qF;
  
  public cy(cv paramcv)
  {
    this.qF = paramcv;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    n.aT("onAdClicked must be called on the main UI thread.");
    gs.S("Adapter called onAdClicked.");
    try
    {
      this.qF.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      gs.d("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    n.aT("onAdClicked must be called on the main UI thread.");
    gs.S("Adapter called onAdClicked.");
    try
    {
      this.qF.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      gs.d("Could not call onAdClicked.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    n.aT("onAdClosed must be called on the main UI thread.");
    gs.S("Adapter called onAdClosed.");
    try
    {
      this.qF.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      gs.d("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    n.aT("onAdClosed must be called on the main UI thread.");
    gs.S("Adapter called onAdClosed.");
    try
    {
      this.qF.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      gs.d("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    n.aT("onAdFailedToLoad must be called on the main UI thread.");
    gs.S("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.qF.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      gs.d("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    n.aT("onAdFailedToLoad must be called on the main UI thread.");
    gs.S("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.qF.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      gs.d("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    n.aT("onAdLeftApplication must be called on the main UI thread.");
    gs.S("Adapter called onAdLeftApplication.");
    try
    {
      this.qF.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      gs.d("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    n.aT("onAdLeftApplication must be called on the main UI thread.");
    gs.S("Adapter called onAdLeftApplication.");
    try
    {
      this.qF.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      gs.d("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    n.aT("onAdLoaded must be called on the main UI thread.");
    gs.S("Adapter called onAdLoaded.");
    try
    {
      this.qF.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      gs.d("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    n.aT("onAdLoaded must be called on the main UI thread.");
    gs.S("Adapter called onAdLoaded.");
    try
    {
      this.qF.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      gs.d("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    n.aT("onAdOpened must be called on the main UI thread.");
    gs.S("Adapter called onAdOpened.");
    try
    {
      this.qF.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      gs.d("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    n.aT("onAdOpened must be called on the main UI thread.");
    gs.S("Adapter called onAdOpened.");
    try
    {
      this.qF.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      gs.d("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */