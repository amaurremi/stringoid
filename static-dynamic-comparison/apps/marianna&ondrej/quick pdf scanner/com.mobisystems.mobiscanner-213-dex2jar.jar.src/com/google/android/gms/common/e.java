package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class e
  implements ServiceConnection
{
  boolean qO = false;
  private final BlockingQueue<IBinder> qP = new LinkedBlockingQueue();
  
  public IBinder ml()
  {
    if (this.qO) {
      throw new IllegalStateException();
    }
    this.qO = true;
    return (IBinder)this.qP.take();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.qP.put(paramIBinder);
      return;
    }
    catch (InterruptedException paramComponentName) {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */