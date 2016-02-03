package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class ca<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  implements MediationBannerListener, MediationInterstitialListener
{
  private final bv nT;
  
  public ca(bv parambv)
  {
    this.nT = parambv;
  }
  
  public void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    eu.z("Adapter called onClick.");
    if (!et.bW())
    {
      eu.D("onClick must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdClicked();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdClicked.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    eu.z("Adapter called onDismissScreen.");
    if (!et.bW())
    {
      eu.D("onDismissScreen must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    eu.z("Adapter called onDismissScreen.");
    if (!et.bW())
    {
      eu.D("onDismissScreen must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    eu.z("Adapter called onFailedToReceiveAd with error. " + paramErrorCode);
    if (!et.bW())
    {
      eu.D("onFailedToReceiveAd must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdFailedToLoad(cb.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.nT.onAdFailedToLoad(cb.a(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      eu.c("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    eu.z("Adapter called onFailedToReceiveAd with error " + paramErrorCode + ".");
    if (!et.bW())
    {
      eu.D("onFailedToReceiveAd must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdFailedToLoad(cb.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.nT.onAdFailedToLoad(cb.a(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      eu.c("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    eu.z("Adapter called onLeaveApplication.");
    if (!et.bW())
    {
      eu.D("onLeaveApplication must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    eu.z("Adapter called onLeaveApplication.");
    if (!et.bW())
    {
      eu.D("onLeaveApplication must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    eu.z("Adapter called onPresentScreen.");
    if (!et.bW())
    {
      eu.D("onPresentScreen must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    eu.z("Adapter called onPresentScreen.");
    if (!et.bW())
    {
      eu.D("onPresentScreen must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    eu.z("Adapter called onReceivedAd.");
    if (!et.bW())
    {
      eu.D("onReceivedAd must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    eu.z("Adapter called onReceivedAd.");
    if (!et.bW())
    {
      eu.D("onReceivedAd must be called on the main UI thread.");
      et.sv.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ca.a(ca.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            eu.c("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */