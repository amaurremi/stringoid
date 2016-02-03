package com.google.analytics.tracking.android;

public abstract class ServiceManager
{
  @Deprecated
  public abstract void dispatchLocalHits();
  
  abstract void onRadioPowered();
  
  @Deprecated
  public abstract void setForceLocalDispatch();
  
  @Deprecated
  public abstract void setLocalDispatchPeriod(int paramInt);
  
  abstract void updateConnectivityStatus(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/ServiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */