package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract class DataBuffer<T>
  implements Releasable, Iterable<T>
{
  protected final DataHolder DG;
  
  protected DataBuffer(DataHolder paramDataHolder)
  {
    this.DG = paramDataHolder;
    if (this.DG != null) {
      this.DG.b(this);
    }
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle eU()
  {
    return this.DG.eU();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.DG == null) {
      return 0;
    }
    return this.DG.getCount();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    if (this.DG == null) {
      return true;
    }
    return this.DG.isClosed();
  }
  
  public Iterator<T> iterator()
  {
    return new c(this);
  }
  
  public void release()
  {
    if (this.DG != null) {
      this.DG.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new h(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/data/DataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */