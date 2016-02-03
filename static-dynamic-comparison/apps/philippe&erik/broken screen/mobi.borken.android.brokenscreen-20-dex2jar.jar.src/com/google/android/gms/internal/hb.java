package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class hb
  implements SafeParcelable
{
  private static final Object FU = new Object();
  private static ClassLoader FV = null;
  private static Integer FW = null;
  private boolean FX = false;
  
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
  
  protected static boolean aA(String paramString)
  {
    ClassLoader localClassLoader = fk();
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
  
  protected static ClassLoader fk()
  {
    synchronized (FU)
    {
      ClassLoader localClassLoader = FV;
      return localClassLoader;
    }
  }
  
  protected static Integer fl()
  {
    synchronized (FU)
    {
      Integer localInteger = FW;
      return localInteger;
    }
  }
  
  protected boolean fm()
  {
    return this.FX;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */