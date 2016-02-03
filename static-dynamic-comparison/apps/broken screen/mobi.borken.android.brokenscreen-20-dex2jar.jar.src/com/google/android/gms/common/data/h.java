package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class h<T>
  extends c<T>
{
  private T ET;
  
  public h(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.Ey);
    }
    this.Ey += 1;
    if (this.Ey == 0)
    {
      this.ET = this.Ex.get(0);
      if (!(this.ET instanceof d)) {
        throw new IllegalStateException("DataBuffer reference of type " + this.ET.getClass() + " is not movable");
      }
    }
    else
    {
      ((d)this.ET).ac(this.Ey);
    }
    return (T)this.ET;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/data/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */