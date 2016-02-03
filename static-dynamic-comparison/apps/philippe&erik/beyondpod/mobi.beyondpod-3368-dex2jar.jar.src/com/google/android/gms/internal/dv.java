package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class dv
  implements SafeParcelable
{
  private static final Object pa = new Object();
  private static ClassLoader pb = null;
  private static Integer pc = null;
  private boolean pd = false;
  
  protected static boolean P(String paramString)
  {
    ClassLoader localClassLoader = bL();
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
  
  protected static ClassLoader bL()
  {
    synchronized (pa)
    {
      ClassLoader localClassLoader = pb;
      return localClassLoader;
    }
  }
  
  protected static Integer bM()
  {
    synchronized (pa)
    {
      Integer localInteger = pc;
      return localInteger;
    }
  }
  
  protected boolean bN()
  {
    return this.pd;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */