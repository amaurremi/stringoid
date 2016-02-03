package com.j256.ormlite.logger;

import java.util.Arrays;

public class Logger
{
  private static final String ARG_STRING = "{}";
  private static final int ARG_STRING_LENGTH = "{}".length();
  private static final Object UNKNOWN_ARG = new Object();
  private final Log log;
  
  public Logger(Log paramLog)
  {
    this.log = paramLog;
  }
  
  private void appendArg(StringBuilder paramStringBuilder, Object paramObject)
  {
    if (paramObject == UNKNOWN_ARG) {
      return;
    }
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
      return;
    }
    if (paramObject.getClass().isArray())
    {
      paramStringBuilder.append(Arrays.toString((Object[])paramObject));
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private String buildFullMessage(String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    int j = 0;
    int i = 0;
    int k = paramString.indexOf("{}", j);
    if (k == -1)
    {
      if (localObject1 == null) {
        return paramString;
      }
    }
    else
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(128);
      }
      ((StringBuilder)localObject2).append(paramString.substring(j, k));
      j = k + ARG_STRING_LENGTH;
      if (paramArrayOfObject == null) {
        if (i == 0) {
          appendArg((StringBuilder)localObject2, paramObject1);
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        if (i == 1)
        {
          appendArg((StringBuilder)localObject2, paramObject2);
        }
        else if (i == 2)
        {
          appendArg((StringBuilder)localObject2, paramObject3);
          continue;
          if (i < paramArrayOfObject.length) {
            appendArg((StringBuilder)localObject2, paramArrayOfObject[i]);
          }
        }
      }
    }
    ((StringBuilder)localObject1).append(paramString.substring(j));
    return ((StringBuilder)localObject1).toString();
  }
  
  private void innerLog(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    if (this.log.isLevelEnabled(paramLevel))
    {
      paramString = buildFullMessage(paramString, paramObject1, paramObject2, paramObject3, paramArrayOfObject);
      if (paramThrowable == null) {
        this.log.log(paramLevel, paramString);
      }
    }
    else
    {
      return;
    }
    this.log.log(paramLevel, paramString, paramThrowable);
  }
  
  public void debug(String paramString)
  {
    innerLog(Log.Level.DEBUG, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void debug(String paramString, Object paramObject)
  {
    innerLog(Log.Level.DEBUG, null, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.DEBUG, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.DEBUG, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void debug(String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.DEBUG, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void debug(Throwable paramThrowable, String paramString)
  {
    innerLog(Log.Level.DEBUG, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void debug(Throwable paramThrowable, String paramString, Object paramObject)
  {
    innerLog(Log.Level.DEBUG, paramThrowable, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void debug(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.DEBUG, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void debug(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.DEBUG, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void debug(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.DEBUG, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void error(String paramString)
  {
    innerLog(Log.Level.ERROR, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void error(String paramString, Object paramObject)
  {
    innerLog(Log.Level.ERROR, null, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.ERROR, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.ERROR, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void error(String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.ERROR, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void error(Throwable paramThrowable, String paramString)
  {
    innerLog(Log.Level.ERROR, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void error(Throwable paramThrowable, String paramString, Object paramObject)
  {
    innerLog(Log.Level.ERROR, paramThrowable, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void error(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.ERROR, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void error(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.ERROR, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void error(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.ERROR, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void fatal(String paramString)
  {
    innerLog(Log.Level.FATAL, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void fatal(String paramString, Object paramObject)
  {
    innerLog(Log.Level.FATAL, null, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void fatal(String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.FATAL, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void fatal(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.FATAL, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void fatal(String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.FATAL, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void fatal(Throwable paramThrowable, String paramString)
  {
    innerLog(Log.Level.FATAL, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void fatal(Throwable paramThrowable, String paramString, Object paramObject)
  {
    innerLog(Log.Level.FATAL, paramThrowable, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void fatal(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.FATAL, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void fatal(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.FATAL, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void fatal(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.FATAL, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void info(String paramString)
  {
    innerLog(Log.Level.INFO, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void info(String paramString, Object paramObject)
  {
    innerLog(Log.Level.INFO, null, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.INFO, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.INFO, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void info(String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.INFO, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void info(Throwable paramThrowable, String paramString)
  {
    innerLog(Log.Level.INFO, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void info(Throwable paramThrowable, String paramString, Object paramObject)
  {
    innerLog(Log.Level.INFO, paramThrowable, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void info(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.INFO, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void info(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.INFO, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void info(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.INFO, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public boolean isLevelEnabled(Log.Level paramLevel)
  {
    return this.log.isLevelEnabled(paramLevel);
  }
  
  public void log(Log.Level paramLevel, String paramString)
  {
    innerLog(paramLevel, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Object paramObject)
  {
    innerLog(paramLevel, null, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(paramLevel, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(paramLevel, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Object[] paramArrayOfObject)
  {
    innerLog(paramLevel, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString)
  {
    innerLog(paramLevel, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject)
  {
    innerLog(paramLevel, paramThrowable, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(paramLevel, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(paramLevel, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    innerLog(paramLevel, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void trace(String paramString)
  {
    innerLog(Log.Level.TRACE, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void trace(String paramString, Object paramObject)
  {
    innerLog(Log.Level.TRACE, null, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.TRACE, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.TRACE, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void trace(String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.TRACE, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void trace(Throwable paramThrowable, String paramString)
  {
    innerLog(Log.Level.TRACE, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void trace(Throwable paramThrowable, String paramString, Object paramObject)
  {
    innerLog(Log.Level.TRACE, paramThrowable, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void trace(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.TRACE, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void trace(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.TRACE, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void trace(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.TRACE, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void warn(String paramString)
  {
    innerLog(Log.Level.WARNING, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void warn(String paramString, Object paramObject)
  {
    innerLog(Log.Level.WARNING, null, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.WARNING, null, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.WARNING, null, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void warn(String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.WARNING, null, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
  
  public void warn(Throwable paramThrowable, String paramString)
  {
    innerLog(Log.Level.WARNING, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void warn(Throwable paramThrowable, String paramString, Object paramObject)
  {
    innerLog(Log.Level.WARNING, paramThrowable, paramString, paramObject, UNKNOWN_ARG, UNKNOWN_ARG, null);
  }
  
  public void warn(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    innerLog(Log.Level.WARNING, paramThrowable, paramString, paramObject1, paramObject2, UNKNOWN_ARG, null);
  }
  
  public void warn(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    innerLog(Log.Level.WARNING, paramThrowable, paramString, paramObject1, paramObject2, paramObject3, null);
  }
  
  public void warn(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    innerLog(Log.Level.WARNING, paramThrowable, paramString, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, paramArrayOfObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/logger/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */