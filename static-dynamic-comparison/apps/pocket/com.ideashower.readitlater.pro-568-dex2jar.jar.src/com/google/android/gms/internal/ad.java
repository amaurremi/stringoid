package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;

public class ad
  implements ServiceConnection
{
  public ad(ac paramac) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (ab.a(this.a.a))
    {
      ac.a(this.a, paramIBinder);
      ac.a(this.a, paramComponentName);
      Iterator localIterator = ac.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((z)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    ac.a(this.a, 1);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (ab.a(this.a.a))
    {
      ac.a(this.a, null);
      ac.a(this.a, paramComponentName);
      Iterator localIterator = ac.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((z)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
    }
    ac.a(this.a, 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */