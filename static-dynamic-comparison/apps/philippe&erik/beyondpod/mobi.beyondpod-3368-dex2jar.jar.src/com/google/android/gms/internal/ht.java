package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.plus.PlusOneDummyView;

public final class ht
{
  private static Context Ci;
  private static hp DQ;
  
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
    paramString = (View)c.b(x(paramContext).a(c.h(paramContext), paramInt1, paramInt2, paramString, paramInt3));
    return paramString;
  }
  
  public static View a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      try
      {
        throw new NullPointerException();
      }
      catch (Exception paramString1)
      {
        return new PlusOneDummyView(paramContext, paramInt1);
      }
    }
    paramString1 = (View)c.b(x(paramContext).a(c.h(paramContext), paramInt1, paramInt2, paramString1, paramString2));
    return paramString1;
  }
  
  private static hp x(Context paramContext)
    throws ht.a
  {
    eg.f(paramContext);
    if (DQ == null)
    {
      if (Ci == null)
      {
        Ci = GooglePlayServicesUtil.getRemoteContext(paramContext);
        if (Ci == null) {
          throw new a("Could not get remote context.");
        }
      }
      paramContext = Ci.getClassLoader();
    }
    try
    {
      DQ = hp.a.av((IBinder)paramContext.loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
      return DQ;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new a("Could not load creator class.");
    }
    catch (InstantiationException paramContext)
    {
      throw new a("Could not instantiate creator.");
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a("Could not access creator.");
    }
  }
  
  public static class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */