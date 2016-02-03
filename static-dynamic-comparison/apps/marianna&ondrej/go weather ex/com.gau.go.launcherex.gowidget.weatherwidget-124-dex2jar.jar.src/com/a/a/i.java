package com.a.a;

import java.util.ArrayList;

class i
  implements b
{
  private d a;
  private j b;
  private int c;
  
  public i(d paramd, j paramj, int paramInt)
  {
    this.a = paramd;
    this.b = paramj;
    this.c = paramInt;
  }
  
  private void e(a parama)
  {
    if (this.a.b) {
      return;
    }
    int j = this.b.c.size();
    int i = 0;
    label24:
    h localh;
    if (i < j)
    {
      localh = (h)this.b.c.get(i);
      if ((localh.b == this.c) && (localh.a.a == parama)) {
        parama.b(this);
      }
    }
    for (parama = localh;; parama = null)
    {
      this.b.c.remove(parama);
      if (this.b.c.size() != 0) {
        break;
      }
      this.b.a.a();
      d.a(this.a).add(this.b.a);
      return;
      i += 1;
      break label24;
    }
  }
  
  public void a(a parama)
  {
    if (this.c == 0) {
      e(parama);
    }
  }
  
  public void b(a parama) {}
  
  public void c(a parama)
  {
    if (this.c == 1) {
      e(parama);
    }
  }
  
  public void d(a parama) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */