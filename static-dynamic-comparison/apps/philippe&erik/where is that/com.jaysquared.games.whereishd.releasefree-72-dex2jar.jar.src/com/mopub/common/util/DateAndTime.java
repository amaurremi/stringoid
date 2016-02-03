package com.mopub.common.util;

import java.util.Date;
import java.util.TimeZone;

public class DateAndTime
{
  protected static DateAndTime instance = new DateAndTime();
  
  public static TimeZone localTimeZone()
  {
    return instance.internalLocalTimeZone();
  }
  
  public static Date now()
  {
    return instance.internalNow();
  }
  
  @Deprecated
  public static void setInstance(DateAndTime paramDateAndTime)
  {
    instance = paramDateAndTime;
  }
  
  public TimeZone internalLocalTimeZone()
  {
    return TimeZone.getDefault();
  }
  
  public Date internalNow()
  {
    return new Date();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/DateAndTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */