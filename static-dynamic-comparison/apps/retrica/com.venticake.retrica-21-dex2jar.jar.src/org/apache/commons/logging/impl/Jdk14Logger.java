package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;

public class Jdk14Logger
  implements Serializable, Log
{
  protected static final Level dummyLevel = Level.FINE;
  protected transient Logger logger = null;
  protected String name = null;
  
  public Jdk14Logger(String paramString)
  {
    this.name = paramString;
    this.logger = getLogger();
  }
  
  private void log(Level paramLevel, String paramString, Throwable paramThrowable)
  {
    Logger localLogger = getLogger();
    String str1;
    Object localObject;
    if (localLogger.isLoggable(paramLevel))
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      String str2 = "unknown";
      String str3 = "unknown";
      str1 = str2;
      localObject = str3;
      if (arrayOfStackTraceElement != null)
      {
        str1 = str2;
        localObject = str3;
        if (arrayOfStackTraceElement.length > 2)
        {
          localObject = arrayOfStackTraceElement[2];
          str1 = ((StackTraceElement)localObject).getClassName();
          localObject = ((StackTraceElement)localObject).getMethodName();
        }
      }
      if (paramThrowable == null) {
        localLogger.logp(paramLevel, str1, (String)localObject, paramString);
      }
    }
    else
    {
      return;
    }
    localLogger.logp(paramLevel, str1, (String)localObject, paramString, paramThrowable);
  }
  
  public void debug(Object paramObject)
  {
    log(Level.FINE, String.valueOf(paramObject), null);
  }
  
  public void debug(Object paramObject, Throwable paramThrowable)
  {
    log(Level.FINE, String.valueOf(paramObject), paramThrowable);
  }
  
  public void error(Object paramObject)
  {
    log(Level.SEVERE, String.valueOf(paramObject), null);
  }
  
  public void error(Object paramObject, Throwable paramThrowable)
  {
    log(Level.SEVERE, String.valueOf(paramObject), paramThrowable);
  }
  
  public void fatal(Object paramObject)
  {
    log(Level.SEVERE, String.valueOf(paramObject), null);
  }
  
  public void fatal(Object paramObject, Throwable paramThrowable)
  {
    log(Level.SEVERE, String.valueOf(paramObject), paramThrowable);
  }
  
  public Logger getLogger()
  {
    if (this.logger == null) {
      this.logger = Logger.getLogger(this.name);
    }
    return this.logger;
  }
  
  public void info(Object paramObject)
  {
    log(Level.INFO, String.valueOf(paramObject), null);
  }
  
  public void info(Object paramObject, Throwable paramThrowable)
  {
    log(Level.INFO, String.valueOf(paramObject), paramThrowable);
  }
  
  public boolean isDebugEnabled()
  {
    return getLogger().isLoggable(Level.FINE);
  }
  
  public boolean isErrorEnabled()
  {
    return getLogger().isLoggable(Level.SEVERE);
  }
  
  public boolean isFatalEnabled()
  {
    return getLogger().isLoggable(Level.SEVERE);
  }
  
  public boolean isInfoEnabled()
  {
    return getLogger().isLoggable(Level.INFO);
  }
  
  public boolean isTraceEnabled()
  {
    return getLogger().isLoggable(Level.FINEST);
  }
  
  public boolean isWarnEnabled()
  {
    return getLogger().isLoggable(Level.WARNING);
  }
  
  public void trace(Object paramObject)
  {
    log(Level.FINEST, String.valueOf(paramObject), null);
  }
  
  public void trace(Object paramObject, Throwable paramThrowable)
  {
    log(Level.FINEST, String.valueOf(paramObject), paramThrowable);
  }
  
  public void warn(Object paramObject)
  {
    log(Level.WARNING, String.valueOf(paramObject), null);
  }
  
  public void warn(Object paramObject, Throwable paramThrowable)
  {
    log(Level.WARNING, String.valueOf(paramObject), paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/Jdk14Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */