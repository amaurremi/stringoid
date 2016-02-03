package com.appbrain.b;

import java.util.ListIterator;

final class s
  implements ListIterator
{
  ListIterator a = r.a(this.c).listIterator(this.b);
  
  s(r paramr, int paramInt) {}
  
  public final boolean hasNext()
  {
    return this.a.hasNext();
  }
  
  public final boolean hasPrevious()
  {
    return this.a.hasPrevious();
  }
  
  public final int nextIndex()
  {
    return this.a.nextIndex();
  }
  
  public final int previousIndex()
  {
    return this.a.previousIndex();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */