package com.google.ads.util;

import android.util.Log;

public final class b
{
  public static b a = null;
  private static int b = 5;
  
  private static void a(a parama, String paramString)
  {
    a(parama, paramString, null);
  }
  
  private static void a(a parama, String paramString, Throwable paramThrowable)
  {
    if (a != null) {
      a.a(parama, paramString, paramThrowable);
    }
  }
  
  public static void a(String paramString)
  {
    if (a("Ads", 3)) {
      Log.d("Ads", paramString);
    }
    a(a.b, paramString);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (a("Ads", 3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
    a(a.b, paramString, paramThrowable);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt >= b;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    return (a(paramInt)) || (Log.isLoggable(paramString, paramInt));
  }
  
  public static void b(String paramString)
  {
    if (a("Ads", 6)) {
      Log.e("Ads", paramString);
    }
    a(a.e, paramString);
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (a("Ads", 6))
    {
      Log.e("Ads", paramString);
      Log.i("Ads", "The following was caught and handled:", paramThrowable);
    }
    a(a.e, paramString, paramThrowable);
  }
  
  public static void c(String paramString)
  {
    if (a("Ads", 4)) {
      Log.i("Ads", paramString);
    }
    a(a.c, paramString);
  }
  
  public static void c(String paramString, Throwable paramThrowable)
  {
    if (a("Ads", 4)) {
      Log.i("Ads", paramString, paramThrowable);
    }
    a(a.c, paramString, paramThrowable);
  }
  
  public static void d(String paramString)
  {
    if (a("Ads", 2)) {
      Log.v("Ads", paramString);
    }
    a(a.a, paramString);
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    if (a("Ads", 5))
    {
      Log.w("Ads", paramString);
      Log.i("Ads", "The following was caught and handled:", paramThrowable);
    }
    a(a.d, paramString, paramThrowable);
  }
  
  public static void e(String paramString)
  {
    if (a("Ads", 5)) {
      Log.w("Ads", paramString);
    }
    a(a.d, paramString);
  }
  
  public static enum a
  {
    public final int f;
    
    private a(int paramInt)
    {
      this.f = paramInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(b.a parama, String paramString, Throwable paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */