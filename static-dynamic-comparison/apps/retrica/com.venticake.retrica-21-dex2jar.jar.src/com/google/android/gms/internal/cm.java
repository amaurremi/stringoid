package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class cm
  extends g<co>
{
  private static final cm oS = new cm();
  
  private cm()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static cn a(Activity paramActivity)
  {
    try
    {
      if (b(paramActivity))
      {
        eu.z("Using AdOverlay from the client jar.");
        return new cf(paramActivity);
      }
      paramActivity = oS.c(paramActivity);
      return paramActivity;
    }
    catch (mn paramActivity)
    {
      eu.D(paramActivity.getMessage());
    }
    return null;
  }
  
  private static boolean b(Activity paramActivity)
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
      throw new mn("Ad overlay requires the useClientJar flag in intent extras.");
    }
    return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
  }
  
  private cn c(Activity paramActivity)
  {
    try
    {
      d locald = e.h(paramActivity);
      paramActivity = cn.a.m(((co)G(paramActivity)).a(locald));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      eu.c("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (g.a paramActivity)
    {
      eu.c("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
  
  protected co l(IBinder paramIBinder)
  {
    return co.a.n(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */