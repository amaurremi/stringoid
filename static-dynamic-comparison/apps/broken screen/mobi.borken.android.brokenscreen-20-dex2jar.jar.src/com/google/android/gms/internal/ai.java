package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class ai
  extends g<as>
{
  private static final ai lP = new ai();
  
  private ai()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public static ar a(Context paramContext, am paramam, String paramString, bt parambt)
  {
    Object localObject;
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0)
    {
      ar localar = lP.b(paramContext, paramam, paramString, parambt);
      localObject = localar;
      if (localar != null) {}
    }
    else
    {
      ev.z("Using AdManager from the client jar.");
      localObject = new v(paramContext, paramam, paramString, parambt, new ew(5077000, 5077000, true));
    }
    return (ar)localObject;
  }
  
  private ar b(Context paramContext, am paramam, String paramString, bt parambt)
  {
    try
    {
      d locald = e.h(paramContext);
      paramContext = ar.a.f(((as)D(paramContext)).a(locald, paramam, paramString, parambt, 5077000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      ev.c("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (g.a paramContext)
    {
      ev.c("Could not create remote AdManager.", paramContext);
    }
    return null;
  }
  
  protected as c(IBinder paramIBinder)
  {
    return as.a.g(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */