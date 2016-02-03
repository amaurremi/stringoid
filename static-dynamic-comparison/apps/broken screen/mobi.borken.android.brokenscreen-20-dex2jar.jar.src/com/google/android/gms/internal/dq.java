package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class dq
{
  public static en a(Context paramContext, dt paramdt, a parama)
  {
    if (paramdt.kO.sw) {
      return b(paramContext, paramdt, parama);
    }
    return c(paramContext, paramdt, parama);
  }
  
  private static en b(Context paramContext, dt paramdt, a parama)
  {
    ev.z("Fetching ad response from local ad request service.");
    paramContext = new dr.a(paramContext, paramdt, parama);
    paramContext.start();
    return paramContext;
  }
  
  private static en c(Context paramContext, dt paramdt, a parama)
  {
    ev.z("Fetching ad response from remote ad request service.");
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0)
    {
      ev.D("Failed to connect to remote ad request service.");
      return null;
    }
    return new dr.b(paramContext, paramdt, parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(dv paramdv);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */