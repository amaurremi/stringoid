package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.HashMap;

public final class ab
  implements Handler.Callback
{
  private static final Object a = new Object();
  private static ab b;
  private final Context c;
  private final HashMap d = new HashMap();
  private final Handler e = new Handler(paramContext.getMainLooper(), this);
  
  private ab(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
  }
  
  public static ab a(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null) {
        b = new ab(paramContext.getApplicationContext());
      }
      return b;
    }
  }
  
  public boolean a(String paramString, z paramz)
  {
    for (;;)
    {
      ac localac;
      synchronized (this.d)
      {
        localac = (ac)this.d.get(paramString);
        if (localac == null)
        {
          localac = new ac(this, paramString);
          localac.a(paramz);
          paramz = new Intent(paramString).setPackage("com.google.android.gms");
          localac.a(this.c.bindService(paramz, localac.a(), 129));
          this.d.put(paramString, localac);
          paramString = localac;
          boolean bool = paramString.c();
          return bool;
        }
        this.e.removeMessages(0, localac);
        if (localac.c(paramz)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + paramString);
        }
      }
      localac.a(paramz);
      switch (localac.d())
      {
      case 1: 
        paramz.onServiceConnected(localac.g(), localac.f());
        paramString = localac;
        break;
      case 2: 
        paramString = new Intent(paramString).setPackage("com.google.android.gms");
        localac.a(this.c.bindService(paramString, localac.a(), 129));
        paramString = localac;
        break;
      default: 
        paramString = localac;
      }
    }
  }
  
  public void b(String paramString, z paramz)
  {
    ac localac;
    synchronized (this.d)
    {
      localac = (ac)this.d.get(paramString);
      if (localac == null) {
        throw new IllegalStateException("Nonexistent connection status for service action: " + paramString);
      }
    }
    if (!localac.c(paramz)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + paramString);
    }
    localac.b(paramz);
    if (localac.e())
    {
      paramString = this.e.obtainMessage(0, localac);
      this.e.sendMessageDelayed(paramString, 5000L);
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return false;
    }
    ac localac = (ac)???.obj;
    synchronized (this.d)
    {
      if (localac.e())
      {
        this.c.unbindService(localac.a());
        this.d.remove(localac.b());
      }
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */