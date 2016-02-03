package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.analytics.internal.a.a;
import java.util.List;
import java.util.Map;

class b
  implements a
{
  private ServiceConnection hJ;
  private b hK;
  private c hL;
  private com.google.android.gms.analytics.internal.a hM;
  private Context mContext;
  
  public b(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    if (paramb == null) {
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    }
    this.hK = paramb;
    if (paramc == null) {
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    this.hL = paramc;
  }
  
  private com.google.android.gms.analytics.internal.a jj()
  {
    jk();
    return this.hM;
  }
  
  private void jl()
  {
    jm();
  }
  
  private void jm()
  {
    this.hK.onConnected();
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    try
    {
      jj().a(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException paramMap)
    {
      v.A("sendHit failed: " + paramMap);
    }
  }
  
  public void connect()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", this.mContext.getPackageName());
    if (this.hJ != null) {
      v.A("Calling connect() while still connected, missing disconnect().");
    }
    boolean bool;
    do
    {
      return;
      this.hJ = new a();
      bool = this.mContext.bindService(localIntent, this.hJ, 129);
      v.C("connect: bindService returned " + bool + " for " + localIntent);
    } while (bool);
    this.hJ = null;
    this.hL.a(1, null);
  }
  
  public void disconnect()
  {
    this.hM = null;
    if (this.hJ != null) {}
    try
    {
      this.mContext.unbindService(this.hJ);
      this.hJ = null;
      this.hK.onDisconnected();
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
    return this.hM != null;
  }
  
  public void ji()
  {
    try
    {
      jj().ji();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      v.A("clear hits failed: " + localRemoteException);
    }
  }
  
  protected void jk()
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
      v.C("service connected, binder: " + paramIBinder);
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          v.C("bound to service");
          b.a(b.this, a.a.b(paramIBinder));
          b.a(b.this);
          return;
        }
      }
      catch (RemoteException paramComponentName)
      {
        b.b(b.this).unbindService(this);
        b.a(b.this, null);
        b.c(b.this).a(2, null);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      v.C("service disconnected: " + paramComponentName);
      b.a(b.this, null);
      b.d(b.this).onDisconnected();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */