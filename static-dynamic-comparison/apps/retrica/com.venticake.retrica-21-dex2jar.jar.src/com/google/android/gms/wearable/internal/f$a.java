package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataItem;

public class f$a
  implements DataApi.DataItemResult
{
  private final DataItem alH;
  private final Status yz;
  
  public f$a(Status paramStatus, DataItem paramDataItem)
  {
    this.yz = paramStatus;
    this.alH = paramDataItem;
  }
  
  public DataItem getDataItem()
  {
    return this.alH;
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/f$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */