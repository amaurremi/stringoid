package com.getjar.sdk.logging;

import android.content.Context;
import android.util.Log;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import java.util.Locale;

public class LogCatAppender
  extends AppenderBase
{
  private static Object _ConfigurationLock = new Object();
  private static LogCatAppender _Instance = null;
  private static Object _InstanceLock = new Object();
  private static String _PACKAGE_NAME = null;
  
  private LogCatAppender()
  {
    super(true, 2, Area.ALL.value());
  }
  
  protected static LogCatAppender getInstance()
  {
    if (_Instance == null) {}
    synchronized (_InstanceLock)
    {
      if (_Instance == null) {
        _Instance = new LogCatAppender();
      }
      return _Instance;
    }
  }
  
  public void configureAppender(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL or empty");
    }
    logInternal(2, "LogCatAppender: configureAppender() START");
    localObject1 = _ConfigurationLock;
    try
    {
      if (_PACKAGE_NAME == null)
      {
        _PACKAGE_NAME = paramContext.getPackageName();
        _TAG = String.format(Locale.US, "%1$s [%2$s]", new Object[] { _TAG, _PACKAGE_NAME });
      }
      logInternal(2, "LogCatAppender: configureAppender() GetJarConfig.getInstance() start");
      Object localObject2 = GetJarConfig.getInstance(paramContext.getApplicationContext());
      logInternal(2, "LogCatAppender: configureAppender() GetJarConfig.getInstance() finished");
      boolean bool = ((GetJarConfig)localObject2).getBooleanValue("logging.logcat.enabled", Boolean.valueOf(true), SettingsManager.Scope.CLIENT).booleanValue();
      logInternal(2, String.format(Locale.US, "LogCatAppender: configureAppender() got enabled = %1$s", new Object[] { Boolean.valueOf(bool) }));
      paramContext = ((GetJarConfig)localObject2).getDirectiveValue("logging.logcat.level", "VERBOSE", SettingsManager.Scope.CLIENT);
      logInternal(2, String.format(Locale.US, "LogCatAppender: configureAppender() got levelStr = %1$s", new Object[] { paramContext }));
      localObject2 = ((GetJarConfig)localObject2).getDirectiveValue("logging.logcat.areas", Area.ALL.name(), SettingsManager.Scope.CLIENT);
      logInternal(2, String.format(Locale.US, "LogCatAppender: configureAppender() got areasStr = %1$s", new Object[] { localObject2 }));
      logInternal(2, "LogCatAppender: configureAppender() calling AppenderBase.configureAppender()");
      super.configureAppender(bool, paramContext, (String)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException = localException;
        logInternal(6, "configureAppender() failed to update the logging TAG with the package name", localException);
      }
    }
    finally
    {
      logInternal(2, "LogCatAppender: configureAppender() FINISHED");
    }
  }
  
  public void log(LogMessage paramLogMessage)
  {
    if (paramLogMessage == null) {
      throw new IllegalArgumentException("'logMessage' cannot be NULL");
    }
    int i = paramLogMessage.getLevel();
    if (shouldLog(i, paramLogMessage.getAreas())) {}
    switch (i)
    {
    default: 
      throw new IllegalArgumentException(String.format(Locale.US, "Unsupported log level [level:%1$d]", new Object[] { Integer.valueOf(paramLogMessage.getLevel()) }));
    case 2: 
      if (paramLogMessage.getThrowable() == null)
      {
        Log.v(_TAG, paramLogMessage.getMessage());
        return;
      }
      Log.v(_TAG, paramLogMessage.getMessage(), paramLogMessage.getThrowable());
      return;
    case 3: 
      if (paramLogMessage.getThrowable() == null)
      {
        Log.d(_TAG, paramLogMessage.getMessage());
        return;
      }
      Log.d(_TAG, paramLogMessage.getMessage(), paramLogMessage.getThrowable());
      return;
    case 4: 
      if (paramLogMessage.getThrowable() == null)
      {
        Log.i(_TAG, paramLogMessage.getMessage());
        return;
      }
      Log.i(_TAG, paramLogMessage.getMessage(), paramLogMessage.getThrowable());
      return;
    case 5: 
      if (paramLogMessage.getThrowable() == null)
      {
        Log.w(_TAG, paramLogMessage.getMessage());
        return;
      }
      Log.w(_TAG, paramLogMessage.getMessage(), paramLogMessage.getThrowable());
      return;
    }
    if (paramLogMessage.getThrowable() == null)
    {
      Log.e(_TAG, paramLogMessage.getMessage());
      return;
    }
    Log.e(_TAG, paramLogMessage.getMessage(), paramLogMessage.getThrowable());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/logging/LogCatAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */