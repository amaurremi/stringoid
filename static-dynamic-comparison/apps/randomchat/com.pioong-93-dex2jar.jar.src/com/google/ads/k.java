package com.google.ads;

import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.a;
import com.google.ads.util.b;

class k
  implements MediationInterstitialListener
{
  private final h a;
  
  k(h paramh)
  {
    this.a = paramh;
  }
  
  public void onDismissScreen(MediationInterstitialAdapter<?, ?> arg1)
  {
    synchronized (this.a)
    {
      this.a.j().b(this.a);
      return;
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, AdRequest.ErrorCode paramErrorCode)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        a.a(paramMediationInterstitialAdapter, this.a.i());
        b.a("Mediation adapter " + paramMediationInterstitialAdapter.getClass().getName() + " failed to receive ad with error code: " + paramErrorCode);
        if (this.a.c())
        {
          b.b("Got an onFailedToReceiveAd() callback after loadAdTask is done from an interstitial adapter.  Ignoring callback.");
          return;
        }
        h localh2 = this.a;
        if (paramErrorCode == AdRequest.ErrorCode.NO_FILL)
        {
          paramMediationInterstitialAdapter = g.a.b;
          localh2.a(false, paramMediationInterstitialAdapter);
        }
      }
      paramMediationInterstitialAdapter = g.a.c;
    }
  }
  
  public void onLeaveApplication(MediationInterstitialAdapter<?, ?> arg1)
  {
    synchronized (this.a)
    {
      this.a.j().c(this.a);
      return;
    }
  }
  
  public void onPresentScreen(MediationInterstitialAdapter<?, ?> arg1)
  {
    synchronized (this.a)
    {
      this.a.j().a(this.a);
      return;
    }
  }
  
  public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    synchronized (this.a)
    {
      a.a(paramMediationInterstitialAdapter, this.a.i());
      if (this.a.c())
      {
        b.e("Got an onReceivedAd() callback after loadAdTask is done from an interstitial adapter. Ignoring callback.");
        return;
      }
      this.a.a(true, g.a.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */