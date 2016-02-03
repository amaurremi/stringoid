package com.chartboost.sdk.Libraries;

import android.util.Log;
import com.chartboost.sdk.Chartboost;

public final class CBLogging
{
  public static Level a = Level.INTEGRATION;
  private static String b = "Chartboost SDK";
  
  private static String a(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof String))) {}
    for (;;)
    {
      return (String)paramObject;
      paramObject = paramObject.getClass().getName();
    }
  }
  
  public static void a(Object paramObject, String paramString)
  {
    if (a == Level.ALL) {
      Log.d(a(paramObject), paramString);
    }
  }
  
  public static void a(Object paramObject, String paramString, Throwable paramThrowable)
  {
    if (a == Level.ALL) {
      Log.d(a(paramObject), paramString, paramThrowable);
    }
  }
  
  public static void a(String paramString)
  {
    if (a()) {
      Log.e(b, paramString);
    }
  }
  
  private static boolean a()
  {
    return (a == Level.ALL) || ((a == Level.INTEGRATION) && (CBUtility.a(Chartboost.sharedChartboost().getContext())));
  }
  
  public static void b(Object paramObject, String paramString)
  {
    if (a == Level.ALL) {
      Log.e(a(paramObject), paramString);
    }
  }
  
  public static void b(Object paramObject, String paramString, Throwable paramThrowable)
  {
    if (a == Level.ALL) {
      Log.e(a(paramObject), paramString, paramThrowable);
    }
  }
  
  public static void c(Object paramObject, String paramString)
  {
    if (a == Level.ALL) {
      Log.w(a(paramObject), paramString);
    }
  }
  
  public static void c(Object paramObject, String paramString, Throwable paramThrowable)
  {
    if (a == Level.ALL) {
      Log.v(a(paramObject), paramString, paramThrowable);
    }
  }
  
  public static void d(Object paramObject, String paramString)
  {
    if (a == Level.ALL) {
      Log.i(a(paramObject), paramString);
    }
  }
  
  public static void d(Object paramObject, String paramString, Throwable paramThrowable)
  {
    if (a == Level.ALL) {
      Log.w(a(paramObject), paramString, paramThrowable);
    }
  }
  
  public static enum Level
  {
    static
    {
      INTEGRATION = new Level("INTEGRATION", 1);
    }
    
    private Level() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/CBLogging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */