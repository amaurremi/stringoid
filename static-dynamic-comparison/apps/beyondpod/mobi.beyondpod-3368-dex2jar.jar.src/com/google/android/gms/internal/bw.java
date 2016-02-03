package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class bw
{
  public static cm a(Context paramContext, bz parambz, a parama)
  {
    if (parambz.ej.iM) {
      return b(paramContext, parambz, parama);
    }
    return c(paramContext, parambz, parama);
  }
  
  private static cm b(Context paramContext, bz parambz, a parama)
  {
    ct.r("Fetching ad response from local ad request service.");
    paramContext = new bx.a(paramContext, parambz, parama);
    paramContext.start();
    return paramContext;
  }
  
  private static cm c(Context paramContext, bz parambz, a parama)
  {
    ct.r("Fetching ad response from remote ad request service.");
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0)
    {
      ct.v("Failed to connect to remote ad request service.");
      return null;
    }
    return new bx.b(paramContext, parambz, parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(cb paramcb);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */