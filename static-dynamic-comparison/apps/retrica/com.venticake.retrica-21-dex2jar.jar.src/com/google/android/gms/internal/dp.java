package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class dp
{
  public static em a(Context paramContext, ds paramds, dp.a parama)
  {
    if (paramds.kQ.sz) {
      return b(paramContext, paramds, parama);
    }
    return c(paramContext, paramds, parama);
  }
  
  private static em b(Context paramContext, ds paramds, dp.a parama)
  {
    eu.z("Fetching ad response from local ad request service.");
    paramContext = new dq.a(paramContext, paramds, parama);
    paramContext.start();
    return paramContext;
  }
  
  private static em c(Context paramContext, ds paramds, dp.a parama)
  {
    eu.z("Fetching ad response from remote ad request service.");
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0)
    {
      eu.D("Failed to connect to remote ad request service.");
      return null;
    }
    return new dq.b(paramContext, paramds, parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */