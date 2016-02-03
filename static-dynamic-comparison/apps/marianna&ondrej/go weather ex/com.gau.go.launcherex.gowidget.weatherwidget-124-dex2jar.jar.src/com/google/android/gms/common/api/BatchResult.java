package com.google.android.gms.common.api;

import com.google.android.gms.internal.fq;

public final class BatchResult
  implements Result
{
  private final PendingResult<?>[] AP;
  private final Status wJ;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.wJ = paramStatus;
    this.AP = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return this.wJ;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.AP.length) {}
    for (boolean bool = true;; bool = false)
    {
      fq.b(bool, "The result token does not belong to this batch");
      PendingResult localPendingResult = this.AP[paramBatchResultToken.mId];
      this.AP[paramBatchResultToken.mId] = null;
      return localPendingResult.await();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/common/api/BatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */