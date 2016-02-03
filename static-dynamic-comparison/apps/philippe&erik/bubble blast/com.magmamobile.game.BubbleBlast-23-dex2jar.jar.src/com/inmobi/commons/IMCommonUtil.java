package com.inmobi.commons;

import com.inmobi.commons.internal.IMLog;
import com.inmobi.commons.internal.IMLog.INTERNAL_LOG_LEVEL;

public class IMCommonUtil
{
  public static final int DEVICE_ID_EXCLUDE_ODIN1 = 2;
  public static final int DEVICE_ID_INCLUDE_DEFAULT = 1;
  private static int a = 1;
  
  public static int getDeviceIdMask()
  {
    return a;
  }
  
  public static LOG_LEVEL getLogLevel()
  {
    if (IMLog.getLogLevel().equals(IMLog.INTERNAL_LOG_LEVEL.NONE)) {
      return LOG_LEVEL.NONE;
    }
    return LOG_LEVEL.DEBUG;
  }
  
  public static String getReleaseVersion()
  {
    return "3.6.1";
  }
  
  public static void setDeviceIDMask(int paramInt)
  {
    a = paramInt;
  }
  
  public static void setLogLevel(LOG_LEVEL paramLOG_LEVEL)
  {
    if (paramLOG_LEVEL == LOG_LEVEL.NONE)
    {
      IMLog.setInternalLogLevel(IMLog.INTERNAL_LOG_LEVEL.NONE);
      return;
    }
    IMLog.setInternalLogLevel(IMLog.INTERNAL_LOG_LEVEL.DEBUG);
  }
  
  public static enum LOG_LEVEL
  {
    private final int a;
    
    private LOG_LEVEL(int paramInt1)
    {
      this.a = paramInt1;
    }
    
    int a()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/commons/IMCommonUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */