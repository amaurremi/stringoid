package org.slf4j.helpers;

public class NOPLogger
  extends MarkerIgnoringBase
{
  public static final NOPLogger NOP_LOGGER = new NOPLogger();
  private static final long serialVersionUID = -517220405410904473L;
  
  public final void debug(String paramString) {}
  
  public final void debug(String paramString, Object paramObject) {}
  
  public final void debug(String paramString, Object paramObject1, Object paramObject2) {}
  
  public final void debug(String paramString, Throwable paramThrowable) {}
  
  public final void debug(String paramString, Object[] paramArrayOfObject) {}
  
  public final void error(String paramString) {}
  
  public final void error(String paramString, Object paramObject) {}
  
  public final void error(String paramString, Object paramObject1, Object paramObject2) {}
  
  public final void error(String paramString, Throwable paramThrowable) {}
  
  public final void error(String paramString, Object[] paramArrayOfObject) {}
  
  public String getName()
  {
    return "NOP";
  }
  
  public final void info(String paramString) {}
  
  public final void info(String paramString, Object paramObject) {}
  
  public final void info(String paramString, Object paramObject1, Object paramObject2) {}
  
  public final void info(String paramString, Throwable paramThrowable) {}
  
  public final void info(String paramString, Object[] paramArrayOfObject) {}
  
  public final boolean isDebugEnabled()
  {
    return false;
  }
  
  public final boolean isErrorEnabled()
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
  
  public final void trace(String paramString) {}
  
  public final void trace(String paramString, Object paramObject) {}
  
  public final void trace(String paramString, Object paramObject1, Object paramObject2) {}
  
  public final void trace(String paramString, Throwable paramThrowable) {}
  
  public final void trace(String paramString, Object[] paramArrayOfObject) {}
  
  public final void warn(String paramString) {}
  
  public final void warn(String paramString, Object paramObject) {}
  
  public final void warn(String paramString, Object paramObject1, Object paramObject2) {}
  
  public final void warn(String paramString, Throwable paramThrowable) {}
  
  public final void warn(String paramString, Object[] paramArrayOfObject) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/helpers/NOPLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */