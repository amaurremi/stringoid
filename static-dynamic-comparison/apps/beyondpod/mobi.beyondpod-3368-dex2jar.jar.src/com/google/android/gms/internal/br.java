package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.e.a;

public final class br
  extends e<bt>
{
  private static final br ha = new br();
  
  private br()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static bs a(Activity paramActivity)
  {
    try
    {
      if (b(paramActivity))
      {
        ct.r("Using AdOverlay from the client jar.");
        return new bk(paramActivity);
      }
      paramActivity = ha.c(paramActivity);
      return paramActivity;
    }
    catch (a paramActivity)
    {
      ct.v(paramActivity.getMessage());
    }
    return null;
  }
  
  private static boolean b(Activity paramActivity)
    throws br.a
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
      throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }
    return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
  }
  
  private bs c(Activity paramActivity)
  {
    try
    {
      b localb = c.h(paramActivity);
      paramActivity = bs.a.m(((bt)t(paramActivity)).a(localb));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      ct.b("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (e.a paramActivity)
    {
      ct.b("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
  
  protected bt l(IBinder paramIBinder)
  {
    return bt.a.n(paramIBinder);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */