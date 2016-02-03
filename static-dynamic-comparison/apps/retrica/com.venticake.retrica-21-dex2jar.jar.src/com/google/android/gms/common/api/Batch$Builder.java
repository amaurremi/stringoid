package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public final class Batch$Builder
{
  private List<PendingResult<?>> DE = new ArrayList();
  private Looper DF;
  
  public Batch$Builder(GoogleApiClient paramGoogleApiClient)
  {
    this.DF = paramGoogleApiClient.getLooper();
  }
  
  public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
  {
    BatchResultToken localBatchResultToken = new BatchResultToken(this.DE.size());
    this.DE.add(paramPendingResult);
    return localBatchResultToken;
  }
  
  public Batch build()
  {
    return new Batch(this.DE, this.DF, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/Batch$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */