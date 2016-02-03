package org.apache.commons.logging;

public class LogConfigurationException
  extends RuntimeException
{
  protected Throwable cause = null;
  
  public LogConfigurationException() {}
  
  public LogConfigurationException(String paramString)
  {
    super(paramString);
  }
  
  public LogConfigurationException(String paramString, Throwable paramThrowable)
  {
    super(paramString + " (Caused by " + paramThrowable + ")");
    this.cause = paramThrowable;
  }
  
  public LogConfigurationException(Throwable paramThrowable) {}
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/LogConfigurationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */