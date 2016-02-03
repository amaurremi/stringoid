package com.google.android.gms.common.data;

import com.google.android.gms.internal.hn;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> Ex;
  protected int Ey;
  
  public c(DataBuffer<T> paramDataBuffer)
  {
    this.Ex = ((DataBuffer)hn.f(paramDataBuffer));
    this.Ey = -1;
  }
  
  public boolean hasNext()
  {
    return this.Ey < this.Ex.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.Ey);
    }
    DataBuffer localDataBuffer = this.Ex;
    int i = this.Ey + 1;
    this.Ey = i;
    return (T)localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */