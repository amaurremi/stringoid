package com.venticake.retrica.view.album;

public abstract interface MonitoredActivity$LifeCycleListener
{
  public abstract void onActivityCreated(MonitoredActivity paramMonitoredActivity);
  
  public abstract void onActivityDestroyed(MonitoredActivity paramMonitoredActivity);
  
  public abstract void onActivityPaused(MonitoredActivity paramMonitoredActivity);
  
  public abstract void onActivityResumed(MonitoredActivity paramMonitoredActivity);
  
  public abstract void onActivityStarted(MonitoredActivity paramMonitoredActivity);
  
  public abstract void onActivityStopped(MonitoredActivity paramMonitoredActivity);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MonitoredActivity$LifeCycleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */