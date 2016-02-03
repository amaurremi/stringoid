package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class ah
{
  private AppEventListener eI;
  private String eK;
  private final ba eW = new ba();
  private ac eX;
  private AdListener ev;
  private final Context mContext;
  
  public ah(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void j(String paramString)
    throws RemoteException
  {
    if (this.eK == null) {
      k(paramString);
    }
    this.eX = u.a(this.mContext, new x(), this.eK, this.eW);
    if (this.ev != null) {
      this.eX.a(new t(this.ev));
    }
    if (this.eI != null) {
      this.eX.a(new z(this.eI));
    }
  }
  
  private void k(String paramString)
  {
    if (this.eX == null) {
      throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
    }
  }
  
  public void a(af paramaf)
  {
    try
    {
      if (this.eX == null) {
        j("loadAd");
      }
      if (this.eX.a(new v(this.mContext, paramaf))) {
        this.eW.c(paramaf.R());
      }
      return;
    }
    catch (RemoteException paramaf)
    {
      ct.b("Failed to load ad.", paramaf);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.ev;
  }
  
  public String getAdUnitId()
  {
    return this.eK;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.eI;
  }
  
  public boolean isLoaded()
  {
    try
    {
      if (this.eX == null) {
        return false;
      }
      boolean bool = this.eX.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Failed to check if ad is ready.", localRemoteException);
    }
    return false;
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.ev = paramAdListener;
      ac localac;
      if (this.eX != null)
      {
        localac = this.eX;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAdListener = new t(paramAdListener);; paramAdListener = null)
      {
        localac.a(paramAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      ct.b("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.eK != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }
    this.eK = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.eI = paramAppEventListener;
      ac localac;
      if (this.eX != null)
      {
        localac = this.eX;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new z(paramAppEventListener);; paramAppEventListener = null)
      {
        localac.a(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      ct.b("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void show()
  {
    try
    {
      k("show");
      this.eX.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Failed to show interstitial.", localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */