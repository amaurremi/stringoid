package org.apache.commons.logging.impl;

import java.io.Serializable;
import org.apache.commons.logging.Log;

public class NoOpLog
  implements Serializable, Log
{
  public NoOpLog() {}
  
  public NoOpLog(String paramString) {}
  
  public void debug(Object paramObject) {}
  
  public void debug(Object paramObject, Throwable paramThrowable) {}
  
  public void error(Object paramObject) {}
  
  public void error(Object paramObject, Throwable paramThrowable) {}
  
  public void fatal(Object paramObject) {}
  
  public void fatal(Object paramObject, Throwable paramThrowable) {}
  
  public void info(Object paramObject) {}
  
  public void info(Object paramObject, Throwable paramThrowable) {}
  
  public final boolean isDebugEnabled()
  {
    return false;
  }
  
  public final boolean isErrorEnabled()
  {
    return false;
  }
  
  public final boolean isFatalEnabled()
  {
    return false;
  }
  
  public final boolean isInfoEnabled()
  {
    return false;
  }
  
  public final boolean isTraceEnabled()
  {
    return false;
  }
  
  public final boolean isWarnEnabled()
  {
    return false;
  }
  
  public void trace(Object paramObject) {}
  
  public void trace(Object paramObject, Throwable paramThrowable) {}
  
  public void warn(Object paramObject) {}
  
  public void warn(Object paramObject, Throwable paramThrowable) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/NoOpLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */