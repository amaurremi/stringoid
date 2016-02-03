package com.flurry.android;

import android.util.Log;

public class Flog
{
  public static final int ASSERT = 7;
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  private static boolean a = false;
  
  static int a(String paramString1, String paramString2)
  {
    if (a) {
      return 0;
    }
    return Log.d(paramString1, paramString2);
  }
  
  static int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      return 0;
    }
    return Log.d(paramString1, paramString2, paramThrowable);
  }
  
  static boolean a(String paramString)
  {
    return Log.isLoggable(paramString, 3);
  }
  
  static int b(String paramString1, String paramString2)
  {
    if (a) {
      return 0;
    }
    return Log.e(paramString1, paramString2);
  }
  
  static int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      return 0;
    }
    return Log.e(paramString1, paramString2, paramThrowable);
  }
  
  static int c(String paramString1, String paramString2)
  {
    if (a) {
      return 0;
    }
    return Log.w(paramString1, paramString2);
  }
  
  public static void disableLog()
  {
    a = true;
  }
  
  public static void enableLog()
  {
    a = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/flurry/android/Flog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */