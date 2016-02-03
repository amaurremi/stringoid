package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.eg.a;
import java.util.List;
import java.util.Map;

class c
  implements b
{
  private Context mContext;
  private ServiceConnection sj;
  private b sk;
  private c sl;
  private eg sm;
  
  public c(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    if (paramb == null) {
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    }
    this.sk = paramb;
    if (paramc == null) {
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    this.sl = paramc;
  }
  
  private eg bS()
  {
    bT();
    return this.sm;
  }
  
  private void bU()
  {
    bV();
  }
  
  private void bV()
  {
    this.sk.onConnected();
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<ef> paramList)
  {
    try
    {
      bS().a(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException paramMap)
    {
      aa.w("sendHit failed: " + paramMap);
    }
  }
  
  public void bR()
  {
    try
    {
      bS().bR();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.w("clear hits failed: " + localRemoteException);
    }
  }
  
  protected void bT()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void connect()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", this.mContext.getPackageName());
    if (this.sj != null) {
      aa.w("Calling connect() while still connected, missing disconnect().");
    }
    boolean bool;
    do
    {
      return;
      this.sj = new a();
      bool = this.mContext.bindService(localIntent, this.sj, 129);
      aa.y("connect: bindService returned " + bool + " for " + localIntent);
    } while (bool);
    this.sj = null;
    this.sl.a(1, null);
  }
  
  public void disconnect()
  {
    this.sm = null;
    if (this.sj != null) {}
    try
    {
      this.mContext.unbindService(this.sj);
      this.sj = null;
      this.sk.onDisconnected();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  public boolean isConnected()
  {
    return this.sm != null;
  }
  
  final class a
    implements ServiceConnection
  {
    a() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      aa.y("service connected, binder: " + paramIBinder);
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          aa.y("bound to service");
          c.a(c.this, eg.a.t(paramIBinder));
          c.a(c.this);
          return;
        }
      }
      catch (RemoteException paramComponentName)
      {
        c.b(c.this).unbindService(this);
        c.a(c.this, null);
        c.c(c.this).a(2, null);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      aa.y("service disconnected: " + paramComponentName);
      c.a(c.this, null);
      c.d(c.this).onDisconnected();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onConnected();
    
    public abstract void onDisconnected();
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, Intent paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */