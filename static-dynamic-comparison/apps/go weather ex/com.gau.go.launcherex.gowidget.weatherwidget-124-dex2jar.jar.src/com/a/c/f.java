package com.a.c;

import android.view.View;
import com.a.a.a;
import com.a.a.an;
import com.a.a.au;
import com.a.a.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class f
  implements au, b
{
  private f(d paramd) {}
  
  public void a(a parama)
  {
    if (d.b(this.a) != null) {
      d.b(this.a).a(parama);
    }
  }
  
  public void a(an paraman)
  {
    float f1 = paraman.m();
    paraman = (h)d.c(this.a).get(paraman);
    Object localObject;
    if ((paraman.a & 0x1FF) != 0)
    {
      localObject = (View)d.d(this.a).get();
      if (localObject != null) {
        ((View)localObject).invalidate();
      }
    }
    paraman = paraman.b;
    if (paraman != null)
    {
      int j = paraman.size();
      int i = 0;
      while (i < j)
      {
        localObject = (g)paraman.get(i);
        float f2 = ((g)localObject).b;
        float f3 = ((g)localObject).c;
        d.a(this.a, ((g)localObject).a, f2 + f3 * f1);
        i += 1;
      }
    }
    paraman = (View)d.d(this.a).get();
    if (paraman != null) {
      paraman.invalidate();
    }
  }
  
  public void b(a parama)
  {
    if (d.b(this.a) != null) {
      d.b(this.a).b(parama);
    }
  }
  
  public void c(a parama)
  {
    if (d.b(this.a) != null) {
      d.b(this.a).c(parama);
    }
    d.c(this.a).remove(parama);
    if (d.c(this.a).isEmpty()) {
      d.a(this.a, null);
    }
  }
  
  public void d(a parama)
  {
    if (d.b(this.a) != null) {
      d.b(this.a).d(parama);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */