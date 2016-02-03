package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class a
  implements ServiceConnection
{
  boolean Ae = false;
  private final BlockingQueue<IBinder> Af = new LinkedBlockingQueue();
  
  public IBinder dV()
    throws InterruptedException
  {
    if (this.Ae) {
      throw new IllegalStateException();
    }
    this.Ae = true;
    return (IBinder)this.Af.take();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.Af.put(paramIBinder);
      return;
    }
    catch (InterruptedException paramComponentName) {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/common/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */