package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import android.util.Log;

public final class ja
{
  private static int a = 4000;
  private static boolean b = false;
  private static int c = 5;
  private static boolean d = false;
  
  public static void a()
  {
    b = true;
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    c(paramInt, paramString1, paramString2);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    c(paramInt, paramString1, paramString2, paramThrowable);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    b(3, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    b(3, paramString1, paramString2, paramThrowable);
  }
  
  public static void b()
  {
    b = false;
  }
  
  private static void b(int paramInt, String paramString1, String paramString2)
  {
    if ((!b) && (c <= paramInt)) {
      d(paramInt, paramString1, paramString2);
    }
  }
  
  private static void b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    b(paramInt, paramString1, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(6, paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    b(6, paramString1, paramString2, paramThrowable);
  }
  
  public static int c()
  {
    return c;
  }
  
  private static void c(int paramInt, String paramString1, String paramString2)
  {
    if (d) {
      d(paramInt, paramString1, paramString2);
    }
  }
  
  private static void c(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    c(paramInt, paramString1, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  public static void c(String paramString1, String paramString2)
  {
    b(4, paramString1, paramString2);
  }
  
  private static void d(int paramInt, String paramString1, String paramString2)
  {
    int i;
    if (TextUtils.isEmpty(paramString2)) {
      i = 0;
    }
    int j;
    label57:
    label68:
    for (int k = 0;; k = j)
    {
      if (k < i) {
        if (a <= i - k) {
          break label57;
        }
      }
      for (j = i;; j = a + k)
      {
        if (Log.println(paramInt, "FlurryAgent", paramString2.substring(k, j)) > 0) {
          break label68;
        }
        return;
        i = paramString2.length();
        break;
      }
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    b(2, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    b(5, paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */