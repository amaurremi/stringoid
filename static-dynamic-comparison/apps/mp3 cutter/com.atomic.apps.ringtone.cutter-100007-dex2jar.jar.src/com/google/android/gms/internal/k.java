package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.atomic.apps.ringtone.cutter.aa;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;

public final class k
  extends e
{
  private static final k a = new k();
  
  private k()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public static r a(Context paramContext, ak paramak, String paramString, ag paramag)
  {
    Object localObject;
    if (com.google.android.gms.common.f.a(paramContext) == 0)
    {
      r localr = a.b(paramContext, paramak, paramString, paramag);
      localObject = localr;
      if (localr != null) {}
    }
    else
    {
      aa.a("Using AdManager from the client jar.");
      localObject = new dv(paramContext, paramak, paramString, paramag, new dx(4452000, 4452000, true));
    }
    return (r)localObject;
  }
  
  private r b(Context paramContext, ak paramak, String paramString, ag paramag)
  {
    try
    {
      a locala = d.a(paramContext);
      paramContext = s.a(((u)a(paramContext)).a(locala, paramak, paramString, paramag, 4452000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      aa.b("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (com.google.android.gms.a.f paramContext)
    {
      aa.b("Could not create remote AdManager.", paramContext);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */