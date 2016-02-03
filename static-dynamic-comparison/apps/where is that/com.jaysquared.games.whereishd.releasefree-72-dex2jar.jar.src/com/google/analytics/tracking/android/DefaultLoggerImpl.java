package com.google.analytics.tracking.android;

import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

class DefaultLoggerImpl
  implements Logger
{
  @VisibleForTesting
  static final String LOG_TAG = "GAV3";
  private Logger.LogLevel mLogLevel = Logger.LogLevel.INFO;
  
  private String formatMessage(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }
  
  public void error(Exception paramException)
  {
    if (this.mLogLevel.ordinal() <= Logger.LogLevel.ERROR.ordinal()) {
      Log.e("GAV3", null, paramException);
    }
  }
  
  public void error(String paramString)
  {
    if (this.mLogLevel.ordinal() <= Logger.LogLevel.ERROR.ordinal()) {
      Log.e("GAV3", formatMessage(paramString));
    }
  }
  
  public Logger.LogLevel getLogLevel()
  {
    return this.mLogLevel;
  }
  
  public void info(String paramString)
  {
    if (this.mLogLevel.ordinal() <= Logger.LogLevel.INFO.ordinal()) {
      Log.i("GAV3", formatMessage(paramString));
    }
  }
  
  public void setLogLevel(Logger.LogLevel paramLogLevel)
  {
    this.mLogLevel = paramLogLevel;
  }
  
  public void verbose(String paramString)
  {
    if (this.mLogLevel.ordinal() <= Logger.LogLevel.VERBOSE.ordinal()) {
      Log.v("GAV3", formatMessage(paramString));
    }
  }
  
  public void warn(String paramString)
  {
    if (this.mLogLevel.ordinal() <= Logger.LogLevel.WARNING.ordinal()) {
      Log.w("GAV3", formatMessage(paramString));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/DefaultLoggerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */