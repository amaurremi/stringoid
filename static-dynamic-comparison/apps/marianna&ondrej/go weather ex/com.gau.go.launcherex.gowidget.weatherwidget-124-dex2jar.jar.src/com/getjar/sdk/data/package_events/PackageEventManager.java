package com.getjar.sdk.data.package_events;

import android.content.Context;
import com.getjar.sdk.comm.CommContext;

public class PackageEventManager
{
  private static volatile PackageEventManager _Instance = null;
  private volatile Object _eventLock = new Object();
  
  private PackageEventManager(Context paramContext)
  {
    PackageEventDatabase.initialize(paramContext);
  }
  
  public static PackageEventManager getInstance(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("'context' cannot be NULL");
      }
      finally {}
    }
    if (_Instance == null) {
      _Instance = new PackageEventManager(paramContext);
    }
    paramContext = _Instance;
    return paramContext;
  }
  
  public void logEvent(String paramString, EventType paramEventType)
  {
    synchronized (this._eventLock)
    {
      PackageEventDatabase.getInstance().addRecord(paramString, paramEventType);
      return;
    }
  }
  
  public void sendUnsyncedEvents(CommContext paramCommContext)
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' cannot be NULL");
    }
    synchronized (this._eventLock)
    {
      PackageEventReporter.getInstance(paramCommContext).sendUnsyncedData();
      return;
    }
  }
  
  public static enum EventType
  {
    INSTALLED,  UNINSTALLED;
    
    private EventType() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/package_events/PackageEventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */