package com.google.android.gms.internal;

import android.util.Log;

public final class ev
{
  public static void A(String paramString)
  {
    if (p(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void B(String paramString)
  {
    if (p(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void C(String paramString)
  {
    if (p(2)) {
      Log.v("Ads", paramString);
    }
  }
  
  public static void D(String paramString)
  {
    if (p(5)) {
      Log.w("Ads", paramString);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (p(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (p(6)) {
      Log.e("Ads", paramString, paramThrowable);
    }
  }
  
  public static void c(String paramString, Throwable paramThrowable)
  {
    if (p(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean p(int paramInt)
  {
    return ((paramInt >= 5) || (Log.isLoggable("Ads", paramInt))) && (paramInt != 2);
  }
  
  public static void z(String paramString)
  {
    if (p(3)) {
      Log.d("Ads", paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */