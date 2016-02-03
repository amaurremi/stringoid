package com.pocket.articleprovider;

import com.ideashower.readitlater.d.c;
import com.ideashower.readitlater.e.o;
import java.util.Iterator;
import java.util.List;

class i
  implements c
{
  private i(f paramf) {}
  
  public void a(o paramo)
  {
    if (paramo.d(false)) {
      f.a(this.a).b(f.a(paramo));
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((o)paramList.next());
    }
  }
  
  public void aj()
  {
    f.a(this.a).c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/articleprovider/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */