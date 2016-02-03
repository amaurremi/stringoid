package com.vladium.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

public abstract class ResourceLoader
{
  public static URL getResource(String paramString)
  {
    ClassLoader localClassLoader = ClassLoaderResolver.getClassLoader(ClassLoaderResolver.getCallerClass(1));
    if (localClassLoader != null) {
      return localClassLoader.getResource(paramString);
    }
    return ClassLoader.getSystemResource(paramString);
  }
  
  public static URL getResource(String paramString, ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {
      return paramClassLoader.getResource(paramString);
    }
    return ClassLoader.getSystemResource(paramString);
  }
  
  public static InputStream getResourceAsStream(String paramString)
  {
    ClassLoader localClassLoader = ClassLoaderResolver.getClassLoader(ClassLoaderResolver.getCallerClass(1));
    if (localClassLoader != null) {
      return localClassLoader.getResourceAsStream(paramString);
    }
    return ClassLoader.getSystemResourceAsStream(paramString);
  }
  
  public static InputStream getResourceAsStream(String paramString, ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {
      return paramClassLoader.getResourceAsStream(paramString);
    }
    return ClassLoader.getSystemResourceAsStream(paramString);
  }
  
  public static Enumeration getResources(String paramString)
    throws IOException
  {
    ClassLoader localClassLoader = ClassLoaderResolver.getClassLoader(ClassLoaderResolver.getCallerClass(1));
    if (localClassLoader != null) {
      return localClassLoader.getResources(paramString);
    }
    return ClassLoader.getSystemResources(paramString);
  }
  
  public static Enumeration getResources(String paramString, ClassLoader paramClassLoader)
    throws IOException
  {
    if (paramClassLoader != null) {
      return paramClassLoader.getResources(paramString);
    }
    return ClassLoader.getSystemResources(paramString);
  }
  
  public static Class loadClass(String paramString)
    throws ClassNotFoundException
  {
    return Class.forName(paramString, false, ClassLoaderResolver.getClassLoader(ClassLoaderResolver.getCallerClass(1)));
  }
  
  public static Class loadClass(String paramString, ClassLoader paramClassLoader)
    throws ClassNotFoundException
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      return Class.forName(paramString, false, paramClassLoader);
      paramClassLoader = ClassLoader.getSystemClassLoader();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/ResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */