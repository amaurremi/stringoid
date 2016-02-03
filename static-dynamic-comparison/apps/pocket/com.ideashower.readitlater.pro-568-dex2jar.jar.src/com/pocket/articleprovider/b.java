package com.pocket.articleprovider;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.objects.h;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.data.ItemQuery.ReadOnlyItemQuery;

public class b
  implements com.ideashower.readitlater.g.l
{
  private final ItemQuery a = new ItemQuery();
  private final ItemQuery b = new ItemQuery();
  private final a c;
  private j d;
  private h e;
  
  protected b(a parama)
  {
    this.c = parama;
    this.a.a().e(Integer.valueOf(1)).a();
    this.b.a().e(Integer.valueOf(1)).c(Integer.valueOf(0)).a(0).a();
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
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.a.a().d(Integer.valueOf(paramInt2)).c(Integer.valueOf(paramInt1)).a();
    if (this.d != null) {
      this.d.D();
    }
    c localc = new c(this, this.a.c());
    localc.a(this, true);
    localc.f();
    this.d = localc;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d != null) {
      this.d.D();
    }
    d locald = new d(this, paramInt1, paramInt2, paramInt3);
    locald.a(this, true);
    locald.f();
    this.d = locald;
  }
  
  public void a(k paramk, boolean paramBoolean)
  {
    if (paramk != this.d) {}
    do
    {
      do
      {
        return;
        localObject = (e)paramk;
        paramk = ((e)localObject).e();
      } while (paramk == null);
      this.e = paramk;
      this.d = null;
      if ((localObject instanceof c))
      {
        localObject = (c)localObject;
        this.c.a(f.a(paramk), c.a((c)localObject).o().intValue(), c.a((c)localObject).r().intValue());
        return;
      }
    } while (!(localObject instanceof d));
    Object localObject = (d)localObject;
    this.c.a(f.a(paramk), d.a((d)localObject), d.b((d)localObject), d.c((d)localObject));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/articleprovider/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */