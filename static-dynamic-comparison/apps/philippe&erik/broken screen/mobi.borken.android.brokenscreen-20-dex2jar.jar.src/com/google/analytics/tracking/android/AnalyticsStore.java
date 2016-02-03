package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.Collection;
import java.util.Map;

abstract interface AnalyticsStore
{
  public abstract void clearHits(long paramLong);
  
  public abstract void close();
  
  public abstract void dispatch();
  
  public abstract Dispatcher getDispatcher();
  
  public abstract void putHit(Map<String, String> paramMap, long paramLong, String paramString, Collection<Command> paramCollection);
  
  public abstract void setDispatch(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/AnalyticsStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */