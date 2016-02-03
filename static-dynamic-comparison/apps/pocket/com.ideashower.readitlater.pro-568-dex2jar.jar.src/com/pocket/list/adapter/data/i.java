package com.pocket.list.adapter.data;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.r;

class i
  extends j
{
  private final ItemQuery.ReadOnlyItemQuery p;
  private com.ideashower.readitlater.objects.h q;
  
  private i(h paramh, ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery)
  {
    this.p = paramReadOnlyItemQuery;
  }
  
  private com.ideashower.readitlater.objects.h e()
  {
    return this.q;
  }
  
  protected void c_()
  {
    this.q = r.a(this.p, this.h, this);
    f.a(this.q);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */