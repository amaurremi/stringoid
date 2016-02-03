package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class c
  implements SafeParcelable
{
  private static final Object Ln = new Object();
  private static ClassLoader Lo = null;
  private static Integer Lp = null;
  private boolean Lq = false;
  
  private static boolean a(Class<?> paramClass)
  {
    try
    {
      boolean bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      return bool;
    }
    catch (IllegalAccessException paramClass)
    {
      return false;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  protected static boolean aV(String paramString)
  {
    ClassLoader localClassLoader = gO();
    if (localClassLoader == null) {
      return true;
    }
    try
    {
      boolean bool = a(localClassLoader.loadClass(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  protected static ClassLoader gO()
  {
    synchronized (Ln)
    {
      ClassLoader localClassLoader = Lo;
      return localClassLoader;
    }
  }
  
  protected static Integer gP()
  {
    synchronized (Ln)
    {
      Integer localInteger = Lp;
      return localInteger;
    }
  }
  
  protected boolean gQ()
  {
    return this.Lq;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */