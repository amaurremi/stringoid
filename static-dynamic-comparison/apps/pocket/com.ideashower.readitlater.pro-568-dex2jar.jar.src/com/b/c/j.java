package com.b.c;

import android.view.View;
import com.b.a.a;
import com.b.a.b;
import com.b.a.p;
import com.b.a.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class j
  implements b, r
{
  private j(i parami) {}
  
  public void a(a parama)
  {
    if (i.b(this.a) != null) {
      i.b(this.a).a(parama);
    }
    i.c(this.a).remove(parama);
    if (i.c(this.a).isEmpty()) {
      i.a(this.a, null);
    }
  }
  
  public void a(p paramp)
  {
    float f1 = paramp.h();
    paramp = (l)i.c(this.a).get(paramp);
    Object localObject;
    if ((paramp.a & 0x1FF) != 0)
    {
      localObject = (View)i.d(this.a).get();
      if (localObject != null) {
        ((View)localObject).invalidate();
      }
    }
    paramp = paramp.b;
    if (paramp != null)
    {
      int j = paramp.size();
      int i = 0;
      while (i < j)
      {
        localObject = (k)paramp.get(i);
        float f2 = ((k)localObject).b;
        float f3 = ((k)localObject).c;
        i.a(this.a, ((k)localObject).a, f2 + f3 * f1);
        i += 1;
      }
    }
    paramp = (View)i.d(this.a).get();
    if (paramp != null) {
      paramp.invalidate();
    }
  }
  
  public void b(a parama)
  {
    if (i.b(this.a) != null) {
      i.b(this.a).b(parama);
    }
  }
  
  public void c(a parama)
  {
    if (i.b(this.a) != null) {
      i.b(this.a).c(parama);
    }
  }
  
  public void d(a parama)
  {
    if (i.b(this.a) != null) {
      i.b(this.a).d(parama);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */