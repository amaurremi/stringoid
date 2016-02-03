package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

public final class av
{
  private AdListener lO;
  private PlayStorePurchaseListener mA;
  private AppEventListener mf;
  private AdSize[] mg;
  private String mh;
  private final bt mu = new bt();
  private final al mv;
  private ar mw;
  private String mx;
  private ViewGroup my;
  private InAppPurchaseListener mz;
  
  public av(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, al.aA());
  }
  
  public av(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, al.aA());
  }
  
  av(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, al paramal)
  {
    this.my = paramViewGroup;
    this.mv = paramal;
    if (paramAttributeSet != null) {
      paramal = paramViewGroup.getContext();
    }
    try
    {
      paramAttributeSet = new ap(paramal, paramAttributeSet);
      this.mg = paramAttributeSet.f(paramBoolean);
      this.mh = paramAttributeSet.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        eu.a(paramViewGroup, new am(paramal, this.mg[0]), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      eu.a(paramViewGroup, new am(paramal, AdSize.BANNER), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
    }
  }
  
  private void aG()
  {
    try
    {
      d locald = this.mw.P();
      if (locald == null) {
        return;
      }
      this.my.addView((View)e.e(locald));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  private void aH()
    throws RemoteException
  {
    if (((this.mg == null) || (this.mh == null)) && (this.mw == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    Context localContext = this.my.getContext();
    this.mw = ai.a(localContext, new am(localContext, this.mg), this.mh, this.mu);
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
    aG();
  }
  
  public void a(au paramau)
  {
    try
    {
      if (this.mw == null) {
        aH();
      }
      if (this.mw.a(this.mv.a(this.my.getContext(), paramau))) {
        this.mu.c(paramau.aD());
      }
      return;
    }
    catch (RemoteException paramau)
    {
      ev.c("Failed to load ad.", paramau);
    }
  }
  
  public void a(AdSize... paramVarArgs)
  {
    this.mg = paramVarArgs;
    try
    {
      if (this.mw != null) {
        this.mw.a(new am(this.my.getContext(), this.mg));
      }
      this.my.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        ev.c("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.mw != null) {
        this.mw.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.lO;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (this.mw != null)
      {
        AdSize localAdSize = this.mw.Q().aB();
        return localAdSize;
      }
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to get the current AdSize.", localRemoteException);
      if (this.mg != null) {
        return this.mg[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return this.mg;
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
  
  public void pause()
  {
    try
    {
      if (this.mw != null) {
        this.mw.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to call pause.", localRemoteException);
    }
  }
  
  public void recordManualImpression()
  {
    try
    {
      this.mw.ab();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to record impression.", localRemoteException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.mw != null) {
        this.mw.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to call resume.", localRemoteException);
    }
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
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (this.mg != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    a(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.mh != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
          break label56;
        }
      }
      label56:
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
    if (this.mz != null) {
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
    }
    try
    {
      this.mA = paramPlayStorePurchaseListener;
      this.mx = paramString;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramPlayStorePurchaseListener == null) {
          break label62;
        }
      }
      label62:
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */