package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.le.a;

class ds
  implements bg<le.a>
{
  private ds(dq paramdq) {}
  
  public void a() {}
  
  public void a(le.a parama)
  {
    c.j localj;
    if (parama.aiH != null) {
      localj = parama.aiH;
    }
    for (;;)
    {
      dq.a(this.a, localj, parama.aiG, true);
      return;
      c.f localf = parama.fK;
      localj = new c.j();
      localj.fK = localf;
      localj.fJ = null;
      localj.fL = localf.fg;
    }
  }
  
  public void a(bg.a parama)
  {
    if (!dq.b(this.a)) {
      dq.a(this.a, 0L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */