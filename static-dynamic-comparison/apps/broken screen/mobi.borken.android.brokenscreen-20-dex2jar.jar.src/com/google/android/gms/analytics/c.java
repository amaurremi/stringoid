package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.a;
import java.util.List;
import java.util.Map;

class c
  implements b
{
  private Context mContext;
  private ServiceConnection tu;
  private b tv;
  private c tw;
  private ff tx;
  
  public c(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    if (paramb == null) {
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    }
    this.tv = paramb;
    if (paramc == null) {
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    this.tw = paramc;
  }
  
  private ff ch()
  {
    ci();
    return this.tx;
  }
  
  private void cj()
  {
    ck();
  }
  
  private void ck()
  {
    this.tv.onConnected();
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<fe> paramList)
  {
    try
    {
      ch().a(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException paramMap)
    {
      aa.A("sendHit failed: " + paramMap);
    }
  }
  
  public void cg()
  {
    try
    {
      ch().cg();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.A("clear hits failed: " + localRemoteException);
    }
  }
  
  protected void ci()
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
    if (this.tu != null) {
      aa.A("Calling connect() while still connected, missing disconnect().");
    }
    boolean bool;
    do
    {
      return;
      this.tu = new a();
      bool = this.mContext.bindService(localIntent, this.tu, 129);
      aa.C("connect: bindService returned " + bool + " for " + localIntent);
    } while (bool);
    this.tu = null;
    this.tw.a(1, null);
  }
  
  public void disconnect()
  {
    this.tx = null;
    if (this.tu != null) {}
    try
    {
      this.mContext.unbindService(this.tu);
      this.tu = null;
      this.tv.onDisconnected();
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
    return this.tx != null;
  }
  
  final class a
    implements ServiceConnection
  {
    a() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      aa.C("service connected, binder: " + paramIBinder);
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          aa.C("bound to service");
          c.a(c.this, ff.a.z(paramIBinder));
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
      aa.C("service disconnected: " + paramComponentName);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */