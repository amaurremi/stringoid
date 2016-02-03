package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class hb$d<TListener>
  extends hb<T>.b<TListener>
{
  private final DataHolder DG;
  
  public hb$d(TListener paramTListener, DataHolder paramDataHolder)
  {
    super(paramTListener, paramDataHolder);
    DataHolder localDataHolder;
    this.DG = localDataHolder;
  }
  
  protected abstract void a(TListener paramTListener, DataHolder paramDataHolder);
  
  protected final void d(TListener paramTListener)
  {
    a(paramTListener, this.DG);
  }
  
  protected void fu()
  {
    if (this.DG != null) {
      this.DG.close();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hb$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */