package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.e.a;

public final class de
  extends e<cy>
{
  private static final de Hz = new de();
  
  private de()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View d(Context paramContext, int paramInt1, int paramInt2)
  {
    return Hz.e(paramContext, paramInt1, paramInt2);
  }
  
  private View e(Context paramContext, int paramInt1, int paramInt2)
  {
    try
    {
      c localc = d.J(paramContext);
      paramContext = (View)d.a(((cy)B(paramContext)).a(localc, paramInt1, paramInt2));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new e.a("Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
    }
  }
  
  public cy A(IBinder paramIBinder)
  {
    return cy.a.z(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */