package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;

public final class ag
{
  private AppEventListener eI;
  private AdSize[] eJ;
  private String eK;
  private final ba eW = new ba();
  private ac eX;
  private ViewGroup eY;
  private AdListener ev;
  
  public ag(ViewGroup paramViewGroup)
  {
    this.eY = paramViewGroup;
  }
  
  public ag(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this.eY = paramViewGroup;
    Context localContext = paramViewGroup.getContext();
    try
    {
      paramAttributeSet = new aa(localContext, paramAttributeSet);
      this.eJ = paramAttributeSet.c(paramBoolean);
      this.eK = paramAttributeSet.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        cs.a(paramViewGroup, new x(localContext, this.eJ[0]), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      cs.a(paramViewGroup, new x(localContext, AdSize.BANNER), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
    }
  }
  
  private void T()
  {
    try
    {
      b localb = this.eX.x();
      if (localb == null) {
        return;
      }
      this.eY.addView((View)c.b(localb));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  private void U()
    throws RemoteException
  {
    if (((this.eJ == null) || (this.eK == null)) && (this.eX == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    Context localContext = this.eY.getContext();
    this.eX = u.a(localContext, new x(localContext, this.eJ), this.eK, this.eW);
    if (this.ev != null) {
      this.eX.a(new t(this.ev));
    }
    if (this.eI != null) {
      this.eX.a(new z(this.eI));
    }
    T();
  }
  
  public void a(af paramaf)
  {
    try
    {
      if (this.eX == null) {
        U();
      }
      if (this.eX.a(new v(this.eY.getContext(), paramaf))) {
        this.eW.c(paramaf.R());
      }
      return;
    }
    catch (RemoteException paramaf)
    {
      ct.b("Failed to load ad.", paramaf);
    }
  }
  
  public void a(AdSize... paramVarArgs)
  {
    this.eJ = paramVarArgs;
    try
    {
      if (this.eX != null) {
        this.eX.a(new x(this.eY.getContext(), this.eJ));
      }
      this.eY.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        ct.b("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.eX != null) {
        this.eX.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.ev;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (this.eX != null)
      {
        AdSize localAdSize = this.eX.y().P();
        return localAdSize;
      }
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Failed to get the current AdSize.", localRemoteException);
      if (this.eJ != null) {
        return this.eJ[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return this.eJ;
  }
  
  public String getAdUnitId()
  {
    return this.eK;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.eI;
  }
  
  public void pause()
  {
    try
    {
      if (this.eX != null) {
        this.eX.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Failed to call pause.", localRemoteException);
    }
  }
  
  public void recordManualImpression()
  {
    try
    {
      this.eX.H();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Failed to record impression.", localRemoteException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.eX != null) {
        this.eX.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ct.b("Failed to call resume.", localRemoteException);
    }
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
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (this.eJ != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    a(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.eK != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */