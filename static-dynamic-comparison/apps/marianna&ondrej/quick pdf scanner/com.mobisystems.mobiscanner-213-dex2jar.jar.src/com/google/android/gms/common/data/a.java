package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a<T>
  implements Iterable<T>
{
  protected final DataHolder rM;
  
  protected a(DataHolder paramDataHolder)
  {
    this.rM = paramDataHolder;
    if (this.rM != null) {
      this.rM.I(this);
    }
  }
  
  public void close()
  {
    if (this.rM != null) {
      this.rM.close();
    }
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.rM == null) {
      return 0;
    }
    return this.rM.getCount();
  }
  
  public Iterator<T> iterator()
  {
    return new d(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */