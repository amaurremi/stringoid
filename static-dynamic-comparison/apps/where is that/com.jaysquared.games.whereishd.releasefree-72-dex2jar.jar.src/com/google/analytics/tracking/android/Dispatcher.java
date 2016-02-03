package com.google.analytics.tracking.android;

import java.util.List;

abstract interface Dispatcher
{
  public abstract void close();
  
  public abstract int dispatchHits(List<Hit> paramList);
  
  public abstract boolean okToDispatch();
  
  public abstract void overrideHostUrl(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */