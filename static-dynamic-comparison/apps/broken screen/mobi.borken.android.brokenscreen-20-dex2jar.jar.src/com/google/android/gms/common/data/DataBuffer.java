package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract class DataBuffer<T>
  implements Releasable, Iterable<T>
{
  protected final DataHolder DD;
  
  protected DataBuffer(DataHolder paramDataHolder)
  {
    this.DD = paramDataHolder;
    if (this.DD != null) {
      this.DD.b(this);
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
  
  public Bundle eP()
  {
    return this.DD.eP();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.DD == null) {
      return 0;
    }
    return this.DD.getCount();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    if (this.DD == null) {
      return true;
    }
    return this.DD.isClosed();
  }
  
  public Iterator<T> iterator()
  {
    return new c(this);
  }
  
  public void release()
  {
    if (this.DD != null) {
      this.DD.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new h(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/data/DataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */