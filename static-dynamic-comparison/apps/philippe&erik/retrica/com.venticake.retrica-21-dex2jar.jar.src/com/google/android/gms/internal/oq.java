package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

final class oq
  implements ServiceConnection
{
  oq(hb paramhb) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.I(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(4, Integer.valueOf(1)));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/oq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */