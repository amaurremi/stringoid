package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

abstract interface ServiceProxy
{
  public abstract void clearHits();
  
  public abstract void createService();
  
  public abstract void dispatch();
  
  public abstract void putHit(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList);
  
  public abstract void setForceLocalDispatch();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/ServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */