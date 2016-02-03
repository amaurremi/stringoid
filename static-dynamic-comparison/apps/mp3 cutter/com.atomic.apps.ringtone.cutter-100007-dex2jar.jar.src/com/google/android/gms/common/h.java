package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class h
  implements ServiceConnection
{
  private boolean a = false;
  private final BlockingQueue b = new LinkedBlockingQueue();
  
  public final IBinder a()
  {
    if (this.a) {
      throw new IllegalStateException();
    }
    this.a = true;
    return (IBinder)this.b.take();
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.b.put(paramIBinder);
      return;
    }
    catch (InterruptedException paramComponentName) {}
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/common/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */