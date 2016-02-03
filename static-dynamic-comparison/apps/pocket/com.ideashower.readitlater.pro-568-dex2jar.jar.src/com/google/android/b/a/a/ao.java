package com.google.android.b.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.b.a.a;
import com.google.android.b.a.b;
import java.util.ArrayList;

public abstract class ao
  implements av
{
  final Handler a;
  private final Context b;
  private IInterface c;
  private ArrayList d;
  private final ArrayList e = new ArrayList();
  private boolean f = false;
  private ArrayList g;
  private boolean h = false;
  private final ArrayList i = new ArrayList();
  private ServiceConnection j;
  private boolean k = false;
  
  protected ao(Context paramContext, aw paramaw, ax paramax)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
      throw new IllegalStateException("Clients must be created on the UI thread.");
    }
    this.b = ((Context)d.a(paramContext));
    this.d = new ArrayList();
    this.d.add(d.a(paramaw));
    this.g = new ArrayList();
    this.g.add(d.a(paramax));
    this.a = new ap(this);
  }
  
  private static b b(String paramString)
  {
    try
    {
      paramString = b.valueOf(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      return b.c;
    }
    catch (NullPointerException paramString) {}
    return b.c;
  }
  
  protected abstract IInterface a(IBinder paramIBinder);
  
  protected abstract void a(y paramy, as paramas);
  
  protected final void a(b paramb)
  {
    this.a.removeMessages(4);
    for (;;)
    {
      int m;
      synchronized (this.g)
      {
        this.h = true;
        ArrayList localArrayList2 = this.g;
        int n = localArrayList2.size();
        m = 0;
        if (m < n)
        {
          if (!this.k) {
            return;
          }
          if (this.g.contains(localArrayList2.get(m))) {
            ((ax)localArrayList2.get(m)).a(paramb);
          }
        }
        else
        {
          this.h = false;
          return;
        }
      }
      m += 1;
    }
  }
  
  protected abstract String b();
  
  protected final void b(IBinder paramIBinder)
  {
    try
    {
      a(z.a(paramIBinder), new as(this));
      return;
    }
    catch (RemoteException paramIBinder)
    {
      Log.w("YouTubeClient", "service died");
    }
  }
  
  protected abstract String c();
  
  public void d()
  {
    h();
    this.k = false;
    synchronized (this.i)
    {
      int n = this.i.size();
      int m = 0;
      while (m < n)
      {
        ((aq)this.i.get(m)).b();
        m += 1;
      }
      this.i.clear();
      this.c = null;
      if (this.j != null)
      {
        this.b.unbindService(this.j);
        this.j = null;
      }
      return;
    }
  }
  
  public final void e()
  {
    this.k = true;
    Object localObject = a.a(this.b);
    if (localObject != b.a) {
      this.a.sendMessage(this.a.obtainMessage(3, localObject));
    }
    do
    {
      return;
      localObject = new Intent(c());
      if (this.j != null)
      {
        Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
        this.c = null;
        this.b.unbindService(this.j);
      }
      this.j = new at(this);
    } while (this.b.bindService((Intent)localObject, this.j, 129));
    this.a.sendMessage(this.a.obtainMessage(3, b.h));
  }
  
  public final boolean f()
  {
    return this.c != null;
  }
  
  protected final void g()
  {
    boolean bool2 = true;
    for (;;)
    {
      int m;
      synchronized (this.d)
      {
        if (this.f) {
          break label160;
        }
        bool1 = true;
        d.a(bool1);
        this.a.removeMessages(4);
        this.f = true;
        if (this.e.size() != 0) {
          break label165;
        }
        bool1 = bool2;
        d.a(bool1);
        ArrayList localArrayList2 = this.d;
        int n = localArrayList2.size();
        m = 0;
        if ((m < n) && (this.k) && (f()))
        {
          this.e.size();
          if (!this.e.contains(localArrayList2.get(m))) {
            ((aw)localArrayList2.get(m)).a();
          }
        }
        else
        {
          this.e.clear();
          this.f = false;
          return;
        }
      }
      m += 1;
      continue;
      label160:
      boolean bool1 = false;
      continue;
      label165:
      bool1 = false;
    }
  }
  
  protected final void h()
  {
    this.a.removeMessages(4);
    for (;;)
    {
      int m;
      synchronized (this.d)
      {
        this.f = true;
        ArrayList localArrayList2 = this.d;
        int n = localArrayList2.size();
        m = 0;
        if ((m < n) && (this.k))
        {
          if (this.d.contains(localArrayList2.get(m))) {
            ((aw)localArrayList2.get(m)).b();
          }
        }
        else
        {
          this.f = false;
          return;
        }
      }
      m += 1;
    }
  }
  
  protected final void i()
  {
    if (!f()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  protected final IInterface j()
  {
    i();
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */