package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class h<T>
  extends c<T>
{
  private T EW;
  
  public h(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.EB);
    }
    this.EB += 1;
    if (this.EB == 0)
    {
      this.EW = this.EA.get(0);
      if (!(this.EW instanceof d)) {
        throw new IllegalStateException("DataBuffer reference of type " + this.EW.getClass() + " is not movable");
      }
    }
    else
    {
      ((d)this.EW).ac(this.EB);
    }
    return (T)this.EW;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/data/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */