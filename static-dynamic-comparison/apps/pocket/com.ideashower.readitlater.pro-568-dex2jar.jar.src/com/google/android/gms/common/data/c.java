package com.google.android.gms.common.data;

import com.google.android.gms.internal.an;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class c
  implements Iterator
{
  private final a a;
  private int b;
  
  public c(a parama)
  {
    this.a = ((a)an.a(parama));
    this.b = -1;
  }
  
  public boolean hasNext()
  {
    return this.b < this.a.a() - 1;
  }
  
  public Object next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.b);
    }
    a locala = this.a;
    int i = this.b + 1;
    this.b = i;
    return locala.a(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */