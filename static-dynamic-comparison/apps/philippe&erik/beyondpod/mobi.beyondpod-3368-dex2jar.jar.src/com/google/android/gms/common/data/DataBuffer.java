package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class DataBuffer<T>
  implements Iterable<T>
{
  protected final DataHolder nE;
  
  protected DataBuffer(DataHolder paramDataHolder)
  {
    this.nE = paramDataHolder;
    if (this.nE != null) {
      this.nE.c(this);
    }
  }
  
  public void close()
  {
    if (this.nE != null) {
      this.nE.close();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.nE == null) {
      return 0;
    }
    return this.nE.getCount();
  }
  
  public Bundle getMetadata()
  {
    return this.nE.getMetadata();
  }
  
  public boolean isClosed()
  {
    if (this.nE == null) {
      return true;
    }
    return this.nE.isClosed();
  }
  
  public Iterator<T> iterator()
  {
    return new a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/data/DataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */