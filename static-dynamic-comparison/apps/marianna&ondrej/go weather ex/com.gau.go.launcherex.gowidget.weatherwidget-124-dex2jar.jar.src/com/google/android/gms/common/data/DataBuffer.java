package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class DataBuffer<T>
  implements Iterable<T>
{
  protected final DataHolder BB;
  
  protected DataBuffer(DataHolder paramDataHolder)
  {
    this.BB = paramDataHolder;
    if (this.BB != null) {
      this.BB.c(this);
    }
  }
  
  public void close()
  {
    if (this.BB != null) {
      this.BB.close();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.BB == null) {
      return 0;
    }
    return this.BB.getCount();
  }
  
  public Bundle getMetadata()
  {
    return this.BB.getMetadata();
  }
  
  public boolean isClosed()
  {
    if (this.BB == null) {
      return true;
    }
    return this.BB.isClosed();
  }
  
  public Iterator<T> iterator()
  {
    return new a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/common/data/DataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */