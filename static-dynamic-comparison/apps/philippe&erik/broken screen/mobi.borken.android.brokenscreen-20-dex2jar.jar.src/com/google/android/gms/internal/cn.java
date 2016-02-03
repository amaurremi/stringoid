package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class cn
  extends g<cp>
{
  private static final cn oQ = new cn();
  
  private cn()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static co a(Activity paramActivity)
  {
    try
    {
      if (b(paramActivity))
      {
        ev.z("Using AdOverlay from the client jar.");
        return new cg(paramActivity);
      }
      paramActivity = oQ.c(paramActivity);
      return paramActivity;
    }
    catch (a paramActivity)
    {
      ev.D(paramActivity.getMessage());
    }
    return null;
  }
  
  private static boolean b(Activity paramActivity)
    throws cn.a
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
      throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }
    return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
  }
  
  private co c(Activity paramActivity)
  {
    try
    {
      d locald = e.h(paramActivity);
      paramActivity = co.a.m(((cp)D(paramActivity)).a(locald));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      ev.c("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (g.a paramActivity)
    {
      ev.c("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
  
  protected cp l(IBinder paramIBinder)
  {
    return cp.a.n(paramIBinder);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */