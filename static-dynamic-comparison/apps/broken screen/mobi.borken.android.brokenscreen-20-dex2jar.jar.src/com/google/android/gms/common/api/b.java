package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

public abstract class b
  implements Releasable, Result
{
  protected final DataHolder DD;
  protected final Status yw;
  
  protected b(DataHolder paramDataHolder)
  {
    this.yw = new Status(paramDataHolder.getStatusCode());
    this.DD = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return this.yw;
  }
  
  public void release()
  {
    if (this.DD != null) {
      this.DD.close();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/api/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */