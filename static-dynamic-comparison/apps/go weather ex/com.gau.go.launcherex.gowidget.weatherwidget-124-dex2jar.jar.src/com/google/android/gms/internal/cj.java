package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class cj
  extends g<cl>
{
  private static final cj oC = new cj();
  
  private cj()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static ck a(Activity paramActivity)
  {
    try
    {
      if (b(paramActivity))
      {
        dw.v("Using AdOverlay from the client jar.");
        return new cc(paramActivity);
      }
      paramActivity = oC.c(paramActivity);
      return paramActivity;
    }
    catch (a paramActivity)
    {
      dw.z(paramActivity.getMessage());
    }
    return null;
  }
  
  private static boolean b(Activity paramActivity)
    throws cj.a
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
      throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }
    return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
  }
  
  private ck c(Activity paramActivity)
  {
    try
    {
      d locald = e.h(paramActivity);
      paramActivity = ck.a.m(((cl)z(paramActivity)).a(locald));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      dw.c("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (g.a paramActivity)
    {
      dw.c("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
  
  protected cl l(IBinder paramIBinder)
  {
    return cl.a.n(paramIBinder);
  }
  
  private static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */