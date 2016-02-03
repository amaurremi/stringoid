package com.google.android.gms.common.data;

import com.google.android.gms.internal.hm;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> EA;
  protected int EB;
  
  public c(DataBuffer<T> paramDataBuffer)
  {
    this.EA = ((DataBuffer)hm.f(paramDataBuffer));
    this.EB = -1;
  }
  
  public boolean hasNext()
  {
    return this.EB < this.EA.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.EB);
    }
    DataBuffer localDataBuffer = this.EA;
    int i = this.EB + 1;
    this.EB = i;
    return (T)localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */