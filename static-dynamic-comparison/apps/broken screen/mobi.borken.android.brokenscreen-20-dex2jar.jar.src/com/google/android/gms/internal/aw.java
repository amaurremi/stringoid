package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class aw
{
  private AdListener lO;
  private PlayStorePurchaseListener mA;
  private final Context mContext;
  private AppEventListener mf;
  private String mh;
  private final bt mu = new bt();
  private final al mv;
  private ar mw;
  private String mx;
  private InAppPurchaseListener mz;
  
  public aw(Context paramContext)
  {
    this(paramContext, al.aA());
  }
  
  public aw(Context paramContext, al paramal)
  {
    this.mContext = paramContext;
    this.mv = paramal;
  }
  
  private void k(String paramString)
    throws RemoteException
  {
    if (this.mh == null) {
      l(paramString);
    }
    this.mw = ai.a(this.mContext, new am(), this.mh, this.mu);
    if (this.lO != null) {
      this.mw.a(new ah(this.lO));
    }
    if (this.mf != null) {
      this.mw.a(new ao(this.mf));
    }
    if (this.mz != null) {
      this.mw.a(new di(this.mz));
    }
    if (this.mA != null) {
      this.mw.a(new dm(this.mA), this.mx);
    }
  }
  
  private void l(String paramString)
  {
    if (this.mw == null) {
      throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
    }
  }
  
  public void a(au paramau)
  {
    try
    {
      if (this.mw == null) {
        k("loadAd");
      }
      if (this.mw.a(this.mv.a(this.mContext, paramau))) {
        this.mu.c(paramau.aD());
      }
      return;
    }
    catch (RemoteException paramau)
    {
      ev.c("Failed to load ad.", paramau);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.lO;
  }
  
  public String getAdUnitId()
  {
    return this.mh;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.mf;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.mz;
  }
  
  public boolean isLoaded()
  {
    try
    {
      if (this.mw == null) {
        return false;
      }
      boolean bool = this.mw.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to check if ad is ready.", localRemoteException);
    }
    return false;
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.lO = paramAdListener;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAdListener = new ah(paramAdListener);; paramAdListener = null)
      {
        localar.a(paramAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      ev.c("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.mh != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }
    this.mh = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.mf = paramAppEventListener;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new ao(paramAppEventListener);; paramAppEventListener = null)
      {
        localar.a(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      ev.c("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (this.mA != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      this.mz = paramInAppPurchaseListener;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramInAppPurchaseListener == null) {
          break label55;
        }
      }
      label55:
      for (paramInAppPurchaseListener = new di(paramInAppPurchaseListener);; paramInAppPurchaseListener = null)
      {
        localar.a(paramInAppPurchaseListener);
        return;
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      ev.c("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    try
    {
      this.mA = paramPlayStorePurchaseListener;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramPlayStorePurchaseListener == null) {
          break label39;
        }
      }
      label39:
      for (paramPlayStorePurchaseListener = new dm(paramPlayStorePurchaseListener);; paramPlayStorePurchaseListener = null)
      {
        localar.a(paramPlayStorePurchaseListener, paramString);
        return;
      }
      return;
    }
    catch (RemoteException paramPlayStorePurchaseListener)
    {
      ev.c("Failed to set the play store purchase parameter.", paramPlayStorePurchaseListener);
    }
  }
  
  public void show()
  {
    try
    {
      l("show");
      this.mw.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to show interstitial.", localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */