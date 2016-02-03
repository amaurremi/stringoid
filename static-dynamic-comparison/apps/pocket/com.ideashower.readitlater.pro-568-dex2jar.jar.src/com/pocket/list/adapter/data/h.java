package com.pocket.list.adapter.data;

import com.ideashower.readitlater.d.a;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;

public class h
  extends f
  implements l
{
  private i a;
  private g b;
  
  public h(g paramg)
  {
    super(paramg);
  }
  
  protected a a(ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery, g paramg)
  {
    this.b = paramg;
    this.a = new i(this, paramReadOnlyItemQuery, null);
    this.a.a(this, true);
    this.a.f();
    return this.a;
  }
  
  public void a() {}
  
  public void a(k paramk, boolean paramBoolean)
  {
    if ((paramk != this.a) || (paramk.a_()) || (i.a((i)paramk) == null)) {
      return;
    }
    paramk = (i)paramk;
    g localg = this.b;
    this.a = null;
    this.b = null;
    localg.a(this, i.b(paramk), i.a(paramk), null);
  }
  
  public void c() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */