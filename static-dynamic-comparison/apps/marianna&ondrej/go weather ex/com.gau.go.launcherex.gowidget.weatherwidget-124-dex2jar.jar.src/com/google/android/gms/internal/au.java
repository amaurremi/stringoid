package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;

public final class au
{
  private AdListener lF;
  private AppEventListener lV;
  private String lX;
  private final Context mContext;
  private final bp ml = new bp();
  private final aj mm;
  private ap mn;
  private InAppPurchaseListener mp;
  
  public au(Context paramContext)
  {
    this(paramContext, aj.az());
  }
  
  public au(Context paramContext, aj paramaj)
  {
    this.mContext = paramContext;
    this.mm = paramaj;
  }
  
  private void k(String paramString)
    throws RemoteException
  {
    if (this.lX == null) {
      l(paramString);
    }
    this.mn = ag.a(this.mContext, new ak(), this.lX, this.ml);
    if (this.lF != null) {
      this.mn.a(new af(this.lF));
    }
    if (this.lV != null) {
      this.mn.a(new am(this.lV));
    }
    if (this.mp != null) {
      this.mn.a(new cp(this.mp));
    }
  }
  
  private void l(String paramString)
  {
    if (this.mn == null) {
      throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
    }
  }
  
  public void a(as paramas)
  {
    try
    {
      if (this.mn == null) {
        k("loadAd");
      }
      if (this.mn.a(this.mm.a(this.mContext, paramas)))
      {
        this.ml.c(paramas.aC());
        this.ml.d(paramas.aD());
      }
      return;
    }
    catch (RemoteException paramas)
    {
      dw.c("Failed to load ad.", paramas);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.lF;
  }
  
  public String getAdUnitId()
  {
    return this.lX;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.lV;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.mp;
  }
  
  public boolean isLoaded()
  {
    try
    {
      if (this.mn == null) {
        return false;
      }
      boolean bool = this.mn.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      dw.c("Failed to check if ad is ready.", localRemoteException);
    }
    return false;
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.lF = paramAdListener;
      ap localap;
      if (this.mn != null)
      {
        localap = this.mn;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAdListener = new af(paramAdListener);; paramAdListener = null)
      {
        localap.a(paramAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      dw.c("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.lX != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }
    this.lX = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.lV = paramAppEventListener;
      ap localap;
      if (this.mn != null)
      {
        localap = this.mn;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new am(paramAppEventListener);; paramAppEventListener = null)
      {
        localap.a(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      dw.c("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    try
    {
      this.mp = paramInAppPurchaseListener;
      ap localap;
      if (this.mn != null)
      {
        localap = this.mn;
        if (paramInAppPurchaseListener == null) {
          break label38;
        }
      }
      label38:
      for (paramInAppPurchaseListener = new cp(paramInAppPurchaseListener);; paramInAppPurchaseListener = null)
      {
        localap.a(paramInAppPurchaseListener);
        return;
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      dw.c("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
  
  public void show()
  {
    try
    {
      l("show");
      this.mn.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      dw.c("Failed to show interstitial.", localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */