package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class h<T>
  extends c<T>
{
  private T Kk;
  
  public h(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.JP);
    }
    this.JP += 1;
    if (this.JP == 0)
    {
      this.Kk = this.JO.get(0);
      if (!(this.Kk instanceof d)) {
        throw new IllegalStateException("DataBuffer reference of type " + this.Kk.getClass() + " is not movable");
      }
    }
    else
    {
      ((d)this.Kk).ap(this.JP);
    }
    return (T)this.Kk;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/data/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */