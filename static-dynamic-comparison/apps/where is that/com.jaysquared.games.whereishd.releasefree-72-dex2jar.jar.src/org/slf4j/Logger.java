package org.slf4j;

public abstract interface Logger
{
  public static final String ROOT_LOGGER_NAME = "ROOT";
  
  public abstract void debug(String paramString);
  
  public abstract void debug(String paramString, Object paramObject);
  
  public abstract void debug(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void debug(String paramString, Throwable paramThrowable);
  
  public abstract void debug(String paramString, Object[] paramArrayOfObject);
  
  public abstract void debug(Marker paramMarker, String paramString);
  
  public abstract void debug(Marker paramMarker, String paramString, Object paramObject);
  
  public abstract void debug(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void debug(Marker paramMarker, String paramString, Throwable paramThrowable);
  
  public abstract void debug(Marker paramMarker, String paramString, Object[] paramArrayOfObject);
  
  public abstract void error(String paramString);
  
  public abstract void error(String paramString, Object paramObject);
  
  public abstract void error(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void error(String paramString, Throwable paramThrowable);
  
  public abstract void error(String paramString, Object[] paramArrayOfObject);
  
  public abstract void error(Marker paramMarker, String paramString);
  
  public abstract void error(Marker paramMarker, String paramString, Object paramObject);
  
  public abstract void error(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void error(Marker paramMarker, String paramString, Throwable paramThrowable);
  
  public abstract void error(Marker paramMarker, String paramString, Object[] paramArrayOfObject);
  
  public abstract String getName();
  
  public abstract void info(String paramString);
  
  public abstract void info(String paramString, Object paramObject);
  
  public abstract void info(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void info(String paramString, Throwable paramThrowable);
  
  public abstract void info(String paramString, Object[] paramArrayOfObject);
  
  public abstract void info(Marker paramMarker, String paramString);
  
  public abstract void info(Marker paramMarker, String paramString, Object paramObject);
  
  public abstract void info(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void info(Marker paramMarker, String paramString, Throwable paramThrowable);
  
  public abstract void info(Marker paramMarker, String paramString, Object[] paramArrayOfObject);
  
  public abstract boolean isDebugEnabled();
  
  public abstract boolean isDebugEnabled(Marker paramMarker);
  
  public abstract boolean isErrorEnabled();
  
  public abstract boolean isErrorEnabled(Marker paramMarker);
  
  public abstract boolean isInfoEnabled();
  
  public abstract boolean isInfoEnabled(Marker paramMarker);
  
  public abstract boolean isTraceEnabled();
  
  public abstract boolean isTraceEnabled(Marker paramMarker);
  
  public abstract boolean isWarnEnabled();
  
  public abstract boolean isWarnEnabled(Marker paramMarker);
  
  public abstract void trace(String paramString);
  
  public abstract void trace(String paramString, Object paramObject);
  
  public abstract void trace(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void trace(String paramString, Throwable paramThrowable);
  
  public abstract void trace(String paramString, Object[] paramArrayOfObject);
  
  public abstract void trace(Marker paramMarker, String paramString);
  
  public abstract void trace(Marker paramMarker, String paramString, Object paramObject);
  
  public abstract void trace(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void trace(Marker paramMarker, String paramString, Throwable paramThrowable);
  
  public abstract void trace(Marker paramMarker, String paramString, Object[] paramArrayOfObject);
  
  public abstract void warn(String paramString);
  
  public abstract void warn(String paramString, Object paramObject);
  
  public abstract void warn(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void warn(String paramString, Throwable paramThrowable);
  
  public abstract void warn(String paramString, Object[] paramArrayOfObject);
  
  public abstract void warn(Marker paramMarker, String paramString);
  
  public abstract void warn(Marker paramMarker, String paramString, Object paramObject);
  
  public abstract void warn(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void warn(Marker paramMarker, String paramString, Throwable paramThrowable);
  
  public abstract void warn(Marker paramMarker, String paramString, Object[] paramArrayOfObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */