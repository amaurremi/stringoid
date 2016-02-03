package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class dd
  implements SafeParcelable
{
  private static final Object a = new Object();
  private static ClassLoader b = null;
  private static Integer c = null;
  private boolean d = false;
  
  private static boolean a(Class paramClass)
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
  
  protected static boolean b(String paramString)
  {
    ClassLoader localClassLoader = t();
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
  
  protected static ClassLoader t()
  {
    synchronized (a)
    {
      ClassLoader localClassLoader = b;
      return localClassLoader;
    }
  }
  
  protected static Integer u()
  {
    synchronized (a)
    {
      Integer localInteger = c;
      return localInteger;
    }
  }
  
  protected boolean v()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */