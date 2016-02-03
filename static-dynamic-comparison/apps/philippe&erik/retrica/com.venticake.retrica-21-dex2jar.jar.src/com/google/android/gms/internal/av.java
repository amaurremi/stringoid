package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class av
{
  private AdListener lQ;
  private InAppPurchaseListener mB;
  private PlayStorePurchaseListener mC;
  private final Context mContext;
  private AppEventListener mh;
  private String mj;
  private final bs mw = new bs();
  private final ak mx;
  private aq my;
  private String mz;
  
  public av(Context paramContext)
  {
    this(paramContext, ak.aF());
  }
  
  public av(Context paramContext, ak paramak)
  {
    this.mContext = paramContext;
    this.mx = paramak;
  }
  
  private void k(String paramString)
  {
    if (this.mj == null) {
      l(paramString);
    }
    this.my = ah.a(this.mContext, new al(), this.mj, this.mw);
    if (this.lQ != null) {
      this.my.a(new ag(this.lQ));
    }
    if (this.mh != null) {
      this.my.a(new an(this.mh));
    }
    if (this.mB != null) {
      this.my.a(new dh(this.mB));
    }
    if (this.mC != null) {
      this.my.a(new dl(this.mC), this.mz);
    }
  }
  
  private void l(String paramString)
  {
    if (this.my == null) {
      throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
    }
  }
  
  public void a(at paramat)
  {
    try
    {
      if (this.my == null) {
        k("loadAd");
      }
      if (this.my.a(this.mx.a(this.mContext, paramat))) {
        this.mw.c(paramat.aI());
      }
      return;
    }
    catch (RemoteException paramat)
    {
      eu.c("Failed to load ad.", paramat);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.lQ;
  }
  
  public String getAdUnitId()
  {
    return this.mj;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.mh;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.mB;
  }
  
  public boolean isLoaded()
  {
    try
    {
      if (this.my == null) {
        return false;
      }
      boolean bool = this.my.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Failed to check if ad is ready.", localRemoteException);
    }
    return false;
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.lQ = paramAdListener;
      aq localaq;
      if (this.my != null)
      {
        localaq = this.my;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAdListener = new ag(paramAdListener);; paramAdListener = null)
      {
        localaq.a(paramAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      eu.c("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.mj != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }
    this.mj = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.mh = paramAppEventListener;
      aq localaq;
      if (this.my != null)
      {
        localaq = this.my;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new an(paramAppEventListener);; paramAppEventListener = null)
      {
        localaq.a(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      eu.c("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (this.mC != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      this.mB = paramInAppPurchaseListener;
      aq localaq;
      if (this.my != null)
      {
        localaq = this.my;
        if (paramInAppPurchaseListener == null) {
          break label55;
        }
      }
      label55:
      for (paramInAppPurchaseListener = new dh(paramInAppPurchaseListener);; paramInAppPurchaseListener = null)
      {
        localaq.a(paramInAppPurchaseListener);
        return;
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      eu.c("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    try
    {
      this.mC = paramPlayStorePurchaseListener;
      aq localaq;
      if (this.my != null)
      {
        localaq = this.my;
        if (paramPlayStorePurchaseListener == null) {
          break label39;
        }
      }
      label39:
      for (paramPlayStorePurchaseListener = new dl(paramPlayStorePurchaseListener);; paramPlayStorePurchaseListener = null)
      {
        localaq.a(paramPlayStorePurchaseListener, paramString);
        return;
      }
      return;
    }
    catch (RemoteException paramPlayStorePurchaseListener)
    {
      eu.c("Failed to set the play store purchase parameter.", paramPlayStorePurchaseListener);
    }
  }
  
  public void show()
  {
    try
    {
      l("show");
      this.my.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Failed to show interstitial.", localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */