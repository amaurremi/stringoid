package com.getjar.sdk.utilities;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SetExceptionFutureTask<V>
  extends FutureTask<V>
{
  public SetExceptionFutureTask(Callable<V> paramCallable)
  {
    super(paramCallable);
  }
  
  public void run()
  {
    try
    {
      super.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      setException(localThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/SetExceptionFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */