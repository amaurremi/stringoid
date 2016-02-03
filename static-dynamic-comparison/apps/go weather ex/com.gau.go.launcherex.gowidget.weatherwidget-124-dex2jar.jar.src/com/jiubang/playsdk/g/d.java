package com.jiubang.playsdk.g;

import android.util.Log;

public class d
{
  private static boolean a = false;
  
  public static int a(String paramString1, String paramString2)
  {
    if (a) {
      return Log.d(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      return Log.d(paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    if (a) {
      return Log.i(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      return Log.e(paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */