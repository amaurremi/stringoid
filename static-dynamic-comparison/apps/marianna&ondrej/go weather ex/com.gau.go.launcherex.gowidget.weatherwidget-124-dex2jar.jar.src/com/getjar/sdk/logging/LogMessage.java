package com.getjar.sdk.logging;

import java.util.Locale;

public class LogMessage
{
  private final long _areas;
  private final int _level;
  private final String _message;
  private final Throwable _throwable;
  private final long _timestamp;
  
  public LogMessage(int paramInt, long paramLong, String paramString)
  {
    this(paramInt, paramLong, paramString, null);
  }
  
  public LogMessage(int paramInt, long paramLong, String paramString, Throwable paramThrowable)
  {
    if ((paramInt != 7) && (paramInt != 3) && (paramInt != 6) && (paramInt != 4) && (paramInt != 2) && (paramInt != 5)) {
      throw new IllegalArgumentException(String.format(Locale.US, "Unsupported log level: %1$d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("'area' cannot be less than or equal to 0");
    }
    if (paramString == null) {
      throw new IllegalArgumentException("'message' cannot be NULL");
    }
    this._level = paramInt;
    this._areas = paramLong;
    this._message = paramString;
    this._throwable = paramThrowable;
    this._timestamp = System.currentTimeMillis();
  }
  
  public long getAreas()
  {
    return this._areas;
  }
  
  public int getLevel()
  {
    return this._level;
  }
  
  public String getMessage()
  {
    return this._message;
  }
  
  public Throwable getThrowable()
  {
    return this._throwable;
  }
  
  public long getTimestamp()
  {
    return this._timestamp;
  }
  
  public String toString()
  {
    if (this._throwable == null) {
      return String.format(Locale.US, "%1$s:%2$s:%3$s", new Object[] { Logger.levelToName(getLevel()), Area.toString(getAreas()), getMessage() });
    }
    return String.format(Locale.US, "%1$s:%2$s:%3$s:%4$s", new Object[] { Logger.levelToName(getLevel()), Area.toString(getAreas()), getMessage(), Logger.getThrowableDump(this._throwable) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/logging/LogMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */