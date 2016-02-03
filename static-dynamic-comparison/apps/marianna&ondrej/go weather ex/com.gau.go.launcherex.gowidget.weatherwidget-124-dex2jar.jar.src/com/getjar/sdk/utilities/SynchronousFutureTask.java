package com.getjar.sdk.utilities;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class SynchronousFutureTask<V>
  extends FutureTask<V>
{
  private static final ExecutorService _ExecutorService = Executors.newFixedThreadPool(1);
  
  public SynchronousFutureTask(Callable<V> paramCallable)
  {
    super(paramCallable);
  }
  
  public V get()
    throws InterruptedException, ExecutionException
  {
    _ExecutorService.execute(this);
    return (V)super.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/SynchronousFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */