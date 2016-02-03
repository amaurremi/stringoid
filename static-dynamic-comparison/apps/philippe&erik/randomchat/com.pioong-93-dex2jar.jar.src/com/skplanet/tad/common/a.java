package com.skplanet.tad.common;

import android.util.Log;

public class a
{
  private static int a = 1;
  
  public static void a(int paramInt)
  {
    a = paramInt;
  }
  
  public static void a(String paramString)
  {
    if ((a & 0x1) > 0) {
      Log.i("T ad SDK", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((a & 0x8) > 0) {
      Log.v("T ad SDK", "[API]" + paramString1 + "() called. " + paramString2);
    }
  }
  
  public static void b(String paramString)
  {
    if ((a & 0x2) > 0) {
      Log.e("T ad SDK", paramString, null);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((a & 0x10) > 0) {
      Log.d("T ad SDK Debug", "[" + paramString1 + "]" + paramString2);
    }
  }
  
  public static void c(String paramString)
  {
    if ((a & 0x4) > 0) {
      Log.d("T ad SDK Debug", paramString);
    }
  }
  
  public static void d(String paramString)
  {
    if ((a & 0x20) > 0) {
      Log.w("T ad SDK Debug", paramString);
    }
  }
  
  public static void e(String paramString)
  {
    if ((a & 0x40) > 0) {
      Log.d("T ad SDK Debug", paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/common/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */