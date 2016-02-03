package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.e.a;

public final class eh
  extends e<ed>
{
  private static final eh pP = new eh();
  
  private eh()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View d(Context paramContext, int paramInt1, int paramInt2)
    throws e.a
  {
    return pP.e(paramContext, paramInt1, paramInt2);
  }
  
  private View e(Context paramContext, int paramInt1, int paramInt2)
    throws e.a
  {
    try
    {
      b localb = c.h(paramContext);
      paramContext = (View)c.b(((ed)t(paramContext)).a(localb, paramInt1, paramInt2));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new e.a("Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
    }
  }
  
  public ed A(IBinder paramIBinder)
  {
    return ed.a.z(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */