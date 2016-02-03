package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.a;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import com.google.android.gms.common.g;
import java.util.ArrayList;

public abstract class s
  implements b
{
  public static final String[] e = { "service_esmobile", "service_googleme" };
  final Handler a;
  final ArrayList b = new ArrayList();
  boolean c = false;
  boolean d = false;
  private final Context f;
  private IInterface g;
  private ArrayList h;
  private boolean i = false;
  private ArrayList j;
  private boolean k = false;
  private final ArrayList l = new ArrayList();
  private z m;
  private final String[] n;
  private final Object o = new Object();
  
  protected s(Context paramContext, c paramc, d paramd, String... paramVarArgs)
  {
    this.f = ((Context)an.a(paramContext));
    this.h = new ArrayList();
    this.h.add(an.a(paramc));
    this.j = new ArrayList();
    this.j.add(an.a(paramd));
    this.a = new t(this, paramContext.getMainLooper());
    a(paramVarArgs);
    this.n = paramVarArgs;
  }
  
  protected abstract IInterface a(IBinder paramIBinder);
  
  protected abstract String a();
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    this.a.sendMessage(this.a.obtainMessage(1, new aa(this, paramInt, paramIBinder, paramBundle)));
  }
  
  protected void a(a parama)
  {
    this.a.removeMessages(4);
    for (;;)
    {
      int i1;
      synchronized (this.j)
      {
        this.k = true;
        ArrayList localArrayList2 = this.j;
        int i2 = localArrayList2.size();
        i1 = 0;
        if (i1 < i2)
        {
          if (!this.c) {
            return;
          }
          if (this.j.contains(localArrayList2.get(i1))) {
            ((d)localArrayList2.get(i1)).a(parama);
          }
        }
        else
        {
          this.k = false;
          return;
        }
      }
      i1 += 1;
    }
  }
  
  protected abstract void a(ai paramai, y paramy);
  
  public final void a(u paramu)
  {
    synchronized (this.l)
    {
      this.l.add(paramu);
      this.a.sendMessage(this.a.obtainMessage(2, paramu));
      return;
    }
  }
  
  protected void a(String... paramVarArgs) {}
  
  protected abstract String b();
  
  protected final void b(IBinder paramIBinder)
  {
    try
    {
      a(aj.a(paramIBinder), new y(this));
      return;
    }
    catch (RemoteException paramIBinder)
    {
      Log.w("GmsClient", "service died");
    }
  }
  
  public void c()
  {
    this.c = true;
    do
    {
      synchronized (this.o)
      {
        this.d = true;
        int i1 = g.a(this.f);
        if (i1 != 0)
        {
          this.a.sendMessage(this.a.obtainMessage(3, Integer.valueOf(i1)));
          return;
        }
      }
      if (this.m != null)
      {
        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
        this.g = null;
        ab.a(this.f).b(a(), this.m);
      }
      this.m = new z(this);
    } while (ab.a(this.f).a(a(), this.m));
    Log.e("GmsClient", "unable to connect to service: " + a());
    this.a.sendMessage(this.a.obtainMessage(3, Integer.valueOf(9)));
  }
  
  public boolean d()
  {
    return this.g != null;
  }
  
  public boolean e()
  {
    synchronized (this.o)
    {
      boolean bool = this.d;
      return bool;
    }
  }
  
  public void f()
  {
    this.c = false;
    synchronized (this.o)
    {
      this.d = false;
    }
    synchronized (this.l)
    {
      int i2 = this.l.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((u)this.l.get(i1)).d();
        i1 += 1;
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      this.l.clear();
      this.g = null;
      if (this.m != null)
      {
        ab.a(this.f).b(a(), this.m);
        this.m = null;
      }
      return;
    }
  }
  
  public final String[] g()
  {
    return this.n;
  }
  
  protected void h()
  {
    boolean bool2 = true;
    for (;;)
    {
      int i1;
      synchronized (this.h)
      {
        if (!this.i)
        {
          bool1 = true;
          an.a(bool1);
          this.a.removeMessages(4);
          this.i = true;
          if (this.b.size() != 0) {
            break label166;
          }
          bool1 = bool2;
          an.a(bool1);
          Bundle localBundle = i();
          ArrayList localArrayList2 = this.h;
          int i2 = localArrayList2.size();
          i1 = 0;
          if ((i1 >= i2) || (!this.c) || (!d()))
          {
            this.b.clear();
            this.i = false;
            return;
          }
          this.b.size();
          if (this.b.contains(localArrayList2.get(i1))) {
            break label171;
          }
          ((c)localArrayList2.get(i1)).a(localBundle);
        }
      }
      boolean bool1 = false;
      continue;
      label166:
      bool1 = false;
      continue;
      label171:
      i1 += 1;
    }
  }
  
  protected Bundle i()
  {
    return null;
  }
  
  protected final void j()
  {
    this.a.removeMessages(4);
    for (;;)
    {
      int i1;
      synchronized (this.h)
      {
        this.i = true;
        ArrayList localArrayList2 = this.h;
        int i2 = localArrayList2.size();
        i1 = 0;
        if ((i1 >= i2) || (!this.c))
        {
          this.i = false;
          return;
        }
        if (this.h.contains(localArrayList2.get(i1))) {
          ((c)localArrayList2.get(i1)).a();
        }
      }
      i1 += 1;
    }
  }
  
  protected final void k()
  {
    if (!d()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  protected final IInterface l()
  {
    k();
    return this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */