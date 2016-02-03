package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.internal.fd;
import com.google.android.gms.internal.fe;
import java.util.List;
import java.util.Map;

class c
  implements v
{
  private ServiceConnection a;
  private c.b b;
  private c.c c;
  private Context d;
  private fe e;
  
  public c(Context paramContext, c.b paramb, c.c paramc)
  {
    this.d = paramContext;
    if (paramb == null) {
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    }
    this.b = paramb;
    if (paramc == null) {
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    this.c = paramc;
  }
  
  private fe f()
  {
    d();
    return this.e;
  }
  
  private void g()
  {
    h();
  }
  
  private void h()
  {
    this.b.onConnected();
  }
  
  public void a()
  {
    try
    {
      f().cl();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      aa.A("clear hits failed: " + localRemoteException);
    }
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<fd> paramList)
  {
    try
    {
      f().a(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException paramMap)
    {
      aa.A("sendHit failed: " + paramMap);
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", this.d.getPackageName());
    if (this.a != null) {
      aa.A("Calling connect() while still connected, missing disconnect().");
    }
    boolean bool;
    do
    {
      return;
      this.a = new w(this);
      bool = this.d.bindService(localIntent, this.a, 129);
      aa.C("connect: bindService returned " + bool + " for " + localIntent);
    } while (bool);
    this.a = null;
    this.c.a(1, null);
  }
  
  public void c()
  {
    this.e = null;
    if (this.a != null) {}
    try
    {
      this.d.unbindService(this.a);
      this.a = null;
      this.b.onDisconnected();
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
  
  protected void d()
  {
    if (!e()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public boolean e()
  {
    return this.e != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */