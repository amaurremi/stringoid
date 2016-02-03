package com.amazonaws.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.jar.JarFile;

public enum Classes
{
  public static Class<?> childClassOf(Class<?> paramClass, Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Object.class))
    {
      paramObject = null;
      return (Class<?>)paramObject;
    }
    if ((paramClass != null) && (paramClass.isInterface())) {
      return null;
    }
    Class localClass;
    for (paramObject = paramObject.getClass();; paramObject = localClass)
    {
      localClass = ((Class)paramObject).getSuperclass();
      if (localClass == paramClass) {
        break;
      }
      if (localClass == null) {
        return null;
      }
    }
  }
  
  public static JarFile jarFileOf(Class<?> paramClass)
  {
    paramClass = paramClass.getResource("/" + paramClass.getName().replace('.', '/') + ".class");
    if (paramClass == null) {}
    for (;;)
    {
      return null;
      paramClass = paramClass.getFile();
      int i = paramClass.indexOf("file:");
      int j = "file:".length();
      int k = paramClass.indexOf(".jar!");
      if (k == -1) {
        continue;
      }
      paramClass = new File(paramClass.substring(i + j, k + ".jar".length()));
      try
      {
        if (!paramClass.exists()) {
          continue;
        }
        paramClass = new JarFile(paramClass);
        return paramClass;
      }
      catch (IOException paramClass)
      {
        throw new IllegalStateException(paramClass);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/Classes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */