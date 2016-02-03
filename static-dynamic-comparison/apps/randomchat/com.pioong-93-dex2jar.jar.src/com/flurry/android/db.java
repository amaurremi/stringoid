package com.flurry.android;

import android.text.TextUtils;
import android.util.Log;

final class db
{
  private static int fg = 4000;
  private static boolean fh = false;
  private static int fi = 5;
  
  private static void a(int paramInt, String paramString1, String paramString2)
  {
    if ((!fh) && (fi <= paramInt))
    {
      int i;
      int k;
      if (TextUtils.isEmpty(paramString2))
      {
        i = 0;
        k = 0;
        label25:
        if (k >= i) {
          return;
        }
        if (fg <= i - k) {
          break label75;
        }
      }
      label75:
      for (int j = i;; j = fg + k)
      {
        if (Log.println(paramInt, paramString1, paramString2.substring(k, j)) <= 0) {
          return;
        }
        k = j;
        break label25;
        i = paramString2.length();
        break;
      }
    }
  }
  
  static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    new StringBuilder().append(paramString2).append('\n').append(Log.getStackTraceString(paramThrowable)).toString();
  }
  
  static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    b(3, paramString1, paramString2, paramThrowable);
  }
  
  static void aw()
  {
    fh = true;
  }
  
  static void ax()
  {
    fh = false;
  }
  
  private static void b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(paramInt, paramString1, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    b(6, paramString1, paramString2, paramThrowable);
  }
  
  static void c(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2);
  }
  
  static void d(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
  
  static void e(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  static void f(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
  
  static void g(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  static void setLogLevel(int paramInt)
  {
    fi = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */