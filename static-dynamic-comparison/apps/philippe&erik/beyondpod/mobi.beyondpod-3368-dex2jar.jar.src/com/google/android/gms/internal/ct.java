package com.google.android.gms.internal;

import android.util.Log;

public final class ct
{
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (n(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (n(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean n(int paramInt)
  {
    return ((paramInt >= 5) || (Log.isLoggable("Ads", paramInt))) && (paramInt != 2);
  }
  
  public static void r(String paramString)
  {
    if (n(3)) {
      Log.d("Ads", paramString);
    }
  }
  
  public static void s(String paramString)
  {
    if (n(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void t(String paramString)
  {
    if (n(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void u(String paramString)
  {
    if (n(2)) {
      Log.v("Ads", paramString);
    }
  }
  
  public static void v(String paramString)
  {
    if (n(5)) {
      Log.w("Ads", paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */