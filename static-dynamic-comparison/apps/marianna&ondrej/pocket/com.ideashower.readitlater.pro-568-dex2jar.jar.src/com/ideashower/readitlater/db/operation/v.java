package com.ideashower.readitlater.db.operation;

import com.ideashower.readitlater.db.operation.action.c;
import java.util.ArrayList;
import java.util.Iterator;

public class v
  extends j
{
  private final c e;
  private final ArrayList p;
  
  public v(c paramc, boolean paramBoolean)
  {
    this.e = paramc;
    this.p = null;
    this.b = paramBoolean;
  }
  
  public v(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.e = null;
    this.p = paramArrayList;
    this.b = paramBoolean;
  }
  
  protected void c_()
  {
    if (this.e != null) {
      a(this.e);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext()) {
        a((c)localIterator.next());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */