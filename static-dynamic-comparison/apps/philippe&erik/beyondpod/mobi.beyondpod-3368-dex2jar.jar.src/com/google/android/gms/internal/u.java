package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.e.a;

public final class u
  extends e<ad>
{
  private static final u ew = new u();
  
  private u()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public static ac a(Context paramContext, x paramx, String paramString, ba paramba)
  {
    Object localObject;
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0)
    {
      ac localac = ew.b(paramContext, paramx, paramString, paramba);
      localObject = localac;
      if (localac != null) {}
    }
    else
    {
      ct.r("Using AdManager from the client jar.");
      localObject = new r(paramContext, paramx, paramString, paramba, new cu(4242000, 4242000, true));
    }
    return (ac)localObject;
  }
  
  private ac b(Context paramContext, x paramx, String paramString, ba paramba)
  {
    try
    {
      b localb = c.h(paramContext);
      paramContext = ac.a.f(((ad)t(paramContext)).a(localb, paramx, paramString, paramba, 4242000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      ct.b("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (e.a paramContext)
    {
      ct.b("Could not create remote AdManager.", paramContext);
    }
    return null;
  }
  
  protected ad c(IBinder paramIBinder)
  {
    return ad.a.g(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */