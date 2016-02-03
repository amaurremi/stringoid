package com.pocket.list.adapter.data;

import com.ideashower.readitlater.d.a;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.objects.h;
import com.ideashower.readitlater.util.j;

public abstract class f
{
  private final g a;
  private a b;
  private g c;
  
  public f(g paramg)
  {
    this.a = paramg;
  }
  
  protected static void a(h paramh)
  {
    if (paramh != null)
    {
      boolean bool = j.c();
      int j = paramh.size();
      int i = 0;
      while (i < j)
      {
        o localo = (o)paramh.get(i);
        localo.Y();
        if (bool) {
          localo.aa();
        }
        localo.o();
        i += 1;
      }
    }
  }
  
  protected abstract a a(ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery, g paramg);
  
  public final void a(ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery)
  {
    b();
    this.c = new g()
    {
      private void a()
      {
        f.a(f.this, null);
      }
      
      public void a(f paramAnonymousf, ItemQuery.ReadOnlyItemQuery paramAnonymousReadOnlyItemQuery)
      {
        if (f.a(f.this) != this) {
          return;
        }
        a();
        f.b(f.this).a(paramAnonymousf, paramAnonymousReadOnlyItemQuery);
      }
      
      public void a(f paramAnonymousf, ItemQuery.ReadOnlyItemQuery paramAnonymousReadOnlyItemQuery, ErrorReport paramAnonymousErrorReport)
      {
        if (f.a(f.this) != this) {
          return;
        }
        a();
        f.b(f.this).a(paramAnonymousf, paramAnonymousReadOnlyItemQuery, paramAnonymousErrorReport);
      }
      
      public void a(f paramAnonymousf, ItemQuery.ReadOnlyItemQuery paramAnonymousReadOnlyItemQuery, h paramAnonymoush, Boolean paramAnonymousBoolean)
      {
        if (f.a(f.this) != this) {
          return;
        }
        a();
        f.b(f.this).a(paramAnonymousf, paramAnonymousReadOnlyItemQuery, paramAnonymoush, paramAnonymousBoolean);
      }
    };
    this.b = a(paramReadOnlyItemQuery, this.c);
  }
  
  public void b()
  {
    if (this.b != null)
    {
      this.b.D();
      this.b = null;
      this.c = null;
    }
  }
  
  public abstract void c();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */