package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class o
  extends g<l>
{
  private static final o Ma = new o();
  
  private o()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View b(Context paramContext, int paramInt1, int paramInt2)
    throws g.a
  {
    return Ma.c(paramContext, paramInt1, paramInt2);
  }
  
  private View c(Context paramContext, int paramInt1, int paramInt2)
    throws g.a
  {
    try
    {
      d locald = e.k(paramContext);
      paramContext = (View)e.f(((l)L(paramContext)).a(locald, paramInt1, paramInt2));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new g.a("Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
    }
  }
  
  public l S(IBinder paramIBinder)
  {
    return l.a.R(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */