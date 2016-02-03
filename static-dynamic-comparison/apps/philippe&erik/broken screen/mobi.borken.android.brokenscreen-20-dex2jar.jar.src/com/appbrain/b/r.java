package com.appbrain.b;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class r
  extends AbstractList
  implements k, RandomAccess
{
  private final k a;
  
  public r(k paramk)
  {
    this.a = paramk;
  }
  
  public final c a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public final List a()
  {
    return this.a.a();
  }
  
  public final void a(c paramc)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Iterator iterator()
  {
    return new t(this);
  }
  
  public final ListIterator listIterator(int paramInt)
  {
    return new s(this, paramInt);
  }
  
  public final int size()
  {
    return this.a.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */