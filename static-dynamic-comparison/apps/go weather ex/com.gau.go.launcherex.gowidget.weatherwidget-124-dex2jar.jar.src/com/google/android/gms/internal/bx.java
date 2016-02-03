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

public final class bx<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  implements MediationBannerListener, MediationInterstitialListener
{
  private final bs nG;
  
  public bx(bs parambs)
  {
    this.nG = parambs;
  }
  
  public void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    dw.v("Adapter called onClick.");
    if (!dv.bD())
    {
      dw.z("onClick must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).P();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdClicked.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    dw.v("Adapter called onDismissScreen.");
    if (!dv.bD())
    {
      dw.z("onDismissScreen must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    dw.v("Adapter called onDismissScreen.");
    if (!dv.bD())
    {
      dw.z("onDismissScreen must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    dw.v("Adapter called onFailedToReceiveAd with error. " + paramErrorCode);
    if (!dv.bD())
    {
      dw.z("onFailedToReceiveAd must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdFailedToLoad(by.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.nG.onAdFailedToLoad(by.a(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      dw.c("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    dw.v("Adapter called onFailedToReceiveAd with error " + paramErrorCode + ".");
    if (!dv.bD())
    {
      dw.z("onFailedToReceiveAd must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdFailedToLoad(by.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.nG.onAdFailedToLoad(by.a(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      dw.c("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    dw.v("Adapter called onLeaveApplication.");
    if (!dv.bD())
    {
      dw.z("onLeaveApplication must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    dw.v("Adapter called onLeaveApplication.");
    if (!dv.bD())
    {
      dw.z("onLeaveApplication must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    dw.v("Adapter called onPresentScreen.");
    if (!dv.bD())
    {
      dw.z("onPresentScreen must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    dw.v("Adapter called onPresentScreen.");
    if (!dv.bD())
    {
      dw.z("onPresentScreen must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    dw.v("Adapter called onReceivedAd.");
    if (!dv.bD())
    {
      dw.z("onReceivedAd must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    dw.v("Adapter called onReceivedAd.");
    if (!dv.bD())
    {
      dw.z("onReceivedAd must be called on the main UI thread.");
      dv.rp.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bx.a(bx.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            dw.c("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */