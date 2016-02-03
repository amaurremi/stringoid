package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.e.a;

public final class ha
  extends e<h>
{
  private static final ha TJ = new ha();
  
  private ha()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public static g a(Context paramContext, ab paramab, String paramString, ah paramah)
  {
    Object localObject;
    if (com.google.android.gms.common.d.w(paramContext) == 0)
    {
      g localg = TJ.b(paramContext, paramab, paramString, paramah);
      localObject = localg;
      if (localg != null) {}
    }
    else
    {
      ce.aG("Using AdManager from the client jar.");
      localObject = new gv(paramContext, paramab, paramString, paramah, new db(4323000, 4323000, true));
    }
    return (g)localObject;
  }
  
  private g b(Context paramContext, ab paramab, String paramString, ah paramah)
  {
    try
    {
      c localc = com.google.android.gms.dynamic.d.J(paramContext);
      paramContext = g.a.k(((h)B(paramContext)).a(localc, paramab, paramString, paramah, 4323000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      ce.c("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (e.a paramContext)
    {
      ce.c("Could not create remote AdManager.", paramContext);
    }
    return null;
  }
  
  protected h H(IBinder paramIBinder)
  {
    return h.a.l(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */