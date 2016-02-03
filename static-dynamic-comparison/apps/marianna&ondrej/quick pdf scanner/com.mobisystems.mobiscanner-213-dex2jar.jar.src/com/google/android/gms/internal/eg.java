package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class eg
  implements SafeParcelable
{
  private static final Object GK = new Object();
  private static ClassLoader GL = null;
  private static Integer GM = null;
  private boolean GN = false;
  
  protected static boolean aJ(String paramString)
  {
    ClassLoader localClassLoader = qn();
    if (localClassLoader == null) {
      return true;
    }
    try
    {
      boolean bool = d(localClassLoader.loadClass(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static boolean d(Class<?> paramClass)
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
  
  protected static ClassLoader qn()
  {
    synchronized (GK)
    {
      ClassLoader localClassLoader = GL;
      return localClassLoader;
    }
  }
  
  protected static Integer qo()
  {
    synchronized (GK)
    {
      Integer localInteger = GM;
      return localInteger;
    }
  }
  
  protected boolean qp()
  {
    return this.GN;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */