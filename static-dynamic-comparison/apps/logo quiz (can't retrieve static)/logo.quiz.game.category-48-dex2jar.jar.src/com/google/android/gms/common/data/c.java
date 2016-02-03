package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.n;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> JO;
  protected int JP;
  
  public c(DataBuffer<T> paramDataBuffer)
  {
    this.JO = ((DataBuffer)n.i(paramDataBuffer));
    this.JP = -1;
  }
  
  public boolean hasNext()
  {
    return this.JP < this.JO.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.JP);
    }
    DataBuffer localDataBuffer = this.JO;
    int i = this.JP + 1;
    this.JP = i;
    return (T)localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */