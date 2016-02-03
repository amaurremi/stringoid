package com.google.android.gms.internal;

import android.os.Build.VERSION;

public final class bd
{
  public static boolean a()
  {
    return a(11);
  }
  
  private static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  public static boolean b()
  {
    return a(13);
  }
  
  public static boolean c()
  {
    return a(17);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */