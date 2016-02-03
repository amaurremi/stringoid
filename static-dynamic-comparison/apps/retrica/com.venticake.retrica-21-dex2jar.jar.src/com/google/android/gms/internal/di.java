package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class di
  extends g<de>
{
  private static final di pv = new di();
  
  private di()
  {
    super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
  }
  
  private static boolean b(Activity paramActivity)
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
      throw new mw("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }
    return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
  }
  
  public static dd d(Activity paramActivity)
  {
    try
    {
      if (b(paramActivity))
      {
        eu.z("Using AdOverlay from the client jar.");
        return new cu(paramActivity);
      }
      paramActivity = pv.e(paramActivity);
      return paramActivity;
    }
    catch (mw paramActivity)
    {
      eu.D(paramActivity.getMessage());
    }
    return null;
  }
  
  private dd e(Activity paramActivity)
  {
    try
    {
      d locald = e.h(paramActivity);
      paramActivity = dd.a.r(((de)G(paramActivity)).b(locald));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      eu.c("Could not create remote InAppPurchaseManager.", paramActivity);
      return null;
    }
    catch (g.a paramActivity)
    {
      eu.c("Could not create remote InAppPurchaseManager.", paramActivity);
    }
    return null;
  }
  
  protected de v(IBinder paramIBinder)
  {
    return de.a.s(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */