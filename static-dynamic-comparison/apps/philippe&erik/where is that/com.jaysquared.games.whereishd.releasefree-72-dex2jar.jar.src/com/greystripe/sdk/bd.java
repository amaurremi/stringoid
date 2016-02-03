package com.greystripe.sdk;

import android.util.Log;
import android.webkit.JavascriptInterface;

final class bd
{
  private static be a;
  
  static be a()
  {
    if (a == null) {
      a = new be((byte)0);
    }
    return new be((byte)0);
  }
  
  private static void a(int paramInt, String paramString, Object... paramVarArgs)
  {
    if (paramString != null)
    {
      i = paramInt;
      str = paramString;
      if (paramVarArgs.length <= 0) {}
    }
    try
    {
      str = String.format(paramString, paramVarArgs);
      i = paramInt;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        str = String.format("Error formatting log message (level=%d): %s", new Object[] { Integer.valueOf(paramInt), paramString });
        i = 6;
      }
    }
    Log.println(i, "Greystripe", str);
  }
  
  static void a(String paramString, Object... paramVarArgs)
  {
    if (c() <= 2) {
      a(2, paramString, paramVarArgs);
    }
  }
  
  static void b(String paramString, Object... paramVarArgs)
  {
    if (c() <= 3) {
      a(3, paramString, paramVarArgs);
    }
  }
  
  static boolean b()
  {
    return 3 >= c();
  }
  
  private static int c()
  {
    int i = 4;
    try
    {
      if (bj.a(bk.LOG_LEVEL) != null) {
        i = Integer.parseInt(bj.a(bk.LOG_LEVEL));
      }
      return i;
    }
    catch (Exception localException) {}
    return 4;
  }
  
  static void c(String paramString, Object... paramVarArgs)
  {
    if (c() <= 4) {
      a(4, paramString, paramVarArgs);
    }
  }
  
  static void d(String paramString, Object... paramVarArgs)
  {
    if (c() <= 5) {
      a(5, paramString, paramVarArgs);
    }
  }
  
  @JavascriptInterface
  static void e(String paramString, Object... paramVarArgs)
  {
    if (c() <= 6) {
      a(6, paramString, paramVarArgs);
    }
  }
  
  static void f(String paramString, Object... paramVarArgs)
  {
    if (c() <= 7) {
      a(7, paramString, paramVarArgs);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */