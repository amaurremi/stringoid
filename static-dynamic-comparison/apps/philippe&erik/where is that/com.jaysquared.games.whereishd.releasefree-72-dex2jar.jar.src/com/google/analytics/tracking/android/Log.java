package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;

public class Log
{
  private static GoogleAnalytics sGaInstance;
  
  @VisibleForTesting
  static void clearGaInstance()
  {
    sGaInstance = null;
  }
  
  public static void e(Exception paramException)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.error(paramException);
    }
  }
  
  public static void e(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.error(paramString);
    }
  }
  
  private static Logger getLogger()
  {
    if (sGaInstance == null) {
      sGaInstance = GoogleAnalytics.getInstance();
    }
    if (sGaInstance != null) {
      return sGaInstance.getLogger();
    }
    return null;
  }
  
  public static void i(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.info(paramString);
    }
  }
  
  public static boolean isVerbose()
  {
    if (getLogger() != null) {
      return Logger.LogLevel.VERBOSE.equals(getLogger().getLogLevel());
    }
    return false;
  }
  
  public static void v(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.verbose(paramString);
    }
  }
  
  public static void w(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.warn(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */