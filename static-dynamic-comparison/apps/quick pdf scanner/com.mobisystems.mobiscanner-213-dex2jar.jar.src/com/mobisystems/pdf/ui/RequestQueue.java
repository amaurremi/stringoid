package com.mobisystems.pdf.ui;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

public class RequestQueue
{
  protected static Handler _requestHandler;
  protected static HandlerThread _requestThread = new HandlerThread("pdf.rquest.thread", -4);
  protected static Handler _responseHandler = new Handler();
  
  public static void post(Request paramRequest)
  {
    paramRequest.finished = false;
    Request.access$002(paramRequest, _responseHandler);
    if (_requestHandler == null)
    {
      _requestThread.start();
      _requestHandler = new Handler(_requestThread.getLooper());
    }
    _requestHandler.post(paramRequest);
  }
  
  public static abstract class Request
    implements Runnable
  {
    private Handler _responseHandler;
    private Throwable error;
    boolean finished = false;
    
    public abstract void onAsyncExec();
    
    public abstract void onRequestFinished(Throwable paramThrowable);
    
    public void run()
    {
      if (this.finished)
      {
        onRequestFinished(this.error);
        return;
      }
      try
      {
        onAsyncExec();
        this.finished = true;
        this._responseHandler.post(this);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.d("RequestQueue", "Exception in onAsyncExec", localThrowable);
          this.error = localThrowable;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/RequestQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */