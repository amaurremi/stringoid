package com.getjar.sdk.data.usage;

import android.app.Activity;

public abstract interface AnalyticsListener
{
  public abstract void endSession();
  
  public abstract void startSession(Activity paramActivity);
  
  public abstract void trackEvent(String paramString, Object... paramVarArgs);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/usage/AnalyticsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */