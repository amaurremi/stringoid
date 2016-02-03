package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import com.google.android.gms.analytics.internal.IAnalyticsService.Stub;
import java.util.List;
import java.util.Map;

class AnalyticsGmsCoreClient
  implements AnalyticsClient
{
  private static final int BIND_ADJUST_WITH_ACTIVITY = 128;
  public static final int BIND_FAILED = 1;
  public static final String KEY_APP_PACKAGE_NAME = "app_package_name";
  public static final int REMOTE_EXECUTION_FAILED = 2;
  static final String SERVICE_ACTION = "com.google.android.gms.analytics.service.START";
  private static final String SERVICE_DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
  private ServiceConnection connection;
  private Context context;
  private OnConnectedListener onConnectedListener;
  private OnConnectionFailedListener onConnectionFailedListener;
  private IAnalyticsService service;
  
  public AnalyticsGmsCoreClient(Context paramContext, OnConnectedListener paramOnConnectedListener, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.context = paramContext;
    this.onConnectedListener = paramOnConnectedListener;
    this.onConnectionFailedListener = paramOnConnectionFailedListener;
  }
  
  private IAnalyticsService getService()
  {
    checkConnected();
    return this.service;
  }
  
  private void onConnectionSuccess()
  {
    this.onConnectedListener.onConnected();
  }
  
  private void onServiceBound()
  {
    onConnectionSuccess();
  }
  
  protected void checkConnected()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void clearHits()
  {
    try
    {
      getService().clearHits();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("clear hits failed: " + localRemoteException);
    }
  }
  
  public void connect()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.putExtra("app_package_name", this.context.getPackageName());
    if (this.connection != null) {
      Log.e("Calling connect() while still connected, missing disconnect().");
    }
    boolean bool;
    do
    {
      return;
      this.connection = new AnalyticsServiceConnection();
      bool = this.context.bindService(localIntent, this.connection, 129);
      Log.iDebug("connect: bindService returned " + bool + " for " + localIntent);
    } while (bool);
    this.connection = null;
    this.onConnectionFailedListener.onConnectionFailed(1, null);
  }
  
  public void disconnect()
  {
    this.service = null;
    if (this.connection != null)
    {
      this.context.unbindService(this.connection);
      this.connection = null;
      this.onConnectedListener.onDisconnected();
    }
  }
  
  public boolean isConnected()
  {
    return this.service != null;
  }
  
  public void sendHit(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    try
    {
      getService().sendHit(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException paramMap)
    {
      Log.e("sendHit failed: " + paramMap);
    }
  }
  
  final class AnalyticsServiceConnection
    implements ServiceConnection
  {
    AnalyticsServiceConnection() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      Log.dDebug("service connected, binder: " + paramIBinder);
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          Log.dDebug("bound to service");
          AnalyticsGmsCoreClient.access$002(AnalyticsGmsCoreClient.this, IAnalyticsService.Stub.asInterface(paramIBinder));
          AnalyticsGmsCoreClient.this.onServiceBound();
          return;
        }
      }
      catch (RemoteException paramComponentName)
      {
        AnalyticsGmsCoreClient.this.context.unbindService(this);
        AnalyticsGmsCoreClient.access$302(AnalyticsGmsCoreClient.this, null);
        AnalyticsGmsCoreClient.this.onConnectionFailedListener.onConnectionFailed(2, null);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      Log.dDebug("service disconnected: " + paramComponentName);
      AnalyticsGmsCoreClient.access$302(AnalyticsGmsCoreClient.this, null);
      AnalyticsGmsCoreClient.this.onConnectedListener.onDisconnected();
    }
  }
  
  public static abstract interface OnConnectedListener
  {
    public abstract void onConnected();
    
    public abstract void onDisconnected();
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(int paramInt, Intent paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/AnalyticsGmsCoreClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */