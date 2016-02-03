package com.magmamobile.game.engine;

public final class DateTimeUtils
{
  public static final long MakeTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt4 * 1000 + 60000 * paramInt3 + 3600000 * paramInt2 + 86400000 * paramInt1;
  }
  
  public static final long getDays(long paramLong)
  {
    return paramLong / 86400000L;
  }
  
  public static final long getHours(long paramLong)
  {
    return paramLong / 3600000L;
  }
  
  public static final long getMinutes(long paramLong)
  {
    return paramLong / 60000L;
  }
  
  public static final long getSeconds(long paramLong)
  {
    return paramLong / 1000L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/DateTimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */