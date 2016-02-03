package com.google.android.b.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class at
  implements ServiceConnection
{
  at(ao paramao) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.b(paramIBinder);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    ao.a(this.a, null);
    this.a.h();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */