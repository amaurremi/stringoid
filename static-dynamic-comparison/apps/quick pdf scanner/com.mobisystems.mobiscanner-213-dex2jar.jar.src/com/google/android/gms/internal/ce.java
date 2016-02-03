package com.google.android.gms.internal;

import android.util.Log;

public final class ce
{
  public static void C(String paramString)
  {
    if (cB(2)) {
      Log.v("Ads", paramString);
    }
  }
  
  public static void D(String paramString)
  {
    if (cB(5)) {
      Log.w("Ads", paramString);
    }
  }
  
  public static void Z(String paramString)
  {
    if (cB(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void aG(String paramString)
  {
    if (cB(3)) {
      Log.d("Ads", paramString);
    }
  }
  
  public static void aa(String paramString)
  {
    if (cB(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (cB(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static void c(String paramString, Throwable paramThrowable)
  {
    if (cB(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean cB(int paramInt)
  {
    return ((paramInt >= 5) || (Log.isLoggable("Ads", paramInt))) && (paramInt != 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */