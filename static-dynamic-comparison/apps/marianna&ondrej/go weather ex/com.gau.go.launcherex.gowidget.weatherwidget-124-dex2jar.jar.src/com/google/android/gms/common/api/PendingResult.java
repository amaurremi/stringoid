package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract interface PendingResult<R extends Result>
{
  public abstract void a(a parama);
  
  public abstract R await();
  
  public abstract R await(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void cancel();
  
  public abstract boolean isCanceled();
  
  public abstract void setResultCallback(ResultCallback<R> paramResultCallback);
  
  public abstract void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit);
  
  public static abstract interface a
  {
    public abstract void l(Status paramStatus);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/common/api/PendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */