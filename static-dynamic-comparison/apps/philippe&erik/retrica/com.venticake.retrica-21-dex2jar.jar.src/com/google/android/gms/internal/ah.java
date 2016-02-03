package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class ah
  extends g<ar>
{
  private static final ah lR = new ah();
  
  private ah()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public static aq a(Context paramContext, al paramal, String paramString, bs parambs)
  {
    Object localObject;
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0)
    {
      aq localaq = lR.b(paramContext, paramal, paramString, parambs);
      localObject = localaq;
      if (localaq != null) {}
    }
    else
    {
      eu.z("Using AdManager from the client jar.");
      localObject = new u(paramContext, paramal, paramString, parambs, new ev(5089000, 5089000, true));
    }
    return (aq)localObject;
  }
  
  private aq b(Context paramContext, al paramal, String paramString, bs parambs)
  {
    try
    {
      d locald = e.h(paramContext);
      paramContext = aq.a.f(((ar)G(paramContext)).a(locald, paramal, paramString, parambs, 5089000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      eu.c("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (g.a paramContext)
    {
      eu.c("Could not create remote AdManager.", paramContext);
    }
    return null;
  }
  
  protected ar c(IBinder paramIBinder)
  {
    return ar.a.g(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */