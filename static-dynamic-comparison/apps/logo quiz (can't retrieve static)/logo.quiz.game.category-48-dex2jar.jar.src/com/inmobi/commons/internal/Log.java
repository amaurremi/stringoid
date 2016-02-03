package com.inmobi.commons.internal;

public class Log
{
  protected static INTERNAL_LOG_LEVEL debugLevel = INTERNAL_LOG_LEVEL.NOT_SET;
  
  public static void debug(String paramString1, String paramString2)
  {
    if ((debugLevel.getValue() >= INTERNAL_LOG_LEVEL.DEBUG.getValue()) || ((debugLevel == INTERNAL_LOG_LEVEL.NOT_SET) && (CommonsConfig.b.getValue() >= INTERNAL_LOG_LEVEL.DEBUG.getValue()))) {
      android.util.Log.d(paramString1, paramString2);
    }
  }
  
  public static void debug(String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (a.a[debugLevel.ordinal()])
    {
    default: 
      return;
    case 1: 
      debug(paramString1, paramString2);
      return;
    }
    internal(paramString1, paramString2, paramThrowable);
  }
  
  public static INTERNAL_LOG_LEVEL getLogLevel()
  {
    return debugLevel;
  }
  
  public static INTERNAL_LOG_LEVEL getLogLevelValue(long paramLong)
  {
    if (paramLong == 2L) {
      return INTERNAL_LOG_LEVEL.INTERNAL;
    }
    if (paramLong == 1L) {
      return INTERNAL_LOG_LEVEL.DEBUG;
    }
    return INTERNAL_LOG_LEVEL.NONE;
  }
  
  public static void internal(String paramString1, String paramString2)
  {
    if ((debugLevel.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue()) || ((debugLevel == INTERNAL_LOG_LEVEL.NOT_SET) && (CommonsConfig.b.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue())))
    {
      StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
      android.util.Log.v(paramString1, localStackTraceElement.getFileName() + ": " + localStackTraceElement.getMethodName() + " " + paramString2);
    }
  }
  
  public static void internal(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((debugLevel.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue()) || ((debugLevel == INTERNAL_LOG_LEVEL.NOT_SET) && (CommonsConfig.b.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue())))
    {
      StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
      android.util.Log.e(paramString1, localStackTraceElement.getFileName() + ": " + localStackTraceElement.getMethodName() + " " + paramString2, paramThrowable);
    }
  }
  
  public static void setInternalLogLevel(INTERNAL_LOG_LEVEL paramINTERNAL_LOG_LEVEL)
  {
    debugLevel = paramINTERNAL_LOG_LEVEL;
    if (debugLevel == INTERNAL_LOG_LEVEL.INTERNAL) {
      com.inmobi.commons.thinICE.icedatacollector.BuildSettings.DEBUG = true;
    }
  }
  
  public static enum INTERNAL_LOG_LEVEL
  {
    private final int a;
    
    static
    {
      NONE = new INTERNAL_LOG_LEVEL("NONE", 1, 0);
    }
    
    private INTERNAL_LOG_LEVEL(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getValue()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/internal/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */