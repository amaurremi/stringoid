package com.adfonic.android.api;

import android.content.Context;
import android.os.Handler;
import com.adfonic.android.api.request.AndroidRequest;
import com.adfonic.android.api.request.AndroidSystemRequestAdapter;
import com.adfonic.android.utils.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestExecutor
{
  private ExecutorService executor = Executors.newSingleThreadExecutor();
  
  public RequestExecutor(Context paramContext) {}
  
  public void close()
  {
    try
    {
      this.executor.shutdownNow();
      return;
    }
    catch (Exception localException)
    {
      Log.e("Issue shutting down the executor", localException);
    }
  }
  
  public void execute(Context paramContext, Request paramRequest, ExecutorCallback paramExecutorCallback, Handler paramHandler)
  {
    if (paramRequest == null)
    {
      Log.w("Can't execute a null request");
      return;
    }
    if ((this.executor == null) || (this.executor.isShutdown())) {
      this.executor = Executors.newSingleThreadExecutor();
    }
    paramRequest = new AndroidRequest(paramRequest);
    getSystemRequestAdapter().prepareStandardRequest(paramRequest, paramContext);
    paramContext = new RequestRunnable(paramRequest, paramExecutorCallback, paramHandler);
    this.executor.execute(paramContext);
  }
  
  protected AndroidSystemRequestAdapter getSystemRequestAdapter()
  {
    return new AndroidSystemRequestAdapter();
  }
  
  public void shutdown()
  {
    if (this.executor != null) {
      this.executor.shutdownNow();
    }
  }
  
  public void start()
  {
    if ((this.executor == null) || (this.executor.isShutdown())) {
      this.executor = Executors.newSingleThreadExecutor();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/RequestExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */