package com.getjar.sdk.logging;

import android.content.Context;

abstract interface AppenderInterface
{
  public abstract void configureAppender(Context paramContext);
  
  public abstract long getAreas();
  
  public abstract int getLevel();
  
  public abstract boolean isAreaActive(long paramLong);
  
  public abstract boolean isEnabled();
  
  public abstract boolean isLevelActive(int paramInt);
  
  public abstract void log(LogMessage paramLogMessage);
  
  public abstract boolean shouldLog(int paramInt, long paramLong);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/logging/AppenderInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */