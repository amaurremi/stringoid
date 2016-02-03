package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.ij;

class dt
  implements bg<c.j>
{
  private dt(dq paramdq) {}
  
  public void a() {}
  
  public void a(c.j paramj)
  {
    synchronized (this.a)
    {
      if (paramj.fK == null)
      {
        if (dq.c(this.a).fK == null)
        {
          as.a("Current resource is null; network resource is also null");
          dq.a(this.a, 3600000L);
          return;
        }
        paramj.fK = dq.c(this.a).fK;
      }
      dq.a(this.a, paramj, dq.a(this.a).currentTimeMillis(), false);
      as.e("setting refresh time to current time: " + dq.d(this.a));
      if (!dq.e(this.a)) {
        dq.a(this.a, paramj);
      }
      return;
    }
  }
  
  public void a(bg.a parama)
  {
    if (dq.f(this.a) != null) {
      this.a.b(dq.f(this.a));
    }
    for (;;)
    {
      dq.a(this.a, 3600000L);
      return;
      this.a.b(this.a.a(Status.Eq));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */