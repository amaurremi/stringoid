package com.google.analytics.tracking.android;

import java.util.Map;

abstract interface TrackerHandler
{
  public abstract void closeTracker(Tracker paramTracker);
  
  public abstract void sendHit(Map<String, String> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/TrackerHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */