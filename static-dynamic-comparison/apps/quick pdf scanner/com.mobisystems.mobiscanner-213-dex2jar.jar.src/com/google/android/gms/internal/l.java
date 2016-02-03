package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public final class l
{
  private com.google.android.gms.ads.doubleclick.a xc;
  private com.google.android.gms.ads.c[] xd;
  private String xe;
  private final ah xr = new ah();
  private com.google.android.gms.ads.a xs;
  private g xt;
  private ViewGroup xu;
  
  public l(ViewGroup paramViewGroup)
  {
    this.xu = paramViewGroup;
  }
  
  public l(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this.xu = paramViewGroup;
    Context localContext = paramViewGroup.getContext();
    try
    {
      paramAttributeSet = new e(localContext, paramAttributeSet);
      this.xd = paramAttributeSet.v(paramBoolean);
      this.xe = paramAttributeSet.oL();
      if (paramViewGroup.isInEditMode()) {
        cb.a(paramViewGroup, new ab(localContext, this.xd[0]), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      cb.a(paramViewGroup, new ab(localContext, com.google.android.gms.ads.c.lF), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
    }
  }
  
  private void oZ()
  {
    try
    {
      com.google.android.gms.dynamic.c localc = this.xt.oM();
      if (localc == null) {
        return;
      }
      this.xu.addView((View)com.google.android.gms.dynamic.d.a(localc));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  private void pa()
  {
    if (((this.xd == null) || (this.xe == null)) && (this.xt == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    Context localContext = this.xu.getContext();
    this.xt = ha.a(localContext, new ab(localContext, this.xd), this.xe, this.xr);
    if (this.xs != null) {
      this.xt.a(new gx(this.xs));
    }
    if (this.xc != null) {
      this.xt.a(new d(this.xc));
    }
    oZ();
  }
  
  public void L(String paramString)
  {
    if (this.xe != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }
    this.xe = paramString;
  }
  
  public void a(com.google.android.gms.ads.a parama)
  {
    try
    {
      this.xs = parama;
      g localg;
      if (this.xt != null)
      {
        localg = this.xt;
        if (parama == null) {
          break label38;
        }
      }
      label38:
      for (parama = new gx(parama);; parama = null)
      {
        localg.a(parama);
        return;
      }
      return;
    }
    catch (RemoteException parama)
    {
      ce.c("Failed to set the AdListener.", parama);
    }
  }
  
  public void a(k paramk)
  {
    try
    {
      if (this.xt == null) {
        pa();
      }
      if (this.xt.a(new z(this.xu.getContext(), paramk))) {
        this.xr.r(paramk.oX());
      }
      return;
    }
    catch (RemoteException paramk)
    {
      ce.c("Failed to load ad.", paramk);
    }
  }
  
  public void a(com.google.android.gms.ads.c... paramVarArgs)
  {
    if (this.xd != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    b(paramVarArgs);
  }
  
  public void b(com.google.android.gms.ads.c... paramVarArgs)
  {
    this.xd = paramVarArgs;
    try
    {
      if (this.xt != null) {
        this.xt.a(new ab(this.xu.getContext(), this.xd));
      }
      this.xu.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        ce.c("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.xt != null) {
        this.xt.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public com.google.android.gms.ads.c ku()
  {
    try
    {
      if (this.xt != null)
      {
        com.google.android.gms.ads.c localc = this.xt.oO().oK();
        return localc;
      }
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Failed to get the current AdSize.", localRemoteException);
      if (this.xd != null) {
        return this.xd[0];
      }
    }
    return null;
  }
  
  public void pause()
  {
    try
    {
      if (this.xt != null) {
        this.xt.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Failed to call pause.", localRemoteException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.xt != null) {
        this.xt.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ce.c("Failed to call resume.", localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */