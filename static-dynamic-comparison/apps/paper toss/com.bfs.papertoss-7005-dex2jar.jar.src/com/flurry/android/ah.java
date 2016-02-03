package com.flurry.android;

import android.util.Log;

final class ah
{
  private static boolean a = false;
  private static int b = 5;
  
  static int a(String paramString1, String paramString2)
  {
    if ((a) || (b <= 3)) {
      return 0;
    }
    return Log.d(paramString1, paramString2);
  }
  
  static int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((a) || (b <= 3)) {
      return 0;
    }
    return Log.d(paramString1, paramString2, paramThrowable);
  }
  
  static void a()
  {
    a = true;
  }
  
  static void a(int paramInt)
  {
    b = paramInt;
  }
  
  static boolean a(String paramString)
  {
    return Log.isLoggable(paramString, 3);
  }
  
  static int b(String paramString1, String paramString2)
  {
    if ((a) || (b <= 6)) {
      return 0;
    }
    return Log.e(paramString1, paramString2);
  }
  
  static int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((a) || (b <= 6)) {
      return 0;
    }
    return Log.e(paramString1, paramString2, paramThrowable);
  }
  
  static void b()
  {
    a = false;
  }
  
  static int c(String paramString1, String paramString2)
  {
    if ((a) || (b <= 4)) {
      return 0;
    }
    return Log.i(paramString1, paramString2);
  }
  
  static int c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((a) || (b <= 4)) {
      return 0;
    }
    return Log.i(paramString1, paramString2, paramThrowable);
  }
  
  static int d(String paramString1, String paramString2)
  {
    if ((a) || (b <= 5)) {
      return 0;
    }
    return Log.w(paramString1, paramString2);
  }
  
  static int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((a) || (b <= 5)) {
      return 0;
    }
    return Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */