package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract class DataBuffer<T>
  implements Releasable, Iterable<T>
{
  protected final DataHolder IC;
  
  protected DataBuffer(DataHolder paramDataHolder)
  {
    this.IC = paramDataHolder;
    if (this.IC != null) {
      this.IC.e(this);
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
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.IC == null) {
      return 0;
    }
    return this.IC.getCount();
  }
  
  public Bundle gz()
  {
    return this.IC.gz();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    if (this.IC == null) {
      return true;
    }
    return this.IC.isClosed();
  }
  
  public Iterator<T> iterator()
  {
    return new c(this);
  }
  
  public void release()
  {
    if (this.IC != null) {
      this.IC.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new h(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/data/DataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */