package com.jiubang.core.c;

import android.os.Message;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class d
  extends FutureTask
{
  d(a parama, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected void done()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = get();
      localObject1 = localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.w("WeatherAsyncTask", localInterruptedException);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localExecutionException.getCause());
    }
    catch (CancellationException localCancellationException)
    {
      a.d().obtainMessage(3, new f(this.a, (Object[])null)).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localThrowable);
    }
    a.d().obtainMessage(1, new f(this.a, new Object[] { localObject1 })).sendToTarget();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */