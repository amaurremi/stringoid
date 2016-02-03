package com.gtp.a.a.b;

import android.util.Log;

public final class c
{
  private static b a = new b();
  
  private static final String a(String paramString, Object paramObject)
  {
    Object localObject1 = "com.jb@";
    Object localObject2 = localObject1;
    if (paramObject != null) {}
    try
    {
      paramObject = "com.jb@" + paramObject.getClass().getName();
      localObject1 = paramObject;
      paramObject = (String)paramObject + "::";
      localObject1 = paramObject;
      paramObject = (String)paramObject + new Exception().getStackTrace()[2].getMethodName();
      localObject1 = paramObject;
      localObject2 = (String)paramObject + "@";
      localObject1 = localObject2;
      paramString = (String)localObject2 + paramString;
      return paramString;
    }
    catch (Exception paramString) {}
    return (String)localObject1;
  }
  
  public static final String a(Throwable paramThrowable)
  {
    return Log.getStackTraceString(paramThrowable);
  }
  
  public static final void a(String paramString1, String paramString2)
  {
    if (a.a(3)) {
      Log.d(a(paramString1, null), paramString2);
    }
  }
  
  public static final void a(String paramString1, String paramString2, Object paramObject)
  {
    if (a.a(4)) {
      Log.i(a(paramString1, paramObject), paramString2);
    }
  }
  
  public static final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.a(5)) {
      Log.w(a(paramString1, null), paramString2, paramThrowable);
    }
  }
  
  public static final boolean a()
  {
    return a.a();
  }
  
  public static final void b(String paramString1, String paramString2)
  {
    if (a.a(4)) {
      Log.i(a(paramString1, null), paramString2);
    }
  }
  
  public static final void b(String paramString1, String paramString2, Object paramObject)
  {
    if (a.a(6)) {
      Log.e(a(paramString1, paramObject), paramString2);
    }
  }
  
  public static final void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.a(6)) {
      Log.e(a(paramString1, null), paramString2, paramThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/a/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */