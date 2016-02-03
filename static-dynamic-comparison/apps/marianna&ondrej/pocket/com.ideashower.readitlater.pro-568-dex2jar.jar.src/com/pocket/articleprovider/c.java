package com.pocket.articleprovider;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.r;
import com.ideashower.readitlater.objects.h;
import com.pocket.list.adapter.data.ItemQuery.ReadOnlyItemQuery;

public class c
  extends j
  implements e
{
  private final ItemQuery.ReadOnlyItemQuery p;
  private h q;
  
  public c(b paramb, ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery)
  {
    this.p = paramReadOnlyItemQuery;
  }
  
  protected void c_()
  {
    this.q = r.a(this.p, this.h, this);
    b.a(this.q);
  }
  
  public h e()
  {
    return this.q;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/articleprovider/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */