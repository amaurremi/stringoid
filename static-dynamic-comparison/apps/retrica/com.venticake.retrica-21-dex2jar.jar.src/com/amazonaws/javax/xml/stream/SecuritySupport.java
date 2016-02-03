package com.amazonaws.javax.xml.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

class SecuritySupport
{
  boolean doesFileExist(final File paramFile)
  {
    ((Boolean)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        return new Boolean(paramFile.exists());
      }
    })).booleanValue();
  }
  
  ClassLoader getContextClassLoader()
  {
    (ClassLoader)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        ClassLoader localClassLoader2 = Thread.currentThread().getContextClassLoader();
        ClassLoader localClassLoader1 = localClassLoader2;
        if (localClassLoader2 == null) {
          localClassLoader1 = ClassLoader.getSystemClassLoader();
        }
        return localClassLoader1;
      }
    });
  }
  
  FileInputStream getFileInputStream(final File paramFile)
  {
    try
    {
      paramFile = (FileInputStream)AccessController.doPrivileged(new PrivilegedExceptionAction()
      {
        public Object run()
        {
          return new FileInputStream(paramFile);
        }
      });
      return paramFile;
    }
    catch (PrivilegedActionException paramFile)
    {
      throw ((FileNotFoundException)paramFile.getException());
    }
  }
  
  InputStream getResourceAsStream(final ClassLoader paramClassLoader, final String paramString)
  {
    (InputStream)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        if (paramClassLoader == null) {
          return ClassLoader.getSystemResourceAsStream(paramString);
        }
        return paramClassLoader.getResourceAsStream(paramString);
      }
    });
  }
  
  String getSystemProperty(final String paramString)
  {
    (String)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        return System.getProperty(paramString);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/SecuritySupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */