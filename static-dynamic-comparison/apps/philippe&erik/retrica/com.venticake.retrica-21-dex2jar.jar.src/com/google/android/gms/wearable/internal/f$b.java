package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;

public class f$b
  implements DataApi.DeleteDataItemsResult
{
  private final int alI;
  private final Status yz;
  
  public f$b(Status paramStatus, int paramInt)
  {
    this.yz = paramStatus;
    this.alI = paramInt;
  }
  
  public int getNumDeleted()
  {
    return this.alI;
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/f$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */