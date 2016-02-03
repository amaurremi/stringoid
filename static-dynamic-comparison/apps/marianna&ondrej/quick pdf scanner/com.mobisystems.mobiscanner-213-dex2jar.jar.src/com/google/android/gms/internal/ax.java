package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.d;

public final class ax
{
  public static br a(Context paramContext, cd paramcd, a parama)
  {
    if (paramcd.CY.FN) {
      return b(paramContext, paramcd, parama);
    }
    return c(paramContext, paramcd, parama);
  }
  
  private static br b(Context paramContext, cd paramcd, a parama)
  {
    ce.aG("Fetching ad response from local ad request service.");
    paramContext = new ay.a(paramContext, paramcd, parama);
    paramContext.start();
    return paramContext;
  }
  
  private static br c(Context paramContext, cd paramcd, a parama)
  {
    ce.aG("Fetching ad response from remote ad request service.");
    if (d.w(paramContext) != 0)
    {
      ce.D("Failed to connect to remote ad request service.");
      return null;
    }
    return new ay.b(paramContext, paramcd, parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(cf paramcf);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */