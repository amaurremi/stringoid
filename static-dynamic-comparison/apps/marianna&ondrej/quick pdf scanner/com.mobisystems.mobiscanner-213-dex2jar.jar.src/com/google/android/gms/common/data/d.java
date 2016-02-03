package com.google.android.gms.common.data;

import com.google.android.gms.internal.dc;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class d<T>
  implements Iterator<T>
{
  private final a<T> sc;
  private int sd;
  
  public d(a<T> parama)
  {
    this.sc = ((a)dc.N(parama));
    this.sd = -1;
  }
  
  public boolean hasNext()
  {
    return this.sd < this.sc.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.sd);
    }
    a locala = this.sc;
    int i = this.sd + 1;
    this.sd = i;
    return (T)locala.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/data/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */