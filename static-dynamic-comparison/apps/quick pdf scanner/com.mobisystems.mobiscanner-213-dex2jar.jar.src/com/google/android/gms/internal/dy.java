package com.google.android.gms.internal;

import android.os.Build.VERSION;

public final class dy
{
  private static boolean cQ(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  public static boolean qY()
  {
    return cQ(11);
  }
  
  public static boolean qZ()
  {
    return cQ(13);
  }
  
  public static boolean ra()
  {
    return cQ(17);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */