package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.n;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status CM;
  private final PendingResult<?>[] Iy;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.CM = paramStatus;
    this.Iy = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return this.CM;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.Iy.length) {}
    for (boolean bool = true;; bool = false)
    {
      n.b(bool, "The result token does not belong to this batch");
      return this.Iy[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/api/BatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */