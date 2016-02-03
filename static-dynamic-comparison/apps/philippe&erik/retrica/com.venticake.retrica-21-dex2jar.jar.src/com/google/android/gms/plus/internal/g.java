package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.hm;
import com.google.android.gms.plus.PlusOneDummyView;

public final class g
{
  private static Context aaj;
  private static c abS;
  
  private static c K(Context paramContext)
  {
    hm.f(paramContext);
    if (abS == null)
    {
      if (aaj == null)
      {
        aaj = GooglePlayServicesUtil.getRemoteContext(paramContext);
        if (aaj == null) {
          throw new g.a("Could not get remote context.");
        }
      }
      paramContext = aaj.getClassLoader();
    }
    try
    {
      abS = c.a.bl((IBinder)paramContext.loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
      return abS;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new g.a("Could not load creator class.");
    }
    catch (InstantiationException paramContext)
    {
      throw new g.a("Could not instantiate creator.");
    }
    catch (IllegalAccessException paramContext)
    {
      throw new g.a("Could not access creator.");
    }
  }
  
  public static View a(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (paramString == null) {
      try
      {
        throw new NullPointerException();
      }
      catch (Exception paramString)
      {
        return new PlusOneDummyView(paramContext, paramInt1);
      }
    }
    paramString = (View)e.e(K(paramContext).a(e.h(paramContext), paramInt1, paramInt2, paramString, paramInt3));
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */