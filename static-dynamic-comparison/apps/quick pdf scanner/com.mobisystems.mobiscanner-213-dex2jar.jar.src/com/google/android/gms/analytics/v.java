package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.cl.a;
import com.google.android.gms.internal.di;
import java.util.List;
import java.util.Map;

class v
  implements t
{
  private Context mContext;
  private ServiceConnection nl;
  private b nm;
  private c nn;
  private cl no;
  
  public v(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    if (paramb == null) {
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    }
    this.nm = paramb;
    if (paramc == null) {
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    this.nn = paramc;
  }
  
  private cl le()
  {
    lf();
    return this.no;
  }
  
  private void lg()
  {
    lh();
  }
  
  private void lh()
  {
    this.nm.onConnected();
  }
  
  public void connect()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", this.mContext.getPackageName());
    if (this.nl != null) {
      j.Z("Calling connect() while still connected, missing disconnect().");
    }
    boolean bool;
    do
    {
      return;
      this.nl = new a();
      bool = this.mContext.bindService(localIntent, this.nl, 129);
      j.C("connect: bindService returned " + bool + " for " + localIntent);
    } while (bool);
    this.nl = null;
    this.nn.b(1, null);
  }
  
  public void d(Map<String, String> paramMap, long paramLong, String paramString, List<di> paramList)
  {
    try
    {
      le().d(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException paramMap)
    {
      j.Z("sendHit failed: " + paramMap);
    }
  }
  
  public void disconnect()
  {
    this.no = null;
    if (this.nl != null) {}
    try
    {
      this.mContext.unbindService(this.nl);
      this.nl = null;
      this.nm.onDisconnected();
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
    return this.no != null;
  }
  
  public void ld()
  {
    try
    {
      le().ld();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      j.Z("clear hits failed: " + localRemoteException);
    }
  }
  
  protected void lf()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  final class a
    implements ServiceConnection
  {
    a() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      j.C("service connected, binder: " + paramIBinder);
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          j.C("bound to service");
          v.a(v.this, cl.a.v(paramIBinder));
          v.a(v.this);
          return;
        }
      }
      catch (RemoteException paramComponentName)
      {
        v.b(v.this).unbindService(this);
        v.a(v.this, null);
        v.c(v.this).b(2, null);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      j.C("service disconnected: " + paramComponentName);
      v.a(v.this, null);
      v.d(v.this).onDisconnected();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onConnected();
    
    public abstract void onDisconnected();
  }
  
  public static abstract interface c
  {
    public abstract void b(int paramInt, Intent paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */