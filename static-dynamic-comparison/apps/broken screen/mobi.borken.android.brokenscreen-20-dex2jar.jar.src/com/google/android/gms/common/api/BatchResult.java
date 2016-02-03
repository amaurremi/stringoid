package com.google.android.gms.common.api;

import com.google.android.gms.internal.hn;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final PendingResult<?>[] Dz;
  private final Status yw;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.yw = paramStatus;
    this.Dz = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return this.yw;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.Dz.length) {}
    for (boolean bool = true;; bool = false)
    {
      hn.b(bool, "The result token does not belong to this batch");
      return this.Dz[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/api/BatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */