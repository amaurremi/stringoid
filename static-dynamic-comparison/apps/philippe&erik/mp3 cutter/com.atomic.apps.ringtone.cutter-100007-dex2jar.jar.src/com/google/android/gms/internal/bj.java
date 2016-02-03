package com.google.android.gms.internal;

import android.content.Context;
import com.atomic.apps.ringtone.cutter.aa;
import com.google.android.gms.common.a;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;

public final class bj
  extends bh
  implements b, c
{
  private final bg a;
  private final bk b;
  private final Object c = new Object();
  
  public bj(Context paramContext, cx paramcx, bg parambg)
  {
    super(paramcx, parambg);
    this.a = parambg;
    this.b = new bk(paramContext, this, this, paramcx.k.d);
    this.b.d();
  }
  
  public final void a(a parama)
  {
    this.a.a(new cz(0));
  }
  
  public final void a_()
  {
    e();
  }
  
  public final void b()
  {
    aa.a("Disconnected from remote ad request service.");
  }
  
  public final void c()
  {
    synchronized (this.c)
    {
      if ((this.b.e()) || (this.b.f())) {
        this.b.g();
      }
      return;
    }
  }
  
  public final bo d()
  {
    synchronized (this.c)
    {
      try
      {
        bo localbo = this.b.c();
        return localbo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        return null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */