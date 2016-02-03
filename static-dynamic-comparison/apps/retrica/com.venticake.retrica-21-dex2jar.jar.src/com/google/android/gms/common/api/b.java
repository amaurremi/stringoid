package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

public abstract class b
  implements Releasable, Result
{
  protected final DataHolder DG;
  protected final Status yz;
  
  protected b(DataHolder paramDataHolder)
  {
    this.yz = new Status(paramDataHolder.getStatusCode());
    this.DG = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
  
  public void release()
  {
    if (this.DG != null) {
      this.DG.close();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */