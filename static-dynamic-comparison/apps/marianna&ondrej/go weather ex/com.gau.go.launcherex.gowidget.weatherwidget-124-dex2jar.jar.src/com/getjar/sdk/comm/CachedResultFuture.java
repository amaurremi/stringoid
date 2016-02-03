package com.getjar.sdk.comm;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class CachedResultFuture
  extends FutureTask<Result>
{
  private static Callable<Result> _ReturnCachedResultCallable = new Callable()
  {
    public Result call()
      throws Exception
    {
      return null;
    }
  };
  private Result _cachedResult = null;
  
  protected CachedResultFuture(Result paramResult)
  {
    super(_ReturnCachedResultCallable);
    if (paramResult == null) {
      throw new IllegalArgumentException("'cachedResult' can not be NULL");
    }
    this._cachedResult = paramResult;
  }
  
  public Result get()
  {
    return this._cachedResult;
  }
  
  public Result get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this._cachedResult;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
  
  public void run() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/CachedResultFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */