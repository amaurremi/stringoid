package com.getjar.sdk.logging;

import android.util.Log;
import com.getjar.sdk.utilities.StringUtility;
import java.util.Locale;

abstract class AppenderBase
  implements AppenderInterface
{
  protected static String _TAG = "GetJar SDK";
  private volatile long _areas;
  private volatile boolean _enabled;
  private volatile int _level;
  
  protected AppenderBase(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("'areas' cannot be zero or less");
    }
    this._enabled = paramBoolean;
    this._level = paramInt;
    this._areas = paramLong;
  }
  
  private static int getLogLevelFromString(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'logLevelString' cannot be NULL or empty");
    }
    if (paramString.equalsIgnoreCase("ASSERT")) {
      return 7;
    }
    if (paramString.equalsIgnoreCase("DEBUG")) {
      return 3;
    }
    if (paramString.equalsIgnoreCase("ERROR")) {
      return 6;
    }
    if (paramString.equalsIgnoreCase("INFO")) {
      return 4;
    }
    if (paramString.equalsIgnoreCase("VERBOSE")) {
      return 2;
    }
    if (paramString.equalsIgnoreCase("WARN")) {
      return 5;
    }
    throw new IllegalArgumentException(String.format(Locale.US, "Unsupported log level [%1$s]", new Object[] { paramString }));
  }
  
  private static long parseAreas(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'areasString' cannot be NULL or empty");
    }
    long l = 0L;
    paramString = paramString.split("\\|");
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      String str = paramString[i];
      if (StringUtility.isNullOrEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        l |= Area.valueOf(str).value();
      }
    }
    if (l == 0L) {
      throw new IllegalStateException("parseAreas() failed to parse any recognized area values");
    }
    return l;
  }
  
  protected void configureAppender(boolean paramBoolean, String paramString1, String paramString2)
  {
    int i = getLogLevelFromString(paramString1);
    long l = parseAreas(paramString2);
    this._enabled = paramBoolean;
    this._level = i;
    this._areas = l;
    Log.d(_TAG, String.format(Locale.US, "%1$s|%2$s: AppenderBase: configureAppender() Appender %3$s configured [enabled=%4$s level=%5$s areas=%6$s]", new Object[] { Area.LOGGING.name(), Area.CONFIG.name(), getClass().getName(), Boolean.valueOf(paramBoolean), paramString1, paramString2 }));
  }
  
  public long getAreas()
  {
    return this._areas;
  }
  
  public int getLevel()
  {
    return this._level;
  }
  
  public boolean isAreaActive(long paramLong)
  {
    return Area.areasOverlap(this._areas, paramLong);
  }
  
  public boolean isEnabled()
  {
    return this._enabled;
  }
  
  public boolean isLevelActive(int paramInt)
  {
    return this._level <= paramInt;
  }
  
  protected void logInternal(int paramInt, String paramString)
  {
    logInternal(paramInt, paramString, null);
  }
  
  protected void logInternal(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (isLevelActive(paramInt)) {
      paramString = String.format(Locale.US, "%1$s: %2$s", new Object[] { Area.LOGGING.name(), paramString });
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(String.format(Locale.US, "Unsupported log level [level:%1$d]", new Object[] { Integer.valueOf(paramInt) }));
    case 2: 
      if (paramThrowable == null)
      {
        Log.v(_TAG, paramString);
        return;
      }
      Log.v(_TAG, paramString, paramThrowable);
      return;
    case 3: 
      if (paramThrowable == null)
      {
        Log.d(_TAG, paramString);
        return;
      }
      Log.d(_TAG, paramString, paramThrowable);
      return;
    case 4: 
      if (paramThrowable == null)
      {
        Log.i(_TAG, paramString);
        return;
      }
      Log.i(_TAG, paramString, paramThrowable);
      return;
    case 5: 
      if (paramThrowable == null)
      {
        Log.w(_TAG, paramString);
        return;
      }
      Log.w(_TAG, paramString, paramThrowable);
      return;
    }
    if (paramThrowable == null)
    {
      Log.e(_TAG, paramString);
      return;
    }
    Log.e(_TAG, paramString, paramThrowable);
  }
  
  public boolean shouldLog(int paramInt, long paramLong)
  {
    return (this._level <= paramInt) && (Area.areasOverlap(this._areas, paramLong));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/logging/AppenderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */