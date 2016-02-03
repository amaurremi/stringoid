package com.amazonaws.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public enum ClassLoaderHelper
{
  public static URL getResource(String paramString, boolean paramBoolean, Class<?>... paramVarArgs)
  {
    Object localObject;
    if (paramBoolean)
    {
      paramVarArgs = getResourceViaClasses(paramString, paramVarArgs);
      localObject = paramVarArgs;
      if (paramVarArgs == null) {
        localObject = getResourceViaContext(paramString);
      }
    }
    for (;;)
    {
      paramVarArgs = (Class<?>[])localObject;
      if (localObject == null) {
        paramVarArgs = ClassLoaderHelper.class.getResource(paramString);
      }
      return paramVarArgs;
      URL localURL = getResourceViaContext(paramString);
      localObject = localURL;
      if (localURL == null) {
        localObject = getResourceViaClasses(paramString, paramVarArgs);
      }
    }
  }
  
  public static URL getResource(String paramString, Class<?>... paramVarArgs)
  {
    return getResource(paramString, false, paramVarArgs);
  }
  
  public static InputStream getResourceAsStream(String paramString, boolean paramBoolean, Class<?>... paramVarArgs)
  {
    Object localObject = null;
    paramVarArgs = getResource(paramString, paramBoolean, paramVarArgs);
    paramString = (String)localObject;
    if (paramVarArgs != null) {}
    try
    {
      paramString = paramVarArgs.openStream();
      return paramString;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  private static URL getResourceViaClasses(String paramString, Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass != null)
    {
      int j = paramArrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        URL localURL = paramArrayOfClass[i].getResource(paramString);
        if (localURL != null) {
          return localURL;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private static URL getResourceViaContext(String paramString)
  {
    ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
    if (localClassLoader == null) {
      return null;
    }
    return localClassLoader.getResource(paramString);
  }
  
  public static Class<?> loadClass(String paramString, boolean paramBoolean, Class<?>... paramVarArgs)
  {
    Object localObject;
    if (paramBoolean)
    {
      paramVarArgs = loadClassViaClasses(paramString, paramVarArgs);
      localObject = paramVarArgs;
      if (paramVarArgs == null) {
        localObject = loadClassViaContext(paramString);
      }
    }
    for (;;)
    {
      paramVarArgs = (Class<?>[])localObject;
      if (localObject == null) {
        paramVarArgs = Class.forName(paramString);
      }
      return paramVarArgs;
      Class localClass = loadClassViaContext(paramString);
      localObject = localClass;
      if (localClass == null) {
        localObject = loadClassViaClasses(paramString, paramVarArgs);
      }
    }
  }
  
  public static Class<?> loadClass(String paramString, Class<?>... paramVarArgs)
  {
    return loadClass(paramString, true, paramVarArgs);
  }
  
  private static Class<?> loadClassViaClasses(String paramString, Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass != null)
    {
      int j = paramArrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfClass[i].getClassLoader();
        if (localObject != null) {
          try
          {
            localObject = ((ClassLoader)localObject).loadClass(paramString);
            return (Class<?>)localObject;
          }
          catch (ClassNotFoundException localClassNotFoundException) {}
        }
        i += 1;
      }
    }
    return null;
  }
  
  private static Class<?> loadClassViaContext(String paramString)
  {
    ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
    if (localClassLoader == null) {
      return null;
    }
    try
    {
      paramString = localClassLoader.loadClass(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/ClassLoaderHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */