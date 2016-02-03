package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends a.a<BatchResult>
{
  private int Dw;
  private boolean Dx;
  private boolean Dy;
  private final PendingResult<?>[] Dz;
  private final Object lq = new Object();
  
  private Batch(List<PendingResult<?>> paramList, Looper paramLooper)
  {
    super(new a.c(paramLooper));
    this.Dw = paramList.size();
    this.Dz = new PendingResult[this.Dw];
    int i = 0;
    while (i < paramList.size())
    {
      paramLooper = (PendingResult)paramList.get(i);
      this.Dz[i] = paramLooper;
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
          for (paramAnonymousStatus = new Status(13);; paramAnonymousStatus = Status.Ek)
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
    PendingResult[] arrayOfPendingResult = this.Dz;
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
    return new BatchResult(paramStatus, this.Dz);
  }
  
  public static final class Builder
  {
    private List<PendingResult<?>> DB = new ArrayList();
    private Looper DC;
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.DC = paramGoogleApiClient.getLooper();
    }
    
    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.DB.size());
      this.DB.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public Batch build()
    {
      return new Batch(this.DB, this.DC, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/api/Batch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */