package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.fe.a;

final class w
  implements ServiceConnection
{
  w(c paramc) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    aa.C("service connected, binder: " + paramIBinder);
    try
    {
      if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
      {
        aa.C("bound to service");
        c.a(this.a, fe.a.z(paramIBinder));
        c.a(this.a);
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      c.b(this.a).unbindService(this);
      c.a(this.a, null);
      c.c(this.a).a(2, null);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    aa.C("service disconnected: " + paramComponentName);
    c.a(this.a, null);
    c.d(this.a).onDisconnected();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */