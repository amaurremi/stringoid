package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.HashMap;

public final class hd
  implements Handler.Callback
{
  private static final Object Gv = new Object();
  private static hd Gw;
  private final HashMap<String, hd.a> Gx = new HashMap();
  private final Context lz;
  private final Handler mHandler = new Handler(paramContext.getMainLooper(), this);
  
  private hd(Context paramContext)
  {
    this.lz = paramContext.getApplicationContext();
  }
  
  public static hd E(Context paramContext)
  {
    synchronized (Gv)
    {
      if (Gw == null) {
        Gw = new hd(paramContext.getApplicationContext());
      }
      return Gw;
    }
  }
  
  public boolean a(String paramString, hb<?>.oq paramhb)
  {
    for (;;)
    {
      hd.a locala;
      synchronized (this.Gx)
      {
        locala = (hd.a)this.Gx.get(paramString);
        if (locala == null)
        {
          locala = new hd.a(this, paramString);
          locala.a(paramhb);
          paramhb = new Intent(paramString).setPackage("com.google.android.gms");
          locala.a(this.lz.bindService(paramhb, locala.a(), 129));
          this.Gx.put(paramString, locala);
          paramString = locala;
          boolean bool = paramString.c();
          return bool;
        }
        this.mHandler.removeMessages(0, locala);
        if (locala.c(paramhb)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + paramString);
        }
      }
      locala.a(paramhb);
      switch (locala.d())
      {
      case 1: 
        paramhb.onServiceConnected(locala.g(), locala.f());
        paramString = locala;
        break;
      case 2: 
        paramString = new Intent(paramString).setPackage("com.google.android.gms");
        locala.a(this.lz.bindService(paramString, locala.a(), 129));
        paramString = locala;
        break;
      default: 
        paramString = locala;
      }
    }
  }
  
  public void b(String paramString, hb<?>.oq paramhb)
  {
    hd.a locala;
    synchronized (this.Gx)
    {
      locala = (hd.a)this.Gx.get(paramString);
      if (locala == null) {
        throw new IllegalStateException("Nonexistent connection status for service action: " + paramString);
      }
    }
    if (!locala.c(paramhb)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + paramString);
    }
    locala.b(paramhb);
    if (locala.e())
    {
      paramString = this.mHandler.obtainMessage(0, locala);
      this.mHandler.sendMessageDelayed(paramString, 5000L);
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return false;
    }
    hd.a locala = (hd.a)???.obj;
    synchronized (this.Gx)
    {
      if (locala.e())
      {
        this.lz.unbindService(locala.a());
        this.Gx.remove(locala.b());
      }
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */