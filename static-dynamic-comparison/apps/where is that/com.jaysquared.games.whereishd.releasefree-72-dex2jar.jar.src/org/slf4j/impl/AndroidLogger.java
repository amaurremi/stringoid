package org.slf4j.impl;

import android.util.Log;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

public class AndroidLogger
  extends MarkerIgnoringBase
{
  private static final long serialVersionUID = -1227274521521287937L;
  
  AndroidLogger(String paramString)
  {
    this.name = paramString;
  }
  
  private String format(String paramString, Object paramObject1, Object paramObject2)
  {
    return MessageFormatter.format(paramString, paramObject1, paramObject2);
  }
  
  private String format(String paramString, Object[] paramArrayOfObject)
  {
    return MessageFormatter.arrayFormat(paramString, paramArrayOfObject);
  }
  
  public void debug(String paramString)
  {
    Log.d(this.name, paramString);
  }
  
  public void debug(String paramString, Object paramObject)
  {
    Log.d(this.name, format(paramString, paramObject, null));
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.d(this.name, format(paramString, paramObject1, paramObject2));
  }
  
  public void debug(String paramString, Throwable paramThrowable)
  {
    Log.d(this.name, paramString, paramThrowable);
  }
  
  public void debug(String paramString, Object[] paramArrayOfObject)
  {
    Log.d(this.name, format(paramString, paramArrayOfObject));
  }
  
  public void error(String paramString)
  {
    Log.e(this.name, paramString);
  }
  
  public void error(String paramString, Object paramObject)
  {
    Log.e(this.name, format(paramString, paramObject, null));
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.e(this.name, format(paramString, paramObject1, paramObject2));
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    Log.e(this.name, paramString, paramThrowable);
  }
  
  public void error(String paramString, Object[] paramArrayOfObject)
  {
    Log.e(this.name, format(paramString, paramArrayOfObject));
  }
  
  public void info(String paramString)
  {
    Log.i(this.name, paramString);
  }
  
  public void info(String paramString, Object paramObject)
  {
    Log.i(this.name, format(paramString, paramObject, null));
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.i(this.name, format(paramString, paramObject1, paramObject2));
  }
  
  public void info(String paramString, Throwable paramThrowable)
  {
    Log.i(this.name, paramString, paramThrowable);
  }
  
  public void info(String paramString, Object[] paramArrayOfObject)
  {
    Log.i(this.name, format(paramString, paramArrayOfObject));
  }
  
  public boolean isDebugEnabled()
  {
    return Log.isLoggable(this.name, 3);
  }
  
  public boolean isErrorEnabled()
  {
    return Log.isLoggable(this.name, 6);
  }
  
  public boolean isInfoEnabled()
  {
    return Log.isLoggable(this.name, 4);
  }
  
  public boolean isTraceEnabled()
  {
    return Log.isLoggable(this.name, 2);
  }
  
  public boolean isWarnEnabled()
  {
    return Log.isLoggable(this.name, 5);
  }
  
  public void trace(String paramString)
  {
    Log.v(this.name, paramString);
  }
  
  public void trace(String paramString, Object paramObject)
  {
    Log.v(this.name, format(paramString, paramObject, null));
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.v(this.name, format(paramString, paramObject1, paramObject2));
  }
  
  public void trace(String paramString, Throwable paramThrowable)
  {
    Log.v(this.name, paramString, paramThrowable);
  }
  
  public void trace(String paramString, Object[] paramArrayOfObject)
  {
    Log.v(this.name, format(paramString, paramArrayOfObject));
  }
  
  public void warn(String paramString)
  {
    Log.w(this.name, paramString);
  }
  
  public void warn(String paramString, Object paramObject)
  {
    Log.w(this.name, format(paramString, paramObject, null));
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.w(this.name, format(paramString, paramObject1, paramObject2));
  }
  
  public void warn(String paramString, Throwable paramThrowable)
  {
    Log.w(this.name, paramString, paramThrowable);
  }
  
  public void warn(String paramString, Object[] paramArrayOfObject)
  {
    Log.w(this.name, format(paramString, paramArrayOfObject));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/impl/AndroidLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */