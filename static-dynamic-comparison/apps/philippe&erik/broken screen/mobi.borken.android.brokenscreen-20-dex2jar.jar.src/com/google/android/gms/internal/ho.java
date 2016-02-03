package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class ho
  extends g<hk>
{
  private static final ho GI = new ho();
  
  private ho()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View b(Context paramContext, int paramInt1, int paramInt2)
    throws g.a
  {
    return GI.c(paramContext, paramInt1, paramInt2);
  }
  
  private View c(Context paramContext, int paramInt1, int paramInt2)
    throws g.a
  {
    try
    {
      d locald = e.h(paramContext);
      paramContext = (View)e.e(((hk)D(paramContext)).a(locald, paramInt1, paramInt2));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new g.a("Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
    }
  }
  
  public hk N(IBinder paramIBinder)
  {
    return hk.a.M(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */