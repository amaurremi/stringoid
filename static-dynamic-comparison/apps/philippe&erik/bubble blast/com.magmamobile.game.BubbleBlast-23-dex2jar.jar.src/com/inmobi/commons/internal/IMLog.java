package com.inmobi.commons.internal;

import android.util.Log;

public class IMLog
{
  protected static INTERNAL_LOG_LEVEL debugLevel = INTERNAL_LOG_LEVEL.NONE;
  
  public static void debug(String paramString1, String paramString2)
  {
    if (debugLevel.getValue() >= INTERNAL_LOG_LEVEL.DEBUG.getValue()) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void debug(String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (a()[debugLevel.ordinal()])
    {
    default: 
      return;
    case 2: 
      debug(paramString1, paramString2);
      return;
    }
    internal(paramString1, paramString2, paramThrowable);
  }
  
  public static INTERNAL_LOG_LEVEL getLogLevel()
  {
    return debugLevel;
  }
  
  public static void internal(String paramString1, String paramString2)
  {
    if (debugLevel.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue())
    {
      StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
      Log.v(paramString1, localStackTraceElement.getFileName() + ": " + localStackTraceElement.getMethodName() + " " + paramString2);
    }
  }
  
  public static void internal(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (debugLevel.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue())
    {
      StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
      Log.v(paramString1, localStackTraceElement.getFileName() + ": " + localStackTraceElement.getMethodName() + " " + paramString2, paramThrowable);
    }
  }
  
  public static void setInternalLogLevel(INTERNAL_LOG_LEVEL paramINTERNAL_LOG_LEVEL)
  {
    debugLevel = paramINTERNAL_LOG_LEVEL;
  }
  
  public static enum INTERNAL_LOG_LEVEL
  {
    private final int a;
    
    private INTERNAL_LOG_LEVEL(int paramInt1)
    {
      this.a = paramInt1;
    }
    
    public int getValue()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/commons/internal/IMLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */