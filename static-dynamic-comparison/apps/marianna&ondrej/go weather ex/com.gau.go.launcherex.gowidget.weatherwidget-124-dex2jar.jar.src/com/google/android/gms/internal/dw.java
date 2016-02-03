package com.google.android.gms.internal;

import android.util.Log;

public final class dw
{
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (n(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (n(6)) {
      Log.e("Ads", paramString, paramThrowable);
    }
  }
  
  public static void c(String paramString, Throwable paramThrowable)
  {
    if (n(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean n(int paramInt)
  {
    return ((paramInt >= 5) || (Log.isLoggable("Ads", paramInt))) && (paramInt != 2);
  }
  
  public static void v(String paramString)
  {
    if (n(3)) {
      Log.d("Ads", paramString);
    }
  }
  
  public static void w(String paramString)
  {
    if (n(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void x(String paramString)
  {
    if (n(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void y(String paramString)
  {
    if (n(2)) {
      Log.v("Ads", paramString);
    }
  }
  
  public static void z(String paramString)
  {
    if (n(5)) {
      Log.w("Ads", paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */