package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;

public class hd$a$a
  implements ServiceConnection
{
  public hd$a$a(hd.a parama) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (hd.a(this.GF.a))
    {
      hd.a.a(this.GF, paramIBinder);
      hd.a.a(this.GF, paramComponentName);
      Iterator localIterator = hd.a.a(this.GF).iterator();
      if (localIterator.hasNext()) {
        ((oq)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    hd.a.a(this.GF, 1);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (hd.a(this.GF.a))
    {
      hd.a.a(this.GF, null);
      hd.a.a(this.GF, paramComponentName);
      Iterator localIterator = hd.a.a(this.GF).iterator();
      if (localIterator.hasNext()) {
        ((oq)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
    }
    hd.a.a(this.GF, 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hd$a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */