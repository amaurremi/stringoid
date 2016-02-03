package com.appbrain.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

final class y
  implements Iterator
{
  private final Stack a = new Stack();
  private r b = a(paramd);
  
  private y(d paramd) {}
  
  private r a(d paramd)
  {
    while ((paramd instanceof x))
    {
      paramd = (x)paramd;
      this.a.push(paramd);
      paramd = x.a(paramd);
    }
    return (r)paramd;
  }
  
  private r b()
  {
    r localr;
    do
    {
      if (this.a.isEmpty()) {
        return null;
      }
      localr = a(x.b((x)this.a.pop()));
    } while (localr.c());
    return localr;
  }
  
  public final r a()
  {
    if (this.b == null) {
      throw new NoSuchElementException();
    }
    r localr = this.b;
    this.b = b();
    return localr;
  }
  
  public final boolean hasNext()
  {
    return this.b != null;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */