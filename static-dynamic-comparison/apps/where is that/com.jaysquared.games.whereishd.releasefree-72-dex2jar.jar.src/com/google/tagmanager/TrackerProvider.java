package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.common.util.VisibleForTesting;

class TrackerProvider
{
  private Context mContext;
  private GoogleAnalytics mGoogleAnalytics;
  
  TrackerProvider(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @VisibleForTesting
  TrackerProvider(GoogleAnalytics paramGoogleAnalytics)
  {
    this.mGoogleAnalytics = paramGoogleAnalytics;
    this.mGoogleAnalytics.setLogger(new LoggerImpl());
  }
  
  private void initTrackProviderIfNecessary()
  {
    try
    {
      if (this.mGoogleAnalytics == null)
      {
        this.mGoogleAnalytics = GoogleAnalytics.getInstance(this.mContext);
        this.mGoogleAnalytics.setLogger(new LoggerImpl());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close(Tracker paramTracker)
  {
    this.mGoogleAnalytics.closeTracker(paramTracker.getName());
  }
  
  public Tracker getTracker(String paramString)
  {
    initTrackProviderIfNecessary();
    return this.mGoogleAnalytics.getTracker(paramString);
  }
  
  static class LoggerImpl
    implements Logger
  {
    private static com.google.analytics.tracking.android.Logger.LogLevel toAnalyticsLogLevel(Logger.LogLevel paramLogLevel)
    {
      switch (TrackerProvider.1.$SwitchMap$com$google$tagmanager$Logger$LogLevel[paramLogLevel.ordinal()])
      {
      default: 
        return com.google.analytics.tracking.android.Logger.LogLevel.ERROR;
      case 1: 
      case 2: 
        return com.google.analytics.tracking.android.Logger.LogLevel.ERROR;
      case 3: 
        return com.google.analytics.tracking.android.Logger.LogLevel.WARNING;
      case 4: 
      case 5: 
        return com.google.analytics.tracking.android.Logger.LogLevel.INFO;
      }
      return com.google.analytics.tracking.android.Logger.LogLevel.VERBOSE;
    }
    
    public void error(Exception paramException)
    {
      Log.e("", paramException);
    }
    
    public void error(String paramString)
    {
      Log.e(paramString);
    }
    
    public com.google.analytics.tracking.android.Logger.LogLevel getLogLevel()
    {
      Logger.LogLevel localLogLevel = Log.getLogLevel();
      if (localLogLevel == null) {
        return com.google.analytics.tracking.android.Logger.LogLevel.ERROR;
      }
      return toAnalyticsLogLevel(localLogLevel);
    }
    
    public void info(String paramString)
    {
      Log.i(paramString);
    }
    
    public void setLogLevel(com.google.analytics.tracking.android.Logger.LogLevel paramLogLevel)
    {
      Log.w("GA uses GTM logger. Please use TagManager.getLogger().setLogLevel(LogLevel) instead.");
    }
    
    public void verbose(String paramString)
    {
      Log.v(paramString);
    }
    
    public void warn(String paramString)
    {
      Log.w(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/TrackerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */