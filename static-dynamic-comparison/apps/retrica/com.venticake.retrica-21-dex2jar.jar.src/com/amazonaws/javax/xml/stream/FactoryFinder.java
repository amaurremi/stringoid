package com.amazonaws.javax.xml.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

class FactoryFinder
{
  static Properties cacheProps = new Properties();
  private static boolean debug;
  static boolean firstTime = true;
  static SecuritySupport ss = new SecuritySupport();
  
  static
  {
    boolean bool = true;
    debug = false;
    try
    {
      String str = ss.getSystemProperty("jaxp.debug");
      if ((str != null) && (!"false".equals(str))) {}
      for (;;)
      {
        debug = bool;
        return;
        bool = false;
      }
      return;
    }
    catch (SecurityException localSecurityException)
    {
      debug = false;
    }
  }
  
  private static void dPrint(String paramString)
  {
    if (debug) {
      System.err.println("JAXP: " + paramString);
    }
  }
  
  static Object find(String paramString1, ClassLoader paramClassLoader, String paramString2)
  {
    dPrint("find factoryId =" + paramString1);
    try
    {
      Object localObject1 = ss.getSystemProperty(paramString1);
      if (localObject1 != null)
      {
        dPrint("found system property, value=" + (String)localObject1);
        localObject1 = newInstance((String)localObject1, null, true);
        return localObject1;
      }
    }
    catch (SecurityException localSecurityException)
    {
      if (debug) {
        localSecurityException.printStackTrace();
      }
    }
    for (;;)
    {
      try
      {
        if (!firstTime) {
          break label476;
        }
        Object localObject5;
        synchronized (cacheProps)
        {
          if (!firstTime) {
            break label471;
          }
          Object localObject2 = ss.getSystemProperty("java.home") + File.separator + "lib" + File.separator + "stax.properties";
          localObject5 = new File((String)localObject2);
          firstTime = false;
          if (ss.doesFileExist((File)localObject5))
          {
            dPrint("Read properties file " + localObject5);
            cacheProps.load(ss.getFileInputStream((File)localObject5));
            localObject5 = cacheProps.getProperty(paramString1);
            if (localObject5 != null)
            {
              dPrint("found in " + (String)localObject2 + " value=" + (String)localObject5);
              localObject2 = newInstance((String)localObject5, null, true);
              return localObject2;
            }
          }
          else
          {
            localObject5 = ss.getSystemProperty("java.home") + File.separator + "lib" + File.separator + "jaxp.properties";
            File localFile = new File((String)localObject5);
            localObject2 = localObject5;
            if (!ss.doesFileExist(localFile)) {
              continue;
            }
            dPrint("Read properties file " + localFile);
            cacheProps.load(ss.getFileInputStream(localFile));
            localObject2 = localObject5;
          }
        }
        if (localObject5 != null) {
          break;
        }
      }
      catch (Exception localException)
      {
        if (debug) {
          localException.printStackTrace();
        }
        localObject5 = findJarServiceProvider(paramString1);
        localObject4 = localObject5;
      }
      if (paramString2 == null) {
        throw new FactoryFinder.ConfigurationError("Provider for " + paramString1 + " cannot be found", null);
      }
      dPrint("loaded from fallback value: " + paramString2);
      return newInstance(paramString2, paramClassLoader, true);
      label471:
      Object localObject4 = null;
      continue;
      label476:
      localObject4 = null;
    }
  }
  
  static Object find(String paramString1, String paramString2)
  {
    return find(paramString1, null, paramString2);
  }
  
  private static Object findJarServiceProvider(String paramString)
  {
    Object localObject2 = "META-INF/services/" + paramString;
    paramString = ss.getContextClassLoader();
    Object localObject1;
    if (paramString != null)
    {
      localObject1 = ss.getResourceAsStream(paramString, (String)localObject2);
      if (localObject1 != null) {
        break label216;
      }
      paramString = FactoryFinder.class.getClassLoader();
      localObject1 = ss.getResourceAsStream(paramString, (String)localObject2);
    }
    label216:
    for (;;)
    {
      if (localObject1 == null)
      {
        return null;
        paramString = FactoryFinder.class.getClassLoader();
        localObject1 = ss.getResourceAsStream(paramString, (String)localObject2);
      }
      else
      {
        if (debug) {
          dPrint("found jar resource=" + (String)localObject2 + " using ClassLoader: " + paramString);
        }
        try
        {
          localObject2 = new BufferedReader(new InputStreamReader((InputStream)localObject1, "UTF-8"));
          localObject1 = localObject2;
          return null;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            try
            {
              localObject2 = ((BufferedReader)localObject1).readLine();
              ((BufferedReader)localObject1).close();
              if ((localObject2 == null) || ("".equals(localObject2))) {
                break;
              }
              dPrint("found in resource, value=" + (String)localObject2);
              return newInstance((String)localObject2, paramString, false);
            }
            catch (IOException paramString)
            {
              return null;
            }
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            localObject1 = new BufferedReader(new InputStreamReader((InputStream)localObject1));
          }
        }
      }
    }
  }
  
  private static Class getProviderClass(String paramString, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    if (paramClassLoader == null)
    {
      try
      {
        paramClassLoader = ss.getContextClassLoader();
        if (paramClassLoader != null) {
          break label39;
        }
        throw new ClassNotFoundException();
      }
      catch (ClassNotFoundException paramClassLoader)
      {
        if (!paramBoolean) {
          break label53;
        }
      }
      return Class.forName(paramString, true, FactoryFinder.class.getClassLoader());
      label39:
      return paramClassLoader.loadClass(paramString);
    }
    paramClassLoader = paramClassLoader.loadClass(paramString);
    return paramClassLoader;
    label53:
    throw paramClassLoader;
  }
  
  static Object newInstance(String paramString, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    try
    {
      Class localClass = getProviderClass(paramString, paramClassLoader, paramBoolean);
      Object localObject = localClass.newInstance();
      if (debug) {
        dPrint("created new instance of " + localClass + " using ClassLoader: " + paramClassLoader);
      }
      return localObject;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new FactoryFinder.ConfigurationError("Provider " + paramString + " not found", paramClassLoader);
    }
    catch (Exception paramClassLoader)
    {
      throw new FactoryFinder.ConfigurationError("Provider " + paramString + " could not be instantiated: " + paramClassLoader, paramClassLoader);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/FactoryFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */