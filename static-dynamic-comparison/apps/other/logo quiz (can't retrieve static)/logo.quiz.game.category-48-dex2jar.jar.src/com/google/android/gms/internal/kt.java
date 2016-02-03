package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.a;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class kt<T extends Result>
  implements PendingResult<T>
{
  private final T Tn;
  
  kt(T paramT)
  {
    this.Tn = paramT;
  }
  
  public void a(PendingResult.a parama)
  {
    parama.n(this.Tn.getStatus());
  }
  
  public T await()
  {
    return this.Tn;
  }
  
  public T await(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.Tn;
  }
  
  public void cancel() {}
  
  public boolean isCanceled()
  {
    return false;
  }
  
  public void setResultCallback(ResultCallback<T> paramResultCallback)
  {
    paramResultCallback.onResult(this.Tn);
  }
  
  public void setResultCallback(ResultCallback<T> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    paramResultCallback.onResult(this.Tn);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/kt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */