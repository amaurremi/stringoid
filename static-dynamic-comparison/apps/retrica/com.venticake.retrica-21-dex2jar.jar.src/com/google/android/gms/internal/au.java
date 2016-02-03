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

public final class au
{
  private AdListener lQ;
  private ViewGroup mA;
  private InAppPurchaseListener mB;
  private PlayStorePurchaseListener mC;
  private AppEventListener mh;
  private AdSize[] mi;
  private String mj;
  private final bs mw = new bs();
  private final ak mx;
  private aq my;
  private String mz;
  
  public au(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, ak.aF());
  }
  
  public au(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, ak.aF());
  }
  
  au(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, ak paramak)
  {
    this.mA = paramViewGroup;
    this.mx = paramak;
    if (paramAttributeSet != null) {
      paramak = paramViewGroup.getContext();
    }
    try
    {
      paramAttributeSet = new ao(paramak, paramAttributeSet);
      this.mi = paramAttributeSet.f(paramBoolean);
      this.mj = paramAttributeSet.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        et.a(paramViewGroup, new al(paramak, this.mi[0]), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      et.a(paramViewGroup, new al(paramak, AdSize.BANNER), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
    }
  }
  
  private void aL()
  {
    try
    {
      d locald = this.my.U();
      if (locald == null) {
        return;
      }
      this.mA.addView((View)e.e(locald));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  private void aM()
  {
    if (((this.mi == null) || (this.mj == null)) && (this.my == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    Context localContext = this.mA.getContext();
    this.my = ah.a(localContext, new al(localContext, this.mi), this.mj, this.mw);
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
    aL();
  }
  
  public void a(at paramat)
  {
    try
    {
      if (this.my == null) {
        aM();
      }
      if (this.my.a(this.mx.a(this.mA.getContext(), paramat))) {
        this.mw.c(paramat.aI());
      }
      return;
    }
    catch (RemoteException paramat)
    {
      eu.c("Failed to load ad.", paramat);
    }
  }
  
  public void a(AdSize... paramVarArgs)
  {
    this.mi = paramVarArgs;
    try
    {
      if (this.my != null) {
        this.my.a(new al(this.mA.getContext(), this.mi));
      }
      this.mA.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        eu.c("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.my != null) {
        this.my.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.lQ;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (this.my != null)
      {
        AdSize localAdSize = this.my.V().aG();
        return localAdSize;
      }
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Failed to get the current AdSize.", localRemoteException);
      if (this.mi != null) {
        return this.mi[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return this.mi;
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
  
  public void pause()
  {
    try
    {
      if (this.my != null) {
        this.my.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Failed to call pause.", localRemoteException);
    }
  }
  
  public void recordManualImpression()
  {
    try
    {
      this.my.ag();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Failed to record impression.", localRemoteException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.my != null) {
        this.my.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Failed to call resume.", localRemoteException);
    }
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
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (this.mi != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    a(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.mj != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
          break label56;
        }
      }
      label56:
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
    if (this.mB != null) {
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
    }
    try
    {
      this.mC = paramPlayStorePurchaseListener;
      this.mz = paramString;
      aq localaq;
      if (this.my != null)
      {
        localaq = this.my;
        if (paramPlayStorePurchaseListener == null) {
          break label62;
        }
      }
      label62:
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */