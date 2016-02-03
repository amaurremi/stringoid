package com.google.android.gms.common.api;

import com.google.android.gms.internal.hm;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final PendingResult<?>[] DC;
  private final Status yz;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.yz = paramStatus;
    this.DC = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return this.yz;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.DC.length) {}
    for (boolean bool = true;; bool = false)
    {
      hm.b(bool, "The result token does not belong to this batch");
      return this.DC[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/BatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */