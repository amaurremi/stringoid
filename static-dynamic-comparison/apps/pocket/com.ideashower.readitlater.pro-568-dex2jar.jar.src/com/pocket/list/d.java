package com.pocket.list;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;
import com.ideashower.readitlater.objects.h;
import com.pocket.list.adapter.data.ItemQuery;

public class d
{
  private final l a;
  private final f b;
  private final ItemQuery c = new ItemQuery();
  private boolean d = true;
  private j e;
  
  public d(f paramf)
  {
    this.b = paramf;
    this.a = new l()
    {
      public void a() {}
      
      public void a(k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        d.a(d.this, (e)paramAnonymousk, paramAnonymousBoolean);
      }
    };
  }
  
  private void a(e parame, boolean paramBoolean)
  {
    if (parame != this.e) {}
    do
    {
      return;
      parame = parame.e();
    } while (parame == null);
    this.e = null;
    this.b.a(parame);
  }
  
  private static void b(h paramh)
  {
    if (paramh != null)
    {
      int j = paramh.size();
      int i = 0;
      while (i < j)
      {
        o localo = (o)paramh.get(i);
        localo.Y();
        localo.o();
        i += 1;
      }
    }
  }
  
  public ItemQuery a()
  {
    return this.c;
  }
  
  public void b()
  {
    if (this.e != null) {
      this.e.D();
    }
    e locale = new e(this, this.c.c());
    locale.a(this.a, true);
    locale.f();
    this.e = locale;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */