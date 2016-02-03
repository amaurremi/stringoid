package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.internal.dc;
import com.google.android.gms.plus.PlusOneDummyView;

public final class g
{
  private static Context UJ;
  private static a Wg;
  
  private static a T(Context paramContext)
  {
    dc.N(paramContext);
    if (Wg == null)
    {
      if (UJ == null)
      {
        UJ = com.google.android.gms.common.d.z(paramContext);
        if (UJ == null) {
          throw new a("Could not get remote context.");
        }
      }
      paramContext = UJ.getClassLoader();
    }
    try
    {
      Wg = a.a.am((IBinder)paramContext.loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
      return Wg;
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
    paramString = (View)com.google.android.gms.dynamic.d.a(T(paramContext).a(com.google.android.gms.dynamic.d.J(paramContext), paramInt1, paramInt2, paramString, paramInt3));
    return paramString;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/plus/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */