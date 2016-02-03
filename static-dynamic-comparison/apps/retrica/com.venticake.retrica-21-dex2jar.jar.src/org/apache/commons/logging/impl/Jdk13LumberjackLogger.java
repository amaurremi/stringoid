package org.apache.commons.logging.impl;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;

public class Jdk13LumberjackLogger
  implements Serializable, Log
{
  protected static final Level dummyLevel = Level.FINE;
  private boolean classAndMethodFound = false;
  protected transient Logger logger = null;
  protected String name = null;
  private String sourceClassName = "unknown";
  private String sourceMethodName = "unknown";
  
  public Jdk13LumberjackLogger(String paramString)
  {
    this.name = paramString;
    this.logger = getLogger();
  }
  
  private void getClassAndMethod()
  {
    try
    {
      Object localObject1 = new Throwable();
      ((Throwable)localObject1).fillInStackTrace();
      Object localObject2 = new StringWriter();
      ((Throwable)localObject1).printStackTrace(new PrintWriter((Writer)localObject2));
      StringTokenizer localStringTokenizer = new StringTokenizer(((StringWriter)localObject2).getBuffer().toString(), "\n");
      localStringTokenizer.nextToken();
      for (localObject1 = localStringTokenizer.nextToken();; localObject1 = localStringTokenizer.nextToken())
      {
        localObject2 = localObject1;
        if (((String)localObject1).indexOf(getClass().getName()) != -1) {
          break;
        }
      }
      while (((String)localObject2).indexOf(getClass().getName()) >= 0) {
        localObject2 = localStringTokenizer.nextToken();
      }
      localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf("at ") + 3, ((String)localObject2).indexOf('('));
      int i = ((String)localObject1).lastIndexOf('.');
      this.sourceClassName = ((String)localObject1).substring(0, i);
      this.sourceMethodName = ((String)localObject1).substring(i + 1);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.classAndMethodFound = true;
  }
  
  private void log(Level paramLevel, String paramString, Throwable paramThrowable)
  {
    if (getLogger().isLoggable(paramLevel))
    {
      paramLevel = new LogRecord(paramLevel, paramString);
      if (!this.classAndMethodFound) {
        getClassAndMethod();
      }
      paramLevel.setSourceClassName(this.sourceClassName);
      paramLevel.setSourceMethodName(this.sourceMethodName);
      if (paramThrowable != null) {
        paramLevel.setThrown(paramThrowable);
      }
      getLogger().log(paramLevel);
    }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/Jdk13LumberjackLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */