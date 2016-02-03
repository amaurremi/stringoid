package com.a.a;

import java.util.ArrayList;
import java.util.HashMap;

class f
  implements b
{
  private d b;
  
  f(d paramd1, d paramd2)
  {
    this.b = paramd2;
  }
  
  public void a(a parama) {}
  
  public void b(a parama) {}
  
  public void c(a parama)
  {
    parama.b(this);
    d.a(this.a).remove(parama);
    ((j)d.b(this.b).get(parama)).f = true;
    int j;
    if (!this.a.b)
    {
      parama = d.c(this.b);
      j = parama.size();
      i = 0;
      if (i >= j) {
        break label162;
      }
      if (((j)parama.get(i)).f) {}
    }
    label162:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        if (this.a.a != null)
        {
          parama = (ArrayList)this.a.a.clone();
          j = parama.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              ((b)parama.get(i)).c(this.b);
              i += 1;
              continue;
              i += 1;
              break;
            }
          }
        }
        d.a(this.b, false);
      }
      return;
    }
  }
  
  public void d(a parama)
  {
    if ((!this.a.b) && (d.a(this.a).size() == 0) && (this.a.a != null))
    {
      int j = this.a.a.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.a.a.get(i)).d(this.b);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */