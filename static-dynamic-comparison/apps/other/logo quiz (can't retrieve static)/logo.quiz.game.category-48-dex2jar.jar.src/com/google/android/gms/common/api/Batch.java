package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends BaseImplementation.AbstractPendingResult<BatchResult>
{
  private int Iv;
  private boolean Iw;
  private boolean Ix;
  private final PendingResult<?>[] Iy;
  private final Object mw = new Object();
  
  private Batch(List<PendingResult<?>> paramList, Looper paramLooper)
  {
    super(new BaseImplementation.CallbackHandler(paramLooper));
    this.Iv = paramList.size();
    this.Iy = new PendingResult[this.Iv];
    int i = 0;
    while (i < paramList.size())
    {
      paramLooper = (PendingResult)paramList.get(i);
      this.Iy[i] = paramLooper;
      paramLooper.a(new PendingResult.a()
      {
        public void n(Status paramAnonymousStatus)
        {
          for (;;)
          {
            synchronized (Batch.a(Batch.this))
            {
              if (Batch.this.isCanceled()) {
                return;
              }
              if (paramAnonymousStatus.isCanceled())
              {
                Batch.a(Batch.this, true);
                Batch.b(Batch.this);
                if (Batch.c(Batch.this) == 0)
                {
                  if (!Batch.d(Batch.this)) {
                    break;
                  }
                  Batch.e(Batch.this);
                }
                return;
              }
            }
            if (!paramAnonymousStatus.isSuccess()) {
              Batch.b(Batch.this, true);
            }
          }
          if (Batch.f(Batch.this)) {}
          for (paramAnonymousStatus = new Status(13);; paramAnonymousStatus = Status.Jo)
          {
            Batch.this.b(new BatchResult(paramAnonymousStatus, Batch.g(Batch.this)));
            break;
          }
        }
      });
      i += 1;
    }
  }
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.Iy;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.Iy);
  }
  
  public static final class Builder
  {
    private List<PendingResult<?>> IA = new ArrayList();
    private Looper IB;
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.IB = paramGoogleApiClient.getLooper();
    }
    
    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.IA.size());
      this.IA.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public Batch build()
    {
      return new Batch(this.IA, this.IB, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/api/Batch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */