package com.appbrain.b;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ac
  extends AbstractList
  implements q, RandomAccess
{
  private final q a;
  
  public ac(q paramq)
  {
    this.a = paramq;
  }
  
  public final d a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public final List a()
  {
    return this.a.a();
  }
  
  public final void a(d paramd)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Iterator iterator()
  {
    return new ae(this);
  }
  
  public final ListIterator listIterator(int paramInt)
  {
    return new ad(this, paramInt);
  }
  
  public final int size()
  {
    return this.a.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */