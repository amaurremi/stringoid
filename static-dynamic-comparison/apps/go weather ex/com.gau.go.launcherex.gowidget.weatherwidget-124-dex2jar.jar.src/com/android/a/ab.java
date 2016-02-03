package com.android.a;

import android.util.Log;
import java.util.Locale;

public class ab
{
  public static String a = "Volley";
  public static boolean b = Log.isLoggable(a, 2);
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (b) {
      Log.v(a, e(paramString, paramVarArgs));
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.e(a, e(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    Log.d(a, e(paramString, paramVarArgs));
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    Log.e(a, e(paramString, paramVarArgs));
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    Log.wtf(a, e(paramString, paramVarArgs));
  }
  
  private static String e(String paramString, Object... paramVarArgs)
  {
    int i;
    if (paramVarArgs == null)
    {
      paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
    }
    for (;;)
    {
      if (i >= paramVarArgs.length) {}
      String str;
      for (paramVarArgs = "<unknown>";; paramVarArgs = str.substring(str.lastIndexOf('$') + 1) + "." + paramVarArgs[i].getMethodName())
      {
        return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
        paramString = String.format(Locale.US, paramString, paramVarArgs);
        break;
        if (paramVarArgs[i].getClass().equals(ab.class)) {
          break label151;
        }
        str = paramVarArgs[i].getClassName();
        str = str.substring(str.lastIndexOf('.') + 1);
      }
      label151:
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */