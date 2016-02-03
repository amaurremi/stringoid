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

public final class bf<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  implements MediationBannerListener, MediationInterstitialListener
{
  private final bd gi;
  
  public bf(bd parambd)
  {
    this.gi = parambd;
  }
  
  public void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ct.r("Adapter called onClick.");
    if (!cs.ay())
    {
      ct.v("onClick must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).w();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdClicked.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.w();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ct.b("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ct.r("Adapter called onDismissScreen.");
    if (!cs.ay())
    {
      ct.v("onDismissScreen must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ct.b("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ct.r("Adapter called onDismissScreen.");
    if (!cs.ay())
    {
      ct.v("onDismissScreen must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ct.b("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    ct.r("Adapter called onFailedToReceiveAd with error. " + paramErrorCode);
    if (!cs.ay())
    {
      ct.v("onFailedToReceiveAd must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdFailedToLoad(bg.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdFailedToLoad(bg.a(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ct.b("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    ct.r("Adapter called onFailedToReceiveAd with error " + paramErrorCode + ".");
    if (!cs.ay())
    {
      ct.v("onFailedToReceiveAd must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdFailedToLoad(bg.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdFailedToLoad(bg.a(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ct.b("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ct.r("Adapter called onLeaveApplication.");
    if (!cs.ay())
    {
      ct.v("onLeaveApplication must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ct.b("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ct.r("Adapter called onLeaveApplication.");
    if (!cs.ay())
    {
      ct.v("onLeaveApplication must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ct.b("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ct.r("Adapter called onPresentScreen.");
    if (!cs.ay())
    {
      ct.v("onPresentScreen must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ct.b("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ct.r("Adapter called onPresentScreen.");
    if (!cs.ay())
    {
      ct.v("onPresentScreen must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ct.b("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ct.r("Adapter called onReceivedAd.");
    if (!cs.ay())
    {
      ct.v("onReceivedAd must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      ct.b("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ct.r("Adapter called onReceivedAd.");
    if (!cs.ay())
    {
      ct.v("onReceivedAd must be called on the main UI thread.");
      cs.iI.post(new Runnable()
      {
        public void run()
        {
          try
          {
            bf.a(bf.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            ct.b("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.gi.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      ct.b("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */