package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.internal.ds;

public abstract class FilteredDataBuffer<T>
  extends DataBuffer<T>
{
  protected final DataBuffer<T> mDataBuffer;
  
  public FilteredDataBuffer(DataBuffer<T> paramDataBuffer)
  {
    super(null);
    ds.d(paramDataBuffer);
    if (!(paramDataBuffer instanceof FilteredDataBuffer)) {}
    for (boolean bool = true;; bool = false)
    {
      ds.a(bool, "Not possible to have nested FilteredDataBuffers.");
      this.mDataBuffer = paramDataBuffer;
      return;
    }
  }
  
  public void close()
  {
    this.mDataBuffer.close();
  }
  
  protected abstract int computeRealPosition(int paramInt);
  
  public T get(int paramInt)
  {
    return (T)this.mDataBuffer.get(computeRealPosition(paramInt));
  }
  
  public Bundle getMetadata()
  {
    return this.mDataBuffer.getMetadata();
  }
  
  public boolean isClosed()
  {
    return this.mDataBuffer.isClosed();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/data/FilteredDataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */