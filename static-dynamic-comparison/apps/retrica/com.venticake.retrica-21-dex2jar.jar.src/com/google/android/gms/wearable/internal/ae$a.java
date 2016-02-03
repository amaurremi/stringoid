package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public class ae$a
  implements MessageApi.SendMessageResult
{
  private final int ra;
  private final Status yz;
  
  public ae$a(Status paramStatus, int paramInt)
  {
    this.yz = paramStatus;
    this.ra = paramInt;
  }
  
  public int getRequestId()
  {
    return this.ra;
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/ae$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */