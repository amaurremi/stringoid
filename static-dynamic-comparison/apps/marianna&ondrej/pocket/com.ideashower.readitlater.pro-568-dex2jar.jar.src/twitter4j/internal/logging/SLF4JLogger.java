package twitter4j.internal.logging;

final class SLF4JLogger
  extends Logger
{
  private final org.slf4j.Logger LOGGER;
  
  SLF4JLogger(org.slf4j.Logger paramLogger)
  {
    this.LOGGER = paramLogger;
  }
  
  public void debug(String paramString)
  {
    this.LOGGER.debug(paramString);
  }
  
  public void debug(String paramString1, String paramString2)
  {
    this.LOGGER.debug(paramString1 + paramString2);
  }
  
  public void error(String paramString)
  {
    this.LOGGER.error(paramString);
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    this.LOGGER.error(paramString, paramThrowable);
  }
  
  public void info(String paramString)
  {
    this.LOGGER.info(paramString);
  }
  
  public void info(String paramString1, String paramString2)
  {
    this.LOGGER.info(paramString1 + paramString2);
  }
  
  public boolean isDebugEnabled()
  {
    return this.LOGGER.isDebugEnabled();
  }
  
  public boolean isErrorEnabled()
  {
    return this.LOGGER.isErrorEnabled();
  }
  
  public boolean isInfoEnabled()
  {
    return this.LOGGER.isInfoEnabled();
  }
  
  public boolean isWarnEnabled()
  {
    return this.LOGGER.isWarnEnabled();
  }
  
  public void warn(String paramString)
  {
    this.LOGGER.warn(paramString);
  }
  
  public void warn(String paramString1, String paramString2)
  {
    this.LOGGER.warn(paramString1 + paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/logging/SLF4JLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */