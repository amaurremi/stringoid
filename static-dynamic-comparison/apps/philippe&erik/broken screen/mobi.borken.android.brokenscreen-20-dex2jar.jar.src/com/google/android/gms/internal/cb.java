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

public final class cb<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  implements MediationBannerListener, MediationInterstitialListener
{
  private final bw nR;
  
  public cb(bw parambw)
  {
    this.nR = parambw;
  }
  
  public void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onClick.");
    if (!eu.bR())
    {
      ev.D("onClick must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdClicked();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdClicked.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onDismissScreen.");
    if (!eu.bR())
    {
      ev.D("onDismissScreen must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ev.z("Adapter called onDismissScreen.");
    if (!eu.bR())
    {
      ev.D("onDismissScreen must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    ev.z("Adapter called onFailedToReceiveAd with error. " + paramErrorCode);
    if (!eu.bR())
    {
      ev.D("onFailedToReceiveAd must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdFailedToLoad(cc.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.nR.onAdFailedToLoad(cc.a(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ev.c("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    ev.z("Adapter called onFailedToReceiveAd with error " + paramErrorCode + ".");
    if (!eu.bR())
    {
      ev.D("onFailedToReceiveAd must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdFailedToLoad(cc.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.nR.onAdFailedToLoad(cc.a(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ev.c("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onLeaveApplication.");
    if (!eu.bR())
    {
      ev.D("onLeaveApplication must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ev.z("Adapter called onLeaveApplication.");
    if (!eu.bR())
    {
      ev.D("onLeaveApplication must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onPresentScreen.");
    if (!eu.bR())
    {
      ev.D("onPresentScreen must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ev.z("Adapter called onPresentScreen.");
    if (!eu.bR())
    {
      ev.D("onPresentScreen must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onReceivedAd.");
    if (!eu.bR())
    {
      ev.D("onReceivedAd must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ev.z("Adapter called onReceivedAd.");
    if (!eu.bR())
    {
      ev.D("onReceivedAd must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ev.c("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */