package com.google.analytics.tracking.android;

import java.util.List;

abstract interface Dispatcher
{
  public abstract int dispatchHits(List<Hit> paramList);
  
  public abstract boolean okToDispatch();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */